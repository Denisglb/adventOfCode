package uk.co.adventOfCode.AdventOfCode.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import uk.co.adventOfCode.AdventOfCode.service.helper.AccessData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Day3 {

    private String gammaRate = "";
    private String epsilonRate = "";

    public int powerConsumption(String path) throws IOException {
        String[] data = AccessData.readData(path);

        String[][] allValuesMapped = new String[data.length][];
        for (int i = 0; i < data.length; i++) {
            allValuesMapped[i] = data[i].split("");
        }

        List<String> eachColumnElements = new ArrayList<>();
        for (int i = 0; i < allValuesMapped[0].length; i++) {
            int finalI = i;

            String list = Arrays.stream(allValuesMapped).map(x -> x[finalI]).collect(Collectors.joining(","));
            eachColumnElements.add(list);
        }

        for (int i = 0; i < eachColumnElements.size(); i++) {
            int count1 = StringUtils.countOccurrencesOf(eachColumnElements.get(i), "0");
            int count2 = StringUtils.countOccurrencesOf(eachColumnElements.get(i), "1");


            if (count1 > count2) {
                if (gammaRate == null) {
                    gammaRate = "0";
                    epsilonRate = "1";
                } else {
                    gammaRate = gammaRate + "0";
                    epsilonRate = epsilonRate + "1";
                }
            } else {
                if (gammaRate == null) {
                    gammaRate = "1";
                    epsilonRate = "0";
                } else {
                    gammaRate = gammaRate + "1";
                    epsilonRate = epsilonRate + "0";
                }
            }

        }
        int gammaDecimal = Integer.parseInt(gammaRate, 2);
        int epsilonRateDecimal = Integer.parseInt(epsilonRate, 2);

        return gammaDecimal * epsilonRateDecimal;
    }


    public int lifeSupportRating(String path) throws IOException {
        String[] data = AccessData.readData(path);
        List<String> listForOxygenGenerator = new ArrayList<>(Arrays.asList(data));
        List<String> listForCo2 = new ArrayList<>(Arrays.asList(data));

        updateListForOxygen(listForOxygenGenerator);
        updateListForCo2(listForCo2);

        int oxygenDecimal = Integer.parseInt(listForOxygenGenerator.get(0), 2);
        int c02Decimal = Integer.parseInt(listForCo2.get(0), 2);
        return oxygenDecimal * c02Decimal;
    }

    private void updateListForOxygen(List<String> providedList) {
        int i = 0;
        
        while (1 < providedList.size()) {
                int finalI = i;
                List<String> one = providedList.stream().filter(x ->
                        '1' == (x.charAt(finalI)))
                        .collect(Collectors.toList());

                List<String> zero = providedList.stream().filter(x ->
                        '0' == (x.charAt(finalI)))
                        .collect(Collectors.toList());

                if (one.size() >= zero.size()) {
                    providedList.removeAll(zero);
                } else {
                    providedList.removeAll(one);
                }
                i++;
            }
//        }
    }

    private void updateListForCo2(List<String> providedList) {
        int i = 0;
        while (1 < providedList.size()) {
            int finalI = i;
            List<String> one = providedList.stream()
                    .filter(x -> '1' == (x.charAt(finalI)))
                    .collect(Collectors.toList());

            List<String> zero = providedList.stream()
                    .filter(x -> '0' == (x.charAt(finalI)))
                    .collect(Collectors.toList());

            if (one.size() >= zero.size()) {
                providedList.removeAll(one);
            } else {
                providedList.removeAll(zero);
            }
            i++;
        }
    }
    
//    else if (one.size() >= zero.size() && !o2) {
//                listForOxygenGenerator.removeAll(one);
//            } else if (one.size() < zero.size() && !o2){
//                listForOxygenGenerator.removeAll(zero);
//            }
}
