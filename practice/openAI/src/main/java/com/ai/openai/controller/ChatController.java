package com.ai.openai.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatController {

    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

    private final ChatClient chatClient;

    @Autowired
    public ChatController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }


    @GetMapping("/dad-jokes")
    public String generate(@RequestParam(value = "message", defaultValue = "Tell me a dad joke") String message) {
        logger.info("Calling openApi with message: {}", message);
        var answer = chatClient.call(message);
        logger.info("OpenApi answered with: {}", answer);
        return answer;
    }


    @GetMapping("/dad-jokes/v2")
    public String jokes() {
        var user = new UserMessage("Tell me a joke about cars");
        Prompt prompt = new Prompt(user);
        var answer = chatClient.call(prompt).getResult().getOutput().getContent();
        logger.info("OpenApi answered with: {}", answer);
        return answer;
    }

    @GetMapping("/universe-jokes")
    public String jokesWith2() {
        var system = new SystemMessage("Your primary function is to tell Dad Jokes. If someone asks for another type of joke tell them to buy a book.");
        var user = new UserMessage("Tell me a serious joke about the universe");
        Prompt prompt = new Prompt(List.of(system,user));
        var answer = chatClient.call(prompt).getResult().getOutput().getContent();
        logger.info("OpenApi answered with: {}", answer);
        return answer;
    }

}
