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
	public static String vaultName = "ExampleVaultAtGlacier";
	public static String archiveToUpload = "D:/example1.zip";
	public static AmazonGlacierClient client;

	public static void main(String[] args) throws IOException {
		AWSCredentials credentials = new PropertiesCredentials(AmazonGlacierUploadArchive_GettingStarted.class.getResourceAsStream("AwsCredentials.properties"));
		
		client = new AmazonGlacierClient(credentials);
		client.setEndpoint("glacier.us-west-1.amazonaws.com");
		


		//CreateVaultRequest request = new CreateVaultRequest().withVaultName(vaultName);
		//CreateVaultResult result = client.createVault(request);
		

		//if(result!=null)
		//System.out.println("Created vault successfully: " + result.getLocation());
		
		
		try {
			ArchiveTransferManager atm = new ArchiveTransferManager(client,credentials);
			System.out.println("in try");
			String archiveId = atm.upload(vaultName, "Example1", new File(archiveToUpload)).getArchiveId();
			System.out.println("after upload");
			System.out.println(archiveId);
			
			//UploadResult result1 = atm.upload(vaultName, archiveToUpload,
				//	new File(archiveToUpload));
			//System.out.println("Archive ID: " + result1.getArchiveId());
		} 
		catch (Exception e) {
			System.out.println("in catch");
			System.err.println(e);
		}
	}
}