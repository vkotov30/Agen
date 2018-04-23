package com.vk.agen.agen.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class CompanyDataSource {

    private DBHelper dbHelper;
    private SQLiteDatabase database;

    public CompanyDataSource(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    private String[] companyAllColumn = {DBHelper.KEY_ID_COMPANY, DBHelper.KEY_COMPANY_NAME,
            DBHelper.KEY_LOCATION, DBHelper.KEY_USES_BASE, DBHelper.KEY_SUBWAY_STATION,
            DBHelper.KEY_RESPONSIBLE_USER, DBHelper.KEY_RU_PHONE, DBHelper.KEY_RU_EMAIL,
            DBHelper.KEY_UPDATED_STATUS };

    ///////////////////////////////////////////////////////////////////////////
    // add, edit, delete Company
    ///////////////////////////////////////////////////////////////////////////
    public Company addCompany(String company, String location, String uses_base, String subway_station,
                           String responsible_user, String ru_phone,String ru_email, int update_status) {

        ContentValues values = new ContentValues();
        values.put(DBHelper.KEY_COMPANY_NAME, company);
        values.put(DBHelper.KEY_LOCATION, location);
        values.put(DBHelper.KEY_USES_BASE, uses_base);
        values.put(DBHelper.KEY_SUBWAY_STATION, subway_station);
        values.put(DBHelper.KEY_RESPONSIBLE_USER, responsible_user);
        values.put(DBHelper.KEY_RU_PHONE, ru_phone);
        values.put(DBHelper.KEY_RU_EMAIL, ru_email);
        values.put(DBHelper.KEY_UPDATED_STATUS, update_status);

        long insertId = database.insert(DBHelper.TABLE_COMPANYS, null,
                values);
        Company newCompany = new Company();
        newCompany.setCompany( company );
        newCompany.setLocation( location );
        newCompany.setUses_bases( uses_base );
        newCompany.setSubway_station( subway_station );
        newCompany.setResponsible_user( responsible_user );
        newCompany.setPhone( ru_phone );
        newCompany.setEmail( ru_email );
        newCompany.setUpdated_status( update_status );
        newCompany.setId(insertId);

        return newCompany;
    }

    public void editCompany(long id, String company, String location, String uses_base, String subway_station,
                            String responsible_user, String ru_phone,String ru_email, int update_status) {

        ContentValues editedCompany = new ContentValues();
        editedCompany.put(DBHelper.KEY_ID_COMPANY, id);
        editedCompany.put(DBHelper.KEY_COMPANY_NAME, company);
        editedCompany.put(DBHelper.KEY_LOCATION, location);
        editedCompany.put(DBHelper.KEY_USES_BASE, uses_base);
        editedCompany.put(DBHelper.KEY_SUBWAY_STATION, subway_station);
        editedCompany.put(DBHelper.KEY_RESPONSIBLE_USER, responsible_user);
        editedCompany.put(DBHelper.KEY_RU_PHONE, ru_phone);
        editedCompany.put(DBHelper.KEY_RU_EMAIL, ru_email);
        editedCompany.put(DBHelper.KEY_UPDATED_STATUS, update_status);

        database.update(dbHelper.TABLE_COMPANYS,
                editedCompany,
                dbHelper.KEY_ID_COMPANY + "=" + id,
                null);
    }

    public void deleteCompany(Company company) {
        long id = company.getId();
        database.delete(DBHelper.TABLE_COMPANYS, DBHelper.KEY_ID_COMPANY
                + " = " + id, null);
    }

    ///////////////////////////////////////////////////////////////////////////
    // 
    ///////////////////////////////////////////////////////////////////////////

    public List<Company> getAllCompanys() {
        List<Company> companys = new ArrayList<Company>();

        Cursor cursor = database.query(DBHelper.TABLE_COMPANYS,
                companyAllColumn, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Company company = cursorToCompany(cursor);
            companys.add(company);
            cursor.moveToNext();
        }
        cursor.close();
        return companys;
    }

    private Company cursorToCompany(Cursor cursor) {
        Company company = new Company();
        company.setId(cursor.getLong(0));
        company.setCompany(cursor.getString(1));
        company.setLocation(cursor.getString(2));
        company.setUses_bases( cursor.getString(3) );
        company.setSubway_station( cursor.getString(4) );
        company.setResponsible_user( cursor.getString(5) );
        company.setPhone( cursor.getString(6) );
        company.setEmail( cursor.getString(7) );
        company.setUpdated_status( cursor.getInt(8) );

        return company;
    }
}
