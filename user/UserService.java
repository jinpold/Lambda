package user;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public interface UserService {

    String test();
    String addUsers();
    String count();
    Map<String, ?> getUserMap();
    String login(User user);
    String updatePassword(User user);
    List<?> findUsersByName(String name);
    List<?> findUsersByJob(String job);
    Map<String, ?> findUsersByJobFromMap(String job);
    Map<String, ?> findUsersByNameFromMap(String name);
    List<?> findUsers () throws SQLException;
    String createTable () throws SQLException;
    String deleteTable () throws SQLException;
    String insertData(User user) throws SQLException;

}

