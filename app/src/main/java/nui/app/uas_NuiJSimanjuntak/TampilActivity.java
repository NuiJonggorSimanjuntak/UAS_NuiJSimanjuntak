package nui.app.uas_NuiJSimanjuntak;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class TampilActivity extends AppCompatActivity {

    ActionBar aB;

    TextView tvUser;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);

        aB = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvUser = findViewById(R.id.hasil);

        // string name bisa disimpan di 1 constant class atau di global variable
        sharedPreferences = getSharedPreferences("data_share_preff", MODE_PRIVATE);

        tvUser.setText(sharedPreferences.getString("INPUT", "-"));

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