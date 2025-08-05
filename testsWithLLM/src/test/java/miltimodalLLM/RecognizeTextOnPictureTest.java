package miltimodalLLM;

import dataProvider.RequestToLLM;
import org.testng.annotations.Test;
import restAction.LocalLLMActions;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class RecognizeTextOnPictureTest {
    private final LocalLLMActions restAction = new LocalLLMActions(
            "http://localhost:1234/v1",
            "/chat/completions"
    );

    @Test
    public void recognizeExpectedWordOnPicture() throws IOException {
        String requestBody = RequestToLLM.getRequestToRecognizeImage();

        String llmResponse = restAction.sendImageRecognitionRequest(requestBody);

        assertThat(llmResponse).as("LLM doesn't find expected word")
                .isEqualToIgnoringCase("yes");
    }
}
