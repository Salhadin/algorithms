/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editdistance;

import java.time.LocalTime;

/**
 *
 * @author saladin
 */
public class EditDistance {

    int[][] data;

    public static void main(String[] args) {

        EditDistance ed = new EditDistance();
        String s1 = "dxzoszpukf", s2 = "xcxgzsiqezsarya";
        System.out.println("Start time():" + LocalTime.now());

        ed.data = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                ed.data[i][j] = -1;
            }
        }
        System.out.println("Result: " + ed.minimumDeleteSum(s1, s2));
        System.out.println("End time():" + LocalTime.now());
    }

    public int minimumDeleteSum(String s1, String s2) {
        int x = s1.length(), y = s2.length();
        int z = minimumDeleteSum(s1, s2, x, y);
        return z;
    }

    public int minimumDeleteSum(String s1, String s2, int i, int j) {
        if (i == 0 && j == 0) {
            return 0;
        }
        if (i != 0 && j == 0) {
            int sumx = 0;
            for (int x = 0; x < i; x++) {
                sumx += (int) s1.charAt(x);
            }
            return sumx;
        }
        if (i == 0 && j != 0) {
            int sumy = 0;
            for (int y = 0; y < j; y++) {
                sumy += (int) s2.charAt(y);
            }
            return sumy;
        }
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return minimumDeleteSum(s1, s2, i - 1, j - 1);
        } else {
//            int x = data[i - 1][j] != -1 ? data[i - 1][j] : minimumDeleteSum(s1, s2, i - 1, j) + (int) s1.charAt(i - 1);
//            int y = data[i][j - 1] != -1 ? data[i][j - 1] : minimumDeleteSum(s1, s2, i, j - 1) + (int) s2.charAt(j - 1);
//            int z = data[i - 1][j - 1] != -1 ? data[i - 1][j - 1] : minimumDeleteSum(s1, s2, i - 1, j - 1) + (int) s1.charAt(i - 1) + (int) s2.charAt(j - 1);
//            data[i][j] = min(x, y, z);
//            return data[i][j];
            int x = data[i - 1][j] != -1 ? data[i - 1][j] : minimumDeleteSum(s1, s2, i - 1, j) + (int) s1.charAt(i - 1);
            int y = data[i][j - 1] != -1 ? data[i][j - 1] : minimumDeleteSum(s1, s2, i, j - 1) + (int) s2.charAt(j - 1);
            int z = data[i - 1][j - 1] != -1 ? data[i - 1][j - 1] : minimumDeleteSum(s1, s2, i - 1, j - 1) + (int) s1.charAt(i - 1) + (int) s2.charAt(j - 1);
            
            data[i][j] = min(x, y, z);
            return data[i][j];
        }
    }

    public int min(int x, int y, int z) {
        return x < y ? (x < z ? x : z) : (y < z ? y : z);
    }
}
