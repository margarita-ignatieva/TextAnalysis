package by.intexsoft.text;

import static java.nio.charset.StandardCharsets.UTF_8;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileOperation {
    public static String readFile(String path){
        StringBuilder textLines = new StringBuilder();
        try {
            textLines.append(Files.readAllLines(Paths.get(path), UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("Input File may not exist, or path is incorrect",e);
        }
        return textLines.toString();
    }

    public static void writeToFile(Map<String, Long> inputMap, String path){
        List<String> lines = inputMap
                .entrySet()
                .stream()
                .map(entry -> new StringBuilder()
                        .append(entry.getKey())
                        .append(" : ")
                        .append(entry.getValue())
                        .toString())
                .collect(Collectors.toList());
        try {
            Files.write(Paths.get(path), lines, UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Wasn't able to write to file with path" + path, e);
        }
    }
}
