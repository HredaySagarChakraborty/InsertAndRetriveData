
package comp.example.hreday.insertandretrivedata;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    private ListView listView;
    private CustomAdapter customAdapter;
    List<Student> studentList;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        studentList = new ArrayList<>();


        databaseReference = FirebaseDatabase.getInstance().getReference("stu:");


        customAdapter=new CustomAdapter(DetailsActivity.this,studentList);


        listView = findViewById(R.id.listViewId);


    }

    @Override
    protected void onStart() {


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                studentList.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){



                    Student student=dataSnapshot1.getValue(Student.class);
                    studentList.add(student);



                }

                listView.setAdapter(customAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onStart();
    }
}