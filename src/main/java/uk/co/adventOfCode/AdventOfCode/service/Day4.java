package uk.co.adventOfCode.AdventOfCode.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day4 {

    private static List<String> choices = new ArrayList<>();
    private static List<List<List<String>>> gameBoard = new ArrayList<>();
    private static int winningNumber;

    public int bingo() {
        int value1 = 0;
        getData();
        int winningBoardNumber = getWinningBoard();
        List<List<String>> winningBoard = gameBoard.get(winningBoardNumber);
        for (int i = 0; i < winningBoard.size(); i++) {
            value1 += Arrays.stream(winningBoard.get(i).stream().filter(x -> !x.equals("X")).mapToInt(x -> Integer.parseInt(x)).toArray()).sum();
        }
        return value1 * winningNumber;

    }

    private int getWinningBoard() {
        for (int i = 0; i < choices.size(); i++) {
            for (int j = 0; j < gameBoard.size(); j++) {
                List<List<String>> game = gameBoard.get(j);
                for (int k = 0; k < game.size(); k++) {
                    if (game.get(k).contains(choices.get(i))) {
                        game.get(k).set(game.get(k).indexOf(choices.get(i)), "X");
                        if (5 == game.get(k).stream().filter(x -> x.equals("X")).count() || getColoumnValues(gameBoard.get(j))) {
                            winningNumber = Integer.parseInt(choices.get(i));
                            return j;
                        }
                    }
                }

            }
        }
        System.out.println(gameBoard);
        return 0;
    }

    private boolean getColoumnValues(List<List<String>> currentBoard) {
        for (int i = 0; i < currentBoard.size(); i++) {
            int xCount = 0;
            for (int j = 0; j < currentBoard.get(0).size(); j++) {
                if ("X" == currentBoard.get(j).get(i)) {
                    xCount++;
                    if (xCount == 5) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void getData() {
        List<List<String>> boardLine = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("/Users/e1206373/Desktop/AdventOfCode/src/test/resources/day4/testData2"))) {
            choices.addAll(Arrays.asList(br.readLine().split(",")));
            while (br.readLine() != null) {
                for (int i = 0; i < 5; i++) {
                    boardLine.add(Arrays.asList(br.readLine().trim().split("\\s+")));
                }
                gameBoard.add(boardLine);
                boardLine = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(choices);
        System.out.println(gameBoard);
    }
}
