package edu.dmacc.coma502;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExamples {
	    
	    public List<Map<String, String>> parseFile1(Path csvFile, List<String> columns) {
	        throw new UnsupportedOperationException("needs implemented");
	    }
	    
	    public List<Map<String, String>> parseFile2(Path csvFile, Map<Integer, String> columnsNumberToNameMapping) {
	        throw new UnsupportedOperationException("needs implemented");
	    }
	    
	    public static void main(String[] args) {
	    	MapExamples collector = new MapExamples();
	        
	        System.out.println(collector.parseFile1(Paths.get("recorded-hours.dat"), Arrays.asList("id","hours", "date")));
	        
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
