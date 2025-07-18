package llmRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ChatRequestBuilder {
    private ChatRequest chatRequest;
    private List<Message> messages = new ArrayList<>();
    private List<ContentElement> contentElements = new ArrayList<>();

    public ChatRequestBuilder() {
        chatRequest = new ChatRequest();
        chatRequest.setModel("gemma-3-12b-it@q6_k");
        chatRequest.setTemperature(0.4);
    }

    public ChatRequestBuilder(String modelName, double modelTemperature) {
        chatRequest = new ChatRequest();
        chatRequest.setModel(modelName);
        chatRequest.setTemperature(modelTemperature);
    }

    public void setSystemPrompt(String systemPrompt) {
        Message systemMessage = new Message();
        systemMessage.setRole("system");
        systemMessage.setContent(systemPrompt);
        messages.add(systemMessage);
    }

    public void setUserPrompt(String userPrompt) {
        ContentElement userMessage = new ContentElement();
        userMessage.setType("text");
        userMessage.setText(userPrompt);
        contentElements.add(userMessage);
    }

    public void setImageElement(String content) {
        ImageUrl imageUrl = new ImageUrl();
        imageUrl.setUrl(content);

        ContentElement imageElement = new ContentElement();
        imageElement.setType("image_url");
        imageElement.setImage_url(imageUrl);
        contentElements.add(imageElement);
    }

    public String build() throws JsonProcessingException {
        Message userMessage = new Message();
        userMessage.setRole("user");
        userMessage.setContent(contentElements);
        messages.add(userMessage);

        chatRequest.setMessages(messages);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(chatRequest);
    }
}
