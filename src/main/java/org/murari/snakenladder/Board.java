package org.murari.snakenladder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Setter
@Getter
@AllArgsConstructor
public class Board {
    private Map<Integer,Integer> snakeMap;
    private Map<Integer, Integer> ladderMap;

}
