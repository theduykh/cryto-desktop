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

public class TestAlert {

	private JFrame frame;
	private JTextField textField_15m;
	private JTextField textField_30m;
	private JTextField textField_1hour;

	public static boolean MUOILAM = false;
	public static boolean BAMUOI = false;
	public static boolean MOTTIENG = false;

	public static double dif_muoilam = 0;
	public static double dif_bamuoi = 0;
	public static double dif_mottieng = 0;

	public static JTextArea textArea;
	Timer timer;

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
		frame.setBounds(100, 100, 832, 657);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JCheckBox checkBox_1hour = new JCheckBox("1 hour");
		JCheckBox checkBox_30m = new JCheckBox("30 minutes");
		JCheckBox checkBox_15m = new JCheckBox("15 minutes");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 260, 790, 337);
		frame.getContentPane().add(scrollPane);

		textArea = new JTextArea();
		textArea.setFont(new Font("monospaced", Font.BOLD, 18));
		scrollPane.setViewportView(textArea);

		JPanel panel = new JPanel();
		panel.setBounds(420, 13, 403, 115);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

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
				AutoUpdatePeriod update = new AutoUpdatePeriod();
				timer.scheduleAtFixedRate(update, 0, 20000);
			}
		});
		btnStart.setBounds(111, 36, 97, 25);
		panel.add(btnStart);

		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.cancel();
				btnStart.setEnabled(true);
			}
		});
		btnStop.setBounds(220, 36, 97, 25);
		panel.add(btnStop);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 13, 396, 215);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		checkBox_15m.setBounds(18, 31, 113, 25);
		panel_1.add(checkBox_15m);

		checkBox_30m.setBounds(18, 93, 113, 25);
		panel_1.add(checkBox_30m);

		checkBox_1hour.setBounds(18, 162, 113, 25);
		panel_1.add(checkBox_1hour);

		textField_15m = new JTextField();
		textField_15m.setText("100");
		textField_15m.setBounds(169, 32, 116, 22);
		panel_1.add(textField_15m);
		textField_15m.setColumns(10);

		textField_30m = new JTextField();
		textField_30m.setText("200");
		textField_30m.setBounds(169, 94, 116, 22);
		panel_1.add(textField_30m);
		textField_30m.setColumns(10);

		textField_1hour = new JTextField();
		textField_1hour.setText("300");
		textField_1hour.setBounds(169, 163, 116, 22);
		panel_1.add(textField_1hour);
		textField_1hour.setColumns(10);
	}
}
