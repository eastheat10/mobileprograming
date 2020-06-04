package net.skhu.a2020_1_mid_mobile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Date;

public class Exam3Adapter extends RecyclerView.Adapter<Exam3Adapter.ViewHolder> {
    TextView textView;
    Button button;


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

         public ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.textView);
            button = view.findViewById(R.id.btnSave);
            textView.setOnClickListener(this);
        }


        public void setData () {
            Edit edit = arrayList.get(getAdapterPosition());
            textView.setText(edit.getBody());
        }

        @Override
        public void onClick (View view){
            int index = super.getAdapterPosition();
            Exam3Activity activity = (Exam3Activity) textView.getContext();
            activity.memoIndex = index;
            Edit edit = arrayList.get(index);
            Intent intent = new Intent(activity, Exam3EditActivity.class);
            intent.putExtra("Edit", (Parcelable) edit);
            activity.startActivityForResult(intent, Exam3Activity.REQUEST_EDIT);
        }
    }

    LayoutInflater layoutInflater;
    ArrayList<Edit> arrayList;

    public Exam3Adapter(Context context, ArrayList<Edit> arrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.arrayList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.item1, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( final ViewHolder viewHolder, final int index) {
        viewHolder.setData();
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
