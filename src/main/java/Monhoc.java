public class Monhoc {
    private static int currentId =100;
    private int maMonhoc;
    private String tenMonhoc;
    private int tongSotiet;
    private int soTietLythuyet;
    private double mucKinhphi;

    public Monhoc(String tenMonhoc, int tongSotiet, int soTietLythuyet, double mucKinhphi) {
        this.maMonhoc = currentId++;
        this.tenMonhoc = tenMonhoc;
        this.tongSotiet = tongSotiet;
        this.soTietLythuyet = soTietLythuyet;
        this.mucKinhphi = mucKinhphi;
    }

    public int getMaMonhoc() {
        return maMonhoc;
    }
    public String getTenMonhoc() {
        return tenMonhoc;
    }

    public void setTenMonhoc(String tenMonhoc) {
        this.tenMonhoc = tenMonhoc;
    }

    public int getTongSotiet() {
        return tongSotiet;
    }

    public void setTongSotiet(int tongSotiet) {
        this.tongSotiet = tongSotiet;
    }

    public int getSoTietLythuyet() {
        return soTietLythuyet;
    }

    public void setSoTietLythuyet(int soTietLythuyet) {
        this.soTietLythuyet = soTietLythuyet;
    }

    public double getMucKinhphi() {
        return mucKinhphi;
    }

    public void setMucKinhphi(double mucKinhphi) {
        this.mucKinhphi = mucKinhphi;
    }
    //Tinh muc kinh phi cho cac tiet thuc hanh
    public double tinhMucKinhPhi(){
        return (0.7 * mucKinhphi * soTietLythuyet)+(mucKinhphi * soTietLythuyet);
    }
    @Override
    public String toString() {
            return "Mã môn học: " + maMonhoc +
                    ", Tên môn: " + tenMonhoc +
                    ", Tổng số tiết: " + tongSotiet +
                    ", Số tiết lý thuyết: " + soTietLythuyet +
                    ", Mức kinh phí: " + mucKinhphi;
    }
}

