package com.vk.agen.agen.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

import com.vk.agen.agen.DB.Company;
import com.vk.agen.agen.DB.CompanyDataSource;
import com.vk.agen.agen.R;

import java.util.List;

public class CompanyListActivity extends AppCompatActivity {

    CompanyDataSource companyDataSource;
    List<Company> elements;
    ListView company_list_view;
    ArrayAdapter<Company> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_company_list );

        companyDataSource = new CompanyDataSource(getApplicationContext());
        companyDataSource.open();

        elements = companyDataSource.getAllCompanys();
        company_list_view = (ListView) findViewById(R.id.company_list_view);

        adapter = new ArrayAdapter<Company>
                (this, android.R.layout.simple_list_item_1, elements);

        company_list_view.setAdapter(adapter);
        company_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle(elements.get(position).getCompany());
                builder.setMessage(elements.get(position).getLocation());
                builder.show();
            }
        });

        registerForContextMenu(company_list_view);
    }
}
