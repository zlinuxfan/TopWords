import java.util.Map;


public class Run {

    public static void main(String[] args) {
        String[] words = {"word1", "word1", "word7", "word2", "word3", "word4", "word7", "word7", "word5", "word5"};
        //String[] words = {"word1"};

        Sorter sorter = new Sorter(words);
        printMap(sorter.getSortedMap());
    }

    private static void printMap(Map<String, Status> map) {
        for (Map.Entry<String, Status> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " ->" + entry.getValue().getCounter() + "; ");
        }
    }
}