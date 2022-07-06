package nui.app.uas_NuiJSimanjuntak;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class AlertActivity extends AppCompatActivity {

    ActionBar aB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        aB = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.buttonSucces).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSuccesDialog();
            }
        });

        findViewById(R.id.buttonWarning).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showWarningDialog();
            }
        });

        findViewById(R.id.buttonError).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showErrorDialog();
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

    private void showSuccesDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(AlertActivity.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(AlertActivity.this).inflate(
                R.layout.layout_succes_dialog,
                (ConstraintLayout) findViewById(R.id.layoutDialogContainer)
        );
        builder.setView(view);
        ((TextView) view.findViewById(R.id.textTitle)).setText(getResources().getString(R.string.succes_title));
        ((TextView) view.findViewById(R.id.textMessage)).setText(getResources().getString(R.string.dummy_text));
        ((TextView) view.findViewById(R.id.buttonAction)).setText(getResources().getString(R.string.okay));
        ((ImageView) view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.success);

        final  AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.buttonAction).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        if (alertDialog.getWindow()!= null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

    private void showWarningDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(AlertActivity.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(AlertActivity.this).inflate(
                R.layout.layout_warning_dialog,
                (ConstraintLayout) findViewById(R.id.layoutDialogContainer)
        );
        builder.setView(view);
        ((TextView) view.findViewById(R.id.textTitle)).setText(getResources().getString(R.string.succes_title));
        ((TextView) view.findViewById(R.id.textMessage)).setText(getResources().getString(R.string.dummy_text));
        ((TextView) view.findViewById(R.id.buttonYes)).setText(getResources().getString(R.string.yes));
        ((TextView) view.findViewById(R.id.buttonNo)).setText(getResources().getString(R.string.no));
        ((ImageView) view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.ic_warning);

        final  AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.buttonYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                Toast.makeText(AlertActivity.this, "Yes", Toast.LENGTH_SHORT).show();
            }
        });

        view.findViewById(R.id.buttonNo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                Toast.makeText(AlertActivity.this, "No", Toast.LENGTH_SHORT).show();
            }
        });

        if (alertDialog.getWindow()!= null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

    private void showErrorDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(AlertActivity.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(AlertActivity.this).inflate(
                R.layout.layout_error_dialog,
                (ConstraintLayout) findViewById(R.id.layoutDialogContainer)
        );
        builder.setView(view);
        ((TextView) view.findViewById(R.id.textTitle)).setText(getResources().getString(R.string.succes_title));
        ((TextView) view.findViewById(R.id.textMessage)).setText(getResources().getString(R.string.dummy_text));
        ((TextView) view.findViewById(R.id.buttonAction)).setText(getResources().getString(R.string.okay));
        ((ImageView) view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.ic_error);

        final  AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.buttonAction).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        if (alertDialog.getWindow()!= null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }
}




