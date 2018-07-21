package com.example.saksham.contacts;

import android.support.design.widget.FloatingActionButton;
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

public class DataRetrieve extends AppCompatActivity {

    private ListView listView;
    DatabaseReference databaseReference;

    List<Users> usersList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_retrieve);

        listView = findViewById(R.id.list_view);

        databaseReference = FirebaseDatabase.getInstance().getReference("users");
                usersList = new ArrayList<>();

    }

    @Override
    protected void onStart() {
        super.onStart();

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot UserSnapshot : dataSnapshot.getChildren()) {

                        Users user = UserSnapshot.getValue(Users.class);
                        usersList.add(user);
                    }




                ContactsAdapters contactsAdapters = new ContactsAdapters(DataRetrieve.this, usersList);
                    listView.setAdapter(contactsAdapters);

            }
                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
    }
}
