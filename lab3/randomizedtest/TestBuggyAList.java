package randomizedtest;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void addRemoveTest() {
        AListNoResizing<Integer> ref = new AListNoResizing<>();
        BuggyAList<Integer> t = new BuggyAList<>();
        int N = 500;
        for (int i = 1; i <= N; i++) {
            ref.addLast(i);
            t.addLast(i);
        }
        for (int i = 1; i <= N; i++) {
            int operationNumber = StdRandom.uniform(0,2);
            if (operationNumber == 0) {
                ref.addLast(i);
                t.addLast(i);
                System.out.println("addLast(" + i + ")");
                assertEquals(ref.size(),t.size());
                assertEquals(ref.get(i),t.get(i));
            }
            else {
                assertEquals(ref.removeLast(),t.removeLast());
                assertEquals(ref.size(),t.size());
            }
        }
    }
}
