package edu.dmacc.coma502;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FixedPositionFileParser {
	public List<Map<String, String>> parseFile3(Path csvFile, Map<String, Segment> columnNameToSegmentMapping)  {
    	try(Scanner scanner = new Scanner(csvFile)) {
    		List<Map<String, String>> rows = new ArrayList<>();
    		while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				Map<String,String> parsedRow = new HashMap<>();
				for(String columnName : columnNameToSegmentMapping.keySet()) {
					Segment columnPosition = columnNameToSegmentMapping.get(columnName);
					parsedRow.put(columnName, line.substring(columnPosition.start, columnPosition.start + columnPosition.length));;
				}
				rows.add(parsedRow);
    		}
    		return rows;
		} catch (IOException e) {
			throw new RuntimeException("Error processing file");
		}
	}

	
	public static void main(String[] args) {
		Path csvFile = Paths.get("recorded-hours.dat");
		FixedPositionFileParser collector = new FixedPositionFileParser();
		Map<String, Segment> columnNameToValuePosition = new HashMap<>();
		columnNameToValuePosition.put("id", new Segment(0,5));
		columnNameToValuePosition.put("hours", new Segment(6,3));
		columnNameToValuePosition.put("date", new Segment(10,10));
		System.out.println(collector.parseFile3(csvFile, columnNameToValuePosition));
		
	}
}

class Segment {
	public final int start;
	public final int length;
	
	Segment(int start, int length) {
		this.start = start;
		this.length = length;
	}
}
