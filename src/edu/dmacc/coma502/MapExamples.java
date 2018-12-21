package edu.dmacc.coma502;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class MapExamples {
	    
	    public List<Map<String, String>> parseFile1(Path csvFile, List<String> columns) {
	    	
	    	try(Scanner scanner = new Scanner(csvFile)) {
	    		List<Map<String, String>> rows = new ArrayList<>();
	    		while(scanner.hasNextLine()) {
					String line = scanner.nextLine();
					String[] partsOfLine = line.split(",");
					Map<String,String> parsedRow = new HashMap<>();
					for(int i = 0; i<columns.size(); i++) {
						String columnName = columns.get(i);
						parsedRow.put(columnName, partsOfLine[i]);;
					}
					rows.add(parsedRow);
	    		}
	    		return rows;
			} catch (IOException e) {
				throw new RuntimeException("Error processing file");
			}
	    }
	    
	    public List<Map<String, String>> parseFile2(Path csvFile, Map<Integer, String> columnsNumberToNameMapping) {
	    	
	    	try(Scanner scanner = new Scanner(csvFile)) {
	    		List<Map<String, String>> rows = new ArrayList<>();
	    		while(scanner.hasNextLine()) {
					String line = scanner.nextLine();
					String[] partsOfLine = line.split(",");
					Map<String,String> parsedRow = new HashMap<>();
					for(Integer index : columnsNumberToNameMapping.keySet()) {
						String columnName = columnsNumberToNameMapping.get(index);
						parsedRow.put(columnName, partsOfLine[index]);;
					}
					rows.add(parsedRow);
	    		}
	    		return rows;
			} catch (IOException e) {
				throw new RuntimeException("Error processing file");
			}
	    }
	    
	    public static void main(String[] args) {
	    	MapExamples collector = new MapExamples();
	    	Path fileReaderPath = Paths.get("recorded-hours.dat");
	    	List<Map<String, String>> rows = collector.parseFile1(fileReaderPath, 
	    			Arrays.asList("employeeId", "hours", "date"));
	    	
	    	List<RecordedHours> recordedHours = new ArrayList<>();
	    	for(Map<String, String> row : rows) {
	    		RecordedHours recordedHour = new RecordedHours(row.get("employeeId"), Double.valueOf(row.get("hours")));
	    		recordedHours.add(recordedHour);
	    	}
	    	
	    	
	    	
//	    	System.out.println(rows);
	    	
	        Map<Integer, String> columnNumbersToNames = new HashMap<>();
	        columnNumbersToNames.put(0, "id");
	        columnNumbersToNames.put(1, "hours");
	        columnNumbersToNames.put(2, "date");
	        System.out.println(collector.parseFile2(Paths.get("recorded-hours.dat"), columnNumbersToNames));
	    }
	
	/* Sample output
	[{date=2018-11-26, hours=8.0, id=E1101}, {date=2018-11-26, hours=7.0, id=E1102}, {date=2018-11-26, hours=8.5, id=E1103}, {date=2018-11-27, hours=8.0, id=E1101}, {date=2018-11-27, hours=7.0, id=E1102}, {date=2018-11-27, hours=8.5, id=E1103}, {date=2018-11-28, hours=8.0, id=E1101}, {date=2018-11-28, hours=7.0, id=E1102}, {date=2018-11-28, hours=8.5, id=E1103}, {date=2018-11-29, hours=8.0, id=E1101}, {date=2018-11-29, hours=7.0, id=E1102}, {date=2018-11-29, hours=8.5, id=E1103}, {date=2018-11-30, hours=8.0, id=E1101}, {date=2018-11-30, hours=7.0, id=E1102}, {date=2018-11-30, hours=8.5, id=E1103}, {date=2018-12-03, hours=8.0, id=E1101}, {date=2018-12-03, hours=7.0, id=E1102}, {date=2018-12-03, hours=8.5, id=E1103}, {date=2018-12-04, hours=8.0, id=E1101}, {date=2018-12-04, hours=7.0, id=E1102}, {date=2018-12-04, hours=8.5, id=E1103}, {date=2018-12-05, hours=8.0, id=E1101}, {date=2018-12-05, hours=7.0, id=E1102}, {date=2018-12-05, hours=8.5, id=E1103}, {date=2018-12-06, hours=8.0, id=E1101}, {date=2018-12-06, hours=7.0, id=E1102}, {date=2018-12-06, hours=8.5, id=E1103}, {date=2018-12-07, hours=8.0, id=E1101}, {date=2018-12-07, hours=7.0, id=E1102}, {date=2018-12-07, hours=8.5, id=E1103}]
	[{date=2018-11-26, hours=8.0, id=E1101}, {date=2018-11-26, hours=7.0, id=E1102}, {date=2018-11-26, hours=8.5, id=E1103}, {date=2018-11-27, hours=8.0, id=E1101}, {date=2018-11-27, hours=7.0, id=E1102}, {date=2018-11-27, hours=8.5, id=E1103}, {date=2018-11-28, hours=8.0, id=E1101}, {date=2018-11-28, hours=7.0, id=E1102}, {date=2018-11-28, hours=8.5, id=E1103}, {date=2018-11-29, hours=8.0, id=E1101}, {date=2018-11-29, hours=7.0, id=E1102}, {date=2018-11-29, hours=8.5, id=E1103}, {date=2018-11-30, hours=8.0, id=E1101}, {date=2018-11-30, hours=7.0, id=E1102}, {date=2018-11-30, hours=8.5, id=E1103}, {date=2018-12-03, hours=8.0, id=E1101}, {date=2018-12-03, hours=7.0, id=E1102}, {date=2018-12-03, hours=8.5, id=E1103}, {date=2018-12-04, hours=8.0, id=E1101}, {date=2018-12-04, hours=7.0, id=E1102}, {date=2018-12-04, hours=8.5, id=E1103}, {date=2018-12-05, hours=8.0, id=E1101}, {date=2018-12-05, hours=7.0, id=E1102}, {date=2018-12-05, hours=8.5, id=E1103}, {date=2018-12-06, hours=8.0, id=E1101}, {date=2018-12-06, hours=7.0, id=E1102}, {date=2018-12-06, hours=8.5, id=E1103}, {date=2018-12-07, hours=8.0, id=E1101}, {date=2018-12-07, hours=7.0, id=E1102}, {date=2018-12-07, hours=8.5, id=E1103}]
	*/
}











