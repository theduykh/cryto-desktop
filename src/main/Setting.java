package main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Setting extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	JCheckBox BTC;
	JCheckBox BCC;
	JCheckBox ETH;
	private JCheckBox XRP;
	private JCheckBox ADA;
	private JCheckBox BTG;
	private JCheckBox ETC;
	private JCheckBox DASH;
	private JCheckBox NEO;
	private JCheckBox LTC;
	private JCheckBox NXT;
	private JCheckBox XMR;
	private JCheckBox ZEC;
	private JCheckBox XVG;
	private JCheckBox OMG;
	private JTextField bot_txt;
	private JLabel lblNewLabel;
	private JTextField group_txt;
	private JLabel lblNewLabel_1;
	private JCheckBox BTC_TOP;
	private JLabel lblNewLabel_2;
	private JLabel lblBtcMarket;
	private JLabel lblSettingBot;
	private JCheckBox exportCSV_checkbox;

	public void open() {
		try {
			Setting dialog = new Setting();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Setting() {
		setModal(true);

		setBounds(100, 100, 651, 593);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 1, 4, 4, 1, 10};
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			lblNewLabel_2 = new JLabel("USDT Market");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 0;
			gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			lblBtcMarket = new JLabel("BTC Market");
			GridBagConstraints gbc_lblBtcMarket = new GridBagConstraints();
			gbc_lblBtcMarket.insets = new Insets(0, 0, 5, 5);
			gbc_lblBtcMarket.gridx = 2;
			gbc_lblBtcMarket.gridy = 0;
			gbc_lblBtcMarket.anchor = GridBagConstraints.WEST;
			contentPanel.add(lblBtcMarket, gbc_lblBtcMarket);
		}
		{
			lblSettingBot = new JLabel("Setting Bot");
			GridBagConstraints gbc_lblSettingBot = new GridBagConstraints();
			gbc_lblSettingBot.insets = new Insets(0, 0, 5, 0);
			gbc_lblSettingBot.gridx = 4;
			gbc_lblSettingBot.gridy = 0;
			contentPanel.add(lblSettingBot, gbc_lblSettingBot);
		}
		{
			BTC = new JCheckBox("BTC/USDT");
			GridBagConstraints gbc_chckbxNewCheckBox_10 = new GridBagConstraints();
			gbc_chckbxNewCheckBox_10.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxNewCheckBox_10.gridx = 1;
			gbc_chckbxNewCheckBox_10.gridy = 1;
			gbc_chckbxNewCheckBox_10.anchor = GridBagConstraints.WEST;
			contentPanel.add(BTC, gbc_chckbxNewCheckBox_10);
			BTC.setSelected(MainScreen.btc_check);
			
		}
		{
			BTC_TOP = new JCheckBox("Top 10 volumn");
			GridBagConstraints gbc_chckbxBtc = new GridBagConstraints();
			gbc_chckbxBtc.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxBtc.gridx = 2;
			gbc_chckbxBtc.gridy = 1;
			gbc_chckbxBtc.anchor = GridBagConstraints.WEST;
			contentPanel.add(BTC_TOP, gbc_chckbxBtc);
			BTC_TOP.setSelected(MainScreen.btc_top_check);
		}
		{
			lblNewLabel = new JLabel("BotToken");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.gridx = 3;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			bot_txt = new JTextField();
			bot_txt.setText(MainScreen.botToken);
			GridBagConstraints gbc_bot_txt = new GridBagConstraints();
			gbc_bot_txt.insets = new Insets(0, 0, 5, 0);
			gbc_bot_txt.fill = GridBagConstraints.HORIZONTAL;
			gbc_bot_txt.gridx = 4;
			gbc_bot_txt.gridy = 1;
			contentPanel.add(bot_txt, gbc_bot_txt);
			bot_txt.setColumns(10);
		}
		{
			BCC = new JCheckBox("BCC/USDT");
			GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
			gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxNewCheckBox.gridx = 1;
			gbc_chckbxNewCheckBox.gridy = 2;
			gbc_chckbxNewCheckBox.anchor = GridBagConstraints.WEST;
			contentPanel.add(BCC, gbc_chckbxNewCheckBox);
			if (MainScreen.bcc_check) {
				BCC.setSelected(true);
			}
		}
		{
			lblNewLabel_1 = new JLabel("ChatID");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.gridx = 3;
			gbc_lblNewLabel_1.gridy = 2;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			group_txt = new JTextField();
			group_txt.setText(MainScreen.chatID.toString());
			GridBagConstraints gbc_group_txt = new GridBagConstraints();
			gbc_group_txt.insets = new Insets(0, 0, 5, 0);
			gbc_group_txt.fill = GridBagConstraints.HORIZONTAL;
			gbc_group_txt.gridx = 4;
			gbc_group_txt.gridy = 2;
			contentPanel.add(group_txt, gbc_group_txt);
			group_txt.setColumns(10);
		}
		{
			ETH = new JCheckBox("ETH/USDT");
			GridBagConstraints gbc_chckbxNewCheckBox_1 = new GridBagConstraints();
			gbc_chckbxNewCheckBox_1.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxNewCheckBox_1.gridx = 1;
			gbc_chckbxNewCheckBox_1.gridy = 3;
			gbc_chckbxNewCheckBox_1.anchor = GridBagConstraints.WEST;
			contentPanel.add(ETH, gbc_chckbxNewCheckBox_1);
			if (MainScreen.eth_check) {
				ETH.setSelected(true);
			}
		}
		{
			XRP = new JCheckBox("XRP/USDT");
			GridBagConstraints gbc_chckbxNewCheckBox_2 = new GridBagConstraints();
			gbc_chckbxNewCheckBox_2.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxNewCheckBox_2.gridx = 1;
			gbc_chckbxNewCheckBox_2.gridy = 4;
			gbc_chckbxNewCheckBox_2.anchor = GridBagConstraints.WEST;
			contentPanel.add(XRP, gbc_chckbxNewCheckBox_2);
			if (MainScreen.xrp_check) {
				XRP.setSelected(true);
			}
		}
		{
			exportCSV_checkbox = new JCheckBox("Export csv");
			GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
			gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 0);
			gbc_chckbxNewCheckBox.gridx = 4;
			gbc_chckbxNewCheckBox.gridy = 4;
			gbc_chckbxNewCheckBox.anchor = GridBagConstraints.WEST;
			contentPanel.add(exportCSV_checkbox, gbc_chckbxNewCheckBox);
			exportCSV_checkbox.setSelected(MainScreen.csv_check);
			exportCSV_checkbox.setVisible(false);
		}
		{
			ADA = new JCheckBox("ADA/USDT");
			GridBagConstraints gbc_chckbxNewCheckBox_3 = new GridBagConstraints();
			gbc_chckbxNewCheckBox_3.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxNewCheckBox_3.gridx = 1;
			gbc_chckbxNewCheckBox_3.gridy = 5;
			gbc_chckbxNewCheckBox_3.anchor = GridBagConstraints.WEST;
			contentPanel.add(ADA, gbc_chckbxNewCheckBox_3);
			if (MainScreen.ada_check) {
				ADA.setSelected(true);
			}
		}
		{
			BTG = new JCheckBox("BTG/USDT");
			GridBagConstraints gbc_chckbxNewCheckBox_4 = new GridBagConstraints();
			gbc_chckbxNewCheckBox_4.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxNewCheckBox_4.gridx = 1;
			gbc_chckbxNewCheckBox_4.gridy = 6;
			gbc_chckbxNewCheckBox_4.anchor = GridBagConstraints.WEST;
			contentPanel.add(BTG, gbc_chckbxNewCheckBox_4);
			if (MainScreen.btg_check) {
				BTG.setSelected(true);
			}
		}
		{
			ETC = new JCheckBox("ETC/USDT");
			GridBagConstraints gbc_chckbxNewCheckBox_5 = new GridBagConstraints();
			gbc_chckbxNewCheckBox_5.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxNewCheckBox_5.gridx = 1;
			gbc_chckbxNewCheckBox_5.gridy = 7;
			gbc_chckbxNewCheckBox_5.anchor = GridBagConstraints.WEST;
			contentPanel.add(ETC, gbc_chckbxNewCheckBox_5);
			if (MainScreen.etc_check) {
				ETC.setSelected(true);
			}
		}
		{
			DASH = new JCheckBox("DASH/USDT");
			GridBagConstraints gbc_chckbxNewCheckBox_6 = new GridBagConstraints();
			gbc_chckbxNewCheckBox_6.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxNewCheckBox_6.gridx = 1;
			gbc_chckbxNewCheckBox_6.gridy = 8;
			gbc_chckbxNewCheckBox_6.anchor = GridBagConstraints.WEST;
			contentPanel.add(DASH, gbc_chckbxNewCheckBox_6);
			if (MainScreen.dash_check) {
				DASH.setSelected(true);
			}
		}
		{
			NEO = new JCheckBox("NEO/USDT");
			NEO.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc_chckbxNewCheckBox_7 = new GridBagConstraints();
			gbc_chckbxNewCheckBox_7.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxNewCheckBox_7.gridx = 1;
			gbc_chckbxNewCheckBox_7.gridy = 9;
			gbc_chckbxNewCheckBox_7.anchor = GridBagConstraints.WEST;
			contentPanel.add(NEO, gbc_chckbxNewCheckBox_7);
			if (MainScreen.neo_check) {
				NEO.setSelected(true);
			}
		}
		{
			LTC = new JCheckBox("LTC/USDT");
			GridBagConstraints gbc_chckbxNewCheckBox_8 = new GridBagConstraints();
			gbc_chckbxNewCheckBox_8.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxNewCheckBox_8.gridx = 1;
			gbc_chckbxNewCheckBox_8.gridy = 10;
			gbc_chckbxNewCheckBox_8.anchor = GridBagConstraints.WEST;
			contentPanel.add(LTC, gbc_chckbxNewCheckBox_8);
			if (MainScreen.ltc_check) {
				LTC.setSelected(true);
			}
		}
		{
			NXT = new JCheckBox("NXT/USDT");
			GridBagConstraints gbc_chckbxNewCheckBox_9 = new GridBagConstraints();
			gbc_chckbxNewCheckBox_9.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxNewCheckBox_9.gridx = 1;
			gbc_chckbxNewCheckBox_9.gridy = 11;
			gbc_chckbxNewCheckBox_9.anchor = GridBagConstraints.WEST;
			contentPanel.add(NXT, gbc_chckbxNewCheckBox_9);
			if (MainScreen.nxt_check) {
				NXT.setSelected(true);
			}
		}
		{
			XMR = new JCheckBox("XMR/USDT");
			GridBagConstraints gbc_chckbxNewCheckBox_11 = new GridBagConstraints();
			gbc_chckbxNewCheckBox_11.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxNewCheckBox_11.gridx = 1;
			gbc_chckbxNewCheckBox_11.gridy = 12;
			gbc_chckbxNewCheckBox_11.anchor = GridBagConstraints.WEST;
			contentPanel.add(XMR, gbc_chckbxNewCheckBox_11);
			if (MainScreen.xmr_check) {
				XMR.setSelected(true);
			}
		}
		{
			ZEC = new JCheckBox("ZEC/USDT");
			GridBagConstraints gbc_chckbxNewCheckBox_12 = new GridBagConstraints();
			gbc_chckbxNewCheckBox_12.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxNewCheckBox_12.gridx = 1;
			gbc_chckbxNewCheckBox_12.gridy = 13;
			gbc_chckbxNewCheckBox_12.anchor = GridBagConstraints.WEST;
			contentPanel.add(ZEC, gbc_chckbxNewCheckBox_12);
			if (MainScreen.zec_check) {
				ZEC.setSelected(true);
			}
		}
		{
			XVG = new JCheckBox("XVG/USDT");
			GridBagConstraints gbc_chckbxNewCheckBox_13 = new GridBagConstraints();
			gbc_chckbxNewCheckBox_13.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxNewCheckBox_13.gridx = 1;
			gbc_chckbxNewCheckBox_13.gridy = 14;
			gbc_chckbxNewCheckBox_13.anchor = GridBagConstraints.WEST;
			contentPanel.add(XVG, gbc_chckbxNewCheckBox_13);
			if (MainScreen.xvg_check) {
				XVG.setSelected(true);
			}
		}
		{
			OMG = new JCheckBox("OMG/USDT");
			GridBagConstraints gbc_chckbxNewCheckBox_14 = new GridBagConstraints();
			gbc_chckbxNewCheckBox_14.insets = new Insets(0, 0, 0, 5);
			gbc_chckbxNewCheckBox_14.gridx = 1;
			gbc_chckbxNewCheckBox_14.gridy = 15;
			gbc_chckbxNewCheckBox_14.anchor = GridBagConstraints.WEST;
			contentPanel.add(OMG, gbc_chckbxNewCheckBox_14);
			if (MainScreen.omg_check) {
				OMG.setSelected(true);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MainScreen.btc_check = BTC.isSelected();
						MainScreen.bcc_check = BCC.isSelected();
						MainScreen.eth_check = ETH.isSelected();
						MainScreen.btg_check = BTG.isSelected();
						MainScreen.dash_check = DASH.isSelected();
						MainScreen.etc_check = ETC.isSelected();
						MainScreen.ltc_check = LTC.isSelected();
						MainScreen.neo_check = NEO.isSelected();
						MainScreen.nxt_check = NXT.isSelected();
						MainScreen.omg_check = OMG.isSelected();
						MainScreen.xmr_check = XMR.isSelected();
						MainScreen.xrp_check = XRP.isSelected();
						MainScreen.xvg_check = XVG.isSelected();
						MainScreen.zec_check = ZEC.isSelected();
						MainScreen.ada_check = ADA.isSelected();
						
						MainScreen.btc_top_check = BTC_TOP.isSelected();
						MainScreen.csv_check = exportCSV_checkbox.isSelected();
						
						MainScreen.botToken = bot_txt.getText().toString();
						MainScreen.chatID = group_txt.getText().toString();
						
						SaveSetting.save(bot_txt.getText().toString(), group_txt.getText().toString());
						Component component = (Component) e.getSource();
						JDialog dialog = (JDialog) SwingUtilities.getRoot(component);
						dialog.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}

		}
	}

}
