package cookmap.cookandroid.com.bus_sample02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etBNum;
    private Custom_adapter adapter;
    Button btnBNSearch;

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
