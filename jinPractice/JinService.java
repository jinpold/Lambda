package jinPractice;

import java.sql.SQLException;
import java.util.List;

public interface JinService {
    List<?> findJin() throws SQLException;
}
