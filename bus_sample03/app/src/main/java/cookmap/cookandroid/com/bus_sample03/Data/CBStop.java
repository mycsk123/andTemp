package cookmap.cookandroid.com.bus_sample03.Data;

/**
 * Created by 8 on 2017-08-28.
 */

public class CBStop {
    private String arsNo; //정류소 번호
    private String bstopId; //정류소ID
    private String nodeNm; //정류소명
    private String gpsX; //정류소GPS X좌표
    private String gpsY; //정류소GPS Y좌표
    private String bustype; //버스 종류
    private String lineNo; //버스 번호
    private String lineid; //노선ID
    private String bstopidx; //노선 정류소 순번
    private String carNo1; //차량번호(4자리)
    private String min1; // 남은 도착시간(분)
    private String station1; //남은 정류소 숫자
    private String lowplate1; //0: 일반, 1: 저상
    private String carNo2; //차량번호(4자리)
    private String min2; //남은 도착시간(분)
    private String station2; //남은 정류소 숫자
    private String lowplate2; //0: 일반, 1: 저상

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

    public String getArsNo() {
        return arsNo;
    }

    public void setArsNo(String arsNo) {
        this.arsNo = arsNo;
    }

    public String getBstopId() {
        return bstopId;
    }

    public void setBstopId(String bstopId) {
        this.bstopId = bstopId;
    }

    public String getNodeNm() {
        return nodeNm;
    }

    public void setNodeNm(String nodeNm) {
        this.nodeNm = nodeNm;
    }

    public String getGpsX() {
        return gpsX;
    }

    public void setGpsX(String gpsX) {
        this.gpsX = gpsX;
    }

    public String getGpsY() {
        return gpsY;
    }

    public void setGpsY(String gpsY) {
        this.gpsY = gpsY;
    }

    public String getBustype() {
        return bustype;
    }

    public void setBustype(String bustype) {
        this.bustype = bustype;
    }

    public String getLineNo() {
        return lineNo;
    }

    public void setLineNo(String lineNo) {
        this.lineNo = lineNo;
    }

    public String getLineid() {
        return lineid;
    }

    public void setLineid(String lineid) {
        this.lineid = lineid;
    }

    public String getBstopidx() {
        return bstopidx;
    }

    public void setBstopidx(String bstopidx) {
        this.bstopidx = bstopidx;
    }

    public String getCarNo1() {
        return carNo1;
    }

    public void setCarNo1(String carNo1) {
        this.carNo1 = carNo1;
    }

    public String getMin1() {
        return min1;
    }

    public void setMin1(String min1) {
        this.min1 = min1;
    }

    public String getStation1() {
        return station1;
    }

    public void setStation1(String station1) {
        this.station1 = station1;
    }

    public String getLowplate1() {
        return lowplate1;
    }

    public void setLowplate1(String lowplate1) {
        this.lowplate1 = lowplate1;
    }

    public String getCarNo2() {
        return carNo2;
    }

    public void setCarNo2(String carNo2) {
        this.carNo2 = carNo2;
    }

    public String getMin2() {
        return min2;
    }

    public void setMin2(String min2) {
        this.min2 = min2;
    }

    public String getStation2() {
        return station2;
    }

    public void setStation2(String station2) {
        this.station2 = station2;
    }

    public String getLowplate2() {
        return lowplate2;
    }

    public void setLowplate2(String lowplate2) {
        this.lowplate2 = lowplate2;
    }
}
