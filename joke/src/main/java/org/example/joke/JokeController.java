package org.example.joke;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/jokes")
public class JokeController {

    private static final Random RANDOM = new Random();

    private static final List<String> JOKES = List.of(
            "Why did the Java developer wear glasses? Because they couldn’t C#.",
            "What's a programmer's favorite hangout place? The Foo Bar.",
            "There are only 10 types of people in the world: those who understand binary and those who don’t.",
            "I told my computer I needed a break, and it said: 'No problem, I’ll go to sleep.'",
            "Why do programmers prefer dark mode? Because light attracts bugs."

    );

    @GetMapping("/random")
    public String getRandomJoke() {
        return JOKES.get(RANDOM.nextInt(JOKES.size()));
    }


}
