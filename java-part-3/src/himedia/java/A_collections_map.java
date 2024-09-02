package himedia.java;

//Map
//키와 값의 쌍을 저장하는 자료구조를 나타낸다
//Map은 중복된 키를 허용하지 않으며, 각 키는 하나의 값에 매핑된다
//Map인터페이스에 대표적인 클래스에는

//주요특징
//키 값 쌍 : 맵 뇨소를 키와 값의 쌍으로 저장한다
//중복된 키 허용안함: 동일한 키를 두 번 추가할 수 없다
//만약 동일한 키를 다시 추가하면 기존의 값이 덮어씌워진다
//빠른 검색: 특정 키를 통해 ㅏㅄ에 빠르게 접근할 수 있다

//주요 메서드
//put(K kye, V value) 맵에 키와 값을 추가한다
//만약 동일한 키가 이미 존재한다면 해당 키읙 ㅏㅄ이 색 값으로 대체된다
//get(Object key): 키에 대응하는 값을 반환한다. 해당 키가 존재하지 않으면 null 반환한다
//remove(Object key): 특정 키에 대응하는 키-쌍 값을 제거한다
//containsKey(Object key): 앱에 특정 키가 포함돼 있는지 확인한다
//containsValue(Objcet value): 앰에 특정 값이 포함되어있는지 확인하낟


import java.util.HashMap;
import java.util.Map;

public class A_collections_map {

    //1.HashMap
    public static void exam1(){
        Map<String, Integer> map = new HashMap<>();
        //요소추가
        map.put("apple", 100);
        map.put("orange", 200);
        map.put("banana", 300);

        System.out.println("Map : " + map);

        Integer bvalue = map.get("apple");
        System.out.println("Value : " + bvalue);

        //요소 제거
        map.remove("orange");
        System.out.println("Map : " + map);

        //키 존재 여부 확인
        boolean aResult = map.containsKey("apple");
        System.out.println("Value : " + aResult);

        //순회방법
        for( Map.Entry<String, Integer>entry : map.entrySet() ){
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        }


        for( String key : map.keySet() ){
            System.out.println("Key : " + key + " Value : " + map.get(key));
        }

        for(Integer value : map.values() ){
            System.out.println("Value : " + value);
        }

    }


    public static void main(String[] args) {

        exam1();
    }
}
