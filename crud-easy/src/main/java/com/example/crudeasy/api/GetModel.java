package com.example.crudeasy.api;

import java.util.Arrays;


public class GetModel {
    public static String[] jsonToModel(String json) {
        // List<Student> list = new ArrayList<Student>();
        
        String[] properties = { "name", "sex", "dob", "height", "mobileNumber", "email" };
        // All is not null
        String[] arrayStudent = json.split("},");

        for (final String student : arrayStudent) {
            if (!student.contains("id")) {
                // Not have id
                return null;
            } else {
                // Have id
                int numberProperOfStudent = 0;
                for (String property : properties) {
                    if (student.contains(property)) {
                        numberProperOfStudent++;
                    }
                }

                if (numberProperOfStudent != properties.length) {
                    // Not enough property
                    return null;
                }
                else {
                        // Parse to list Student
                        // Long id = Long.valueOf(student.substring(student.indexOf("id:"), student.indexOf(",")));
                        // String name = student.substring(student.indexOf("name:"), );
                        // Boolean sex = Boolean.valueOf(student.substring(student.indexOf("sex:"), ));
                        
                }

            }
        }
        return arrayStudent;
    }
    public static void main(String[] args) {
        String[] list = jsonToModel("{\"userId\": 1,\n\"id\": 1,\"title\":\"delectus aut autem\",\"completed\": false}");
        System.out.println(Arrays.toString(list));
    }
}
