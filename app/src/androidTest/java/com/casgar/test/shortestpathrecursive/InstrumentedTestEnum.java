package com.casgar.test.shortestpathrecursive;

/**
 * Created by Humberto on 2/28/2017.
 */

public enum InstrumentedTestEnum {
    CASE1( "3,4,1,2,8,6\n6,1,8,2,7,4\n5,9,3,9,9,5\n8,4,1,3,2,6\n3,7,2,8,6,4",
            "Yes\n16\n[1 2 3 4 4 5]"),
    CASE2("3,4,1,2,8,6\n6,1,8,2,7,4\n5,9,3,9,9,5\n8,4,1,3,2,6\n3,7,2,1,2,3",
            "Yes\n11\n[1 2 1 5 4 5]"),
    CASE3("19,10,19,10,19\n21,23,20,19,12\n20,12,20,11,10",
            "No\n48\n[1 1 1]"),
    CASE4("5,8,5,3,5",
            "Yes\n26\n[1 1 1 1 1]"),
    CASE5("5\n8\n5\n3\n5",
            "Yes\n3\n[4]"),
    CASE6("5,4,H\n8,M,7\n5,7,5",
            "Not valid input"),
    CASE7("",
            "Not valid input"),
    CASE8("69,10,19,10,19\n51,23,20,19,12\n60,12,20,11,10",
            "No\n0\n[]"),
    CASE9("60,3,3,6\n6,3,7,9\n5,6,8,3",
            "Yes\n14\n[3 2 1 3]"),
    CASE10("6,3,-5,9\n-5,2,4,10\n3,-2,6,10\n6,-1,-2,10",
            "Yes\n0\n[2 3 4 1]"),
    CASE11("5,4\n3\n2\n9",
            "Columns doesn't have the same lenght");

    private final String matrix;
    private final String result;

    InstrumentedTestEnum(String matrix, String result ){

        this.matrix = matrix;
        this.result = result;
    }

    public String getMatrix() {
        return matrix;
    }

    public String getResult() {
        return result;
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
            case CASE11:
                name= "CASE11";
                break;

        }
        return name;
    }
}
