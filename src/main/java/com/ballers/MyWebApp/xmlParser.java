package com.ballers.MyWebApp;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.URL;


public class xmlParser {
    public static Node[] arrayCreator(URL url) throws IOException, SAXException, ParserConfigurationException {
        File inputFile = createFile(url);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(inputFile);
        NodeList nList = doc.getElementsByTagName("Player");
        Node[] array = new Node[nList.getLength()];
        for (int i = 0; i < nList.getLength(); i ++){
            Node nNode = nList.item(i);
            array[i] = nNode;
            Element e = (Element) nNode;
            System.out.println(e.getElementsByTagName("name").item(0).getTextContent());
        }

        //Element e = (Element) nNode;

        return array;
    }
    public static File createFile(URL url) throws IOException {

        File f = new File("C:\\Users\\minmi\\IdeaProjects\\MyWebApp\\src\\main\\java\\com\\ballers\\MyWebApp\\info.xml");

        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        OutputStream outStream = new FileOutputStream(f);
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            outStream.write(inputLine.getBytes());
        }

        outStream.close();
        in.close();

        return f;
    }


}
