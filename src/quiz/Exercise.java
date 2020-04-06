package quiz;

import edu.duke.*;
import java.io.File;

public class Exercise {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        //Print largest side
        System.out.println("Largest size is "+getLargestSide(s));
        
      
        System.out.println("Average length is "+getAverageLength(s));
        
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
    	int size = 0;
    	for(Point point:s.getPoints()) {
    		size+=1;
    	}
        return size;
    }

    public double getAverageLength(Shape s) {
  
    	// Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
    	
        return totalPerim/getNumPoints(s);
    }

    public double getLargestSide(Shape s) {
        double largest=0;
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            if(currDist>largest) {
            	largest = currDist;
            }
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        return largest;
    }

    public double getLargestX(Shape s) {
    	int largest = s.getLastPoint().getX();
        for(Point point:s.getPoints()) {
        	if(point.getX()>largest) {
        		largest = point.getX();
        	}
        }
        return largest;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        return 0.0;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource("example3.txt");
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
    	Exercise pr = new Exercise();
        pr.testPerimeter();
      
    }
}
