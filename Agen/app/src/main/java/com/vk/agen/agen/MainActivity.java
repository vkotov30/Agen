package com.vk.agen.agen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.vk.agen.agen.UI.CompanyListActivity;

public class MainActivity extends AppCompatActivity {

    Button btn_comp_list, btn_planing, btn_events, btn_report, btn_dumps_comp, btn_contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        btn_comp_list = (Button) findViewById( R.id.btn_comp_list );
        btn_comp_list.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CompanyListActivity.class);
                startActivity(intent);
            }
        } );
    }
}
