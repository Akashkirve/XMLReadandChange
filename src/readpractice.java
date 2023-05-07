import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.*;

public class readpractice {

	public static void main(String[] args) throws Exception {
	String xmlfile = "C:\\Users\\HP\\NEW Workplace\\XMLReadandchange\\XML\\sample_CustomersOrders.xml";
	
	//try {
        // Load XML file
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();

    // Step 2: Parse the XML file and create a Document object
    Document doc = builder.parse(new File("XML\\sample_CustomersOrders.xml"));
    Element root = doc.getDocumentElement();
     
    
    NodeList nodes = root.getElementsByTagName("Phone");
    
    
    for(int i =0; i<nodes.getLength(); i++) 
    {
    	Element element = (Element)nodes.item(i);
    	element.setTextContent("12344");
    }
    
    

    //element.setTextContent("1234");

        
        
        
     
        // Save the modified document back to the file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("xmlfile"));
        transformer.transform(source, result);
        System.out.println("The XML file has been updated.");
   
//   
//  }catch (Exception e) {
//      e.printStackTrace();
//      
	
	
        
	}
	
}




