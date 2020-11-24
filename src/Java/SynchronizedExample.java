package Java;

public class SynchronizedExample implements Runnable{
    // 共享资源
    static Integer i=0;
    public synchronized void increase(){
        i++;
    }

    @Override
    public void run() {
        for(int j =0;j<1000000;j++){
                increase();
        }
    }

    public static void main(String[] args) {
        SynchronizedExample sy = new SynchronizedExample();
        Thread t1 = new Thread(sy);
        Thread t2 = new Thread(sy);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 去掉synchronize， 1115745
        // 加上  2000000
        System.out.println(i);
    }
}
