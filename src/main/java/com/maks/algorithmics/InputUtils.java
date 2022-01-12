package com.maks.algorithmics;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class InputUtils {

    public static List<Integer> readListOfIntegersFromLineOrNull(BufferedReader br) throws IOException {
        String line = br.readLine();
        if(line != null) {
            return Arrays.asList(line.split(" ")).stream()
                    .map(Integer::parseInt)
                    .collect(toList());
        } else {
            return null;
        }
    }

    public static Integer readIntFromLineOrNull(BufferedReader br) throws IOException {
        String line = br.readLine();
        if(line != null) {
            return Integer.parseInt(line);
        } else {
            return null;
        }
    }

}

