public class Giangvien {
    private static int currentId = 100;
    private int maGV;
    private String hoTen;
    private String diaChi;
    private String sdt;
    private String trinhDo;

    public Giangvien(String hoTen, String diaChi, String sdt, String trinhDo) {
        this.maGV = currentId++;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.trinhDo = trinhDo;
    }

    public int getMaGV() {
        return maGV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    @Override
    public String toString() {
        return maGV + " - " + hoTen + " - " + sdt + " - " + trinhDo;
    }
}
