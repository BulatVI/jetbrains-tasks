package phonebook;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


public class Main {
    
    public static void main(String[] args) throws IOException {

        //1
        System.out.println("Start searching...");
        long start = System.currentTimeMillis();
        int find = 0;
        int numberOfLines = 0;
        try (BufferedReader br1 = new BufferedReader(new FileReader("F:\\Мои документы\\Загрузки\\directory.txt"));
             BufferedReader br2 = new BufferedReader(new FileReader("F:\\Мои документы\\Загрузки\\find.txt"))) {

//            StringBuilder sb1 = new StringBuilder();
//            while (br1.ready()) {
//                sb1.append(br1.readLine());
//            }
//            String s = sb1.toString();
//            while (br2.ready()) {
 //               numberOfLines++;
//                if (s.contains(br2.readLine())) {
 //                   find++;
//                }
//            }

            StringBuilder sb1 = new StringBuilder();
            while (br1.ready()) {
                sb1.append(br1.readLine()).append("\n");
            }
           String[] s = sb1.toString().split("\n");
            while (br2.ready()) {
                numberOfLines++;
                if (linearSearch(s, br2.readLine().trim()) >= 0) {
                   find++;
               }
           }
        }

        long finish = System.currentTimeMillis();
        long millis = finish - start;
        System.out.printf("Found %s / %s entries. Time taken: %d min. %d sec. %d ms.%n",
                find, numberOfLines,
                TimeUnit.MILLISECONDS.toMinutes(millis),
                TimeUnit.MILLISECONDS.toSeconds(millis) % 60,
                millis % 1000
        );
        System.out.println();
        find = 0;
        numberOfLines = 0;

        //2
        System.out.println("Start searching (bubble sort + jump search)...");
        long startSorting;
        long millisCreating = 0;
        long millisSearching = 0;

        try (BufferedReader br1 = new BufferedReader(new FileReader("F:\\Мои документы\\Загрузки\\directory.txt"));
             BufferedReader br2 = new BufferedReader(new FileReader("F:\\Мои документы\\Загрузки\\find.txt"))) {
            StringBuilder sb1 = new StringBuilder();
            while (br1.ready()) {
                sb1.append(br1.readLine()).append("\n");
            }
            String[] s = sb1.toString().split("\n");
            startSorting = System.currentTimeMillis();

            final boolean[] b = {false};
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    bubbleSort(s);// это пиздец
                    b[0] = true;
                }
            };

            Thread thread = new Thread(task);
            thread.start();
            while ((System.currentTimeMillis() - startSorting) < millis * 10) {
                Thread.sleep(50);
            }
            if (!b[0]) {
                thread.stop();
            }

            long finishSorting = System.currentTimeMillis();
            millisCreating = finishSorting - startSorting;
            long startSearching = System.currentTimeMillis();

            if (!b[0]) {
                //String str = sb1.toString();
                //while (br2.ready()) {
              //      numberOfLines++;
                //    if (str.contains(br2.readLine())) {
               //         find++;
              //      }
              //  }
                while (br2.ready()) {
                    numberOfLines++;
                    if (linearSearch(s, br2.readLine().trim()) >= 0) {
                        find++;
                    }
                }
                long finishSearching = System.currentTimeMillis();
                millisSearching = finishSearching - startSearching;
                System.out.println("Found " + find + " / " + numberOfLines + " entries. Time taken: " + millisToTime(millisCreating + millisSearching));
                System.out.println("Sorting time: " + millisToTime(millisCreating) + " - STOPPED, moved to linear search");
                System.out.println("Searching time: " + millisToTime(millisSearching));
            } else {

                while (br2.ready()) {
                    numberOfLines++;
                    if (jumpSearch(s, br2.readLine().trim()) >= 0) {
                        find++;
                    }
                }
                long finishSearching = System.currentTimeMillis();
                millisSearching = finishSearching - startSearching;

                System.out.println("Found " + find + " / " + numberOfLines + " entries. Time taken: " + millisToTime(millisCreating + millisSearching));
                System.out.println("Sorting time: " + millisToTime(millisCreating));
                System.out.println("Searching time: " + millisToTime(millisSearching));
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();

        //3
        find = 0;
        numberOfLines = 0;
        System.out.println("Start searching (quick sort + binary search)...");

        try (BufferedReader br1 = new BufferedReader(new FileReader("F:\\Мои документы\\Загрузки\\directory.txt"));
             BufferedReader br2 = new BufferedReader(new FileReader("F:\\Мои документы\\Загрузки\\find.txt"))) {
            StringBuilder sb1 = new StringBuilder();
            while (br1.ready()) {
                sb1.append(br1.readLine()).append("\n");
            }
            String[] s = sb1.toString().split("\n");
            startSorting = System.currentTimeMillis();

            quickSort(s, 0, s.length - 1);

            long finishSorting = System.currentTimeMillis();
            millisCreating = finishSorting - startSorting;


            long startSearching = System.currentTimeMillis();

            while (br2.ready()) {
                numberOfLines++;
                if (binarySearch(s, br2.readLine().trim()) >= 0) {
                    find++;
                }
            }

            long finishSearching = System.currentTimeMillis();
            millisSearching = finishSearching - startSearching;

            System.out.println("Found " + find + " / " + numberOfLines + " entries. Time taken: " + millisToTime(millisCreating + millisSearching));
            System.out.println("Sorting time: " + millisToTime(millisCreating));
            System.out.println("Searching time: " + millisToTime(millisSearching));
        }
        System.out.println();

        //4
        find = 0;
        numberOfLines = 0;
        System.out.println("Start searching (hash table)...");

        try (BufferedReader br1 = new BufferedReader(new FileReader("F:\\Мои документы\\Загрузки\\directory.txt"));
             BufferedReader br2 = new BufferedReader(new FileReader("F:\\Мои документы\\Загрузки\\find.txt"))) {

            long startCreating = System.currentTimeMillis();
            Map<String, String> map = new HashMap<>(2_000_000);
            while (br1.ready()) {
                String s = br1.readLine();
                map.put(s.split(" ",2)[1].trim(), s.split(" ",2)[0]);
            }

            long finishCreating = System.currentTimeMillis();
            millisCreating = finishCreating - startCreating;


            long startSearching = System.currentTimeMillis();

            while (br2.ready()) {
                numberOfLines++;
                if (map.get(br2.readLine().trim()) != null) {
                    find++;
                }
            }

            long finishSearching = System.currentTimeMillis();
            millisSearching = finishSearching - startSearching;

            System.out.println("Found " + find + " / " + numberOfLines + " entries. Time taken: " + millisToTime(millisCreating + millisSearching));
            System.out.println("Creating time: " + millisToTime(millisCreating));
            System.out.println("Searching time: " + millisToTime(millisSearching));
        }
        System.out.println();
    }

    public static String millisToTime(long millis) {
        return String.format("%d min. %d sec. %d ms.",
                TimeUnit.MILLISECONDS.toMinutes(millis),
                TimeUnit.MILLISECONDS.toSeconds(millis) % 60,
                millis % 1000
        );
    }  

    public static void quickSort(String[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        String pivot = source[(leftMarker + rightMarker) / 2].split(" ", 2)[1];
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (source[leftMarker].split(" ", 2)[1].compareTo(pivot) < 0) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (source[rightMarker].split(" ", 2)[1].compareTo(pivot) > 0) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    String tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
        }
    }

    public static void bubbleSort(String[] array) {
        int n = array.length;
        String temp = "";
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1].split(" ", 2)[1].compareTo(array[j].split(" ", 2)[1]) > 0) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static int linearSearch(String[] arr, String elementToSearch) {
        for (int index = 0; index < arr.length; index++) {
            if (arr[index].split(" ", 2)[1].equals(elementToSearch))
                return index;
        }
        return -1;
    }

    public static int jumpSearch(String[] arr, String x) {
        int n = arr.length;
        // Finding block size to be jumped
        int step = (int) Math.floor(Math.sqrt(n));
        // Finding the block where element is
        // present (if it is present)
        int prev = 0;
        while (arr[Math.min(step, n) - 1].split(" ", 2)[1].compareTo(x) < 0) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n)
                return -1;
        }
        // Doing a linear search for x in block
        // beginning with prev.
        while (arr[prev].split(" ", 2)[1].compareTo(x) < 0) {
            prev++;
            // If we reached next block or end of
            // array, element is not present.
            if (prev == Math.min(step, n))
                return -1;
        }
        // If element is found
        if (Objects.equals(arr[prev].split(" ", 2)[1], x))
            return prev;

        return -1;
    }

    public static int binarySearch(String[] arr, String elementToSearch) {

        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        // условие прекращения (элемент не представлен)
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            // если средний элемент - целевой элемент, вернуть его индекс
            if (arr[middleIndex].split(" ", 2)[1].equals(elementToSearch)) {
                return middleIndex;
            }

            // если средний элемент меньше
            // направляем наш индекс в middle+1, убирая первую часть из рассмотрения
            else if (arr[middleIndex].split(" ", 2)[1].compareTo(elementToSearch) < 0)
                firstIndex = middleIndex + 1;

                // если средний элемент больше
                // направляем наш индекс в middle-1, убирая вторую часть из рассмотрения
            else if (arr[middleIndex].split(" ", 2)[1].compareTo(elementToSearch) > 0)
                lastIndex = middleIndex - 1;

        }
        return -1;
    }
}
