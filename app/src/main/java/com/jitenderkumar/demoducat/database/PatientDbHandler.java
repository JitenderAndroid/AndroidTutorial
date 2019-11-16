package com.jitenderkumar.demoducat.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PatientDbHandler extends SQLiteOpenHelper {

    public static final String TABLE_PATIENT = "patientsTable";
    public static final String COLUMN_ID = "empId";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_DOB = "dob";
    public static final String COLUMN_city = "city";
    public static final String COLUMN_GENDER = "gender";
    private static final String DATABASE_NAME = "patients.db";
    public static final int DATABASE_VERSION = 1;

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_PATIENT + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_AGE + " TEXT, " +
                    COLUMN_GENDER + " TEXT, " +
                    COLUMN_DOB + " TEXT, " +
                    COLUMN_city + " TEXT " +
                    ")";


    public PatientDbHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PATIENT);
        db.execSQL(TABLE_CREATE);
    }
}