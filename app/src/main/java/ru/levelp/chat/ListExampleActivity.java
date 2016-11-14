package ru.levelp.chat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class ListExampleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListExampleAdapter adapter;
    private OnListItemClickListener clickListener = new OnListItemClickListener() {
        @Override
        public void onClick(View v, int position) {
            Log.d(ListExampleAdapter.class.getSimpleName(), "Clicked pos: " + position);
            Toast.makeText(ListExampleActivity.this, "Clicked " + position, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_example);



        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<User> users =  new ArrayList<User>();
        for (int i = 0; i < 100; i++) {
            users.add(new User("User " + i, "Description " + i));
        }

        adapter = new ListExampleAdapter(users, clickListener);
        recyclerView.setAdapter(adapter);
    }
}
