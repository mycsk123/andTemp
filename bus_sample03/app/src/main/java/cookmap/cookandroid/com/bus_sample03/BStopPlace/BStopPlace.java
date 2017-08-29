package cookmap.cookandroid.com.bus_sample03.BStopPlace;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import cookmap.cookandroid.com.bus_sample03.Data.CBRoute;
import cookmap.cookandroid.com.bus_sample03.Data.CBStopInfo;
import cookmap.cookandroid.com.bus_sample03.R;
import cookmap.cookandroid.com.bus_sample03.XMLParser.NetworkGet;

public class BStopPlace extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;

    CBRoute br;
    ArrayList<CBStopInfo> bsInfoList;
    ArrayList<CBStopInfo> te;

    TextView tv1;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bstop_place);

        tv1 = (TextView)findViewById(R.id.tv1);

        bsInfoList = new ArrayList<CBStopInfo>();

//        Intent intent = getIntent();
//        br = (CBRoute) intent.getSerializableExtra("BStop");

        String temp1 = "부산시청";
        String temp2 = "13045";

        new NetworkGet(context.getApplicationContext(), bsInfoList, 3, temp2, temp1);



        //public NetworkGet(ArrayList<CBStop> bsArrList, int select, String bstopId, String lineId)
        //new NetworkGet(bsInfoList, 3, br.getArsNo(), br.getBstopnm());


//        try {
//            String temp = new NetworkGet(bsInfoList, 3, br.getArsNo(), br.getBstopnm()).get();
//            Log.v("test", temp);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }


        bsInfoList.size();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(35.134004, 129.103702);
//
//        double tempX = Integer.parseInt(bsInfoList.get(0).getGpsX());
//        double tempY = Integer.parseInt(bsInfoList.get(0).getGpsY());

//        mMap.addMarker(new MarkerOptions().position(new LatLng(tempX, tempY)).title(bsInfoList.get(0).getBstopNm()));
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(tempX, tempY), 15));

        mMap.addMarker(new MarkerOptions().position(new LatLng(35.134004, 129.103702)).title("부경대"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(35.134004, 129.103702), 15));
    }

    public class Task extends AsyncTask<String, Void, String>{
        String serviceUrl = "http://data.busan.go.kr/openBus/service/busanBIMS2/";
        String serviceKey = "slg7RJ8L%2FCOauR%2FaIz85i2dqPOIbESUB2oT83luBfprZZQy5C5t9gdyOn7FwwPFHMAMpgwZadPce0vCiDFiQLg%3D%3D";
        String URL_Adress = "";

        Task(String bstopnm, String arsno){
            URL_Adress = serviceUrl + "busStop?serviceKey=" + serviceKey + "&bstopnm=" + bstopnm + "&arsno=" + arsno;
        }

        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection conn = null;
            String line = null;
            String page = "";

            try {
                Url = new URL(URL_Adress);

                conn = (HttpURLConnection) Url.openConnection();

                BufferedInputStream buf = new BufferedInputStream(conn.getInputStream());
                BufferedReader bufreader = new BufferedReader(new InputStreamReader(buf, "utf-8"));

                while ((line = bufreader.readLine()) != null) {
                    page += line;
                }

            }catch (MalformedURLException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                conn.disconnect();
            }

            return page;
        }
    }
}
