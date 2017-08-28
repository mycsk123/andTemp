package cookmap.cookandroid.com.bus_sample02;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by 8 on 2017-08-22.
 */

public class NetworkGet extends AsyncTask<String, Void, String> {
    private URL Url;

    private Custom_adapter adapter;
    private CuA_BStopR adapterBStopR;

    private String serviceUrl;
    private String serviceKey;
    private String searchbuslinenum;
    private String searchbstoproute;
    private int select;

    private String URL_Adress;

    public NetworkGet(Custom_adapter adapters, int select, String search){

        serviceUrl = "http://data.busan.go.kr/openBus/service/busanBIMS2/";
        serviceKey = "slg7RJ8L%2FCOauR%2FaIz85i2dqPOIbESUB2oT83luBfprZZQy5C5t9gdyOn7FwwPFHMAMpgwZadPce0vCiDFiQLg%3D%3D";
        this.select = select;

        searchbuslinenum = search;
        URL_Adress = serviceUrl + "busInfo?serviceKey=" + serviceKey + "&lineno=" + searchbuslinenum;
        adapter = adapters;

    }

    public NetworkGet(CuA_BStopR adapters, int select, String search){

        serviceUrl = "http://data.busan.go.kr/openBus/service/busanBIMS2/";
        serviceKey = "slg7RJ8L%2FCOauR%2FaIz85i2dqPOIbESUB2oT83luBfprZZQy5C5t9gdyOn7FwwPFHMAMpgwZadPce0vCiDFiQLg%3D%3D";
        this.select = select;

        searchbstoproute = search;
        URL_Adress = serviceUrl + "busInfoRoute?serviceKey=" + serviceKey + "&lineid=" + searchbstoproute;
        adapterBStopR = adapters;

    }

    public NetworkGet(int select, String bstopId, String lineId){
        serviceUrl = "http://data.busan.go.kr/openBus/service/busanBIMS2/";
        serviceKey = "slg7RJ8L%2FCOauR%2FaIz85i2dqPOIbESUB2oT83luBfprZZQy5C5t9gdyOn7FwwPFHMAMpgwZadPce0vCiDFiQLg%3D%3D";
        this.select = select;

        URL_Adress = serviceUrl + "busStopArr?serviceKey=" + serviceKey + "&bstopid=" + bstopId + "&lineid=" + lineId;

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
                ArrayList<BusInfo> busList = new ArrayList<BusInfo>();
                count = 0;

                try{
                    count = XmlParser.getBusInfoXml(s, busList);
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
                ArrayList<BusByRoute> routeList = new ArrayList<BusByRoute>();
                count = 0;

                try{
                    count = XmlParserRoute.getBStopRouteXml(s, routeList);
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

                ArrayList<BStopArrBus> bsArrList = new ArrayList<BStopArrBus>();
                count = 0;

                try{
                    bsArrList = XmlParserBStopArr.getBStopArrXml(s, bsArrList);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;

            default:
                break;
        }



    }
}
