import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.concurrent.TimeUnit;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Rectangle;

public class Gui extends JFrame {
	// private JTextField txtBloodLossEstimations;
	private JTextField spongeTextField;
	private JTextField estimationTextField;

	public Gui() {
		//Start of GUI init
		setBounds(new Rectangle(300, 0, 450, 250));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panel_1.setForeground(Color.WHITE);
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new MigLayout("", "[][][][][grow][][][][][][grow]", "[][][][grow][][][][]"));

		JLabel lblSponges = new JLabel("Sponges Processed:");
		lblSponges.setFont(new Font("Century Gothic", Font.PLAIN, 26));
		panel_1.add(lblSponges, "cell 1 0,alignx trailing");

		spongeTextField = new JTextField();	//holds number of sponges analyzed
		spongeTextField.setBackground(Color.RED);
		spongeTextField.setEditable(false);
		spongeTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		spongeTextField.setFont(new Font("Century Gothic", Font.PLAIN, 26));
		spongeTextField.setText("0");
		panel_1.add(spongeTextField, "cell 2 0");
		spongeTextField.setColumns(3);
		spongeTextField.setText(Sponge.getSponges());
		spongeTextField.setText(Sponge.getSponges());

		JLabel lblEstimatedBloodLoss = new JLabel("Estimated Blood Loss:");
		lblEstimatedBloodLoss.setFont(new Font("Century Gothic", Font.PLAIN, 26));
		panel_1.add(lblEstimatedBloodLoss, "cell 1 1,alignx trailing");

		estimationTextField = new JTextField();	//holds estimated blood loss
		estimationTextField.setBackground(Color.RED);
		estimationTextField.setEditable(false);
		estimationTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		estimationTextField.setText("0");
		estimationTextField.setFont(new Font("Century Gothic", Font.PLAIN, 26));
		panel_1.add(estimationTextField, "cell 2 1");
		estimationTextField.setColumns(3);
		estimationTextField.setText(Sponge.getVolume());
		estimationTextField.setText(Sponge.getVolume());

		JLabel lblMl_1 = new JLabel("mL");
		lblMl_1.setFont(new Font("Century Gothic", Font.PLAIN, 26));
		panel_1.add(lblMl_1, "cell 3 1");

		JSeparator separator = new JSeparator();
		separator.setBackground(Color.RED);
		panel_1.add(separator, "cell 5 3");

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.RED);
		getContentPane().add(panel_2, BorderLayout.CENTER);

		JLabel lblBloodBot = new JLabel("Blood Bot");
		panel_2.add(lblBloodBot);
		lblBloodBot.setFont(new Font("Century Gothic", Font.PLAIN, 56));
		this.setVisible(true);
		//end of GUI init
		
		
		//image analysis code
		try {
			Pic pic1 = new Pic("light_blood.png");

			Pic pic2 = new Pic("dark_blood.png");

			Sponge sponge1 = new Sponge(pic1.getSaturation());

			sponge1.addVolume();
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//set field values
			estimationTextField.setText(Sponge.getVolume());
			spongeTextField.setText(Sponge.getSponges());
			Sponge sponge2 = new Sponge(pic2.getSaturation());
			sponge2.addVolume();
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
			}
			//set field values
			estimationTextField.setText(Sponge.getVolume());
			spongeTextField.setText(Sponge.getSponges());
		} catch (Exception e) {

		}

	}

	public static void main(String[] args) {
		new Gui();

	}
}
