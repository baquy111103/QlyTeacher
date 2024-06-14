public class QlKekhaigiangday {
    private Giangvien giangvien ;
    private Monhoc[] monhoc;
    private int soTiet;
    private int[] sot;

    public QlKekhaigiangday(Giangvien giangvien) {
        this.giangvien = giangvien;
        this.monhoc = new Monhoc[30];
        this.soTiet = 0;
    }

    public Giangvien getGiangvien() {
        return giangvien;
    }

    public int getTongSoLuongTiet(){
        int total = 0;
        for (int i = 0; i < soTiet; i++) {
            total+=sot[i];
        }
        return total;
    }

    public int getSoTiet() {
        return soTiet;
    }

    public Monhoc[] getMonhoc() {
        return monhoc;
    }

    public int[] getSot() {
        return sot;
    }

    public boolean giangDay(Monhoc monhoc , int soLop) {
        if(soTiet < 200 || soLop < 3) return false;
        for (int i = 0; i < soTiet; i++) {
            if(this.monhoc[i].getMaMonhoc() == monhoc.getMaMonhoc()) {
                this.sot[i] +=soLop;
                return true;
            }
        }
        this.monhoc[soTiet] =monhoc;
        this.sot[soTiet] =soLop;
        soTiet++;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(giangvien.getHoTen()+" có trình độ "+giangvien.getTrinhDo()+" dạy :");
        for (int i = 0; i < soTiet; i++) {
            result.append("\n\t" +monhoc[i].getTenMonhoc()+ " - " + sot[i] + " lớp");
        }
        return result.toString();
    }
}
