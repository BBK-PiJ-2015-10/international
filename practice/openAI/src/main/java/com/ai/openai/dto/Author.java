package com.ai.openai.dto;

import java.util.List;

public record Author(String name, List<String> books) {
}
