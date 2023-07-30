import java.util.Arrays;

public class Program {

    public static void main(String[] args) {

        int[] array = ArrayUtils.prepareArray();
        ArrayUtils.printArray(array);
        SortUtils.directSort(array);
        ArrayUtils.printArray(array);
        System.out.println();
        array = ArrayUtils.prepareArray();
        ArrayUtils.printArray(array);
        SortUtils.quickSort(array);
        ArrayUtils.printArray(array);

        array = new int[] {5, 4, 1, 0, 1};
        SortUtils.quickSort(array);
        ArrayUtils.printArray(array);

        array = new int[] {-60, 40, 1, 17, 0, -5, 14, 22, 1, 19, -5};
        ArrayUtils.printArray(array);
        SortUtils.quickSort(array);
        ArrayUtils.printArray(array);
        int searchElement = 22;
        //int res = SearchUtils.binarySearch(array, searchElement);
        int res = Arrays.binarySearch(array, searchElement);
        System.out.printf("Элемент %d %s\n",
                searchElement, res >= 0 ? String.format("найден в массиве по индексу %d", res) :
                "не найден в массиве");


        /*array = ArrayUtils.prepareArray(200000);
        long startTime = System.currentTimeMillis();
        SortUtils.directSort(array.clone());
        long endTime = System.currentTimeMillis();
        System.out.printf("Время работы сортировки выбором: %d мс.\n", endTime - startTime);


        startTime = System.currentTimeMillis();
        SortUtils.quickSort(array.clone());
        endTime = System.currentTimeMillis();
        System.out.printf("Время работы быстрой сортировки: %d мс.\n", endTime - startTime);

        startTime = System.currentTimeMillis();
        Arrays.sort(array.clone());
        endTime = System.currentTimeMillis();
        System.out.printf("Время работы системной сортировки: %d мс.\n", endTime - startTime);*/




    }

}
