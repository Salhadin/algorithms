/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONSerializer;

/**
 *
 * @author 986036
 */
public class JSONSerializer {

    public static void main(String[] args) {
        String json = "{k1:'1234',k2:{k3:'123',k4:'abc'},k3:'sddd'}";
        System.out.println("Serialized JSON: ");
        serializeJSON("", json);
    }

    private static void serializeJSON(String parent, String json) {
        if (json.startsWith("{") && json.endsWith("}")) {
            String[] entries = json.substring(1, json.length() - 1).split(",");
            for (String entry : entries) {
                String[] keyValuePair = entry.split(":");
                String key = keyValuePair[0];
//                String value = keyValuePair[1];
//                if (!isObject(value)) {
//                    System.out.print(key + ".");
//                    serializeJSON(key, value);
//                    System.out.print(key + ".");
//                    serializeJSON(key, value);
//                } else {
//                    System.out.print(key + "->");
//                }
                System.out.print(key + "->");
            }
        }
    }

    private static boolean isObject(String value) {
        return value.startsWith("\'") && value.endsWith("\'");
    }

}
