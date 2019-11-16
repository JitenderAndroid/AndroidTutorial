package com.jitenderkumar.demoducat.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.jitenderkumar.demoducat.models.PatientData;

import java.util.ArrayList;
import java.util.List;

public class PatientOperations {
    public static final String LOGTAG = "EMP_MNGMNT_SYS";

    private static final String[] allColumns = {
            PatientDbHandler.COLUMN_ID,
            PatientDbHandler.COLUMN_NAME,
            PatientDbHandler.COLUMN_AGE,
            PatientDbHandler.COLUMN_GENDER,
            PatientDbHandler.COLUMN_DOB,
            PatientDbHandler.COLUMN_city

    };
    SQLiteOpenHelper dbhandler;
    SQLiteDatabase database;

    public PatientOperations(Context context) {
        dbhandler = new PatientDbHandler(context);
    }

    public void open() {
        Log.i(LOGTAG, "Database Opened");
        database = dbhandler.getWritableDatabase();
        }

    public void close() {
        Log.i(LOGTAG, "Database Closed");
        dbhandler.close();
    }

    public void upgrade() {
        dbhandler.onUpgrade(database, PatientDbHandler.DATABASE_VERSION, 2);
    }

    public PatientData addPatient(PatientData patientData) {
        ContentValues values = new ContentValues();

        values.put(PatientDbHandler.COLUMN_NAME, patientData.getName());
        values.put(PatientDbHandler.COLUMN_AGE, patientData.getAge());
        values.put(PatientDbHandler.COLUMN_GENDER, patientData.getGender());
        values.put(PatientDbHandler.COLUMN_city, patientData.getCity());
        values.put(PatientDbHandler.COLUMN_DOB, patientData.getDob());

        long insertid = database.insert(PatientDbHandler.TABLE_PATIENT, null, values);
        patientData.setId(insertid+"");
        return patientData;
    }

    // Getting single Employee
    public PatientData getPAtientData(long id) {
        Cursor cursor = database.query(PatientDbHandler.TABLE_PATIENT, allColumns, PatientDbHandler.COLUMN_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

         PatientData e = new PatientData(Long.parseLong(cursor.getString(0))+"", cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
        return e;
    }

    public List<PatientData> getAllPatients() {
        Cursor cursor = database.query(PatientDbHandler.TABLE_PATIENT, allColumns, null, null, null, null, null);

        List<PatientData> patients = new ArrayList<>();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                PatientData patientData = new PatientData();

                patientData.setId(cursor.getLong(cursor.getColumnIndex(PatientDbHandler.COLUMN_ID))+"");
                patientData.setName(cursor.getString(cursor.getColumnIndex(PatientDbHandler.COLUMN_NAME)));
                patientData.setDob(cursor.getString(cursor.getColumnIndex(PatientDbHandler.COLUMN_DOB)));
                patientData.setAge(cursor.getString(cursor.getColumnIndex(PatientDbHandler.COLUMN_AGE)));
                patientData.setCity(cursor.getString(cursor.getColumnIndex(PatientDbHandler.COLUMN_city)));
                patients.add(patientData);
            }
        }
        return patients;
    }

    public int updatePatient(PatientData patientData) {
        ContentValues values = new ContentValues();
        values.put(PatientDbHandler.COLUMN_AGE, patientData.getAge());
        values.put(PatientDbHandler.COLUMN_city, patientData.getCity());
        values.put(PatientDbHandler.COLUMN_DOB, patientData.getDob());
        values.put(PatientDbHandler.COLUMN_NAME, patientData.getName());
        values.put(PatientDbHandler.COLUMN_GENDER, patientData.getGender());

        return database.update(PatientDbHandler.TABLE_PATIENT, values,
                PatientDbHandler.COLUMN_ID + "=?", new String[]{String.valueOf(patientData.getId())});
    }

}