package POST;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class crearProds {

	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new FileReader("productos.in"));
		while(sc.readLine()!="jaaaaaaaaaaaaaaa") {

			URL url = new URL("https://ccxn.crm.us6.oraclecloud.com/crmRestApi/resources/11.13.17.11/products");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			String name;
			String itemNumber2 = sc.readLine();
			String descripcion = sc.readLine();
			String itemNumber = itemNumber2.replaceAll("-", "");
			name = itemNumber + "-" + descripcion 	;
			String json = "{%ItemNumber% : %" + itemNumber2 + "%,  %Description% : %" + descripcion + "%,  %Name% : %"
					+ name + "%, %DefaultUOMCode% : %zzy%, %ProductTypeCode% : %GOODS%}";
			String json2 = json.replaceAll("%", "\"");
			System.out.println(json2);
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/vnd.oracle.adf.resourceitem+json");
			con.setRequestProperty("Authorization", "Basic dGNhc3RpbGxvOlRTQTEyMzQ1");
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