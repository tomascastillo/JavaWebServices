package gruposDeProductoGetAllSales;

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

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GetAllRestApi {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		URL url = new URL("https://ccda-test.crm.us2.oraclecloud.com/salesApi/resources/11.12.1.0/setupSalesCatalogs/?q=InternalName=Transmision de Datos 3 Mbps"				);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		Map<String, String> parameters = new HashMap<>();
		parameters.put("q", "InternalName=Transmision de Datos 3 Mbps");
		 
//		con.setDoOutput(true);
//		DataOutputStream out = new DataOutputStream(con.getOutputStream());
//		out.writeBytes(ParamterStringBuilder.getParamsString(parameters));
//		out.flush();
//		out.close();
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Authorization", "Basic TURJTFVDQTpGaWJlcjEyMzQ=");

		//String contentType = con.getHeaderField("Content-Type");
		
		PrintWriter pw = new PrintWriter(new File("ofertasComerciales.out"));
		int status = con.getResponseCode();
		BufferedReader in = new BufferedReader(
				  new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
				    content.append(inputLine);
				    System.out.println(inputLine);
				    pw.print(inputLine);
//				    String items = inputLine.split("items")[1];
////				    String id = items.split("ProdGroupId")[1];
//				    System.out.println(items);
//				    System.out.println(inputLine);
//				    String json =inputLine;
//				    JsonParser parser = new JsonParser();
//
//				    JsonElement jsonTree = parser.parse(json);
//
//				    if(jsonTree.isJsonObject()){
//				        JsonObject jsonObject = jsonTree.getAsJsonObject();
//
//				        JsonElement f1 = jsonObject.get("ProdGroupName");
//
//				        JsonElement f2 = jsonObject.get("ProdGroupId");
//				        System.out.println("f111111111"+f1);
////				        if(f2.isJsonObject()){
////				            JsonObject f2Obj = f2.getAsJsonObject();
//			//
////				            JsonElement f3 = f2Obj.get("f3");
////				        }
//				        String name=f1.getAsString();
//				        String number=f2.getAsString();
//				        String rta=name+" , "+number;
//				        pw.println(rta);
//				    }
//				    //String rta = parse(inputLine);
//				    else {System.out.println("no");}
				}
				
				in.close();
				con.disconnect();
	}
//	public static String parse(String jsonLine) throws EOFException {
//	   JsonElement jelement = new JsonParser().parse(jsonLine);
//	    JsonObject  jobject = jelement.getAsJsonObject();
//	    jobject = jobject.getAsJsonObject("items");
////	    JsonArray jarray = jobject.getAsJsonArray("items");
//	//    jobject = jarray.get(0).getAsJsonObject();
//	    String name = jobject.get("ProdGroupName").getAsString();
//	    String number = jobject.get("ProdGroupId").getAsString();
//	    String result = name+","+number;
//	    
//
//	    
//	    
//	    
//	    return result;
//	}
}
