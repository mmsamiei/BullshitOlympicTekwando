import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AddPlayer extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtname;
	private JTextField txtnationality;
	private JTextField txtoverall;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddPlayer dialog = new AddPlayer();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddPlayer() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNationality = new JLabel("nationality");
			lblNationality.setBounds(73, 91, 117, 16);
			contentPanel.add(lblNationality);
		}
		{
			JLabel lblName = new JLabel("name");
			lblName.setBounds(73, 16, 56, 16);
			contentPanel.add(lblName);
		}
		{
			JLabel lblOverall = new JLabel("overall");
			lblOverall.setBounds(73, 159, 56, 16);
			contentPanel.add(lblOverall);
		}
		{
			txtname = new JTextField();
			txtname.setBounds(171, 13, 116, 22);
			contentPanel.add(txtname);
			txtname.setColumns(10);
		}
		{
			txtnationality = new JTextField();
			txtnationality.setBounds(171, 88, 116, 22);
			contentPanel.add(txtnationality);
			txtnationality.setColumns(10);
		}
		{
			txtoverall = new JTextField();
			txtoverall.setBounds(171, 156, 116, 22);
			contentPanel.add(txtoverall);
			txtoverall.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						MainFrame.createPlayer(txtname.getText().toString(), txtnationality.getText().toString(), Integer.parseInt(txtoverall.getText().toString()));
						dispose();
					}
				});
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						MainFrame.createPlayer(txtname.getText().toString(), txtnationality.getText().toString(), Integer.parseInt(txtoverall.getText().toString()));
						dispose();
					}
				});
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
