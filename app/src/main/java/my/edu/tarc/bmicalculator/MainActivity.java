package my.edu.tarc.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextWeight,editTextHeight;
    private ImageView imageViewResult;
    private TextView textViewResult;
    private Button buttonCalc;
    private Button buttonReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWeight = (EditText)findViewById(R.id.weight);
        editTextHeight = (EditText)findViewById(R.id.height);

        imageViewResult = (ImageView)findViewById(R.id.imageView);

        textViewResult = (TextView)findViewById(R.id.resultText);

        buttonCalc = (Button)findViewById(R.id.buttonCalc);
        buttonReset = (Button)findViewById(R.id.buttonReset);

    }

    public void calculate(View view){
        double weight, height,bmi;
        weight = Double.parseDouble(editTextWeight.getText().toString());
        height = Double.parseDouble(editTextHeight.getText().toString());
        bmi = weight/(height*height);
        if(bmi<18.5){
            textViewResult.setText("Underweight");
            imageViewResult.setImageResource(R.drawable.under);
        }
        else if(bmi>18.5 && bmi < 21){
            textViewResult.setText("Normal");
            imageViewResult.setImageResource(R.drawable.normal);
        }
        else{
            textViewResult.setText("U fat");
            imageViewResult.setImageResource(R.drawable.over);
        }
    }
    public void reset(View view){
        editTextHeight.setText("");
        editTextWeight.setText("");
        textViewResult.setText("");
        imageViewResult.setImageResource(R.drawable.empty);
    }
}
