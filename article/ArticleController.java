package article;

import java.sql.SQLException;
import java.util.List;

public class ArticleController {

    ArticleServiceImpl service;

    public ArticleController() {
        this.service = ArticleServiceImpl.getInstnace();
    }

    public List<?> findArticles() throws SQLException {
        return service.findArticles();
    }
}
