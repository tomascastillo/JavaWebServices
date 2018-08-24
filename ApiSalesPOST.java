package apiSales;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ApiSalesPOST {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub'
		URL url = new URL("https://ccda-test.crm.us2.oraclecloud.com/crmRestApi/resources/11.13.17.11/setupSalesCatalogs/300000006594662/child/ProductGroupRelationSetup/");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		String json="{%RelProdGroupId%: 300000096324549}";
		String json2 = json.replaceAll("%","\"");
		System.out.println(json2);
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/vnd.oracle.adf.resourceitem+json");

		con.setRequestProperty("Authorization", "Basic Uk9DVE9SUkVTOkZpYmVyMTIzNA==");
//		System.out.println(json2);
		con.setDoOutput(true);
//		con.setDoInput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		
		wr.write(json2.getBytes());
		wr.flush();
		wr.close();
		//String contentType = con.getHeaderField("Content-Type");
		System.out.println(con.getResponseCode());
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());
	}
}