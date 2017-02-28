package com.casgar.test.shortestpathrecursive;

/**
 * Created by Humberto on 2/28/2017.
 */

public enum TestEnum {
    CASE1( new int[][] {{3,4,1,2,8,6},{6,1,8,2,7,4},{5,9,3,9,9,5},{8,4,1,3,2,6},{3,7,2,8,6,4}},
            true, 16, "[1 2 3 4 4 5]"),
    CASE2(new int[][]{{3,4,1,2,8,6},{6,1,8,2,7,4},{5,9,3,9,9,5},{8,4,1,3,2,6},{3,7,2,1,2,3}}
            ,true, 11, "[1 2 1 5 4 5]"),
    CASE3(new int[][]{{19,10,19,10,19},{21,23,20,19,12},{20,12,20,11,10}},false, 48, "[1 1 1]"),
    CASE4(new int[][]{{5,8,5,3,5}},true, 26, "[1 1 1 1 1]"),
    CASE5(new int[][]{{5},{8},{5},{3},{5}}, true, 3, "[4]"),
    CASE8(new int[][]{{69,10,19,10,19},{51,23,20,19,12},{60,12,20,11,10}},false,0 , "[]"),
    CASE9(new int [][] {{60,3,3,6},{6,3,7,9},{5,6,8,3}},true, 14, "[3 2 1 3]"),
    CASE10(new int[][]{{6,3,-5,9},{-5,2,4,10},{3,-2,6,10},{6,-1,-2,10}}, true, 0, "[2 3 4 1]"),;

    private final int[][] matrix;
    private final boolean finished;
    private final int weight;
    private final String path;

    TestEnum( int[][] matrix,boolean finished, int weight, String path ){

        this.matrix = matrix;
        this.finished = finished;
        this.weight = weight;
        this.path = path;

    }

    public int[][] getMatrix() {
        return matrix;
    }

    public boolean isFinished() {
        return finished;
    }

    public int getWeight() {
        return weight;
    }

    public String getPath() {
        return path;
    }

    public String getCaseName(){
        String name = "";
        switch (this){
            case CASE1:
                name= "CASE1";
                break;
            case CASE2:
                name= "CASE2";
                break;
            case CASE3:
                name= "CASE3";
                break;
            case CASE4:
                name= "CASE4";
                break;
            case CASE5:
                name= "CASE5";
                break;
            case CASE8:
                name= "CASE8";
                break;
            case CASE9:
                name= "CASE9";
                break;
            case CASE10:
                name= "CASE10";
                break;

        }
        return name;
    }
}
