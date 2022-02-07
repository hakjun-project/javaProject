package project01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Setting {
	private int gameSetNumber=0;
	private byte gameWay=0;
	private HashMap<String, String[]> team = new HashMap<>();
	
	public Setting(int gameSetNumber, HashMap<String, String[]> team) {
		this.gameSetNumber = gameSetNumber;
		this.team = team;
		this.gameWay = (byte)team.get("A팀").length;
	}

	public void print() {
		Iterator<Entry<String, String[]>> teamIr = team.entrySet().iterator();
		System.out.println("\t".repeat(11)+"┏━━━━━┳━━━━ 선수이름 ━━━━━━━━━━━┓");
		while(teamIr.hasNext()) {
			Entry<String, String[]> teamEntry = teamIr.next();
			String[] names = teamEntry.getValue();
			System.out.print("\t".repeat(11) + "┃ " + teamEntry.getKey() + " ┃ ");
			for(int i = 0; i < names.length; i++)
				System.out.print(names[i] + "  ");
			System.out.println("\t".repeat(3-names.length) + "┃");
		}
		System.out.println("\t".repeat(11)+"┗━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		
	}
	
	public int getGameSetNumber() { return gameSetNumber; }
	public byte getGameWay() { return gameWay; }
	public HashMap<String, String[]> getTeam() { return team; }
	
	

}
