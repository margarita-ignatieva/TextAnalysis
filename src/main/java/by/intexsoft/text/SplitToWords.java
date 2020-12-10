package by.intexsoft.text;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitToWords {
    public static List<String> formatWordsFromText(String rawText){
        if (rawText == null || rawText.length() == 0){
            throw new RuntimeException("Text is absent");
        }
        return  Arrays.stream(rawText
                .toLowerCase()
                .replaceAll("[^a-z0-9]", ":")
                .split(":"))
                .filter(x -> x.length() > 0)
                .collect(Collectors.toList());
    }
}
