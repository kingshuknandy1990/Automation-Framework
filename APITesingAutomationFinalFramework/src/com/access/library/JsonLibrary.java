package com.access.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonLibrary {
JSONParser parser;
	
	public JsonLibrary() {
		parser=new JSONParser();
	}
	
	
	//=====================================Custom Parser==============
	public HashMap<String, Object> customParser(String responseString){
		HashMap <String, Object> mapObj1=new HashMap<String, Object>();
		try {
			if(parser.parse(responseString) instanceof JSONObject){
				mapObj1=JsonLibrary.instanceOfJSONobject((JSONObject) parser.parse(responseString));
			}else 
				throw new Exception("It is not a JSON Object");
			
		} catch (ParseException e1) {
				System.out.println("Exception Occured in Custom parser"+e1);
		} catch (Exception e2) {
				System.out.println("Exception Occured in Custom parser"+e2);
		}
		return mapObj1;
	}
	
	
	//========================Instance of json object============================
	public static HashMap<String, Object> instanceOfJSONobject(JSONObject jOBJ){
		HashMap <String, Object> mapObj=new HashMap<String, Object>();	
		
		
		Set<Entry<String,Object>> entryObj =  jOBJ.entrySet();
		Iterator<Entry<String,Object>> iteratorEntry = entryObj.iterator();
		while(iteratorEntry.hasNext()){
			Entry<String, Object> iteratorEntryObj = iteratorEntry.next();
			if(iteratorEntryObj.getValue() instanceof JSONObject){
				HashMap <String, Object> mapObj111=JsonLibrary.instanceOfJSONobject((JSONObject) iteratorEntryObj.getValue() );
				mapObj.put(iteratorEntryObj.getKey(), mapObj111);
			}else if(iteratorEntryObj.getValue() instanceof JSONArray){
				List listArr=JsonLibrary.instanceOfJSONArray((JSONArray) iteratorEntryObj.getValue() );
				mapObj.put(iteratorEntryObj.getKey(), listArr);
			}else if(iteratorEntryObj.getValue() instanceof String){
				String str=JsonLibrary.instanceOfString((String) iteratorEntryObj.getValue() );
				mapObj.put(iteratorEntryObj.getKey(), str);
			}else{
				try {
					throw new Exception("It is not a JSON Object");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return mapObj;
	}
	

	//========================Instance of json Array============================
	public static List instanceOfJSONArray(JSONArray jARR){
		List outList=new ArrayList();
		Iterator ite=jARR.iterator();
		 while (ite.hasNext()) {
			 Object obj=ite.next();
			 if(obj instanceof String){
				 outList.add(obj.toString()) ;
			 }else if(obj instanceof JSONObject){
					HashMap <String, Object> mapObj111=JsonLibrary.instanceOfJSONobject((JSONObject) obj );
					outList.add(mapObj111);
			}else if(obj instanceof JSONArray){
					List listArr=JsonLibrary.instanceOfJSONArray((JSONArray) obj );
					outList.add(listArr);
				}
		}
		return outList;	
	}
	
	//========================Instance of String============================
	public static String instanceOfString(String stringObj){	
		return stringObj;
	}	
}
