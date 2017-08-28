package cookmap.cookandroid.com.bus_sample03.BRouteResult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;

import cookmap.cookandroid.com.bus_sample03.Data.CBInfo;
import cookmap.cookandroid.com.bus_sample03.R;
import cookmap.cookandroid.com.bus_sample03.XMLParser.NetworkGet;

public class BRouteResult extends AppCompatActivity {
    CBInfo bi;
    ListView listView;
    private CuA_BStopR adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broute_result);

        Intent intent = getIntent();
        bi = (CBInfo) intent.getSerializableExtra("selectBusNumber");

        listView = (ListView)findViewById(R.id.bnr_listView);
        adapter = new CuA_BStopR(this, R.layout.adapter_busroute, new ArrayList<BusByRoute>());
        listView.setAdapter(adapter);

        new NetworkGet((CuA_BStopR)listView.getAdapter(), 2, bi.lineId).execute("");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), BStopMap.class);

                //정류소 명 + 번호

                BusByRoute br = (BusByRoute)adapter.getItem(i);

                intent.putExtra("BStop", (Serializable)br);

                startActivity(intent);
            }
        });

    }
}
