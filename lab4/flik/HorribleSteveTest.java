package flik;

import static org.junit.Assert.*;
import org.junit.Test;

public class HorribleSteveTest {

    @Test
    public void TestIsSameNumber() {
        Flik test = new Flik();
        for (int i = 1; i <= 500; i++) {

            boolean same = test.isSameNumber(i, i);
            assertTrue(same);
        }
    }
}
