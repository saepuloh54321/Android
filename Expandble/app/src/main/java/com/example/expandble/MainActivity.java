package com.example.expandble;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.Toast;

import java.util.ArrayList;


/*
Fathurrahman (okedroid.com)
 */
public class MainActivity extends AppCompatActivity {


    private ExpandableListAdapter expandableListAdapter;
    private ArrayList<Grup> grupExpandList;
    private ExpandableListView expandableListView;
    private Object ExpandableListAdapter;
    //mendeklarasikan object Expandable ListAdapter ,ArrayList dan ExpandableListView


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().setTitle("Expandable ListView");
        getSupportActionBar().setSubtitle("Belajar di okedroid.com");


        expandableListView = (ExpandableListView) findViewById(R.id.exp_list_item);
        //menginisialisasi object dari container ExpandableListView yang berada di activity_main.xml


        grupExpandList = inputData();
        //memberikan nilai pada object groupExpandList berdasarkan method inputData()

        expandableListAdapter = new ExpandListAdapter(this, grupExpandList);
        //menginstansiasi object dari class Adapter ExpandListAdapter

        expandableListView.setAdapter(expandableListAdapter);
        //mensetting nilai berdasarkan  objectexpandableListAdapter
        // dari method di object  expandableListView

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int grupPosition, int childPosition, long id) {

                String namagrup = grupExpandList.get(grupPosition).getNama();

                ArrayList<Child> childList = grupExpandList.get(grupPosition).getItem();

                String namachild = childList.get(childPosition).getNama();

                tampilPesan(namagrup+ " = "+namachild);

                //method dari object  expandableListView yang dimana ketika di klik akan menampilkan
                //data dari Child yang ada di dalam Grup
                //serta menampilkan pesan text Toast

                return false;

            }

        });


        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int grupPosition) {
                String namagrup = grupExpandList.get(grupPosition).getNama();
                tampilPesan(namagrup+" Di buka ");
                //method untuk membuka list data dari Child

            }
        });


        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                String namagrup = grupExpandList.get(groupPosition).getNama();
                tampilPesan(namagrup+" Di tutup");
                //method untuk menutup list data dari Child
            }
        });


    }







    public ArrayList<Grup> inputData() {
        //method untuk menginput data
        ArrayList<Grup> groupArrayList = new ArrayList<Grup>();
        ArrayList<Child> childArrayList ;

        //Setting Grup 1

        childArrayList = new ArrayList<Child>();
        Grup grup1 = new Grup();


        grup1.setNama("Nama Binatang");

        Child binatang1 = new Child();
        binatang1.setNama("Anjing");
        childArrayList.add(binatang1);


        Child binatang2 = new Child();
        binatang2.setNama("Kucing");
        childArrayList.add(binatang2);

        Child binatang3 = new Child();
        binatang3.setNama("Cicak");
        childArrayList.add(binatang3);

        //mensetting data object childArrayList dari object grup1
        grup1.setItem(childArrayList);

        //Setting Grup 2
        childArrayList = new ArrayList<Child>();

        Grup grup2 = new Grup();
        grup2.setNama("Bahasa Pemrograman");


        Child program1 = new Child();
        program1.setNama("Java");
        childArrayList.add(program1);

        Child program2 = new Child();
        program2.setNama("SQL");
        childArrayList.add(program2);

        Child program3 = new Child();
        program3.setNama("PHP");

        childArrayList.add(program3);

        //mensetting data object childArrayList dari object grup2
        grup2.setItem(childArrayList);

        //mendaftarkan ke object grup
        groupArrayList.add(grup1);
        groupArrayList.add(grup2);


        return groupArrayList;
    }


    public void tampilPesan(String pesan){
//method untuk menampilkan pesan text toast
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();

    }
}