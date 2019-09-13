package listIIII.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import listIIII.model.Student;

public class StudentDAO {

	public void insert(Student student) throws Exception {
		String name = student.getName();
		String email = student.getName();
		String cellPhone = student.getName();
		
		String sql = "INSERT INTO Student (name, email, cellPhone) VALUES (?,?,?)";
		PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
		
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setString(3, cellPhone);
		
		ps.execute();
	}
	
	public Student find(int id) throws Exception {
		String sql = "SELECT * FROM Student WHERE id = ?";
		PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			String name = rs.getString("name");
			String email = rs.getString("email");
			String cellPhone = rs.getString("cellPhone");
			return new Student(id, name, email, cellPhone);
		}
		return null;
	}
	
}
