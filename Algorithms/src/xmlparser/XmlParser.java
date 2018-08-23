/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlparser;

import java.util.Stack;

/**
 *
 * @author 986036
 */
public class XmlParser {

    static Stack<String> stack = new Stack<>();

    public static void main(String[] args) {
        String xml = "<note>\n"
                + "<to>Tove</to>\n"
                + "<from>Jani</from>\n"
                + "<heading>Reminder</heading>\n"
                + "<body>Don't forget me this weekend!</body>\n"
                + "</note>";
        System.out.println("Is xml valid: " + parseXml(xml));
    }

    static boolean parseXml(String xml) {
        System.out.println("\nInput XML: " + xml);
        int index = 0;
        if (xml.startsWith("<")) {
            StringBuilder b = new StringBuilder();
            for (int i = 1; i < xml.length(); i++) {
                if (xml.charAt(i) == '>') {
                    processStack(b.toString());
                    index = i + 1;
                    break;
                    //b.delete(i, i)
                } else {
                    b.append(xml.charAt(i));
                }
            }
            parseXml(xml.substring(index));
            return stack.isEmpty();
        } else {
            if (xml.length() == 0) {
                return false;
            } else {
                return parseXml(xml.substring(xml.indexOf("<")));
            }
        }
    }

    private static void processStack(String b) {
        String node = b.replaceAll("/|<|>", "");
        if (stack.isEmpty()) {
            stack.add(node);
        } else if (stack.peek().equalsIgnoreCase(node)) {
            stack.pop();
        } else {
            stack.push(node);
        }
        System.out.println("Stack: " + stack);
    }
}
