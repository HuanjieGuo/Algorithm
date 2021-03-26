package osAlgorithm.consumer_producer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Resource_2 {
    int num = 0;

    // 消费者
    synchronized public void remove()throws Exception{
        while (num==0) this.wait();
        num--;
        System.out.println("消费者消费,剩下 "+num);
        this.notifyAll();
    }
    // 生产者
    synchronized public void put()throws Exception{
        while (num==10) this.wait();
        num++;
        System.out.println("生产者生成,剩下 "+num);
        this.notifyAll();
    }



    public static void main(String[] args) {
        Resource resource = new Resource();
        Producer p = new Producer((resource));
        Consumer c = new Consumer(resource);
        new Thread(p).start();
        new Thread(c).start();
    }
}
