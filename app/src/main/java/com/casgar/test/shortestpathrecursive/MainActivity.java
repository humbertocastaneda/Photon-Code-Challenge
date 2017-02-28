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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = (TextView) findViewById(R.id.tvResult);
        etMatrix = (EditText) findViewById(R.id.etMatrix);
        bStart = (Button) findViewById(R.id.bStart);

        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start();
            }
        });

    }

    public void start(){
        int[][] matrix = null;

        String [] matrixRows = etMatrix.getText().toString().split("\n");
        int i = 0;
        for (String string:matrixRows){

            String [] matrixColumns = string.split(",");
            if (matrix == null){
                matrix = new int[matrixRows.length][matrixColumns.length];

            }
            if (matrixColumns.length != matrix[0].length){
                tvResult.setText("Columns doesn't have the same lenght");
                return;
            }
            int j = 0;
            for (String value : matrixColumns){


                try{
                    matrix[i][j]= Integer.parseInt(value.trim());
                }catch (NumberFormatException e){
                    tvResult.setText("Not valid input");
                    e.printStackTrace();
                    return;
                }


                j++;
            }
            i++;
        }

        ShortestPathResult searchShortest = ShortestPathUtils.searchShortest(matrix);
        String result = searchShortest.isFinished()?"Yes":"No";
        result += "\n" + searchShortest.getWeight();
        result += "\n" + searchShortest.getPath();
        tvResult.setText(result);
    }


}
