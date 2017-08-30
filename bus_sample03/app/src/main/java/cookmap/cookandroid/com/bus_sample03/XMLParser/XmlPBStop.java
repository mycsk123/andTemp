package cookmap.cookandroid.com.bus_sample03.XMLParser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import cookmap.cookandroid.com.bus_sample03.Data.CBStop;

/**
 * Created by 8 on 2017-08-29.
 */

public class XmlPBStop {
    static public int getXmlPBStop(String response, ArrayList<CBStop> bsArrList){
        String arsNo = null;
        String bstopId = null;
        String nodeNm = null;
        String gpsX = null;
        String gpsY = null;
        String bustype = null;
        String lineNo = null;
        String lineid = null;
        String bstopidx = null;
        String carNo1 = null;
        String min1 = null;
        String station1 = null;
        String lowplate1 = null;
        String carNo2 = null;
        String min2 = null;
        String station2 = null;
        String lowplate2 = null;

        boolean is_arsNo = false;
        boolean is_bstopId = false;
        boolean is_nodeNm = false;
        boolean is_gpsX = false;
        boolean is_gpsY = false;
        boolean is_bustype = false;
        boolean is_lineNo = false;
        boolean is_lineid = false;
        boolean is_bstopidx = false;
        boolean is_carNo1 = false;
        boolean is_min1 = false;
        boolean is_station1 = false;
        boolean is_lowplate1 = false;
        boolean is_carNo2 = false;
        boolean is_min2 = false;
        boolean is_station2 = false;
        boolean is_lowplate2 = false;

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

                    if (tag_name.equals("arsNo")) {
                        is_arsNo = true;
                    }
                    if (tag_name.equals("bstopId")) {
                        is_bstopId = true;
                    }
                    if (tag_name.equals("nodeNm")) {
                        is_nodeNm = true;
                    }
                    if (tag_name.equals("gpsX")) {
                        is_gpsX = true;
                    }
                    if (tag_name.equals("gpsY")) {
                        is_gpsY = true;
                    }
                    if (tag_name.equals("bustype")) {
                        is_bustype = true;
                    }
                    if (tag_name.equals("lineNo")) {
                        is_lineNo = true;
                    }
                    if (tag_name.equals("lineid")) {
                        is_lineid = true;
                    }
                    if (tag_name.equals("bstopidx")) {
                        is_bstopidx = true;
                    }
                    if (tag_name.equals("carNo1")) {
                        is_carNo1 = true;
                    }
                    if (tag_name.equals("min1")) {
                        is_min1 = true;
                    }
                    if (tag_name.equals("station1")) {
                        is_station1 = true;
                    }
                    if (tag_name.equals("lowplate1")) {
                        is_lowplate1 = true;
                    }
                    if (tag_name.equals("carNo2")) {
                        is_carNo2 = true;
                    }
                    if (tag_name.equals("min2")) {
                        is_min2 = true;
                    }
                    if (tag_name.equals("station2")) {
                        is_station2 = true;
                    }
                    if (tag_name.equals("lowplate2")) {
                        is_lowplate2 = true;
                    }
                }else{
                    if (eventType == XmlPullParser.TEXT){
                        if(is_arsNo){
                            arsNo = xpp.getText();
                            bsArrList.add(new CBStop());
                            bsArrList.get(bsArrList.size() - 1).setArsNo(arsNo);

                            is_arsNo = false;
                        }
                        if(is_bstopId){
                            bstopId = xpp.getText();
                            bsArrList.get(bsArrList.size() - 1).setBstopId(bstopId);

                            is_bstopId = false;

                        }
                        if(is_nodeNm){
                            nodeNm = xpp.getText();
                            bsArrList.get(bsArrList.size() - 1).setNodeNm(nodeNm);

                            is_nodeNm = false;
                        }
                        if(is_gpsX){
                            gpsX = xpp.getText();
                            bsArrList.get(bsArrList.size() - 1).setGpsX(gpsX);

                            is_gpsX = false;
                        }
                        if(is_gpsY){
                            gpsY = xpp.getText();
                            bsArrList.get(bsArrList.size() - 1).setGpsY(gpsY);

                            is_gpsY = false;
                        }
                        if(is_bustype){
                            bustype = xpp.getText();
                            bsArrList.get(bsArrList.size() - 1).setBustype(bustype);

                            is_bustype = false;
                        }

                        if(is_lineNo){
                            lineNo = xpp.getText();
                            bsArrList.get(bsArrList.size() - 1).setLineNo(lineNo);

                            is_lineNo = false;
                        }
                        if(is_lineid){
                            lineid = xpp.getText();
                            bsArrList.get(bsArrList.size() - 1).setLineid(lineid);

                            is_lineid = false;
                        }
                        if(is_bstopidx){
                            bstopidx = xpp.getText();
                            bsArrList.get(bsArrList.size() - 1).setBstopidx(bstopidx);

                            is_bstopidx = false;
                        }
                        if(is_carNo1){
                            carNo1 = xpp.getText();
                            bsArrList.get(bsArrList.size() - 1).setCarNo1(carNo1);

                            is_carNo1 = false;
                        }
                        if(is_min1){
                            min1 = xpp.getText();
                            bsArrList.get(bsArrList.size() - 1).setMin1(min1);

                            is_min1 = false;
                        }
                        if(is_station1){
                            station1 = xpp.getText();
                            bsArrList.get(bsArrList.size() - 1).setStation1(station1);

                            is_station1 = false;
                        }
                        if(is_lowplate1){
                            lowplate1 = xpp.getText();
                            bsArrList.get(bsArrList.size() - 1).setLowplate1(lowplate1);

                            is_lowplate1 = false;
                        }
                        if(is_carNo2){
                            carNo2 = xpp.getText();
                            bsArrList.get(bsArrList.size() - 1).setCarNo2(carNo2);

                            is_carNo2 = false;
                        }
                        if(is_min2){
                            min2 = xpp.getText();
                            bsArrList.get(bsArrList.size() - 1).setMin2(min2);

                            is_min2 = false;
                        }
                        if(is_station2){
                            station2 = xpp.getText();
                            bsArrList.get(bsArrList.size() - 1).setStation2(station2);

                            is_station2 = false;
                        }
                        if(is_lowplate2){
                            lowplate2 = xpp.getText();
                            bsArrList.get(bsArrList.size() - 1).setLowplate2(lowplate2);

                            is_lowplate2 = false;
                        }
                    }else if (eventType == XmlPullParser.END_TAG){

                    }
                }
                eventType = xpp.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //return bsArrList;
        return bsArrList.size();

    }
}
