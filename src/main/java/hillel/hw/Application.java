package src.main.java.hillel.hw;

public class Application {
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();

        //Додаємо файли у каталог
        fileNavigator.add(".\\src\\main\\java\\hillel\\hw\\resourses\\0\\");
        fileNavigator.add(".\\src\\main\\java\\hillel\\hw\\resourses\\1\\");
        fileNavigator.add(".\\src\\main\\java\\hillel\\hw\\resourses\\2\\");

        // додаємо по 2 разу
        fileNavigator.add(".\\src\\main\\java\\hillel\\hw\\resourses\\2\\txt12.txt");
        fileNavigator.add(".\\src\\main\\java\\hillel\\hw\\resourses\\2\\txt12.txt");

        // видаляємо папку, це знищить всі папки і файли 1,2,3
//        fileNavigator.remove(".\\src.main.java.hillel.hw.resourses\\1");
//        fileNavigator.remove(".\\src.main.java.hillel.hw.resourses\\2");
//        fileNavigator.remove(".\\src.main.java.hillel.hw.resourses\\0");

            // спроба видалити те чого не існує
        fileNavigator.remove(".\\res\\");


        // метод що шукає файли у окремій папці
        System.out.println(fileNavigator.find(".\\src\\main\\java\\hillel\\hw\\resourses\\2"));


        // сортуємо за розміром
        System.out.println(fileNavigator.sortBySize());


        // фільтруємо за розміром
        System.out.println(fileNavigator.filterBySize(".\\src\\main\\java\\hillel\\hw\\resourses\\2", 100000));
    }
}