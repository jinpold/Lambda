package jinPractice;

import java.sql.SQLException;
import java.util.List;

public class JinServiceImpl implements JinService {

    private JinRepository Repository;

    private static JinServiceImpl instance = new JinServiceImpl();

    public JinServiceImpl() {
        this.Repository = JinRepository.getInstace();
    }

    public static JinServiceImpl getInstance() {
        return instance;
    }

    @Override
    public List<?> findJin() throws SQLException {
        return Repository.findJin();
    }
}
