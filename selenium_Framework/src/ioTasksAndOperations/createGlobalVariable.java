package ioTasksAndOperations;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashMap; 

public class createGlobalVariable {
	
	public static String initValue;
	public static String name;

	public static void main(String args[]) {
		updateGlobalVariables("globalvarTest");
	}
        
        public static void updateGlobalVariables(String ProfileName)
        {

    		String path = System.getProperty("user.dir")+"/src/ioTasksAndOperations/GlobalVariables.java";
            File file = new File(path);
            FileWriter fr = null;
           
            try {
            	fr = new FileWriter(file, false);
            	HashMap<String, String> map = new HashMap<>();
            	map = getGlobalVariables(ProfileName);
            	
            	fr.write("package ioTasksAndOperations;\npublic class GlobalVariables {\n\n");
            	

//            	fr.write("//input variables here");
            	for (HashMap.Entry<String, String> entry : map.entrySet()) {
            		StringBuilder mapValue = new StringBuilder(entry.getKey()); 
            		String varValue = (mapValue.deleteCharAt(0)).toString();
            		mapValue = new StringBuilder(varValue);
            		varValue = (mapValue.deleteCharAt(varValue.length()-1)).toString();
            		fr.write("public static String "+entry.getValue()+" = \""+varValue+"\";\n\n");

            	}
            	fr.write("\n}");
            	
            	
            	
            	
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                //close resources
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        
        public static HashMap<String, String> getGlobalVariables(String ProfileName)
        {
        	 HashMap<String, String> map  = new HashMap<>();
        
        try {
   		 
            File inputFile = new File(System.getProperty("user.dir")+"\\Profiles\\"+ProfileName+".xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            //This will first get the selector Method in the xml file
            
            NodeList nList = doc.getElementsByTagName("GlobalVariableEntity");
            
            for (int temp = 0; temp < nList.getLength(); temp++) 
            {
               Node nNode = nList.item(temp);
               
               if (nNode.getNodeType() == Node.ELEMENT_NODE) 
               {
               	Element eElement = (Element) nNode;
               	initValue = eElement.getElementsByTagName("initValue").item(0).getTextContent();
               	name = eElement.getElementsByTagName("name").item(0).getTextContent();

               
                map.put(initValue, name); 
               }
            }
   	 }
   	 catch(Exception e)
   	 {
   		 e.printStackTrace();
   	 }
        return map;
    }
	
	
}
