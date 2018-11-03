package com.example.gferreir.projectcleaner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class GetAllUsersActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<UserModel> userModelArrayList;
    private CustomAdapter customAdapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        listView = (TextView) findViewById(R.id.txtSalaInsere);

        databaseHelper = new DatabaseHelper(this);

        userModelArrayList = databaseHelper.getAllUsers();

        customAdapter = new CustomAdapter(this,userModelArrayList);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GetAllUsersActivity.this,UpdateDeleteActivity.class);
                intent.putExtra("user",userModelArrayList.get(position));
                startActivity(intent);
            }
        });
    }

}
