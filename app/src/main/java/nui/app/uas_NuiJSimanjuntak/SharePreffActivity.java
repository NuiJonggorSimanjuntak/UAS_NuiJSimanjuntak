package nui.app.uas_NuiJSimanjuntak;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class SharePreffActivity extends AppCompatActivity {

    ActionBar aB;

    EditText et1;
    ImageView btnsave, btnshow;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedEditor;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_preff);

        aB = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context = this;

        btnshow = findViewById(R.id.btn_show);
        btnsave = findViewById(R.id.btn_save);

        et1 = findViewById(R.id.et_input);

        sharedPreferences = getSharedPreferences("data_share_preff", MODE_PRIVATE);
        sharedEditor = sharedPreferences.edit();

        btnsave.setOnClickListener(view -> {
            String input = et1.getText().toString();
            if (!input.equals("")) {
                sharedEditor.putString("INPUT", input);
                sharedEditor.commit();

                Intent intent = new Intent(context, TampilActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(context, "Silakan Isi Dulu!", Toast.LENGTH_LONG).show();
            }
        });

        btnshow.setOnClickListener(view -> {
            sharedEditor.remove("INPUT");
            sharedEditor.commit();

            Intent intent = new Intent(context, TampilActivity.class);
            startActivity(intent);
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