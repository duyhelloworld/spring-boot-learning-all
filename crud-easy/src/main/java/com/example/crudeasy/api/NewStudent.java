package com.example.crudeasy.api;

import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudeasy.dao.GetConnection;

@RestController
public class NewStudent {

    @PostMapping(value = "/student/new")
    public Boolean createStudent(@RequestBody String data) {
        
        List<String> result = new LinkedList<String>();
        // if (result.size() < properties.length) {
            // result.add("null");
        // }
        // while (isConnected()) {
        String cmd_insert = "INSERT INTO student.`student` VALUE (default, "
                + result.toString().substring(1, result.toString().indexOf("]")) + ")";
        PreparedStatement pstm = null;
        try {
            pstm = GetConnection.getConnection().prepareStatement(cmd_insert);
            pstm.executeUpdate(cmd_insert);
            
        } catch (Exception e) {
            return false;
        }
        return null;
    }
}

// public List<Student> createStd(@RequestBody String JSON) {
//     if (isConnected()) {
//         List<Student> ls = new ArrayList<Student>();
//         Student std = null;
//         ls.add();
//         return ls;
//     }
//     return null;
// }
// public Boolean createNewStd(String name, Boolean sex, Date dob, String mobileNumber, String email,
//         Float scoreEntranceExam,
//         Boolean olympicResult){
//     if (isConnected()) {
//         String command = "INSERT INTO `student`.student VALUE (default, " + name + "," + sex + "," + dob + "," + mobileNumber + "," + email + "," + scoreEntranceExam.toString() + "," + olympicResult.toString();
//         PreparedStatement stm = null;
//         try {
//             stm = conn.prepareStatement(command);
//             stm.executeQuery();
//             return true;
//         } catch (Exception e) {
//             e.getSuppressed();
//             return false;
//         }
//     } else {
//         return false;
//     }
// }
