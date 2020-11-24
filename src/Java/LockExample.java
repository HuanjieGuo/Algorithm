package Java;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        try{
            System.out.println("获取锁");
        }catch (Exception e){
        }finally {
            System.out.println("释放锁");
            lock.unlock();
        }
    }
}
