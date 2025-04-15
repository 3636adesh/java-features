import java.util.List;
import java.util.Locale;
import java.util.stream.Gatherer;

/**
 * <a href="https://www.youtube.com/watch?v=oVdWfU_IObY&t=1s">Gatherer</a>
 */

public class A_MapFilter {

    public static void main(String[] args) {

        var strings = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

//        Gatherer< String, ?, String> gatherer = ()-> (state, element, downstream)->true;
        Gatherer<String, ?, String> mappingGatherer = Gatherer.of(
                (_, element, downstream) -> {
                    downstream.push(element.toUpperCase());
                    return true;
                }
        );
        Gatherer<String, ?, String> filteringGatherer = Gatherer.of(
                (_, element, downstream) -> {
                    if (element.length() > 3) {
                        return downstream.push(element);
                    }
                    return true;
                }
        );
        var result = strings.stream()
//                .map(String::toLowerCase)   // upstream
                .gather(filteringGatherer)
                .toList();
        System.out.println("result = " + result);
    }
}
