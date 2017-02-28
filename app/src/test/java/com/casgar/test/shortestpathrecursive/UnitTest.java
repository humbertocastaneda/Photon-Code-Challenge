package com.casgar.test.shortestpathrecursive;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTest {
    @Test
    public void testCases() throws Exception {
        for (TestEnum testEnum : TestEnum.values()) {
            ShortestPathResult shortestPathResult = ShortestPathUtils.searchShortest(testEnum.getMatrix());

            assertEquals(testEnum.getCaseName(),testEnum.getPath(),shortestPathResult.getPath());
            assertEquals(testEnum.getCaseName(), testEnum.isFinished(),shortestPathResult.isFinished());
            assertEquals(testEnum.getCaseName(), testEnum.getWeight(),shortestPathResult.getWeight());

        }


    }

    @Test
    public void testPathComparatorBetterPath() throws Exception {
        ShortestPathResult path1 = new ShortestPathResult();
        path1.setWeight(19);
        path1.setFinished(true);
        ShortestPathResult path2 = new ShortestPathResult();
        path2.setWeight(6);
        path2.setFinished(true);
        boolean result = ShortestPathUtils.pathComparator(path1, path2);
        assertEquals(true, result);

    }

    @Test
    public void testPathComparatorNoPathChange() throws Exception {
        ShortestPathResult path1 = new ShortestPathResult();
        path1.setWeight(6);
        path1.setFinished(true);
        ShortestPathResult path2 = new ShortestPathResult();
        path2.setWeight(19);
        path2.setFinished(true);

        boolean result = ShortestPathUtils.pathComparator(path1, path2);
        assertEquals(false, result);

    }

    @Test
    public void testPathComparatorFirstPathEqualsNull() throws Exception {
        ShortestPathResult path1 = null;
        ShortestPathResult path2 = new ShortestPathResult();
        path2.setWeight(19);
        path2.setFinished(true);

        boolean result = ShortestPathUtils.pathComparator(path1, path2);
        assertEquals(true, result);

    }

    @Test
    public void testPathComparatorSecondPathNull() throws Exception {
        ShortestPathResult path1 = new ShortestPathResult();
        path1.setWeight(6);
        path1.setFinished(true);
        ShortestPathResult path2 = null;

        boolean result = ShortestPathUtils.pathComparator(path1, path2);
        assertEquals(false, result);

    }
    @Test
    public void testPathComparatorBetterPathNotFinished() throws Exception {
        ShortestPathResult path1 = new ShortestPathResult();
        path1.setWeight(19);
        path1.setFinished(false);
        ShortestPathResult path2 = new ShortestPathResult();
        path2.setWeight(6);
        path2.setFinished(false);
        boolean result = ShortestPathUtils.pathComparator(path1, path2);
        assertEquals(true, result);

    }

    @Test
    public void testPathComparatorNoPathChangeNotFinished() throws Exception {
        ShortestPathResult path1 = new ShortestPathResult();
        path1.setWeight(6);
        path1.setFinished(false);
        ShortestPathResult path2 = new ShortestPathResult();
        path2.setWeight(19);
        path2.setFinished(false);

        boolean result = ShortestPathUtils.pathComparator(path1, path2);
        assertEquals(false, result);

    }

    @Test
    public void testPathComparatorBetterPathNotFinishedBiggerPath() throws Exception {
        ShortestPathResult path1 = new ShortestPathResult();
        path1.setWeight(19);
        path1.setFinished(false);
        path1.addPath(1);
        ShortestPathResult path2 = new ShortestPathResult();
        path2.setWeight(6);
        path2.setFinished(false);
        boolean result = ShortestPathUtils.pathComparator(path1, path2);
        assertEquals(false, result);

    }

    @Test
    public void testPathComparatorNoPathChangeNotFinishedBiggerPath() throws Exception {
        ShortestPathResult path1 = new ShortestPathResult();
        path1.setWeight(6);
        path1.setFinished(false);
        ShortestPathResult path2 = new ShortestPathResult();
        path2.setWeight(19);
        path2.addPath(1);
        path2.setFinished(false);

        boolean result = ShortestPathUtils.pathComparator(path1, path2);
        assertEquals(true, result);

    }

}