package carsharing;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;

public class LearningProgressTracker {

    public static void main(String[] args) {
        //2
        /*System.out.println("Learning Progress Tracker");
        Scanner scanner = new Scanner(System.in);
        boolean mainLoop = true;
        List<Student> students = new ArrayList<>();
        while (mainLoop) {
            String s = scanner.nextLine();
            switch (s.strip().toLowerCase()) {
                case "exit": {
                    System.out.println("Bye!");
                    mainLoop = false;
                    break;
                }
                case "back": {
                    System.out.println("Enter 'exit' to exit the program.");
                    break;
                }
                case "": {
                    System.out.println("No input");
                    break;
                }
                case "add students": {
                    System.out.println("Enter student credentials or 'back' to return");
                    int totalStudentsHaveBeenAdded = 0;
                    while (true) {
                        s = scanner.nextLine();
                        if (s.equalsIgnoreCase("back")) {
                            System.out.println("Total " + totalStudentsHaveBeenAdded + " students have been added.");
                            break;
                        } else {
                            String[] str = s.split(" ");
                            if (str.length < 3) {
                                System.out.println("Incorrect credentials");
                            } else {
                                String firsName = str[0];
                                String email = str[str.length - 1];
                                String lastName = s.substring(firsName.length() + 1, s.indexOf(email) - 1);

                                if (checkStudent(firsName, lastName, email)) {
                                    Student st = new Student(firsName, lastName, email);
                                    students.add(st);
                                    totalStudentsHaveBeenAdded++;
                                    System.out.println("The student has been added.");
                                }
                            }
                        }
                    }
                    break;
                }
                default:
                    System.out.println("Unknown command!");
                    break;
            }
        }*/

        //3
        /*System.out.println("Learning Progress Tracker");
        Scanner scanner = new Scanner(System.in);
        boolean mainLoop = true;
        while (mainLoop) {
            String s = scanner.nextLine();
            switch (s.strip().toLowerCase()) {
                case "exit": {
                    System.out.println("Bye!");
                    mainLoop = false;
                    break;
                }
                case "back": {
                    System.out.println("Enter 'exit' to exit the program.");
                    break;
                }
                case "": {
                    System.out.println("No input");
                    break;
                }
                case "find": {
                    System.out.println("Enter an id or 'back' to return");
                    while (true) {
                        s = scanner.nextLine().strip();
                        if (s.equalsIgnoreCase("back")) {
                            break;
                        }
                        String finalS = s;
                        if (checkId(s)) {
                            System.out.println(students.stream().filter(x -> x.getStudentId().equalsIgnoreCase(finalS))
                                    .findAny().orElseThrow().pointsToString());
                        }
                    }
                    break;
                }
                case "add points": {
                    System.out.println("Enter an id and points or 'back' to return");
                    while (true) {
                        s = scanner.nextLine();
                        if (s.equalsIgnoreCase("back")) {
                            break;
                        }
                        String[] str = checkPoints(s);
                        if (str == null) continue;
                        students.stream().filter(x -> x.getStudentId().equalsIgnoreCase(str[0]))
                                .findAny()
                                .orElseThrow()
                                .addPoints(Integer.parseInt(str[1])
                                        , Integer.parseInt(str[2]),
                                        Integer.parseInt(str[3]),
                                        Integer.parseInt(str[4]));
                        System.out.println("Points updated");
                    }
                    break;
                }
                case "list": {
                    if (students.isEmpty()) {
                        System.out.println("No students found");
                    } else {
                        System.out.println("Students:");
                        students.forEach(x -> System.out.println(x.getStudentId()));
                    }
                    break;
                }
                case "add students": {
                    System.out.println("Enter student credentials or 'back' to return");
                    int totalStudentsHaveBeenAdded = 0;
                    while (true) {
                        s = scanner.nextLine();
                        if (s.equalsIgnoreCase("back")) {
                            System.out.println("Total " + totalStudentsHaveBeenAdded + " students have been added.");
                            break;
                        } else {
                            String[] str = s.split(" ");
                            if (str.length < 3) {
                                System.out.println("Incorrect credentials");
                            } else {
                                String firsName = str[0];
                                String email = str[str.length - 1];
                                String lastName = s.substring(firsName.length() + 1, s.indexOf(email) - 1);

                                if (checkStudent(firsName, lastName, email)) {
                                    Student st = new Student(firsName, lastName, email);
                                    students.add(st);
                                    totalStudentsHaveBeenAdded++;
                                    System.out.println("The student has been added.");
                                }
                            }
                        }
                    }
                    break;
                }
                default:
                    System.out.println("Unknown command!");
                    break;
            }
        }*/

        //4 and 5
        System.out.println("Learning Progress Tracker");
        Scanner scanner = new Scanner(System.in);
        boolean mainLoop = true;
        while (mainLoop) {
            String s = scanner.nextLine();
            switch (s.strip().toLowerCase()) {
                case "exit": {
                    System.out.println("Bye!");
                    mainLoop = false;
                    break;
                }
                case "back": {
                    System.out.println("Enter 'exit' to exit the program.");
                    break;
                }
                case "": {
                    System.out.println("No input");
                    break;
                }
                case "notify": {
                    long notifiedStudents = students.stream().filter(Student::informCount).count();
                    students.forEach(Student::notifyStudent);
                    System.out.println("Total " + notifiedStudents + " students have been notified.");
                    break;
                }
                case "statistics": {
                    System.out.println("Type the name of a course to see details or 'back' to quit");
                    Statistic stat = new Statistic(students);
                    System.out.println(stat.printStatictic());
                    while (true) {
                        s = scanner.nextLine().strip();
                        if (s.equalsIgnoreCase("back")) break;
                        String[] cources = {"Java", "DSA", "Databases", "Spring"};
                        String finalS1 = s;
                        if (Arrays.stream(cources).noneMatch(x -> x.equalsIgnoreCase(finalS1))) {
                            System.out.println("Unknown course");
                            continue;
                        }
                        stat.detailForCourse(s);

                    }
                    break;
                }
                case "find": {
                    System.out.println("Enter an id or 'back' to return");
                    while (true) {
                        s = scanner.nextLine().strip();
                        if (s.equalsIgnoreCase("back")) {
                            break;
                        }
                        String finalS = s;
                        if (checkId(s)) {
                            System.out.println(students.stream().filter(x -> x.getStudentId().equalsIgnoreCase(finalS))
                                    .findAny().orElseThrow().pointsToString());
                        }
                    }
                    break;
                }
                case "add points": {
                    System.out.println("Enter an id and points or 'back' to return");
                    while (true) {
                        s = scanner.nextLine();
                        if (s.equalsIgnoreCase("back")) {
                            break;
                        }
                        String[] str = checkPoints(s);
                        if (str == null) continue;
                        students.stream().filter(x -> x.getStudentId().equalsIgnoreCase(str[0]))
                                .findAny()
                                .orElseThrow()
                                .addPoints(Integer.parseInt(str[1])
                                        , Integer.parseInt(str[2]),
                                        Integer.parseInt(str[3]),
                                        Integer.parseInt(str[4]));
                        System.out.println("Points updated");
                    }
                    break;
                }
                case "list": {
                    if (students.isEmpty()) {
                        System.out.println("No students found");
                    } else {
                        System.out.println("Students:");
                        students.forEach(x -> System.out.println(x.getStudentId()));
                    }
                    break;
                }
                case "add students": {
                    System.out.println("Enter student credentials or 'back' to return");
                    int totalStudentsHaveBeenAdded = 0;
                    while (true) {
                        s = scanner.nextLine();
                        if (s.equalsIgnoreCase("back")) {
                            System.out.println("Total " + totalStudentsHaveBeenAdded + " students have been added.");
                            break;
                        } else {
                            String[] str = s.split(" ");
                            if (str.length < 3) {
                                System.out.println("Incorrect credentials");
                            } else {
                                String firsName = str[0];
                                String email = str[str.length - 1];
                                String lastName = s.substring(firsName.length() + 1, s.indexOf(email) - 1);

                                if (checkStudent(firsName, lastName, email)) {
                                    Student st = new Student(firsName, lastName, email);
                                    students.add(st);
                                    totalStudentsHaveBeenAdded++;
                                    System.out.println("The student has been added.");
                                }
                            }
                        }
                    }
                    break;
                }
                default:
                    System.out.println("Unknown command!");
                    break;
            }
        }
    }

    private static String[] checkPoints(String s) {
        String[] points = s.split(" ");
        if (points.length != 5) {
            System.out.println("Incorrect points format");
            return null;
        }
        try {
            for (int i = 1; i < points.length; i++) {
                if (Integer.parseInt(points[i]) < 0) {
                    System.out.println("Incorrect points format");
                    return null;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Incorrect points format");
            return null;
        }
        if (!checkId(points[0])) return null;
        return points;
    }

    private static boolean checkId(String id) {
        if (students.stream().noneMatch(x -> x.getStudentId().equalsIgnoreCase(id))) {
            System.out.printf("No student is found for id=%s", id);
            return false;
        }
        return true;
    }

    static List<Student> students = new ArrayList<>();

    static boolean checkStudent(String firstName, String lastName, String email) {
        if (!checkFirstName(firstName)) {
            System.out.println("Incorrect first name.");
            return false;
        }
        if (!checkLastName(lastName)) {
            System.out.println("Incorrect last name.");
            return false;
        }
        if (!checkEmail(email)) {
            System.out.println("Incorrect email.");
            return false;
        }
        if (students.stream().anyMatch(x -> x.getEmail().equalsIgnoreCase(email))) {
            System.out.println("This email is already taken.");
            return false;
        }
        return true;
    }

    static boolean checkFirstName(String firstName) {
        return firstName.matches("^[A-Za-z][A-Za-z'-]*[A-Za-z]") && !firstName.matches("^[A-Za-z]*['-]{2,}[A-Za-z]*");
    }

    static boolean checkLastName(String lastName) {
        return lastName.matches("^[A-Za-z][A-Za-z' -]*[A-Za-z]") && !lastName.matches("^[A-Z a-z]*['-]{2,}[A-Z a-z]*");
    }

    static boolean checkEmail(String email) {
        return email.matches("^[A-Za-z\\d.]+@[A-Za-z\\d]+[.][a-zA-Z\\d]+");
    }
}

class Statistic {
    static String[] mostPopular, leastPopular, highestActivity, lowestActivity, easiestCourse, hardestCourse;
    private static List<Student> students = new ArrayList<>();

    public Statistic(List<Student> students) {
        Statistic.students = students;
        mostPopular = getMostPopular();
        leastPopular = getLeastPopular();
        highestActivity = getHighestActivity();
        lowestActivity = getLowestActivity();
        easiestCourse = getEasiest();
        hardestCourse = getHardest();
    }

    public void detailForCourse(String course) {
        MathContext context = new MathContext(2, RoundingMode.HALF_UP);
        switch (course.toLowerCase()) {
            case "java": {
                System.out.println("Java");
                System.out.println("id" + "    " + "points" + "        " + "completed");
                students.stream()
                        .filter(x -> x.getJava() > 0)
                        .sorted(Comparator.comparingInt(Student::getJava).reversed().thenComparing(Student::getStudentId))
                        .forEach(st -> System.out.printf(st.getStudentId() + "    " + st.getJava()
                                + "        %.1f%%\n", new BigDecimal((st.getJava() * 100)).divide(new BigDecimal(600), context)));
                break;
            }
            case "dsa": {
                System.out.println("DSA");
                System.out.println("id" + "    " + "points" + "        " + "completed");
                students.stream()
                        .filter(x -> x.getdSA() > 0)
                        .sorted(Comparator.comparingInt(Student::getdSA).reversed().thenComparing(Student::getStudentId))
                        .forEach(st -> System.out.printf(st.getStudentId() + "    " + st.getdSA()
                                + "        %.1f%%\n", new BigDecimal((st.getdSA() * 100)).divide(new BigDecimal(400), context)));
                break;
            }
            case "databases": {
                System.out.println("Databases");
                System.out.println("id" + "    " + "points" + "        " + "completed");
                students.stream()
                        .filter(x -> x.getDataBases() > 0)
                        .sorted(Comparator.comparingInt(Student::getDataBases).reversed().thenComparing(Student::getStudentId))
                        .forEach(st -> System.out.printf(st.getStudentId() + "    " + st.getDataBases()
                                + "        %.1f%%\n", new BigDecimal((st.getDataBases() * 100)).divide(new BigDecimal(480), context)));
                break;
            }
            case "spring": {
                System.out.println("Spring");
                System.out.println("id" + "    " + "points" + "        " + "completed");
                students.stream()
                        .filter(x -> x.getSpring() > 0)
                        .sorted(Comparator.comparingInt(Student::getSpring).reversed().thenComparing(Student::getStudentId))
                        .forEach(st -> System.out.printf(st.getStudentId() + "    " + st.getSpring()
                                + "        %.1f%%\n", new BigDecimal((st.getSpring() * 100)).divide(new BigDecimal(550), context)));
                break;
            }
        }
    }


    public String printStatictic() {
        return "Most popular: " + toString(mostPopular) + "\n" +
                "Least popular: " + toString(leastPopular) + "\n" +
                "Highest activity: " + toString(highestActivity) + "\n" +
                "Lowest activity: " + toString(lowestActivity) + "\n" +
                "Easiest course: " + toString(easiestCourse) + "\n" +
                "Hardest course: " + toString(hardestCourse);
    }

    private String toString(String[] arr) {
        return String.join(", ", arr);
    }

    private static Map<String, Integer> mapOfSubmissions() {
        Map<String, Integer> mapOfSubmissions = new HashMap<>();
        mapOfSubmissions.put("Java", students.stream().map(Student::getSubmissionsJava).reduce(0, Integer::sum));
        mapOfSubmissions.put("DSA", students.stream().map(Student::getSubmissionsdSA).reduce(0, Integer::sum));
        mapOfSubmissions.put("Databases", students.stream().map(Student::getSubmissionsDataBases).reduce(0, Integer::sum));
        mapOfSubmissions.put("Spring", students.stream().map(Student::getSubmissionsSpring).reduce(0, Integer::sum));
        return mapOfSubmissions;
    }

    private static String[] getHighestActivity() {
        int maxValue = mapOfSubmissions().entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow()
                .getValue();
        if (maxValue == 0) return new String[]{"n/a"};
        return mapOfSubmissions().entrySet().stream().filter(x -> x.getValue() == maxValue).map(Map.Entry::getKey).toArray(String[]::new);
    }

    private static String[] getLowestActivity() {
        int minValue = mapOfSubmissions().entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow()
                .getValue();
        if (minValue == 0) return new String[]{"n/a"};
        String[] str = mapOfSubmissions().entrySet().stream()
                .filter(x -> Arrays.stream(getHighestActivity()).noneMatch(y -> x.getKey().equalsIgnoreCase(y)))
                .filter(x -> x.getValue() == minValue)
                .map(Map.Entry::getKey).toArray(String[]::new);
        if (str.length == 0) return new String[]{"n/a"};
        return str;
    }

    private static String[] getMostPopular() {
        long maxValue = mapOfPopular().entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .orElseThrow()
                .getValue();
        if (maxValue == 0) return new String[]{"n/a"};
        return mapOfPopular().entrySet().stream().filter(x -> x.getValue() == maxValue).map(Map.Entry::getKey).toArray(String[]::new);
    }

    private static String[] getLeastPopular() {
        long minValue = mapOfPopular().entrySet().stream()
                .min(Comparator.comparingLong(Map.Entry::getValue))
                .orElseThrow()
                .getValue();
        if (minValue == 0) return new String[]{"n/a"};
        String[] str = mapOfPopular().entrySet().stream()
                .filter(x -> Arrays.stream(getMostPopular()).noneMatch(y -> x.getKey().equalsIgnoreCase(y)))
                .filter(x -> x.getValue() == minValue)
                .map(Map.Entry::getKey).toArray(String[]::new);
        if (str.length == 0) return new String[]{"n/a"};
        return str;
    }

    private static Map<String, Long> mapOfPopular() {
        Map<String, Long> mapOfPopular = new HashMap<>();
        mapOfPopular.put("Java", students.stream().filter(x -> x.getJava() > 0).count());
        mapOfPopular.put("DSA", students.stream().filter(x -> x.getdSA() > 0).count());
        mapOfPopular.put("Databases", students.stream().filter(x -> x.getDataBases() > 0).count());
        mapOfPopular.put("Spring", students.stream().filter(x -> x.getSpring() > 0).count());
        return mapOfPopular;
    }

    private static Map<String, Integer> mapOfEasiest() {
        Map<String, Integer> mapOfEasiest = new HashMap<>();
        mapOfEasiest.put("Java", students.stream().map(Student::getJava).reduce(0, (x, y) -> {
            if (mapOfPopular().get("Java") == 0L) {
                return 0;
            }
            return Math.toIntExact((x + y) * 100L / mapOfPopular().get("Java"));
        }));
        mapOfEasiest.put("DSA", students.stream().map(Student::getdSA).reduce(0, (x, y) -> {
            if (mapOfPopular().get("DSA") == 0L) {
                return 0;
            }
            return Math.toIntExact((x + y) * 100L / mapOfPopular().get("DSA"));
        }));
        mapOfEasiest.put("Databases", students.stream().map(Student::getDataBases).reduce(0, (x, y) -> {
            if (mapOfPopular().get("Databases") == 0L) {
                return 0;
            }
            return Math.toIntExact((x + y) * 100L / mapOfPopular().get("Databases"));
        }));
        mapOfEasiest.put("Spring", students.stream().map(Student::getSpring).reduce(0, (x, y) -> {
            if (mapOfPopular().get("Spring") == 0L) {
                return 0;
            }
            return Math.toIntExact((x + y) * 100L / mapOfPopular().get("Spring"));
        }));
        return mapOfEasiest;
    }

    private static String[] getEasiest() {
        int i = mapOfEasiest().entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .orElseThrow()
                .getValue();
        if (i == 0) return new String[]{"n/a"};
        return mapOfEasiest().entrySet().stream().filter(x -> x.getValue() == i).map(Map.Entry::getKey).toArray(String[]::new);
    }

    private static String[] getHardest() {
        int i = mapOfEasiest().entrySet().stream()
                .min(Comparator.comparingLong(Map.Entry::getValue))
                .orElseThrow()
                .getValue();
        if (i == 0) return new String[]{"n/a"};
        String[] str = mapOfEasiest().entrySet().stream()
                .filter(x -> x.getValue() == i)
                .filter(x -> Arrays.stream(getEasiest()).noneMatch(y -> x.getKey().equalsIgnoreCase(y)))
                .map(Map.Entry::getKey).toArray(String[]::new);
        if (str.length == 0) return new String[]{"n/a"};
        return str;
    }
}

enum Course {
    JAVA("Java"), DSA("DSA"), DATABASES("Databases"), SPRING("Spring");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Student {
    private String firstName;
    private String lastName;
    private String email;
    private final String studentId;

    private int java = 0, dSA = 0, dataBases = 0, spring = 0;
    private int submissionsJava = 0, submissionsdSA = 0, submissionsDataBases = 0, submissionsSpring = 0;
    private boolean[] inform = new boolean[]{false, false, false, false};

    public void addPoints(int java, int dSA, int dataBases, int spring) {
        if (java > 0) submissionsJava++;
        if (dSA > 0) submissionsdSA++;
        if (dataBases > 0) submissionsDataBases++;
        if (spring > 0) submissionsSpring++;
        this.java += java;
        this.dSA += dSA;
        this.dataBases += dataBases;
        this.spring += spring;
        if (this.java >= 600) {
            this.java = 600;
        }
        if (this.dSA >= 400) {
            this.dSA = 400;
        }
        if (this.dataBases >= 480) {
            this.dataBases = 480;
        }
        if (this.spring >= 550) {
            this.spring = 550;
        }
    }

    boolean informCount() {
        if (this.java == 600 && !inform[0]) {
            return true;
        }
        if (this.dSA == 400 && !inform[1]) {
            return true;
        }
        if (this.dataBases == 480 && !inform[2]) {
            return true;
        }
        return this.spring == 550 && !inform[3];
    }

    public void notifyStudent() {
        if (this.java == 600 && !inform[0]) {
            System.out.println(messageToStudent(Course.JAVA));
            inform[0] = true;
        }
        if (this.dSA == 400 && !inform[1]) {
            System.out.println(messageToStudent(Course.DSA));
            inform[1] = true;
        }
        if (this.dataBases == 480 && !inform[2]) {
            System.out.println(messageToStudent(Course.DATABASES));
            inform[2] = true;
        }
        if (this.spring == 550 && !inform[3]) {
            System.out.println(messageToStudent(Course.SPRING));
            inform[3] = true;
        }
    }

    public String messageToStudent(Course course) {
        return String.format("To: %s\n" +
                "Re: Your Learning Progress\n" +
                "Hello, %s! You have accomplished our %s course!", email, firstName + " " + lastName, course.getName());
    }

    public int getSubmissionsJava() {
        return submissionsJava;
    }

    public int getSubmissionsdSA() {
        return submissionsdSA;
    }

    public int getSubmissionsDataBases() {
        return submissionsDataBases;
    }

    public int getSubmissionsSpring() {
        return submissionsSpring;
    }

    public int getJava() {
        return java;
    }

    public int getdSA() {
        return dSA;
    }

    public int getDataBases() {
        return dataBases;
    }

    public int getSpring() {
        return spring;
    }


    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.studentId = String.format("%05d", (int) (Math.random() * 100000));
    }

    public String pointsToString() {
        return String.format("%s points: Java=%d; DSA=%d; Databases=%d; Spring=%d", studentId, java, dSA, dataBases, spring);
    }

    public String getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
