package cookmap.cookandroid.com.bus_sample02;

import java.io.Serializable;

/**
 * Created by 8 on 2017-08-22.
 */

public class BusInfo implements Serializable {
    String buslinenum; //버스 번호
    String bustype; //일반, 마을, 급행
    String companyid; //회사
    String lineId; //노선아이디
    String startpoint; //출발점
    String endpoint; //종착점
    String firsttime; //첫차 시간
    String endtime; //막차 시간
    String headway; //배차간격
    String headwayHoli; //배차간격(휴일)
    String headwayNorm; //배차간격(일반)
    String headwayPeak; //배차간격(출퇴근)

    public BusInfo(){
        buslinenum = null;
        bustype = null;
        companyid = null;
        lineId = null;
        startpoint = null;
        endpoint = null;
        firsttime = null;
        endtime = null;
        headway = null;
        headwayHoli = null;
        headwayNorm = null;
        headwayPeak = null;
    }

}
