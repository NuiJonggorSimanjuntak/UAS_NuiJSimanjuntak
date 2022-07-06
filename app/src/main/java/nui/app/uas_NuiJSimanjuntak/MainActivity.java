package nui.app.uas_NuiJSimanjuntak;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ActionBar aB;

    private ImageView btnMaps, btnKamera, btnListView, btnSms, btnAsynctask, btnNetwork, btnToast, btnAlert, btnLocalDB, btnTabView, btnSharePreff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMaps = findViewById(R.id.btn_maps);
        btnKamera = findViewById(R.id.btn_kamera);
        btnListView = findViewById(R.id.btn_listView);
        btnSms = findViewById(R.id.btn_sms);
        btnAsynctask = findViewById(R.id.btn_asynctask);
        btnNetwork = findViewById(R.id.btn_network);
        btnToast = findViewById(R.id.btn_toast);
        btnAlert = findViewById(R.id.btn_alert);
        btnLocalDB = findViewById(R.id.btn_localdb);
        btnTabView = findViewById(R.id.btn_tabview);
        btnSharePreff = findViewById(R.id.btn_sharepreff);

        aB = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MapsActivity.class));
                //atau
//                Intent maps = new Intent(getApplicationContext(), MapsActivity.class);
//                startActivity(maps);
            }
        });

        btnKamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), KameraActivity.class));
            }
        });

        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ListViewActivity.class));
            }
        });

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), KirimSmsActivity.class));
            }
        });

        btnAsynctask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AsyncTaskActivity.class));
            }
        });

        btnNetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ListViewActivity.ReadActivity.class));
            }
        });

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ToastActivity.class));
            }
        });

        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AlertActivity.class));
            }
        });

        btnLocalDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LocalDBActivity.class));
            }
        });

        btnTabView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TabViewActivity.class));
            }
        });

        btnSharePreff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SharePreffActivity.class));
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}