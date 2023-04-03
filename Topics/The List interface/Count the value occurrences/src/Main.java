import java.util.Collections;
import java.util.List;

class Counter {

    public static boolean checkTheSameNumberOfTimes(int elem, List<Integer> list1, List<Integer> list2) {
        if (list1 != null && list2 != null) {
            int firstCounter = 0, secondCounter = 0;
            for (int i : list1) {
                if (elem == i) {
                    firstCounter++;
                }
            }
            for (int i : list2) {
                if (elem == i) {
                    secondCounter++;
                }
            }
            if (firstCounter == secondCounter) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /*public static void main(String[] args) {
        List<Integer> list1 = List.of(9, 8, 4, 3, 2);
        List<Integer> list2 = List.of(1, 3, 3, 3);
        System.out.println(checkTheSameNumberOfTimes(3, list1, list2));
    }*/
}