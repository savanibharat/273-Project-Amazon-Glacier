import java.io.IOException;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.glacier.AmazonGlacierClient;
import com.amazonaws.services.glacier.model.DescribeVaultRequest;
import com.amazonaws.services.glacier.model.DescribeVaultResult;

public class DescriveVaultOutput {
	public static void main(String[] args) throws IOException {

		AmazonGlacierClient client = null;
		
		AWSCredentials credentials = new PropertiesCredentials(AmazonGlacierUploadArchive_GettingStarted.class.getResourceAsStream("AwsCredentials.properties"));

		client = new AmazonGlacierClient(credentials);
		client.setEndpoint("https://glacier.us-west-1.amazonaws.com/");

		DescribeVaultRequest request = new DescribeVaultRequest()
				.withVaultName("ExampleVaultAtGlacier");
		DescribeVaultResult result = client.describeVault(request);
		System.out.print("\nCreationDate: " + result.getCreationDate()
				+ "\nLastInventoryDate: " + result.getLastInventoryDate()
				+ "\nNumberOfArchives: " + result.getNumberOfArchives()
				+ "\nSizeInBytes: " + result.getSizeInBytes() + "\nVaultARN: "
				+ result.getVaultARN() + "\nVaultName: "
				+ result.getVaultName());
	}
}