package project01;

import java.util.ArrayList;

public class OneGame {
	final String [] SCORES = {"0","15","30","40","60","40A"};
	int a = 0, b = 0;
	int count = 0;
	String [] gamePoint = {SCORES[a], SCORES[b]};
	ArrayList<String[]> point = new ArrayList<>();
	
	public void pointWinner(int p) {
		if(( gamePoint[0].equals("40") && gamePoint[0].equals(gamePoint[1])) || count >= 1)	deuce(p);
		else	gamePoint[p-1] = SCORES[(p == 1 ? ++a : ++b)];
		
	}
	
	public int whosGameWinner() {
		boolean aWin = gamePoint[0].equals("60");
		boolean bWin = gamePoint[1].equals("60");
		if( aWin || bWin ) {
			count = 0;
			point.add(gamePoint);
			a = b = 0;
			gamePoint = new String[]{SCORES[a], SCORES[b]};
			if(aWin)	return 1;
			else		return 2;
		}
		return -1;
	}
	
	public void deuce(int p) {
		count++;
		if(!gamePoint[p-1].equals("40A"))	gamePoint[p-1] = SCORES[5];
		else if(gamePoint[0].equals(gamePoint[1]) && gamePoint[0].equals("40A")) {
			gamePoint[2-p] = "40";
			count = 0;
		}
		else	gamePoint[p-1] = SCORES[4];
	}

}
