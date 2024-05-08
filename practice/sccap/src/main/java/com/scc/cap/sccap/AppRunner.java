package com.scc.cap.sccap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AppRunner implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(AppRunner.class);

    @Override
    public void run(String... args) throws Exception {
        var GOOGLE_SEARCH_URL = "http://www.google.com/search";

        System.out.println("Enter word!");
        Scanner scanner = new Scanner(System.in);
        String searchTerm = scanner.nextLine();
        String url = "http://www.google.com/search?q=" + searchTerm;

       // String searchURL = GOOGLE_SEARCH_URL + "?q="+searchTerm+"&num="+10;
        Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").get();
        logger.info(doc.title());
        Elements newsHeadlines = doc.select("#mp-itn b a");
        for (Element headline : newsHeadlines) {
            logger.info("a: {} b: {}",
                    headline.attr("title"), headline.absUrl("href"));
        }

        ///System.out.println(line);
    }
}
