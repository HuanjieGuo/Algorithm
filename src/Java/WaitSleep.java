package Java;

import java.util.stream.Stream;

public class WaitSleep {
    private final static Object lock = new Object();
    public static void main(String[] args) {
        Stream.of("线程1","线程2").forEach(n->new Thread(n){
            @Override
            public void run() {
                WaitSleep.testWait();
//                WaitSleep.testSleep();

            }
        }.start());

    }
    /**
     * 测试sleep 不释放锁
     线程1正在运行
     线程1休眠结束
     线程2正在运行
     线程2休眠结束
     */
    private static void testSleep(){
        // sleep不依赖synchronized
        synchronized ((lock)){
            try{
                System.out.println(Thread.currentThread().getName()+"正在运行");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"休眠结束");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * wait释放锁
     线程1正在运行
     线程2正在运行
     线程2休眠结束
     线程1休眠结束
     */
    private static void testWait(){
            try{
                System.out.println(Thread.currentThread().getName()+"正在运行");
                // 没加synchronize的话，没结束时 第二次被执行报错。
                lock.wait(1000);
                //lock.notify();// 唤醒休眠
                System.out.println(Thread.currentThread().getName()+"休眠结束");
            }catch (Exception e){
                e.printStackTrace();
            }
    }
}
