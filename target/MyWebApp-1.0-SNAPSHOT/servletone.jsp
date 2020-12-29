



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
        <style>
            .button {
                background-color: #FFFFFF; /* White */
                border: none;
                color: black;
                font-weight: bold;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 15px;
                margin: 4px 2px;
                cursor: pointer;
            }
            th {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <h1><%= "Servlet One Home Page" %></h1><br/>
        <table>
            <tr>
                <th>
                    <button class="button">Player</button>
                </th>
                <th>
                    <button class="button">Team</button>
                </th>
                <th>
                    <button class="button">Position</button>
                </th>
                <th>
                    <button class="button">Games</button>
                </th>
                <th>
                    <button class="button">PTS</button>
                </th>
                <th>
                    <button class="button">AST</button>
                </th>
                <th>
                    <button class="button">REB</button>
                </th>
                <th>
                    <button class="button">FG%</button>
                </th>
                <th>
                    <button class="button">FT%</button>
                </th>
                <th>
                    <button class="button">STL</button>
                </th>
                <th>
                    <button class="button">BLK</button>
                </th>
                <th>
                    <button class="button">3PM</button>
                </th>
                <th>
                    <button class="button">TO</button>
                </th>
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

                for (int i = 0; i < e.length; i++) {
                    int games = Integer.parseInt(e[i].getElementsByTagName("Games").item(0).getTextContent()); %>
                    <tr>
                        <td><%=e[i].getElementsByTagName("name").item(0).getTextContent()%></td>
                        <td><%=e[i].getElementsByTagName("team").item(0).getTextContent()%></td>
                        <td><%=e[i].getElementsByTagName("position").item(0).getTextContent()%></td>
                        <td><%=e[i].getElementsByTagName("Games").item(0).getTextContent()%></td>
                        <td><%=Math.floor(Double.parseDouble(e[i].getElementsByTagName("PTS").item(0).getTextContent())/games * 100)/100%></td>
                        <td><%=Math.floor(Double.parseDouble(e[i].getElementsByTagName("AST").item(0).getTextContent())/games * 100)/100%></td>
                        <td><%=Math.floor(Double.parseDouble(e[i].getElementsByTagName("REB").item(0).getTextContent())/games * 100)/100%></td>
                        <td><%=e[i].getElementsByTagName("FG").item(0).getTextContent()%></td>
                        <td><%=e[i].getElementsByTagName("FT").item(0).getTextContent()%></td>
                        <td><%=Math.floor(Double.parseDouble(e[i].getElementsByTagName("STL").item(0).getTextContent())/games * 100)/100%></td>
                        <td><%=Math.floor(Double.parseDouble(e[i].getElementsByTagName("BLK").item(0).getTextContent())/games * 100)/100%></td>
                        <td><%=Math.floor(Double.parseDouble(e[i].getElementsByTagName("THREES").item(0).getTextContent())/games * 100)/100%></td>
                        <td><%=Math.floor(Double.parseDouble(e[i].getElementsByTagName("TO").item(0).getTextContent())/games * 100)/100%></td>
                    </tr>
            <% } %>
        </table>
    </body>




</html>