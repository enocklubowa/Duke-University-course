package perimeter;

import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
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
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
    	int sum = 0;
    	for(Point currPt : s.getPoints()) {
    		sum++;
    	}
        return sum;
    }

    public double getAverageLength(Shape s) {
        // Put code here
    	
        return getPerimeter(s)/(double)getNumPoints(s);
    }

    public double getLargestSide(Shape s) {
        // Put code here
    	double largest = 0;
    	// Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
        	// Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
        	if(currDist>largest) {
        		largest=currDist;
        	}
            
            prevPt = currPt;
        }
        return largest;
    }

    public double getLargestX(Shape s) {
        double largestX = s.getLastPoint().getX();
    	
        
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            if(currPt.getX()>largestX) {
            	largestX = currPt.getX();
            }
       
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
    	double largestPerimeter = 0;
    	DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
        	FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if(getPerimeter(s)>largestPerimeter) {
            	largestPerimeter=getPerimeter(s);
            }
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
    	double largestPerimeter = 0;
    	String largestFile = "";
    	DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
        	FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if(getPerimeter(s)>largestPerimeter) {
            	largestPerimeter=getPerimeter(s);
            	largestFile = f.getName();
            }
        }
        return largestFile;
    }

    public void testPerimeter () {
    	File file = new File("C:\\Users\\Lubowa\\Eclipse projects\\Duke-University-course\\src\\perimeter\\datatest1.txt");
        FileResource fr = new FileResource(file);
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        System.out.println("number of points = " + getNumPoints(s));
        System.out.println("Average length = " + getAverageLength(s));
        System.out.println("longest length = " + getLargestSide(s));
        System.out.println("Largest X = " + getLargestX(s));
       // System.out.println("Largest perimeter = " + getLargestPerimeterMultipleFiles());
        //System.out.println("File with Largest perimeter = " + getFileWithLargestPerimeter());
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
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
