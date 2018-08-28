package POST;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class AsociacionSubgrupoAGrupo {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("asociacionS.in"));
		for (int i = 0; i < 1; i++) {

			URL url = new URL(
					"https://ccxn-test.crm.us6.oraclecloud.com/crmRestApi/resources/11.13.17.11/setupSalesCatalogs/300000003200440/child/ProductGroupRelationSetup/");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			String RelProdGroupId = sc.nextLine();
			String json = "{%RelProdGroupId%: " + RelProdGroupId + "}";
			String json2 = json.replaceAll("%", "\"");
			System.out.println(json2);
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/vnd.oracle.adf.resourceitem+json");

			con.setRequestProperty("Authorization", "Basic Y2FzdGlsbG90b21hc2FkbWluOlRTQTEyMzQ1");
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());

			wr.write(json2.getBytes());
			wr.flush();
			wr.close();
			System.out.println(con.getResponseCode());
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			System.out.println(response.toString());
		}
		sc.close();
	}
}