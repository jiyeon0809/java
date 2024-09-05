package himedia.java;

//스레드의 실행 제어
//스레드의 상태
//[NEW] :스레드가 생성되고 아직 start()가 호출되지 않은 상태
//[RUNNABLE] : 스레드가 실행 중 또는 실행 가능 상태
//->스레드를 생성하고 start()를 호출하면 바로 실행되는 것이 아니라
//실행 대기열에 저장되어 자신의 차례를 기다려야한다
//실행대기열은 큐와 같은 구조로 먼저 실행 대기열에 들어온 스레드 먼저 실행된다
//주어진 실행시간이 다죄거나 yield()를 만나면 다시 실행대기상태가 되고 다음 차례 스레드가 실행된다
//[BLOCKED]: 동기화블럭에 의해서 일시정지된상태(lock이 풀릴 때까지 기다리는 상태)
//[WAITING, THREAD_WAITING]: 스레드의 작업이 종료되지 않았지만 실행가능하지 않은 일시상태
//TIMED_WAITING은 일시정지시간이 지정된 경우를 의미한다
//->실행중인 suspend(), sleep(), wait(), join(), I/O block에 의해 일시정지된 상태가 될 수 있다
//I/O block은 입출력작업에서 발생하는 지연상태를 뜻한다. 사용자의 입력을 기다리는 경우를 예로 들 수 있는데
//이런 경우 일시정지 상태에 있다가 사용자가 입력을 마치면 다시 실행대기 상태가 된다
//->지정된 일시정지상태가 다되거나(time-out), notify(), resume(), interrupt()가 호출되면
//일시정지 상태를 벗어나 다시 실행대기열에 저장되어 자신의 차례를 기다리게 된다
//[TERMINATED]: 스레드의 작업이 종료된 상태
//-> 실행을 모두 마치거나 stop()이 호출되면 스레드는 소멸된다

//메서드
//sleep(): 지정된스레드를 일시정지시킨다
//지정된 시간이 지나고 나면 자동적으로 다시 실행대기 상태가 된다
//join(): 지정된 시간동안 스레드가  실행되도록 한다. 지정된 시간이 지나 작업이 종료됨녀
//join()ㅇ,ㅡㄹ 호출한 스레드로 돌아와 실행 계속한ㄱ다
//interrupt(): sleep()이나 join()에 의해 일시정지상태인 스렉드를 깨워서 실행대기상태로 ㅁ나든다
//해당 스레드에서 interruptedException이 발생함으로써 일시정지상태를 벗어나게 된다
//stop(): 스레드를 즉시 종료한다
//suspend(): 스레드를 일시정지한다. resume()을 호출하면 다시 실행대기한다
//yield(): 실행 중에 자신에게 주어진 실행시간으로 다른 스레드에게 양보하고 자신은 실행대기상태가 된다

//-> resume, stop, suspend는 스레드를 교착상태로 만들기 쉬어 deprecated되었다


import java.util.Scanner;

class ThreadEx_sleep_1 extends Thread{
    @Override
    public void run() {
        for( int i=0; i<300; ++i){
            System.out.println("-");
        }
        System.out.println("<<th1종료>>");
    }
}



class ThreadEx_sleep_2 extends Thread{
    @Override
    public void run() {
        for( int i=0; i<300; ++i){
            System.out.println("|");
        }
        System.out.println("<<th2종료>>");
    }
}


class ThreadEx_interrupt_1 extends Thread{
    @Override
    public void run() {
        int i=10;
        while(i!=0 && !isInterrupted()){
            System.out.println(i--);
            for(long x=0; x<2500000000L; x++); //시간 지연
        }
        System.out.println("카운트가 종료되었습니다");
    }
}


class ThreadEx_interrupt_2 extends Thread{
    @Override
    public void run() {
        int i=10;
        while(i!=0 && !isInterrupted()){
            System.out.println(i--);
            for(long x=0; x<2500000000L; x++); //시간 지연
        }
        System.out.println("카운트가 종료되었습니다");
    }
}

class ThreadEx_yield_1 extends Thread{
    private String name;

    public ThreadEx_yield_1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i=0; i<5; i++){
            System.out.println(name+"is running. Iteration : "+i);

            Thread.yield();

            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}

class ThreadEx_join_1 extends Thread{
    @Override
    public void run() {
        for(int i=0; i<300; ++i){
            System.out.println("-");
        }
    }
}

class ThreadEx_join_2 extends Thread{
    @Override
    public void run() {
        for(int i=0; i<300; ++i){
            System.out.println("|");
        }
    }
}



public class C_thread_7 {
    public static void exam1(){
        ThreadEx_sleep_1 t1 = new ThreadEx_sleep_1();
        t1.start();
        ThreadEx_sleep_2 t2 = new ThreadEx_sleep_2();
        t2.start();

        try {
            t1.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("<<main 종료>>");

        //t1이 가장 늦게 종료되어야하는데 결과에서는 제일 먼저 종료될 수 있다
        //그 이유는 sleep()이 항상 현재 실행 중인 스레드에 대해 작동하기 때문에 t1.sleep()을 했어도
        //실제로 영향받는 것은  main 스레드에서 실행하는 main스레드다
        //그래서 sleep()은 참조 변수 이용해서 호출하기 조다 static으로 선언된 Thread.sleep(2000);
    }

    //interrupt(): 스레드의 작업을 취소한다
    //진행중인 스레드의 작업이 끝나기 전에 취소해야할 떄가 있다
    //예를 들어 시간이 너무 오래 걸리면중간에 당ㄴ로드를 포기하고
    //취소할 수 잇어야 한다
    //interrupt()는 스레드에게 작업을 멈추라고 요청한다
    //단지 멈추라고 요청한 것일 뿐 스레드를 강제로 종료시키지는 못한다
    //interrupted()는 interrupt()가 호출되었는지 알려준다
    //interrupted()가 호출되이 않았다면 false, 호출했다면 true 반환

    public static void exam2_1(){
        ThreadEx_interrupt_1 t1 = new ThreadEx_interrupt_1();
        t1.start();

        System.out.println("I1 : "+ t1.isInterrupted());

        System.out.println("아무값이나 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("입력한 값은"+input+"입니다.");
        t1.interrupt();

        System.out.println("I1 : "+ t1.isInterrupted());

    }

    //thread.yield
    //자바의 스레드 제어 메서드 중 하나로 현재 실행중인 스레드가 cpu를 다른 스레드에 양보하도록 한다

    public static void exam3(){
        ThreadEx_yield_1 t1 = new ThreadEx_yield_1("Thread 1");
        t1.start();


        ThreadEx_yield_1 t2 = new ThreadEx_yield_1("Thread 2");
        t2.start();
        System.out.println("I1 : "+ t1.isInterrupted());
    }

    //join(): 다른 스레드 작업 기다림
    public static void exam4(){
        ThreadEx_join_1 t1 = new ThreadEx_join_1();
        ThreadEx_join_2 t2 = new ThreadEx_join_2();

        t1.start();
        t2.start();

        long startTime=System.currentTimeMillis();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("소요시간 : "+(System.currentTimeMillis()-startTime)+"ms");

        //join을 시용하지 않았다면 main 스레드가 바로 종료
    }

    //스레드가 sleep(), wait(), join()에 의해 일시정지상태에 있을 떄
    //해당 스레드에 대해 interrupted()를 호출하면 sleep(), wiat(), join()에서
    //interruptedException이 발생하고 스레드는 실행대기상태로바뀐다

    public static void main(String[] args) {
        exam4();
    }
}
