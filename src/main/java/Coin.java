package main.java;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Coin {
    private String coinType;
    private int cpValue;
    private int spValue;
    private int epValue;
    private int gpValue;
    private int ppValue;
}
