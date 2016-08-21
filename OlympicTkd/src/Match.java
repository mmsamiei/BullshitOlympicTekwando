import java.util.Vector;


public class Match {
	Player A,B;

	public Match(Player a, Player b) {
		super();
		A = a;
		B = b;
	}
	
	//return Vector of 2 players first is winner 2nd is looser
	public Vector<Player> doMatch(){
		Vector<Player> players= new Vector<>();
		if(A==null){
			players.addElement(B);
			players.addElement(A);
			return players;
		}
		if(B==null){
			players.addElement(A);
			players.addElement(B);
			return players;
		}
		int a = A.overall;
		int b = B.overall;
		int rand = (int) (Math.random()*(a+b));
		
		if(rand<a){
			players.addElement(A);
			players.addElement(B);
			return players;
		}
		else{
			players.addElement(B);
			players.addElement(A);
			return players;
		}
	}
}
