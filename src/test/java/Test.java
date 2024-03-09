import com.github.worldofmeow.autumn.AHttpExchange;
import com.github.worldofmeow.autumn.AutumnHttpServer;
import com.github.worldofmeow.autumn.RequestHandler;
import com.github.worldofmeow.autumn.ServerContext;

public class Test {
    public static void main(String[] args) {
        AutumnHttpServer server = ServerContext.blank().http();
        server.setRoute("/", new RequestHandler() {
            @Override
            public void request(AHttpExchange exchange) {
                
            }
        });
    }
}
