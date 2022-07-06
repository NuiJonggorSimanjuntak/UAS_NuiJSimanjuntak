package nui.app.uas_NuiJSimanjuntak;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        maps = googleMap;

        LatLng Rumah = new LatLng(-6.355747, 106.731188);
        maps.addMarker(new MarkerOptions().position(Rumah).title("Kenari Utama Block AD 8 No. 14"));
        maps.setMaxZoomPreference(1000);
        maps.setMinZoomPreference(10);
        maps.moveCamera(CameraUpdateFactory.newLatLng(Rumah));

    }
}