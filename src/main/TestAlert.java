package main;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import PeriodBittrex.AutoUpdatePeriod;

import java.awt.event.ActionListener;
import java.util.Timer;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TestAlert {

	private JFrame frame;
	private JTextField textField_15m;
	private JTextField textField_30m;
	private JTextField textField_1hour;

	public static boolean MUOILAM = false;
	public static boolean BAMUOI = false;
	public static boolean MOTTIENG = false;
	public static boolean BATIENG = false;

	public static double dif_muoilam = 0;
	public static double dif_bamuoi = 0;
	public static double dif_mottieng = 0;
	public static double dif_batieng = 0;

	public static JTextArea textArea;
	Timer timer;
	private JTextField textField_3hours;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestAlert window = new TestAlert();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestAlert() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 883, 693);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JCheckBox checkBox_1hour = new JCheckBox("1 hour");
		JCheckBox checkBox_30m = new JCheckBox("30 minutes");
		JCheckBox checkBox_15m = new JCheckBox("15 minutes");
		JCheckBox checkBox_3hours = new JCheckBox("3 hours");

		JScrollPane scrollPane = new JScrollPane();

		textArea = new JTextArea();
		textArea.setFont(new Font("monospaced", Font.BOLD, 18));
		scrollPane.setViewportView(textArea);

		JPanel panel = new JPanel();

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Start");
				timer = new Timer(true);
				btnStart.setEnabled(false);
				BAMUOI = checkBox_30m.isSelected();
				if (BAMUOI) {
					dif_bamuoi = Double.parseDouble(textField_30m.getText());
				}
				MUOILAM = checkBox_15m.isSelected();
				if (MUOILAM) {
					dif_muoilam = Double.parseDouble(textField_15m.getText());
				}
				MOTTIENG = checkBox_1hour.isSelected();
				if (MOTTIENG) {
					dif_mottieng = Double.parseDouble(textField_1hour.getText());
				}
				BATIENG = checkBox_3hours.isSelected();
				if (BATIENG) {
					dif_batieng = Double.parseDouble(textField_3hours.getText());
				}
				AutoUpdatePeriod update = new AutoUpdatePeriod();
				timer.scheduleAtFixedRate(update, 0, 20000);
			}
		});

		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.cancel();
				btnStart.setEnabled(true);
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);

		checkBox_15m.setBounds(18, 30, 113, 25);
		panel_1.add(checkBox_15m);

		checkBox_30m.setBounds(18, 80, 113, 25);
		panel_1.add(checkBox_30m);

		checkBox_1hour.setBounds(18, 130, 113, 25);
		panel_1.add(checkBox_1hour);
		
		textField_15m = new JTextField();
		textField_15m.setText("100");
		textField_15m.setBounds(169, 32, 116, 22);
		panel_1.add(textField_15m);
		textField_15m.setColumns(10);

		textField_30m = new JTextField();
		textField_30m.setText("200");
		textField_30m.setBounds(169, 81, 116, 22);
		panel_1.add(textField_30m);
		textField_30m.setColumns(10);

		textField_1hour = new JTextField();
		textField_1hour.setText("300");
		textField_1hour.setBounds(169, 131, 116, 22);
		panel_1.add(textField_1hour);
		textField_1hour.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE).addGap(107))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE))
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(13)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE).addGap(132))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE).addGap(18)))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE).addContainerGap()));

		
		checkBox_3hours.setBounds(18, 180, 113, 25);
		panel_1.add(checkBox_3hours);

		textField_3hours = new JTextField();
		textField_3hours.setText("1000");
		textField_3hours.setBounds(169, 181, 116, 22);
		panel_1.add(textField_3hours);
		textField_3hours.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(31)
						.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE).addGap(71)
						.addComponent(btnStop, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE).addGap(30)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(36).addGroup(gl_panel
						.createParallelGroup(Alignment.BASELINE).addComponent(btnStart).addComponent(btnStop))));
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
