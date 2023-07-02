import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static final String FILENAME = "toys.csv";

    public static void main(String[] args) {

        try{
            ToyShop shop = new ToyShop();
            File toyFile = new File(FILENAME);

            if (!toyFile.exists()){
                toyFile.createNewFile();
                shop.add(new Toy(1, "Пожарная машина", 5, 20));
                shop.add(new Toy(2, "Водный пистолет", 3, 10));
                shop.add(new Toy(3, "Мусоровоз", 10, 50));
                shop.add(new Toy(4, "Бадминтон", 3, 10));
                shop.add(new Toy(5, "Сачок", 8, 15));
                shop.saveToFile(FILENAME);
            } else {
                shop.loadFromFile(FILENAME);
            }

            shop.setWeight(1, 25); // Изменить вес первой игрушки на 25%

            ArrayList<String> toyList = shop.getToyList(); // Получить список игрушек в магазине
            for (String toy : toyList){
                System.out.println(toy);
            }

            ArrayList<Toy> winners = shop.playGame(5); //Разыграть 3 игрушки
            System.out.println("Выиграли следующие игрушки: ");
            for (Toy t : winners){
                System.out.println(t.getName());
            }

            shop.saveToFile(FILENAME); // Сохранить данные об игрушках в файл

        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлами: " + e.getMessage());
        }
    }
}
