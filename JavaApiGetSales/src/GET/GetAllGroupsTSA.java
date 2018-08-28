package GET;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class GetAllGroupsTSA {

	public static void main(String[] args) throws IOException {
		URL url = new URL("https://ccxn-test.crm.us6.oraclecloud.com/salesApi/resources/11.12.1.0/setupSalesCatalogs/?"				);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		Map<String, String> parameters = new HashMap<>();
		parameters.put("q", "limit=1000");

		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Authorization", "Basic Y2FzdGlsbG90b21hc2FkbWluOlRTQTEyMzQ1");
		PrintWriter pw = new PrintWriter(new File("grupos.out"));
		int status = con.getResponseCode();
		BufferedReader in = new BufferedReader(
				  new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
				    content.append(inputLine);
				    System.out.println(inputLine);
				    pw.print(inputLine);
				}
				
				in.close();
				con.disconnect();
	}
}
