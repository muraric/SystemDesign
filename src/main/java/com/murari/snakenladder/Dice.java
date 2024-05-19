package com.murari.snakenladder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Dice {
    private int maxCount;
    private int minCount;

    public int rollDice() {
        return (int) ((Math.random() * (maxCount - minCount)) + minCount);
    }
}
