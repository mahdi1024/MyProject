import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpeloyeeEntManager {
	private ArrayList<Empeloyee> emp = new ArrayList<Empeloyee>();
	private Empeloyee empeloyee = new Empeloyee();
	private String masage;

	public String getMasage() {
		return masage;
	}

	public ArrayList<Empeloyee> showAllEmpeloyee() {
		try {
			String sql = "SELECT * FROM `empeloyee`";
			ResultSet rs = Connect.stmt.executeQuery(sql);
			int i = 0;
			while (rs.next()) {
				emp.add(new Empeloyee());
				emp.get(i).setId(rs.getInt("idEmpeloyee"));
				emp.get(i).setName(rs.getString("name"));
				emp.get(i).setFamily(rs.getString("family"));
				emp.get(i).setSalary(rs.getInt("salary"));
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			masage = "Error in select all!";
		}
		return emp;
	}

	public int addEmpeloyee(Empeloyee empeloyee) {
		try {
			String sql = "INSERT INTO `empeloyee` (`idEmpeloyee`, `name`, `family`, `salary`) VALUES (NULL, '"
					+ empeloyee.getName()
					+ "', '"
					+ empeloyee.getFamily()
					+ "', '" + +empeloyee.getSalary() + "');";
			Connect.stmt.executeUpdate(sql);
			sql = "SELECT * FROM `empeloyee` where `name` = '"
					+ empeloyee.getName() + "' and `family` = '"
					+ empeloyee.getFamily() + "' and `salary`= '"
					+ empeloyee.getSalary() + "';";
			ResultSet rs = Connect.stmt.executeQuery(sql);
			while (rs.next()) {
				return rs.getInt("idEmpeloyee");
			}
			masage = "done";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			masage = "error";
		}
		return 0;
	}

	public void deleteEmpeloyee(int id) {
		try {
			String sql = "DELETE FROM `empeloyee` WHERE `empeloyee`.`idEmpeloyee` = '"
					+ id + "';";
			Connect.stmt.executeUpdate(sql);
			masage = "done";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			masage = "error";
		}
	}

	public void editEmpeloyee(Empeloyee empeloyee) {
		try {
		String sql = "UPDATE `empeloyee` SET `name` = '" + empeloyee.getName()
				+ "', `family` = '" + empeloyee.getFamily() + "', `salary` = '"
				+ empeloyee.getSalary()
				+ "' WHERE `empeloyee`.`idEmpeloyee` = '" + empeloyee.getId()
				+ "';";
			Connect.stmt.executeUpdate(sql);
			masage = "done";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			masage = "error";
		}
	}
}
