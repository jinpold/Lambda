package user;

public class UserRepository {

    UserService userService;

    public UserRepository() {
        this.userService = UserServiceImpl.getInstance();
    }
}
