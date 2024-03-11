package jinPractice;

import java.util.List;

public class JinController {

    JinServiceImpl jinService;

    public JinController() {
        this.jinService = new JinServiceImpl();
    }

    public List<?> findJin() {
        return jinService.findJin();
    }
}
