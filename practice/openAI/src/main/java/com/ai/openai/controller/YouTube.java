package com.ai.openai.controller;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/youtube")
public class YouTube {

    private final ChatClient chatClient;

    private Resource ytPromptResource;

    public YouTube(ChatClient chatClient, @Value("classpath:/prompts/youtube.st") Resource ytPromptResource) {
        this.chatClient = chatClient;
        this.ytPromptResource = ytPromptResource;
    }

    @GetMapping("/popular")
    public String findPopularYouTubersByGenre(@RequestParam(value = "genre", defaultValue = "tech") String genre) {
        PromptTemplate promptTemplate = new PromptTemplate(ytPromptResource);
        Prompt prompt = promptTemplate.create(Map.of("genre", genre));
        var result = chatClient.call(prompt).getResult().getOutput().getContent();
        return result;
    }

    @GetMapping("/popular/president")
    public String findTheMostPopularPresident(@RequestParam(value = "country", defaultValue = "USA") String country) {
        String message = """
                List 10 of the most popular presidents in {country}. If you
                don't know the answer , just say "I don't know".
                """;
        PromptTemplate promptTemplate = new PromptTemplate(message);
        Prompt prompt = promptTemplate.create(Map.of("country", country));
        var result = chatClient.call(prompt).getResult().getOutput().getContent();
        return result;

    }


}
