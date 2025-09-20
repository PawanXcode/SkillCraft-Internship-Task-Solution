import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class ProductScraper {

    public static void main(String[] args) {
        String url = "https://www.flipkart.com/search?q=smartphone"; // Example search
        String csvFile = "products.csv";

        try {
            // Connect to the page
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0")
                    .timeout(10000)
                    .get();

            // Open CSV writer
            FileWriter writer = new FileWriter(csvFile);
            writer.append("Name,Price,Rating\n");

            // Select product containers
            Elements products = doc.select("div._1AtVbE");

            for (Element product : products) {
                String name = product.select("a.IRpwTa").text();
                if (name.isEmpty()) {
                    name = product.select("div._4rR01T").text(); // fallback selector
                }

                String price = product.select("div._30jeq3").text();
                String rating = product.select("div._3LWZlK").text();

                if (!name.isEmpty() && !price.isEmpty()) {
                    writer.append(name.replace(",", " ")) // avoid CSV breaking
                          .append(",")
                          .append(price)
                          .append(",")
                          .append(rating.isEmpty() ? "N/A" : rating)
                          .append("\n");
                }
            }

            writer.flush();
            writer.close();
            System.out.println("Data saved in " + csvFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
