package com.ballers.MyWebApp;


import java.io.IOException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.net.URL;



public class Main {
    public static void main(String args[]) throws IOException, ParserConfigurationException, SAXException {
        URL url = new URL("https://www.fantasybasketballnerd.com/service/draft-projections");
        Node[] n = xmlParser.arrayCreator(url);
        RankingsGenerator.sortByRank(n, "REB");
    }

}
