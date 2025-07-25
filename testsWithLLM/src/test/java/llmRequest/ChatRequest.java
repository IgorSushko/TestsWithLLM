package llmRequest;

import java.util.List;

public class ChatRequest {
    private String model;
    private List<Message> messages;
    private double temperature;


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "ChatRequest{" +
                "model='" + model + '\'' +
                ", messages=" + messages +
                ", temperature=" + temperature +
                '}';
    }
}
