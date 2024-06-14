import java.util.Scanner;

public class Mananegement {
    private static Giangvien[] giangviens = new Giangvien[10];
    private static Monhoc[] monhocs = new Monhoc[10];
    private static QlKekhaigiangday[] qlKekhaigiangdays = new QlKekhaigiangday[10];
    private static int giangvienCount = 0;
    private static int monhocCount = 0;
    private static int qlKekhaigiangdayCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Nhập danh sách môn học mới và in ra");
            System.out.println("2. Nhập danh sách giảng viên mới và in ra");
            System.out.println("3. Lập bảng kê khai giảng dạy cho mỗi giảng viên và in ra");
            System.out.println("4. Tính lương và hiển thị !!");
            System.out.println("0. Thoát");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    nhapMonhocMoi();
                    inMonhocMoi();
                    break;
                case 2:
                    nhapGiangvienMoi();
                    inDanhsachGiangvien();
                    break;
                case 3:
                    lapBangQlykekhaigiangday();
                    inDanhSachGiangDay();
                case 4:
                    tinhLuongChoGiangVien();
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
    private static void nhapMonhocMoi(){
        System.out.println("Nhập số lượng môn học mới :");
        int soLuongMonhocMoi = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < soLuongMonhocMoi; i++) {
            System.out.println("Nhập thông tin môn học "+(i+1)+":");
            System.out.print("Nhập tên môn học : ");
            String tenMonhoc = scanner.nextLine();
            System.out.print("Tổng số tiết : ");
            int tongSotiet = Integer.parseInt(scanner.nextLine());
            System.out.print("Số tiết lý thuyết : ");
            int soTietLythuyet = Integer.parseInt(scanner.nextLine());
            System.out.println("Mức kinh phí : ");
            int mucKinhphi = Integer.parseInt(scanner.nextLine());
            monhocs[monhocCount++] = new Monhoc(tenMonhoc,tongSotiet,soTietLythuyet,mucKinhphi);
        }
    }
    private static void inMonhocMoi(){
        System.out.println("Danh sách các môn học : ");
        for (int i = 0; i < monhocCount; i++) {
            System.out.println(monhocs[i]);
        }
    }

    private static void nhapGiangvienMoi(){
        System.out.println("Nhập số lượng giảng viên mới :");
        int soLuongGiangvienMoi = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < soLuongGiangvienMoi; i++) {
            System.out.println("Nhập thông tin giảng viên "+(i+1)+":");
            System.out.print("Nhập tên giảng viên : ");
            String hoTen = scanner.nextLine();
            System.out.print("Địa chỉ: ");
            String diaChi = scanner.nextLine();
            System.out.print("SĐT: ");
            String sdt = scanner.nextLine();
            System.out.println("Trình độ : ");
            System.out.println("1.GS-TS \n2.PGS-TS \n3.Giảng viên chính \n4.Thạc sỹ");
            int trinhdoOption = Integer.parseInt(scanner.nextLine());
            String trinhDo = "";
            switch (trinhdoOption){
                case 1:
                    trinhDo = "GS-TS";
                    break;
                case 2:
                    trinhDo = "PGS-TS";
                    break;
                case 3:
                    trinhDo = "Giảng viên chính";
                    break;
                case 4:
                    trinhDo = "Thạc sỹ";
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ , mặc định phải là 'Thạc sỹ' ");
                    trinhDo = "Thạc sỹ";
                    break;
                }
                giangviens[giangvienCount++] = new Giangvien(hoTen,diaChi,sdt,trinhDo);
        }
    }
    private static void inDanhsachGiangvien(){
        System.out.println("Danh sách giảng viên : ");
        for (int i = 0; i < giangvienCount; i++) {
            System.out.println(giangviens[i]);
        }
    }

    private static void lapBangQlykekhaigiangday(){
        System.out.println("Nhập mã giảng viên: ");
        int maGV = Integer.parseInt(scanner.nextLine());
        Giangvien giangvien = null;
        for(int i = 0; i < giangvienCount;i++){
            giangvien =giangviens[i];
            break;
        }
        if(giangvien == null){
            System.out.println("Không tìm thấy giảng viên!");
            return;
        }
        QlKekhaigiangday qlKekhaigiangday = new QlKekhaigiangday(giangvien);
        while (true){
            System.out.println("Nhập mã Môn học muốn giảng dạy (0 để kết thúc):");
            int maMonhoc = Integer.parseInt(scanner.nextLine());
            if(maMonhoc == 0) break;
            Monhoc monhoc = null;
            for (int i =0 ;i < monhocCount;i++){
                if(monhocs[i].getMaMonhoc()==maMonhoc){
                    monhoc = monhocs[i];
                    break;
                }
            }
            if(monhoc == null){
                System.out.println("Không tìm thấy môn học này !");
                continue;
            }
            System.out.print("Nhập số lớp muốn giảng dạy môn học này : ");
            int soLop = Integer.parseInt(scanner.nextLine());
            if(!qlKekhaigiangday.giangDay(monhoc , soLop)){
                System.out.println("Không thể nhận thêm lớp vì lớp đăng kí không lớn hơn 3 lớp!!");
            }
        }
        qlKekhaigiangdays[qlKekhaigiangdayCount++] = qlKekhaigiangday;
    }
    private static void inDanhSachGiangDay(){
        System.out.println("Danh sách giảng viên giảng dạy : ");
        for(int i = 0;i<qlKekhaigiangdayCount;i++){
            System.out.println(qlKekhaigiangdays[i]);
        }
    }

    private static void sapXepQLKekhai(){
        System.out.println("1. Sắp xếp theo tên giảng viên");
        System.out.println("2. Sắp xếp theo số lượng tiết giảng dạy");
        int choice = Integer.parseInt(scanner.nextLine());
        if(choice == 1){
            for (int i = 0; i< qlKekhaigiangdayCount -1;i++){
                for(int j = i+1;j<qlKekhaigiangdayCount;j++){
                    if(qlKekhaigiangdays[i].getGiangvien().getHoTen().compareTo(qlKekhaigiangdays[j].getGiangvien().getHoTen()) > 0){
                        QlKekhaigiangday temp = qlKekhaigiangdays[i];
                        qlKekhaigiangdays[i]= qlKekhaigiangdays[j];
                        qlKekhaigiangdays[j]= temp;
                    }
                }
            }
        } else if (choice==2) {
            for(int i = 0 ;i <qlKekhaigiangdayCount-1;i++){
                for(int j = i+1;j<qlKekhaigiangdayCount;j++){
                    if(qlKekhaigiangdays[i].getTongSoLuongTiet() < qlKekhaigiangdays[i].getTongSoLuongTiet()){
                        QlKekhaigiangday temp = qlKekhaigiangdays[i];
                        qlKekhaigiangdays[i]=qlKekhaigiangdays[j];
                        qlKekhaigiangdays[j]=temp;
                    }
                }
            }
        }
        else{
            System.out.println("Lựa chọn không hợp lệ !! Vui lòng chọn 1 hoặc 2 !");
        }
    }
    private static void tinhLuongChoGiangVien() {
        System.out.println("Mức lương của các giảng viên:");
        for (int i = 0; i < qlKekhaigiangdayCount; i++) {
            QlKekhaigiangday ql = qlKekhaigiangdays[i];
            Giangvien giangvien = ql.getGiangvien();
            double luong = tinhLuong(giangvien, ql);
            System.out.println(giangvien.getHoTen() + " - " + giangvien.getTrinhDo() + " - " + luong);
        }
    }

    private static double tinhLuong(Giangvien giangvien, QlKekhaigiangday ql) {
        double luong = 0;
        for (int i = 0; i < ql.getSoTiet(); i++) {
            Monhoc monhoc = ql.getMonhoc()[i];
            int soLop = ql.getSot()[i];
            // Tính toán mức lương từng môn học dựa trên số tiết dạy và mức kinh phí
            luong += monhoc.tinhMucKinhPhi() * soLop;
        }
        return luong;
    }



}
