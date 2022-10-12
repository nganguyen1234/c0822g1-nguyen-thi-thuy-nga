//package z_extra_practice.chuyen_thanh_he_co_so_bat_ki;
//
//import java.lang.reflect.Array;
//
//public class Conversion {
//
//    private int soCanChuyen;
//    private int heCoSo;
//
//
//    public Conversion(int soCanChuyen, int heCoSo) {
//        this.soCanChuyen = soCanChuyen;
//        this.heCoSo = heCoSo;
//    }
//
//    public int getSoCanChuyen() {
//        return soCanChuyen;
//    }
//
//    public void setSoCanChuyen(int soCanChuyen) {
//        this.soCanChuyen = soCanChuyen;
//    }
//
//    public int getHeCoSo() {
//        return heCoSo;
//    }
//
//    public void setHeCoSo(int heCoSo) {
//        this.heCoSo = heCoSo;
//    }
//
//    public String converter() {
//        int soBiChia = soCanChuyen;
//        int soDu;
//        int count =0;
//        do {
//            soDu = soBiChia % heCoSo;
//            soBiChia /= heCoSo;
//            SoDu soDu1 = new SoDu(soDu);
//            count++;
//        } while (soDu != 0);
//        for (int i = count; i >= 0 ; i--) {
//            SoDu[count].get
//        }
//    }
//}
//
//class SoDu {
//    private int soDu;
//
//    public SoDu(int soDu) {
//        this.soDu = soDu;
//    }
//
//    public int getSoDu() {
//        return soDu;
//    }
//
//}