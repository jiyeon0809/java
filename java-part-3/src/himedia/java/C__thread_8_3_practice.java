package himedia.java;

class SharedResource1{
    private boolean isAvailable = false;


    public synchronized void waitForResource(String threaName){
        while(!isAvailable){
            try {
                System.out.println(threaName+"is waiting for resource...");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void makeResourceAvailable(){
        isAvailable = true;
        System.out.println("Resource is available.");
        notifyAll();
    }

}

class workerThread extends Thread{
    private SharedResource sharedResource;
    private String threaName;
}



public class C__thread_8_3_practice {
}
