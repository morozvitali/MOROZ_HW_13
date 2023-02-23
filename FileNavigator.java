import java.util.*;
import java.util.stream.Collectors;

public class FileNavigator {
    private final Map<String, List<FileData>> fileMap;

    public FileNavigator() {
        fileMap = new HashMap<>();
    }

    public void add(FileData fileData) {
        String path = fileData.getPath();
        if (!fileMap.containsKey(path)) {
            fileMap.put(path, new ArrayList<>());
        }
        List<FileData> files = fileMap.get(path);

        // перевірка консистентності шляху
        if (!getKey(path).equals(getKey(fileData.getPath()))) {
            System.out.println("Помилка: шлях-ключ і шлях до файлу не співпадають!");
            return;
        }

        files.add(fileData);
    }

    private String getKey(String path) {
        return path;
    }

    /*
     * У методі add ми перевіряємо, чи є відповідний шлях у карті файлів.
     * Якщо ні, ми створюємо новий список файлів та додаємо його до картки.
     * Потім ми отримуємо список файлів карти та додаємо до нього новий файл.

     * перевірити консистентність шляху, пов'язаного з файлом, та шляху-ключа,
     * що веде до списку файлів. Якщо вони не співпадають,
     * видаляти файл із списку та виводити повідомлення про помилку у консоль.
     */

    public List<FileData> find(String path) {
        if (fileMap.containsKey(path)) {
            return fileMap.get(path);
        } else {
            return new ArrayList<>();
        }
    }

    /*
     * Метод find просто повертає список файлів, пов'язаних з вказаним шляхом.
     * Якщо шлях не знайдено в карті, повертаємо порожній список.
     */

    public List<FileData> filterBySize(String path, long maxSize) {
        List<FileData> files = find(path);
        return files.stream()
                .filter(f -> f.getSize() <= maxSize)
                .collect(Collectors.toList());
    }

    /*
     * Метод filterBySize також використовує метод find для отримання списку файлів для заданого шляху.
     * Потім ми застосовуємо фільтр за розміром, виключаючи файли, розмір яких більше, ніж передане значення maxSize.
     * Нарешті, ми повертаємо список відфільтрованих файлів.
     */

    public void remove(String path) {
        fileMap.remove(path);
    }

    /*
     * Метод remove просто видаляє вказаний шлях з картки файлів.
     */

    public List<FileData> sortBySize() {
        List<FileData> files = new ArrayList<>();
        fileMap.values().forEach(files::addAll);
        files.sort(Comparator.comparingLong(FileData::getSize));
        return files;
    }

        /*
          Метод sortBySize отримує всі файли з картки файлів, додаючи їх до списку.
          Потім ми сортуємо цей список за розміром
         */
}