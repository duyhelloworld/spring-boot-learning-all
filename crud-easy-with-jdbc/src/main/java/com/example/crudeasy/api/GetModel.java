package com.example.crudeasy.api;

import java.util.ArrayList;
import java.util.List;


public class GetModel {
    public static List<String> jsonToModel(String json) {
        
        List<String> result = new ArrayList<String>();

        String[] listStudent = json.split("},");

        for (final String S_student : listStudent) {
            // Not have id
            if (!S_student.contains("id")) {
                return null;
            } else {
                String[] properties = { "id", "name", "sex", "dob" };
                String[] keys_values = S_student.split(",");
                String tmp = "";

                for (int i = 0; i < keys_values.length; i++) {
                    final String key_value = keys_values[i];
                    for (String prop : properties) {
                        if (key_value.contains(prop)) {
                            tmp += key_value.substring(key_value.indexOf(":") + 1).replace("]", "")
                                    .replace("}", "").concat(i == keys_values.length-1 ? "" : ", ");
                            break;
                        }
                    }
                }
                result.add(tmp.stripTrailing());
            }
        }
        return result;
    }

    // public static void main(String[] args) {
    //     List<String> list = jsonToModel(
    //             "[      {\"id\": 1,\"name\": \"Pham Duy\",\"sex\":true,\"dob\": \"2003-12-10\"}," + 
    //                     "{\"id\": 2,\"name\": \"Nguyen Hieu\",\"sex\":true,\"dob\": \"2003-01-20\"}," +
    //                    "{\"id\": 3,\"name\": \"Le Hang\",\"sex\":false,\"dob\": \"2002-11-20\"}]");
    //     for (String std : list) {
    //         System.out.println(std);
    //     }
    // }
}
