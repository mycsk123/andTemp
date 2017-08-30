package cookmap.cookandroid.com.bus_sample03.BNumResult;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cookmap.cookandroid.com.bus_sample03.Data.CBInfo;
import cookmap.cookandroid.com.bus_sample03.R;


/**
 * Created by 8 on 2017-08-28.
 */

public class CA_BNumResult extends BaseAdapter {

    private Activity mAct;
    LayoutInflater mInflater;
    ArrayList<CBInfo> mBusInfoObjArr;
    int mListLayout;

    public CA_BNumResult(Activity a, int listLayout, ArrayList<CBInfo> mBusInfoObjArrayListT) {

        mAct = a;
        mListLayout = listLayout;
        mBusInfoObjArr = mBusInfoObjArrayListT;
        mInflater = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setDatas(ArrayList<CBInfo> arrayList){
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

        final ImageView img_bustype = (ImageView)view.findViewById(R.id.img_bustype);
        if(mBusInfoObjArr.get(i).getBustype().equals("일반버스")){
            img_bustype.setImageResource(R.drawable.busstyle01);

        }else if(mBusInfoObjArr.get(i).getBustype().equals("좌석버스")){
            img_bustype.setImageResource(R.drawable.busstyle02);
        }else if(mBusInfoObjArr.get(i).getBustype().equals("급행버스")){
            img_bustype.setImageResource(R.drawable.busstyle04);
        }else if(mBusInfoObjArr.get(i).getBustype().equals("심야버스")){
            img_bustype.setImageResource(R.drawable.busstyle05);
        }else if(mBusInfoObjArr.get(i).getBustype().equals("심야버스(급행)")){
            img_bustype.setImageResource(R.drawable.busstyle05);
        }else if(mBusInfoObjArr.get(i).getBustype().equals("마을버스")){
            img_bustype.setImageResource(R.drawable.busstyle03);
        }else{
            img_bustype.setImageResource(R.drawable.busstyle06);
        }


        final TextView tvbustype = (TextView)view.findViewById(R.id.tv_bustype);
        tvbustype.setText(mBusInfoObjArr.get(i).getBustype());

        final  TextView tvbuslinenum = (TextView)view.findViewById(R.id.tv_buslinenum);
        tvbuslinenum.setText(mBusInfoObjArr.get(i).getBuslinenum());

        final  TextView tvpoint = (TextView)view.findViewById(R.id.tv_point);
        tvpoint.setText(mBusInfoObjArr.get(i).getStartpoint() + "↔" + mBusInfoObjArr.get(i).getEndpoint());

        final  TextView tvfirsttime = (TextView)view.findViewById(R.id.tv_firsttime);
        tvfirsttime.setText(mBusInfoObjArr.get(i).getFirsttime());
        final  TextView tvendtime = (TextView)view.findViewById(R.id.tv_endtime);
        tvendtime.setText(mBusInfoObjArr.get(i).getEndtime());

        final  TextView tvheadwayNorm = (TextView)view.findViewById(R.id.tv_headwayNorm);
        tvheadwayNorm.setText(mBusInfoObjArr.get(i).getHeadwayNorm() + "분");

        return view;

    }

}
