package tb.soft;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    private static final ConsoleUserDialog UI = new ConsoleUserDialog();

    static Set<Student> HS = new HashSet<>();
    static Set<Student> TS = new TreeSet<>();
    static List<Student> AL = new ArrayList();
    static List<Student> LL = new LinkedList();
    static Map<Integer, Student> HM = new HashMap();
    static Map<Integer, Student> TM = new TreeMap();
    static int personId = 1;
    static boolean running = true;
    static String toRemove = null;

    public static void main(String[] args) {


        while (running) {
            try {                    // wybór koleckji
                switch (UI.enterInt(
                        "1 - HashSet           \n" +
                                "2 - TreeSet      \n" +
                                "3 - ArrayList  \n" +
                                "4 - LinkedList     \n" +
                                "5 - HashMap\n" +
                                "6 - TreeMap\n" +
                                "7 - Exit\n" + "==>> ")) {
                    case 1:
                        chooseHashset();
                        break;
                    case 2:
                        chooseTreeset();
                        break;
                    case 3:
                        chooseArrayList();
                        break;
                    case 4:
                        chooseLinkedList();
                        break;
                    case 5:
                        chooseHashmap();
                        break;
                    case 6:
                        chooseTreemap();
                        break;
                    case 7:
                        running = false;
                        break;
                }
            } catch (Exception e) {
                UI.printErrorMessage(e.getMessage());
            }
        }
    }

    public static void chooseHashset() {
        try {
            switch (UI.enterInt("1 - Dodaj element           \n" +
                    "2 - Wyświetl elementy      \n" +
                    "3 - Usuń element  \n" + "==>> ")) {
                case 1:
                    addElement("hashset");
                    break;
                case 2:
                    for (Student student : HS) {
                        System.out.println("[" + student + "]");
                    }
                    break;
                case 3:
                    toRemove = UI.enterString("Element do usunięcia:\n");
                    for (Student student : HS) {
                        if (HS.iterator().next().equals(toRemove))
                            HS.iterator().remove();
                    }
                    break;
            }

        } catch (Exception e) {
            UI.printErrorMessage(e.getMessage());
        }
    }

    public static void chooseTreeset() {
        try {
            switch (UI.enterInt("1 - Dodaj element           \n" +
                    "2 - Wyświetl elementy      \n" +
                    "3 - Usuń element  \n" + "==>> ")) {
                case 1:
                    addElement("treeset");
                    break;
                case 2:
                    for (Student student : TS) {
                        System.out.println("[" + student + "]");
                    }
                    break;
                case 3:
                    toRemove = UI.enterString("Element do usunięcia:\n");
                    for (Student student : TS) {
                        if (TS.iterator().next().equals(toRemove))
                            TS.iterator().remove();
                    }
                    break;
            }

        } catch (Exception e) {
            UI.printErrorMessage(e.getMessage());
        }
    }

    public static void chooseArrayList() {
        try {
            switch (UI.enterInt("1 - Dodaj element           \n" +
                    "2 - Wyświetl elementy      \n" +
                    "3 - Usuń element  \n" + "==>> ")) {
                case 1:
                    addElement("arraylist");
                    break;
                case 2:
                    for (Student student : AL) {
                        System.out.println("[" + student + "]");
                    }
                    break;
                case 3:
                    toRemove = UI.enterString("Element do usunięcia:\n");
                    for (Student student : AL) {
                        if (AL.iterator().next().equals(toRemove))
                            AL.iterator().remove();
                    }
                    break;
            }

        } catch (Exception e) {
            UI.printErrorMessage(e.getMessage());
        }
    }

    public static void chooseLinkedList() {
        try {
            switch (UI.enterInt("1 - Dodaj element           \n" +
                    "2 - Wyświetl elementy      \n" +
                    "3 - Usuń element  \n" + "==>> ")) {
                case 1:
                    addElement("linkedlist");
                    break;
                case 2:
                    for (Student student : LL) {
                        System.out.println("[" + student + "]");
                    }
                    break;
                case 3:
                    toRemove = UI.enterString("Element do usunięcia:\n");
                    for (Student student : LL) {
                        if (LL.iterator().next().equals(toRemove))
                            LL.iterator().remove();
                    }
                    break;
            }

        } catch (Exception e) {
            UI.printErrorMessage(e.getMessage());
        }
    }

    public static void chooseHashmap() {
        try {
            switch (UI.enterInt("1 - Dodaj element           \n" +
                    "2 - Wyświetl elementy      \n" +
                    "3 - Usuń element  \n" + "==>> ")) {
                case 1:
                    addElement("hashmap");
                    break;
                case 2:
                    HM.forEach((key, value) -> System.out.println(key + ":" + value));
                    break;
                case 3:
                    toRemove = UI.enterString("Wybierz klucz elementu do usunięcia:\n");
                    HM.remove(toRemove);

                    break;
            }

        } catch (Exception e) {
            UI.printErrorMessage(e.getMessage());
        }
    }

    public static void chooseTreemap() {
        try {
            switch (UI.enterInt("1 - Dodaj element           \n" +
                    "2 - Wyświetl elementy      \n" +
                    "3 - Usuń element  \n" + "==>> ")) {
                case 1:
                    addElement("treemap");
                    break;
                case 2:
                    TM.forEach((key, value) -> System.out.println(key + ":" + value));
                    break;
                case 3:
                    toRemove = UI.enterString("Wybierz klucz elementu do usunięcia:\n");
                    TM.remove(toRemove);
                    break;
            }

        } catch (Exception e) {
            UI.printErrorMessage(e.getMessage());
        }
    }

    private static void addElement(String collection) {
        if (collection == "hashset") {
            Student stu = createNewPerson();
            HS.add(stu);
        }
        if (collection == "treeset") {
            Student stu = createNewPerson();
            TS.add(stu);
        }
        if (collection == "arraylist") {
            Student stu = createNewPerson();
            AL.add(stu);
        }
        if (collection == "linkedlist") {
            Student stu = createNewPerson();
            LL.add(stu);
        }
        if (collection == "hashmap") {
            Student stu = createNewPerson();
            HM.put(personId, stu);
            personId = +1;
        }
        if (collection == "treemap") {
            Student stu = createNewPerson();
            TM.put(personId, stu);
            personId = +1;
        }
    }


    static Student createNewPerson() {
        String first_name = UI.enterString("Podaj imię: ");
        String last_name = UI.enterString("Podaj nazwisko: ");
        String birth_year = UI.enterString("Podaj rok ur.: ");
        UI.printMessage("Dozwolone stanowiska:" + Arrays.deepToString(PersonJob.values()));
        String job_name = UI.enterString("Podaj stanowisko: ");
        Student student;
        try {
            // Utworzenie nowego obiektu klasy Person oraz
            // ustawienie wartości wszystkich atrybutów.
            student = new Student(first_name, last_name);
            student.setBirthYear(birth_year);
            student.setJob(job_name);
        } catch (Exception e) {
            return null;
        }
        return student;
    }


}

