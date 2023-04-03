class Problem {
    public static void main(String[] args) {
        int counter = 0;
        int number = 8;
        int[] digits = {6, 7, 9, 6, 6, 6, 3, 1, 0, 1, 7, 6, 0, 3, 1, 2, 1, 9, 2, 3, 8, 9, 8, 6, 7, 0, 2, 2, 1, 5, 3, 3, 7, 8, 2, 7, 4, 5, 0, 3, 6, 5, 9, 4, 9, 8, 8, 9, 5, 0, 6, 8, 3, 3, 1, 8, 0, 4, 6, 5, 7, 5, 6, 1, 3, 2, 4, 0, 2, 6, 2, 9, 4, 8, 2, 7, 4, 6, 8, 2, 2, 8, 2, 2, 9, 1, 1, 3, 2, 5, 9, 2, 2, 5, 3, 4, 3, 3, 2, 1};
        for (int i : digits) {
            if (number == i) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}