package com.example.examand1;

import android.os.Bundle;
import android.view.Menu;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends OptionsMenu {

    private Toolbar toolbar;
    private RecyclerView mRecyclerView;
    private MainActivityAdapter dataAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.front_images);
        mRecyclerView.hasFixedSize();


        // LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
      //  manager.setOrientation(GridLayoutManager.VERTICAL);
        getPhoto();


    }

    public void getPhoto(){
        ArrayList<FrontPhoto> imagelist = new ArrayList<>();
        imagelist.add(new FrontPhoto(R.drawable.pic1));
        imagelist.add(new FrontPhoto(R.drawable.pic5));
        imagelist.add(new FrontPhoto(R.drawable.pic3));
        imagelist.add(new FrontPhoto(R.drawable.pic6));
        dataAdapter = new MainActivityAdapter(this, imagelist);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(dataAdapter);


    }




    public void onBackPressed() {
// empty so nothing happens
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


   }