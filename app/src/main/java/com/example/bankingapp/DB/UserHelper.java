package com.example.bankingapp.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.bankingapp.DB.UserContract.UserEntry;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(8526,'Mali Yugal', 'yugalmali198@gmail.com','2158','7768884864', 10000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9705,'Patil Abhishek', 'patilabhishek@gmail.com','9868','8793603318', 2000)");
        db.execSQL("insert into " + TABLE_NAME + " values(6782,'Sharma Pankaj', 'pankajsharma@gmail.com','8876','8977451136', 9500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7685,'Parit Abhishek', 'paritabhishek@gmail.com','2178','7865478963', 5500)");
        db.execSQL("insert into " + TABLE_NAME + " values(6536,'Sharma Rohit', 'rohitsharma@gmail.com','4755','876654988', 8900)");
        db.execSQL("insert into " + TABLE_NAME + " values(5241,'Lohar Sandeep', 'sandeeplohar@gmail.com','5277','9995640038', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1474,'Narkhede Mayuri', 'harshika@gmail.com','6554','7896532451', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7667,'Bhojane Shubham', 'shubhambhojane@gmail.com','7358','9985214636', 20000)");
        db.execSQL("insert into " + TABLE_NAME + " values(8753,'Magare Rushikesh', 'rushikeshmagare@gmail.com','3255','9885117342', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(5322,'Petkar Prajwal', 'prajwalpetkar@gmail.com','7592','9307452108', 11500)");
        db.execSQL("insert into " + TABLE_NAME + " values(6218,'Patil Harshal', 'harshalpatil@gmail.com','7321','7756837521', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5437,'Langer Gaurav', 'gauravlanger@gmail.com','4487','6276554305', 3700)");
        db.execSQL("insert into " + TABLE_NAME + " values(3779,'Chavan Roshani', 'roshanichavan@gmail.com','5597','7889547661', 2000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9851,'Patil Pavan', 'pavanpatil@gmail.com','3233','9011675489', 9700)");
        db.execSQL("insert into " + TABLE_NAME + " values(4223,'Yadav Shubham', 'shubhamyadav@gmail.com','5589','6303527651', 4800)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}