



<%@ page import="com.ballers.MyWebApp.RankingsGenerator" %>
<%@ page import="java.net.URL" %>
<%@ page import="org.w3c.dom.Element" %>
<%@ page import="org.w3c.dom.Node" %>
<%@ page import="javax.xml.parsers.ParserConfigurationException" %>
<%@ page import="org.xml.sax.SAXException" %>
<%@ page import="java.io.OptionalDataException" %>
<%@ page import="java.text.DecimalFormat" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP - Servlet One Home Page</title>
    </head>

    <body>
        <h1><%= "Servlet One Home Page" %></h1><br/>
        <table class="center">
            <tr>
                <th>Player</th>
                <th>Team</th>
                <th>Position</th>
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
            <%

                URL url = new URL("https://www.fantasybasketballnerd.com/service/draft-projections");
                Element[] e = new Element[0];
                String category;
                try {
                    e = RankingsGenerator.getOrderedArray(url, category);
                } catch (ParserConfigurationException | SAXException parserConfigurationException) {
                    parserConfigurationException.printStackTrace();
                }

                for (int i = 0; i < e.length; i++) {
                    int games = Integer.parseInt(e[i].getElementsByTagName("Games").item(0).getTextContent()); %>
                    <tr>
                        <td><%=e[i].getElementsByTagName("name").item(0).getTextContent()%></td>
                        <td><%=e[i].getElementsByTagName("team").item(0).getTextContent()%></td>
                        <td><%=e[i].getElementsByTagName("position").item(0).getTextContent()%></td>
                        <td><%=Math.floor(Double.parseDouble(e[i].getElementsByTagName("PTS").item(0).getTextContent())/games * 100)/100%></td>
                        <td><%=Math.floor(Double.parseDouble(e[i].getElementsByTagName("AST").item(0).getTextContent())/games * 100)/100%></td>
                    </tr>
            <% } %>
        </table>
    </body>




</html>