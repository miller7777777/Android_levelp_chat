package ru.levelp.chat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class ListContactActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListContactAdapter adapter;
    private OnListItemClickListener clickListener = new OnListItemClickListener() {
        @Override
        public void onClick(View v, int position) {
            Log.d(ListContactAdapter.class.getSimpleName(), "Clicked pos: " + position);
            Toast.makeText(ListContactActivity.this, "Clicked pos: " + position, Toast.LENGTH_SHORT).show();

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact);

        recyclerView = (RecyclerView) findViewById(R.id.contacts_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        for (int i = 0; i < 100; i++) {
            contacts.add(new Contact("Contact " + i, "Description " + i));
        }


        adapter = new ListContactAdapter(contacts, clickListener);
        recyclerView.setAdapter(adapter);
    }
}
