package cookmap.cookandroid.com.bus_sample03.XMLParser;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import cookmap.cookandroid.com.bus_sample03.BNumResult.CA_BNumResult;
import cookmap.cookandroid.com.bus_sample03.BRouteResult.CA_BRouteResult;
import cookmap.cookandroid.com.bus_sample03.Data.CBInfo;
import cookmap.cookandroid.com.bus_sample03.Data.CBRoute;
import cookmap.cookandroid.com.bus_sample03.Data.CBStop;
import cookmap.cookandroid.com.bus_sample03.Data.CBStopInfo;

/**
 * Created by 8 on 2017-08-28.
 */

public class NetworkGet extends AsyncTask<String, Void, String> {

    private URL Url;
    private String serviceUrl;
    private String serviceKey;

    private CA_BNumResult adapter;
    private CA_BRouteResult adapterBStopR;
    ArrayList<CBStopInfo> bsInfoList;
    ArrayList<CBStop> bsArrList;

    private String searchbuslinenum;
    private String searchbstoproute;
    private int select;

    private String URL_Adress;

    public NetworkGet(CA_BNumResult adapters, int select, String search){

        serviceUrl = "http://data.busan.go.kr/openBus/service/busanBIMS2/";
        serviceKey = "slg7RJ8L%2FCOauR%2FaIz85i2dqPOIbESUB2oT83luBfprZZQy5C5t9gdyOn7FwwPFHMAMpgwZadPce0vCiDFiQLg%3D%3D";
        this.select = select;

        searchbuslinenum = search;
        URL_Adress = serviceUrl + "busInfo?serviceKey=" + serviceKey + "&lineno=" + searchbuslinenum;
        this.adapter = adapters;

    }

    public NetworkGet(CA_BRouteResult adapters, int select, String search){

        serviceUrl = "http://data.busan.go.kr/openBus/service/busanBIMS2/";
        serviceKey = "slg7RJ8L%2FCOauR%2FaIz85i2dqPOIbESUB2oT83luBfprZZQy5C5t9gdyOn7FwwPFHMAMpgwZadPce0vCiDFiQLg%3D%3D";
        this.select = select;

        searchbstoproute = search;
        URL_Adress = serviceUrl + "busInfoRoute?serviceKey=" + serviceKey + "&lineid=" + searchbstoproute;
        adapterBStopR = adapters;

    }

    public NetworkGet(int select, String bstopnm, String arsno){
        serviceUrl = "http://data.busan.go.kr/openBus/service/busanBIMS2/";
        serviceKey = "slg7RJ8L%2FCOauR%2FaIz85i2dqPOIbESUB2oT83luBfprZZQy5C5t9gdyOn7FwwPFHMAMpgwZadPce0vCiDFiQLg%3D%3D";
        this.select = select;

        try {
            //한글일 경우 utf-8로 인코딩해서 넣을 것
            String tempBstopnm = URLEncoder.encode(bstopnm, "UTF-8");
            URL_Adress = serviceUrl + "busStop?serviceKey=" + serviceKey + "&bstopnm=" + tempBstopnm + "&arsno=" + arsno;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //URL_Adress = serviceUrl + "busStop?serviceKey=" + serviceKey + "&bstopnm=" + bstopnm + "&arsno=" + arsno;
//        URL_Adress = "http://data.busan.go.kr/openBus/service/busanBIMS2/busStop?serviceKey=slg7RJ8L%2FCOauR%2FaIz85i2dqPOIbESUB2oT83luBfprZZQy5C5t9gdyOn7FwwPFHMAMpgwZadPce0vCiDFiQLg%3D%3D&bstopnm=%EB%B6%80%EC%82%B0%EC%8B%9C%EC%B2%AD&arsno=13045";


    }

    public NetworkGet(String bstopId, String lineid){
        serviceUrl = "http://data.busan.go.kr/openBus/service/busanBIMS2/";
        serviceKey = "slg7RJ8L%2FCOauR%2FaIz85i2dqPOIbESUB2oT83luBfprZZQy5C5t9gdyOn7FwwPFHMAMpgwZadPce0vCiDFiQLg%3D%3D";

        //URL_Adress = "http://data.busan.go.kr/openBus/service/busanBIMS2/busStopArr?serviceKey=slg7RJ8L%2FCOauR%2FaIz85i2dqPOIbESUB2oT83luBfprZZQy5C5t9gdyOn7FwwPFHMAMpgwZadPce0vCiDFiQLg%3D%3D&bstopid=193990101&lineid=5200179000";

        URL_Adress = serviceUrl + "busStopArr?serviceKey=" + serviceKey + "&bstopid=" + bstopId + "&lineid=" + lineid;
    }

    //ArrayList<CBStop> bsArrList = new ArrayList<CBStop>();
//    public NetworkGet(ArrayList<CBStop> bsArrList, int select, String bstopId, String lineId){
//        serviceUrl = "http://data.busan.go.kr/openBus/service/busanBIMS2/";
//        serviceKey = "slg7RJ8L%2FCOauR%2FaIz85i2dqPOIbESUB2oT83luBfprZZQy5C5t9gdyOn7FwwPFHMAMpgwZadPce0vCiDFiQLg%3D%3D";
//        this.select = select;
//
//        URL_Adress = serviceUrl + "busStopArr?serviceKey=" + serviceKey + "&bstopid=" + bstopId + "&lineid=" + lineId;
//
//        this.bsArrList = bsArrList;
//    }


//    @Override
//    protected void onPreExecute() {
//        mDlg = new ProgressDialog(mContext);
//        mDlg.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//        mDlg.setMessage("Start");
//        mDlg.show();
//
//        super.onPreExecute();
//    }

    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection conn = null;
        String line = null;
        String page = "";

        try {
            Url = new URL(URL_Adress);

            conn = (HttpURLConnection) Url.openConnection();

            BufferedInputStream buf = new BufferedInputStream(conn.getInputStream());
            BufferedReader bufreader = new BufferedReader(new InputStreamReader(buf, "utf-8"));

            while ((line = bufreader.readLine()) != null) {
                page += line;
            }

        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            conn.disconnect();
        }

        return page;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        int count = 0;

        switch (select){

            case 1:
                ArrayList<CBInfo> busList = new ArrayList<CBInfo>();
                count = 0;

                try{
                    count = XmlPBInfo.getXmlPBInfo(s, busList);
                }catch (Exception e){
                    e.printStackTrace();
                }

                if(count == 0){

                }else {
                    adapter.setDatas(busList);
                    adapter.notifyDataSetChanged();
                }
                break;
            case 2:
                ArrayList<CBRoute> routeList = new ArrayList<CBRoute>();
                count = 0;
                try{
                    count = XmlPBRoute.getXmlPBRoute(s, routeList);
                }catch (Exception e){
                    e.printStackTrace();
                }

                if(count == 0){

                }else {
                    adapterBStopR.setDatas(routeList);
                    adapterBStopR.notifyDataSetChanged();
                }

                break;

            case 3:
                break;

            case 4:

//                ArrayList<CBStop> bsArrList = new ArrayList<CBStop>();
//                count = 0;
//
//                try{
//                    XmlPBStop.getXmlPBStop(s, bsArrList);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }



                break;

            default:
                break;
        }



    }

}
