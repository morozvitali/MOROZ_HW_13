package src.main.java.hillel.hw;

public class Application {
        public static void main(String[] args) {
//        FileData fileData0 = new FileData("txt0.txt", 672, "./src/main/java/resources/resourses.0/");
//        FileData fileData1 = new FileData("txt1.txt", 4322, "./src/main/java/resources/resourses.1/");
//        FileData fileData2 = new FileData("txt2.txt", 466722, "./src/main/java/resources/resourses.1/");
//        FileData fileData3 = new FileData("txt3.txt", 45222, "./src/main/java/resources/2/");
//        FileData fileData4 = new FileData("txt4.txt", 28762, "./src/main/java/resources/2/");
//        FileData fileData10 = new FileData("txt10.txt", 22987, "./src/main/java/resources/2/");
//        FileData fileData11 = new FileData("txt11.txt", 2865, "./src/main/java/resources/2/");
//        FileData fileData12 = new FileData("txt12.txt", 26582, "./src/main/java/resources/2/");
//        FileData fileData13 = new FileData("txt12.txt", 26582, "./src/main/java/resources/2/");
//        FileData fileData14 = new FileData("txt12.txt", 26582, "./src/main/java/resources/2/");

        FileNavigator fileNavigator = new FileNavigator();

//        fileNavigator.add(".\\resourses\\0\\txt0.txt");
//        fileNavigator.add(".\\resourses\\1\\txt1.txt");
//        fileNavigator.add(".\\resourses\\1\\txt2.txt");
//        fileNavigator.add(".\\resourses\\2\\txt3.txt");
//        fileNavigator.add(".\\resourses\\2\\txt4.txt");
//        fileNavigator.add(".\\resourses\\2\\txt10.txt");
//        fileNavigator.add(".\\resourses\\2\\txt11.txt");
//        fileNavigator.add(".\\resourses\\2\\txt12.txt");
//
//        fileNavigator.add(".\\resours\\2\\txt12.txt");


        // додаємо по 2 разу
//        fileNavigator.add(".\\resourses\\2\\txt12.txt");
//        fileNavigator.add(".\\resourses\\2\\txt12.txt");
        // додаємо директорію
        fileNavigator.add(".\\resourses\\2");


        //спроба додати дублікат
//        fileNavigator.add(fileData13);
//        fileNavigator.add(fileData14);

        // метод що шукає файли у окремій папці
//        System.out.println(fileNavigator.find("./src/main/java/resources/2/"));

        // видаляємо папку
//        fileNavigator.remove("./src/main/java/resources/2/");
//        System.out.println(fileNavigator.find("./src/main/java/resources/2/"));

        // сортуємо за розміром
        System.out.println(fileNavigator.sortBySize());

        // фільтруємо за розміром
//        System.out.println(fileNavigator.filterBySize("./src/main/java/resources/resourses.1/", 100000));


    }
}
