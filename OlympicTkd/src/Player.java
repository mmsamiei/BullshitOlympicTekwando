import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

public class Player {
	String name;
	String country;
	int overall;
	int goldMedal;
	int silverMedal;
	int bronzeMedal;

	public Player(String name, String country, int overall) {
		super();
		goldMedal = 0;
		silverMedal = 0;
		bronzeMedal = 0;
		this.name = name;
		this.country = country;
		this.overall = overall;
	}

	public boolean isWorther(Player B) {
		if (this.goldMedal > B.goldMedal)
			return true;
		else if (this.goldMedal < B.goldMedal)
			return false;
		else if (this.silverMedal > B.silverMedal)
			return true;
		else if (this.silverMedal < B.silverMedal)
			return false;
		else if (this.bronzeMedal >= B.bronzeMedal)
			return true;
		else
			return false;
	}
	
	public static  void  sort(Vector<Player> players) {
		for(int i=0;i<players.size();i++){
			for(int j=i+1;j<players.size();j++){
				if(players.elementAt(j).isWorther(players.elementAt(i))){
					Collections.swap(players, i, j);
				}
			}
		}
	}

}
