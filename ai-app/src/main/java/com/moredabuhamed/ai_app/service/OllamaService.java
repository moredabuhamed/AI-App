package com.moredabuhamed.ai_app.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service
public class OllamaService {

    private final String modelName = "deepseek-r1:1.5b";

   public String askOllama(String promptText) {
    try {
        URL url = new URL("http://localhost:11434/api/generate");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; utf-8");
        conn.setRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);

        String jsonInputString = String.format(
            "{ \"model\": \"%s\", \"prompt\": \"%s\", \"stream\": %b }",
            modelName, promptText, false
        );

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(
                conn.getResponseCode() >= 200 && conn.getResponseCode() < 300
                        ? conn.getInputStream()
                        : conn.getErrorStream(),
                StandardCharsets.UTF_8));

        StringBuilder response = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();

        JSONObject jsonResponse = new JSONObject(response.toString());
        String responseText = jsonResponse.getString("response");

        // 🧹 Clean unwanted text
        return responseText
                .replaceAll("(?s)<think>.*?</think>", "") // removes <think>…</think>
                .replaceAll("Ollama", "")
                .trim();

    } catch (Exception e) {
        e.printStackTrace();
        return "Error: " + e.getMessage();
    }
}

}
