package model;

public class MatBang {
private String maMatBang;
private double dienTich;
private TrangThai trangThai;
private int tang;
private LoaiMatBang loaiMatBang;
private String moTa;
private double giaChoThue;
private String ngayBatDau;
private String ngayKetThuc;

    public MatBang(String maMatBang, double dienTich, TrangThai trangThai, int tang, LoaiMatBang loaiMatBang, String moTa, double giaChoThue, String ngayBatDau, String ngayKetThuc) {
        this.maMatBang = maMatBang;
        this.dienTich = dienTich;
        this.trangThai = trangThai;
        this.tang = tang;
        this.loaiMatBang = loaiMatBang;
        this.moTa = moTa;
        this.giaChoThue = giaChoThue;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public MatBang(double dienTich, TrangThai trangThai, int tang, LoaiMatBang loaiMatBang, String moTa, double giaChoThue, String ngayBatDau, String ngayKetThuc) {
        this.dienTich = dienTich;
        this.trangThai = trangThai;
        this.tang = tang;
        this.loaiMatBang = loaiMatBang;
        this.moTa = moTa;
        this.giaChoThue = giaChoThue;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMaMatBang() {
        return maMatBang;
    }

    public void setMaMatBang(String maMatBang) {
        this.maMatBang = maMatBang;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public TrangThai getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TrangThai trangThai) {
        this.trangThai = trangThai;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public LoaiMatBang getLoaiMatBang() {
        return loaiMatBang;
    }

    public void setLoaiMatBang(LoaiMatBang loaiMatBang) {
        this.loaiMatBang = loaiMatBang;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public double getGiaChoThue() {
        return giaChoThue;
    }

    public void setGiaChoThue(double giaChoThue) {
        this.giaChoThue = giaChoThue;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
}
