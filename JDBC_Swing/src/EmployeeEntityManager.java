import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeEntityManager {
	static int i ;
	static Employee[] emp = new Employee[10];
	private ResultSet rs;
	static String error = "";
	
	public String getError(){
		return error;
	}
	
	public void deletRecord() {
		try {
			int id = Swing.id;
			String sql = "DELETE FROM employee " + "WHERE id = " + id ;
			System.out.println("delete record complete.");
			Connect.stmt.executeUpdate(sql);
						
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {

		}// end try
	}
	
	public void addEmployee() {
		try {
			error = "" ;
			// STEP 4: Execute a query
//			System.out.println("Inserting records into the table...");
//			stmt = c.conn.createStatement();
			int salary = Swing.salary;
			String name = Swing.name;
			String dept = Swing.dept;
			int id = Swing.id;
			String sql = "INSERT INTO employee (`id`, `name`, `dept` ,`salary`) "
					+ "VALUES ('" + id + "' , '" + name + "' , '" + dept + "' , '" + salary + "')";
			Connect.stmt.executeUpdate(sql);
			System.out.println("Inserted records into the table...");

		} catch (SQLException se) {
			
			// Handle errors for JDBC
		//	se.printStackTrace();
			error = "Add failed.";
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
//			try {
//				if (c.stmt != null)
//					c.conn.close();
//			} catch (SQLException se) {
//			}// do nothing
//			try {
//				if (c.conn != null)
//					c.conn.close();
//			} catch (SQLException se) {
//				se.printStackTrace();
//			}// end finally try
		}// end try
	}
	
	public void select() {
		try {
			int id = Swing.id;
//			System.out.println(id);
			String sql;
			String strId;
			if (id != 0){
				strId = "id = " + id;
			}else {
				strId = "1";
			}
			sql = "SELECT * FROM employee where " + strId + " ;";
			rs = Connect.stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			System.out.printf("%-4s%-15s%-10s%-12s\n", "id", "name", "dept",
					"salary");
			for (int i = 0; i < 40; i++) {
				System.out.print("-");
			}
			System.out.println();
			while (rs.next()) {
				// Retrieve by column name
				emp[i] = new Employee();
				emp[i].setId(rs.getInt("id"));
				emp[i].setName(rs.getString("name"));
//				System.out.println(emp[i].getName());
				emp[i].setDept(rs.getString("dept"));
				emp[i].setSalary(rs.getInt("salary"));
				i++;
//				System.out.printf("%-4d%-15s%-10s%-12d\n", id, name, dept, salary);
//				System.out.println("ali");
			}
			// STEP 6: Clean-up environment
//			rs.close();
//			Connect.stmt.close();
//			Connect.conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			
		}// end try
	}// end main

}
