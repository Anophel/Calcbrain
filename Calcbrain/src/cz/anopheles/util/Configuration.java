package cz.anopheles.util;

import java.io.File;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cz.anopheles.MainClass;

public class Configuration {

	private static final URL path = MainClass.class.getResource("sources/Configuration.xml");
	
	private static Configuration configuration;
	
	private static final String VERSION = "version";
	private String version;
	
	private Configuration(){
	}
	
	public static void initConfiguration() throws Exception{
		File inputFile = new File(path.getFile());
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList ss = doc.getElementsByTagName(VERSION);
        
        Configuration config = new Configuration();
        
        for(int i = 0; i < ss.getLength(); i++){
        	Node n = ss.item(i);
        	switch(n.getNodeName()){
        	case VERSION:
        		config.setVersion(n.getTextContent());
        		break;
        	default:
        		// unidentified -> skipping
        		break;
        	}
        }
        
        setConfiguration(config);
	}
	
	public static Configuration getConfiguration() {
		return configuration;
	}

	private static void setConfiguration(Configuration configuration) {
		Configuration.configuration = configuration;
	}
	
	public static boolean isConfigReady(){
		return configuration != null;
	}

	public String getVersion() {
		return version;
	}

	private void setVersion(String version) {
		this.version = version;
	}
}
