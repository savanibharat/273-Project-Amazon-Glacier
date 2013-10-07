import java.awt.List;

import com.amazonaws.services.glacier.AmazonGlacierClient;
import com.amazonaws.services.glacier.model.DescribeVaultOutput;
import com.amazonaws.services.glacier.model.ListVaultsRequest;
import com.amazonaws.services.glacier.model.ListVaultsResult;

public class VaultMetadata extends DescribeVaultOutput{
	public static void main(String[] args) {

		AmazonGlacierClient client;
		//client.setEndpoint("https://glacier.us-west-1.amazonaws.com/");
		String marker = null;
//		do {
//			ListVaultsRequest request = new ListVaultsRequest().withLimit("5")
//					.withMarker(marker);
//			ListVaultsResult listVaultsResult = client.listVaults(request);
//			List<DescribeVaultOutput> vaultList = listVaultsResult
//					.getVaultList();
//			marker = listVaultsResult.getMarker();
//			for (DescribeVaultOutput vault : vaultList) {
//				System.out.println("\nCreationDate: " + vault.getCreationDate()
//						+ "\nLastInventoryDate: "
//						+ vault.getLastInventoryDate() + "\nNumberOfArchives: "
//						+ vault.getNumberOfArchives() + "\nSizeInBytes: "
//						+ vault.getSizeInBytes() + "\nVaultARN: "
//						+ vault.getVaultARN() + "\nVaultName: "
//						+ vault.getVaultName());
//			}
//		} while (marker != null);
	}
}
