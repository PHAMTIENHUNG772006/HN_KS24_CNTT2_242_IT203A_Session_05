import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Bai_exam01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = new String[100];
        int count = 0;
        String regex = "^B(\\d{7})";
        int choice;


        do {

            System.out.println("1.In ra danh sách MSSV hiện có");
            System.out.println("2.Yêu cầu nhập MSSV mới");
            System.out.println("3.Nhập vị trí (index) cần sửa, kiểm tra tính hợp lệ của index và cho phép nhập MSSV mới (cũng phải thỏa mãn Regex)");
            System.out.println("4.Nhập một MSSV cụ thể. Nếu tìm thấy, thực hiện xóa và dồn mảng để đảm bảo tính liên tục");
            System.out.println("5.Tìm kiếm (Regex): Nhập một chuỗi ký tự bất kỳ từ bàn phím\n");
            System.out.println("6. Thoát");

            System.out.print("Mời bạn nhập lựa chọn : ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:

                    if (count == 0){
                        System.out.println("Trong danh sách không có sv nào");
                    }
                    for (int i = 0; i < count; i++) {
                        System.out.printf("Sinh viên số %d có mã là %s \n", i + 1, arr[i]);
                    }
                    break;
                case 2:

                    String studentID;

                    if (count == 100){
                        System.out.println("Danh sách đã đầy không thể nhập");
                        return;
                    }
                    while (true){

                        System.out.print("Mời bạn nhập mã sinh viên (B0000000): ");
                        studentID = sc.nextLine();

                        if(studentID.matches(regex)){
                           break;
                        }else {
                            System.out.println("Mã sinh viên không hợp lệ, vui lòng nhập lại");
                        }
                    }
                    arr[count] = studentID;
                    System.out.printf("Mã sinh viên mới thêm là %s \n",studentID);
                    count++;
                    break;
                case 3:
                    int index ;

                    System.out.print("Mời bạn nhập index: ");
                    index = sc.nextInt();
                    sc.nextLine();

                    while (true){

                        System.out.print("Mời bạn nhập mã sinh viên (B0000000): ");
                        studentID = sc.nextLine();

                        if(studentID.matches(regex)){
                            break;
                        }else {
                            System.out.println("Mã sinh viên không hợp lệ, vui lòng nhập lại");
                        }
                    }

                    if (index < 0 || index > 99){
                        System.out.println("Index không hợp lệ");
                    }else {
                        System.out.printf("Mã sinh viên trước khi cập nhật : %s \n", arr[index]);
                        arr[index] = studentID;
                        System.out.printf("Mã sinh viên sau khi cập nhật : %s \n", studentID);
                    }
                    break;
                case 4:
                    System.out.print("Mời bạn nhập mã sinh viên cần xóa (B0000000): ");
                    String studentIdDelete = sc.nextLine();
                    boolean found = false;
                    int indexDelete = -1;

                    for (int i = 0; i < count; i++) {
                        if (arr[i].equals(studentIdDelete)) {
                            indexDelete = i;
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        for (int i = indexDelete; i < count - 1; i++) {
                            arr[i] = arr[i + 1];
                        }
                        count--;
                        System.out.printf("Đã xóa MSSV %s thành công!\n", studentIdDelete);
                    } else {
                        System.out.println("Không tìm thấy MSSV cần xóa!");
                    }
                    break;

                case 5:
                    String word;

                    System.out.println("nhập chuỗi kí tự : ");
                    word = sc.nextLine();

                    for (int i = 0; i < count; i++) {
                        if (arr[i].toLowerCase().contains(word.toLowerCase())){
                            System.out.printf("Mã sinh viên tìm thấy là : %s \n",arr[i]);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Thoát chương trình thành công");
                    break;
                default:
                    System.out.println("Lỗi : nhập lựa chọn không hợp lệ ");
            }
        }while (choice != 6);
    }
}