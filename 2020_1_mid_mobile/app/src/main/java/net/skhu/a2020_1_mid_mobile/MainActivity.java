package net.skhu.a2020_1_mid_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity<listener2> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.exam1_button);
        View.OnClickListener listener1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Exam1Activity.class);
                startActivity(intent);
            }
        };
        btn1.setOnClickListener(listener1);


        Button btn2 = (Button) findViewById(R.id.exam2_button);
        View.OnClickListener listener2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Exam2Activity.class);
                startActivity(intent);
            }
        };
        btn2.setOnClickListener(listener2);

        Button btn3 = (Button) findViewById(R.id.exam3_button);
        View.OnClickListener listener3 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Exam3Activity.class);
                startActivity(intent);
            }
        };
        btn3.setOnClickListener(listener3);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
