package model;

public class TrangThai {
    private int maTrangThai;
    private String trangThai;

    public TrangThai(int maTrangThai) {
        this.maTrangThai = maTrangThai;
    }

    public TrangThai(int maTrangThai, String trangThai) {
        this.maTrangThai = maTrangThai;
        this.trangThai = trangThai;
    }

    public int getMaTrangThai() {
        return maTrangThai;
    }

    public void setMaTrangThai(int maTrangThai) {
        this.maTrangThai = maTrangThai;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
