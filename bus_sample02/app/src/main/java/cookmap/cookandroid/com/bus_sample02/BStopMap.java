package cookmap.cookandroid.com.bus_sample02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class BStopMap extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;

    BusByRoute br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bstop_map);

        Intent intent = getIntent();
        br = (BusByRoute) intent.getSerializableExtra("BStop");

        new NetworkGet(3, br.arsNo, br.bstopnm);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(35.134004, 129.103702);
        mMap.addMarker(new MarkerOptions().position(new LatLng(35.134004, 129.103702)).title("부경대"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(35.134004, 129.103702), 15));
    }
}
