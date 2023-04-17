package org.example;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//       Cреднее значение чисел в списке:
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        double num = numbers.stream()
                .mapToInt(a -> a.intValue())
                .average().orElse(0);
        System.out.println("Среднее арифматическое значение : " + num);

//      Получить список квадратов чисел в списке:
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());

        System.out.println("Квадраты чисел: " + squares);
//      Отфильтровать элементы списка, оставив только четные числа
        List<Integer> evens = numbers.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Четные числа: " + evens);

//      Проверить, содержит ли список число 3:
        boolean isExists = numbers.stream()
                .filter(n -> n == 3)
                .count() > 0;
        System.out.println("Cодержит список число 3: " + isExists);

//      Соединить элементы списка в одну строку через запятую:
        List<String> strings = Arrays.asList("one", "two", "three", "four", "five");
        String nums = strings.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Элементы в одну строку через запятую : " + nums);
        System.out.println("-------------------------------------------------------");

//      Получить первые три элемента списка:
        numbers.stream().limit(3).forEach(n -> System.out.println(n + " "));
        System.out.println("-------------------------------------------------------");

//      Извлечь из списка все уникальные элементы:
        List<Integer> listNums = Arrays.asList(1, 2, 3, 4, 5, 3, 4, 6);
        listNums.stream()
                .distinct()
                .forEach(p -> System.out.println(p + " "));

//      Найти максимальное значение в списке:
        Integer max = numbers.stream().max(Integer::compare).get();
        System.out.println("Максимальное значение: " + max);

//      Отсортировать список в обратном порядке:
        List<Integer> integerList= numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("Список в обратном порядке: " + integerList);
        System.out.println();

        System.out.println("---------Лямбда-выражение-----------------------");
//      Напишите лямбда-выражение, которое умножает каждый элемент списка на 2.
        numbers.replaceAll(n-> n * 2 );
        System.out.println("Список умноженный на 2: " + numbers);

//      Напишите лямбда-выражение, которое находит сумму двух чисел.
        Operationable operation = (x,y)->x+y;

        int result = operation.calculate(25, 55);
        System.out.println("Сумма двух чисел: " + result);

//      Напишите лямбда-выражение, которое возвращает True, если переданное число больше 10.
        Confirmable confirmable = x-> x >10;
        System.out.println("Возвращает true если число больше 10: " + confirmable.confirm(15));

//      Напишите лямбда-выражение, которое возвращает True, если переданная строка содержит более 5 символов.
        Containable containable = s -> String.valueOf(s.length()>5);
        System.out.println(containable.containSymbol("Hello"));

//      Напишите лямбда-выражение, которое возвращает длину переданной строки.
        LengthOfString ofString = s -> s.length();
        System.out.println("Длина переданной строки: " + ofString.check("Java"));

//      Напишите лямбда-выражение, которое возвращает квадрат переданного числа.
        Square sq = n -> n * n;
        System.out.println("Квадрат переданного числа: " + sq.calculate(25));

//      Напишите лямбда-выражение, которое возвращает сумму элементов списка.
        SumOfNumbers sumOfList = a -> numbers.stream().reduce(0, (x, y) -> x + y);
        System.out.println("Cумма элементов списка: " + sumOfList.calculate(numbers));

//      Напишите лямбда-выражение, которое возвращает True, если переданная строка начинается с буквы "A".
        StartsWithA startsWithA = s -> s.startsWith("А");
        System.out.println("Возвращает true , если переданная строка начинается с буквы \"A\": " + startsWithA.check("Австрия"));

//      Напишите лямбда-выражение, которое возвращает список квадратов элементов исходного списка.

        numbers.replaceAll(n -> n * n);
        System.out.println("Cписок квадратов элементов: " + numbers);
    }
    interface Operationable{
        int calculate(int x, int y);}
    interface  Confirmable {
        Boolean confirm(int x);}
    interface  Containable {
        String containSymbol(String x);}
    interface  LengthOfString {
        int check(String x);}
    interface  Square {
        int calculate(int x);}
    interface  SumOfNumbers {
        int calculate(List<Integer> nums);}
    public interface StartsWithA{
        boolean check(String s);
    }

}