package uk.co.adventOfCode.AdventOfCode.service;

import org.yaml.snakeyaml.util.ArrayUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Day4 {

    private static List<String> choices = new ArrayList<>();
    private static List<List<String>> gameBoard = new ArrayList<>();

    public int bingo() {
        getData();
        
        return 1;

    }
    
    private void getData() {
        List<String> boardLine = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("/Users/e1206373/Desktop/AdventOfCode/src/test/resources/day4/testData"))) {
            choices.addAll(Arrays.asList(br.readLine().split(",")));
            while (br.readLine() != null) {
                for (int i = 0; i < 5; i++) {
                    boardLine.add(br.readLine());
                }
                gameBoard.add(boardLine);
                boardLine = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(choices);
        System.out.println(gameBoard);
//        List<Integer> collect = gameBoard.get(0).stream().map(Integer::parseInt).collect(Collectors.toList());
        Integer[] collect2 = Arrays.asList(gameBoard.get(0).get(0).split(" ")).stream().filter(x -> x == "").toArray(Integer[]::new);
//        ArrayUtils.remove(array, index)
//                .stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
    }
}
