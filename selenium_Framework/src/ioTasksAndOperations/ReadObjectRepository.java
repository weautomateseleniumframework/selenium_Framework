package ioTasksAndOperations;
import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
public class ReadObjectRepository {

	
	public static ArrayList<String> findTestObject(String objectloc)
	{
		
		String selectorMethod = null;
		String xpath = null;
		ArrayList<String> object = new ArrayList<String>();
		String selector = "xpath";
		String isSelected = null;
		String tagName = null;
		String cssValue = null;
		Boolean propertyXpathbool = false;
		 try {
	         File inputFile = new File(System.getProperty("user.dir")+"\\Object Repository\\"+objectloc+".rs");
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
//This will first get the selector Method in the xml file
	         
	         NodeList nList = doc.getElementsByTagName("WebElementEntity");
	         for (int temp = 0; temp < nList.getLength(); temp++) 
	         {
	            Node nNode = nList.item(temp);
	            
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) 
	            {
	            	
	            	Element eElement = (Element) nNode;
	            	
	                //This will first get the selector Method in the xml file
	            	selectorMethod = eElement.getElementsByTagName("selectorMethod").item(0).getTextContent();
	            	
	            	/*According to the Selector Method, we have to do the following
	   	          * if Selector Method is set to XPATH
	   	          * Search for webElementXpaths node where isSelected node is set to true
	   	          * get the value of value
	   	         */
	            	
	            	if(selectorMethod.equals("XPATH"))
	            	{
	            	 NodeList xpathList = doc.getElementsByTagName("webElementXpaths");
	       	         for (temp = 0; temp < xpathList.getLength(); temp++) 
	       	         {
	       	            Node xpathNode = xpathList.item(temp);
	       	            
	       	            if (xpathNode.getNodeType() == Node.ELEMENT_NODE) 
	       	            {
	       	            	Element isSelectedElement = (Element) xpathNode;
	       	            	isSelected = isSelectedElement.getElementsByTagName("isSelected").item(0).getTextContent();
	       	            	if(isSelected.equals("true"))
	       	            	{
	       	            	Element xpathElement = (Element) xpathNode;
	       	            	xpath = xpathElement.getElementsByTagName("value").item(0).getTextContent();
	       	            	}
	       	            }
	       	         }
	            	}
	            	
	            	
	            	/*According to the Selector Method, we have to do the following
		   	          * if Selector Method is not set to XPATH
		   	          * Search for webElementXpaths node where isSelected node is set to true
		   	          * get the value of value
		   	         */
	            	else if(selectorMethod.equals("BASIC"))
	            	{
	            	
	                	 NodeList propertyList = doc.getElementsByTagName("webElementProperties");
		       	         for (temp = 0; temp < propertyList.getLength(); temp++) 
		       	         {
		       	            Node propertyNode = propertyList.item(temp);
		       	            
		       	            if (propertyNode.getNodeType() == Node.ELEMENT_NODE) 
		       	            {
		       	            	Element isSelectedElement = (Element) propertyNode;
		       	            	isSelected = isSelectedElement.getElementsByTagName("isSelected").item(0).getTextContent();
		       	            	if(isSelected.equals("true"))
		       	            	{
		       	            		Element elementE = (Element) propertyNode;
		       	            		String element = elementE.getElementsByTagName("name").item(0).getTextContent();
		       	            		if(element.equals("tag"))
		       	            		{
		       	            			Element tagNameE = (Element) propertyNode;
			       	            		tagName = tagNameE.getElementsByTagName("value").item(0).getTextContent();
		       	            		}
		       	            		else if(element.equals("xpath"))
		       	            		{
		       	            			Element xpathElement = (Element) propertyNode;
		       	            			xpath = xpathElement.getElementsByTagName("value").item(0).getTextContent();
		       	            			propertyXpathbool = true;
		       	            		}
		       	            		else if(element.equals("css"))
		       	            		{
		       	            			selector = "css";
		       	            			Element xpathElement = (Element) propertyNode;
		       	            			cssValue = xpathElement.getElementsByTagName("value").item(0).getTextContent();
		       	            		}
		       	            		else
		       	            		{
		       	            			Element xpathElement = (Element) propertyNode;
			       	            		if(xpath==null)
			       	            			xpath = "@"+element+"='" +xpathElement.getElementsByTagName("value").item(0).getTextContent()+"'";
			       	            		else
			       	            			xpath = xpath + " and @"+element+"='" +xpathElement.getElementsByTagName("value").item(0).getTextContent()+"'";
		       	            		}
		       	            		
		       	        
		       	            	}
		       	            }
		       	         }
		       	         
		       	         if(tagName == null)
		       	        	 tagName = "*";
		       	         
	            		if(propertyXpathbool == false)
	            		xpath = "//"+tagName+"["+xpath + "]";
	            		
	            	}
	            	 	
	            	
	      }
	         }
	         }catch (Exception e) {
	         e.printStackTrace();
	      }
		 
		 object.add(selector);
		 if(selector.equals("css"))
		 {
			 object.add(cssValue);	 
		 }
		 else
		 {
		 object.add(xpath);
		 }
		 
		return object;	
	}
	

	
}
