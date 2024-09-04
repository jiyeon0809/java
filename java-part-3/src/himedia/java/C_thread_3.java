package himedia.java;

//싱글 스레드와 멀티 스레드
// 두개의 작업을 하나의 스레드로 처리하는 경우와 두 개의 스레드로 처리하는 경우
//하나의 스레드로 두 작업을 처리하는 경우는 한 작업을 마친 후 다른 작업을 시작하지만
//두 개의 스레드로 작업하는 경우에는 짧은 시간 동안 2개의 스레드가 번갈아가면서 작업을 수행한다


class C_threadEx_time extends Thread {
    @Override
    public void run() {
        for(int i=0; i<300; ++i){
            System.out.printf("%s", new String("|"));
        }
    }
}



public class C_thread_3 {
    static long startTime=0;

    public void exam1(){
        long startTime = System.currentTimeMillis();
        for(int i=0; i<300; ++i){
            System.out.printf("%s", new String("-"));
        }

       long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    public static void exam2(){
        C_threadEx_time t1 = new C_threadEx_time();
        t1.start();
        startTime=System.currentTimeMillis();
    }


    public static void main(String[] args) {

    }

}
