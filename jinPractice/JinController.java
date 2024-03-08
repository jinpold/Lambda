package jinPractice;

import java.sql.SQLException;
import java.util.List;

public class JinController {

    private JinServiceImpl jinService;

    public JinController() {
        this.jinService =  JinServiceImpl.getInstance();
    }

    public List<?> findJin() throws SQLException {
        return jinService.findJin();
    }
}
