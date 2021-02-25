package osAlgorithm.consumer_producer;

public class Producer implements Runnable{
    Resource resource;
    public Producer(Resource resource){
        this.resource = resource;
    }
    @Override
    public void run() {
        while (true){
            resource.put();
        }
    }
}
