package edu.neu.madcourse.numad21su_emilycolladay;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;



public class LinksClick extends AppCompatActivity {
    //Creating the essential parts needed for a Recycler view to work: RecyclerView, Adapter, LayoutManager
    private ArrayList<ItemCard> linkList = new ArrayList<>();
    private RecyclerView rView;
    private LinksAdapter adapter;
    private RecyclerView.LayoutManager rLayoutManager;
    private FloatingActionButton addButton;

    private static final String KEY_OF_INSTANCE = "KEY_OF_INSTANCE";
    private static final String NUMBER_OF_LINKS = "NUMBER_OF_LINKS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.links_main);

        createRecyclerView();

        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = 0;
                addLink(pos);
            }
        });
    }

    // creates the view
    private void createRecyclerView() {

        rLayoutManager = new LinearLayoutManager(this);

        rView = findViewById(R.id.recycler_view);
        rView.setHasFixedSize(true);

        adapter = new LinksAdapter(linkList);


        rView.setAdapter(adapter);
        rView.setLayoutManager(rLayoutManager);


    }

    // Adds another link to the list
    private void addLink(int position) {
        linkList.add(position, new ItemCard("No Logo item", "Item id: "));
        //Toast.makeText(getApplicationContext(), "Add an item", Toast.LENGTH_SHORT).show();

        adapter.notifyItemInserted(position);

        Snackbar.make(findViewById(R.id.button_links), R.string.LinkAdded,
                Snackbar.LENGTH_SHORT)
                .show();
    }
}