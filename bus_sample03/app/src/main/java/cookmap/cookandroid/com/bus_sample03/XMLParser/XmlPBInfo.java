package cookmap.cookandroid.com.bus_sample03.XMLParser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import cookmap.cookandroid.com.bus_sample03.Data.CBInfo;

/**
 * Created by 8 on 2017-08-28.
 */

public class XmlPBInfo {

    static public int getXmlPBInfo(String response, ArrayList<CBInfo> busList){

        String buslinenum = null;
        String bustype = null;
        String companyid = null;
        String lineId = null;
        String startpoint = null;
        String endpoint = null;
        String firsttime = null;
        String endtime = null;
        String headway = null;
        String headwayHoli = null;
        String headwayNorm = null;
        String headwayPeak = null;

        boolean is_buslinenum = false;
        boolean is_bustype = false;
        boolean is_companyid = false;
        boolean is_lineId = false;
        boolean is_startpoint = false;
        boolean is_endpoint = false;
        boolean is_firsttime = false;
        boolean is_endtime = false;
        boolean is_headway = false;
        boolean is_headwayHoli = false;
        boolean is_headwayNorm = false;
        boolean is_headwayPeak = false;

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

                    if (tag_name.equals("buslinenum")) {
                        is_buslinenum = true;
                    }
                    if (tag_name.equals("bustype")) {
                        is_bustype = true;
                    }
                    if (tag_name.equals("companyid")) {
                        is_companyid = true;
                    }
                    if (tag_name.equals("lineId")) {
                        is_lineId = true;
                    }
                    if (tag_name.equals("startpoint")) {
                        is_startpoint = true;
                    }
                    if (tag_name.equals("endpoint")) {
                        is_endpoint = true;
                    }
                    if (tag_name.equals("firsttime")) {
                        is_firsttime = true;
                    }
                    if (tag_name.equals("endtime")) {
                        is_endtime = true;
                    }
                    if (tag_name.equals("headway")) {
                        is_headway = true;
                    }
                    if (tag_name.equals("headwayHoli")) {
                        is_headwayHoli = true;
                    }
                    if (tag_name.equals("headwayNorm")) {
                        is_headwayNorm = true;
                    }
                    if (tag_name.equals("headwayPeak")) {
                        is_headwayPeak = true;
                    }
                }else {
                    if (eventType == XmlPullParser.TEXT) {
                        if (is_buslinenum) {
                            buslinenum = xpp.getText();
                            busList.add(new CBInfo());
                            busList.get(busList.size() - 1).setBuslinenum(buslinenum);

                            is_buslinenum = false;
                        }
                        if (is_bustype) {
                            bustype = xpp.getText();
                            busList.get(busList.size() - 1).setBustype(bustype);

                            is_bustype = false;
                        }
                        if (is_companyid) {
                            companyid = xpp.getText();
                            busList.get(busList.size() - 1).setCompanyid(companyid);

                            is_companyid = false;
                        }
                        if (is_lineId) {
                            lineId = xpp.getText();
                            busList.get(busList.size() - 1).setLineId(lineId);

                            is_lineId = false;
                        }
                        if (is_startpoint) {
                            startpoint = xpp.getText();
                            busList.get(busList.size() - 1).setStartpoint(startpoint);

                            is_startpoint = false;
                        }
                        if (is_endpoint) {
                            endpoint = xpp.getText();
                            busList.get(busList.size() - 1).setEndpoint(endpoint);

                            is_endpoint = false;
                        }
                        if (is_firsttime) {
                            firsttime = xpp.getText();
                            busList.get(busList.size() - 1).setFirsttime(firsttime);

                            is_firsttime = false;
                        }
                        if (is_endtime) {
                            endtime = xpp.getText();
                            busList.get(busList.size() - 1).setEndtime(endtime);

                            is_endtime = false;
                        }
                        if (is_headway) {
                            headway = xpp.getText();
                            busList.get(busList.size() - 1).setHeadway(headway);

                            is_headway = false;
                        }
                        if (is_headwayHoli) {
                            headwayHoli = xpp.getText();
                            busList.get(busList.size() - 1).setHeadwayHoli(headwayHoli);

                            is_headwayHoli = false;
                        }
                        if (is_headwayNorm) {
                            headwayNorm = xpp.getText();
                            busList.get(busList.size() - 1).setHeadwayNorm(headwayNorm);

                            is_headwayNorm = false;
                        }
                        if (is_headwayPeak) {
                            headwayPeak = xpp.getText();
                            busList.get(busList.size() - 1).setHeadwayPeak(headwayPeak);

                            is_headwayPeak = false;
                        }

                    } else if (eventType == XmlPullParser.END_TAG) {

                    }
                }
                eventType = xpp.next();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return busList.size();
    }



}
