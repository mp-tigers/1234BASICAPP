package basic.sachet.com.sqlite;

import basic.sachet.com.beans.User;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StoreUserDetails extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "userDetails";

    public StoreUserDetails(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_USER_TAB = "CREATE TABLE USER_DTLS(USER_ID TEXT, USER_NAME TEXT NOT NULL,"+
                                    "USER_DOB DATE, USER_EMAIL TEXT, USER_PIC_URL TEXT, USER_ACCOUNT_ID TEXT NOT NULL,"+
                                    "USER_ACCOUNT_TYPE CHARACTER NOT NULL)";

        db.execSQL(CREATE_USER_TAB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS USER_DTLS");

        // Create tables again
        onCreate(db);
    }

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("USER_NAME", user.getUserName());
        //values.put("USER_ID", user.getUserId());
        if(user.getDob() != null)
            values.put("USER_DOB",user.getDob().toString());
        values.put("USER_EMAIL",user.getEmail());
        values.put("USER_PIC_URL",user.getPicUrl());
        values.put("USER_ACCOUNT_ID",user.getAccountId());
        values.put("USER_ACCOUNT_TYPE", user.getAccountType());

        // Inserting Row

        db.insert("USER_DTLS", null, values);
        db.close(); // Closing database connection
    }

    // Getting single user details
    User getContact(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("USER_DTLS", new String[] { "USER_NAME",
                        "USER_ID", "USER_DOB","USER_EMAIL","USER_PIC_URL","USER_ACCOUNT_ID","USER_ACCOUNT_TYPE"}, "USER_ACCOUNT_ID = ?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        DateFormat formatter ;
        Date date = null;
        formatter = new SimpleDateFormat("dd-MMM-yy");
        try {
            date = formatter.parse(cursor.getString(2));
        }catch(ParseException e)
        {
            e.printStackTrace();
        }
        User user = new User(cursor.getString(0),cursor.getString(1),date,cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6));
        // return contact
        return user;
    }

}
