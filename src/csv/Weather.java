package csv;

import java.io.File;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class Weather {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Weather weather= new Weather();
		//weather.testColdestHourInFile();
		System.out.println(weather.fileWithColdestTemperature());;
	}
	
	private CSVRecord coldestHourInFile(CSVParser parser) {
		CSVRecord coldest = null;
		for(CSVRecord record:parser) {
			if(coldest==null) {
				coldest=record;
			}
			else {
				if(Double.parseDouble(record.get("TemperatureF"))<Double.parseDouble(coldest.get("TemperatureF")) && 
						Double.parseDouble(record.get("TemperatureF")) != -9999) {
					coldest = record;
				}
			}
		}
		return coldest;
	}
	
	private void testColdestHourInFile() {
		File f = new File("/home/lubowa/eclipse-workspace/Duke course/src/nc_weather/2014/weather-2014-07-22.csv");
		FileResource file = new FileResource(f);
		CSVParser parser = file.getCSVParser();
		System.out.println(coldestHourInFile(parser));
		//System.out.println(lowestHumidityInFile(parser));
	}
	
	private String fileWithColdestTemperature() {
		String coldestFile = null;
		DirectoryResource directoryResource = new DirectoryResource();
		CSVParser coldest_parser_so_far = null;
		CSVRecord coldest_record_so_far = null;
		for(File f:directoryResource.selectedFiles()) {
			FileResource resource = new FileResource(f);
			CSVParser parser = resource.getCSVParser();
			if(coldestFile==null) {
				coldestFile=f.getName();
				coldest_parser_so_far=parser;
				
			}
			else {
				for(CSVRecord record:parser) {
					if(coldest_record_so_far==null) {
						coldest_record_so_far=record;
						coldestFile=f.getName();
					}
					else {
						if(Double.parseDouble(record.get("TemperatureF"))<Double.parseDouble(coldest_record_so_far.get("TemperatureF")) && 
								Double.parseDouble(record.get("TemperatureF")) != -9999) {
							coldest_record_so_far = record;
							coldestFile=f.getName();
						}
					}
				}
			}
		}
		return coldest_record_so_far.get("TemperatureF");
	}
	
	private CSVRecord lowestHumidityInFile(CSVParser parser) {
		CSVRecord lowest_sofar=null;
		for(CSVRecord record:parser) {
			if(lowest_sofar==null) {
				lowest_sofar=record;
			}
			else {
				if(!record.get("Humidity").equals("N/A")) {
					if(Double.parseDouble(record.get("Humidity"))<Double.parseDouble(lowest_sofar.get("Humidity"))) {
						lowest_sofar = record;
					}
				}
				
			}
		}
		return lowest_sofar;
	}
	
	private CSVRecord fileWithLowestHumidy() {
		String coldestFile = null;
		DirectoryResource directoryResource = new DirectoryResource();
		CSVParser coldest_parser_so_far = null;
		CSVRecord coldest_record_so_far = null;
		for(File f:directoryResource.selectedFiles()) {
			FileResource resource = new FileResource(f);
			CSVParser parser = resource.getCSVParser();
			if(coldestFile==null) {
				coldestFile=f.getName();
				coldest_parser_so_far=parser;
				
			}
			else {
				for(CSVRecord record:parser) {
					if(coldest_record_so_far==null) {
						coldest_record_so_far=record;
						coldestFile=f.getName();
					}
					else {
						if(!record.get("Humidity").equals("N/A")) {
							if(Double.parseDouble(record.get("Humidity"))<Double.parseDouble(coldest_record_so_far.get("Humidity"))) {
								coldest_record_so_far = record;
								coldestFile=f.getName();
							}
						}
						
					}
				}
			}
		}
		return coldest_record_so_far;
	}

}
