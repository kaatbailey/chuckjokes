package com.kaat.chuckjokes;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class ChuckNorrisController {

    private final List<ChuckNorrisJoke> jokes;

    public ChuckNorrisController() {
        jokes = new ArrayList<>();
        try {
            ClassPathResource resource = new ClassPathResource("chucknorrisjokes.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                jokes.add(new ChuckNorrisJoke(line));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/joke")
    public ChuckNorrisJoke getRandomJoke() {
        Random random = new Random();
        int index = random.nextInt(jokes.size());
        return jokes.get(index);
    }
}

class ChuckNorrisJoke {
    private final String joke;

    public ChuckNorrisJoke(String joke) {
        this.joke = joke;
    }

    public String getJoke() {
        return joke;
    }
}
