package com.example.saksham.contacts;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    EditText name,phone;
    Button insert;
    FirebaseDatabase database;
    DatabaseReference ref;
    Users user;
    private FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.Name);
        phone = (EditText) findViewById(R.id.PhnNum);
        insert = (Button) findViewById(R.id.button);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("users");
        user = new Users();
        floatingActionButton = findViewById(R.id.floatingActionButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(MainActivity.this,DataRetrieve.class);
                startActivity(next);
            }
        });
}
        private void getValues()
        {

            user.setName(name.getText().toString());
            user.setPhone(phone.getText().toString());
        }
    public void button (View view){
                        getValues();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                    ref.child("users01").setValue(user);
                Toast.makeText(MainActivity.this,"ADDED TO DATABASE",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(MainActivity.this,"failed",Toast.LENGTH_LONG).show();

            }
        });




    }
}




