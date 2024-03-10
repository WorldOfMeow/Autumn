import com.github.worldofmeow.autumn.*;

public class Test {
    public static void main(String[] args) {
        AutumnHttpServer server = ServerContext.blank().http().start();
        server.setRoute("/", new RequestHandler() {
            @Override
            public void request(SimpleHttpExchange exchange) {
                exchange.simple().returnPlainText("Autumn Version: " + Autumn.versionString);
            }
        });
    }
}
