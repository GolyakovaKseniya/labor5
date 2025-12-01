package ru.golyakova.main;

import ru.golyakova.cat.*;
import ru.golyakova.cat.CatDecorator;
import ru.golyakova.fractions.CachedFraction;
import ru.golyakova.fractions.FractionInterface;
import ru.golyakova.metods.*;
import ru.golyakova.metods.Validator;
import ru.golyakova.polyline.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean flag = false;
        while (!flag) {
            System.out.println("Задача 1.1");
            System.out.println("Задача 2.1");
            System.out.println("Задача 3.9");
            System.out.println("Задача 4.4");
            System.out.println("Задача 5.5");
            System.out.println("Задача 6.1");
            System.out.println("Задача 7.1");
            System.out.println("Задача 7.2");
            System.out.println("0 - Выход");
            System.out.print("Ваш выбор: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1.1":{
                    System.out.println("Создание дроби с кэшированием: ");
                    System.out.print("Введите числитель: ");
                    int num2 = Validator.inputInt();
                    System.out.print("Введите знаменатель: ");
                    int den2 = Validator.inputInt();
                    FractionInterface fraction2 = new CachedFraction(num2,den2);
                    System.out.println("Дробь с кэшированием: " + fraction2);

                    System.out.println("Первое вычисление: " + fraction2.getValue());
                    System.out.println("Второе вычисление: " + fraction2.getValue());

                    CachedFraction.printCache();

                    System.out.print("Введите новый числитель: ");
                    int newNum = Validator.inputInt();
                    fraction2.setFraction(newNum,den2);

                    System.out.println("Вычисление 3: " + fraction2.getValue());
                    System.out.println("Вычисление 4: " + fraction2.getValue());

                    CachedFraction.printCache();
                    System.out.println();
                    break;
                }
                case "2.1":{
                    System.out.print("Введите имя кота: ");
                    String name = scanner.nextLine();
                    Cat cat = new Cat(name);
                    CatDecorator countCat = new CatDecorator(cat);
                    System.out.println("Создан: " + cat);
                    Meowable m = countCat;
                    Metods.meowsCare(m);
                    System.out.println("Результаты: ");
                    System.out.println("Кот мяукал: " + countCat.getCount() + " раз");
                    System.out.println();
                    break;
                }
                case "3.9":{
                    boolean flag1 = true;
                    while (flag1) {
                        System.out.println("1 - Работа с числами");
                        System.out.println("2 - Работа со строками");
                        System.out.println("0 - Выход");
                        System.out.print("Ваш выбор: ");
                        int choice1 = Validator.inputInt();
                        switch (choice1) {
                            case 1: {
                                List<Integer> L1 = new ArrayList<>();
                                List<Integer> L2 = new ArrayList<>();
                                System.out.print("Введите количество чисел для списка L1: ");
                                int count = Validator.inputInt();
                                System.out.println("Введите элементы списка L1:");
                                for (int i = 0; i < count; i++) {
                                    System.out.print("Число " + (i + 1) + ": ");
                                    L1.add(Validator.inputInt());
                                }
                                System.out.println();
                                System.out.print("Введите количество чисел для списка L2: ");
                                int count2 = Validator.inputInt();
                                System.out.println("Введите элементы списка L2:");
                                for (int i = 0; i < count2; i++) {
                                    System.out.print("Число " + (i + 1) + ": ");
                                    L2.add(Validator.inputInt());
                                }
                                List<Integer> L = new ArrayList<>();
                                Metods.addElement(L1, L2, L);
                                Metods.addElement(L2, L1, L);

                                System.out.println("Результат: ");
                                System.out.println("Список L1: " + L1);
                                System.out.println("Список L2: " + L2);
                                System.out.println("Результат (список L): " + L);
                                break;
                            }
                            case 2: {
                                List<String> L1 = new ArrayList<>();
                                List<String> L2 = new ArrayList<>();
                                System.out.print("Введите количество элементов для списка L1: ");
                                int count = Validator.inputInt();
                                System.out.println("Введите элементы списка L1:");
                                for (int i = 0; i < count; i++) {
                                    System.out.print("Элемент " + (i + 1) + ": ");
                                    L1.add(scanner.nextLine());
                                }
                                System.out.println();
                                System.out.print("Введите количество элементов для списка L2: ");
                                int count2 = Validator.inputInt();
                                System.out.println("Введите элементы списка L2:");
                                for (int i = 0; i < count2; i++) {
                                    System.out.print("Элемент " + (i + 1) + ": ");
                                    L2.add(scanner.nextLine());
                                }
                                List<String> L = new ArrayList<>();
                                Metods.addElement(L1, L2, L);
                                Metods.addElement(L2, L1, L);

                                System.out.println("Результат: ");
                                System.out.println("Список L1: " + L1);
                                System.out.println("Список L2: " + L2);
                                System.out.println("Результат (список L): " + L);
                                break;
                            }
                            case 0: {
                                flag1 = false;
                                System.out.println("Вы вышли");
                                break;
                            }
                            default: {
                                System.out.println("Неверный выбор! Попробуйте снова");
                            }
                        }
                        System.out.println();
                    }
                    break;
                }
                case "4.4":{
                    Map<String, int[]> applicants = new HashMap();
                    try{
                        String file = "4.4";
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        int countPeople = Integer.parseInt(reader.readLine().trim());
                        for(int i = 0; i <countPeople; i++){
                            String line = reader.readLine();
                            if(line != null){
                                String[] parts = line.split(" ");
                                if(parts.length >= 4){
                                    String fullName = parts[0] + " " + parts[1];
                                    int score1 = Integer.parseInt(parts[2]);
                                    int score2= Integer.parseInt(parts[3]);
                                    if(score1 > 100 || score2>100 || score2 < 0 || score1<0){
                                        System.out.println("Ошибка в файле, числа должны быть от 0 до 100");
                                        break;
                                    }
                                    applicants.put(fullName, new int[]{score1,score2});
                                }
                            }
                        }

                    }catch (IOException e){
                        System.out.println("Файл не найден: " + e.getMessage());
                    }
                    Metods.processResult(applicants);
                    System.out.println();
                    break;
                }
                case "5.5":{
                    try {
                        String file = "5.5";
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        Set<String> words = new HashSet<>();
                        String line;
                        while ((line = reader.readLine()) != null){
                            String[] lineWords = line.toLowerCase().split("[^а-яё]+");
                            for(String word : lineWords){
                                if(!word.isEmpty()){
                                    words.add(word);
                                }
                            }
                        }
                        reader.close();
                        Set<Character> voicedConsonants = Set.of('б', 'в', 'г', 'д', 'ж', 'з', 'й', 'л', 'м', 'н', 'р');
                        Set<Character> result = Metods.findConsonants(words, voicedConsonants);

                        System.out.println("Звонкие согласные, которые входят в более чем 1 слово: ");
                        for(char consonant : result){
                            System.out.print(consonant + " ");
                        }
                        System.out.println();
                    }catch (IOException e){
                        System.out.println("Файл не найден: " + e.getMessage());
                    }
                    System.out.println();
                    break;
                }
                case "6.1":{
                    boolean flag1 = true;
                    while (flag1) {
                        System.out.println("1 - Работа с числами");
                        System.out.println("2 - Работа со строками");
                        System.out.println("0 - Выход");
                        System.out.print("Ваш выбор: ");
                        int choice1 = Validator.inputInt();
                        switch (choice1) {
                            case 1: {
                                Queue<Integer> queue = new LinkedList<>();
                                System.out.print("Введите количество чисел для очереди: ");
                                int count = Validator.inputInt();
                                System.out.println("Введите элементы очереди:");
                                for (int i = 0; i < count; i++) {
                                    System.out.print("Число " + (i + 1) + ": ");
                                    queue.add(Validator.inputInt());
                                }
                                System.out.println("Исходная очередь: " + queue);
                                System.out.print("Элементы в обратном порядке: ");
                                Metods.printQueue(queue);
                                System.out.println();
                                System.out.println("Исходная очередь: " + queue);
                                break;
                            }
                            case 2:{
                                Queue<String> queue = new LinkedList<>();
                                System.out.print("Введите количество элементов очереди: ");
                                int count = Validator.inputInt();
                                System.out.println("Введите элементы очереди:");
                                for (int i = 0; i < count; i++) {
                                    System.out.print("Элемент " + (i + 1) + ": ");
                                    queue.add(scanner.nextLine());
                                }
                                System.out.println("Исходная очередь: " + queue);
                                System.out.print("Элементы в обратном порядке: ");
                                Metods.printQueue(queue);
                                System.out.println();
                                System.out.println("Исходная очередь: " + queue);
                                break;
                            }
                            case 0: {
                                flag1 = false;
                                System.out.println("Вы вышли");
                                break;
                            }
                            default: {
                                System.out.println("Неверный выбор! Попробуйте снова");
                            }
                        }
                        System.out.println();
                    }
                    break;
                }
                case "7.1":{
                    List<Point> points = new ArrayList<>();
                    System.out.print("Введите количество точек: ");
                    int count = Validator.inputInt();
                    System.out.println("Введите точки: ");
                    for (int i = 0 ; i< count; i++){
                        System.out.println("Точка " + (i+1) + " : ");
                        System.out.print("X: ");
                        int x = Validator.inputInt();
                        System.out.print("Y: ");
                        int y = Validator.inputInt();
                        points.add(new Point(x,y));
                        System.out.println("Добавлена точка: " + new Point(x, y));
                    }

                    System.out.println("Всего точек: " + points.size());
                    System.out.println("Исходные точки: " + points);

                    System.out.println("Стрим: ");
                    Polyline polyline = points.stream()
                            .distinct()
                            .sorted(Comparator.comparingInt(Point::getX))
                            .map(p -> new Point(p.getX(), Math.abs(p.getY())))
                            .collect(Collectors.collectingAndThen(Collectors.toList(), Polyline::new));

                    System.out.println("Результат (ломаная) : " + polyline );
                    System.out.println();
                    break;
                }
                case "7.2":{
                    String file = "7.2";
                    try {
                        Map<Integer, List<String>> result = Files.lines(Paths.get(file))
                                .map(line -> line.split(":"))
                                .filter(parts -> parts.length == 2 && !parts[1].trim().isEmpty())
                                .collect(Collectors.groupingBy(parts -> Integer.parseInt(parts[1].trim()),
                                                Collectors.mapping(parts -> {
                                                    String name = parts[0].trim();
                                                    return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
                                                },
                                                        Collectors.toList())
                                        ));
                        System.out.println("Результат: ");
                        System.out.println(result);
                    }catch (IOException e){
                        System.err.println("Ошибка чтения файла: " + e.getMessage());
                    }
                    System.out.println();
                    break;
                }
                case "0":{
                    System.out.println("Выход из программы");
                    return;
                }
                default:{
                    System.out.println("Неверный выбор! Попробуйте снова");
                    break;
                }
            }
        }
    }
}
