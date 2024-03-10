import com.github.worldofmeow.autumn.*;

public class Test {
    public static int i = 0;
    public static void main(String[] args) {
        AutumnHttpServer server = ServerContext.blank().http().start();
        server.setRoute("/i", new RequestHandler() {
            @Override
            public void request(SimpleHttpExchange exchange) {
//                for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
//                    System.out.println(ste + "\n");
//                }
                exchange.simple().returnPlainText("I=" + (i++));
            }
        });
    }
}
