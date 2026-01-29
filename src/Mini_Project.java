import java.util.Scanner;

public class Mini_Project {

    public static void twoSum(int[] arrays, int target) {

        for (int i = 0; i < arrays.length; i++) {
            for (int j = i + 1; j < arrays.length; j++) {
                if (arrays[i] + arrays[j] == target) {
                    System.out.printf(" [%d,%d]  \n", i, j);
                    return;
                }
            }
        }

        System.out.println("Không có phần tử nào phù hợp!");

    }

    public static void moveZero(int[] arrays) {
        int index = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] != 0) {
                System.out.println("Trước khi hoán đổi ");
                System.out.printf("Array[%d] : %d \n Array[%d] : %d \n", i, arrays[i], index, arrays[index]);
                arrays[index] = arrays[i];
                index++;
                System.out.printf(" ");
                System.out.println("Sau khi hoán đổi ");
                System.out.printf("Array[%d] : %d \n Array[%d] : %d \n", i, arrays[i], index, arrays[index]);
            }
        }

        for (int i = index; i < arrays.length; i++) {
            arrays[i] = 0;
        }
    }


    public static boolean ValidPalindrome(String str) {
        String regex = "[^A-Za-z]";

        String temp = str.replaceAll(regex, "").toLowerCase();

        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) != temp.charAt(temp.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static String reverseString(String str) {
        String[] temp = str.trim().split("\\s+");

        StringBuilder strBuilder = new StringBuilder();
        for (int i = temp.length - 1; i >= 0; i--) {
            strBuilder.append(temp[i]);
        }

        String tempString = strBuilder.toString();

        return tempString;
    }

    public static void happyNumber(int number) {

        while (number != 1 && number != 4) {
            number = sumSquare(number);
        }

        if (number == 1) {
            System.out.println("Số của bạn là số hoàn hảo");
        }

        if (number == 4) {
            System.out.println("Số của bạn không phải là số hoàn hảo");
        }
    }

    public static int sumSquare(int number) {
        int sum = 0;

        while (number > 0) {
            int digit = number % 10;

            sum += (digit * digit);

            number = number / 10;
        }
        return sum;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;


        do {
            int size;
            int[] arrays;
            String str;
            System.out.println("=========== MENU ==============");
            System.out.println("1.Tìm cặp số có tổng bằng K (Two Sum)");
            System.out.println("2.Dồn số 0 về cuối (Move Zeroes)");
            System.out.println("3.Kiểm tra chuỗi đối xứng (Valid Palindrome)");
            System.out.println("4.Đảo ngược từ trong câu (Reverse Words)");
            System.out.println("5.Số hạnh phúc (Happy Number)");
            System.out.println("0. Thoát");

            System.out.print("Mời bạn nhập lựa chọn : ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    int target;

                    System.out.print("Mời nhập phần tử n để tìm các cặp số : ");
                    target = sc.nextInt();

                    System.out.print("Mời nhập số lượng phần tử trong mảng : ");
                    size = sc.nextInt();

                    if (size < 0) {
                        System.out.println("Kích thước mảng không hợp lệ!");
                        break;
                    }

                    arrays = new int[size];

                    for (int i = 0; i < size; i++) {
                        int element;
                        System.out.printf("Nhập phần tử thứ %d : ", i + 1);
                        element = sc.nextInt();
                        arrays[i] = element;
                    }

                    twoSum(arrays, target);

                    break;
                case 2:


                    System.out.print("Mời nhập số lượng phần tử trong mảng : ");
                    size = sc.nextInt();

                    if (size < 0) {
                        System.out.println("Kích thước mảng không hợp lệ!");
                        break;
                    }

                    arrays = new int[size];

                    for (int i = 0; i < size; i++) {
                        int element;
                        System.out.printf("Nhập phần tử thứ %d : ", i + 1);
                        element = sc.nextInt();
                        arrays[i] = element;
                    }

                    moveZero(arrays);

                    System.out.println("Mảng sau khi thay đổi là : ");
                    for (int i = 0; i < arrays.length; i++) {
                        System.out.printf("%d \n", arrays[i]);
                    }
                    break;
                case 3:


                    System.out.println("Nhập chuỗi kí tự kiểm tra đối xứng : ");
                    str = sc.nextLine();

                    if (ValidPalindrome(str)) {
                        System.out.println("Chuỗi bạn nhập vào là chuỗi đối xứng");
                    } else {
                        System.out.println("Chuỗi bạn nhập vào không phải là chuỗi đối xứng");
                    }

                    break;
                case 4:

                    System.out.println("Nhập chuỗi kí tự để đảo ngược : ");
                    str = sc.nextLine();

                    System.out.println("Chuỗi trước khi đảo ngược : " + str);

                    String tempString = reverseString(str);

                    System.out.println("Chuỗi sau khi đảo ngược : " + tempString);


                    break;
                case 5:

                    int number;

                    System.out.println("Nhập số để kiểm tra (Số hạnh phúc): ");
                    number = sc.nextInt();

                    happyNumber(number);
                    break;
                case 0:
                    System.out.println("Bạn đã thoát chương trình");
                    break;
                default:
                    System.out.println("Lỗi : Lựa chọn của bạn không hợp lệ");
            }
        } while (choice != 0);
    }
}
