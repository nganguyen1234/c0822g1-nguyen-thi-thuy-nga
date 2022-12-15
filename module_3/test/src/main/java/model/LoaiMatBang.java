package model;

public class LoaiMatBang {
    private int maLoai;
    private String tenLoai;

    public LoaiMatBang(int maLoai) {
        this.maLoai = maLoai;
    }

    public LoaiMatBang(int maLoai, String tenLoai) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }
}
