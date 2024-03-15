import java.io.IOException;

public interface Observer {
    void update(String ProviderName) throws IOException;
}
