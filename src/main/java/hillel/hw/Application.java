package src.main.java.hillel.hw;

public class Application {
    public static void main(String[] args) {
        FileData fileData = new FileData("txt.txt", 2222, "/");
        FileNavigator fileNavigator = new FileNavigator();

        fileNavigator.add(fileData);


    }
}
