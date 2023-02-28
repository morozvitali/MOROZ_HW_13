package src.main.java.hillel.hw;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class FileNavigator {
    private Map<String, List<FileData>> fileMap;

    public FileNavigator() {
        fileMap = new HashMap<>();
    }

    public void addToHashMap(FileData fileData) {


        String path = fileData.getPath();
        String name = fileData.getName();

        List<FileData> files = fileMap.computeIfAbsent(path, k -> new ArrayList<>());

        boolean hasDuplicateFile = files.stream()
                .anyMatch(f -> f.getName().equals(name) && f.getPath().equals(path));

        if (!hasDuplicateFile) {
            files.add(fileData);
        } else {
            System.out.println("Спроба додати файл з тим самим ім'ям");
            System.out.println("Помилка: файл " + fileData.getName() + " вже існує по вказаному шляху " + fileData.getPath());
        }
    }

    public void add(String path) {
        File file = new File(path);
        if (file.exists() && !file.isDirectory()) {
            String directoryPath = file.getParent();
            FileData fileData = new FileData(file.getName(), file.length(), directoryPath);
            addToHashMap(fileData);
        } else if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                if (!f.isFile()) continue;
                FileData fileData = new FileData(f.getName(), f.length(), f.getParent());
                addToHashMap(fileData);
            }
        } else {
            System.out.println("Шлях " + path + " не існує");
        }
    }


    public List<FileData> find(String path) {
        System.out.println("Шукаємо файли за шляхом: метод find() ");

        if (fileMap.containsKey(path)) {
            return fileMap.get(path);
        } else {
            return new ArrayList<>();
        }
    }

    public List<FileData> filterBySize(String path, long maxSize) {
        System.out.println("Фільтруємо за розміром: метод filterBySize() ");
        List<FileData> files = find(path);
        return files.stream()
                .filter(f -> f.getSize() <= maxSize)
                .collect(Collectors.toList());
    }

    public void remove(String path) {
        File f = new File(path);


        if (f.exists() && f.isFile()) {
            f.delete();
            System.out.println("Файл за посиланням " + path + " видалено");
            fileMap.remove(path);

            System.out.println("Видаляємо файл " + f.getName() + " з таблиці файлів: метод remove() ");
        } else if (f.exists() && !f.isFile()) {
            System.out.println("Видаляємо директорію з файлами");
            for (File file : f.listFiles()) {
                System.out.println("Спочатку видалимо файли в середині папки, якщо вони є, спроба видалити" + file);
                file.delete();
            }
            f.delete();

            System.out.println("Спроба видалити директорію з переліку");
            fileMap.remove(path);
        } else
            System.out.println("Файл за посиланням " + path + " не існує");
    }

    public List<FileData> sortBySize() {
        System.out.println("Сортуємо за розміром: метод sortBySize() ");
        List<FileData> files = new ArrayList<>();
        fileMap.values().forEach(files::addAll);
        files.sort(Comparator.comparingLong(FileData::getSize));
        return files;
    }

    @Override
    public String toString() {
        return "FileNavigator{" +
                "fileMap=" + fileMap +
                '}';
    }
}