package com.jitenderkumar.demoducat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jitenderkumar.netmedssample.activities.EditPatientActivity;
import com.jitenderkumar.netmedssample.models.PatientData;

import java.util.ArrayList;

public class UserAdapter extends ArrayAdapter<PatientData> {
    // View lookup cache
    Context context;
    private static class ViewHolder {
        TextView name;
        TextView age;
        TextView city;
    }

    public UserAdapter(Context context, ArrayList<PatientData> users) {
        super(context, R.layout.item_patient, users);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final PatientData user = getItem(position);
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_patient, parent, false);

            viewHolder.name = (TextView) convertView.findViewById(R.id.text_name);
            viewHolder.age = (TextView) convertView.findViewById(R.id.text_age);
            viewHolder.city = (TextView) convertView.findViewById(R.id.text_city);
            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, EditPatientActivity.class).putExtra("id",user.getId()));
            }
        });

        viewHolder.name.setText(user.getName());
        viewHolder.city.setText(user.getCity());
        viewHolder.age.setText(user.getAge());

        return convertView;
    }
}