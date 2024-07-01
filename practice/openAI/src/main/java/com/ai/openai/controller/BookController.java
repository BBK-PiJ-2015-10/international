package com.ai.openai.controller;

import com.ai.openai.dto.Author;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.ai.parser.MapOutputParser;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

    private final ChatClient chatClient;

    public BookController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/by-author")
    public Author byAuthor(@RequestParam(value = "author", defaultValue = "Ken Kouse") String author) {
        String promptMessage = """
                Generate a list of books written by the author {author}. If you aren't positive that a book
                belongs to this author please don't include it.
                {format}
                """;
        BeanOutputParser<Author> outputParser = new BeanOutputParser<>(Author.class);
        String format = outputParser.getFormat();
        PromptTemplate template = new PromptTemplate(promptMessage, Map.of("author", author, "format", format));
        Prompt prompt = template.create();
        Generation generation = chatClient.call(prompt).getResult();
        return outputParser.parse(generation.getOutput().getContent());
    }


    @GetMapping("/author/{author}")
    public Map<String, Object> getAuthorSocialLinks(@PathVariable("author") String author) {
        String promptMessage = """
                Generate a list of links for the author {author}. Include the authors name as the key 
                and any social network links as the object. {format}
                """;
        MapOutputParser outputParser = new MapOutputParser();
        String format = outputParser.getFormat();
        PromptTemplate template = new PromptTemplate(promptMessage, Map.of("author", author, "format", format));
        Prompt prompt = template.create();
        Generation generation = chatClient.call(prompt).getResult();
        return outputParser.parse(generation.getOutput().getContent());
    }

}
