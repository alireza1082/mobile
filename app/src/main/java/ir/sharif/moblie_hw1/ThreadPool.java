package ir.sharif.moblie_hw1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;*/

public class ThreadPool {
    private static final ThreadPool threadPool = new ThreadPool();//Early, instance will be created at load time
    private final ExecutorService threadPoolExecutor;

    private ThreadPool() {
        /*int corePoolSize = 5;
        int maxPoolSize = 10;
        long keepAliveTime = 5000;

        this.threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>()
        );*/

        int poolSize = 8;

        this.threadPoolExecutor = Executors.newFixedThreadPool(poolSize);
    }

    public static ThreadPool getThreadPool() {
        return threadPool;
    }

    public void execute(Runnable task) {
        threadPoolExecutor.execute(task);
    }

    public void shutDown(){
        threadPoolExecutor.shutdown();
    }
}
