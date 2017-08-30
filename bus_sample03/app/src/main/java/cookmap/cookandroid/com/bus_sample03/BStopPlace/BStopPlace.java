package cookmap.cookandroid.com.bus_sample03.BStopPlace;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import cookmap.cookandroid.com.bus_sample03.Data.CBRoute;
import cookmap.cookandroid.com.bus_sample03.Data.CBStop;
import cookmap.cookandroid.com.bus_sample03.Data.CBStopInfo;
import cookmap.cookandroid.com.bus_sample03.R;
import cookmap.cookandroid.com.bus_sample03.XMLParser.NetworkGet;
import cookmap.cookandroid.com.bus_sample03.XMLParser.XmlPBStop;
import cookmap.cookandroid.com.bus_sample03.XMLParser.XmlPBStopInfo;

public class BStopPlace extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;

    CBRoute br;
    ArrayList<CBStopInfo> bsInfoList;
    ArrayList<CBStop> bstopList;

    Button btnPrev;
    TextView tv_nodeNm, tv_arsNo, tv_min1, tv_min2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bstop_place);

        bsInfoList = new ArrayList<CBStopInfo>();
        bstopList = new ArrayList<CBStop>();

        btnPrev = (Button)findViewById(R.id.btnPrev);

        tv_nodeNm = (TextView)findViewById(R.id.tv_nodeNm);
        tv_arsNo = (TextView)findViewById(R.id.tv_arsNo);
        tv_min1 = (TextView)findViewById(R.id.tv_min1);
        tv_min2 = (TextView)findViewById(R.id.tv_min2);

        Intent intent = getIntent();
        br = (CBRoute) intent.getSerializableExtra("BStop");
        String lineId = intent.getStringExtra("selectLinID");

        try {
            String tempUrl = new NetworkGet(this, 3, br.getBstopnm(), br.getArsNo()).execute("").get();
            XmlPBStopInfo.getXmlPBStopInfo(tempUrl, bsInfoList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try{
            String tempUrl1 = new NetworkGet(this, bsInfoList.get(0).getBstopId(), lineId).execute("").get();
            XmlPBStop.getXmlPBStop(tempUrl1, bstopList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        tv_nodeNm.setText(bstopList.get(0).getNodeNm());
        tv_arsNo.setText(bstopList.get(0).getArsNo());
        tv_min1.setText(bstopList.get(0).getMin1() + "분");
        tv_min2.setText(bstopList.get(0).getMin2() + "분");

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        double tempX = Double.parseDouble(bsInfoList.get(0).getGpsY());
        Log.v("test", ""+tempX);
        double tempY = Double.parseDouble(bsInfoList.get(0).getGpsX());
        Log.v("test", ""+tempY);

        mMap.addMarker(new MarkerOptions().position(new LatLng(tempX, tempY)).title(bsInfoList.get(0).getBstopNm()));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(tempX, tempY), 15));

    }

}
