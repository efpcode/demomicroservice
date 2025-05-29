package org.example.quote;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/quotes")
public class QouteController {

    private static final Random RANDOM = new Random();

    List<String> quotes = List.of(
            "Do not go where the path may lead, go instead where there is no path and leave a trail. — Ralph Waldo Emerson",
            "The only way to do great work is to love what you do. — Steve Jobs",
            "Success is not final, failure is not fatal: It is the courage to continue that counts. — Winston Churchill",
            "In the middle of every difficulty lies opportunity. — Albert Einstein",
            "You miss 100% of the shots you don't take. — Wayne Gretzky"
    );


    @GetMapping("/random")
    public String random() {
        return quotes.get(RANDOM.nextInt(quotes.size()));
    }




}
