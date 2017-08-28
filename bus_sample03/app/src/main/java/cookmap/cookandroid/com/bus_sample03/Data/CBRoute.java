package cookmap.cookandroid.com.bus_sample03.Data;

/**
 * Created by 8 on 2017-08-28.
 */

public class CBRoute {
    private String arsNo; //정류소 번호
    private String avgtm; //평균시간
    private String bstopIdx; //노선 정류소 순번
    private String bstopnm; //정류소 이름
    private String carNo; //버스 차량번호
    private String direction; //버스 운행 방향
    private String gpsTm; //HH24:MI:SS형식
    private String lat; //버스GPS X좌표
    private String lon; //버스GPS Y좌표
    private String lineNo; //노선번호
    private String lowplate; //저상버스 0: 일반, 1: 저상
    private String nodeId; //노드ID
    private String nodeKn; //노드종류(0: 교차로, 3:정류소)
    private String rpoint; //0: 일반, 1: 회차지

    public CBRoute(){
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

    public String getArsNo() {
        return arsNo;
    }

    public void setArsNo(String arsNo) {
        this.arsNo = arsNo;
    }

    public String getAvgtm() {
        return avgtm;
    }

    public void setAvgtm(String avgtm) {
        this.avgtm = avgtm;
    }

    public String getBstopIdx() {
        return bstopIdx;
    }

    public void setBstopIdx(String bstopIdx) {
        this.bstopIdx = bstopIdx;
    }

    public String getBstopnm() {
        return bstopnm;
    }

    public void setBstopnm(String bstopnm) {
        this.bstopnm = bstopnm;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getGpsTm() {
        return gpsTm;
    }

    public void setGpsTm(String gpsTm) {
        this.gpsTm = gpsTm;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLineNo() {
        return lineNo;
    }

    public void setLineNo(String lineNo) {
        this.lineNo = lineNo;
    }

    public String getLowplate() {
        return lowplate;
    }

    public void setLowplate(String lowplate) {
        this.lowplate = lowplate;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeKn() {
        return nodeKn;
    }

    public void setNodeKn(String nodeKn) {
        this.nodeKn = nodeKn;
    }

    public String getRpoint() {
        return rpoint;
    }

    public void setRpoint(String rpoint) {
        this.rpoint = rpoint;
    }
}
