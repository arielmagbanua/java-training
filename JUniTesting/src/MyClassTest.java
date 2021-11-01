import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class MyClassTest {
    @Test
    public void testCompute() {
        Assert.assertTrue(MyClass.compute(-10, 0, 0) == -1);
        Assert.assertTrue(MyClass.compute(10, 10, 10) == 1000);
        Assert.assertTrue(MyClass.compute(0, 0, 0) == 0);
    }
}
