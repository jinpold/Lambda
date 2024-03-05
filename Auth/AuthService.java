package Auth;


import user.User;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public interface AuthService {

    String addUsers();

    String join(Scanner sc);

    String login();

    User findUser(String username);

    String updatePassword(User user);
    String deleteUser(String username);

    List<?> getUserList();
    List<?> findUsersByName(String name);
    List<?> findUsersByJob(String job);

    String count();
    Map<String, User> getUserMap();

}
