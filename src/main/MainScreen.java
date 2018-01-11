package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import util.Bot;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Timer;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;

public class MainScreen {
	public static boolean btc_check = true;
	public static boolean bcc_check = true;
	public static boolean eth_check = true;
	public static boolean ada_check = true;
	public static boolean xrp_check = true;
	public static boolean xmr_check = true;
	public static boolean btg_check = true;
	public static boolean dash_check = true;
	public static boolean etc_check = true;
	public static boolean ltc_check = true;
	public static boolean neo_check = true;
	public static boolean zec_check = true;
	public static boolean omg_check = true;
	public static boolean xvg_check = true;
	public static boolean nxt_check = true;
	public static boolean btc_top_check = true;

	public static boolean csv_check = false;

	public static long interval = 60 * 1000;

	public static String botToken = "";
	public static Object chatID = null;

	public static boolean check5m = false;
	public static boolean check15m = false;
	public static boolean check30m = false;
	public static boolean check1h = false;
	public static boolean check3h = false;

	JFrame frmCrytocurrency = new JFrame();
	String result = "";
	JTextArea textArea;
	Thread updateArea;
	JButton startButton;
	JButton btnStop;
	JButton clearBtn;
	private JTextField textField;
	private JLabel lblS;

	Timer timer;
	private JScrollPane scrollPane_1;
	private JTextArea textArea_message;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.frmCrytocurrency.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String[] settings = SaveSetting.load();
		botToken = settings[0];
		chatID = settings[1];

		frmCrytocurrency.setTitle("Crytocurrency");

		frmCrytocurrency.setBounds(100, 100, 1024, 720);
		frmCrytocurrency.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JScrollPane scrollPane = new JScrollPane();

		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmCrytocurrency.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE).addContainerGap())
				.addGroup(groupLayout.createSequentialGroup().addGap(24).addComponent(scrollPane,
						GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE).addGap(30)));
		// JButton btnStop = new JButton("Stop");
		// panel.add(btnStop);

		// JButton btnSetting = new JButton("Setting");
		// panel.add(btnSetting);
		// Font font = new Font("Arial", 0, 20);
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("monospaced", Font.BOLD, 18));

		frmCrytocurrency.getContentPane().setLayout(groupLayout);

		startButton = new JButton("Start");
		startButton.setBounds(312, 13, 97, 25);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (botToken == null || chatID == null || botToken.equals("") || chatID.equals("")) {
					textArea.append("Please input bot token and chat id");
					textArea.append(System.lineSeparator());
					return;
				}
				try {
					int inter = Integer.parseInt(textField.getText().toString());
					if (inter < 1) {
						inter = 1;
					}
					MainScreen.interval = inter * 60 * 1000;
					textField.setEnabled(false);
					startButton.setEnabled(false);
					// updateArea = new Thread(new UpdateAreaText(textArea).setBotToken(botToken));
					// updateArea.start();
					TimerUpdate timerUpdate = new TimerUpdate(textArea).setBotToken(botToken)
							.setChatID(MainScreen.chatID);
					timer = new Timer(true);
					timer.scheduleAtFixedRate(timerUpdate, 0, MainScreen.interval);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		panel.setLayout(null);
		panel.add(startButton);

		clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		clearBtn.setBounds(637, 13, 97, 25);
		panel.add(clearBtn);

		btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// updateArea.interrupt();
				try {
					timer.cancel();
				} catch (Exception e2) {
					// TODO: handle exception

				}
				startButton.setEnabled(true);
				textField.setEnabled(true);
				System.out.println("Stopped.");
			}
		});
		btnStop.setBounds(480, 13, 97, 25);
		panel.add(btnStop);
		Setting setting = new Setting();
		JButton btnSetting = new JButton("Setting");
		btnSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setting.open();
			}
		});
		btnSetting.setBounds(782, 13, 97, 25);
		panel.add(btnSetting);

		textField = new JTextField();
		textField.setBounds(75, 14, 102, 22);
		textField.setText("10");
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Interval");
		lblNewLabel.setBounds(12, 17, 116, 16);
		panel.add(lblNewLabel);

		lblS = new JLabel("m");
		lblS.setBounds(189, 17, 56, 16);
		panel.add(lblS);

		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSend.setEnabled(false);
				if (botToken == null || chatID == null || botToken.equals("") || chatID.equals("")) {
					textArea.append("Please input bot token and chat id");
					textArea.append(System.lineSeparator());
					btnSend.setEnabled(true);
					return;
				}
				if (textArea_message.getText().equals("") || textArea_message.getText() == null) {
					btnSend.setEnabled(true);
					return;
				}
				String message = textArea_message.getText();
				Bot bot = new Bot(botToken);
				bot.sendMessage(chatID, message);
				textArea_message.setText("");
				textArea.append(message + System.lineSeparator());
				btnSend.setEnabled(true);
			}
		});
		btnSend.setBounds(480, 66, 97, 29);
		panel.add(btnSend);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 48, 456, 61);
		panel.add(scrollPane_1);

		textArea_message = new JTextArea();
		scrollPane_1.setViewportView(textArea_message);

		SpinnerNumberModel model1 = new SpinnerNumberModel(10.0, 0.0, 999.0, 1.0);

	}
}
