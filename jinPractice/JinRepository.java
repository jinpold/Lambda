package jinPractice;

import java.util.List;

public class JinRepository {

    private static JinRepository Instance = new JinRepository();

    public JinRepository() {

    }
    public static JinRepository getInstance() {
        return Instance;
    }

}
