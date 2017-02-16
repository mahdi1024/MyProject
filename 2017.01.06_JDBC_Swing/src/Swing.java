import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Swing extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextField textFieldName;
	private JTextField textFieldDept;
	private JTextField textFieldSalary;

	static int id;
	private String errorId;
	static String name;
	private String errorName;
	static String dept;
	private String errorDept;
	static int salary;
	private String errorSalary;

	private static Swing frame;

	public int getId() {
		return id;
	}

	public void run() {
		new Connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Swing();
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
	public Swing() {

		setTitle("Employee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblId = new JLabel("ID", SwingConstants.CENTER);
		lblId.setBounds(10, 10, 65, 20);
		contentPane.add(lblId);

		JLabel lblName = new JLabel("Name", SwingConstants.CENTER);
		lblName.setBounds(10, 40, 65, 20);
		contentPane.add(lblName);

		JLabel lblDepartment = new JLabel("Department", SwingConstants.CENTER);
		lblDepartment.setBounds(10, 70, 80, 20);
		contentPane.add(lblDepartment);

		JLabel lblSalary = new JLabel("Salary", SwingConstants.CENTER);
		lblSalary.setBounds(10, 100, 65, 20);
		contentPane.add(lblSalary);

		JLabel lblErrorId = new JLabel("");
		lblErrorId.setBounds(210, 10, 201, 20);
		contentPane.add(lblErrorId);

		textFieldId = new JTextField();
		textFieldId.setBounds(100, 10, 100, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		textFieldId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent a) {
				try {
					if (!textFieldId.getText().isEmpty()) {
						id = Integer.parseInt(textFieldId.getText());
						errorId = textFieldId.getText();
					} else {
						errorId = "Nothing!";
					}
				} catch (Exception e) {
					errorId = "Id incorent!";
				}
				lblErrorId.setText(errorId);
			}
		});

		textFieldName = new JTextField();
		textFieldName.setBounds(100, 40, 100, 20);
		textFieldName.setColumns(10);
		contentPane.add(textFieldName);

		JLabel lblErrorName = new JLabel("");
		textFieldName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent a) {
				try {
					if (textFieldName.getText().isEmpty()) {
						errorName = "Nothing...";
					}
					name = textFieldName.getText();
					for (int j = 0; j < name.length(); j++) {
						boolean b = Character.isLetter(name.charAt(j));
						if (b) {
							errorName = name;
						} else if (name.substring(j, j + 1).equals(" ")
								&& j > 0) {
							errorName = name;
							if (name.substring(j + 1, j + 2).equals(" ")) {
								errorName = "Name incrent!";
							}

						} else {
							errorName = "Name incrent!";
						}
					}
				} catch (Exception e1) {
					errorName = "Name incrent!";
				}
				lblErrorName.setText(errorName);
			}
		});
		lblErrorName.setBounds(210, 40, 201, 20);
		contentPane.add(lblErrorName);

		textFieldDept = new JTextField();
		textFieldDept.setBounds(100, 70, 100, 20);
		textFieldDept.setColumns(10);
		contentPane.add(textFieldDept);

		JLabel lblErrorDept = new JLabel("");
		textFieldDept.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent a) {
				try {
					if (textFieldDept.getText().isEmpty()) {
						errorDept = "Nothing...";
					}
					dept = textFieldDept.getText();
					for (int j = 0; j < dept.length(); j++) {
						boolean b = Character.isLetter(dept.charAt(j));
						if (b) {
							errorDept = dept;
						} else if (dept.substring(j, j + 1).equals(" ")
								&& j > 0) {
							errorDept = dept;
							if (dept.substring(j + 1, j + 2).equals(" ")) {
								errorDept = "Department incrent!";
							}

						} else {
							errorDept = "Department incrent!";
						}
					}
				} catch (Exception e1) {
					errorDept = "Department incrent!";
				}
				lblErrorDept.setText(errorDept);
			}
		});
		lblErrorDept.setBounds(210, 70, 201, 20);
		contentPane.add(lblErrorDept);

		textFieldSalary = new JTextField();
		textFieldSalary.setBounds(100, 100, 100, 20);
		textFieldSalary.setColumns(10);
		contentPane.add(textFieldSalary);

		JLabel lblErrorSalary = new JLabel("");
		textFieldSalary.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent a) {
				try {
					if (!textFieldSalary.getText().isEmpty()) {
						salary = Integer.parseInt(textFieldSalary.getText());
						errorSalary = textFieldSalary.getText();
					} else {
						errorSalary = "Nothing!";
					}
				} catch (Exception e) {
					errorSalary = "Salary incorent!";
				}
				lblErrorSalary.setText(errorSalary);
			}
		});

		lblErrorSalary.setBounds(210, 100, 201, 20);
		contentPane.add(lblErrorSalary);

		JLabel lblAddBtn = new JLabel("", SwingConstants.RIGHT);
		lblAddBtn.setBounds(163, 153, 162, 14);
		contentPane.add(lblAddBtn);

		JLabel lblDeleteBtn = new JLabel("", SwingConstants.RIGHT);
		lblDeleteBtn.setBounds(163, 210, 162, 14);
		contentPane.add(lblDeleteBtn);

		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(10, 236, 415, 14);
		contentPane.add(lblStatus);
		lblStatus.setText(Connect.status);

		JButton btnAddButton = new JButton("Add");
		btnAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					lblAddBtn.setText("");
					lblDeleteBtn.setText("");
					if (!textFieldId.getText().isEmpty()
							&& !textFieldName.getText().isEmpty()
							&& !textFieldDept.getText().isEmpty()
							&& !textFieldSalary.getText().isEmpty()) {
						id = Integer.parseInt(textFieldId.getText());
						name = textFieldName.getText();
						dept = textFieldDept.getText();
						salary = Integer.parseInt(textFieldSalary.getText());
						EmployeeEntityManager empEM = new EmployeeEntityManager();
						empEM.addEmployee();
						if (empEM.getError().equals("")) {
							lblAddBtn.setText("Add is done.");
						} else {
							lblAddBtn.setText(empEM.getError());
						}
					} else {
						lblAddBtn.setText("Format incorent!");
					}
				} catch (Exception e) {
					lblAddBtn.setText("Add failed.");
				}
			}
		});
		btnAddButton.setBounds(335, 150, 90, 20);
		contentPane.add(btnAddButton);

		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				try {
					lblAddBtn.setText("");
					lblDeleteBtn.setText("");
					if (!textFieldId.getText().isEmpty()) {
						id = Integer.parseInt(textFieldId.getText());
						EmployeeEntityManager empEM = new EmployeeEntityManager();
						empEM.select();
						textFieldName.setText(EmployeeEntityManager.emp[0]
								.getName());
						textFieldDept.setText(EmployeeEntityManager.emp[0]
								.getDept());
						textFieldSalary.setText(String
								.valueOf(EmployeeEntityManager.emp[0]
										.getSalary()));
						EmployeeEntityManager.i = 0;
					} else {
						id = 0;
						EmployeeEntityManager empEM = new EmployeeEntityManager();
						empEM.select();
						// System.out.println(empEM.emp[0].getName());
						// Show.i = EmployeeEntityManager.emp.length;
						for (int j = 0; j < EmployeeEntityManager.i; j++) {
							Show.setData(j,
									EmployeeEntityManager.emp[j].getId(),
									EmployeeEntityManager.emp[j].getName(),
									EmployeeEntityManager.emp[j].getDept(),
									EmployeeEntityManager.emp[j].getSalary());
						}
						// System.out.println("1");
						Show.runShow();
						// frame.dispose();
						dispatchEvent(new WindowEvent(null,
								WindowEvent.WINDOW_CLOSING));
						EmployeeEntityManager.i = 0;
					}
				} catch (Exception e) {
					errorId = "id incorent!";
					// System.out.println("error");
				}
			}
		});
		btnShow.setBounds(335, 180, 90, 20);
		contentPane.add(btnShow);

		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					lblAddBtn.setText("");
					lblDeleteBtn.setText("");
					if (!textFieldId.getText().isEmpty()) {
						id = Integer.parseInt(textFieldId.getText());
						EmployeeEntityManager empEM = new EmployeeEntityManager();
						empEM.deletRecord();
						lblDeleteBtn.setText("Delete is done.");
					} else {
						lblDeleteBtn.setText("Removal failed.");
					}
				} catch (Exception e) {
					lblDeleteBtn.setText("Removal failed.");
				}
			}
		});
		btnNewButton_2.setBounds(335, 210, 90, 20);
		contentPane.add(btnNewButton_2);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Connect.disconnect();
			}
		});

	}
}
