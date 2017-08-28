package cookmap.cookandroid.com.bus_sample02;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 8 on 2017-08-22.
 */

public class Custom_adapter extends BaseAdapter {
    private Activity mAct;
    LayoutInflater mInflater;
    ArrayList<BusInfo> mBusInfoObjArr;
    int mListLayout;

    public Custom_adapter(Activity a, int listLayout, ArrayList<BusInfo> mBusInfoObjArrayListT) {

        mAct = a;
        mListLayout = listLayout;
        mBusInfoObjArr = mBusInfoObjArrayListT;
        mInflater = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setDatas(ArrayList<BusInfo> arrayList){
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

        final TextView tvbustype = (TextView)view.findViewById(R.id.tv_bustype);
        tvbustype.setText(mBusInfoObjArr.get(i).bustype);

        final  TextView tvbuslinenum = (TextView)view.findViewById(R.id.tv_buslinenum);
        tvbuslinenum.setText(mBusInfoObjArr.get(i).buslinenum);

        final  TextView tvpoint = (TextView)view.findViewById(R.id.tv_point);
        tvpoint.setText(mBusInfoObjArr.get(i).startpoint + "↔" + mBusInfoObjArr.get(i).endpoint);

        final  TextView tvfirsttime = (TextView)view.findViewById(R.id.tv_firsttime);
        tvfirsttime.setText(mBusInfoObjArr.get(i).firsttime);
        final  TextView tvendtime = (TextView)view.findViewById(R.id.tv_endtime);
        tvendtime.setText(mBusInfoObjArr.get(i).endtime);

        final  TextView tvheadwayNorm = (TextView)view.findViewById(R.id.tv_headwayNorm);
        tvheadwayNorm.setText(mBusInfoObjArr.get(i).headwayNorm + "분");


        return view;

    }

}
