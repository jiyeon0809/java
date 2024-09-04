package himedia.java;

//스레ㅔ드의 우선순위
//스레드느느 우선순위라는 속성을 가지고 있는데 이 우선순위값에 따라 스레드가 얻는 실행시간이 달라진다
//스레드가 수행하는 작업의 중요도에 따라 스레드 우선순위를 서로 다르게 지정하여 특정 스레드가


class C_threadEx_pri_1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 3000; i++) {
            System.out.println("-");
        }
    }
}

class C_threadEx_pri_2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 3000; i++) {
            System.out.println("|");
        }
    }
}

public class C_thread_4 {
    public static void main(String[] args) {
        C_threadEx_pri_1 t = new C_threadEx_pri_1();
        C_threadEx_pri_2 t2 = new C_threadEx_pri_2();

        t2.setPriority(7);

        System.out.println(t.getPriority());
    }
}
