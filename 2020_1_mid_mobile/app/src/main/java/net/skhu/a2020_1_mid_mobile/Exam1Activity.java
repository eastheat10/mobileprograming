package net.skhu.a2020_1_mid_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Exam1Activity extends AppCompatActivity {
    int num = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam1);


        Button btn1 = (Button)findViewById(R.id.increase);
        View.OnClickListener listener1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++num;
                String s = Integer.toString(num);
                EditText editText = (EditText) findViewById(R.id.editText);
                editText.setText(s);
            }
        };
        btn1.setOnClickListener(listener1);

        Button btn2 = (Button)findViewById(R.id.decrease);
        View.OnClickListener listener2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                --num;
                String s = Integer.toString(num);
                EditText editText = (EditText) findViewById(R.id.editText);
                editText.setText(s);
            }
        };
        btn2.setOnClickListener(listener2);
    }
}
