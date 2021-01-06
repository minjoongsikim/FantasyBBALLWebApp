<%@ page import="com.ballers.MyWebApp.RankingsGenerator" %>
<%@ page import="java.net.URL" %>
<%@ page import="org.w3c.dom.Element" %>
<%@ page import="javax.xml.parsers.ParserConfigurationException" %>
<%@ page import="org.xml.sax.SAXException" %>
<%@ page import="com.ballers.MyWebApp.Player" %>
<%@ page import="java.util.Vector" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <title>JSP - Servlet One Home Page</title>
        <link href = "./style.css" type = "text/css" rel = "stylesheet">
        <script src="https://www.kryogenix.org/code/browser/sorttable/sorttable.js"></script>
    </head>
    <body>
        <header>
            <img src = "Photos/fantasyimage.png">
            <nav>
                <ul>
                    <li><a href = "./index.jsp"> Home </a></li>
                    <li><a href = "#" class = "active"> Player Values </a></li>
                    <li><a href="#">Pricing</a></li>
                    <li><a href="#">Terms of use</a></li>
                    <li><a href="#">Contact</a></li>
                </ul>
            </nav>
        </header>
        <main>
            <table class = "sortable styled-table">
                <tr>
                    <th>Player</th>
                    <th>Calculated Value</th>
                </tr>
                <%
                    @SuppressWarnings("unchecked") // so it doesn't throw an error (know I want a vector of Players)
                    Vector<Player> players = (Vector<Player>) session.getAttribute("players");

                for (Player p : players) { %>

                <tr class="item">
                    <td><%=p.NAME%></td>
                    <td><%=p.findValue()%></td>
                </tr>
            <% } %>

            </table>
        </main>
    </body>
</html>