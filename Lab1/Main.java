package Tuan1;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            String projectPath = System.getProperty("user.dir");

            File inputFile = new File(projectPath + "/src/Tuan1/input.txt");


            System.out.println("Input path: " + inputFile.getAbsolutePath());


            Scanner sc = new Scanner(inputFile);

            int idx = 1;

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                int n = Integer.parseInt(line);

                System.out.println(idx + "," + buildPerfectList(n));
                idx++;
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

    public static String buildPerfectList(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        boolean first = true;

        for (int i = 2; i <= n; i++) {
            if (checkPerfect(i)) {
                if (!first) sb.append(",");
                sb.append(i);
                first = false;
            }
        }

        sb.append("]");
        return sb.toString();
    }

    public static boolean checkPerfect(long n) {
        if (n <= 1) return false;

        long sum = 1;
        for (long i = 2; i <= n / 2; i++) {
            if (n % i == 0) sum += i;
        }
        return sum == n;
    }
}

