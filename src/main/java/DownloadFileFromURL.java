import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.jsoup.Jsoup;

public class DownloadFileFromURL {

    public static List<String> parseString(Properties properties) throws IOException {
        List<String> words = new LinkedList<>();

        try (Scanner in = new Scanner(new URL(properties.getProperty("url")).openStream(),
            StandardCharsets.UTF_8.toString())) {
            in.useDelimiter("\\A");
            String line;

            while (in.hasNextLine()) {
                line = Jsoup.parse(in.nextLine()).text().toLowerCase(Locale.ROOT);
                words.addAll(Arrays.stream(line.split("\\s+"))
                    .filter(w -> w.length() >= Integer.parseInt(properties.getProperty("minCharsOfCount")))
                    .collect(Collectors.toList()));
            }

            return words;
        }
    }
}

