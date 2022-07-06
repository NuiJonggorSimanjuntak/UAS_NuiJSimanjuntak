package nui.app.uas_NuiJSimanjuntak;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import nui.app.uas_NuiJSimanjuntak.R;

public class ToastActivity extends AppCompatActivity {

    ActionBar aB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        aB = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.btnToast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.toast_success, (ViewGroup) findViewById(R.id.custom_toast_id) );
                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(view);
                toast.show();
            }
        });

        findViewById(R.id.btnToast2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.toast_information, (ViewGroup) findViewById(R.id.custom_toast_id) );
                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(view);
                toast.show();
            }
        });

        findViewById(R.id.btnToast3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.toast_danger, (ViewGroup) findViewById(R.id.custom_toast_id) );
                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(view);
                toast.show();
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