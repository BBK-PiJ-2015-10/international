package com.ai.openai.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromptController {

    private static final Logger logger = LoggerFactory.getLogger(PromptController.class);

    private final ChatClient chatClient;

    public PromptController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/")
    public String simple(String message) {
        logger.info("Calling prompt with prompt {}", message);
        var response = chatClient.call(new Prompt("Tell me a dad jok")).getResult().getOutput().getContent();
        logger.info("Received prompt {}", response);
        return response;
    }
}
