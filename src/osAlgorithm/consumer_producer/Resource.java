package osAlgorithm.consumer_producer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
signal 唤醒在此LOCK等待的单个线程
 signalAll 唤醒在此lock等待的所有线程
 */
public class Resource {
    int full = 0;
    int free = 10;
    // 锁
    ReentrantLock reentrantLock = new ReentrantLock();
    // 条件
    Condition condition = reentrantLock.newCondition();
    // 消费者
    public void remove(){
        try{
            //释放锁
            reentrantLock.lock();
            while (full==0){
                System.out.println("消费者进入等待线程");
                // 调用await的线程释放锁然后加入到等待队列，并且线程状态转换为等待状态。
                condition.await();
            }
            //消费
            full --;
            free ++;
            System.out.println("消费者线程为:" + Thread.currentThread().getName() + "--资源数量:" + full);
            // 唤醒其他等待线程
            condition.signal();

        }catch (Exception e) {
            e.printStackTrace();
        }
        finally  {
            reentrantLock.unlock();
        }
    }
    // 生产者
    public void put(){
        try{
            reentrantLock.lock();
            while (free==0){
                System.out.println("生产者进入等待线程");
                // 调用await的线程释放锁然后加入到等待队列，并且线程状态转换为等待状态。
                condition.await();
            }
            free--;
            full++;
            System.out.println("生产者线程为:" + Thread.currentThread().getName() + "--资源数量:" + full);
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }
    }



    public static void main(String[] args) {
        Resource resource = new Resource();
        Producer p = new Producer((resource));
        Consumer c = new Consumer(resource);
        new Thread(p).start();
        new Thread(c).start();
    }
}
