package cookmap.cookandroid.com.testsample01;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

/**
 * Created by 8 on 2017-08-28.
 */

public class ProgressDlgTest extends AsyncTask<Integer, String, Integer> {
    private ProgressDialog mDlg;
    private Context mContext;

    public ProgressDlgTest(View.OnClickListener context) {
        mContext = (Context) context;
    }

    //onPreExecute 함수는 이름대로 excute()로 실행 시 doInBackground() 실행 전에 호출되는 함수
    //여기서 ProgressDialog 생성 및 기본 세팅하고 show()
    @Override
    protected void onPreExecute() {
        mDlg = new ProgressDialog(mContext);
        mDlg.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mDlg.setMessage("작업 시작");
        mDlg.show();

        super.onPreExecute();
    }

    //doInBackground 함수는 excute() 실행시  실행됨
    //여기서 인수로는 작업개수를 넘겨주었다.
    @Override
    protected Integer doInBackground(Integer... params) {

        final int taskCnt = params[0];
        //넘겨받은 작업개수를 ProgressDialog의 맥스값으로 세팅하기 위해 publishProgress()로 데이터를 넘겨준다.
        //publishProgress()로 넘기면 onProgressUpdate()함수가 실행된다.
        publishProgress("max", Integer.toString(taskCnt));

        //작업 진행, 여기선 넘겨준 작업개수 * 100 만큼 sleep() 걸어줌
        for (int i = 0; i < taskCnt; ++i) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //작업 진행 마다 진행률을 갱신하기 위해 진행된 개수와 설명을 publishProgress() 로 넘겨줌.
            publishProgress("progress", Integer.toString(i), "작업 번호 " + Integer.toString(i) + "번 수행중");
        }

        //작업이 끝나고 작업된 개수를 리턴 . onPostExecute()함수의 인수가 됨
        return taskCnt;
    }

    //onProgressUpdate() 함수는 publishProgress() 함수로 넘겨준 데이터들을 받아옴
    @Override
    protected void onProgressUpdate(String... progress) {
        if (progress[0].equals("progress")) {
            mDlg.setProgress(Integer.parseInt(progress[1]));
            mDlg.setMessage(progress[2]);
        }
        else if (progress[0].equals("max")) {
            mDlg.setMax(Integer.parseInt(progress[1]));
        }
    }

    //onPostExecute() 함수는 doInBackground() 함수가 종료되면 실행됨
    @Override
    protected void onPostExecute(Integer result) {
        mDlg.dismiss();
        Toast.makeText(mContext, Integer.toString(result)+ "개의 작업 완료", Toast.LENGTH_SHORT).show();
    }
}
