
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class StudentSQL {

	private static Connection getConnection(){
		Connection con = null;
		try {
            Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletDB", "root", "");
		} catch (ClassNotFoundException| SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static int save(Student stu){
		int s = 0;
		Connection con  = getConnection();
		String sql = "INSERT INTO student_info(name, password, email, country) VALUES (?,?,?,?);";

	
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, stu.getName());
			ps.setString(2, stu.getPassword());
			ps.setString(3, stu.getEmail());
			ps.setString(4, stu.getCountry());
			
			s = ps.executeUpdate();
			
	
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return s;
	}
	
	public static int update(Student stu){
		int s = 0;
		Connection con  = StudentSQL.getConnection();
		String sql = "UPDATE `student_info` SET `name`=?,`password`=?,`email`=?,`country`=? WHERE `id`=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, stu.getName());
			ps.setString(2, stu.getPassword());
			ps.setString(3, stu.getEmail());
			ps.setString(4, stu.getCountry());
			ps.setInt(5, stu.getId());

			s = ps.executeUpdate();
			
	
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return s;
	}
	
	public static int delete(int stuId){
		int s = 0;
		Connection con  = StudentSQL.getConnection();
		String sql = "DELETE FROM `student_info` WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, stuId);

			s = ps.executeUpdate();
			
	
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return s;
	}
	
	public static Student getStudentById(int stuId){
	Student st = new Student();
		Connection con  = StudentSQL.getConnection();
		String sql = "SELECT * FROM `student_info` WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, stuId);
			ResultSet resultSet = ps.executeQuery();
			
			if(resultSet.next()){
				st.setId(resultSet.getInt(1));
				st.setName(resultSet.getString(2));
				st.setPassword(resultSet.getString(3));
				st.setEmail(resultSet.getString(4));
				st.setCountry(resultSet.getString(5));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return st;
	}
	
	public static List<Student> getStudents(){
		List<Student> sts = new ArrayList<>();
			Connection con  = StudentSQL.getConnection();
			String sql = "SELECT * FROM `student_info`";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				
		
				ResultSet resultSet = ps.executeQuery();
				
				while(resultSet.next()){
					Student st = new Student();
					st.setId(resultSet.getInt(1));
					st.setName(resultSet.getString(2));
					st.setPassword(resultSet.getString(3));
					st.setEmail(resultSet.getString(4));
					st.setCountry(resultSet.getString(5));
					sts.add(st);
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			return sts;
		}
	
}
