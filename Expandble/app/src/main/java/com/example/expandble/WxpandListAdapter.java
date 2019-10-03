package com.example.expandble;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FATHUR on 7/6/2017.
 */

class ExpandListAdapter extends BaseExpandableListAdapter{
//menwariskan class BaseExpandableListAdapter



    private Context context;
    private ArrayList<Grup> grups;

    //deklarasi var context dan groups




    public ExpandListAdapter(Context context, ArrayList<Grup> grups) {
        this.context = context;
        this.grups = grups;

        //constructor
    }


    @Override
    public Object getChild(int grupPosition, int childPosition) {


        ArrayList<Child> childList = grups.get(grupPosition).getItem();

        return childList.get(childPosition);

        //mengambil nilai atau value dari child
    }



    @Override
    public long getChildId(int grupPosition, int childPosition) {
        return childPosition;
        //mengambil id dari child
    }

    @Override
    public View getChildView(int grupPosition, int childPosition, boolean isLastChild,
                             View convertView, ViewGroup parent) {

        Child child = (Child)getChild(grupPosition,childPosition);
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)context
                    .getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.child_item,null);

        }

        TextView textView = (TextView)convertView.findViewById(R.id.child_konten);

        String text = child.getNama();
        textView.setText(text);

        //menampilkan data ke view layout child_item.xml
        return convertView;
    }

    @Override
    public int getGroupCount() {
        return grups.size();
        //mengambil nilai atau value dari jumlah grup
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        List<Child> child ;
        child = grups.get(groupPosition).getItem();
        //Mengambil jumlah child berdasarkan grup tertentu
        return child.size();
    }

    @Override
    public Object getGroup(int groupPosition) {

        // Mengambil data yang terkait object grup
        return grups.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
//Mengambil id yang terkait grup
        return groupPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
        //Menunjukan apakah id dari grup dan child stabil terkait perubahan data di dalamnya
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        Grup grup = (Grup)getGroup(groupPosition);

        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)
                    context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.grup_item,null);

            TextView textView = (TextView)convertView.findViewById(R.id.grup_header);
            String text = grup.getNama();

            textView.setText(text);


        }


        // //menampilkan data ke view layout grup_item.xml
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
        //Menunjukan apakah posisi child tertentu dapat di selectable
    }
}