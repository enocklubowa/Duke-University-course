package csv;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.FileResource;

public class Csv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Csv csv = new Csv();
		csv.tester();

	}
	
	private void tester() {
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		//System.out.println(countryInfo(parser, "Nauru"));
		//listExportersTwoProducts(parser,"cotton","flowers");
		//System.out.println(numberOfExporters(parser,"cocoa"));
		bigExporters(parser, "$999,999,999,999");
		
	}
	
	private String countryInfo(CSVParser parser, String country) {
		for(CSVRecord record:parser) {
			if(record.get("Country").equals(country)) {
				return country+": "+record.get("Exports")+": "+record.get("Value (dollars)");
			}
		}
		return "NOT FOUND";
	}
	
	private void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
		for(CSVRecord record:parser) {
			if(record.get("Exports").contains(exportItem1) && record.get("Exports").contains(exportItem2)) {
				System.out.println(record.get("Country"));
				
			}
		}
		
	}
	
	private int numberOfExporters(CSVParser parser, String exportItem) {
		int total = 0;
		for(CSVRecord record:parser) {
			if(record.get("Exports").contains(exportItem)) {
				total++;
			}
		}
		return total;
	}
	
	private void bigExporters(CSVParser parser, String amount) {
		for(CSVRecord record:parser) {
			if(record.get("Value (dollars)").length()>amount.length()) {
				System.out.println(record.get("Country"));
			}
		}
	}

}
