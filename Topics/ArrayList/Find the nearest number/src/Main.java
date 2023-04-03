import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();

        String[] numbers = scanner.nextLine().split(" ");
        for (String number : numbers) {
            nums.add(Integer.parseInt(number));
        }
        int digit = 0;
        if (scanner.hasNextInt()) {
            digit = scanner.nextInt();
        }
        Collections.sort(nums);
        //System.out.println(nums);
        //System.out.println(digit);

        List<Integer> diffs = new ArrayList<>();
        for (int num : nums) {
            diffs.add(Math.abs(digit - num));
        }
        int minDif = Collections.min(diffs);

        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < diffs.size(); i++) {
            if (diffs.get(i) == minDif) {
                indexes.add(i);
            }
        }

        for (int i : indexes) {
            System.out.print(nums.get(i) + " ");
        }
    }
}