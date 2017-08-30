package cookmap.cookandroid.com.bus_sample03.BStopResult;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import cookmap.cookandroid.com.bus_sample03.Data.CBStopInfo;
import cookmap.cookandroid.com.bus_sample03.R;

/**
 * Created by 8 on 2017-08-30.
 */

public class CA_BStopResult extends BaseAdapter {

    private Activity mAct;
    LayoutInflater mInflater;
    ArrayList<CBStopInfo> mBusInfoObjArr;
    int mListLayout;

    public CA_BStopResult(Activity a, int listLayout, ArrayList<CBStopInfo> mBStopInfoObjArrayListT){
        mAct = a;
        mListLayout = listLayout;
        mBusInfoObjArr = mBStopInfoObjArrayListT;
        mInflater = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setDatas(ArrayList<CBStopInfo> arrayList){
        mBusInfoObjArr = arrayList;
    }

    @Override
    public int getCount() {
        return mBusInfoObjArr.size();
    }

    @Override
    public Object getItem(int i) {
        return mBusInfoObjArr.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null)
            view = mInflater.inflate(mListLayout, viewGroup, false);

        final TextView tv_bstopNm = (TextView)view.findViewById(R.id.tv_bstopNm);
        tv_bstopNm.setText(mBusInfoObjArr.get(i).getBstopNm());

        final TextView tv_bstopArsno = (TextView)view.findViewById(R.id.tv_bstopArsno);
        tv_bstopArsno.setText(mBusInfoObjArr.get(i).getBstopArsno());

        final TextView tv_stoptype = (TextView)view.findViewById(R.id.tv_stoptype);
        tv_stoptype.setText(mBusInfoObjArr.get(i).getStoptype());

        return view;
    }
}
