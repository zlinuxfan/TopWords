import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class SorterTest {
    private final List<String> words = Arrays.asList(
        "word1", "word1", "word7", "word4", "word7", "word5", "word5", "word7");

    @org.junit.jupiter.api.Test
    void getTop() {
        Sorter sorter = new Sorter(words);
        String[] expected  = {"word4", "word1", "word5", "word7"};

        assertArrayEquals( expected, sorter.getTop().toArray(new String[0]));
    }

    @Test
    void getSortedMap() {
        Sorter sorter = new Sorter(words);
        Map<String, Status> expected = new HashMap<>();
        expected.put("word7", new Status().increment().increment());
        expected.put("word5", new Status().increment());
        expected.put("word1", new Status().increment());
        expected.put("word4", new Status());

        for (Map.Entry<String, Status> entry : sorter.getSortedMap().entrySet()) {
            assertEquals(entry.getValue(), expected.get(entry.getKey()));
        }
    }

    private boolean areEqual(Map<String, Status> first, Map<String, Status> second) {
        if (first.size() != second.size()) {
            return false;
        }

        return first.entrySet().stream()
            .allMatch(e -> e.getValue().equals(second.get(e.getKey())));
    }

}
