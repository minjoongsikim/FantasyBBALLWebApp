<%@ page import="com.ballers.MyWebApp.RankingsGenerator" %>
<%@ page import="java.net.URL" %>
<%@ page import="org.w3c.dom.Element" %>
<%@ page import="javax.xml.parsers.ParserConfigurationException" %>
<%@ page import="org.xml.sax.SAXException" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <title>JSP - Index / Home Page</title>
        <link href = "./style.css" type = "text/css" rel = "stylesheet">
        <link rel= "stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script src="https://www.kryogenix.org/code/browser/sorttable/sorttable.js"></script>
    </head>
    <body>
        <!-- Header -->
        <header>
            <nav>
                <ul>
                    <li><a href = "#"> Home </a></li>
                    <li><a href = "./servletone.jsp"> Servlet One </a></li>
                </ul>
            </nav>
        </header>

        <p>Welcome to the Fantasy Basketball WebApp</p>

        <h1> 2020-2021 NBA SEASON PROJECTIONS</h1>
        <table class = "sortable styled-table">
            <tr>
                <th>Player</th>
                <th>Team</th>
                <th>Position</th>
                <th>Games</th>
                <th>PTS</th>
                <th>AST</th>
                <th>REB</th>
                <th>FG%</th>
                <th>FT%</th>
                <th>STL</th>
                <th>BLK</th>
                <th>3PM</th>
                <th>TO</th>
            </tr>
            <%

                URL url = new URL("https://www.fantasybasketballnerd.com/service/draft-projections");
                Element[] e = new Element[0];
                String category = "0";
                try {
                    e = RankingsGenerator.getOrderedArray(url, category);
                } catch (ParserConfigurationException | SAXException parserConfigurationException) {
                    parserConfigurationException.printStackTrace();
                }

                for (Element element : e) {
                    int games = Integer.parseInt(element.getElementsByTagName("Games").item(0).getTextContent()); %>
                <tr class="item">
                    <td><%=element.getElementsByTagName("name").item(0).getTextContent()%>
                    </td>
                    <td><%=element.getElementsByTagName("team").item(0).getTextContent()%>
                    </td>
                    <td><%=element.getElementsByTagName("position").item(0).getTextContent()%>
                    </td>
                    <td><%=element.getElementsByTagName("Games").item(0).getTextContent()%>
                    </td>
                    <td><%=Math.floor(Double.parseDouble(element.getElementsByTagName("PTS").item(0).getTextContent()) / games * 100) / 100%>
                    </td>
                    <td><%=Math.floor(Double.parseDouble(element.getElementsByTagName("AST").item(0).getTextContent()) / games * 100) / 100%>
                    </td>
                    <td><%=Math.floor(Double.parseDouble(element.getElementsByTagName("REB").item(0).getTextContent()) / games * 100) / 100%>
                    </td>
                    <td><%=element.getElementsByTagName("FG").item(0).getTextContent()%>
                    </td>
                    <td><%=element.getElementsByTagName("FT").item(0).getTextContent()%>
                    </td>
                    <td><%=Math.floor(Double.parseDouble(element.getElementsByTagName("STL").item(0).getTextContent()) / games * 100) / 100%>
                    </td>
                    <td><%=Math.floor(Double.parseDouble(element.getElementsByTagName("BLK").item(0).getTextContent()) / games * 100) / 100%>
                    </td>
                    <td><%=Math.floor(Double.parseDouble(element.getElementsByTagName("THREES").item(0).getTextContent()) / games * 100) / 100%>
                    </td>
                    <td><%=Math.floor(Double.parseDouble(element.getElementsByTagName("TO").item(0).getTextContent()) / games * 100) / 100%>
                    </td>
                </tr>
            <% } %>
        </table>
    </body>
</html>