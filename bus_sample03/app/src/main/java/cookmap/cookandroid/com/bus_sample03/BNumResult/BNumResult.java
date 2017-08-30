package cookmap.cookandroid.com.bus_sample03.BNumResult;

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

import cookmap.cookandroid.com.bus_sample03.BRouteResult.BRouteResult;
import cookmap.cookandroid.com.bus_sample03.Data.CBInfo;
import cookmap.cookandroid.com.bus_sample03.R;
import cookmap.cookandroid.com.bus_sample03.XMLParser.NetworkGet;

public class BNumResult extends AppCompatActivity {
    ListView listView;
    private CA_BNumResult adapter;
    TextView tvBNum;
    Button btnPrev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bnum_result);

        Intent intent = getIntent();
        String tempBNum = intent.getExtras().getString("busNumber");

        tvBNum = (TextView)findViewById(R.id.tvBNum);
        tvBNum.setText("검색결과 : " + tempBNum);

        btnPrev = (Button)findViewById(R.id.btnPrev);

        listView = (ListView)findViewById(R.id.bnr_listView);
        adapter = new CA_BNumResult(this, R.layout.ca_bnumresult, new ArrayList<CBInfo>());
        listView.setAdapter(adapter);

        new NetworkGet(this, (CA_BNumResult)listView.getAdapter(), 1, tempBNum).execute("");



        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplicationContext(), BRouteResult.class);

                CBInfo tempBusInfo = (CBInfo)adapter.getItem(i);

                intent.putExtra("selectBusNumber", (Serializable) tempBusInfo);

                startActivity(intent);

            }
        });

    }
}
