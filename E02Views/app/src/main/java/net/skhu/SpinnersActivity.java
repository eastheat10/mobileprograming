package net.skhu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnersActivity extends AppCompatActivity {

    boolean t = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinners);

        final String[] stringArray = { "집주소", "직장주소", "기타" };
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, stringArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner spinner1 = (Spinner) findViewById(R.id.spinner_phoneType);
        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner_addressType);
        spinner2.setAdapter(adapter);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (t == false) {
                    t = true;
                    return;
                }
                else
                Toast.makeText(SpinnersActivity.this,"선택된 항목 : "+spinner2.getSelectedItem().toString() ,Toast.LENGTH_LONG).show();
        }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        View.OnClickListener listener1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int index1 = spinner1.getSelectedItemPosition();
                String text1 = spinner1.getSelectedItem().toString();


                int index2 = spinner2.getSelectedItemPosition();
                String text2 = spinner2.getSelectedItem().toString();


                String s = String.format("전화:%s(%d)   주소:%s(%d)", text1, index1, text2, index2);
                Toast.makeText(SpinnersActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        };
        Button button = (Button) findViewById(R.id.btnSave);
        button.setOnClickListener(listener1);
    }

}
