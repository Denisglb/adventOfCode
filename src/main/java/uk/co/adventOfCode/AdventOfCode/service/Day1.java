package uk.co.adventOfCode.AdventOfCode.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import uk.co.adventOfCode.AdventOfCode.service.helper.AccessData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.Integer.parseInt;

@Service
public class Day1 {
    
    public int process(String pathName) throws IOException {
        int count = 0;
        String[] strings = AccessData.readData(pathName);

        for (int i = 0; i < strings.length - 1; i++) {
            if (parseInt(strings[i]) < parseInt(strings[i + 1])) {
                ++count;
            }
        }
        return count;
    }

    public int process3way(String pathName) throws IOException {
        int count = 0;
        String[] strings = AccessData.readData(pathName);

        for (int i = 0; i < strings.length - 3; i++) {
            int sum = parseInt(strings[i]) + parseInt(strings[i+1]) + parseInt(strings[i+2]);
            int sum2 = parseInt(strings[i + 1]) + parseInt(strings[i + 2]) + parseInt(strings[i + 3]);
            
            if (sum < sum2) {
                ++count;
            }
        }
        return count;
    }
}
