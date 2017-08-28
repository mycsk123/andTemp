package cookmap.cookandroid.com.bus_sample02;

/**
 * Created by 8 on 2017-08-22.
 */

public class BusByRoute {
    String arsNo; //정류소 번호
    String avgtm; //평균시간
    String bstopIdx; //노선 정류소 순번
    String bstopnm; //정류소 이름
    String carNo; //버스 차량번호
    String direction; //버스 운행 방향
    String gpsTm; //HH24:MI:SS형식
    String lat; //버스GPS X좌표
    String lon; //버스GPS Y좌표
    String lineNo; //노선번호
    String lowplate; //저상버스 0: 일반, 1: 저상
    String nodeId; //노드ID
    String nodeKn; //노드종류(0: 교차로, 3:정류소)
    String rpoint; //0: 일반, 1: 회차지

    public BusByRoute(){
        arsNo = null;
        avgtm = null;
        bstopIdx = null;
        bstopnm = null;
        carNo = null;
        direction = null;
        gpsTm = null;
        lat = null;
        lon = null;
        lineNo = null;
        lowplate = null;
        nodeId = null;
        nodeKn = null;
        rpoint = null;
    }
}
