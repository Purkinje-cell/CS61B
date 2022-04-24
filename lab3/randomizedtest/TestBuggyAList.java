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
        for (int i = 1; i <= 31; i += 1) {
            t.addLast(i);
        }
        for (int i = 1; i <= 31; i += 1) {
            t.removeLast();
        }
    }
}

