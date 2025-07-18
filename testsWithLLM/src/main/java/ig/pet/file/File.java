package ig.pet.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class File {
    static public byte[] getFileAsByteArray(String folder, String file) throws IOException {
        Path path = Paths.get("src/test/resources/" + folder + "/" + file);
        return Files.readAllBytes(path);
    }
}
