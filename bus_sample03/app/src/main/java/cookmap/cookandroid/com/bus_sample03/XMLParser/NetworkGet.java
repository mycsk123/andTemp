package cookmap.cookandroid.com.bus_sample03.XMLParser;

import android.app.ProgressDialog;
import android.content.Context;
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
import cookmap.cookandroid.com.bus_sample03.BStopResult.CA_BStopResult;
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
    private CA_BStopResult adapterBStop;

    ArrayList<CBStopInfo> bsInfoList;
    ArrayList<CBStop> bsArrList;

    private String searchbuslinenum;
    private String searchbstoproute;
    private int select;

    private String URL_Adress;

    ProgressDialog progressDialog;
    Context context;

    public NetworkGet(Context context, CA_BNumResult adapters, int select, String search){

        this.context = context;

        serviceUrl = "http://data.busan.go.kr/openBus/service/busanBIMS2/";
        serviceKey = "slg7RJ8L%2FCOauR%2FaIz85i2dqPOIbESUB2oT83luBfprZZQy5C5t9gdyOn7FwwPFHMAMpgwZadPce0vCiDFiQLg%3D%3D";
        this.select = select;

        searchbuslinenum = search;
        URL_Adress = serviceUrl + "busInfo?serviceKey=" + serviceKey + "&lineno=" + searchbuslinenum;
        this.adapter = adapters;

    }

    public NetworkGet(Context context, CA_BRouteResult adapters, int select, String search){
        this.context = context;

        serviceUrl = "http://data.busan.go.kr/openBus/service/busanBIMS2/";
        serviceKey = "slg7RJ8L%2FCOauR%2FaIz85i2dqPOIbESUB2oT83luBfprZZQy5C5t9gdyOn7FwwPFHMAMpgwZadPce0vCiDFiQLg%3D%3D";
        this.select = select;

        searchbstoproute = search;
        URL_Adress = serviceUrl + "busInfoRoute?serviceKey=" + serviceKey + "&lineid=" + searchbstoproute;
        adapterBStopR = adapters;

    }

    //메인에서 버스 검색 시 - 차후 arsno 값 null로 사용하므로 아래와 같이 합쳐서 조건 걸어 사용할 것
    public NetworkGet(Context context, CA_BStopResult adapters, int select, String bstopnm, String arsno){
        this.context = context;
        adapterBStop = adapters;

        serviceUrl = "http://data.busan.go.kr/openBus/service/busanBIMS2/";
        serviceKey = "slg7RJ8L%2FCOauR%2FaIz85i2dqPOIbESUB2oT83luBfprZZQy5C5t9gdyOn7FwwPFHMAMpgwZadPce0vCiDFiQLg%3D%3D";
        this.select = select;

        try {
            //한글일 경우 utf-8로 인코딩해서 넣을 것
            String tempBstopnm = URLEncoder.encode(bstopnm, "UTF-8");
            URL_Adress = serviceUrl + "busStop?serviceKey=" + serviceKey + "&bstopnm=" + tempBstopnm;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //URL_Adress = serviceUrl + "busStop?serviceKey=" + serviceKey + "&bstopnm=" + bstopnm + "&arsno=" + arsno;
//        URL_Adress = "http://data.busan.go.kr/openBus/service/busanBIMS2/busStop?serviceKey=slg7RJ8L%2FCOauR%2FaIz85i2dqPOIbESUB2oT83luBfprZZQy5C5t9gdyOn7FwwPFHMAMpgwZadPce0vCiDFiQLg%3D%3D&bstopnm=%EB%B6%80%EC%82%B0%EC%8B%9C%EC%B2%AD&arsno=13045";
    }

    public NetworkGet(Context context, int select, String bstopnm, String arsno){
        this.context = context;

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

    public NetworkGet(Context context, String bstopId, String lineid){
        this.context = context;

        serviceUrl = "http://data.busan.go.kr/openBus/service/busanBIMS2/";
        serviceKey = "slg7RJ8L%2FCOauR%2FaIz85i2dqPOIbESUB2oT83luBfprZZQy5C5t9gdyOn7FwwPFHMAMpgwZadPce0vCiDFiQLg%3D%3D";

        //URL_Adress = "http://data.busan.go.kr/openBus/service/busanBIMS2/busStopArr?serviceKey=slg7RJ8L%2FCOauR%2FaIz85i2dqPOIbESUB2oT83luBfprZZQy5C5t9gdyOn7FwwPFHMAMpgwZadPce0vCiDFiQLg%3D%3D&bstopid=193990101&lineid=5200179000";

        URL_Adress = serviceUrl + "busStopArr?serviceKey=" + serviceKey + "&bstopid=" + bstopId + "&lineid=" + lineid;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //Toast.makeText(context, "다이얼로그 띄우기", Toast.LENGTH_SHORT).show();
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("검색 중입니다.");
        progressDialog.setMessage("Loading.....");
        progressDialog.setProgressStyle(progressDialog.STYLE_SPINNER);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

    }

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

                break;

            case 5:

                ArrayList<CBStopInfo> bstopList = new ArrayList<CBStopInfo>();
                count = 0;

                try{
                    count = XmlPBStopInfo.getXmlPBStopInfo(s, bstopList);
                }catch (Exception e){
                    e.printStackTrace();
                }

                if(count == 0){

                }else {
                    adapterBStop.setDatas(bstopList);
                    adapterBStop.notifyDataSetChanged();
                }


                break;

            default:
                break;
        }

        progressDialog.dismiss();

    }

}
