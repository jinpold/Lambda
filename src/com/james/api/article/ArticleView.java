package com.james.api.article;

import com.james.api.enums.ArticleRouter;

import java.sql.SQLException;
import java.util.*;

public class ArticleView {

    public static void main(Scanner sc) throws SQLException {

        ArticleController ctrl = new ArticleController();
        ArticleRouter.munu(sc);
    }
}


