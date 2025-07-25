package com.korit.authstudy.security.filter;

import com.korit.authstudy.domain.entity.User;
import com.korit.authstudy.repository.UsersRepository;
import com.korit.authstudy.security.jwt.JwtUtil;
import com.korit.authstudy.security.model.PrincipalUser;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter implements Filter {

    private final JwtUtil jwtUtil;
    private final UsersRepository usersRepository;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("JWT AccessToken 검사");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 해당 메소드가 아니면 그냥 다음 필터로 넘김.
        List<String> methods = List.of("POST", "GET", "PUT", "PATCH", "DELETE");
        if (!methods.contains(request.getMethod())) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String authorization = request.getHeader("Authorization");
        System.out.println("Brearer 토큰: " + authorization);
        if (jwtUtil.isBearer(authorization)) {
            String accessToken = jwtUtil.removeBearer(authorization);
    try {
        Claims claims = jwtUtil.getClaims(accessToken);
        String id = claims.getId();
        Integer userId = Integer.parseInt(id);
        Optional<User> foundUserOptional = usersRepository.findById(userId);
        foundUserOptional.ifPresentOrElse((user) -> {
            // UserEntity를 Security에서 인증객체로 사용할 PrincipalUser로 변환
            PrincipalUser principalUser = PrincipalUser.builder()
                    .userId(user.getId())
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .fullName(user.getFullName())
                    .email(user.getEmail())
                    .build();                                                                           // getAuthorities() 는 사용자의 권한 목록을 담은 컬렉션(Collection)을 반환
            Authentication authentication = new UsernamePasswordAuthenticationToken(principalUser, "", principalUser.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);                       // 토큰 정보를
            System.out.println("인증 성공");
            System.out.println(authentication.getName());
        }, () -> {
            throw new AuthenticationServiceException("인증 실패");
        });
    } catch (RuntimeException e) {
        e.printStackTrace();
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
