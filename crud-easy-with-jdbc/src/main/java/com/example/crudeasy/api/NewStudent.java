package com.example.crudeasy.api;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudeasy.dao.GetConnection;

@RestController
public class NewStudent {

    @PostMapping(value = "/student/new")
    public Boolean createStudent(@RequestBody String data) {
        
        List<String> result = GetModel.jsonToModel(data);
        PreparedStatement pstm = null;
        try {
            String cmd_insert = "INSERT INTO JDBC_CRUD.`student` VALUE (default, ?, ?, ?, ?)";
            pstm = GetConnection.getConnection().prepareStatement(cmd_insert);
            for (String value : result) {
                int rowAffected = pstm.executeUpdate(cmd_insert);
                if (rowAffected == result.size()) {
                    return true;
                }
            }
        } catch (Exception e) {
            
        }
        return false;
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
