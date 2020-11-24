package Java;

import java.util.concurrent.Callable;

public class ThreadCreateExample extends Thread{
    @Override
    public void run() {
        super.run();
    }
    static class RunnableExample implements Runnable{

        @Override
        public void run() {

        }
    }
    static class CallableExample implements Callable{

        @Override
        public Object call() throws Exception {
            System.out.println(1);
            return null;
        }
    }

    public static void main(String[] args) {
        CallableExample ex = new CallableExample();
        RunnableExample ru = new RunnableExample();
        try {
            ru.run(); // void
            Object object = ex.call(); // 返回object
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
