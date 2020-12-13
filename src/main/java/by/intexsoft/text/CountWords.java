package by.intexsoft.text;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountWords {
    public static Map<String, Long>  convertToMap(List<String> textList) {
        final Map<String, Long> textMap = new HashMap<>();
        textList.stream()
                .forEach(x -> {
            if (textMap.containsKey(x)) {
                long tempNum = textMap.get(x);
                textMap.put(x, ++tempNum);
            } else {
                textMap.put(x, 1L);
            }
        });

        return textMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
    }
}
