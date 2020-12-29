
<%@ page import="com.ballers.MyWebApp.RankingsGenerator" %>
<%@ page import="java.net.URL" %>
<%@ page import="org.w3c.dom.Element" %>
<%@ page import="org.w3c.dom.Node" %>
<%@ page import="javax.xml.parsers.ParserConfigurationException" %>
<%@ page import="org.xml.sax.SAXException" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP - Servlet One Home Page</title>
    </head>

    <body>
        <h1><%= "Servlet One Home Page" %></h1><br/>
        <%
            URL url = new URL("https://www.fantasybasketballnerd.com/service/draft-projections");
            try {
                Element[] e = RankingsGenerator.getOrderedArray(url, "PTS");
            } catch (ParserConfigurationException | SAXException parserConfigurationException) {
                parserConfigurationException.printStackTrace();
                System.out.println("Error");
            }

        %>
        <table class="center">
            <tr>
                <th>Player</th>
                <th>PTS</th>
                <th>AST</th>
                <th>REB</th>
                <th>FG</th>
                <th>FT</th>
                <th>STL</th>
                <th>BLK</th>
                <th>THREES</th>
                <th>TO</th>
            </tr>
        </table>
    </body>




</html>