package net.skhu;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.btnRecyclerView1);
        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecyclerView1Activity.class);
                startActivity(intent);
            }
        }; button.setOnClickListener(listener);

    }

    public void btnListView_clicked(View view) {
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);
    }

    public void btnRecyclerView2_clicked(View view) {
        Intent intent = new Intent(this, RecyclerView2Activity.class);
        startActivity(intent);
    }
    public void btnRecyclerView3_clicked(View view) {
        Intent intent = new Intent(this, RecyclerView3Activity.class);
        startActivity(intent);
    }

}
