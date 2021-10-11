import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Http server
 */
public class MyHttpServer {
    public static void main(String[] args) throws IOException {
        final int PORT = 9000;

        HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);
        httpServer.createContext("/pets", new PetRequestHandler());
        System.out.println("Server started! \nPORT: " + PORT);
        httpServer.setExecutor(null);
        httpServer.start();
    }
}
