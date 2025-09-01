package com.moredabuhamed.ai_app.controller;

import com.moredabuhamed.ai_app.service.OllamaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatController {

    private final OllamaService ollamaService;
    private final List<String[]> chatHistory = new ArrayList<>();

    public ChatController(OllamaService ollamaService) {
        this.ollamaService = ollamaService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("chatHistory", chatHistory);
        return "index";
    }

    @PostMapping("/ask")
    public String ask(@RequestParam("prompt") String prompt, Model model) {
        String reply = ollamaService.askOllama(prompt);
        chatHistory.add(new String[]{"user", prompt});
        chatHistory.add(new String[]{"bot", reply});
        model.addAttribute("chatHistory", chatHistory);
        return "index";
    }
}
