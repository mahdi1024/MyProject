import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class Show extends JDialog {
	private JTable table;
	static String[][] str = new String[EmployeeEntityManager.i][4];;
	

	/**
	 * Launch the application.
	 */
	public static void runShow() {
		try {
			Show dialog = new Show();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setData(int i , int id , String name , String dept , int salary){
		str[i][0] = String.valueOf(id);
		str[i][1] = name;
		str[i][2] = dept;
		str[i][3] = String.valueOf(salary);
	}

	/**
	 * Create the dialog.
	 */
	public Show() {
		setBounds(100, 100, 450, 300);
		{
			table = new JTable();
			DefaultTableModel dtm = new DefaultTableModel(0, 0);
			String header[] = new String[] { "ID", "Name", "Department", "Salary" };
			dtm.setColumnIdentifiers(header);
			table.setModel(dtm);
			dtm.addRow(new Object[] { "ID", "Name", "Department", "Salary"});
			for (int count = 0; count < EmployeeEntityManager.i ; count++) {
				dtm.addRow(new Object[] { str[count][0], str[count][1] , str[count][2], str[count][3]});
			}
			getContentPane().add(table, BorderLayout.CENTER);
		}
	}

}
