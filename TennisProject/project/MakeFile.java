package project01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class MakeFile {
	
	String path = ".\\src\\project\\";
	public void makeFile(int i, String winner){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String date = 
		path += sdf.format(new Date()) + "_" + i + "번째경기" + "_" + winner + ".txt";
		try (FileWriter fr = new FileWriter(path); BufferedWriter br = new BufferedWriter(fr)){
			br.write(winner);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
