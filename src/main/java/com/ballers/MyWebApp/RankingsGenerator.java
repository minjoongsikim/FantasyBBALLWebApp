package com.ballers.MyWebApp;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import static java.lang.Integer.parseInt;

/*
Creating the functions to sort the player base in the way the player desires.
 */
public class RankingsGenerator {
    public static Element[] sortByRank(Node[] array, String cat) {
        Element[] eArray = new Element[array.length];
        for (int i = 0; i < array.length; i ++) {
            eArray[i] = (Element) array[i];
        }


        String s = eArray[0].getElementsByTagName(cat).item(0).getTextContent();
        quickSort(eArray, 0, eArray.length - 1, cat);
        System.out.println(eArray[425].getElementsByTagName("name").item(0).getTextContent() + " " + eArray[423].getElementsByTagName("name").item(0).getTextContent()
                + " " + eArray[424].getElementsByTagName("name").item(0).getTextContent());
        return eArray;
    }
    public static void quickSort(Element arr[], int begin, int end, String cat) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end, cat);

            quickSort(arr, begin, partitionIndex-1, cat);
            quickSort(arr, partitionIndex+1, end, cat);
        }
    }
    private static int partition(Element arr[], int begin, int end, String cat) {
        int pivot = parseInt(arr[end].getElementsByTagName(cat).item(0).getTextContent());
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (parseInt(arr[j].getElementsByTagName(cat).item(0).getTextContent()) <= pivot) {
                i++;

                Element swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        Element swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }

}
