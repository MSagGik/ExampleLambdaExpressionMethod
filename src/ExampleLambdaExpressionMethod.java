import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExampleLambdaExpressionMethod {
    public static void main(String[] args) {
        // метод map()

        // структуры данных
        int[] arr = new int[10];
        List<Integer> list = new ArrayList<>();
        // методы заполнения структур данных
        fillArr(arr);
        fillList(list);
        // вывод на экран
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        System.out.println(list); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        // пример умножения на 2 каждого значения данных:
//        // 1) стандартным способом
//        for (int i = 0; i < 10; i++) {
//            arr[i] = arr[i] * 2;
//            list.set(i, list.get(i) * 2);
//        }
        // 2) с помощью лямбда выражения
        // метод stream() вызывает поток,
        // метод map() берёт данные и сопоставляет им новые данные
        // (в данном методе нужно описывать сопоставляющую логику),
        // далее нужно обратно преобразовать потоки в соответствующуе структыры данных
        arr = Arrays.stream(arr).map(a -> a * 2).toArray();
        list = list.stream().map(a -> a * 2).collect(Collectors.toList());

        // вывод на экран преобразованные данные
        System.out.println(Arrays.toString(arr)); // [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
        System.out.println(list); // [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]

        // метод filter()

        // структуры данных
        int[] arr2 = new int[10];
        List<Integer> list2 = new ArrayList<>();
        // методы заполнения структур данных
        fillArr(arr2);
        fillList(list2);

        // метод filter() по заданному критерию отфильтвовывает значения
        // (пример критерия деления на 2 без остатка)
        arr2 = Arrays.stream(arr2).filter(a -> a % 2 == 0).toArray();
        list2 = list2.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());
        // вывод на экран преобразованные данные
        System.out.println(Arrays.toString(arr2)); // [2, 4, 6, 8, 10]
        System.out.println(list2); // [2, 4, 6, 8, 10]

        // метод forEach() выпоняет какое-либо действие для каждого элемента
        Arrays.stream(arr2).forEach(System.out::print); //246810
        list2.stream().forEach(System.out::print); // 246810

        // метод reduce()
        // структуры данных
        int[] arr3 = new int[10];
        List<Integer> list3 = new ArrayList<>();
        // методы заполнения структур данных
        fillArr(arr3);
        fillList(list3);

        // в методе reduce() первый парамметр "acc" означает счётчик или аккумулятор
        // методы getAsInt() и get() преобразуют соответствующий поток в целое число
        // первое значение acc равняется первому значению массива
        int sum1a = Arrays.stream(arr3).reduce((acc, b) -> acc + b).getAsInt();
        // первое значение acc равняется нулю
        int sum1b = Arrays.stream(arr3).reduce(10, (acc, b) -> acc + b);
        // первое значение acc равняется первому значению массива
        int product1a = list3.stream().reduce((acc, b) -> acc * b).get();
        // первое значение acc равняется единице
        int product1b = list3.stream().reduce(3, (acc, b) -> acc * b);
        // вывод на экран преобразованные данные
        System.out.println(sum1a); // 55
        System.out.println(sum1b); // 65
        System.out.println(product1a); // 3628800
        System.out.println(product1b); // 10886400

        // применение нескольких методов с лямда выражениями
        int[] arr4 = new int[10];
        fillArr(arr4);
        int[] newArray = Arrays.stream(arr4).filter(a -> a % 2 != 0).map(a -> a * 2).toArray();
        System.out.println(Arrays.toString(newArray)); // [2, 6, 10, 14, 18]
    }

    private static void fillArr(int[] arr) {
        for (int i = 0; i < 10; i++)
            arr[i] = i + 1;
    }
    private static void fillList(List<Integer> list) {
        for (int i = 0; i < 10; i++)
            list.add(i + 1);
    }

}
