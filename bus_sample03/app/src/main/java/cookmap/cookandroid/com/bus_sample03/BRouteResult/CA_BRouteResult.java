package cookmap.cookandroid.com.bus_sample03.BRouteResult;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cookmap.cookandroid.com.bus_sample03.Data.CBRoute;
import cookmap.cookandroid.com.bus_sample03.R;

/**
 * Created by 8 on 2017-08-28.
 */

public class CA_BRouteResult extends BaseAdapter {
    private Activity mAct;
    LayoutInflater mInflater;
    ArrayList<CBRoute> mBusByRouteObjArr;
    int mListLayout;

    public CA_BRouteResult(Activity a, int listLayout, ArrayList<CBRoute> mBusByRouteObjArrayListT){
        mAct = a;
        mListLayout = listLayout;
        mBusByRouteObjArr = mBusByRouteObjArrayListT;
        mInflater = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setDatas(ArrayList<CBRoute> arrayList){
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
        tvCarNo.setText(mBusByRouteObjArr.get(i).getCarNo());

        final  TextView tvBstopnm = (TextView)view.findViewById(R.id.tv_bstopnm);
        tvBstopnm.setText(mBusByRouteObjArr.get(i).getBstopnm());

        final  TextView tvArsNo = (TextView)view.findViewById(R.id.arsNo);
        tvArsNo.setText(mBusByRouteObjArr.get(i).getArsNo());

        final ImageView imgbstype = (ImageView)view.findViewById(R.id.img_bstype);
        if(mBusByRouteObjArr.get(i).getCarNo() == null){
            imgbstype.setImageResource(R.drawable.line01);
        }else {
            imgbstype.setImageResource(R.drawable.line02);
        }

        return view;

    }

}
