package com.jitenderkumar.demoducat.database;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jitenderkumar.demoducat.R;
import com.jitenderkumar.demoducat.models.PatientData;

public class EditPatientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_patient);

        initData();
    }

    private void initData() {
        String id = getIntent().getExtras().getString("id");

        if (id == null) return;

        final PatientOperations patientOperations = new PatientOperations(this);
        patientOperations.open();
        final PatientData patientData = patientOperations.getPAtientData(Long.valueOf(id));

        final EditText editName = findViewById(R.id.edit_name);
        final EditText editAge = findViewById(R.id.edit_age);
        final EditText editCity = findViewById(R.id.edit_city);
        final EditText editGender = findViewById(R.id.edit_gender);
        final EditText editDob = findViewById(R.id.edit_dob);

        editAge.setText(patientData.getAge());
        editName.setText(patientData.getName());
        editCity.setText(patientData.getCity());
        editDob.setText(patientData.getDob());

        ((Button)findViewById(R.id.button_submit)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                patientOperations.updatePatient(new PatientData(patientData.getId(),
                        editName.getText().toString().trim(),
                        editAge.getText().toString().trim(),
                        editDob.getText().toString().trim(),
                        editCity.getText().toString().trim(),
                        editGender.getText().toString().trim()));
                finish();
           }
        });

    }
}
