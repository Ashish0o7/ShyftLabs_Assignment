// This is probably the only approach that would work for this question, as it requires
// us to find the first index of -1, we have to go through all the elements and should return
// count when first -1 appears
// Time complexity O(N), N here would be number of elements utto first -1.

import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        int indx_neg = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int x = scanner.nextInt();

            if (x == -1) {
                break;
            }
            indx_neg++;
        }
        System.out.println(indx_neg);
    }
}
