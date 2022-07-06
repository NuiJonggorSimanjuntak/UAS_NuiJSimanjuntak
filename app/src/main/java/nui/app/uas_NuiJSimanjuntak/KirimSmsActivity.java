package nui.app.uas_NuiJSimanjuntak;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class KirimSmsActivity extends AppCompatActivity {

    ActionBar aB;

    private EditText etNoHp;
    private EditText etPesan;
    private ImageView btnPesanManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kirim_sms);

        etNoHp = findViewById(R.id.et_hp);
        etPesan = findViewById(R.id.et_pesan);
        btnPesanManager = findViewById(R.id.smsManager);

        aB = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnPesanManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kirimPesanManager();
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

    private void kirimPesanManager() {
        Uri uri = Uri.parse("smsto:" + etNoHp.getText().toString());
        Intent smsSIntent = new Intent(Intent.ACTION_SENDTO, uri);
        smsSIntent.putExtra("sms_body", etPesan.getText().toString());
        try {
            startActivity(smsSIntent);
        } catch (Exception e) {
            Toast.makeText(KirimSmsActivity.this, "Gagal Mengirim SMS...",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}