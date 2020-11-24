package Java;

import java.util.Queue;
import java.util.concurrent.*;

public class ThreadPoolExample {
    /**
     * the most basic ThreadPoolExecutor
     * test maximumPoolSize
     1.线程池最大线程数大小。 同时创建的总线程>maximumPoolSize+Queue，触发饱和策略。 先使用队列，再使用maximumPoolSize.
     2.如果使用了无界队列，则创建无限线程，直到内存溢出，maximumPoolSize永远用不上
     */
    static void ThreadPoolExecutorExample(){
        ExecutorService executor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5));
        for(int i=0;i<16;i++){
            executor.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName()+"正在执行 "+System.currentTimeMillis());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /**
     * newFixedThreadPool
     * 核心数和最大线程数一样
     * keepAliveTime 为0
     * 无界队列linkedBlockingQueue
     * 由执行结果可见，按核心线程执行，其余放入阻塞线程，依次执行
     */

    /**
     pool-1-thread-1正在执行 1606129456710
     pool-1-thread-3正在执行 1606129456710
     pool-1-thread-2正在执行 1606129456710
     pool-1-thread-2正在执行 1606129457713
     pool-1-thread-1正在执行 1606129457713
     pool-1-thread-3正在执行 1606129457713
     pool-1-thread-1正在执行 1606129458718
     */
    static void newFixedThreadPoolExample(){
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(int i=0;i<7;i++){
            executor.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName()+"正在执行 "+System.currentTimeMillis());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /**
     * newCachedThreadPool
     * 核心数0  最大线程数Integer.MAX_VALUE
     * keepAliveTime 为60
     * 不存储的阻塞队列 SynchronousQueue
     * 由执行结果可见，全部同时并发。
     */

    /**
     pool-1-thread-1 正在执行 1606129376409
     pool-1-thread-3 正在执行 1606129376409
     pool-1-thread-2 正在执行 1606129376409
     pool-1-thread-4 正在执行 1606129376409
     pool-1-thread-5 正在执行 1606129376409
     pool-1-thread-6 正在执行 1606129376409
     pool-1-thread-7 正在执行 1606129376410
     */
    static void newCachedThreadPoolExample(){
        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i=0;i<70;i++){
            executor.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName()+ " 正在执行"+" "+System.currentTimeMillis());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /**
     * newSingleThreadExecutor
     * 核心数1  最大线程数1
     * keepAliveTime 为0
     * 阻塞队列 LinkedBlockingQueue
     * 由执行结果可见，单线程执行了7次。
     */

    /**
     pool-1-thread-1 正在执行 1606129871131
     pool-1-thread-1 正在执行 1606129872134
     pool-1-thread-1 正在执行 1606129873138
     pool-1-thread-1 正在执行 1606129874142
     pool-1-thread-1 正在执行 1606129875147
     pool-1-thread-1 正在执行 1606129876150
     pool-1-thread-1 正在执行 1606129877154
     */
    static void newSingleThreadExecutorExample(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for(int i=0;i<7;i++){
            executor.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName()+ " 正在执行"+" "+System.currentTimeMillis());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /**
     * newScheduledThreadPool
     * 核心数n  最大线程数Integer.MAX_VALUE
     * keepAliveTime 为0
     * 阻塞队列 DelayedWorkQueue
     * 由执行结果可见，间隔为设置的时间
     */
    /**
     pool-1-thread-1 正在执行 1606132425243
     pool-1-thread-1 正在执行 1606132428246
     pool-1-thread-1 正在执行 1606132431248
     pool-1-thread-1 正在执行 1606132434251
     */
    static void newScheduledThreadPoolExample(){
        ScheduledExecutorService s = Executors.newScheduledThreadPool(1);
        s.scheduleWithFixedDelay(() -> {
            System.out.println(Thread.currentThread().getName()+ " 正在执行"+" "+System.currentTimeMillis());
        },0,3,TimeUnit.SECONDS);
    }
    public static void main(String[] args) {
        newScheduledThreadPoolExample();
    }
}
