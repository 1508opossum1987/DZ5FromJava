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
    /*Path path = Paths.get("notes.txt");
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
    }*/


    //2.Alternate
    /*Path path = Paths.get("notes.txt");

    String[] strok = {
            "Александр Блок",
            "Перед грозой",
            "Закат горел в последний раз.",
            "Светило дня спустилось в тучи,",
            "И их края в прощальный час",
            "Горели пламенем могучим."
    };

    try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
        for (String s : strok) {
            writer.write(s);
            writer.newLine();
        }
        System.out.println("Файл успешно записан");
    } catch (IOException e) {
        System.err.println("Ошибка при записи: " + e.getMessage());
    }

    try (BufferedReader reader = Files.newBufferedReader(path)) {
        System.out.println("Содержимое файла:");
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    } catch (IOException e) {
        System.err.println("Ошибка при чтении: " + e.getMessage());
    }*/

    //3.

    /*(List<Integer> numbers = new ArrayList<>();

    // создадим список из 20 рандомных чисел от 1 до 100
    Random rand = new Random();

    System.out.println("Исходная коллекция из 20 целых чисел от 1 до 100: ");
    for (int i =0; i<20;i++){
        numbers.add(rand.nextInt(100)+1);
    }
    System.out.println(numbers);

    List<Integer> result = numbers.stream()
            .filter(n->n%2==0)
            .map(n->n*2)
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
    System.out.println("Результат: ");
    System.out.println(result);

    int sum = result.stream()
            .mapToInt(Integer::intValue)
            .sum();

    System.out.println("Сумма чисел: ");
    System.out.println(sum);*/

    //4.

    /*List<Student> students = new ArrayList<> ();
    students.add(new Student("Alex", 17, 4.67));
    students.add(new Student("Voldemar", 23, 3.12));
    students.add(new Student("Sophia", 20, 4.11));
    students.add(new Student("George", 17, 2.08));
    students.add(new Student("John", 18, 4.55));
    students.add(new Student("Christy", 19, 4.97));
    students.add(new Student("Joshua", 21, 4.01));
    students.add(new Student("Suzanna", 18, 3.17));
    students.add(new Student("Bob", 20, 3.33));
    students.add(new Student("Kyle", 22, 4.07));

    System.out.println("Весь список студентов: ");
    System.out.println(
            students.stream()
                    .map(Student::toString)
                    .collect(Collectors.joining())
    );

    List<Student> overFrom18 = students.stream()
            .filter(s -> s.getAge() > 18)
            .collect(Collectors.toList());

    System.out.println("Студенты старше 18 лет: ");
    overFrom18.forEach(System.out::print);
    System.out.println();

    List<Student> sortedByGrade = students.stream()
            .sorted(new StudentComparator())
            .collect(Collectors.toList());

    System.out.println("Сортировка по среднему баллу: ");
    sortedByGrade.forEach(System.out::print);
    System.out.println();

    List<String> namesFromOver45 = students.stream()
            .filter(s->s.getGrade()>4.5)
            .map(Student::getName)
            .collect(Collectors.toList());

    System.out.println("Имена студентов с баллом выше 4.5: ");
    namesFromOver45.forEach(System.out::println);
    System.out.println();

    String bestStudent = students.stream()
            .max(new StudentComparator())
            .map(Student::getName)
            .get();

    System.out.println("Студент с самым высоким баллом: "+bestStudent);
    System.out.println();

    double sumOfGrades = students.stream()
            .mapToDouble(Student::getGrade)
            .sum();

    double averageGrade = Math.round((sumOfGrades / students.size()) * 100.0) / 100.0;
    System.out.println("Средняя оценка группы: "+averageGrade);*/

    //5.

    /*Path path = Paths.get("products.txt");

    List<String> linesFromFile = new ArrayList<>();

    try (BufferedReader reader = Files.newBufferedReader(path)) {
        System.out.println("Содержимое файла:");
        String line;
        for (int i = 0; (line = reader.readLine()) != null; i++) {
            System.out.println(line);
            linesFromFile.add(line);
        }
    } catch (IOException e) {
        System.err.println("Ошибка при чтении: " + e.getMessage());
    }

    List<Product> products = new ArrayList<>();

    for (int i = 0; i < linesFromFile.size(); i++) {
        String line = linesFromFile.get(i);
        if (line.trim().isEmpty()) {
            continue;
        }
        String[] parts = line.split(";");

        try {
            String name = parts[0].trim();
            int price = Integer.parseInt(parts[1].trim());
            Product product = new Product (name, price);
            products.add(product);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: '" + parts[1] + "' не является числом");
        }
    }

    for (Product p : products) {
        System.out.println(p);
    }
    System.out.println();

    List<Product> overFrom200 = products.stream()
            .filter(p->p.getPrice()>200)
            .collect(Collectors.toList());

    System.out.println("Продукты дороже 200 рублей: ");
    for (Product p : overFrom200) {
        System.out.println(p);
    }
    System.out.println();

    List<Product> sortedByPrice = products.stream()
            .sorted(new ProductComparator())
            .collect(Collectors.toList());

    System.out.println("Сортировка продуктов по цене: ");
    for (Product p : sortedByPrice) {
        System.out.println(p);
    }
    System.out.println();

    Product biggestPriceProduct = products.stream()
            .max(new ProductComparator())
            .get();

    System.out.println("Продукт с максимальной ценой: ");
    System.out.println(biggestPriceProduct);
    System.out.println();

    int sumOfPrices = products.stream()
            .mapToInt(Product::getPrice)
            .sum();

    System.out.println("Сумма цен всех продуктов: ");
    System.out.println(sumOfPrices);*/

    //6.
    Path path = Paths.get("books.bin");

    List<String> linesFromFile = new ArrayList<>();

    try (BufferedReader reader = Files.newBufferedReader(path)) {
        System.out.println("Содержимое файла:");
        String line;
        for (int i = 0; (line = reader.readLine()) != null; i++) {
            System.out.println(line);
            linesFromFile.add(line);
        }
    } catch (IOException e) {
        System.err.println("Ошибка при чтении: " + e.getMessage());
    }

    for(String l: linesFromFile){
        System.out.println(l);
    }

    List<Book> books = new ArrayList<>();

    for (int i = 0; i < linesFromFile.size(); i++) {
        String line = linesFromFile.get(i);
        if (line.trim().isEmpty()) {
            continue;
        }
        String[] parts = line.split(";");

        try {
            String name = parts[0].trim();
            String author = parts[1].trim();
            int year = Integer.parseInt(parts[2].trim());
            int pages = Integer.parseInt(parts[3].trim());
            boolean available = Boolean.parseBoolean(parts[4].trim());
            Book book = new Book(name, author, year, pages, available);
            books.add(book);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: "+e.getMessage());
        }
    }

    System.out.println("Книги в библиотеке: ");
    for (Book b: books){
        System.out.println(b);
    }
    System.out.println();

    System.out.println("Введите автора книг: ");
    Scanner console = new Scanner(System.in);
    String authorUser = console.nextLine();

    List<Book> booksByAuthor = books.stream()
            .filter(a->a.getAuthor().equals(authorUser))
            .collect(Collectors.toList());

    System.out.println("Все книги автора: "+authorUser+": ");
    for (Book b: booksByAuthor){
        System.out.println(b);
    }
    System.out.println();

    Book fromOldestYear = books.stream()
            .min(new BookComparator())
            .get();

    System.out.println("Самая старая книга: ");
    System.out.println(fromOldestYear);
    System.out.println();

    Book fromYoungestYear = books.stream()
            .max(new BookComparator())
            .get();

    System.out.println("Самая новая книга: ");
    System.out.println(fromYoungestYear);
    System.out.println();








}
