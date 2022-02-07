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
		System.out.println("\t".repeat(gameSetNumber == 5 ? 8 : 9)+"     ┏━━━━━━" + "━".repeat(gameSetNumber == 5 ? 6 : 0) + " Winner " +  "━".repeat(gameSetNumber == 5 ? 6 : 0)+"━━━━━━┓");
		System.out.print("\t".repeat(gameSetNumber == 5 ? 8 : 9)+"        ");
		for(int i = 1; i <= gameSetNumber; i++)
				System.out.printf("%d세트 ", i);
		System.out.print("\n"+"\t".repeat(gameSetNumber == 5 ? 8 : 9)+"        ");
		for(int i = 0; i < idx; i++)
			System.out.printf("  %s   ", winnerList[i]);
		System.out.println("\n"+"\t".repeat(gameSetNumber == 5 ? 8 : 9)+"     ┗━━━━━━━━━━━━━━━━━━━━"+ "━".repeat(gameSetNumber == 5 ? 12 : 0)+ "┛");
		System.out.println();
	}
	
	public void dispScoreBoard() {
		int i = 0;
		printWinner();
		System.out.println("\t".repeat(7)+"   ┏━━━━━┳━━━━━━┳━━━━━━━━━━━ SCORE ━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.print("\t".repeat(7) + "   ┃     ┃ 승수 ┃");
		int size = point.size();
		for(i = (size-3) > 0 ? size-3 : 1 ; i <= size+1; i++)
			System.out.printf("%2d게임  ",i);
		System.out.println( (4-size<=0) ? " ┃":" ".repeat(33-8*(i-2))+ "┃");
		System.out.println("\t".repeat(7)+"   ┣━━━━━╋━━━━━━╋━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
		System.out.print("\t".repeat(7) + "   ┃ A팀 ┃");
		System.out.printf(" %3d  ┃",set[0]);
		for(i = (size-4) > 0 ? size-4 : 0 ; i < size; i++)
			System.out.printf(" %3s    ",point.get(i)[0]);
		System.out.printf(" %3s    ",gamePoint[0]);
		System.out.println( (4-size<=0) ? " ┃":" ".repeat(17-8*(i-2))+ "┃");
		System.out.print("\t".repeat(7) + "   ┃ B팀 ┃");
		System.out.printf(" %3d  ┃",set[1]);
		for(i = (size-4) > 0 ? size-4 : 0 ; i < size; i++)
			System.out.printf(" %3s    ",point.get(i)[1]);
		System.out.printf(" %3s    ",gamePoint[1]);
		System.out.println( (4-size<=0) ? " ┃":" ".repeat(17-8*(i-2))+ "┃");
		System.out.println("\t".repeat(7)+"   ┗━━━━━┻━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("\n".repeat(4));
		
		
	}
	

}
