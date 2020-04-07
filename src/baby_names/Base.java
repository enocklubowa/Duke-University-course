package baby_names;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class Base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String fileName = "C:\\Users\\Lubowa\\Eclipse projects\\Duke-University-course\\src\\baby_names\\us_babynames_by_year\\yob"+1905+".csv";
		//FileResource resource = new FileResource(fileName);
		//CSVParser parser = resource.getCSVParser(false);
		//totalBirths(parser);
		//System.out.println(getRank(1971, "Frank", "M"));
		//System.out.println(getName(1982, 450, "M"));
		//System.out.println(yearOfHighestRank("Genevieve","F"));
		System.out.println(getAverageRank("Susan","F"));
		//System.out.println(getTotalBirthsRankedHigher(1990, "Drew", "M"));
		//whatIsNameInYear("Susan", 1972, 2014, "F");
	}
	
	private static void totalBirths(CSVParser parser) {
		int totalBirths = 0;
		int totalGirls = 0;
		int totalBoys = 0;
		for(CSVRecord record:parser) {
			totalBirths++;
			if(record.get(1).equals("F")) {
				totalGirls++;
			}
			if(record.get(1).equals("M")) {
				totalBoys++;
			}
		}
		System.out.println("Total births are "+totalBirths);
		System.out.println("Total girls are "+totalGirls);
		System.out.println("Total boys are "+totalBoys);
	}
	
	private static int getRank(int year, String name, String gender) {
		String fileName = "C:\\Users\\Lubowa\\Eclipse projects\\Duke-University-course\\src\\baby_names\\us_babynames_by_year\\yob"+year+".csv";
		//String fileName = "C:\\Users\\Lubowa\\Eclipse projects\\Duke-University-course\\src\\baby_names\\us_babynames_test\\yob2012short.csv";
		int rank = 0;
		File file = new File(fileName);
		FileResource resource = new FileResource(file);
		List<String> girls = new ArrayList<String>();
		List<String> boys = new ArrayList<String>();
		for(CSVRecord record:resource.getCSVParser(false)) {
			//System.out.println(record.get(1));
			if(record.get(1).equals("F")) {
				girls.add(record.get(0));
			}
			if(record.get(1).equals("M")) {
				boys.add(record.get(0));
			}
		}
		
		
        int counter = 0;
        
        if(gender.equals("M")) {
        	for(String s:boys) {
        		if(s.equals(name)) {
        			return counter+1;
        		}
        		counter++;
        	}
        }
        
        else if(gender.equals("F")) {
        	for(String s:girls) {
        		if(s.equals(name)) {
        			return counter+1;
        		}
        		counter++;
        	}
        }
        
        
        return -1;
	}
	
	private static int getRank(String name, String gender, FileResource resource) {
		//String fileName = "C:\\Users\\Lubowa\\Eclipse projects\\Duke-University-course\\src\\baby_names\\us_babynames_test\\yob"+year+"short.csv";
		//String fileName = "C:\\Users\\Lubowa\\Eclipse projects\\Duke-University-course\\src\\baby_names\\us_babynames_test\\yob2012short.csv";
		int rank = 0;
		List<String> girls = new ArrayList<String>();
		List<String> boys = new ArrayList<String>();
		for(CSVRecord record:resource.getCSVParser(false)) {
			if(record.get(1).equals("F")) {
				girls.add(record.get(0));
			}
			if(record.get(1).equals("M")) {
				boys.add(record.get(0));
			}
		}
		
		
        int counter = 0;
        
        if(gender.equals("M")) {
        	for(String s:boys) {
        		if(s.equals(name)) {
        			return counter+1;
        		}
        		counter++;
        	}
        }
        
        else if(gender.equals("F")) {
        	for(String s:girls) {
        		if(s.equals(name)) {
        			return counter+1;
        		}
        		counter++;
        	}
        }
        
        
        return -1;
	}
	
	
	
	private static String getName(int year, int rank, String gender) {
		String baby = "";
		String fileName = "C:\\Users\\Lubowa\\Eclipse projects\\Duke-University-course\\src\\baby_names\\us_babynames_by_year\\yob"+year+".csv";
		//String fileName = "C:\\Users\\Lubowa\\Eclipse projects\\Duke-University-course\\src\\baby_names\\us_babynames_test\\yob2012short.csv";
		File file = new File(fileName);
		FileResource resource = new FileResource(file);
		List<String> girls = new ArrayList<String>();
		List<String> boys = new ArrayList<String>();
		for(CSVRecord record:resource.getCSVParser(false)) {
			if(record.get(1).equals("F")) {
				girls.add(record.get(0));
			}
			if(record.get(1).equals("M")) {
				boys.add(record.get(0));
			}
		}
		
		if(gender.equals("F")) {
			if(rank<=girls.size()) {
				if(girls.get(rank-1) != null) {
					baby = girls.get(rank-1);
					return baby;
				}
			}
					
		}
		else if(gender.equals("M")) {
			if(rank<=boys.size()) {
				if(boys.get(rank-1) != null) {
					baby = boys.get(rank-1);
					return baby;
				}
			}
			
		}
		return "NO NAME";
		
	}
	
	private static void whatIsNameInYear(String name, int year, int newYear, String gender) {
		String newName = getName(newYear,getRank(year,name,gender),gender);
		if(gender.equals("F")) {
			System.out.println(name+" born in "+year+" would be "+newName+" if she was born in "+newYear);

		}
		else if(gender.equals("M")) {
			System.out.println(name+" born in "+year+" would be "+newName+" if he was born in "+newYear);

		}
	}
	
	private static String yearOfHighestRank(String name, String gender){
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		DirectoryResource directoryResource = new DirectoryResource();
		for(File file:directoryResource.selectedFiles()) {
			FileResource resource = new FileResource(file);
			if(getRank(name, gender, resource)>0) {
				map.put(getRank(name, gender, resource), file.getName());
			}
		}
		
		
		if(map.size()>0) {
			TreeMap<Integer, String> tree = new TreeMap<Integer, String>();
			tree.putAll(map);
			System.out.println(map);
			return tree.firstEntry().getValue();
		}
		return "-1";
	}
	
	private static double getAverageRank(String name, String gender) {
		List<Double> list = new ArrayList<Double>();
		DirectoryResource directoryResource = new DirectoryResource();
		for(File file:directoryResource.selectedFiles()) {
			FileResource resource = new FileResource(file);
			if(getRank(name, gender, resource)>0) {
				list.add(Double.valueOf(getRank(name, gender, resource)));
			}
		}
		
		if(list.size()>0) {
			return list.stream().mapToDouble(val -> val).average().orElse(0.0);
		}
		
		return 0.0;
	}
	
	private static int getTotalBirthsRankedHigher(int year, String name, String gender) {
		String fileName = "C:\\Users\\Lubowa\\Eclipse projects\\Duke-University-course\\src\\baby_names\\us_babynames_by_year\\yob"+year+".csv";
		//String fileName = "C:\\Users\\Lubowa\\Eclipse projects\\Duke-University-course\\src\\baby_names\\us_babynames_test\\yob2012short.csv";
		int rank = getRank(year, name, gender);
		File file = new File(fileName);
		FileResource resource = new FileResource(file);
		List<Integer> girls = new ArrayList<Integer>();
		List<Integer> boys = new ArrayList<Integer>();
		for(CSVRecord record:resource.getCSVParser(false)) {
			if(record.get(1).equals("F")) {
				girls.add(Integer.parseInt(record.get(2)));
			}
			if(record.get(1).equals("M")) {
				boys.add(Integer.parseInt(record.get(2)));
			}
		}
		
		
		int sum = 0;
		if(gender.equals("F")) {
			for(int i=0;i<rank-1;i++) {
				sum= sum+girls.get(i);
			}
			return sum;
		}
		if(gender.equals("M")) {
			for(int i=0;i<rank-1;i++) {
				sum= sum+boys.get(i);
			}
			return sum;
		}
		
		return 0;
	}

}
