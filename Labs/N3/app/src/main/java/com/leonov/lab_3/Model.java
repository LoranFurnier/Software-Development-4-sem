package com.leonov.lab_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.leonov.lab_3.model.Student;

import java.util.List;


public class Model extends BaseAdapter
{
    Context context;
    LayoutInflater inflater;
    List<Student> list;
    public static int current_position=0;

    public Model(Context context, List<Student> l) {

        this.context = context;
        this.list=l;
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        TextView name;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.list, parent, false);
        name = (TextView) itemView.findViewById(R.id.txt);
        name.setText(this.list.get(position).getFIO()+" "+this.list.get(position).getDate().toString());

        return itemView;
    }
}