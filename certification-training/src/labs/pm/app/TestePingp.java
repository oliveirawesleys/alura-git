package labs.pm.app;

import java.util.concurrent.*;

public class TestePingp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(() -> System.out.println("Ping"));

/*        Future<String> future = new Callable<String>() {
            public String call() throws Exception {
                return "Pong";
            }
        }.call();*/

        Future<String> future = es.submit(() -> "Pong");

        System.out.println(future.get());
        es.shutdown();
    }
}
