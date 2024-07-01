package com.ai.openai.controller;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.parser.ListOutputParser;
import org.springframework.ai.parser.OutputParser;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SongsController {

    private ChatClient chatClient;

    public SongsController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/songs")
    public List<String> getSongsByArtist(@RequestParam(value = "artist", defaultValue = "Roland Kaiser") String artist) {
        ListOutputParser outputParser = new ListOutputParser(new DefaultConversionService());
        var message = """
                Please give me the a list of top 10 songs for the artist {artist} . If you don't know the 
                answer just say. I am sorry, I don't listen to music. Here is the format {format}
                """;
        PromptTemplate promptTemplate = new PromptTemplate(message, Map.of("artist", artist,
                "format", outputParser.getFormat()
        ));
        Prompt prompt = promptTemplate.create();
        ChatResponse response = chatClient.call(prompt);
        return outputParser.parse(response.getResult().getOutput().getContent());
    }

//    @GetMapping("/songs")
//    public String getSongsByArtist(@RequestParam(value = "artist", defaultValue = "Roland Kaiser") String artist) {
//        var message = """
//                Please give me the a list of top 10 songs for the artist {artist} . If you don't know the
//                answer just say. I am sorry, I don't listen to music
//                """;
//        PromptTemplate promptTemplate = new PromptTemplate(message,Map.of("artist", artist));
//        Prompt prompt = promptTemplate.create();
//        ChatResponse response = chatClient.call(prompt);
//        return response.getResult().getOutput().getContent();
//    }


}
