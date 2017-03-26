package com.casgar.test.shortestpathrecursive;

import android.util.Pair;

import java.util.Hashtable;

/**
 * Created by Humberto on 2/28/2017.
 */

/**
 * This class has all the methods for getting the shortest path
 */
public class ShortestPathUtils {

    /**
     * Gets the shortest path from the given path
     * @param matrix Matrix with all the weights
     * @return The shortest path
     */
    public static ShortestPathResult searchShortest(int[][] matrix) {
        ShortestPathResult shortestPathResult = null;
        Hashtable<Pair<Integer, Integer>,ShortestPathResult> paths = new Hashtable<>();

        //We need to iterate through the first columns
        for (int i = 0; i < matrix.length; i++) {
            ShortestPathResult testResult;

            //If the cell weight is greater than 50, this start doesn't have shortest path
            if( matrix[i][0] > 50){
                continue;
            }
            else{
                //Let's check all the posible paths
                testResult = searchShortest(paths, matrix, i, 0, matrix[i][0]);
            }

            //Let´s compare the current shortest with the current shortest
            if (pathComparator(shortestPathResult, testResult)) {
                //If it is shorter than the previously saved, replace it
                shortestPathResult = testResult;
            }

        }
        if (shortestPathResult == null){
            //If there is not shortest path in this matrix, return a empty shortestpath
            shortestPathResult = new ShortestPathResult();
        }

        return shortestPathResult;
    }

    /**
     * Searches the shortest path from a specific cell
     * @param paths Hashtable that saves all the shortest paths from an specific cell.
     *              Coordinates, Shortest path object
     * @param matrix Matrix to search from
     * @param row Row of a cell that you want to start the search
     * @param column Column of the cell that you want to start the search
     * @param weight Weight of the current step
     * @return The shortest path of this cell
     */
    private static ShortestPathResult searchShortest(Hashtable <Pair<Integer, Integer>,ShortestPathResult> paths, int[][] matrix, int row, int column, int weight)  {
        ShortestPathResult shortestPathResult = null;

        //If we had reached the last
        if (column + 1 == matrix[0].length) {

            shortestPathResult = new ShortestPathResult();
            shortestPathResult.setWeight(weight);
            shortestPathResult.setFinished(true);
            shortestPathResult.addPath(row + 1);
            shortestPathResult.setWeightBackwards(matrix[row][column]);

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

            //Check over the has table if it already got a shortest path
            ShortestPathResult testResult = paths.get(new Pair<>(nextRow, column+1));

            //Path haven't been calculated yet
            if (testResult == null){
                if (weight + matrix[nextRow][column + 1] > 50) {
                    //Cannot reach the other side, lets save this path anyway
                    testResult = new ShortestPathResult();
                    testResult.addPath(row + 1);
                    testResult.setWeight(weight);
                    testResult.setFinished(false);

                    //Let's compare this path
                    if (pathComparator(shortestPathResult, testResult)) {
                        //replace the previously saved, if it is more optimal
                        shortestPathResult = testResult;
                    }

                    continue;
                }

                //Check the shortest path for the next cell
                testResult = searchShortest(paths, matrix, nextRow, column + 1, weight + matrix[nextRow][column + 1]);
            }
            else
            {
                //If we got the current path from the hashtable, we need recalculate the weight.
                //Since the weight was set for the previous search
                testResult.setWeight(testResult.getWeightBackwards() + weight);
            }

            try {
                //As we are using hastable as cursor, we need to be careful saving and getting information
                //from it
                testResult = (ShortestPathResult) testResult.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            //We add the current node to the shortest path
            testResult.addPath(row + 1);

            //Let´s compare
            if (pathComparator(shortestPathResult, testResult)) {
                shortestPathResult = testResult;
            }

            //Sets the weight from right to left
            shortestPathResult.setWeightBackwards((shortestPathResult.getWeight() -weight) + matrix[row][column] );
        }
        //If it is finished, we can tell the shortest path
        if (shortestPathResult.isFinished()){
            //Save the shortest path
            paths.put(new Pair<>(row, column),shortestPathResult);
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
        //If path1 is null, should be replaced
        if (path1 == null) {
            return true;
        }

        //If path2 is null, should not be replaced
        if (path2==null){
            return false;
        }

        //If both paths are not finished, but path2 got farther, Should be replaced
        if (!path1.isFinished() && !path2.isFinished() && path2.path.size() > path1.path.size()) {
            return true;
        }
        //If both paths are not finished but path1 got farther, Should not be replaced
        else if (!path1.isFinished() && !path2.isFinished() && path2.path.size() < path1.path.size()){
            return false;
        }

        //If it path1 is more expensive, should be replaced
        if (path1.getWeight() > path2.getWeight() ) {
            return true;
        }

        //Else... you should keep path1
        return false;
    }
}
