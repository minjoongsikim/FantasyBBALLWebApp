package com.ballers.MyWebApp;


import java.io.IOException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.net.URL;
import java.util.List;


public class Main {
    public static void main(String args[]) throws IOException, ParserConfigurationException, SAXException {
        List<LivePlayer> players = JSONHandler.getLivePlayers();
        System.out.println("hello");
        System.out.println(players.get(0).getName());
        System.out.println((players.get(0).getAssists()));
    }
}
