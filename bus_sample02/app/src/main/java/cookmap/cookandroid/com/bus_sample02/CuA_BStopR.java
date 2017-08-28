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

public class CuA_BStopR extends BaseAdapter {
    private Activity mAct;
    LayoutInflater mInflater;
    ArrayList<BusByRoute> mBusByRouteObjArr;
    int mListLayout;

    public CuA_BStopR(Activity a, int listLayout, ArrayList<BusByRoute> mBusByRouteObjArrayListT){
        mAct = a;
        mListLayout = listLayout;
        mBusByRouteObjArr = mBusByRouteObjArrayListT;
        mInflater = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setDatas(ArrayList<BusByRoute> arrayList){
        mBusByRouteObjArr = arrayList;
    }

    @Override
    public int getCount() {
        return mBusByRouteObjArr.size();
    }

    @Override
    public Object getItem(int i) {
        return mBusByRouteObjArr.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null)
            view = mInflater.inflate(mListLayout, viewGroup, false);

        final TextView tvCarNo = (TextView)view.findViewById(R.id.tv_carNo);
        tvCarNo.setText(mBusByRouteObjArr.get(i).carNo);

        final  TextView tvBstopnm = (TextView)view.findViewById(R.id.tv_bstopnm);
        tvBstopnm.setText(mBusByRouteObjArr.get(i).bstopnm);

        final  TextView tvArsNo = (TextView)view.findViewById(R.id.arsNo);
        tvArsNo.setText(mBusByRouteObjArr.get(i).arsNo);

        return view;

    }

}
