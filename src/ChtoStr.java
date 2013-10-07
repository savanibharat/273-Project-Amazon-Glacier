
public class ChtoStr {

	public static void main(String[] args) {
	
		String test="D:/dropwizard-helloworld/bin/dev.sh";
		String[] strobj = test.split("/");
		String filename = null;
		for (String string : strobj) {
		    System.out.println( string);
		    filename=string;
		}
		System.out.println("file name to be uploaded is "+filename);
		
		
	}
	
}
