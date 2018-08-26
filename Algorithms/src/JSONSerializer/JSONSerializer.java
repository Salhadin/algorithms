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

        //String json = "{k1:'1234',k2:{k3:'123',k4:'abc'},k3:'sddd'}";
        String json = "{k1:'1234'}";
        System.out.println("Serialized JSON: ");
        //serializeJSON(json, "Onject Name");
        if (json.startsWith("{") && json.endsWith("}")) {
            
        }
    }

    private static void serializeJSON(String json, String parent) {
        //if (json.startsWith("{") && json.endsWith("}")) {
        System.out.println("Input: " + json);
        if (json.contains(":")) {
            int colonIndex = json.indexOf(":");
            String key = json.substring(0, colonIndex).replace("{", "");
            String value = json.substring(colonIndex + 1);

            System.out.println("Key: " + parent + "." + key);
            System.out.println("Value: " + value);

            if (value.trim().startsWith("'")) {
                int quoteIndex = value.substring(1).indexOf("'");
                String subJson = value.substring(1).substring(quoteIndex + 1);
                serializeJSON(subJson, parent);
            } else if (value.trim().startsWith("{")) {
                serializeJSON(value.trim(), key);
            }
        }

        //}
    }

    public static String parse(String json) {
        if (json.length() == 0) {
            return "";
        }

        if (json.equals("}")) {

        }
        return "";
    }

}
