package uk.co.adventOfCode.AdventOfCode.service;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class Day1Test {
    String EXPECTED_DATA = "199\n" +
            "200\n" +
            "208\n" +
            "210\n" +
            "200\n" +
            "207\n" +
            "240\n" +
            "269\n" +
            "260\n" +
            "263\n";

    String[] EXEPCTED_ARRAY = new String[]{"199", "200", "208", "210", "200", "207", "240", "269", "260", "263"};

    @Test
    void readFromFile() throws IOException {
        
        Path path = new ClassPathResource("/day1/inputDataTest").getFile().toPath();
        String data = new String(Files.readAllBytes(path));

        assertThat(data).isEqualTo(EXPECTED_DATA);
        String[] arrayList = data.split("\n");

        assertThat(arrayList).isEqualTo(EXEPCTED_ARRAY);
    }

    @Test
    void shouldProcessData() throws IOException {
        Day1 day1 = new Day1();

        assertThat(day1.process("/day1/inputDataTest")).isEqualTo(7);

    }

    @Test
    void shouldProcessData3way() throws IOException {
        Day1 day1 = new Day1();
        assertThat(day1.process3way("/day1/inputData")).isEqualTo(1491);
    }
}