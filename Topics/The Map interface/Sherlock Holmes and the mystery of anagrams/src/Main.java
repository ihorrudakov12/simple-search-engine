import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> firstWord = Arrays.asList(scanner.nextLine().toLowerCase().split(""));
        List<String> secondWord = Arrays.asList(scanner.nextLine().toLowerCase().split(""));
        Set<String> chars = new HashSet<>();
        Map<String, Integer> result1 = new HashMap<>();
        Map<String, Integer> result2 = new HashMap<>();
        for (String c : firstWord) {
            chars.add(c);
        }

        for (String c : firstWord) {
            result1.put(c, Collections.frequency(firstWord, c));
        }
        for (String c : secondWord) {
            result2.put(c, Collections.frequency(secondWord, c));
        }




        if (Objects.equals(result1, result2)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}