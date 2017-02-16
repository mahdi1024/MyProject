import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class Window extends JFrame {

	private JPanel contentPane;
	private int decisec = 0;
	private int secend = 0;
	private int min = 0;
	private boolean runnig = false;

	/**
	 * Launch the application.
	 */
	public static void runWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
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
	public Window() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTimer = new JLabel(String.format("%02d : %02d : %02d", min,
				secend, decisec));
		lblTimer.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimer.setBackground(Color.WHITE);
		lblTimer.setBounds(75, 40, 200, 30);
		contentPane.add(lblTimer);

		JButton btnStart = new JButton("Start");
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Thread timer = new Thread() {
					public void run() {
						while (runnig) {
							decisec++;
							if (decisec == 100) {
								decisec = 0;
								secend++;
							}
							if (secend == 60) {
								secend = 0;
								min++;
							}
							lblTimer.setText(String.format(
									"%02d : %02d : %02d", min, secend, decisec));
							try {
								sleep(10);
							} catch (InterruptedException ex) {
							}
						}
					}
				};
				timer.start();
				runnig = true;
			}

		});
		btnStart.setBounds(45, 85, 80, 25);
		contentPane.add(btnStart);

		JButton btnStop = new JButton("Stop");
		btnStop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				runnig = false;
			}
		});
		btnStop.setBounds(135, 85, 80, 25);
		contentPane.add(btnStop);

		JButton btnReset = new JButton("Reset");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				runnig = false;
				min = decisec = secend = 0;
				lblTimer.setText(String.format("%02d : %02d : %02d", min,
						secend, decisec));
			}
		});
		btnReset.setBounds(225, 85, 75, 25);
		contentPane.add(btnReset);

	}
}
