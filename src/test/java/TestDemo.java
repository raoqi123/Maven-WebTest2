import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import rq.Person;

import javax.annotation.Resource;

/**
 * Created by raoqi on 16/9/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestDemo {

    @Resource
    private Person person;

    @Test
    public void test(){
        System.out.println(this.person);
    }

}
