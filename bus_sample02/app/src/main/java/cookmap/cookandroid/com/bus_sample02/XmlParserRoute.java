package cookmap.cookandroid.com.bus_sample02;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by 8 on 2017-08-22.
 */

public class XmlParserRoute {
    static public int getBStopRouteXml(String response, ArrayList<BusByRoute> routeList){

        String arsNo = null;
        String avgtm = null;
        String bstopIdx = null;
        String bstopnm = null;
        String carNo = null;
        String direction = null;
        String gpsTm = null;
        String lat = null;
        String lon = null;
        String lineNo = null;
        String lowplate = null;
        String nodeId = null;
        String nodeKn = null;
        String rpoint = null;

        boolean is_arsNo = false;
        boolean is_avgtm = false;
        boolean is_bstopIdx = false;
        boolean is_bstopnm = false;
        boolean is_carNo = false;
        boolean is_direction = false;
        boolean is_gpsTm = false;
        boolean is_lat = false;
        boolean is_lon = false;
        boolean is_lineNo = false;
        boolean is_lowplate = false;
        boolean is_nodeId = false;
        boolean is_nodeKn = false;
        boolean is_rpoint = false;

        boolean isAction = false;

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
                    if (tag_name.equals("avgtm")) {
                        is_avgtm = true;
                    }
                    if (tag_name.equals("bstopIdx")) {
                        is_bstopIdx = true;
                    }
                    if (tag_name.equals("bstopnm")) {
                        is_bstopnm = true;
                    }
                    if (tag_name.equals("carNo")) {
                        is_carNo = true;
                    }
                    if (tag_name.equals("direction")) {
                        is_direction = true;
                    }
                    if (tag_name.equals("gpsTm")) {
                        is_gpsTm = true;
                    }
                    if (tag_name.equals("lat")) {
                        is_lat = true;
                    }
                    if (tag_name.equals("lon")) {
                        is_lon = true;
                    }
                    if (tag_name.equals("lineNo")) {
                        is_lineNo = true;
                    }
                    if (tag_name.equals("lowplate")) {
                        is_lowplate = true;
                    }
                    if (tag_name.equals("nodeId")) {
                        is_nodeId = true;
                    }
                    if (tag_name.equals("nodeKn")) {
                        is_nodeKn = true;
                    }
                    if (tag_name.equals("rpoint")) {
                        is_rpoint = true;
                    }
                }else {
                    if (eventType == XmlPullParser.TEXT) {
                        if (is_arsNo) {
                            isAction = true;

                            arsNo = xpp.getText();
                            routeList.add(new BusByRoute());
                            routeList.get(routeList.size() - 1).arsNo = arsNo;

                            is_arsNo = false;
                        }
                        if (is_avgtm) {

                            if(!isAction) {
                                routeList.add(new BusByRoute());
                            }

                            avgtm = xpp.getText();
                            routeList.get(routeList.size() - 1).avgtm = avgtm;

                            isAction = false;
                            is_avgtm = false;
                        }
                        if (is_bstopIdx) {
                            bstopIdx = xpp.getText();
                            routeList.get(routeList.size() - 1).bstopIdx = bstopIdx;

                            is_bstopIdx = false;
                        }
                        if (is_bstopnm) {
                            bstopnm = xpp.getText();
                            routeList.get(routeList.size() - 1).bstopnm = bstopnm;

                            is_bstopnm = false;
                        }
                        if (is_carNo) {
                            carNo = xpp.getText();
                            routeList.get(routeList.size() - 1).carNo = carNo;

                            is_carNo = false;
                        }
                        if (is_direction) {
                            direction = xpp.getText();
                            routeList.get(routeList.size() - 1).direction = direction;

                            is_direction = false;
                        }
                        if (is_gpsTm) {
                            gpsTm = xpp.getText();
                            routeList.get(routeList.size() - 1).gpsTm = gpsTm;

                            is_gpsTm = false;
                        }
                        if (is_lat) {
                            lat = xpp.getText();
                            routeList.get(routeList.size() - 1).lat = lat;

                            is_lat = false;
                        }
                        if (is_lon) {
                            lon = xpp.getText();
                            routeList.get(routeList.size() - 1).lon = lon;

                            is_lon = false;
                        }
                        if (is_lineNo) {
                            lineNo = xpp.getText();
                            routeList.get(routeList.size() - 1).lineNo = lineNo;

                            is_lineNo = false;
                        }
                        if (is_lowplate) {
                            lowplate = xpp.getText();
                            routeList.get(routeList.size() - 1).lowplate = lowplate;

                            is_lowplate = false;
                        }
                        if (is_nodeId) {
                            nodeId = xpp.getText();
                            routeList.get(routeList.size() - 1).nodeId = nodeId;

                            is_nodeId = false;
                        }
                        if (is_nodeKn) {
                            nodeKn = xpp.getText();
                            routeList.get(routeList.size() - 1).nodeKn = nodeKn;

                            is_nodeKn = false;
                        }
                        if (is_rpoint) {
                            rpoint = xpp.getText();
                            routeList.get(routeList.size() - 1).rpoint = rpoint;

                            is_rpoint = false;
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

        return routeList.size();
    }

}

