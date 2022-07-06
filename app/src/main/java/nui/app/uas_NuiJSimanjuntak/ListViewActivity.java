package nui.app.uas_NuiJSimanjuntak;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import nui.app.uas_NuiJSimanjuntak.adapter.DataDiriAdapter;
import nui.app.uas_NuiJSimanjuntak.adapter.ListAdapter;
import nui.app.uas_NuiJSimanjuntak.databinding.ActivityListViewBinding;
import nui.app.uas_NuiJSimanjuntak.model.DataDiriModel;

public class ListViewActivity extends AppCompatActivity {

    ActionBar aB;

    ActivityListViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        aB = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int[] imageId = {R.drawable.nui, R.drawable.josua,R.drawable.eky,
                R.drawable.marfel,R.drawable.abel, R.drawable.cristofer,
                R.drawable.frisca, R.drawable.estu, R.drawable.golan};

        String[] name = {"Nui J Simanjunta", "Josua Ferdy", "Eky Y M Simanjuntak",
                "Marfel Crisly", "Annabelle Quency", "Cristofer Hasudungan",
                "Frisca Tri Ananda", "Estu Renatalia", "Golan Ruli"};

        String[] lastMessage = {"Bams", "Jangkrik", "Ekong", "Brother",
                "Abel", "Cristo", "Fisca", "Estu", "Golpek"};

        String[] lastmsgTime = {"12.11 am", "01.11 pm", "02:11 am", "01:11 pm" ,
                "08:11 pm", "10:41 pm", "07:11 pm" , "08:11 pm", "02:11 am"};

        String[] phoneNo = {"081111", "082222" , "083333" , "084444" ,
                "085555" , "086666" , "087777" , "088888" , "089999"};

        String[] country = {"Indonesia", "Jamaica" , "Jepang" , "Amerika Serikat" ,
                "Israel" , "India" , "Afrika Selatan" , "Arab Saudi" , "Korea Selatan"};

        ArrayList<User> userArrayList = new ArrayList<>();

        for (int i=0; i<imageId.length; i++) {

            User user = new User(name[i], lastMessage[i], lastmsgTime[i], phoneNo[i], country[i], imageId[i]);
            userArrayList.add(user);

        }

        ListAdapter listAdapter = new ListAdapter(ListViewActivity.this, userArrayList);

        binding.listView.setAdapter(listAdapter);
        binding.listView.setClickable(true);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent i = new Intent(ListViewActivity.this, UserActivity.class);
                    i.putExtra("name", name[position]);
                    i.putExtra("phone", phoneNo[position]);
                    i.putExtra("country", country[position]);
                    i.putExtra("imageid", imageId[position]);
                    startActivity(i);

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

    public static class ReadActivity extends AppCompatActivity {

        ActionBar aB;

        DataDiriAdapter adapter;
        ArrayList<DataDiriModel> listData;

        RecyclerView recyclerView;
        LinearLayoutManager manager;

        DatabaseReference ref;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_read);

            recyclerView = findViewById(R.id.rv_read);
            recyclerView.setHasFixedSize(true);

            aB = getSupportActionBar();
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            manager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(manager);

            AmbilData();
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

        public void AmbilData() {
            listData = new ArrayList<>();

            ref = FirebaseDatabase.getInstance().getReference("UASNui");
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    listData.clear();
                    for (DataSnapshot datsnap:snapshot.getChildren()) {
                        DataDiriModel model = datsnap.getValue(DataDiriModel.class);

                        model.setKey(model.getKey());
                        listData.add(model);

                    }
                    adapter = new DataDiriAdapter(getApplicationContext(), listData);
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }

        public void fab(View view) {
            startActivity(new Intent(ReadActivity.this, NetworkingActivity.class));
        }
    }
}