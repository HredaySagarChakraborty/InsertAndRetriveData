package comp.example.hreday.insertandretrivedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText name, age;
    private Button button,button2;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        databaseReference = FirebaseDatabase.getInstance().getReference("stu:");


        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        button = findViewById(R.id.insert);
       button2 = findViewById(R.id.Load);


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
                startActivity(intent);

            }


        });




        button.setOnClickListener(this);


    }





    @Override
    public void onClick(View view) {

        saveData();





    }


    private void saveData() {


        String nam = name.getText().toString().trim();
        String ag = age.getText().toString().trim();

        String key = databaseReference.push().getKey();

        Student student = new Student(nam, ag);

        databaseReference.child(key).setValue(student);
        Toast.makeText(this, "Data has been stored", Toast.LENGTH_SHORT).show();




    }



}

