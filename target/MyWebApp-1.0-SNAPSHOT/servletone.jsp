
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
    </body>



    <table class="center">
        <tr>
            <th>Player</th>
            <th>PTS</th>
        </tr>
        <tr>
            <td>January</td>
            <td>$100</td>
        </tr>
        <tr>
            <td>February</td>
            <td>$80</td>
        </tr>
    </table>
</html>