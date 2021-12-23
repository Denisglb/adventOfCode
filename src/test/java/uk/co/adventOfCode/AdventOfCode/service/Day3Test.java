package uk.co.adventOfCode.AdventOfCode.service;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class Day3Test {


    @Test
    void testDate() throws IOException {
        Day3 day3 = new Day3();
        assertThat(day3.powerConsumption("day3/testData")).isEqualTo(198);
    }

    @Test
    void actualData() throws IOException {
        Day3 day3 = new Day3();

        assertThat(day3.powerConsumption("day3/coreData")).isEqualTo(4118544);
    }

    @Test
    void lifeSupportRatingTestData() throws IOException {

        Day3 day3 = new Day3();
        assertThat(day3.lifeSupportRating("day3/testData")).isEqualTo(230);
    }

    @Test
    void lifeSupportRatingCoreData() throws IOException {

        Day3 day3 = new Day3();
        assertThat(day3.lifeSupportRating("day3/coreData")).isEqualTo(3832770);
    }
}