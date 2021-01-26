package me.jipps.reflectiondemo;

import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReflectiondemoApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    public void pointcutAdvisor() {
        ProxyFactoryBean pfBean = new ProxyFactoryBean();
    }

}
