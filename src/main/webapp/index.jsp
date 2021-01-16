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
        <title>JSP - Index / Home Page</title>
        <link href = "./style.css" type = "text/css" rel = "stylesheet">
        <script src="https://www.kryogenix.org/code/browser/sorttable/sorttable.js"></script>
    </head>
    <body>
        <!-- Header -->
        <header>
            <img src = "Photos/fantasyimage.png">
            <nav>
                <ul>
                    <li><a href = "#" class = "active"> Home </a></li>
                    <li><a href = "./servletone.jsp"> Player Values </a></li>
                    <li><a href="#">Pricing</a></li>
                    <li><a href="#">Terms of use</a></li>
                </ul>
            </nav>
        </header>
        <main>
            <h1> Welcome to the Fantasy Basketball WebApp</h1>
            <p> Created by Larry Bird</p>
            <h2> 2020-2021 PROJECTIONS</h2>
            <input type="text" id="myInput" onkeyup="filterNames()" placeholder="Enter name..." title="Name">
            <table id = "datatable" class = "sortable styled-table">
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

                    Vector<Player> players = new Vector<>(); // to be accessed across pages

                    for (Element element : e) {
                        Player singlePlayer = new Player(element);
                        players.add(singlePlayer);%>

                        <tr class="item">
                            <td><%=singlePlayer.NAME%></td>
                            <td><%=singlePlayer.TEAM%></td>
                            <td><%=singlePlayer.POS%></td>
                            <td><%=singlePlayer.GAMES%></td>
                            <td><%=singlePlayer.PTS%></td>
                            <td><%=singlePlayer.AST%></td>
                            <td><%=singlePlayer.REB%></td>
                            <td><%=singlePlayer.FG%></td>
                            <td><%=singlePlayer.FT%></td>
                            <td><%=singlePlayer.STL%></td>
                            <td><%=singlePlayer.BLK%></td>
                            <td><%=singlePlayer.THREES%></td>
                            <td><%=singlePlayer.TO%></td>
                        </tr>
                <% }
                session.setAttribute("players", players); // adding the vector of player info to be accessed on other pages %>
            </table>
        </main>
    </body>

    <!-- Function to filter the names of a table -->
    <script>
        function filterNames() {
            let input, filter, table, tr, td, i, txtValue;
            input = document.getElementById("myInput"); // gets the input
            filter = input.value.toUpperCase(); // case does not matter
            table = document.getElementById("datatable");
            tr = table.getElementsByTagName("tr");
            for (i = 0; i < tr.length; i++) {
                td = tr[i].getElementsByTagName("td")[0]; // searches "name" since name is indexed at 0
                if (td) {
                    txtValue = td.textContent || td.innerText; // gets the text of the line
                    if (txtValue.toUpperCase().indexOf(filter) > -1) {
                        tr[i].style.display = ""; // displays the row
                    } else {
                        tr[i].style.display = "none"; // hides the row
                    }
                }
            }
        }
    </script>
</html>