import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;

void main() {
    //1.

    /*List<String> students = new ArrayList<String>();

    students.add("Петр");
    students.add("Марина");
    students.add("Иван");
    students.add("Алексей");
    students.add("Наталья");
    students.add("Лилия");
    students.add("Яков");
    System.out.println(students);

    students.remove("Алексей");
    System.out.println(students);

    System.out.println(students.contains("Иван"));

    System.out.println(students.size());*/

    //2.
    Path path = Paths.get("notes.txt");
    try {
        Files.createFile(path);
        System.out.println("Файл создан: " + path);
    } catch (IOException e) {
        System.err.println("Ошибка: " + e.getMessage());
    }

    String[] strok = {
            "Александр Блок",
            "Перед грозой",
            "Закат горел в последний раз.",
            "Светило дня спустилось в тучи,",
            "И их края в прощальный час",
            "Горели пламенем могучим."
    };

    for (String s: strok){
        try {
            Files.write(path, (s + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    try {
        List<String> lines = Files.readAllLines(path);
        System.out.println("Содержимое файла:");
        for (String line : lines) {
            System.out.println(line);
        }
    } catch (IOException e) {
        System.err.println("Ошибка: " + e.getMessage());
    }

}