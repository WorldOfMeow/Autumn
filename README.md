###Simple Example:
```java
    public static void main(String[] args) {
        AutumnHttpServer server = ServerContext.blank().http().start();
        server.setRoute("/", new RequestHandler() {
            @Override
            public void request(SimpleHttpExchange exchange) {
                exchange.simple().returnPlainText("Autumn Version: " + Autumn.versionString);
            }
        });
    }
```
