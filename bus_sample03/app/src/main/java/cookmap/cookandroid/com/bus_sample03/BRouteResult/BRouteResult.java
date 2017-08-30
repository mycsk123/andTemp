package cookmap.cookandroid.com.bus_sample03.BRouteResult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

import cookmap.cookandroid.com.bus_sample03.BStopPlace.BStopPlace;
import cookmap.cookandroid.com.bus_sample03.Data.CBInfo;
import cookmap.cookandroid.com.bus_sample03.Data.CBRoute;
import cookmap.cookandroid.com.bus_sample03.R;
import cookmap.cookandroid.com.bus_sample03.XMLParser.NetworkGet;

public class BRouteResult extends AppCompatActivity {
    CBInfo bi;
    ListView listView;
    private CA_BRouteResult adapter;
    Button btnPrev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broute_result);

        btnPrev = (Button)findViewById(R.id.btnPrev);

        Intent intent = getIntent();
        bi = (CBInfo) intent.getSerializableExtra("selectBusNumber");

        listView = (ListView)findViewById(R.id.bnr_listView);
        adapter = new CA_BRouteResult(this, R.layout.ca_brouteresult, new ArrayList<CBRoute>());
        listView.setAdapter(adapter);

        new NetworkGet((CA_BRouteResult)listView.getAdapter(), 2, bi.getLineId()).execute("");

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), BStopPlace.class);
//
//                //정류소 명 + 번호
//
                CBRoute tempBusRoute = (CBRoute)adapter.getItem(i);

                intent.putExtra("BStop", (Serializable)tempBusRoute);
                intent.putExtra("selectLinID", bi.getLineId());

                startActivity(intent);
            }
        });

    }
}
