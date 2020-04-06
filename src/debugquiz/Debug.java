package debugquiz;

public class Debug {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Debug.test();
	}
	
	public static void findAbc(String input){
	       int index = input.indexOf("abc");
	       while (true){
	           if (index == -1 || index >= input.length() - 3){
	               break;
	           }
	           System.out.println("Index is "+index);
	           String found = input.substring(index+1, index+4);
	           
	           System.out.println(found);
	           index = input.indexOf("abc",index+3);
	           System.out.println("index after updating " + index);
	       }
	   }
	
	   public static void test() {
		   //findAbc("abcd");
		   findAbc("abcabcabcabca");

//“kdabcabcjei”


//“ttabcesoeiabco”


//“abcbabccabcd”


//“qwertyabcuioabcp”


//“abcabcabcabca”



	}

}
