import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Run {
    static final Logger log = LogManager.getLogger(Run.class.getName());
    private static final Properties properties = new Properties();

    public static void main(String[] args) {
        readProperty();

        printMap(
            new Sorter(getWords()).getSortedMap(),
            Integer.parseInt(properties.getProperty("minMeet"))
        );
    }

    private static List<String> getWords() {
        List<String> words = new LinkedList<>();

        try {
            words = DownloadFileFromURL.parseString(properties);
        } catch (IOException ioE) {
            System.out.println("Sorry. We was not load file: " + properties.getProperty("url"));
            log.error("Sorry. We was not load file: ", ioE);
            System.exit(1);
        }

        return words;
    }

    private static void readProperty() {
        try (
            InputStream input = Run.class.getClassLoader().getResourceAsStream(
                "config.properties")
        ) {
            if (input == null) {
                System.out.println(
                    "Sorry, unable to find config.properties. See folder : 'src/main/resources'.");
                System.exit(1);
            }

            properties.load(input);

        } catch (IOException ioE) {
            log.error("We can not read property file: " + ioE);
        }
    }

    private static void printMap(Map<String, Status> map, int minMeet) {
        for (Map.Entry<String, Status> entry : map.entrySet()) {
            if (entry.getValue().getCounter() > minMeet) {
                System.out.println(entry.getKey() + " ->" + entry.getValue().getCounter() + "; ");
            }
        }
    }
}