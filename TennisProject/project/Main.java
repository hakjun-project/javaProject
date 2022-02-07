package project01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	static TennisCounter count = null;
	static final int NUM = 11;
	static int gameNum=1;
	
	public static void main(String[] args) {
		int key;
		
		do{
			key = selectKey();
			switch (key) {
			case 1:
				set();
				game();
				//games.add(count);
				makeFile();
				winnerTeam();
				break;
			case 2:
				print();
				System.out.println("\t".repeat(NUM)+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
				System.out.println("\t".repeat(NUM)+"┃\t  게 임 종 료\t     ┃");
				System.out.println("\t".repeat(NUM)+"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
				break;
			default:
				break;
			}
			
		}while(key != 2);

	}
	
	public static int randWin() {
		Random rnd = new Random();
		return rnd.nextInt(2) + 1;
	}
	
	public static void game() {
		do {
			count.pointWinner(randWin());
			count.gameWinner(count.whosGameWinner());
			
			count.winner(count.whosSetWinner());
			count.whosWinner();
			print();
			count.dispScoreBoard();
			
			
			System.out.println("\t".repeat(NUM)+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("\t".repeat(NUM)+"┃       엔터를 누르세요.     ┃");
			System.out.println("\t".repeat(NUM)+"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			scanner.nextLine();
			try {System.in.skip(System.in.available());
			} catch (IOException e) {};
		}while(count.win == null);
	}
	
	public static void set() {
		HashMap<String, String[]> teamList = new LinkedHashMap<String, String[]>();
		print();
		System.out.println("\t".repeat(NUM)+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("\t".repeat(NUM)+"┃\t  게 임 시 작\t     ┃");
		System.out.println("\t".repeat(NUM)+"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("\t".repeat(NUM)+"┏━━━━━━━━━━ 세트수 ━━━━━━━━━━┓");
		System.out.println("\t".repeat(NUM)+"┃\t3세트 / 5세트\t     ┃");
		System.out.println("\t".repeat(NUM)+"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println();
		System.out.println("-".repeat(219));
		int gameSetNumber = Integer.parseInt(scanner.nextLine());
		System.out.println("-".repeat(219));
		addMember(teamList, "A팀");
		addMember(teamList, "B팀");
		count = new TennisCounter(new Setting(gameSetNumber, teamList));
	}
	
	public static void addMember(HashMap teamList, String team) {
		System.out.printf("\t".repeat(10)+"%s 선수이름을 입력해주세요\n", team);
		String [] name =  scanner.nextLine().split(" ");
		System.out.println("-".repeat(219));
		teamList.put(team, name);
	}
	
	public static void print() {
		System.out.println("\n".repeat(3));
		System.out.println("\t".repeat(7)+"TTTTTTTTTTTTTT    EEEEEEEEEEEE    NN        NN    NN        NN    IIIIIIII      SSSSS	");
		System.out.println("\t".repeat(7)+"TTTTTTTTTTTTTT    EEEEEEEEEEEE    NNN       NN    NNN       NN    IIIIIIII     SS   SS	");
		System.out.println("\t".repeat(7)+"      TT          EE              NNNN      NN    NNNN      NN       II       SS     SS	");
		System.out.println("\t".repeat(7)+"      TT          EE              NN NN     NN    NN NN     NN       II        SS		");
		System.out.println("\t".repeat(7)+"      TT          EEEEEEEEEEEE    NN  NN    NN    NN  NN    NN       II          SS		");
		System.out.println("\t".repeat(7)+"      TT          EEEEEEEEEEEE    NN   NN   NN    NN   NN   NN       II            SS	");
		System.out.println("\t".repeat(7)+"      TT          EE              NN    NN  NN    NN    NN  NN       II             SS	");
		System.out.println("\t".repeat(7)+"      TT          EE              NN     NN NN    NN     NN NN       II              SS	");
		System.out.println("\t".repeat(7)+"      TT          EE              NN      NNNN    NN      NNNN       II       SS      SS	");
		System.out.println("\t".repeat(7)+"      TT          EEEEEEEEEEEE    NN       NNN    NN       NNN    IIIIIIII     SS    SS	");
		System.out.println("\t".repeat(7)+"      TT          EEEEEEEEEEEE    NN        NN    NN        NN    IIIIIIII      SSSSS	");
		System.out.println("\n".repeat(2));
		try{count.setting.print();} catch(Exception e) {};
	}
	
	public static int selectKey() {
		print();
		//System.out.println("\n".repeat(10));
		System.out.println("\t".repeat(NUM)+"┏━━━━━━━━━━ 번호선택 ━━━━━━━━━━┓");
		System.out.println("\t".repeat(NUM)+"┃\t 1번 : 게임시작\t       ┃");
		System.out.println("\t".repeat(NUM)+"┃\t 2번 : 게임종료\t       ┃");
		System.out.println("\t".repeat(NUM)+"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println();
		System.out.println("-".repeat(219));
		int key = scanner.nextInt();
		scanner.nextLine();
		System.out.println("-".repeat(219));
		return key;
	}
	
	public static void winnerTeam() {
		System.out.println("\t".repeat(NUM)+"┏━━━━━━━━━━━ 승리팀 ━━━━━━━━━━━┓");
		if(count.win.equals("A팀")) {
			System.out.println("\t".repeat(NUM)+"┃             AAAA             ┃");
			System.out.println("\t".repeat(NUM)+"┃            AA  AA            ┃");
			System.out.println("\t".repeat(NUM)+"┃           AA    AA           ┃");
			System.out.println("\t".repeat(NUM)+"┃          AA      AA          ┃");
			System.out.println("\t".repeat(NUM)+"┃         AA        AA         ┃");
			System.out.println("\t".repeat(NUM)+"┃        AAAAAAAAAAAAAA        ┃");
			System.out.println("\t".repeat(NUM)+"┃       AAAAAAAAAAAAAAAA       ┃");
			System.out.println("\t".repeat(NUM)+"┃      AA              AA      ┃");
			System.out.println("\t".repeat(NUM)+"┃     AA                AA     ┃");
			System.out.println("\t".repeat(NUM)+"┃    AA                  AA    ┃");
			System.out.println("\t".repeat(NUM)+"┃   AA                    AA   ┃");
		} else {
			System.out.println("\t".repeat(NUM)+"┃    BBBBBBBBBBBBBBBBBB        ┃");
			System.out.println("\t".repeat(NUM)+"┃    BBBBBBBBBBBBBBBBBBB       ┃");
			System.out.println("\t".repeat(NUM)+"┃    BB                BB      ┃");
			System.out.println("\t".repeat(NUM)+"┃    BB               BB       ┃");
			System.out.println("\t".repeat(NUM)+"┃    BBBBBBBBBBBBBBBBBB        ┃");
			System.out.println("\t".repeat(NUM)+"┃    BBBBBBBBBBBBBBBBBB        ┃");
			System.out.println("\t".repeat(NUM)+"┃    BB              BB        ┃");
			System.out.println("\t".repeat(NUM)+"┃    BB                BB      ┃");
			System.out.println("\t".repeat(NUM)+"┃    BB                 BB     ┃");
			System.out.println("\t".repeat(NUM)+"┃    BBBBBBBBBBBBBBBBBBBB      ┃");
			System.out.println("\t".repeat(NUM)+"┃    BBBBBBBBBBBBBBBBBBB       ┃");
		}
		System.out.println("\t".repeat(NUM)+"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
	
	public static void makeFile(){
		String path = ".\\src\\project01\\";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd(E)");
		String date = sdf.format(new Date());
		path += date + "_" + (gameNum++) + "번째경기" + "_" + count.win + ".txt";
		int gameSetNumber = count.setting.getGameSetNumber();
		try (FileWriter fr = new FileWriter(path); BufferedWriter br = new BufferedWriter(fr)){
			br.write("\t\t" + date + "\n");
			Iterator<Entry<String, String[]>> teamIr = count.setting.getTeam().entrySet().iterator();
			br.write("┏━━━━━┳━━━━ 선수이름 ━━━━━━━━━━━┓");
			while(teamIr.hasNext()) {
				Entry<String, String[]> teamEntry = teamIr.next();
				String[] names = teamEntry.getValue();
				br.write("\n  "+teamEntry.getKey() + " ┃ ");
				for(int i = 0; i < names.length; i++)
					br.write(names[i] + "  ");
			}
			br.write("\n┗━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
			br.write("\t".repeat(gameSetNumber == 5 ? 0 : 1)+"┏━━━━━━" + "━".repeat(gameSetNumber == 5 ? 6 : 0) + " Winner " +  "━".repeat(gameSetNumber == 5 ? 6 : 0)+"━━━━━━┓\n");
			br.write("\t".repeat(gameSetNumber == 5 ? 0 : 1)+"   ");
			for(int i = 1; i <= gameSetNumber; i++)
				br.write(String.format("%d세트 ", i));
			br.write("\n"+"\t".repeat(gameSetNumber == 5 ? 0 : 1)+"   ");
			for(int i = 0; i < count.idx; i++)
				br.write(String.format("  %s   ", count.winnerList[i]));
			br.write("\n"+"\t".repeat(gameSetNumber == 5 ? 0 : 1)+"┗━━━━━━━━━━━━━━━━━━━━"+ "━".repeat(gameSetNumber == 5 ? 12 : 0)+ "┛\n");
			
			br.write("\t┏━━━━━━━━━━━ 승리팀 ━━━━━━━━━━━┓\n");
			if(count.win.equals("A팀")) {
				br.write("\t┃             AAAA             ┃\n");
				br.write("\t┃            AA  AA            ┃\n");
				br.write("\t┃           AA    AA           ┃\n");
				br.write("\t┃          AA      AA          ┃\n");
				br.write("\t┃         AA        AA         ┃\n");
				br.write("\t┃        AAAAAAAAAAAAAA        ┃\n");
				br.write("\t┃       AAAAAAAAAAAAAAAA       ┃\n");
				br.write("\t┃      AA              AA      ┃\n");
				br.write("\t┃     AA                AA     ┃\n");
				br.write("\t┃    AA                  AA    ┃\n");
				br.write("\t┃   AA                    AA   ┃\n");
			} else {
				br.write("\t┃    BBBBBBBBBBBBBBBBBB        ┃\n");
				br.write("\t┃    BBBBBBBBBBBBBBBBBBB       ┃\n");
				br.write("\t┃    BB                BB      ┃\n");
				br.write("\t┃    BB               BB       ┃\n");
				br.write("\t┃    BBBBBBBBBBBBBBBBBB        ┃\n");
				br.write("\t┃    BBBBBBBBBBBBBBBBBB        ┃\n");
				br.write("\t┃    BB              BB        ┃\n");
				br.write("\t┃    BB                BB      ┃\n");
				br.write("\t┃    BB                 BB     ┃\n");
				br.write("\t┃    BBBBBBBBBBBBBBBBBBBB      ┃\n");
				br.write("\t┃    BBBBBBBBBBBBBBBBBBB       ┃\n");
			}
			br.write("\t┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
