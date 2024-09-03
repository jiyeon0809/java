package himedia.java;

//제네릭
//자바에서 클래스, 인터페이스, 메서드를 정의할 때 사용할 데이터 타입을 지정하지 않고
//필요할 때 사용할 데이터 타입을 지정할 수 있게 하는 기능이다
//제네릭을 사용하면 컴파일 시 타입 안정성을 ㅜ보장하고 불필요한 타입 캐스팅을 줄일 수 있다


public class B_generic<T> {

    private T item;

    private T getItem(){
        return item;
    }

    public void setItem(T item){
        this.item = item;
    }

    public static void main(String[] args) {
        B_generic<Integer> intBox = new B_generic<>();
        intBox.setItem(1234);
        System.out.println("Integer value : "+intBox.getItem());

        B_generic<String> strBox = new B_generic<>();
        strBox.setItem("test");
        System.out.println("String value : "+strBox.getItem());
    }
}
