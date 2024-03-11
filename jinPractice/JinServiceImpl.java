package jinPractice;

import common.AbstractService;
import enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JinServiceImpl extends AbstractService implements JinService {

    private static JinServiceImpl instance = new JinServiceImpl();

    private JinRepository jinRepository;

    public JinServiceImpl() {
        this.jinRepository = JinRepository.getInstance();
    }

    public static JinServiceImpl getInstance() {
        return instance;
    }

    public List<?> findJin() {
        return findJin();
    }

    @Override
    public Messenger save(Object o) {
        return null;
    }

    @Override
    public List findAll() throws SQLException {
        return null;
    }

    @Override
    public Optional findById(long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String delete(Object o) {
        return null;
    }

    @Override
    public String deleteAll() {
        return null;
    }

    @Override
    public Boolean existsById(long id) {
        return null;
    }
}
