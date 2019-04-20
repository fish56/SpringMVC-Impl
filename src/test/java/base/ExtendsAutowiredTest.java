package base;

import org.junit.Assert;
import org.junit.Test;

public class ExtendsAutowiredTest extends AutowiredTest {

    // 确认可以使用父类自动注入的属性
    @Test
    public void canUseBaseClassFields() throws Exception{
        Assert.assertNotNull(webApplicationContext);
        Assert.assertNotNull(mockMvc);
    };
}
