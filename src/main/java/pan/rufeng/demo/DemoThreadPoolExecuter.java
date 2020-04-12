package pan.rufeng.demo;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DemoThreadPoolExecuter {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Test begin");
        Runnable myRunnable = new Runnable() {
//            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
//                    System.out.println(Thread.currentThread().getName() + " run");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        // Test case 1: SynchronousQueue, 6 tasks, corePoolSize 3, maxmumPoolSize 6, keepAliveTime 5秒
        // keepAliveTime to 6
        // maxmumPoolSize to 5
        // Test case 2: LinkedBlockingQueue without size limit, 6 tasks, corePoolSize 4, maxmumPoolSize 6, keepAliveTime 5秒
        // Test case 3: ArrayBlockingQueue或LinkedBlockingQueue with size limit, 6 tasks, corePoolSize 4, maxmumPoolSize 6, keepAliveTime 5秒
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(3, 6, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(2));
        executeRunnable3Times("第一次提交：", myRunnable, tpe);
        executeRunnable3Times("第二次提交：",myRunnable, tpe);
        Thread.sleep(8000);
        System.out.println("   8秒之后：corePoolSize: " + tpe.getCorePoolSize() + "\t poolSize: " + tpe.getPoolSize() + "\t queueSize: " + tpe.getQueue().size());

    }

    private static void executeRunnable3Times(String title, Runnable myRunnable, ThreadPoolExecutor tpe) {
        tpe.execute(myRunnable);
        tpe.execute(myRunnable);
        tpe.execute(myRunnable);
        System.out.println(title + "corePoolSize: " + tpe.getCorePoolSize() + "\t poolSize: " + tpe.getPoolSize() + "\t queueSize: " + tpe.getQueue().size());
    }
}
