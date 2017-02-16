import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Table extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ArrayList<Empeloyee> emp = new ArrayList<Empeloyee>();
	private EmpeloyeeEntManager eem = new EmpeloyeeEntManager();
	static Table frame;
	private String status = "";
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void runTable() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Table();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Table() {
		emp = eem.showAllEmpeloyee();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblStatus = new JLabel("status");
		lblStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus.setBounds(290, 0, 100, 20);
		contentPane.add(lblStatus);
		
		table = new JTable();
		@SuppressWarnings("serial")
		DefaultTableModel dtm = new DefaultTableModel(emp.size(), 6) {
			boolean[] columnEditables = new boolean[] { false, true, true,
					true, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		String header[] = new String[] { "ID", "Name", "Department", "Salary",
				"", "" };
		dtm.setColumnIdentifiers(header);
		for (int i = 0; i < emp.size(); i++) {
			dtm.setValueAt(emp.get(i).getId(), i, 0);
			dtm.setValueAt(emp.get(i).getName(), i, 1);
			dtm.setValueAt(emp.get(i).getFamily(), i, 2);
			dtm.setValueAt(emp.get(i).getSalary(), i, 3);
			dtm.setValueAt("delete", i, 4);
			dtm.setValueAt("edit", i, 5);
		}
		dtm.addRow(new Object[] { "", "", "", "", "add", status });
		table.setModel(dtm);
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(30);
		table.getColumnModel().getColumn(5).setPreferredWidth(30);
		table.setBounds(0, 0, 400, 260);
		contentPane.add(table);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int row = table.getSelectedRow();
					if (table.getValueAt(table.getSelectedRow(),
							table.getSelectedColumn()).equals("delete")) {
						int id = (int) table.getValueAt(table.getSelectedRow(),
								0);
						eem.deleteEmpeloyee(id);
						dtm.removeRow(row);
						status = eem.getMasage();
						lblStatus.setText(status);
					} else if (table.getValueAt(table.getSelectedRow(),
							table.getSelectedColumn()).equals("add")) {
						int i = table.getSelectedRow();
						String name = (String) table.getValueAt(i, 1);
						String family = (String) table.getValueAt(i, 2);
						String salary = (String) table.getValueAt(i, 3);
						if (!name.isEmpty() && !family.isEmpty()
								&& !salary.isEmpty()) {
							Empeloyee empeloyee = new Empeloyee();
							empeloyee.setName(name);
							empeloyee.setFamily(family);
							empeloyee.setSalary(Integer.parseInt(salary));
							empeloyee.setId(eem.addEmpeloyee(empeloyee));
							status = eem.getMasage();
							if (empeloyee.getId() != 0) {
								dtm.setValueAt(empeloyee.getId(), i, 0);
								dtm.setValueAt("delete", i, 4);
								dtm.setValueAt("edit", i, 5);
								status = "done";
								dtm.addRow(new Object[] { "", "", "", "",
										"add", status });
							}
							lblStatus.setText(status);
						}
					}else if (table.getValueAt(table.getSelectedRow(),table.getSelectedColumn()).equals("edit")){
						Empeloyee empeloyee = new Empeloyee();
						int id = (int) table.getValueAt(table.getSelectedRow(), 0);
						String name = (String) table.getValueAt(table.getSelectedRow(), 1);
						String family = (String) table.getValueAt(table.getSelectedRow(), 2);
						String s = (String) table.getValueAt(table.getSelectedRow(), 3);
						int salary = Integer.parseInt(s);
						empeloyee.setId(id);
						empeloyee.setName(name);
						empeloyee.setFamily(family);
						empeloyee.setSalary(salary);
						eem.editEmpeloyee(empeloyee);
						status = eem.getMasage();
						lblStatus.setText(status);
					}
				}
			}
		});
		

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(table.getBounds());
		contentPane.add(scrollPane);

	}
}
