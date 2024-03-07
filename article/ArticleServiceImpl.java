package article;

import java.sql.SQLException;
import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    ArticleRepository articleRepository;
    private static ArticleServiceImpl instnace = new ArticleServiceImpl();
    public ArticleServiceImpl() {
        this.articleRepository = ArticleRepository.getInstance();
    }
    public static ArticleServiceImpl getInstnace() {
        return instnace;
    }
    @Override
    public List<?> findArticles() throws SQLException {
        return articleRepository.findArticles();
    }
}


