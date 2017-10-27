package com.garbage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.accesslibrary.JsonLibrary;








public class Practice1 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		//String url="http://services.groupkt.com/country/get/all";
		String url="http://services.groupkt.com/country/get/iso2code/"+"IN";
		String path="";
		HttpClient client=HttpClientBuilder.create().build();
		
		HttpGet request = new HttpGet(url + path);
		HttpResponse response= client.execute(request);
		
		StringBuffer responseString = new StringBuffer();
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line = "";
		while ((line = rd.readLine()) != null) {
			responseString.append(line);
		}
		
		System.out.println(responseString);
		System.out.println("Status Code::"+response.getStatusLine().getStatusCode());
		System.out.println("Status Phrase::"+response.getStatusLine().getReasonPhrase());
		
		Header[] rheaders = response.getAllHeaders();
		for (Header header : rheaders) {
			System.out.println("Header Name::"+header.getName()+"   Header value::"+header.getValue());
		}
		
		System.out.println("-----------------------------------------------------------------");
		JsonLibrary jlib=new JsonLibrary();
		HashMap   hmap=jlib.customParser(responseString.toString());
		System.out.println(hmap);
		System.out.println("-----------------------------------------------------------------");
		/*JSONParser parser = new JSONParser();
		try {
			JSONObject jsonObject = (JSONObject) parser.parse(responseString.toString());
			Set<String> set =  jsonObject.keySet();
			Iterator<String> iterator = set.iterator();
			while(iterator.hasNext()){
				System.out.println("-------"+iterator.next());
			}
			
			Set<Entry<String,Object>> entry =  jsonObject.entrySet();
			Iterator<Entry<String,Object>> iteratorEntry = entry.iterator();
			while(iteratorEntry.hasNext()){
				Entry<String, Object> entry2 = iteratorEntry.next();
				System.out.println("-------"+entry2.getKey()+"-------"+entry2.getValue());
				if(entry2.getValue() instanceof JSONObject){
					//JsonLibrary.instanceOfJSONobject((JSONObject) entry2.getValue() );
					System.out.println("*********JSONObject************");
				}else if(entry2.getValue() instanceof JSONArray){
					//JsonLibrary.instanceOfJSONArray((JSONArray) entry3.getValue() );
					System.out.println("*********JSONArray************");
				}else if(entry2.getValue() instanceof String){
					///JsonLibrary.instanceOfString((String) entry3.getValue() );
					System.out.println("*********String************");
				}else{
					
				}
			}*/
			
		
			
			
			System.out.println("*************************************************");
	/*		JSONObject jsonObject2=(JSONObject) jsonObject.get("RestResponse");
			JSONArray messageArray=(JSONArray) jsonObject2.get("messages");
			Iterator ite=messageArray.iterator();
			 while (ite.hasNext()) {
				 System.out.println("message::"+ite.next());	
			}
			 
			 JSONObject jsonObject3=(JSONObject) jsonObject2.get("result");
			 String name=(String) jsonObject3.get("name");
			 String alpha2_code=(String) jsonObject3.get("alpha2_code");
			 String alpha3_code=(String) jsonObject3.get("alpha3_code");
			 System.out.println("name::"+name);
			 System.out.println("alpha2_code::"+alpha2_code);
			 System.out.println("alpha3_code::"+alpha3_code);*/
	/*	} catch (ParseException e) {
			
		}*/
	
	}

}
