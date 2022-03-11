package spring.normal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import spring.normal.member.MemberRepository;
import spring.normal.member.MemoryMemberRepository;

@Configuration
@ComponentScan(
        basePackages = "spring.normal", //안쓰면 AutoAppConfig.java의 패키지로 디폴트 지정 = spring.normal로 똑같음
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    //ConflictingBeanDefinitionException
//    @Bean(name = "memoryMemberRepository")
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }

}
