// Every Data Base Related Work Are Done Through this common Java file
package com.example.sqlitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

// Extend from MySql Class
// Why : We get Oncreate & OnUpgrade
public class MyDBHelper extends SQLiteOpenHelper {
    // Context matlab Reference chahiye
    // cursor factory not required ,hatado use bhi parameters me se
    // Cursor factory is required for sub cursor , jab hum select query lagate hai
    // @Nullable Hatoda do Sabb , kyuki hum activty se data nahi mangayeenge
    // data base has a verson , by creatiing 1st time it has given version 1 , if tabble related or data related data is change kiya hoi toh version update karna padega

    // assign name variable
    // final use isliye ki in future koi bhi data name change na karde isliye
    // static isliye kyuki koi iss class ka object call hoga dusri class se jab jab call kiya jaye
    // Static variable asssign pehele hi hojayega
    private static final String DATABASE_NAME ="ContactDB";
    private  static final int DATABASE_VERSION = 1;
    private static final String TABLE_CONTACT="contacts";
    // Create Table Variables
    private static final String KEY_ID = "id";// Table column id naam thi banse
    private static final String KEY_NAME = "name"; // Table Column name naam thi banse
    private static final String KEY_PHONE_NO = "phone_no"; // same phone_no naam thi banse
    public MyDBHelper( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // first time jab DB create hoga to Oncreate Call Hoga
    // DB is collection of Multiple Tables && Tables consisting of multiple Rows and Column
    // CREATE TABLE contacts (id INTEGER PRIMARY AUTOINCREMENT , name TEXT , phone_no TEXT
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create table in DB
        // Only use in when Sql execute qurrey daal ni hai
        // Use of SQL execute query  to  create , delete ,insert,update
        // COlumn making with name and key values means : NOTNULL ,   etc..
        db.execSQL("CREATE TABLE "+TABLE_CONTACT +
                "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT," + KEY_PHONE_NO + " TEXT" + ")");// Not return cursor
        // selection query is not used becuase it throws query data

        // Data base Requirement  , here we are getting DB reference , so on other classes if we have to get database reference we must have to write this code
       //DB open
        SQLiteDatabase database = this.getWritableDatabase(); //this.getWritableDatabase   open DB get readable or Writable
       // database.update & many more wwe can use DB methods
        // for closing DB
        database.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // if DB is change or upgrade , it update , we have to drop dipple and re generate table & ReCall Oncreate method to create a new upgraded table

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACT);
        onCreate(db);


    } // Override for upper getting method & making Constructer
    // to add value in table
    public void  addContact(String name,String phone_no)
    {
        SQLiteDatabase db = this.getWritableDatabase(); // why writable Beacuse to update ,delte, insert

        ContentValues values = new ContentValues();
        values.put(KEY_PHONE_NO,phone_no);
        values.put(KEY_NAME,name);
        db.insert(TABLE_CONTACT,null,values) ;      //nullColumn to  insert null value
    }

}
