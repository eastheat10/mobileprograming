package net.skhu.a2020_1_mid_mobile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Exam2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam2);

        Button btn = (Button)findViewById(R.id.button);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Exam2Activity.this);
                builder.setMessage("Do you want to delete");
                builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int index) {
                        String s = "삭제실패";
                        Toast.makeText(Exam2Activity.this, s, Toast.LENGTH_SHORT).show();
                        TextView tv = (TextView)findViewById(R.id.textView);
                        tv.setText(s);
                    }
                });
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int index) {
                        String s = "삭제성공";
                        Toast.makeText(Exam2Activity.this, s, Toast.LENGTH_SHORT).show();
                        TextView tv = (TextView)findViewById(R.id.textView);
                        tv.setText(s);
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        };
        btn.setOnClickListener(listener);
    }
}
