package carsharing;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class SortingTool {
    public static void main(final String[] args) throws IOException {
        //1
        /*Scanner scanner = new Scanner(System.in);
        List<Long> list = new ArrayList<>();
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            list.add(number);
        }
        System.out.println("Total numbers: " + list.size() + ".");
        long max = list.stream().mapToLong(v -> v).max().orElseThrow();
        long times = list.stream().filter(x->x==max).count();
        System.out.println("The greatest number: " + max + " (" + times + " time(s)).");
        scanner.close();*/

        //2
        /*Scanner scanner = new Scanner(System.in);
        String dataType = "word";
        if (args[0] != null && args[0].equalsIgnoreCase("-dataType")) {
            dataType = args[1];
        }
        switch (dataType) {
            case "long": {
                List<Long> list = new ArrayList<>();
                while (scanner.hasNextLong()) {
                    long number = scanner.nextLong();
                    list.add(number);
                }
                System.out.println("Total numbers: " + list.size() + ".");
                long max = list.stream().mapToLong(v -> v).max().orElseThrow();
                long times = list.stream().filter(x -> x == max).count();
                System.out.println("The greatest number: " + max + " (" + times + " time(s)), " + times * 100 / list.size() + "%).");
                break;
            }
            case "line": {
                List<String> list = new ArrayList<>();
                while (scanner.hasNext()) {
                    list.add(scanner.nextLine());
                }
                String longestLine = list.stream().max(Comparator.comparingInt(String::length)).orElseThrow();
                List<String> longestLines = list.stream()
                        .filter(x -> x.length() == longestLine.length())
                        .collect(Collectors.toList());

                System.out.println("Total lines: " + list.size() + ".\nThe longest line:");
                longestLines.stream().sorted().forEach(System.out::println);
                long times = longestLines.stream().filter(x -> x.equals(longestLine)).count();
                System.out.println("(" + times + " time(s), " + times * 100 / list.size() + "%).");
                break;
            }
            case "word": {
                List<String> list = new ArrayList<>();
                while (scanner.hasNext()) {
                    list.add(scanner.next().trim());
                }
                String longestWord = list.stream().max(Comparator.comparingInt(String::length)).orElseThrow();
                List<String> longestWords = list.stream()
                        .filter(x -> x.length() == longestWord.length())
                        .collect(Collectors.toList());

                long times = longestWords.stream().filter(x -> x.equals(longestWord)).count();
                System.out.print("Total words: " + list.size() + ".\n");
                longestWords.stream().sorted().forEach(System.out::println);
                System.out.println("The longest word: " + longestWord + " (" + times + " time(s), " + times * 100 / list.size() + "%).");
                break;
            }
        }
        scanner.close();*/

        //3
        /*Scanner scanner = new Scanner(System.in);
        boolean sortIntegers = false;
        for (String s : args) {
            if (s.equalsIgnoreCase("-sortIntegers")) {
                sortIntegers = true;
                break;
            }
        }
        if (sortIntegers) {
            List<Long> list = new ArrayList<>();
            while (scanner.hasNextLong()) {
                long number = scanner.nextLong();
                list.add(number);
            }
            System.out.println("Total numbers: " + list.size() + ".");
            System.out.print("Sorted data: ");
            list.stream().sorted().forEach(x -> System.out.print(x + " "));
            System.out.println();
        } else if (args[0] != null && args[0].equalsIgnoreCase("-dataType")) {
            String dataType = "word";
            dataType = args[1];
            switch (dataType) {
                case "long": {
                    List<Long> list = new ArrayList<>();
                    while (scanner.hasNextLong()) {
                        long number = scanner.nextLong();
                        list.add(number);
                    }
                    System.out.println("Total numbers: " + list.size() + ".");
                    long max = list.stream().mapToLong(v -> v).max().orElseThrow();
                    long times = list.stream().filter(x -> x == max).count();
                    System.out.println("The greatest number: " + max + " (" + times + " time(s)), " + times * 100 / list.size() + "%).");
                    break;
                }
                case "line": {
                    List<String> list = new ArrayList<>();
                    while (scanner.hasNext()) {
                        list.add(scanner.nextLine());
                    }
                    String longestLine = list.stream().max(Comparator.comparingInt(String::length)).orElseThrow();
                    List<String> longestLines = list.stream()
                            .filter(x -> x.length() == longestLine.length())
                            .collect(Collectors.toList());

                    System.out.println("Total lines: " + list.size() + ".\nThe longest line:");
                    longestLines.stream().sorted().forEach(System.out::println);
                    long times = longestLines.stream().filter(x -> x.equals(longestLine)).count();
                    System.out.println("(" + times + " time(s), " + times * 100 / list.size() + "%).");
                    break;
                }
                case "word": {
                    List<String> list = new ArrayList<>();
                    while (scanner.hasNext()) {
                        list.add(scanner.next().trim());
                    }
                    String longestWord = list.stream().max(Comparator.comparingInt(String::length)).orElseThrow();
                    List<String> longestWords = list.stream()
                            .filter(x -> x.length() == longestWord.length())
                            .collect(Collectors.toList());

                    long times = longestWords.stream().filter(x -> x.equals(longestWord)).count();
                    System.out.print("Total words: " + list.size() + ".\n");
                    System.out.println("The longest word: " + longestWord + " (" + times + " time(s), " + times * 100 / list.size() + "%).");
                    break;
                }
            }
        }
        scanner.close();*/

        //4
        /*Scanner scanner = new Scanner(System.in);
        String sortingType = "natural";
        String dataType = "word";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equalsIgnoreCase("-sortingType")) {
                sortingType = args[i + 1] != null ? args[i + 1] : "natural";
            }
            if (args[i].equalsIgnoreCase("-dataType")) {
                dataType = args[i + 1] != null ? args[i + 1] : "word";
            }
        }
        switch (dataType) {
            case "long": {
                List<Long> list = new ArrayList<>();
                while (scanner.hasNextLong()) {
                    long number = scanner.nextLong();
                    list.add(number);
                }
                System.out.println("Total numbers: " + list.size() + ".");
                if (sortingType.equals("natural")) {
                    System.out.print("Sorted data: ");
                    list.stream().sorted().forEach(x -> System.out.print(x + " "));
                } else if (sortingType.equals("byCount")) {
                    Map<Long, Long> countLongs = list.stream()
                            .collect(Collectors.toMap(x -> x, y -> 1L, Long::sum));
                    countLongs.entrySet().stream()
                            .sorted(Map.Entry.<Long, Long> comparingByValue().thenComparing(Map.Entry.comparingByKey()))
                            .forEach(x ->
                                    System.out.printf("%s: %s time(s), %s%%\n",
                                            x.getKey(),
                                            x.getValue(),
                                            x.getValue() * 100 / list.size()));

                }
                break;
            }
            case "line": {
                List<String> list = new ArrayList<>();
                while (scanner.hasNext()) {
                    list.add(scanner.nextLine());
                }
                System.out.println("Total lines: " + list.size());
                if (sortingType.equals("natural")) {
                    System.out.println("Sorted data:");
                    list.stream().sorted().forEach(System.out::println);
                } else {
                    sortingAndPrint(sortingType, list);
                }
                break;
            }
            case "word": {
                List<String> list = new ArrayList<>();
                while (scanner.hasNext()) {
                    list.add(scanner.next().trim());
                }
                System.out.println("Total words: " + list.size());
                if (sortingType.equals("natural")) {
                    System.out.print("Sorted data: ");
                    list.stream().sorted().forEach(x -> System.out.print(x + " "));
                } else {
                    sortingAndPrint(sortingType, list);
                }
                break;
            }
        }
        scanner.close();*/

        //5
        /*boolean b = true;
        String sortingType = "natural";
        String dataType = "word";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equalsIgnoreCase("-sortingType")) {
                try {
                    if (args[i + 1] != null) {
                        if (args[i + 1].equalsIgnoreCase("natural") ||
                                args[i + 1].equalsIgnoreCase("byCount")) {
                            sortingType = args[i + 1];
                        }
                    } else {
                        sortingType = "natural";
                        System.out.println("No sorting type defined!");
                        b = false;
                    }
                } catch (Exception e) {
                    sortingType = "natural";
                    System.out.println("No sorting type defined!");
                    b = false;
                }
            }
            if (args[i].equalsIgnoreCase("-dataType")) {
                try {
                    if (args[i + 1] != null) {
                        if (args[i + 1].equalsIgnoreCase("long") ||
                                args[i + 1].equalsIgnoreCase("line") ||
                                args[i + 1].equalsIgnoreCase("word")) {
                            dataType = args[i + 1];
                        }
                    } else {
                        dataType = "word";
                        System.out.println("No data type defined!");
                        b = false;
                    }
                } catch (Exception e) {
                    dataType = "word";
                    System.out.println("No data type defined!");
                    b = false;
                }
            }
        }

        if (b) {
            String[] arguments = {"-sortingType", "natural", "byCount", "-dataType", "long", "line", "word"};
            Arrays.stream(args)
                    .filter(arg -> Arrays.stream(arguments).noneMatch(arg::equalsIgnoreCase))
                    .forEach(x -> System.out.println("\"" + x + "\" is not a valid parameter. It will be skipped."));

            Scanner scanner = new Scanner(System.in);
            switch (dataType) {
                case "long": {
                    List<Long> list = new ArrayList<>();
                    String number = "";
                    while (scanner.hasNext()) {
                        try {
                            number = scanner.next();
                            list.add(Long.parseLong(number));
                        } catch (Exception e) {
                            System.out.println("\"" + number + "\" is not a long. It will be skipped.");
                        }
                    }
                    System.out.println("Total numbers: " + list.size() + ".");
                    if (sortingType.equals("natural")) {
                        System.out.print("Sorted data: ");
                        list.stream().sorted().forEach(x -> System.out.print(x + " "));
                    } else if (sortingType.equals("byCount")) {
                        Map<Long, Long> countLongs = list.stream()
                                .collect(Collectors.toMap(x -> x, y -> 1L, Long::sum));
                        countLongs.entrySet().stream()
                                .sorted(Map.Entry.<Long, Long>comparingByValue().thenComparing(Map.Entry.comparingByKey()))
                                .forEach(x ->
                                        System.out.printf("%s: %s time(s), %s%%\n",
                                                x.getKey(),
                                                x.getValue(),
                                                x.getValue() * 100 / list.size()));

                    }
                    break;
                }
                case "line": {
                    List<String> list = new ArrayList<>();
                    while (scanner.hasNext()) {
                        list.add(scanner.nextLine());
                    }
                    System.out.println("Total lines: " + list.size());
                    if (sortingType.equals("natural")) {
                        System.out.println("Sorted data:");
                        list.stream().sorted().forEach(System.out::println);
                    } else {
                        sortingAndPrint(sortingType, list);
                    }
                    break;
                }
                case "word": {
                    List<String> list = new ArrayList<>();
                    while (scanner.hasNext()) {
                        list.add(scanner.next().trim());
                    }
                    System.out.println("Total words: " + list.size());
                    if (sortingType.equals("natural")) {
                        System.out.print("Sorted data: ");
                        list.stream().sorted().forEach(x -> System.out.print(x + " "));
                    } else {
                        sortingAndPrint(sortingType, list);
                    }
                    break;
                }
            }
            scanner.close();
        }*/

        //6
        boolean b = true;
        String sortingType = "natural";
        String dataType = "word";
        String outputFile = "";

        for (int i = 0; i < args.length; i++) {
            if (args[i].equalsIgnoreCase("-sortingType")) {
                try {
                    if (args[i + 1] != null) {
                        if (args[i + 1].equalsIgnoreCase("natural") ||
                                args[i + 1].equalsIgnoreCase("byCount")) {
                            sortingType = args[i + 1];
                        }
                    } else {
                        sortingType = "natural";
                        System.out.println("No sorting type defined!");
                        b = false;
                    }
                } catch (Exception e) {
                    sortingType = "natural";
                    System.out.println("No sorting type defined!");
                    b = false;
                }
            }
            if (args[i].equalsIgnoreCase("-dataType")) {
                try {
                    if (args[i + 1] != null) {
                        if (args[i + 1].equalsIgnoreCase("long") ||
                                args[i + 1].equalsIgnoreCase("line") ||
                                args[i + 1].equalsIgnoreCase("word")) {
                            dataType = args[i + 1];
                        }
                    } else {
                        dataType = "word";
                        System.out.println("No data type defined!");
                        b = false;
                    }
                } catch (Exception e) {
                    dataType = "word";
                    System.out.println("No data type defined!");
                    b = false;
                }
            }
            if (args[i].equalsIgnoreCase("-inputFile")) {
                try {
                    if (args[i + 1] != null) {
                        System.setIn(new FileInputStream(args[i + 1]));
                    }
                } catch (Exception ignored) {
                }
            }
            if (args[i].equalsIgnoreCase("-outputFile")) {
                try {
                    if (args[i + 1] != null) {
                        outputFile = args[i + 1];
                    }
                } catch (Exception ignored) {
                }
            }
        }
        if (!outputFile.equals("")) {
            bw = new BufferedWriter(new FileWriter(outputFile, true));
        }

        if (b) {
            String[] arguments = {"-sortingType", "natural", "byCount", "-dataType", "long", "line", "word", "inputFile", "-outputFile"};
            Arrays.stream(args)
                    .filter(arg -> Arrays.stream(arguments).noneMatch(arg::equalsIgnoreCase))
                    .forEach(x -> System.out.println("\"" + x + "\" is not a valid parameter. It will be skipped."));

            Scanner scanner = new Scanner(System.in);
            switch (dataType.toLowerCase()) {
                case "long": {
                    List<Long> list = new ArrayList<>();
                    String number = "";
//                    int i = 0;
                    while (scanner.hasNext()) {
//                        i++;
//                        if (i == 5) break;
                        try {
                            number = scanner.next();
                            list.add(Long.parseLong(number));
                        } catch (Exception e) {
                            System.out.println("\"" + number + "\" is not a long. It will be skipped.");
                        }
                    }
                    String finalOutputFile = outputFile;
                    println(outputFile, "Total numbers: " + list.size() + ".");
                    if (sortingType.equalsIgnoreCase("natural")) {
                        print(outputFile, "Sorted data: ");
                        list.stream().sorted().forEach(x -> print(finalOutputFile, x + " "));
                    } else if (sortingType.equalsIgnoreCase("byCount")) {
                        Map<Long, Long> countLongs = list.stream()
                                .collect(Collectors.toMap(x -> x, y -> 1L, Long::sum));
                        countLongs.entrySet().stream()
                                .sorted(Map.Entry.<Long, Long>comparingByValue().thenComparing(Map.Entry.comparingByKey()))
                                .forEach(x ->
                                        println(finalOutputFile, String.format("%s: %s time(s), %s%%",
                                                x.getKey(),
                                                x.getValue(),
                                                x.getValue() * 100 / list.size())));

                    }
                    break;
                }
                case "line": {
                    List<String> list = new ArrayList<>();
                    while (scanner.hasNext()) {
                        list.add(scanner.nextLine());
                    }
                    println(outputFile, "Total lines: " + list.size());
                    if (sortingType.equalsIgnoreCase("natural")) {
                        println(outputFile, "Sorted data:");
                        String finalOutputFile1 = outputFile;
                        list.stream().sorted().forEach(x -> println(finalOutputFile1, x));
                    } else {
                        sortingAndPrint(outputFile, sortingType, list);
                    }
                    break;
                }
                case "word": {
                    List<String> list = new ArrayList<>();
                    while (scanner.hasNext()) {
                        list.add(scanner.next().trim());
                    }
                    println(outputFile, "Total words: " + list.size());
                    if (sortingType.equalsIgnoreCase("natural")) {
                        print(outputFile, "Sorted data: ");
                        String finalOutputFile2 = outputFile;
                        list.stream().sorted().forEach(x -> println(finalOutputFile2, x + " "));
                    } else {
                        sortingAndPrint(outputFile, sortingType, list);
                    }
                    break;
                }
            }
            scanner.close();
//            System.in.close();
//            System.out.close();
            if (bw != null) {
                bw.close();
            }
        }
    }

    private static BufferedWriter bw;

    private static void println(String file, String text) {
        if (file.equals("")) {
            System.out.println(text);
        } else {
            try {
                bw.write(text);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void print(String file, String text) {
        if (file.equals("")) {
            System.out.print(text);
        } else {
            try {
                bw.write(text);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void sortingAndPrint(String outputFile, String sortingType, List<String> list) {
        if (sortingType.equals("byCount")) {
            Map<String, Long> countLongs = list.stream()
                    .collect(Collectors.toMap(x -> x, y -> 1L, Long::sum));
            countLongs.entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().thenComparing(Map.Entry.comparingByKey()))
                    .forEach(x ->
                            print(outputFile, String.format("%s: %s time(s), %s%%\n",
                                    x.getKey(),
                                    x.getValue(),
                                    x.getValue() * 100 / list.size())));
        }
    }
}
