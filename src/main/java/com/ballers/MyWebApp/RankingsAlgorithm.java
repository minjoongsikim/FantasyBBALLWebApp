package com.ballers.MyWebApp;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class RankingsAlgorithm {
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
    public int[] categoryValue(int[] array, Node[] players) {
        int[] errorArray = new int[0];
        Element[] playerArray = new Element[players.length];
        for (int i = 0; i < players.length; i++) {
            playerArray[i] = (Element)players[i];
        }
        if (array.length != 8) {
            System.out.println("Incorrect array size for categories");
            return errorArray;

        }
        for (int i = 0; i < playerArray.length; i++) {
            /**
             * creating additive flat values for each category per player to arrive at composite total.
              */
            double totalValue = 0;
            double PTS = 0;
            double AST = 0;
            double REB = 0;
            double FG = 0;
            double FT = 0;
            double STL = 0;
            double BLK = 0;
            double THREES = 0;
            double TO = 0;
            if (array[0] == 1) {
                PTS += Double.parseDouble(playerArray[i].getElementsByTagName("PTS").item(0).getTextContent());
            }
            if (array[1] == 1) {
                AST += Double.parseDouble(playerArray[i].getElementsByTagName("AST").item(0).getTextContent());
            }
            if (array[2] == 1) {
                REB += Double.parseDouble(playerArray[i].getElementsByTagName("REB").item(0).getTextContent());
            }
            if (array[3] == 1) {
                FG +=  Double.parseDouble(playerArray[i].getElementsByTagName("FG").item(0).getTextContent());
            }
            if (array[4] == 1) {
                FT +=  Double.parseDouble(playerArray[i].getElementsByTagName("FT").item(0).getTextContent());
            }
            if (array[5] == 1) {
                STL +=  Double.parseDouble(playerArray[i].getElementsByTagName("STL").item(0).getTextContent());
            }
            if (array[6] == 1) {
                BLK +=  Double.parseDouble(playerArray[i].getElementsByTagName("BLK").item(0).getTextContent());
            }
            if (array[7] == 1) {
                THREES +=  Double.parseDouble(playerArray[i].getElementsByTagName("THREES").item(0).getTextContent());
            }
            if (array[8] == 1) {
                TO +=  Double.parseDouble(playerArray[i].getElementsByTagName("TO").item(0).getTextContent());
            }
            totalValue = findValue(PTS, AST, REB, FG, FT, STL, BLK, THREES, TO, playerArray[i].getElementsByTagName("position").item(0).getTextContent());
        }
        return array;
    }
    public double findValue(double PTS, double AST,double REB,double FG, double FT, double STL, double BLK, double THREES, double TO, String position) {
        double calculatedValue = 0;
        double estimatedFTA = 0;
        double estimatedFTM = 0;
        double estimatedFGA = 0;
        double estimatedFGM = 0;
        calculatedValue += PTS / 241488 + AST / 52704 + REB / 96768 + STL / 16416 + BLK / 10584 + THREES / 26352 - TO / 31320;
        if (FT != 0) {
            if (position.equals("C"))
            estimatedFTA += .235484821692 * PTS;
            estimatedFTM = estimatedFTA * FT;
            calculatedValue += 0.774891774892 - (38664 - estimatedFTM) / (49896 - estimatedFTA);
        }
        if (FG != 0) {
            //estimatedFGA += .235484821692 * PTS;
            //estimatedFGM = estimatedFGA * FG;
            //calculatedValue += 0.774891774892 - (38664 - estimatedFTM) / (49896 - estimatedFTA);
        }
        return 0;
    }
}
