package com.study.springboot202210Lseunguk.IocAndDi;

public class Main {

    private final UserService userService;

    public Main(UserService userService) {
//      this.userService = UserService.getInstance(); // 일체형으로 결합도가 높으므로 밑의 코드를 사용해야 한다.
        this.userService = userService;
    }

    public void run() {
        userService.createUser();
        userService.getUser();
        userService.updateUser();
        userService.deleteUser();
    }

    public static void main(String[] args) {
        UserService userService = UserServiceImpl.getInstance();

        Main main = new Main(userService);
//        Di > 의존성을 주입했다 (외부에서 주입을 하는 방식)
        main.run();
    }
}
