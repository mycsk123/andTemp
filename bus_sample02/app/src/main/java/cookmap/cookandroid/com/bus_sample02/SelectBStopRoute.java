package cookmap.cookandroid.com.bus_sample02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class SelectBStopRoute extends AppCompatActivity {
    BusInfo bi;
    ListView listView;
    private CuA_BStopR adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_bstop_route);

        Intent intent = getIntent();
        bi = (BusInfo) intent.getSerializableExtra("selectBusNumber");

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
