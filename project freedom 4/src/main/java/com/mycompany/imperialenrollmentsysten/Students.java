/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.imperialenrollmentsysten;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
/**
 *
 * @author lajimperial
 */
public class Students extends ImperialENROLLMENTSYSTEN {
    int studentID;
    String Name;
    String Address; 
    String Course;  // Changed from Contact to Course
    String Email;
    String Gender;
    String yearLvl;
    ImperialENROLLMENTSYSTEN a = new ImperialENROLLMENTSYSTEN();
    
public void SaveRecord(int studentID, String Name, String Address, String Course, String Email, String Gender, String yearLvl ){  // Changed Contact to Course
    a.connectDB();
    String query;
    if (studentID == 0){
    query = "INSERT INTO students(Name, Address, Course, Email, Gender, yearLvl) VALUES('" + Name + "', '" + Address + "', '" + Course + "', '" + Email + "', '" + Gender + "', '" + yearLvl + "')";  // Changed Contact to Course
    } else {
        query = "INSERT INTO students (studentID, Name, Address, Course, Email, Gender, yearLvl) VALUES (?, ?, ?, ?, ?, ?, ?)";  // Changed Contact to Course
    }
    
    try {
        a.stl.executeUpdate(query);
        System.out.println("Added a new entry!");
        } catch (Exception ex) {
            System.out.println("SAVE FAILED: " + ex.getMessage());
            ex.printStackTrace();
    }
}
public void DeleteRecord(int studentID){
    a.connectDB();
    String query  = "DELETE FROM students where studentID = " + studentID;
    try {
        a.stl.executeUpdate(query);
        System.out.println("Entry has been deleted!!!!");
    } catch (Exception ex) {
        System.out.println("DELETE FAILED");
        ex.printStackTrace();
    }
    
}
public void UpdateRecord(int studentID, String Name, String Address, String Course, String Email, String Gender, String yearLvl ){  // Changed Contact to Course
    a.connectDB();
    String query = "UPDATE students SET Name=?, Address=?, Course=?, Email=?, Gender=?, yearLvl=? WHERE studentID=?";  // Changed Contact to Course
    try (PreparedStatement pstmt = a.con.prepareStatement(query)) {
        pstmt.setString(1, Name);
        pstmt.setString(2, Address);
        pstmt.setString(3, Course);  // Changed Contact to Course
        pstmt.setString(4, Email);
        pstmt.setString(5, Gender);
        pstmt.setString(6, yearLvl);
        pstmt.setInt(7, studentID);
        
        pstmt.executeUpdate();
        System.out.println("Entry has CHANGED!!!");
    } catch (SQLException ex) {
        System.out.println("UPDATE FAILED" + ex.getMessage());
        ex.printStackTrace();
    }
}
public ResultSet LoadRecord(){
    a.connectDB();
    String query = "Select * FROM students";
    try {
        return a.stl.executeQuery(query);
    }catch(Exception e) {
        System.out.println("Error fetching records beause of " + e.getMessage());
        return null;
    }

}
public ResultSet LoadEnrollments(int studid) throws SQLException {
    a.connectDB(); // Connect using your existing DB connection method
String sql = """
    SELECT e.subjid, s.SUBcode, s.SUBdesc, s.SUBUNITS, s.SUBsched
    FROM Enroll e
    JOIN subjects s ON e.subjid = s.SUBid
    WHERE e.studid = ?
""";

    PreparedStatement pst = a.con.prepareStatement(sql);
    pst.setInt(1, studid);
    return pst.executeQuery();
}
// In the class where 'a' is defined (e.g., SubjectForm or a utility class)
public void newDatabase(int numb) {
    a.connectDB();  // Use your existing connection setup
    String databasename;

    try {
        // Get current year from MySQL server
        ResultSet rs = a.stl.executeQuery("SELECT YEAR(CURDATE()) AS currentYear;");
        rs.next();
        int currentYearFull = rs.getInt("currentYear");
    
// Get last two digits of current year
        int currentYear = currentYearFull % 100;
        int nextYear = (currentYear + 1) % 100;

// Decide database name based on semester number
        switch (numb) {
        default:
        case 0:
            databasename = "1stsemsy" + currentYear + "_" + nextYear;
            break;
        case 1:
            databasename = "2ndsemsy" + currentYear + "_" + nextYear;
            break;
        case 2:
            databasename = "summersy" + currentYear + "_" + nextYear;
            break;
}


        // Create database and switch to it
        a.stl.executeUpdate("CREATE DATABASE IF NOT EXISTS " + databasename + ";");
        a.stl.executeUpdate("USE " + databasename + ";");

        // Create tables
        // ASSIGN TABLE
// 1. STUDENTS TABLE
a.stl.executeUpdate(
    "CREATE TABLE IF NOT EXISTS `students` (" +
    "`studentID` int(11) NOT NULL AUTO_INCREMENT, " +
    "`Name` text DEFAULT NULL, " +
    "`Address` text DEFAULT NULL, " +
    "`Course` text DEFAULT NULL, " +
    "`Email` text DEFAULT NULL, " +
    "`Gender` text DEFAULT NULL, " +
    "`yearLvl` text DEFAULT NULL, " +
    "PRIMARY KEY (`studentID`)" +
    ") ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;"
);

// 2. TEACHERS TABLE
a.stl.executeUpdate(
    "CREATE TABLE IF NOT EXISTS `teachers` (" +
    "`teachID` int(11) NOT NULL AUTO_INCREMENT, " +
    "`teachName` text DEFAULT NULL, " +
    "`Address` text DEFAULT NULL, " +
    "`Contact` text DEFAULT NULL, " +
    "`Email` text DEFAULT NULL, " +
    "`Dept` text DEFAULT NULL, " +
    "`STATUS` text DEFAULT NULL, " +
    "PRIMARY KEY (`teachID`)" +
    ") ENGINE=InnoDB AUTO_INCREMENT=3000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;"
);

// 3. SUBJECTS TABLE
a.stl.executeUpdate(
    "CREATE TABLE IF NOT EXISTS `subjects` (" +
    "`SUBid` int(11) NOT NULL AUTO_INCREMENT, " +
    "`SUBcode` text DEFAULT NULL, " +
    "`SUBdesc` text DEFAULT NULL, " +
    "`SUBUNITS` int(11) DEFAULT NULL, " +
    "`SUBsched` text DEFAULT NULL, " +
    "PRIMARY KEY (`SUBid`)" +
    ") ENGINE=InnoDB AUTO_INCREMENT=2000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;"
);

// 4. ENROLL TABLE
a.stl.executeUpdate(
    "CREATE TABLE IF NOT EXISTS `enroll` (" +
    "`eid` int(11) NOT NULL AUTO_INCREMENT, " +
    "`studid` int(11) NOT NULL, " +
    "`subjid` int(11) NOT NULL, " +
    "PRIMARY KEY (`eid`), " +
    "KEY `studid` (`studid`), " +
    "KEY `subjid` (`subjid`), " +
    "UNIQUE KEY `unique_enroll` (`studid`,`subjid`), " + // prevents duplicate enrollments
    "CONSTRAINT `enroll_ibfk_1` FOREIGN KEY (`studid`) REFERENCES `students` (`studentID`), " +
    "CONSTRAINT `enroll_ibfk_2` FOREIGN KEY (`subjid`) REFERENCES `subjects` (`SUBid`)" +
    ") ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;"
);

// 5. ASSIGN TABLE
a.stl.executeUpdate(
    "CREATE TABLE IF NOT EXISTS `assign` (" +
    "`aid` int(11) NOT NULL AUTO_INCREMENT, " +
    "`tid` int(11) DEFAULT NULL, " +
    "`subjid` int(11) DEFAULT NULL, " +
    "PRIMARY KEY (`aid`), " +
    "UNIQUE KEY `unique_teacher` (`tid`), " +
    "UNIQUE KEY `unique_subject` (`subjid`), " +
    "CONSTRAINT `assign_ibfk_1` FOREIGN KEY (`tid`) REFERENCES `teachers` (`teachID`), " +
    "CONSTRAINT `assign_ibfk_2` FOREIGN KEY (`subjid`) REFERENCES `subjects` (`SUBid`)" +
    ") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;"
);

// 6. GRADES TABLE
a.stl.executeUpdate(
    "CREATE TABLE IF NOT EXISTS `Grades` (" +
    "GradeID INT PRIMARY KEY AUTO_INCREMENT, " +
    "eid INT, " +
    "Prelim TEXT, " +
    "Midterm TEXT, " +
    "Prefinal TEXT, " +
    "Final TEXT, " +
    "UNIQUE KEY `unique_grade` (`eid`), " + // prevents duplicate grading
    "CONSTRAINT `grades_enroll_fk` FOREIGN KEY (`eid`) REFERENCES `enroll`(`eid`) " +
    "ON DELETE CASCADE ON UPDATE CASCADE" +
    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;"
);


// 7. TRANSACTION CHARGES TABLE
a.stl.executeUpdate(
    "CREATE TABLE IF NOT EXISTS `TransactionCharges` (" +
    "TransID INT PRIMARY KEY, " +
    "Department TEXT, " +
    "SubjUnits DECIMAL(10,2), " +
    "Insurance DECIMAL(10,2), " +
    "Computer DECIMAL(10,2), " +
    "Laboratory DECIMAL(10,2), " +
    "Cultural DECIMAL(10,2), " +
    "Library DECIMAL(10,2), " +
    "Facility DECIMAL(10,2)" +
    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;"
);

// 8. INVOICE TABLE
a.stl.executeUpdate(
    "CREATE TABLE IF NOT EXISTS `Invoice` (" +
    "Invoicenum INT PRIMARY KEY, " +
    "studid INT, " +
    "TransID INT" +
    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;"
);
        JOptionPane.showMessageDialog(null, "Database '" + databasename + "' created successfully!");

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error creating database: " + e.getMessage());
        e.printStackTrace();
    }
}


}


