package uk.co.adventOfCode.AdventOfCode.service;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class Day2Test {

    @Test
    void Test1() throws IOException {
        Day2 day2 = new Day2();

        int expectedValue = day2.getData("day2/day2Data");

        assertThat(expectedValue).isEqualTo(2105273490);
    }

//    @Test
//    void Test2() throws IOException {
//        Day2 day2 = new Day2();
//
//        int expectedValue = day2.getData();
//
//        assertThat(expectedValue).isEqualTo(2322630);
//    }
}