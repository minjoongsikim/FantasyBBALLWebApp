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

        if (cat.equals("name") || cat.equals("team") || cat.equals("position")) {
            stringQuickSort(eArray, 0, eArray.length - 1, cat);
        } else {
            quickSort(eArray, 0, eArray.length - 1, cat);
        }
        for (int i = 0; i < array.length; i ++) {
            System.out.println(eArray[i].getElementsByTagName("name").item(0).getTextContent());
            System.out.println(eArray[i].getElementsByTagName(cat).item(0).getTextContent());
        }
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
        double pivot = Double.parseDouble(arr[end].getElementsByTagName(cat).item(0).getTextContent());
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (Double.parseDouble(arr[j].getElementsByTagName(cat).item(0).getTextContent()) >= pivot) {
                i++;

                Element swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            } else if (Double.parseDouble(arr[j].getElementsByTagName(cat).item(0).getTextContent()) == pivot) {
                if (arr[i].getElementsByTagName("name").item(0).getTextContent().compareTo(arr[end].getElementsByTagName("name").item(0).getTextContent()) < 0) {
                    i++;

                    Element swapTemp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = swapTemp;
                }
            }

                Element swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
        }

        Element swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
    public static void stringQuickSort(Element arr[], int begin, int end, String cat) {
        if (begin < end) {
            int partitionIndex = stringPartition(arr, begin, end, cat);

            stringQuickSort(arr, begin, partitionIndex-1, cat);
            stringQuickSort(arr, partitionIndex+1, end, cat);
        }
    }
    private static int stringPartition(Element arr[], int begin, int end, String cat) {
        String pivot = arr[end].getElementsByTagName(cat).item(0).getTextContent();
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j].getElementsByTagName(cat).item(0).getTextContent().compareTo(pivot) < 0) {
                i++;

                Element swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            } else if (arr[j].getElementsByTagName(cat).item(0).getTextContent().compareTo(pivot) == 0) {
                if (arr[j].getElementsByTagName("name").item(0).getTextContent().compareTo(arr[end].getElementsByTagName("name").item(0).getTextContent()) < 0) {
                    i++;
                    Element swapTemp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = swapTemp;
                }
            }
        }

        Element swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
}
