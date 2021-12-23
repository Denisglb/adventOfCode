package uk.co.adventOfCode.AdventOfCode.service;

import org.springframework.stereotype.Service;
import java.io.IOException;
import static uk.co.adventOfCode.AdventOfCode.service.helper.AccessData.readData;

@Service
public class Day2 {

    public static int depth;
    public static int horizontal;
    public static int aim;

    private void submarineInput(String direction, int value) {

        if (direction.equals("forward")) {
            horizontal = horizontal + value;
            depth = depth + (aim * value);
        }

        if (direction.equals("up")) {
//            depth = depth - value;
            aim = aim - value;
        }

        if (direction.equals("down")) {
//            depth = depth + value;
            aim = aim + value;
        }
    }

    public int getData(String path) throws IOException {
        String[] data = readData(path);
        for (int i = 0; i < data.length; i++) {
            String[] dataToProcess = data[i].split(" ");
            submarineInput(dataToProcess[0], Integer.parseInt(dataToProcess[1]));
        }
        return depth * horizontal;
    }
}
