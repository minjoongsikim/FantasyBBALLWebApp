package com.ballers.MyWebApp;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.Vector;

public class Player {
    /** Category values takes as a parameter an aray with 8 indices to signify which categories should be taken into consideration when creating composite value.
     * Integer value of 1 should indicate usage.
     * Categories in order are:
     * 0. <PTS> - total points
     * 1. <AST> - total assists
     * 2. <REB> - total rebounds (offensive and defensive)
     * 3. <FG> - player field goal percentage
     * 4. <FT> - player free throw percentage
     * 5. <STL> - total steals
     * 6. <BLK> - total blocks
     * 7. <THREES> - total three pointers made
     * 8. <TO> - total turnovers
     */

    public String NAME;
    public String TEAM;
    public String POS;
    public int GAMES;
    public double PTS;
    public double AST;
    public double REB;
    public double FG;
    public double FT;
    public double STL;
    public double BLK;
    public double THREES;
    public double TO;
    public double totalPTS;
    public double totalAST;
    public double totalREB;
    public double totalSTL;
    public double totalBLK;
    public double totalTHREES;
    public double totalTO;
    public int rank;
    public Player(Element e) {
        NAME = e.getElementsByTagName("name").item(0).getTextContent();
        TEAM = e.getElementsByTagName("team").item(0).getTextContent();
        POS = e.getElementsByTagName("position").item(0).getTextContent();
        GAMES = Integer.parseInt(e.getElementsByTagName("Games").item(0).getTextContent());
        PTS = Math.floor(Double.parseDouble(e.getElementsByTagName("PTS").item(0).getTextContent()) / GAMES * 100) / 100;
        totalPTS = Double.parseDouble(e.getElementsByTagName("PTS").item(0).getTextContent());
        AST = Math.floor(Double.parseDouble(e.getElementsByTagName("AST").item(0).getTextContent()) / GAMES * 100) / 100;
        totalAST = Double.parseDouble(e.getElementsByTagName("AST").item(0).getTextContent());
        REB = Math.floor(Double.parseDouble(e.getElementsByTagName("REB").item(0).getTextContent()) / GAMES * 100) / 100;
        totalREB = Double.parseDouble(e.getElementsByTagName("REB").item(0).getTextContent());
        FG = Double.parseDouble(e.getElementsByTagName("FG").item(0).getTextContent());
        FT = Double.parseDouble(e.getElementsByTagName("FT").item(0).getTextContent());
        STL = Math.floor(Double.parseDouble(e.getElementsByTagName("STL").item(0).getTextContent()) / GAMES * 100) / 100;
        totalSTL = Double.parseDouble(e.getElementsByTagName("STL").item(0).getTextContent());
        BLK = Math.floor(Double.parseDouble(e.getElementsByTagName("BLK").item(0).getTextContent()) / GAMES * 100) / 100;
        totalBLK = Double.parseDouble(e.getElementsByTagName("BLK").item(0).getTextContent());
        THREES = Math.floor(Double.parseDouble(e.getElementsByTagName("THREES").item(0).getTextContent()) / GAMES * 100) / 100;
        totalTHREES = Double.parseDouble(e.getElementsByTagName("THREES").item(0).getTextContent());
        TO = Math.floor(Double.parseDouble(e.getElementsByTagName("TO").item(0).getTextContent()) / GAMES * 100) / 100;
        totalTO = Double.parseDouble(e.getElementsByTagName("TO").item(0).getTextContent());
    }

    public double findValue() {
        double calculatedValue = 0;
        double estimatedFTA = 0;
        double estimatedFTM = 0;
        double estimatedFGA = 0;
        double estimatedFGM = 0;
        rank = 0;
        /**
         * Using Z score to calculate player additive values.
         */
        calculatedValue += (totalPTS-(.878*443.254))/(.878*422) + (totalAST-(.878*97.45))/(.878*114) + (totalREB-(.878*182.138))/(.878*168) + (totalSTL-(.878*30.562))/(.878*27.02) + (totalBLK-(.878*20.098))/(.878*25.12) + (totalTHREES-(.878*47.84))/(.878*55) - (totalTO-(.878*55.326))/(.878*54);
        if (FT == 0) {
            if (POS.equals("C"))
            estimatedFTM += 	0.16426 * totalPTS;
            estimatedFTA = estimatedFTM * (1/FT);
            calculatedValue += (0.774891774892 - ((38664 - estimatedFTM) / (49896 - estimatedFTA)))/0.774891774892;
            if (POS.equals("PF"))
                estimatedFTM += 	0.1579 * totalPTS;
            estimatedFTA = estimatedFTM * (1/FT);
            calculatedValue += (0.774891774892 - ((38664 - estimatedFTM) / (49896 - estimatedFTA)))/0.774891774892;
            if (POS.equals("PG"))
                estimatedFTM += 0.1746 * totalPTS;
            estimatedFTA = estimatedFTM * (1/FT);
            calculatedValue += (0.774891774892 - ((38664 - estimatedFTM) / (49896 - estimatedFTA)))/0.774891774892;
            if (POS.equals("SF"))
                estimatedFTM += 0.1546 * totalPTS;
            estimatedFTA = estimatedFTM * (1/FT);
            calculatedValue += (0.774891774892 - ((38664 - estimatedFTM) / (49896 - estimatedFTA)))/0.774891774892;
            if (POS.equals("SG"))
                estimatedFTM += 0.1483 * totalPTS;
            estimatedFTA = estimatedFTM * (1/FT);
            calculatedValue += (0.774891774892 - ((38664 - estimatedFTM) / (49896 - estimatedFTA)))/0.774891774892;
        }
        if (FG == 0) {
            if (POS.equals("C")) {
                estimatedFGM = .3922 * totalPTS;
                estimatedFGA = estimatedFGM/FG;
                calculatedValue += (.460585585586 - ((176688 - estimatedFGM) / (383616 - estimatedFGA)))/0.460585585586;
            }
            if (POS.equals("C")) {
                estimatedFGM = .3922 * totalPTS;
                estimatedFGA = estimatedFGM/FG;
                calculatedValue += (.460585585586 - ((176688 - estimatedFGM) / (383616 - estimatedFGA)))/0.460585585586;
            }
            if (POS.equals("PF")) {
                estimatedFGM = .3666 * totalPTS;
                estimatedFGA = estimatedFGM/FG;
                calculatedValue += (.460585585586 - ((176688 - estimatedFGM) / (383616 - estimatedFGA)))/0.460585585586;
            }
            if (POS.equals("PG")) {
                estimatedFGM = .3594 * totalPTS;
                estimatedFGA = estimatedFGM/FG;
                calculatedValue += (.460585585586 - ((176688 - estimatedFGM) / (383616 - estimatedFGA)))/0.460585585586;
            }
            if (POS.equals("SF")) {
                estimatedFGM = .3591 * totalPTS;
                estimatedFGA = estimatedFGM/FG;
                calculatedValue += (.460585585586 - ((176688 - estimatedFGM) / (383616 - estimatedFGA)))/0.460585585586;
            }
            if (POS.equals("SG")) {
                estimatedFGM = .3532 * totalPTS;
                estimatedFGA = estimatedFGM/FG;
                calculatedValue += (.460585585586 - ((176688 - estimatedFGM) / (383616 - estimatedFGA)))/0.460585585586;
            }

        }
        return calculatedValue;
    }
    public static Vector<Player> sortByValue(Vector<Player> players) {
        quickSort(players, 0, players.size()-1);
        for (int i = 0; i < players.size(); i++) {
            players.get(i).rank = i + 1;
        }
        return players;
    }
    public static void quickSort(Vector<Player> players, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(players, begin, end);

            quickSort(players, begin, partitionIndex-1);
            quickSort(players, partitionIndex+1, end);
        }
    }
    private static int partition(Vector<Player> players, int begin, int end) {
        double pivot = players.get(end).findValue();
        int i = (begin-1);

        for (int j = begin; j <= end - 1; j++) {
            if (players.get(j).findValue() > pivot) {
                i++;
                Player swapTemp = players.get(i);
                players.set(i, players.get(j));
                players.set(j, swapTemp);
            }
        }

        Player swapTemp = players.get(i+1);
        players.set(i + 1, players.get(end));
        players.set(end, swapTemp);
        return i+1;
    }
}
