package cookmap.cookandroid.com.bus_sample03.Data;

/**
 * Created by 8 on 2017-08-28.
 */

public class CBStop {
    String arsNo; //정류소 번호
    String bstopId; //정류소ID
    String nodeNm; //정류소명
    String gpsX; //정류소GPS X좌표
    String gpsY; //정류소GPS Y좌표
    String bustype; //버스 종류
    String lineNo; //버스 번호
    String lineid; //노선ID
    String bstopidx; //노선 정류소 순번
    String carNo1; //차량번호(4자리)
    String min1; // 남은 도착시간(분)
    String station1; //남은 정류소 숫자
    String lowplate1; //0: 일반, 1: 저상
    String carNo2; //차량번호(4자리)
    String min2; //남은 도착시간(분)
    String station2; //남은 정류소 숫자
    String lowplate2; //0: 일반, 1: 저상

    public CBStop(){
        arsNo = null;
        bstopId = null;
        nodeNm = null;
        gpsX = null;
        gpsY = null;
        bustype = null;
        lineNo = null;
        lineid = null;
        bstopidx = null;
        carNo1 = null;
        min1 = null;
        station1 = null;
        lowplate1 = null;
        carNo2 = null;
        min2 = null;
        station2 = null;
        lowplate2 = null;
    }

}
