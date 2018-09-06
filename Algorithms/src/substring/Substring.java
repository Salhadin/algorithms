/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package substring;

/**
 *
 * @author saladin
 */
public class Substring {

    public static void main(String[] args) {
        String s1 = "about", s2 = "smabouter";
        System.out.printf("Is <%s> a substring of <%s>: %s\n", s2, s1, substring(s1, s2));
        
    }

    public static boolean substring(String s1, String s2) {
        String longer, shorter;
        if (s1.length() >= s2.length()) {
            longer = s1;
            shorter = s2;
        } else {
            longer = s2;
            shorter = s1;
        }

        int count = 0;
        for (int i = 0, j = 0; i < longer.length() && j < shorter.length();) {

            if (longer.charAt(i) == shorter.charAt(j)) {
                count++;
                i++;
                j++;
            } else {
                count = 0;
                i++;
            }
            if (count == shorter.length()) {
                return true;
            }
        }
        return false;
    }
}
