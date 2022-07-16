package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    @Bean(name = "memoryMemberRepository")//이렇게 bean명이 중복 되면 수동이 자동을 우선한다.
        // 단, 최근 springboot에서는 애초에 이름이 중복되면 실행되지 않도록 default가 설정되어 있다.
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
