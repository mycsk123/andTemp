package cookmap.cookandroid.com.bus_sample03.BStopResult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import cookmap.cookandroid.com.bus_sample03.Data.CBStopInfo;
import cookmap.cookandroid.com.bus_sample03.R;
import cookmap.cookandroid.com.bus_sample03.XMLParser.NetworkGet;

public class BStopResult extends AppCompatActivity {
    ListView listView;
    private CA_BStopResult adapter;
    TextView tvBStop;
    Button btnPrev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bstop_result);

        Intent intent = getIntent();
        String tempBStop = intent.getExtras().getString("busStop");

        tvBStop = (TextView)findViewById(R.id.tvBStop);
        tvBStop.setText("검색결과 : " + tempBStop);

        btnPrev = (Button)findViewById(R.id.btnPrev);

        listView = (ListView)findViewById(R.id.bsr_listView);
        adapter = new CA_BStopResult(this, R.layout.ca_bstopresult, new ArrayList<CBStopInfo>());
        listView.setAdapter(adapter);

        String temp = null; //임시 - 나중에 지울 것

        new NetworkGet(this, (CA_BStopResult)listView.getAdapter(), 5, tempBStop, temp).execute("");

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
