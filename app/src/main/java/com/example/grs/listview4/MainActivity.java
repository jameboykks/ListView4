package com.example.grs.listview4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    List<String> listdataHeader;
    HashMap<String,List<String>> listdataChild;
    CustomExpandableListView customExpandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        customExpandableListView = new CustomExpandableListView(MainActivity.this,listdataHeader,listdataChild);
        expandableListView.setAdapter(customExpandableListView);
        Click_group();
        Click_child();
        Close_group();
        Open_group();
    }

    private void Open_group() {
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(MainActivity.this,listdataHeader.get(groupPosition)+" Mở",Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void Close_group() {
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(MainActivity.this,listdataHeader.get(groupPosition)+" Đóng",Toast.LENGTH_SHORT).show();


            }
        });
    }

    private void Click_child() {
    expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
        @Override
        public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long l) {
            Toast.makeText(MainActivity.this,listdataChild.get(listdataHeader.get(groupPosition)).get(childPosition),Toast.LENGTH_SHORT).show();
            return false;
        }
    });
    }

    private void Click_group() {
    expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
        @Override
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long l) {
            Toast.makeText(MainActivity.this,listdataHeader.get(groupPosition),Toast.LENGTH_SHORT).show();

            return false;
        }
    });
    }

    private void addControl() {
        expandableListView = findViewById(R.id.expandleListView);
        listdataHeader = new ArrayList<>();
        listdataChild = new HashMap<>();

        listdataHeader.add("Vegetables");
        listdataHeader.add("Fruits");
        listdataHeader.add("Herbs");

        List<String> vegetables = new ArrayList<String>();
        vegetables.add("Squash");
        vegetables.add("Zucchini");
        vegetables.add("Carrots");

        List<String> fruits = new ArrayList<String>();
        fruits.add("Tomato");
        fruits.add("Banana");
        fruits.add("Cherry");

        List<String> herbs = new ArrayList<String>();
        herbs.add("Grass");
        herbs.add("Plants");
        herbs.add("Flora");

        listdataChild.put(listdataHeader.get(0),vegetables);
        listdataChild.put(listdataHeader.get(1),fruits);
        listdataChild.put(listdataHeader.get(2),herbs);
    }
}
