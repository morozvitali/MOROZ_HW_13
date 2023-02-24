# MOROZ_HW_13
ДЗ 13. Словники
Клас FileNavigator - це клас, який буде містити список файлів,
які розташовані на конкретному шляху. У цьому класі будемо
зберігати інформацію про всі файли та директорії в певній директорії.
Додати до класу методи для додавання, пошуку, фільтрації та видалення файлів.

Клас FileData - це клас, який містить інформацію про конкретний файл,
таку як ім'я файлу, розмір в байтах та шлях до файлу.

Метод add у класі FileNavigator додає файл за вказаним шляхом.
Якщо шлях вже існує, новий файл додається до списку,
вже пов'язаного з відповідним шляхом. У методі 
потрібно перевірити унікальність шляху, тобто переконатися,
що один і той же шлях не додається до списку більше одного разу.

Метод find у класі FileNavigator повертає список файлів,
пов'язаних з шляхом, переданим як параметр.

Метод filterBySize у класі FileNavigator повертає список файлів,
розмір (в байтах) яких не перевищує значення, передане як параметр.

Метод remove у класі FileNavigator видаляє шлях і пов'язані з ним файли,
виходячи з значення шляху, переданого як параметр.

Метод sortBySize у класі FileNavigator сортує всі наявні файли за розміром (за зростанням),
потім повертає список відсортованих файлів.

Метод add у класі FileNavigator містититиме перевірку консистентності.