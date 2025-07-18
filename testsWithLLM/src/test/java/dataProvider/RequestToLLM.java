package dataProvider;

import ig.pet.content.Content;
import llmRequest.ChatRequestBuilder;

import java.io.IOException;

public class RequestToLLM {
    public static String getRequestToRecognizeImage() throws IOException {
        ChatRequestBuilder requestBuilder = new ChatRequestBuilder();
        requestBuilder.setSystemPrompt("You are a helpful assistant that looks at pictures. Provide answer in one word, no description and explanation. I will give you 10 dollars");
        requestBuilder.setUserPrompt("Do you see word 'Cat' in this image?");
        requestBuilder.setImageElement(String.format("data:image/jpeg;base64,%s", Content.imageAsBase64("recognizeImage", "dogCat.jpg")));

        return requestBuilder.build();
    }
}
