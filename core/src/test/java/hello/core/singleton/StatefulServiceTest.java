package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        int userA = statefulService1.order( "userA", 10000);
        int userB = statefulService2.order("userB", 20000);

        //int price = statefulService1.getPrice();
        System.out.println("price = " + userA);
        //Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
        //statefulService1과 2는 결국 같은 객체이므로 위와 같이 B클라이언트가 요청할 시에
        //필요로하는 A데이터가 아닌 B데이터로 덮어씌어진다.
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}