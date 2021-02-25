package osAlgorithm.consumer_producer;

/**
 没加锁混乱

 生产者线程为：Thread-0---资源数量：3
 消费者线程为：Thread-1---资源数量：2
 生产者线程为：Thread-0---资源数量：3
 消费者线程为：Thread-1---资源数量：3
 消费者线程为：Thread-1---资源数量：3
 生产者线程为：Thread-0---资源数量：3
 生产者线程为：Thread-0---资源数量：3
 消费者线程为：Thread-1---资源数量：2
 */
public class ResourceWithoutLock {
    int full = 0;
    int free = 10;
    // 消耗资源
    public void withoutLockRemove(){
        if(full==0){
            return;
        }
        full--;
        free++;
        System.out.println("消费者线程为：" + Thread.currentThread().getName() + "---资源数量：" + full);
    }
    // 生产
    public void withoutLockPut(){
        if(free==0){
            return;
        }
        full++;
        free--;
        System.out.println("生产者线程为：" + Thread.currentThread().getName() + "---资源数量：" + full);
    }
}
