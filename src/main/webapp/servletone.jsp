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
                    <th>Rank</th>
                    <th>Player</th>
                    <th>Value</th>
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
                    @SuppressWarnings("unchecked") // so it doesn't throw an error (know I want a vector of Players)
                    Vector<Player> players = (Vector<Player>) session.getAttribute("players");
                    Player.sortByValue(players);

                for (Player p : players) { %>

                <tr class="item">
                    <td><%=p.rank%></td>
                    <td><%=p.NAME%></td>
                    <td><%=p.findValue()%></td>
                    <td><%=p.TEAM%></td>
                    <td><%=p.POS%></td>
                    <td><%=p.GAMES%></td>
                    <td><%=p.PTS%></td>
                    <td><%=p.AST%></td>
                    <td><%=p.REB%></td>
                    <td><%=p.FG%></td>
                    <td><%=p.FT%></td>
                    <td><%=p.STL%></td>
                    <td><%=p.BLK%></td>
                    <td><%=p.THREES%></td>
                    <td><%=p.TO%></td>

                </tr>
            <% } %>

            </table>
        </main>
    </body>
</html>