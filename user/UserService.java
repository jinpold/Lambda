package user;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public interface UserService {

    String addUsers();
    String count();
    Map<String, ?> getUserMap();
    String login(User user);
    String updatePassword(User user);
    List<?> findUsersByName(String name);
    List<?> findUsersByJob(String job);
    Map<String, ?> findUsersByJobFromMap(String job);
    Map<String, ?> findUsersByNameFromMap(String name);

}

