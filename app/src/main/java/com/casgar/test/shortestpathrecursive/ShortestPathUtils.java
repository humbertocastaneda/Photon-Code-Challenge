package com.casgar.test.shortestpathrecursive;

/**
 * Created by Humberto on 2/28/2017.
 */

public class ShortestPathUtils {

    public static ShortestPathResult searchShortest(int[][] matrix) {
        ShortestPathResult shortestPathResult = null;

        for (int i = 0; i < matrix.length; i++) {
            ShortestPathResult testResult;
            if( matrix[i][0] > 50){
                continue;
            }
            else{
                testResult = searchShortest(matrix, i, 0, matrix[i][0]);
            }

            if (pathComparator(shortestPathResult, testResult)) {
                shortestPathResult = testResult;
            }

        }
        if (shortestPathResult == null){
            shortestPathResult = new ShortestPathResult();
        }

        return shortestPathResult;
    }

    private static ShortestPathResult searchShortest(int[][] matrix, int row, int column, int weight) {
        ShortestPathResult shortestPathResult = null;

        //if we had reached the last
        if (column + 1 == matrix[0].length) {

            shortestPathResult = new ShortestPathResult();
            shortestPathResult.setWeight(weight);
            shortestPathResult.setFinished(true);
            shortestPathResult.addPath(row + 1);
            return shortestPathResult;

        }

        //Loop for every diagonal
        for (int j = -1; j < 2; j++) {
            int nextRow = row + j;

            if (nextRow < 0) {
                nextRow = matrix.length - 1;
            } else if (nextRow == matrix.length) {
                nextRow = 0;
            }

            if (weight + matrix[nextRow][column + 1] > 50) {
                //if (shortestPathResult == null || shortestPathResult.getWeight()>weight){
                ShortestPathResult testResult = new ShortestPathResult();
                testResult.addPath(row + 1);
                testResult.setWeight(weight);
                testResult.setFinished(false);

                if (pathComparator(shortestPathResult, testResult)) {
                    shortestPathResult = testResult;
                }


                continue;
            }

            ShortestPathResult testResult = searchShortest(matrix, nextRow, column + 1, weight + matrix[nextRow][column + 1]);
            testResult.addPath(row + 1);
            //if (shortestPathResult == null || shortestPathResult.getWeight() >testResult.getWeight()){
            if (pathComparator(shortestPathResult, testResult)) {
                shortestPathResult = testResult;
            }
        }

        return shortestPathResult;
    }

    /**
     * Compares two paths
     *
     * @param path1 older path
     * @param path2 newer path
     * @return returns if the new string is a better path
     */
    public static boolean pathComparator(ShortestPathResult path1, ShortestPathResult path2) {
        if (path1 == null) {
            return true;
        }

        if (path2==null){
            return false;
        }

        if (!path1.isFinished() && !path2.isFinished() && path2.path.size() > path1.path.size()) {
            return true;
        }
        else if (!path1.isFinished() && !path2.isFinished() && path2.path.size() < path1.path.size()){
            return false;
        }

        if (path1.getWeight() > path2.getWeight() ) {
            return true;
        }

        return false;
    }
}
