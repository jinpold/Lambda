package board;
import common.UtilService;
import common.UtilServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardView {

    public static void main(Scanner sc) {
        List<Board> articles = new ArrayList<>();
        UtilService util = UtilServiceImpl.getInstance();
        Board article = Board.builder()
                .boardname(util.createRandomTitle())
                .boardType(util.createRandomContent())
                .build();

        for(int i=0; i<5; i++) {
            articles.add(Board.builder()
                    .boardname(util.createRandomTitle())
                    .boardType(util.createRandomContent())
                    .build());
        }
//        for(BoardDto articles2 : articles) { 향상된 for문
//            System.out.println(articles2.toString());
//        }
        articles.forEach(i-> {
            System.out.println(i.toString());
        });
    }
}
