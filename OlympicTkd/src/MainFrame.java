import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class MainFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	JButton btnRunTournament;
	static Vector<Player> players;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAddPlayer = new JButton("add player");
		btnAddPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddPlayer().show();
			}
		});
		btnAddPlayer.setBounds(12, 13, 143, 25);
		contentPane.add(btnAddPlayer);

		btnRunTournament = new JButton("run tournament");
		btnRunTournament.setBounds(12, 65, 143, 25);
		btnRunTournament.addActionListener(this);
		contentPane.add(btnRunTournament);
		
		JButton btnGoldMedal = new JButton("gold Medal");
		btnGoldMedal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("آمار مدال های طلا ");
				for (int i = 0; i < players.size(); i++) {
					try {
						System.out.println(players.elementAt(i).name+"  "+players.elementAt(i).GoldMedal);
					} catch (Exception e1) {
						System.out.println("null");
					}
				}
				System.out.println("_____________");
			}
		});
		btnGoldMedal.setBounds(12, 121, 143, 25);
		contentPane.add(btnGoldMedal);

		players = new Vector<Player>();
	}

	public static void createPlayer(String name, String nationality, int overall) {
		Player p = new Player(name, nationality, overall);
		players.addElement(p);
		System.out.println(players.elementAt(players.size() - 1).overall);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRunTournament) {
			Vector<Player> temp = players;
			normalizePlayers(temp);
			temp = Randomize(temp);
			System.out.println("آغاز دور جدید");
			for (int i = 0; i < temp.size(); i++) {
				try {
					System.out.println(temp.elementAt(i).name+"  "+temp.elementAt(i).overall);
				} catch (Exception e1) {
					System.out.println("null");
				}
			}
			while (temp.size() != 1) {
				normalizePlayers(temp);
				temp = doStage(temp);
				System.out.println("ــــــــــــــــــــ");
				for (int i = 0; i < temp.size(); i++) {
					try {
						System.out.println(temp.elementAt(i).name+"  "+temp.elementAt(i).overall);
					} catch (Exception e1) {
						System.out.println("null");
					}
				}
			}
			temp.elementAt(0).overall+=1;
			temp.elementAt(0).GoldMedal+=1;
			System.out.println("\nfinish \n");
		}
	}

//	public void normalizePlayers() {
//		int i = 1;
//		while (i < players.size())
//			i = i * 2;
//		int j = i - players.size();
//		for (int k = 0; k < j; k++) {
//			players.addElement(null);
//		}
//	}
	
	public void normalizePlayers(Vector<Player> temp) {
		int i = 1;
		while (i < temp.size())
			i = i * 2;
		int j = i - temp.size();
		for (int k = 0; k < j; k++) {
			temp.addElement(null);
		}
	}

	public Vector<Player> doStage(Vector<Player> vecplayer) {
		int size = vecplayer.size();
		Vector<Player> result = new Vector<>();
		if (size == 1) {
			result.addElement(vecplayer.elementAt(0));
			return result;
		}
		for (int i = 0; i < size; i += 2) {
			Match match = new Match(vecplayer.elementAt(i),
					vecplayer.elementAt(i + 1));
			result.addElement(match.doMatch());
		}
		return result;
	}
	
	public Vector<Player> Randomize(Vector<Player> temp) {
		Player[] array = new Player[temp.size()];
		for(int i=0;i<temp.size();i++){
			array[i]=null;
		}
		for(int i=0;i<temp.size();i++){
			int r = (int) (Math.random()*temp.size());
			while(true){
				if(array[r]==null){
					array[r]=temp.elementAt(i);
					break;
				}
				else
					r++;
				if(r>=temp.size())
					r=0;
			}
		}
		Vector<Player> result=  new Vector<>();
		for(int i=0;i<array.length;i++)
			result.addElement(array[i]);
		return result;		
	}
}
