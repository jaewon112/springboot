//package com.korit.authstudy.init;
//
//import com.korit.authstudy.domain.entity.User;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.function.Consumer;
//
//@RequiredArgsConstructor
//class OptionalStudy<T> {
//
//    private final T present;
//
//    public void ifPresentOfElse(Consumer<T> action, Runnable runnable) {
//        if (present == null) {
//            action.accept(present);
//        } else {
//            runnable.run();
//        }
//    }
//}
//
//@Component
//public class Lambda implements CommandLineRunner {
//
//    @Override
//    public void run(String... args) throws Exception {
//        User user = User.builder()
//                .id(100)
//                .username("test")
//                .password("1234")
//                .build();
//        OptionalStudy<User> optionalStudy = new OptionalStudy<>(user);
//        Consumer<User> consumer = new Consumer<User>() {
//            @Override
//            public void accept(User user) {
//                System.out.println("user객체 찾음" + user);
//            }
//        };
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("user 객체 못찾아서 여기서 다른 작업해줄거임");
//            }
//        };
//        optionalStudy.ifPresentOfElse(consumer,runnable);
//
//        Consumer<User> consumerLambda = (u) -> System.out.println("user객체 찾음" + user);
//
//        Runnable runnableLambda = () -> System.out.println("user 객체 못찾아서 여기서 다른 작업해줄거임");
//
//        optionalStudy.ifPresentOfElse(consumerLambda,runnableLambda);
//
//        optionalStudy.ifPresentOfElse(
//                (u) -> {
//            System.out.println("user객체 찾음" + user);
//        },
//                () -> {
//            System.out.println("user 객체 못찾아서 여기서 다른 작업해줄거임");
//        });
//
//    }
//}
