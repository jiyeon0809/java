package himedia.java;

//wait()과  notify()


class Chat {
    private boolean flag=false;

    //질문하는 메서드
    public synchronized void question(String msg){
        while(flag){
            try {
                wait(); //질문할 차례가 될 떄까지 대기
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Question : "+msg);
        flag=true;
        notify();
    }
    //답변하는 메서드
    public synchronized void answer(String msg){
        while(!flag){
            try {
                wait(); //답변할 차례 대기
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Answer : "+msg);
        flag=false;
        notify();
    }


}

class QuestionThread extends Thread{
    private Chat chat;
    private String[] questions ={"Hi","How are you?","What are you doing?"};
    public QuestionThread(Chat chat){
        this.chat = chat;
    }

    @Override
    public void run() {
        chat.question(questions[0]);
    }
}

class AnswerThread extends Thread{
    private Chat chat;
    private String[] answers ={"Hello","I'm fine. Thank you.","I'm coding in java"};
    public AnswerThread(Chat chat){
        this.chat = chat;
    }

    @Override
    public void run() {
        chat.answer(answers[0]);
    }
}

public class C_thread_8_2_wait_notify {
    public static void main(String[] args) {

        Chat chat = new Chat();
        QuestionThread qt = new QuestionThread(chat);
        AnswerThread at = new AnswerThread(chat);
        qt.start();
        at.start();
    }
}
