package com.example.edwinharen.gymdyr;

/**
 * Created by EdwinHaren on 28/04/2016.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class BMI extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);

        final Button button_calc = (Button) findViewById(R.id.button_calc);
        final EditText fieldWeight = (EditText) findViewById(R.id.fieldWeight);
        final EditText fieldHeight = (EditText) findViewById(R.id.fieldHeight);
        final TextView view_result = (TextView) findViewById(R.id.view_result);
        final TextView view_msg = (TextView) findViewById(R.id.view_msg);

        button_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double weight;
                double height;
                double bmi;
                String msg="";

                if(fieldHeight.getText().toString().equals("") || fieldWeight.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "No valid values!", Toast.LENGTH_LONG);

                }else {

                    weight = Double.parseDouble(fieldWeight.getText().toString());
                    height = Double.parseDouble(fieldHeight.getText().toString());

                    bmi = height * height;
                    bmi = weight / bmi;

                    view_result.setText(String.valueOf(bmi));

                    if (bmi < 18.5) {

                        msg = "Underweight";
                    } else if (bmi > 18.5 && bmi < 25) {

                        msg = "Normal";

                    } else if (bmi > 25) {

                        msg = "Overweight";
                    }
                    view_msg.setText(msg);
                }
            }
        });
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
}