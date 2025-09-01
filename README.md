# 💬 AI-App (Spring Boot + Thymeleaf + Ollama)

A **local AI chatbot application** powered by [Ollama](https://ollama.ai) and built with **Spring Boot**, **Thymeleaf**, and **Maven**.  
This project connects to an Ollama model running locally (e.g., `deepseek-r1:1.5b`) and provides a simple, modern web-based chat UI.

---

## ✨ Features
- 🔹 Chat with local Ollama models (e.g., `deepseek-r1:1.5b`, `llama3`)
- 🔹 **Spring Boot 3.5 + Java 21**
- 🔹 **Thymeleaf templates** render the chat history dynamically
- 🔹 Responsive chat UI with:
  - Auto-scroll to latest message
  - Enter = send, Shift+Enter = newline
- 🔹 Dark mode chat interface

---

## 📦 Tech Stack
- **Backend**: Spring Boot (Web, Thymeleaf)
- **Frontend**: Thymeleaf + HTML5, CSS3, JavaScript
- **AI Engine**: [Ollama](https://ollama.ai) (local LLMs)
- **Build Tool**: Maven

---
## 📂 Project Structure
markdown
Copy code
```
ai-app/
 ├── src/main/java/com/moredabuhamed/ai_app
 │   ├── controller/       # ChatController handles routes
 │   ├── service/          # OllamaService for API calls
 │   └── AiAppApplication  # Spring Boot entry point
 │
 ├── src/main/resources
 │   ├── templates/        # Thymeleaf HTML templates
 │   │   └── index.html    # Chat UI
 │   └── application.properties
 │
 └── pom.xml               # Maven configuration
```
---
## 🖼️ Screenshot

Here’s how the chat app looks in action:

<img width="957" height="911" alt="image" src="https://github.com/user-attachments/assets/f2c96a24-fb52-47b6-919e-f02c76711e45" />

