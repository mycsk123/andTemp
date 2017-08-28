package cookmap.cookandroid.com.bus_sample03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cookmap.cookandroid.com.bus_sample03.BNumResult.BNumResult;
import cookmap.cookandroid.com.bus_sample03.BNumResult.CA_BNumResult;

public class MainActivity extends AppCompatActivity {
    EditText etBNum;
    Button btnBNSearch;

    private CA_BNumResult adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBNSearch = (Button)findViewById(R.id.btnBNSearch);
        etBNum = (EditText)findViewById(R.id.etBNum);

        btnBNSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tempBNum = etBNum.getText().toString();

                Intent intent = new Intent(MainActivity.this, BNumResult.class);
                intent.putExtra("busNumber", tempBNum);
                //액티비티 시작!
                startActivity(intent);
            }
        });

    }
}
