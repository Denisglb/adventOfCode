package uk.co.adventOfCode.AdventOfCode.service;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day4Test {

//    int[] choices = new int[]{7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1};
//    int[][] board = new int[][] {};

    List<String> choices = new ArrayList<>();
    List<List<String>> gameBoard = new ArrayList<List<String>>();

//    board 1 = [
//    [1,2,3,4]
//    [5,6,7,8]
//    ]


    @Test
    void test1() {
        Day4 day4 = new Day4();
        
        assertThat(day4.bingo()).isEqualTo(4512);
    }


}