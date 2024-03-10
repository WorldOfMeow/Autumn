#Autumn Http Library
### This Library aims to make Http Servers easy and uncomplicated to integrate into any Project in just a few steps. No External Libraries needed!  
## Simple Example:
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
