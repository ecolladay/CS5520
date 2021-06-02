package edu.neu.madcourse.numad21su_emilycolladay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Random;

import edu.neu.madcourse.numad21su_emilycolladay.ItemCard;
import edu.neu.madcourse.numad21su_emilycolladay.RviewAdapter;

public class LinksClick extends AppCompatActivity {
    //Creating the essential parts needed for a Recycler view to work: RecyclerView, Adapter, LayoutManager
    private ArrayList<ItemCard> linkList = new ArrayList<>();
    private RecyclerView rView;
    private RviewAdapter adapter;
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
                addItem(pos);
            }
        });
    }

    private void createRecyclerView() {


        rLayoutManager = new LinearLayoutManager(this);

        rView = findViewById(R.id.recycler_view);
        rView.setHasFixedSize(true);

        adapter = new RviewAdapter(linkList);
        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //attributions bond to the item has been changed
                itemList.get(position).onItemClick(position);

                rviewAdapter.notifyItemChanged(position);
            }

            @Override
            public void onCheckBoxClick(int position) {
                //attributions bond to the item has been changed
                itemList.get(position).onCheckBoxClick(position);

                rviewAdapter.notifyItemChanged(position);
            }
        };
        rviewAdapter.setOnItemClickListener(itemClickListener);

        recyclerView.setAdapter(rviewAdapter);
        recyclerView.setLayoutManager(rLayoutManger);


    }

    private void addItem(int position) {
        itemList.add(position, new ItemCard(R.drawable.empty, "No Logo item", "Item id: " + Math.abs(new Random().nextInt(100000)), false));
        Toast.makeText(getApplicationContext(), "Add an item", Toast.LENGTH_SHORT).show();

        rviewAdapter.notifyItemInserted(position);
    }
}