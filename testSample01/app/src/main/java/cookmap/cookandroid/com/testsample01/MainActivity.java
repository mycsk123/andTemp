package cookmap.cookandroid.com.testsample01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView)findViewById(R.id.img);
        img.setImageResource(R.drawable.line01);

//        Button btn = (Button) findViewById(R.id.btn_popup);
//
//        ProgressBar progressBar = (ProgressBar)findViewById(R.id.small);
//        progressBar.setMax(100);
//        progressBar.setProgress(30);
//        progressBar.setSecondaryProgress(70);
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //new ProgressDlgTest(this).execute(100);
//            }
//        });


    }
}
