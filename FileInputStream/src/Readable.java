import java.io.*;

public interface Readable {
    void read();
    void buildSummary(FileInputStream fis) throws IOException;
}
