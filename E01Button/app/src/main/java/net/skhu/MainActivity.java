package net.skhu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  //layout inflation 발생

        Button b = (Button)findViewById(R.id. button);
        View.OnClickListener listenerObj = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e = (EditText) findViewById(R.id.editText);
                CharSequence s = e.getText();
                TextView t = (TextView) findViewById(R.id.textView);
                t.setText(s);
            }
        };
        b.setOnClickListener(listenerObj);
    }
}

//리스너 : 무언가 바뀌면 (클릭, 입력 ...) 무언가 실행됨