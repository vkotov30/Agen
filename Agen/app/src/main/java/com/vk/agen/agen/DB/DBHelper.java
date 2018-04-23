package com.vk.agen.agen.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MainDB.db";
    public static final String TABLE_COMPANYS = "TableCompanys";

    public static final String KEY_ID_COMPANY = "_id";
    public static final String KEY_COMPANY_NAME = "Company";
    public static final String KEY_LOCATION = "Location";
    public static final String KEY_USES_BASE = "Uses_bases";
    public static final String KEY_SUBWAY_STATION = "Subway_station";
    public static final String KEY_RESPONSIBLE_USER = "Responsible_user";
    public static final String KEY_RU_PHONE = "Phone";
    public static final String KEY_RU_EMAIL = "Email";
    public static final String KEY_UPDATED_STATUS = "Updated_status";

//    public static final String TABLE_CONTACTS = "TableContacts";
//    public static final String KEY_ID_CONTACT = "_id";
//    public static final String KEY_PHONE = "Phone";
//    public static final String KEY_EMAIL = "Email";

    public DBHelper(Context context) {
        super( context, DATABASE_NAME, null, DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL( "CREATE TABLE " + TABLE_COMPANYS + "("
                + KEY_ID_COMPANY + " INTEGER PRIMARY KEY,"
                + KEY_COMPANY_NAME + "TEXT,"
                + KEY_LOCATION + "TEXT,"
                + KEY_USES_BASE + "TEXT,"
                + KEY_SUBWAY_STATION + "TEXT,"
                + KEY_RESPONSIBLE_USER + "TEXT,"
                + KEY_RU_PHONE + "TEXT,"
                + KEY_RU_EMAIL + "TEXT,"
                + KEY_UPDATED_STATUS + "INTEGER);");

//        db.execSQL("CREATE TABLE " + TABLE_CONTACTS + "("
//                + KEY_ID_CONTACT + " INTEGER PRIMARY KEY,"
//                + KEY_PHONE + "TEXT,"
//                + KEY_EMAIL + "TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPANYS );
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS );
        onCreate( db );
    }
}
