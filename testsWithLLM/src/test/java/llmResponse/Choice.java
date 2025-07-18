package llmResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Choice {
    private int index;
    private Object logprobs;
    @JsonProperty("finish_reason")
    private String finishReason;
    private Message message;


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Object getLogprobs() {
        return logprobs;
    }

    public void setLogprobs(Object logprobs) {
        this.logprobs = logprobs;
    }

    public String getFinishReason() {
        return finishReason;
    }

    public void setFinishReason(String finishReason) {
        this.finishReason = finishReason;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "index=" + index +
                ", logprobs=" + logprobs +
                ", finishReason='" + finishReason + '\'' +
                ", message=" + message +
                '}';
    }
}
