package lesson03;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Test {

    @BeforeClass
    public void setUp() {
    }

    @org.testng.annotations.Test
    public void testPositive(){

        int a = 2;
        int b = 2;
        Assert.assertEquals(a, b);

    }

    @org.testng.annotations.Test
    public void testNegative(){

        int a = 2;
        int b = 3;
        Assert.assertNotEquals(a, b);

    }

    @AfterClass
    public void tearDown(){

    }

}
