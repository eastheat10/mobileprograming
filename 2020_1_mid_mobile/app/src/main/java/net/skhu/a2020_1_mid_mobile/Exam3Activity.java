package net.skhu.a2020_1_mid_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Date;

public class Exam3Activity extends AppCompatActivity {
    private static final int REQUEST_CREATE = 0;
    public static final int REQUEST_EDIT = 1;

    Exam3Adapter exam3Adapter;
    ArrayList<Edit> arrayList;
    int memoIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam3);

        arrayList = new ArrayList<Edit>();
        arrayList.add(new Edit("one"));
        arrayList.add(new Edit("two"));

        exam3Adapter = new Exam3Adapter(this, arrayList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(exam3Adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_create) {
            Intent intent = new Intent(this, Exam3EditActivity.class);
            startActivityForResult(intent, REQUEST_CREATE);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_create);
        return true;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == RESULT_OK) {
            Edit edit = (Edit)intent.getSerializableExtra("Edit");
            if (requestCode == REQUEST_CREATE)
                arrayList.add(edit);
            else if (requestCode == REQUEST_EDIT)
                arrayList.set(memoIndex, edit);
            exam3Adapter.notifyDataSetChanged();
        }
    }
}
