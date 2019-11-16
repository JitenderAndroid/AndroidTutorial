package com.jitenderkumar.demoducat.database;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jitenderkumar.demoducat.R;

public class PatientRegistration extends AppCompatActivity {

    PatientOperations patientOperations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_registration);

        final EditText editName = findViewById(R.id.edit_name);
        final EditText editAge = findViewById(R.id.edit_age);
        final EditText editCity = findViewById(R.id.edit_city);
        final EditText editGender = findViewById(R.id.edit_gender);
        final EditText editDob = findViewById(R.id.edit_dob);

        initDb();
        ((Button)findViewById(R.id.button_submit)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                patientOperations.addPatient(new PatientData("",
                        editName.getText().toString().trim(),
                        editAge.getText().toString().trim(),
                        editDob.getText().toString().trim(),
                        editCity.getText().toString().trim(),
                        editGender.getText().toString().trim()));

                startActivity(new Intent(PatientRegistration.this, PatiemtsListActivity.class));
            }
        });
    }

    void initDb() {
        patientOperations = new PatientOperations(this);
        patientOperations.open();
        //patientOperations.upgrade();
    }
}
