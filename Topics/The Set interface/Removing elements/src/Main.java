import java.util.*;

class SetUtils {

    public static Set<Integer> getSetFromString(String str) {
        Set<Integer> numbers = new TreeSet<>();
        String[] strNums = str.split(" ");
        for (String num : strNums) {
            numbers.add(Integer.parseInt(num));
        }
        return numbers;
    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
        set.removeIf(num -> num > 10);
    }
}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        Set<Integer> set = SetUtils.getSetFromString(numbers);
        SetUtils.removeAllNumbersGreaterThan10(set);
        set.forEach(e -> System.out.print(e + " "));
    }
}