package com.banjir.info.infobanjir;

import android.content.Intent;
import android.content.SyncAdapterType;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class first_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
    }

    public void perlis_click(View view) {
        Intent intent = new Intent(this, perlis_activity.class);
        startActivity(intent);
    }

    public void kedah_click(View view) {
        Intent intent = new Intent(this, kedah_activity.class);
        startActivity(intent);
    }

    public void perak_click(View view) {
        Intent intent = new Intent(this, perak_activity.class);
        startActivity(intent);
    }

    public void selangor_click(View view) {
        Intent intent = new Intent(this, selangor_activity.class);
        startActivity(intent);
    }

    public void n9_click(View view) {
        Intent intent = new Intent(this, n9_activity.class);
        startActivity(intent);
    }

    public void melaka_click(View view) {
        Intent intent = new Intent(this, melaka_activity.class);
        startActivity(intent);
    }

    public void johor_click(View view) {
        Intent intent = new Intent(this, johor_activity.class);
        startActivity(intent);
    }

    public void pahang_click(View view) {
        Intent intent = new Intent(this, pahang_activity.class);
        startActivity(intent);
    }

    public void terengganu_click(View view) {
        Intent intent = new Intent(this, terengganu_activity.class);
        startActivity(intent);
    }

    public void kelantan_click(View view) {
        Intent intent = new Intent(this, kelantan_activity.class);
        startActivity(intent);
    }

    public void labuan_click(View view) {
        Intent intent = new Intent(this, labuan_activity.class);
        startActivity(intent);
    }

    public void kl_click(View view) {
        Intent intent = new Intent(this, kl_activity.class);
        startActivity(intent);
    }

    public void sabah_click(View view) {
        Intent intent = new Intent(this, sabah_activity.class);
        startActivity(intent);
    }
    public void sarawak_click(View view) {
        Intent intent = new Intent(this, sarawak_activity.class);
        startActivity(intent);
    }

    public void pulaupinang_click(View view) {
        Intent intent = new Intent(this, pulaupinang_activity.class);
        startActivity(intent);
    }

    public void exit_btn(View view) {
        finish();
        System.exit(0);
    }
}
