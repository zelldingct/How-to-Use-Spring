package hello.core.singleton;

public class SingletonService {

    //자기 자신을 private 하고 static 으로 딱 1개만 가지고 있다.
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;

    }

    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
