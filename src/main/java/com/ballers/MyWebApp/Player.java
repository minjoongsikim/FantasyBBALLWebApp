package com.ballers.MyWebApp;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

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

    public Player(Element e) {
        NAME = e.getElementsByTagName("name").item(0).getTextContent();
        TEAM = e.getElementsByTagName("team").item(0).getTextContent();
        POS = e.getElementsByTagName("position").item(0).getTextContent();
        GAMES = Integer.parseInt(e.getElementsByTagName("Games").item(0).getTextContent());
        PTS = Math.floor(Double.parseDouble(e.getElementsByTagName("PTS").item(0).getTextContent()) / GAMES * 100) / 100;
        AST = Math.floor(Double.parseDouble(e.getElementsByTagName("AST").item(0).getTextContent()) / GAMES * 100) / 100;
        REB = Math.floor(Double.parseDouble(e.getElementsByTagName("REB").item(0).getTextContent()) / GAMES * 100) / 100;
        FG = Double.parseDouble(e.getElementsByTagName("FG").item(0).getTextContent());
        FT = Double.parseDouble(e.getElementsByTagName("FT").item(0).getTextContent());
        STL = Math.floor(Double.parseDouble(e.getElementsByTagName("STL").item(0).getTextContent()) / GAMES * 100) / 100;
        BLK = Math.floor(Double.parseDouble(e.getElementsByTagName("BLK").item(0).getTextContent()) / GAMES * 100) / 100;
        THREES = Math.floor(Double.parseDouble(e.getElementsByTagName("THREES").item(0).getTextContent()) / GAMES * 100) / 100;
        TO = Math.floor(Double.parseDouble(e.getElementsByTagName("TO").item(0).getTextContent()) / GAMES * 100) / 100;
    }

    public double findValue() {
        double calculatedValue = 0;
        double estimatedFTA = 0;
        double estimatedFTM = 0;
        double estimatedFGA = 0;
        double estimatedFGM = 0;
        calculatedValue += PTS / 241488 + AST / 52704 + REB / 96768 + STL / 16416 + BLK / 10584 + THREES / 26352 - TO / 31320;
        if (FT != 0) {
            if (POS.equals("C"))
            estimatedFTM += 	0.16426 * PTS;
            estimatedFTA = estimatedFTM * (1/FT);
            calculatedValue += (0.774891774892 - (38664 - estimatedFTM) / (49896 - estimatedFTA))/0.774891774892;
            if (POS.equals("PF"))
                estimatedFTM += 	0.1579 * PTS;
            estimatedFTA = estimatedFTM * (1/FT);
            calculatedValue += (0.774891774892 - (38664 - estimatedFTM) / (49896 - estimatedFTA))/0.774891774892;
            if (POS.equals("PG"))
                estimatedFTM += 0.1746 * PTS;
            estimatedFTA = estimatedFTM * (1/FT);
            calculatedValue += (0.774891774892 - (38664 - estimatedFTM) / (49896 - estimatedFTA))/0.774891774892;
            if (POS.equals("SF"))
                estimatedFTM += 0.1546 * PTS;
            estimatedFTA = estimatedFTM * (1/FT);
            calculatedValue += (0.774891774892 - (38664 - estimatedFTM) / (49896 - estimatedFTA))/0.774891774892;
            if (POS.equals("SG"))
                estimatedFTM += 0.1483 * PTS;
            estimatedFTA = estimatedFTM * (1/FT);
            calculatedValue += (0.774891774892 - (38664 - estimatedFTM) / (49896 - estimatedFTA))/0.774891774892;
        }
        if (FG != 0) {
            if (POS.equals("C")) {
                estimatedFGM = .3922 * PTS;
                estimatedFGA = estimatedFGM/FG;
                calculatedValue += 0.460 - (176688 - estimatedFGM) / (383616 - estimatedFGA);
            }
        }
        return calculatedValue;
    }
}
