package com.casgar.test.shortestpathrecursive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    EditText etMatrix;
    Button bStart;

    //Initialize variables inside this step
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind each control with the XML
        tvResult = (TextView) findViewById(R.id.tvResult);
        etMatrix = (EditText) findViewById(R.id.etMatrix);
        bStart = (Button) findViewById(R.id.bStart);

        //Added a listener to the bStart button
        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Let's start to search for the shortest path
                start();
            }
        });
    }

    /**
     * Starts the processing of the shortest path.
     * The matrix should be written inside the edit text:
     * Use commas to represent columns
     * Use line break to represent rows
     */
    public void start(){
        int[][] matrix = null;

        //Split the text by break lines for getting the rows
        String [] matrixRows = etMatrix.getText().toString().split("\n");
        int i = 0;
        //For each row, we should split by commas for getting the columns
        for (String string:matrixRows){
            String [] matrixColumns = string.split(",");
            if (matrix == null){
                matrix = new int[matrixRows.length][matrixColumns.length];
            }

            //All the columns must be the same length, if not, stop the execution
            if (matrixColumns.length != matrix[0].length){
                tvResult.setText("Columns doesn't have the same lenght");
                return;
            }

            //The processing is specting the values to be int, so we need to parse the information
            //to int
            int j = 0;
            for (String value : matrixColumns){

                try{
                    matrix[i][j]= Integer.parseInt(value.trim());
                }catch (NumberFormatException e){
                    //If we got another type of caracter, let's stop the execution
                    tvResult.setText("Not valid input");
                    e.printStackTrace();
                    return;
                }


                j++;
            }
            i++;
        }

        //Once we got the matrix, we can start the calculations
        ShortestPathResult searchShortest = ShortestPathUtils.searchShortest(matrix);

        //Getting the result and print it to the user
        String result = searchShortest.isFinished()?"Yes":"No";
        result += "\n" + searchShortest.getWeight();
        result += "\n" + searchShortest.getPath();
        tvResult.setText(result);
    }


}
