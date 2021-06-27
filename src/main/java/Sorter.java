import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeMap;

public class Sorter implements SortedMap, Top{
    private final List<String> words;

    private final Map<String, Status> wordsCounts = new HashMap<>();

    public Sorter(final List<String> words) {
        if (words.size() < 2) {
            throw new IllegalArgumentException("You sent one or zero words");
        }
        this.words = words;
    }

    private void makeTop() {
        for (String word : words) {
            if (wordsCounts.containsKey(word)) {
                wordsCounts.put(word, wordsCounts.get(word).increment());
            } else {
                wordsCounts.put(word, new Status());
            }
        }
    }

    public TreeMap<String, Status> getSortedMap() {
        makeTop();

        TreeMap<String, Status> sortedWordCounts = new TreeMap<>(new ValueComparator(wordsCounts));
        sortedWordCounts.putAll(wordsCounts);

        return sortedWordCounts;
    }

    public NavigableSet<String> getTop() {
        makeTop();

        TreeMap<String, Status> sortedWordCounts = new TreeMap<>(new ValueComparator(wordsCounts));
        sortedWordCounts.putAll(wordsCounts);

        return sortedWordCounts.descendingKeySet();
    }
}

class ValueComparator implements Comparator<String> {
    private final Map<String, Status> map;

    public ValueComparator(Map<String, Status> map) {
        this.map = map;
    }

    @Override
    public int compare(String s1, String s2) {
        if (map.get(s1).getCounter() >= map.get(s2).getCounter()) {
            return -1;
        } else {
            return 1;
        }
    }
}
