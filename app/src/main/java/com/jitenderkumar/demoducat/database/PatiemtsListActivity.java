package com.jitenderkumar.demoducat.database;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.jitenderkumar.demoducat.R;
import com.jitenderkumar.demoducat.UserAdapter;
import com.jitenderkumar.demoducat.models.PatientData;

import java.util.ArrayList;

public class PatiemtsListActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patiemts_list);

        listView = findViewById(R.id.list_Patients);
        initPAtientsList();
    }

    private void initPAtientsList() {
        PatientOperations patientOperations = new PatientOperations(this);
        patientOperations.open();

        ArrayList<PatientData> patientData = (ArrayList<PatientData>) patientOperations.getAllPatients();
        UserAdapter userAdapter = new UserAdapter(this, patientData);
        listView.setAdapter(userAdapter);
    }
}
