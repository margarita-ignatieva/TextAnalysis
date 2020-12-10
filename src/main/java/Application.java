import by.intexsoft.text.CountWords;
import by.intexsoft.text.FileOperation;
import by.intexsoft.text.SplitToWords;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String... args){
        List<String> list = new ArrayList<>();
        list.add("boo");
        list.add("bee");
        list.add("boo");
        list.add("bor");
        list.add("bor");
        list.add("bor");
        System.out.println(CountWords.convertToMap(list));
        final String path = "D:\\by_intexSoft\\TextAnalysis\\src\\main\\resources\\testText";
        final String outputPath = "D:\\by_intexSoft\\TextAnalysis\\src\\main\\resources\\outputFile";
        String rawText = FileOperation.readFile(path);
        List<String> formatedText = SplitToWords.formatWordsFromText(rawText);
        Map<String, Long> formatedTextMap = CountWords.convertToMap(formatedText);
        FileOperation.writeToFile(formatedTextMap, outputPath);
    }
}
