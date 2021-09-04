
import com.github.guillaumederval.javagrading.Grade;
import com.github.guillaumederval.javagrading.GradeFeedback;
import com.github.guillaumederval.javagrading.GradeFeedbacks;
import com.github.guillaumederval.javagrading.GradingRunner;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(GradingRunner.class) // classic "jail runner" from Guillaume's library
public class Tests{

    @Test
    @Grade
    @GradeFeedbacks({@GradeFeedback(onSuccess = true, message = ""),
            @GradeFeedback(onFail = true, message = "Your act method in animal didn't work as expected")})
    public void test_act_animal() {
        Animal a1 = new Animal("Unknown animal");
        Animal a2 = new Cat();
        String[] acttions = new String[] {"EAT", "SLEEP", "CODE", "REPEAT"};
        StringBuilder expected = new StringBuilder();

        for(String action : acttions) {
            a1.act(action);
            a2.act(action);
            expected.append("%s is performing the following action: ").append(action).append("\n");
        }

        assertEquals(expected.toString().replaceAll("%s", "Unknown animal"), a1.logs());
        assertEquals(expected.toString().replaceAll("%s", "Cat"), a2.logs());

    }

    @Test
    @Grade
    @GradeFeedbacks({@GradeFeedback(onSuccess = true, message = ""),
            @GradeFeedback(onFail = true, message = "Your constructor for Cat didn't work as expected")})
    public void test_constructor_cat() {
        Animal a1 = new Cat();
        assertEquals("Cat", a1.getName());
    }

    @Test
    @Grade
    @GradeFeedbacks({@GradeFeedback(onSuccess = true, message = ""),
            @GradeFeedback(onFail = true, message = "Your act_forTestMethod method in Cat didn't work as expected")})
    public void test_act_forTestMethod() {
        Cat a1 = new Cat();
        a1.actForTestMethod();
        assertEquals("Cat is performing the following action: Thinking\n", a1.logs());
    }

    @Test
    @Grade
    @GradeFeedbacks({@GradeFeedback(onSuccess = true, message = ""),
            @GradeFeedback(onFail = true, message = "Your clear_log method in SuperCat didn't work as expected")})
    public void test_clear_log() {
        SuperCat a1 = new SuperCat();
        a1.clearLog();
        assertTrue(a1.logs().isEmpty());
    }

}