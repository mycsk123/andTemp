package cookmap.cookandroid.com.bus_sample03.Data;

/**
 * Created by 8 on 2017-08-29.
 */

public class CBStopInfo {
    private String bstopArsno; //정류소번호
    private String bstopId; //정류소아이디
    private String bstopNm; //정류소명
    private String gpsX; //GPS X좌표
    private String gpsY; //GPS Y좌표
    private String stoptype; //정류소구분 - 일반, 마을

    public CBStopInfo() {
        bstopArsno = null;
        bstopId = null;
        bstopNm = null;
        gpsX = null;
        gpsY = null;
        stoptype = null;
    }

    public String getBstopArsno() {
        return bstopArsno;
    }

    public void setBstopArsno(String bstopArsno) {
        this.bstopArsno = bstopArsno;
    }

    public String getBstopId() {
        return bstopId;
    }

    public void setBstopId(String bstopId) {
        this.bstopId = bstopId;
    }

    public String getBstopNm() {
        return bstopNm;
    }

    public void setBstopNm(String bstopNm) {
        this.bstopNm = bstopNm;
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

    public String getStoptype() {
        return stoptype;
    }

    public void setStoptype(String stoptype) {
        this.stoptype = stoptype;
    }
}
