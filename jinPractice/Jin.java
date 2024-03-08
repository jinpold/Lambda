package jinPractice;

import lombok.*;
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})

public class Jin {

        private int id;
        private String title;
        private String content;
        private String writer;


        @Builder(builderMethodName = "builder")
        public void jin (int id, String title, String content, String writer) {
            this.id = id;
            this.title = title;
            this.content = content;
            this.writer = writer;
        }
    }

