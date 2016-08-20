
public class Match {
	Player A,B;

	public Match(Player a, Player b) {
		super();
		A = a;
		B = b;
	}
	
	public Player doMatch(){
		if(A==null)
			return B;
		if(B==null)
			return A;
		int a = A.overall;
		int b = B.overall;
		int rand = (int) (Math.random()*(a+b));
		
		if(rand<a){
			return A;
		}
		else{
			return B;
		}
	}
}
