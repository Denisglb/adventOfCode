package uk.co.adventOfCode.AdventOfCode.service.helper;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AccessData {

    public static String[] readData(String pathName) throws IOException {
        Path path = new ClassPathResource(pathName).getFile().toPath();
        String data = new String(Files.readAllBytes(path));
        return data.split("\n");
    }


    public static String[] readDataDay4(String pathName) throws IOException {
        Path path = new ClassPathResource(pathName).getFile().toPath();
        String data = new String(Files.readAllBytes(path));
        return data.split("\n");
    }
    
    
}
