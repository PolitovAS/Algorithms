import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class App {
    public static void main(String[] args) throws Exception {
        int lastNumber = 43;
        AtomicInteger counter = new AtomicInteger();
        System.out.printf("Сумма всех чисел от 1 до %d равна %d\n", lastNumber, sum(lastNumber, counter));
        System.out.println("Количество итераций: " + counter.get());

        System.out.printf("Сумма всех чисел от 1 до %d равна %d\n", lastNumber, sum2(lastNumber));

        counter.set(0);
        System.out.println("Простые числа: " + findSimpleNumbers(lastNumber, counter));
        System.out.println("Количество итераций: " + counter.get());

        counter.set(0);
        long startTime = System.currentTimeMillis();
        System.out.printf("Число Фибоначчи для индекса %d равно %d\n [Рекурсия]", lastNumber, fb1(lastNumber, counter));
        long endTime = System.currentTimeMillis();
        System.out.println("Количество итераций: " + counter.get());
        System.out.printf("Операция выполнена за %d мс \n", endTime - startTime);

        counter.set(0);
        startTime = System.currentTimeMillis();
        System.out.printf("Число Фибоначчи для индекса %d равно %d\n", lastNumber, fb2(lastNumber, counter));
        endTime = System.currentTimeMillis();
        System.out.println("Количество итераций: " + counter.get());
        System.out.printf("Операция выполнена за %d мс \n", endTime - startTime);
    }

    public static int sum(int lastNumber, AtomicInteger c){
        int sum = 0;
        for (int i = 1; i <= lastNumber; i++) {
            sum += i;
            c.getAndIncrement();
        }
        return sum;
    }

    public static int sum2(int lastNumber){
        return ((1 + lastNumber) * lastNumber) / 2;
    }

    public static ArrayList<Integer> findSimpleNumbers(int lastNumber, AtomicInteger counter){
        ArrayList<Integer> simleNumbers = new ArrayList<>();
        for (int i = 1; i <= lastNumber; i++) {
            boolean isSimple = true;
            for (int j = 2; j < i; j++) {
                counter.getAndIncrement();
                if (i % j == 0){
                    isSimple = false;
                    break;
                }
            }
            if (isSimple)
                simleNumbers.add(i);
        }
        return simleNumbers;
    }

    public static long fb1(int num, AtomicInteger counter){
        counter.getAndIncrement();
        if (num == 0 || num == 1)
            return num;
        return fb1(num - 1, counter) + fb1(num - 2, counter);
    }

    public static long fb2(int num, AtomicInteger counter){
        if (num == 0 || num == 1)
            return num;
        int[] array = new int[num + 1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            counter.getAndIncrement();
            array[i] = array[i - 1] + array[i -2];
        }
        return array[num];
    }
}
