package base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration // 表明这是为web应用的测试
@ContextConfiguration({"classpath:applicationContext.xml"})
// 因为绕过了真实的web容器，所以不需要加载 web.xml
public class BaseTest {
    // 判断环境是否正常
    @Test
    public void isEnvOk(){};
}
