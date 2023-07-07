import java.util.HashMap;
import java.io.IOException;

public class Progm {
    public static void main(String[] args) {
        ParsData parsData = new ParsData(); // Создается объект класса ParsData
        String fileName = null;              // Инициализация переменной
        FileWriter_w writerW = new FileWriter_w(); // Создается объект класса WriteFile

        HashMap<String, Object> data = parsData.parsInputData();
        while (data.size() != 6) {
            try {
                throw new DataException();
            } catch (DataException e) {
                data = parsData.parsInputData();
            }
        } // // Цикл для ввода данных.

        fileName = data.get("lastName") + ".txt"; // Указывается файл для записи данных пользователя
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : data.keySet()) {
            stringBuilder.append(data.get(str));
            stringBuilder.append(" ");
        }
        System.out.println(data);
        String filePath = fileName;
        System.out.println(filePath);
        writerW.writeData(String.valueOf(stringBuilder), filePath); // Вызывается метод класса WriteFile для записи в файл

    }
}
