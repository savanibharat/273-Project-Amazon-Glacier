import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.services.glacier.AmazonGlacierClient;
import com.amazonaws.services.glacier.model.CreateVaultRequest;
import com.amazonaws.services.glacier.model.CreateVaultResult;
import com.amazonaws.services.glacier.transfer.ArchiveTransferManager;
import com.amazonaws.services.glacier.transfer.UploadResult;

public class AmazonGlacierUploadArchive_GettingStarted {
	public static String vaultName = "Projections";
	//public static String archiveToUpload = "D:/getfile.jpeg";
	
	public static AmazonGlacierClient client;

	public static void main(String[] args) throws IOException {
		
		String test="D:/273 Prof. Sithu Aung/Mysql.txt";
//		String[] strobj = test.split("/");
//		String filename = null;
//		for (String string : strobj) {
//		    System.out.println( string);
//		    filename=string;
//		}
//		System.out.println("file name to be uploaded is "+filename);
		//File newfile=new File("D:/273 Prof. Sithu Aung/Mysql.txt");
		
		AWSCredentials credentials = new PropertiesCredentials(AmazonGlacierUploadArchive_GettingStarted.class.getResourceAsStream("AwsCredentials.properties"));
		
		client = new AmazonGlacierClient(credentials);
		client.setEndpoint("https://glacier.us-west-1.amazonaws.com/");
		//client.setEndpoint("https://glacier.us-west-1.amazonaws.com/");

		CreateVaultRequest request = new CreateVaultRequest().withVaultName(vaultName);
		CreateVaultResult result = client.createVault(request);
		
		if(result!=null)
		System.out.println("Created vault successfully: " + result.getLocation());		
		
		try {
			ArchiveTransferManager atm = new ArchiveTransferManager(client,credentials);
			System.out.println("in try");
						
			UploadResult result1 = atm.upload(vaultName, test,new File(test));
			System.out.println(result1);
			System.out.println("Archive ID: " + result1.getArchiveId());	
		} 
		catch (Exception e) {
			System.out.println("in catch");
			System.err.println(e);
		}
		
		
		
	}
}