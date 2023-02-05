import java.util.Scanner;

class brute {
    public static int algo(String text, String pattern) {
        int tl = text.length();
        int pl = pattern.length();

        for (int i = 0; i <= tl - pl; i++) {
            int j = 0;
            while ((j < pl) && (text.charAt(i + j) == pattern.charAt(j))) {
                j++;
            }
            if (j == pl) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        brute ob = new brute();
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String pattern = sc.nextLine();
        int posi = ob.algo(text, pattern) + 1;
        int end = posi + pattern.length();
        if (posi == 0) {
            System.out.println("pattern is not found");
        } else {
            System.out.println("Found at position: " + posi);
            System.out.println("end at position: " + end);
        }
    }

}