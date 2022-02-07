package project01;

public class TennisCounter extends OneSet{
	Setting setting = null;
	int gameSetNumber;
	
	String [] winnerList = null;
	int idx = 0;
	String win = null;
	int winCount;
	int count = 0;
	
	
	public TennisCounter(Setting setting) {
		this.setting = setting;
		gameSetNumber = setting.getGameSetNumber();
		
		winnerList = new String[gameSetNumber];
		winCount = ((int) gameSetNumber/2) + 1;
	}
	
	void winner(String win) {
		if(!win.equals("")) {
			winnerList[idx++] = win;
			set[0] = set[1] = 0;
		}
	}
	
	void whosWinner() {
		int i = 0;
		int aCount = 0;
		int bCount = 0;
		while(i < winnerList.length && winnerList[i] != null ) {
			if(winnerList[i].equals("A"))	aCount++;
			else							bCount++;
			i++;
		}
		if(aCount >= winCount)		win = "A팀";
		else if(bCount >= winCount)	win = "B팀";
	}
	
	void printWinner() {
		System.out.println("\t".repeat(gameSetNumber == 5 ? 11 : 12)+"┏━━━━━━" + "━".repeat(gameSetNumber == 5 ? 6 : 0) + " Winner " +  "━".repeat(gameSetNumber == 5 ? 6 : 0)+"━━━━━━┓");
		System.out.print("\t".repeat(gameSetNumber == 5 ? 11 : 12)+"   ");
		for(int i = 1; i <= gameSetNumber; i++)
				System.out.printf("%d세트 ", i);
		System.out.print("\n"+"\t".repeat(gameSetNumber == 5 ? 11 : 12)+"   ");
		for(int i = 0; i < idx; i++)
			System.out.printf("  %s   ", winnerList[i]);
		System.out.println("\n"+"\t".repeat(gameSetNumber == 5 ? 11 : 12)+"┗━━━━━━━━━━━━━━━━━━━━"+ "━".repeat(gameSetNumber == 5 ? 12 : 0)+ "┛");
		System.out.println();
	}
	
	public void dispScoreBoard() {
		printWinner();
		System.out.println("\t".repeat(10)+"┏━━━━━┳━━━━━━┳━━━━━━━━━━━ SCORE ━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.print("\t".repeat(10) + "┃     ┃ 승수 ┃ ");
		int size = point.size();
		for(int i = (size-3) > 0 ? size-3 : 1 ; i <= size+1; i++)
			System.out.printf("%2d게임  ",i);
		System.out.println( "      ".repeat( (4-size<=0) ? 0 : 4-size)+ "┃");
		System.out.println("\t".repeat(10)+"┣━━━━━╋━━━━━━╋━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
		System.out.print("\t".repeat(10) + "┃ A팀 ┃");
		System.out.printf(" %3d  ┃",set[0]);
		for(int i = (size-4) > 0 ? size-4 : 0 ; i < size; i++)
			System.out.printf(" %5s  ",point.get(i)[0]);
		System.out.printf(" %5s  ",gamePoint[0]);
		System.out.println(" ┃");
		System.out.print("\t".repeat(10) + "┃ B팀 ┃");
		System.out.printf(" %3d  ┃",set[1]);
		for(int i = (size-4) > 0 ? size-4 : 0 ; i < size; i++)
			System.out.printf(" %5s  ",point.get(i)[1]);
		System.out.printf(" %5s  ",gamePoint[1]);
		System.out.println(" ┃");
		System.out.println("\t".repeat(10)+"┗━━━━━┻━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("\n".repeat(10));
		
		
	}
	

}
