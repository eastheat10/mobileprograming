package net.skhu.a2020_1_mid_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class Exam3EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam3_edit);

        final EditText editText = (EditText) findViewById(R.id.editText);

        Button button = (Button) findViewById(R.id.btnSave);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String body = editText.getText().toString();
                if (isEmptyOrWhiteSpace(body)) {
                    editText.setError("입력하세요");
                    return;
                }

                Edit edit = new Edit(body);
                Intent intent = new Intent();
                intent.putExtra("Edit", edit);
                setResult(RESULT_OK, intent);
                finish();
            }
        };
        button.setOnClickListener(listener);
    }

    static boolean isEmptyOrWhiteSpace(String s) {
        if (s == null) return true;
        return s.toString().trim().length() == 0;
    }
}
