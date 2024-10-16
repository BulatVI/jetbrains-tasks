package carsharing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleSearchEngine {
    public static void main(String[] args) throws IOException {
        //1
        /*try (Scanner sc = new Scanner(System.in)) {
            String words = sc.nextLine();
            String searchWord = sc.next();

            if (!words.contains(searchWord)) {
                System.out.println("Not found");
            } else {
                String[] strings = words.split(" ");
                int i = 0;
                boolean b = false;
                for (String str : strings) {
                    i++;
                    if (str.equals(searchWord)) {
                        b = true;
                        break;
                    }
                }
                if (b) System.out.println(i);
                else System.out.println("Not found");
            }
        }*/

        //2
        /*try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the number of people:");
            int i = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter all people:");
            String[] s = new String[i];
            for (int j = 0; j < i; j++) {
                s[j] = sc.nextLine();
                //if (j != i - 1) sc.nextLine();
            }

            System.out.println();
            System.out.println("Enter the number of search queries:");
            i = sc.nextInt();
            sc.nextLine();
            String searchWord;
            for (int j = 0; j < i; j++) {
                List<String> list = new ArrayList<>();
                System.out.println("Enter data to search people:");
                searchWord = sc.nextLine().trim().toLowerCase();
                System.out.println();

                String finalSearchWord = searchWord;
                Arrays.stream(s).filter(x -> x.toLowerCase().contains(finalSearchWord)).forEach(list::add);

                if (list.size() > 0) {
                    System.out.println("Found people:");
                    list.forEach(System.out::println);
                } else System.out.println("No matching people found.");
                System.out.println();
            }
        }*/

        //3
        /*try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the number of people:");
            int i = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter all people:");
            String[] peoples = new String[i];
            for (int j = 0; j < i; j++) {
                peoples[j] = sc.nextLine();
//                if (j != i - 1) sc.nextLine();
            }

            boolean b = true;
            while (b) {
                System.out.println("\n=== Menu ===\n" +
                        "1. Find a person\n" +
                        "2. Print all people\n" +
                        "0. Exit");
                i = sc.nextInt();
                List<String> list = new ArrayList<>();
                switch (i) {
                    case 1: { //Find a person
                        System.out.println("Enter a name or email to search all suitable people.");
                        sc.nextLine();
                        String finalSearchPeople = sc.nextLine().trim().toLowerCase();
                        Arrays.stream(peoples).filter(x -> x.toLowerCase().contains(finalSearchPeople)).forEach(list::add);

                        if (list.size() > 0) {
                            list.forEach(System.out::println);
                        } else System.out.println("No matching people found.");
                        break;
                    }
                    case 2: { //Print all people
                        System.out.println("\n=== List of people ===");
                        Arrays.stream(peoples).forEach(System.out::println);
                        break;
                    }
                    case 0: {
                        System.out.println("\nBye!");
                        b = false;
                        break;
                    }
                    default: {
                        System.out.println("Incorrect option! Try again.");
                        break;
                    }
                }
            }
        }*/

        //4
        /*if (!args[0].toLowerCase().equals("--data") || args[1] != null) {
            try (Scanner sc = new Scanner(System.in);
                 BufferedReader br = new BufferedReader(new FileReader(args[1]))
            ) {
                StringBuilder sb1 = new StringBuilder();
                while (br.ready()) {
                    sb1.append(br.readLine()).append("\n");
                }
                String[] peoples = sb1.toString().split("\n");

                boolean b = true;
                while (b) {
                    System.out.println("\n=== Menu ===\n" +
                            "1. Find a person\n" +
                            "2. Print all people\n" +
                            "0. Exit");
                    int i = sc.nextInt();
                    List<String> list = new ArrayList<>();
                    switch (i) {
                        case 1: { //Find a person
                            System.out.println("Enter a name or email to search all suitable people.");
                            sc.nextLine();
                            String finalSearchPeople = sc.nextLine().trim().toLowerCase();
                            Arrays.stream(peoples).filter(x -> x.toLowerCase().contains(finalSearchPeople)).forEach(list::add);

                            if (list.size() > 0) {
                                list.forEach(System.out::println);
                            } else System.out.println("No matching people found.");
                            break;
                        }
                        case 2: { //Print all people
                            System.out.println("\n=== List of people ===");
                            Arrays.stream(peoples).forEach(System.out::println);
                            break;
                        }
                        case 0: {
                            System.out.println("\nBye!");
                            b = false;
                            break;
                        }
                        default: {
                            System.out.println("Incorrect option! Try again.");
                            break;
                        }
                    }
                }
            }
        }*/

        //5
        /*if (!args[0].equalsIgnoreCase("--data") || args[1] != null) {
            try (Scanner sc = new Scanner(System.in);
                 BufferedReader br = new BufferedReader(new FileReader(args[1]))
            ) {
                Map<String, List<Integer>> map;
                Set<String> set;
                Map<Integer, String> peoples = new LinkedHashMap<>();
                StringBuilder sb1 = new StringBuilder();
                int k = 0;
                while (br.ready()) {
                    String temp = br.readLine();
                    sb1.append(temp).append("\n");
                    peoples.put(k++, temp);
                }

                String[] words = sb1.toString().split("[ \n]");
                set = Arrays.stream(words).collect(Collectors.toSet());

                map = set.stream().collect(Collectors.toMap((String x) -> x,
                        (String y) -> peoples.entrySet()
                                .stream()
                                .filter(z -> z.getValue().toLowerCase().contains(y.toLowerCase()))
                                .map(Map.Entry::getKey)
                                .collect(Collectors.toList())
                ));

                boolean b = true;
                while (b) {
                    System.out.println("\n=== Menu ===\n" +
                            "1. Find a person\n" +
                            "2. Print all people\n" +
                            "0. Exit");
                    int i = sc.nextInt();
                    List<String> list = new ArrayList<>();
                    switch (i) {
                        case 1: { //Find a person
                            System.out.println("Enter a name or email to search all suitable people.");
                            sc.nextLine();
                            String searchPeople = sc.nextLine().trim().toLowerCase();
                            map.entrySet()
                                    .stream()
                                    .filter(x -> x.getKey().equalsIgnoreCase(searchPeople))
                                    .map(Map.Entry::getValue)
                                    .flatMap(Collection::stream)
                                    .map(peoples::get)
                                    .forEach(list::add);

                            if (list.size() > 0) {
                                System.out.println(list.size() + " persons found:");
                                list.forEach(System.out::println);
                            } else System.out.println("No matching people found.");
                            break;
                        }
                        case 2: { //Print all people
                            System.out.println("\n=== List of people ===");
                            peoples.values().forEach(System.out::println);
                            break;
                        }
                        case 0: {
                            System.out.println("\nBye!");
                            b = false;
                            break;
                        }
                        default: {
                            System.out.println("Incorrect option! Try again.");
                            break;
                        }
                    }
                }
            }
        }*/

        //6
        if (!args[0].equalsIgnoreCase("--data") || args[1] != null) {
            try (Scanner sc = new Scanner(System.in);
                 BufferedReader br = new BufferedReader(new FileReader(args[1]))
            ) {
                Map<String, List<Integer>> map;
                Set<String> set;
                Map<Integer, String> peoples = new LinkedHashMap<>();
                StringBuilder sb1 = new StringBuilder();
                int k = 0;
                while (br.ready()) {
                    String temp = br.readLine();
                    sb1.append(temp).append("\n");
                    peoples.put(k++, temp);
                }

                String[] words = sb1.toString().split("[ \n]");
                set = Arrays.stream(words).collect(Collectors.toSet());

                map = set.stream().collect(Collectors.toMap(String::toLowerCase,
                        (String y) -> peoples.entrySet()
                                .stream()
                                .filter(z -> z.getValue().toLowerCase().contains(y.toLowerCase()))
                                .map(Map.Entry::getKey)
                                .collect(Collectors.toList())
                ));

                boolean b = true;
                while (b) {
                    System.out.println("\n=== Menu ===\n" +
                            "1. Find a person\n" +
                            "2. Print all people\n" +
                            "0. Exit");
                    int i = sc.nextInt();
                    List<String> list = new ArrayList<>();
                    switch (i) {
                        case 1: { //Find a person
                            System.out.println("Select a matching strategy: ALL, ANY, NONE");
                            String strategy = sc.next();
                            System.out.println("Enter a name or email to search all suitable people.");
                            sc.nextLine();
                            String searchPeople = sc.nextLine().trim().toLowerCase();
                            String[] searchPeoples = searchPeople.toLowerCase().trim().split(" ");

//                            System.out.println(searchPeople);
//                            System.out.println(Arrays.toString(searchPeoples));
//                            System.out.println(map);
//                            System.out.println(peoples);

                            List<Integer> rowNumberList = map.keySet().stream()
                                    .filter((String x) -> Arrays.stream(searchPeoples)
                                            .anyMatch((String q1) -> q1.equalsIgnoreCase(x))
                                    )
                                    .map(map::get)
                                    .flatMap(Collection::stream)
                                    .distinct()
                                    .collect(Collectors.toList());

                            switch (strategy.toUpperCase()) {
                                case "ALL": {
                                    List<Integer> spisokStrok = new ArrayList<>();
                                    for (String str : searchPeoples) {
                                        if (map.get(str.toLowerCase()) == null) {
                                            spisokStrok.clear();
                                            break;
                                        } else {
                                            spisokStrok.addAll(map.get(str.toLowerCase()));
                                        }
                                    }

                                    Map<Integer, Integer> frequency = spisokStrok.stream().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
                                    frequency.entrySet().stream()
                                            .filter(x -> x.getValue() == searchPeoples.length)
                                            .map(Map.Entry::getKey)
                                            .map(peoples::get)
                                            .distinct()
                                            .forEach(list::add);

                                    break;
                                }
                                case "ANY": {
                                    peoples.keySet().stream()
                                            .filter(q ->
                                                    rowNumberList.stream()
                                                            .anyMatch(z -> Objects.equals(z, q))
                                            )
                                            .forEach(z -> list.add(peoples.get(z)));
                                    break;
                                }
                                case "NONE": {
                                    peoples.keySet().stream()
                                            .filter(q ->
                                                    rowNumberList.stream()
                                                            .noneMatch(z -> Objects.equals(z, q))
                                            )
                                            .forEach(z -> list.add(peoples.get(z)));
                                    break;
                                }
                            }

                            if (list.size() > 0) {
                                System.out.println(list.size() + " persons found:");
                                list.forEach(System.out::println);
                            } else System.out.println("No matching people found.");
                            break;
                        }
                        case 2: { //Print all people
                            System.out.println("\n=== List of people ===");
                            peoples.values().forEach(System.out::println);
                            break;
                        }
                        case 0: { //Bye
                            System.out.println("\nBye!");
                            b = false;
                            break;
                        }
                        default: {
                            System.out.println("Incorrect option! Try again.");
                            break;
                        }
                    }
                }
            }
        }
    }
}
