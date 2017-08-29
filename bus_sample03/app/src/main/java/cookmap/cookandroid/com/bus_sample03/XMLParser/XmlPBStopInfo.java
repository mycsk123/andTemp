package cookmap.cookandroid.com.bus_sample03.XMLParser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import cookmap.cookandroid.com.bus_sample03.Data.CBStopInfo;

/**
 * Created by 8 on 2017-08-29.
 */

public class XmlPBStopInfo {

    static public int getXmlPBStopInfo(String response, ArrayList<CBStopInfo> bstopInfos){

        String bstopArsno = null;
        String bstopId = null;
        String bstopNm = null;
        String gpsX = null;
        String gpsY = null;
        String stoptype = null;

        boolean is_bstopArsno = false;
        boolean is_bstopId = false;
        boolean is_bstopNm = false;
        boolean is_gpsX = false;
        boolean is_gpsY = false;
        boolean is_stoptype = false;

        try{
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            xpp.setInput(new StringReader(response));
            int eventType = xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT){
                if(eventType == XmlPullParser.START_DOCUMENT){

                }else if(eventType == XmlPullParser.START_TAG){
                    String tag_name = xpp.getName();

                    if (tag_name.equals("bstopArsno")) {
                        is_bstopArsno = true;
                    }
                    if (tag_name.equals("bstopId")) {
                        is_bstopId = true;
                    }
                    if (tag_name.equals("bstopNm")) {
                        is_bstopNm = true;
                    }
                    if (tag_name.equals("gpsX")) {
                        is_gpsX = true;
                    }
                    if (tag_name.equals("gpsY")) {
                        is_gpsY = true;
                    }
                    if (tag_name.equals("stoptype")) {
                        is_stoptype = true;
                    }
                }else{
                    if(eventType == XmlPullParser.TEXT){
                        if (is_bstopArsno) {
                            bstopArsno = xpp.getText();
                            bstopInfos.add(new CBStopInfo());
                            bstopInfos.get(bstopInfos.size() - 1).setBstopArsno(bstopArsno);

                            is_bstopArsno = false;
                        }
                        if (is_bstopId) {
                            bstopId = xpp.getText();
                            bstopInfos.get(bstopInfos.size() - 1).setBstopId(bstopId);

                            is_bstopId = false;
                        }
                        if (is_bstopNm) {
                            bstopNm = xpp.getText();
                            bstopInfos.get(bstopInfos.size() - 1).setBstopNm(bstopNm);

                            is_bstopNm = false;
                        }
                        if (is_gpsX) {
                            gpsX = xpp.getText();
                            bstopInfos.get(bstopInfos.size() - 1).setGpsX(gpsX);

                            is_gpsX = false;
                        }
                        if (is_gpsY) {
                            gpsY = xpp.getText();
                            bstopInfos.get(bstopInfos.size() - 1).setGpsY(gpsY);

                            is_gpsY = false;
                        }
                        if (is_stoptype) {
                            stoptype = xpp.getText();
                            bstopInfos.get(bstopInfos.size() - 1).setStoptype(stoptype);

                            is_stoptype = false;
                        }

                    }else if (eventType == XmlPullParser.END_TAG){

                    }
                }eventType = xpp.next();
            }


        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bstopInfos.size();
    }
}
