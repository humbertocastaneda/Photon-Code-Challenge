package com.casgar.test.shortestpathrecursive;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Humberto on 2/27/2017.
 */

/**
 * This class is used to save the shortest path information
 */
public class ShortestPathResult implements Cloneable {
    private boolean finished=false;
    private int weight = 0;
    private int weightBackwards = 0;
    public List<Integer> path;

    /**
     * Initialize
     */
    public ShortestPathResult(){
        path = new ArrayList<>();
    }

    /**
     * Sets a path followed
     * @param path List of row index (non zero-based) showing the path followed backwards
     *             Example
     *
     *             4, 3, 1, 1
     *
     *             Path should be read  like Col 1 row 1, Col 2 row 1, Col 3 row 3, Col 4 row 4
     */
    public void setPath(List<Integer> path) {
        this.path = path;
    }

    /** Clones an object for preventing problems with cursors
     *
     * @return Cloned object
     * @throws CloneNotSupportedException Throws exception if the object cannot be cloned
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        ShortestPathResult cloned = (ShortestPathResult) super.clone();
        List<Integer> path = new ArrayList<>();
        path.addAll(this.path);
        cloned.setPath(path);
        return cloned;
    }

    /**
     * Adds a row index to the path
     * @param row Row index
     */
    public void addPath(int row){
        path.add(row);
    }

    /**
     * Generates the path in string format
     * @return String with the path followed
     */
    public String getPath(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = this.path.size() - 1; i >= 0; i--){
            if(!stringBuilder.toString().equals("[")){
                stringBuilder.append(" ");
            }
            stringBuilder.append(this.path.get(i));

        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /**
     * Sets if the path was finished or not
     * @param finished Status of the path
     */
    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    /**
     * Sets the weight of this path from left to right
     * @param weight weight of the current path
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Sets the weight from right to left
     * @param weightBackwards Weight from right to left
     */
    public void setWeightBackwards(int weightBackwards) {
        this.weightBackwards = weightBackwards;
    }

    /**
     * Gets the weight from right to left
     * @return
     */
    public int getWeightBackwards() {
        return weightBackwards;
    }

    /**
     * Returns if the path got the other side
     * @return
     */
    public boolean isFinished() {
        return finished;
    }

    /**
     * Gets the weight from left to right
     * @return
     */
    public int getWeight() {
        return weight;
    }
}
