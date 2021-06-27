import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Run {

    public static void main(String[] args) {
        String url = "https://github.com/zlinuxfan/card/blob/master/README.md ";
        List<String> words = new LinkedList<>();

        try {
            words = DownloadFileFromURL.parseString(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sorter sorter = new Sorter(words);
        printMap(sorter.getSortedMap(), 7);
    }

    private static void printMap(Map<String, Status> map, int minMeet) {
        for (Map.Entry<String, Status> entry : map.entrySet()) {
            if (entry.getValue().getCounter() > minMeet) {
                System.out.println(entry.getKey() + " ->" + entry.getValue().getCounter() + "; ");
            }
        }
    }
}