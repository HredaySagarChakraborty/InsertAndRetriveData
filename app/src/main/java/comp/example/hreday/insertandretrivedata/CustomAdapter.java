package comp.example.hreday.insertandretrivedata;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Student> {


    private Activity context;
    private List<Student> studentList;

    public CustomAdapter(@NonNull Activity context,  List<Student> studentList) {
        super(context, R.layout.sample, studentList);
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.sample, null, true);


        Student student = studentList.get(position);

        TextView t1 = view.findViewById(R.id.textViewId);
        TextView t2 = view.findViewById(R.id.textView2Id);


        t1.setText(student.getName());
        t2.setText(student.getAge());


        return view;
    }
}

