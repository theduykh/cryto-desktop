package util;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import java.awt.Font;

public class TestDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TestDialog dialog = new TestDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TestDialog() {
		setBounds(100, 100, 621, 432);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JCheckBox chckbxNewCheckBox = new JCheckBox("5 minutes");
			chckbxNewCheckBox.setSelected(true);
			chckbxNewCheckBox.setBounds(32, 25, 113, 25);
			contentPanel.add(chckbxNewCheckBox);
		}
		{
			JSpinner spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(new Integer(200), null, null, new Integer(1)));
			spinner.setBounds(197, 26, 119, 22);
			contentPanel.add(spinner);
		}
		{
			JCheckBox chckbxNewCheckBox_1 = new JCheckBox("15 minutes");
			chckbxNewCheckBox_1.setBounds(32, 87, 113, 25);
			contentPanel.add(chckbxNewCheckBox_1);
		}
		{
			JSpinner spinner = new JSpinner();
			spinner.setEnabled(false);
			spinner.setModel(new SpinnerNumberModel(new Integer(400), null, null, new Integer(1)));
			spinner.setBounds(197, 88, 119, 22);
			contentPanel.add(spinner);
		}
		{
			JCheckBox chckbxNewCheckBox_2 = new JCheckBox("30 minutes");
			chckbxNewCheckBox_2.setSelected(true);
			chckbxNewCheckBox_2.setBounds(32, 153, 113, 25);
			contentPanel.add(chckbxNewCheckBox_2);
		}
		{
			JSpinner spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(new Integer(500), null, null, new Integer(1)));
			spinner.setBounds(197, 154, 119, 22);
			contentPanel.add(spinner);
		}
		{
			JCheckBox chckbxNewCheckBox_3 = new JCheckBox("1 hour");
			chckbxNewCheckBox_3.setSelected(true);
			chckbxNewCheckBox_3.setBounds(32, 218, 113, 25);
			contentPanel.add(chckbxNewCheckBox_3);
		}
		{
			JSpinner spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(new Integer(1000), null, null, new Integer(1)));
			spinner.setBounds(197, 219, 119, 22);
			contentPanel.add(spinner);
		}
		{
			JLabel label = new JLabel("$");
			label.setFont(new Font("Tahoma", Font.PLAIN, 16));
			label.setBounds(328, 26, 43, 21);
			contentPanel.add(label);
		}
		{
			JLabel lblNewLabel = new JLabel("$");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(328, 91, 56, 16);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("$");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(328, 157, 56, 16);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("$");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_2.setBounds(328, 222, 56, 16);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
