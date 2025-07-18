package ig.pet.content;

import ig.pet.file.File;

import java.io.IOException;
import java.util.Base64;

public class Content {
    private static String createEncodedString(byte[] object) {
        return Base64.getEncoder().encodeToString(object);
    }

    public static String imageAsBase64(String folder, String file) throws IOException {
        byte[] imageAsByteArr = File.getFileAsByteArray(folder, file);
        return createEncodedString(imageAsByteArr);
    }
}
