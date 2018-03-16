package com.example.grs.listview4;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Gr's on 03/15/18.
 */

public class CustomExpandableListView extends BaseExpandableListAdapter{
    Context context;
    List<String> listHeader;
    HashMap<String,List<String>>listChild;

    public CustomExpandableListView(Context context, List<String> listHeader, HashMap<String, List<String>> listChild) {
        this.context = context;
        this.listHeader = listHeader;
        this.listChild = listChild;
    }

    @Override
    //Get ra listHeader
    public int getGroupCount() {
        return listHeader.size();
    }
    //Get ra vi tri cua group
    @Override
    public int getChildrenCount(int groupPosition) {
        return listChild.get(listHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listChild.get(listHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean b, View converview, ViewGroup viewGroup) {
        String headerTitle = (String) getGroup(groupPosition);
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        converview = inflater.inflate(R.layout.group_view,null);
        TextView txtheader = converview.findViewById(R.id.textviewHeader);
        txtheader.setText(headerTitle);
        return converview;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View converview, ViewGroup viewGroup) {
        String item = (String) getChild(groupPosition,childPosition);
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        converview = inflater.inflate(R.layout.child_view,null);
        TextView txtitem = converview.findViewById(R.id.textviewChild);
        txtitem.setText(item);
        return converview;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
