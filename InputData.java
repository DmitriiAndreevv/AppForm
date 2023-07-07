import java.util.Scanner;

public class InputData {
    public String[] en_data() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n"+"Введите строку через пробел(строка должна содержать Ф.И.О, дату рождения, номер телефона,пол: )");
            String data = scanner.nextLine();
            String[] arrayD = data.split(" ");
            if (arrayD.length == 6) {
                return arrayD;
            } else if (arrayD.length < 6) {
                System.out.println("вы ввели не все данные, пожалуйста, повторите попытку");
            } else System.out.println("вы ввели дополнительные данные, пожалуйста, повторите попытку");
        }
    }
}
