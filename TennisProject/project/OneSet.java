package project01;

public class OneSet extends OneGame{
	int [] set = {0, 0};
	//int setNumber = 1;
	
	void gameWinner(int t){
		if(t == 1)	set[0]++;
		else if(t == 2) set[1]++;
	}
	
	public String whosSetWinner() {
		String r = null;
		if( (set[0] > 5 || set[1] > 5) && Math.abs(set[0]-set[1]) >= 2) {
			boolean winner = set[0] > set[1];
			if(winner)	r = "A";
			else		r = "B";
			set[0] = set[1] = 0;
			return r;
		}
		return "";
	}

}
