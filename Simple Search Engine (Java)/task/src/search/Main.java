package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String filePath = "";
        if (args.length == 2 && args[0].equals("--data")) {
            filePath = args[1];
        }
        List<String> people = uploadDataFromFile(filePath);
        Scanner scanner = new Scanner(System.in);
        mainMenu(scanner, people);
    }

    public static void mainMenu(Scanner scanner, List<String> people) {
        System.out.println("=== Menu ===");
        System.out.println("1. Find a person\n"
                + "2. Print all people\n"
                + "0. Exit");
        int selected = 0;
        if (scanner.hasNextInt()) {
            selected = scanner.nextInt();
        }
        switch (selected) {
            case 1 : searchStrategyMenu(scanner, people);
            break;
            case 2 : printAllPeopleCase(scanner, people);
            break;
            case 0 : System.out.println("Bye!");
            break;
            default:
                System.out.println("\nIncorrect option! Try again.\n");
                mainMenu(scanner, people);

        }
    }
    
    public static void searchStrategyMenu(Scanner scanner, List<String> people) {
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        String strategy = scanner.nextLine();
        strategy = strategy.equals("") ? scanner.nextLine().toLowerCase() : strategy.toLowerCase();
        SearchContext searchContext = null;
        switch (strategy) {
            case "all" : searchContext = new SearchContext(new AllSearchingStrategy());
            break;
            case "any" : searchContext = new SearchContext(new AnySearchingStrategy());
            break;
            case "none" : searchContext = new SearchContext(new NoneSearchingStrategy());
            break;
            default:
                System.out.println("\nIncorrect option! Try again.\n");
                searchStrategyMenu(scanner, people);
        }
        if (searchContext == null) {
            throw new NullPointerException("Unknown strategy type passed");
        }
        String query = getQuery(scanner);
        searchContext.perform(people, query);
        mainMenu(scanner, people);
    }

    public static String getQuery(Scanner scanner) {
        System.out.println("Enter a name or email to search all suitable people.");
        String query = scanner.nextLine();
        query = query.equals("") ? scanner.nextLine() : query;
        return query.toLowerCase();
    }
    public static void printAllPeopleCase(Scanner scanner, List<String> people) {
        System.out.println("=== List of people ===");
        for (String person : people) {
            System.out.println(person);
        }
        System.out.println();
        mainMenu(scanner, people);
    }

    public static void searchPeople(List<String> people, String query) {
        ArrayList<String> foundPeople = new ArrayList<>();
        for (String person : people) {
            if (person.toLowerCase().contains(query.toLowerCase())) {
                foundPeople.add(person);
            }
        }

        if (foundPeople.size() == 0) {
            System.out.println("No matching people found.\n");
        } else {
            for (String person : foundPeople) {
                System.out.println(person);
            }
            System.out.println();
        }
    }

    public static List<String> uploadDataFromFile(String filePath) {
        List<String> people = new ArrayList<>();
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                people.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return people;
    }
}
