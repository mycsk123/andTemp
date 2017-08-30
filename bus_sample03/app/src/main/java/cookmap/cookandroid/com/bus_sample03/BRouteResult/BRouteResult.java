package cookmap.cookandroid.com.bus_sample03.BRouteResult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

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

    TextView tv_buslinenum, tv_StartEndPoint;

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

        new NetworkGet(this, (CA_BRouteResult)listView.getAdapter(), 2, bi.getLineId()).execute("");

        tv_buslinenum = (TextView)findViewById(R.id.tv_buslinenum);
        tv_StartEndPoint = (TextView)findViewById(R.id.tv_StartEndPoint);

        tv_buslinenum.setText(bi.getBuslinenum());
        tv_StartEndPoint.setText(bi.getStartpoint() + " ↔ " + bi.getEndpoint());

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

                CBRoute tempBusRoute = (CBRoute)adapter.getItem(i);

                intent.putExtra("BStop", (Serializable)tempBusRoute);
                intent.putExtra("selectLinID", bi.getLineId());

                startActivity(intent);
            }
        });

    }
}
