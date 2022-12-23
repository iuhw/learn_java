package di;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author:
 */
public class IDriverTest {
    Mockery context = new JUnit4Mockery();

    @Test
    public void driver() {
        final ICar car = context.mock(ICar.class);
        IDriver driver = new Driver();

        context.checking(new Expectations() {{
            oneOf(car).run();
        }});

        driver.driver(car);
    }
}