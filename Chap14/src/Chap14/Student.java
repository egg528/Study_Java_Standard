package Chap14;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
public class Student {
    String name;
    boolean isMale;
    int hak;
    int ban;
    int score;

    enum LEVEL {HIGH, MID, LOW};

}
