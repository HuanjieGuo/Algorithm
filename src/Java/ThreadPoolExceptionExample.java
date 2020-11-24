package Java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolExceptionExample {
    /**
     * use future.get
     * @param args
     */
    public static void main(String[] args) {
    }

    /**
     * 用future.get()获取异常
     */
    void futureExample(){
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            Future future = threadPool.submit(() -> {
                System.out.println("current thread name" + Thread.currentThread().getName());
                Object object = null;
                System.out.print("result## " + object.toString());
            });
            try{
                future.get();
            }catch (Exception e){
                System.out.println("发生异常");
            }
        }
    }

    /**
     * 用try catch获取
     */
    void tryExample(){
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            threadPool.submit(() -> {
                try {
                    System.out.println("current thread name" + Thread.currentThread().getName());
                    Object object = null;
                    System.out.print("result## " + object.toString());
                }catch (Exception e){
                    System.out.println("出错了");
                }
            });
        }
    }
}
