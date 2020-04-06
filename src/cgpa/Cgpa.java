package cgpa;

import java.util.HashMap;

public class Cgpa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(){
			{
				put(66, 4);
				put(83, 4);
				put(89, 4);
				put(64, 3);
				put(72, 4);
				put(85,4);
				put(62,4);
				put(75,4);
				put(77,4);
				put(90,3);
				put(60,5);
				put(61,5);
				put(78,4);
				put(76,4);
				put(80,4);
				put(77,3);
				put(60,3);
				put(66,3);
				put(78,3);
				put(74,4);
				put(81,4);
				put(75,3);
				put(89,5);
				put(84,3);
				put(86,3);
				put(76,4);
				put(84,3);
				
				//project
				put(75,5);
				
				put(82,4);
				put(82,4);
				put(80,3);
				put(80,3);
				put(75,5);
				
				
			}
		};
		double grade_sum=0;
		double grade = 0;
		double cu_sum =0;
		double cgpa=0;
		for(Integer i:map.keySet()) {
			if(i>=80) {
				grade = 5*map.get(i);
			}
			else if(i>=75) {
				grade = 4.5*map.get(i);
			}
			else if(i>=70) {
				grade = 4*map.get(i);
			}
			else if(i>=65) {
				grade = 3.5*map.get(i);
			}
			else if(i>=60) {
				grade = 3.0*map.get(i);
			}
			grade_sum=grade_sum+grade;
			cu_sum=cu_sum+map.get(i);

		}
		cgpa = grade_sum/cu_sum;
		System.out.println(cgpa);
	
	}

}
