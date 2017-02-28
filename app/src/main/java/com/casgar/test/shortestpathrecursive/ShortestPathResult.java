package com.casgar.test.shortestpathrecursive;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Humberto on 2/27/2017.
 */

public class ShortestPathResult {
    private boolean finished=false;
    private int weight = 0;
    public List<Integer> path;

    public ShortestPathResult(){
        path = new ArrayList<>();
    }

    public void addPath(int row){
        path.add(row);
    }

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

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isFinished() {
        return finished;
    }

    public int getWeight() {
        return weight;
    }
}
