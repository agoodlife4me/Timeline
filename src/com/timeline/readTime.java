package com.timeline;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.Serializable;

public class readTime {
    public static void main(String[] args) {
        try {
            File fKmlTime = new File("c:\\temp\\history-2021-07-06.kml");
            DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbfactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fKmlTime);
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nllist = doc.getElementsByTagName("Placemark");
            System.out.println("Count is " + nllist.getLength());
            for (int temp = 0; temp < nllist.getLength(); temp++){
                Node nNode = nllist.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("Description" + eElement.getElementsByTagName("description").item(0).getTextContent());
//                    System.out.println("Distance "+ eElement.getAttribute("Distance").);
                    String descTxt = eElement.getElementsByTagName("description").item(0).getTextContent();
//                    int sidx = descTxt.indexOf(" from ");
//                    int toidx = descTxt.indexOf(" to ");
//                    int disidx = descTxt.indexOf(" Distance ");
//                    String dName = descTxt.substring(0,sidx);
//                    System.out.println("Description name :" + dName);
//                    String startTxt = descTxt.substring(sidx + 6, toidx);
//                    System.out.println("Start Time: " + startTxt);
//                    String endTxt = descTxt.substring(toidx + 3, disidx);
//                    String DistanceTxt = descTxt.substring(disidx + 10, descTxt.length());
//                    System.out.println("Ending Time : " + endTxt);
//                    System.out.println("Distance Meters: " +  DistanceTxt);

                    Element Extraitems = (Element) eElement.getElementsByTagName("ExtendedData").item(0);
                    NodeList extraList = Extraitems.getElementsByTagName("Data");
                    System.out.println("Count of Extended Data elements " + extraList.getLength());
                    for(int xi = 0;xi < extraList.getLength();xi++){
                        Element xElm = (Element) extraList.item(xi);
                        String wha = xElm.getAttribute("name");
                        System.out.print("Tag name hopefully "+ wha);
                        System.out.println(" value " + xElm.getTextContent());





 //                       System.out.println("Email " + xElm.getElementsByTagName("Email").item(0).getTextContent());
//                        System.out.println("Category " + xElm.getElementsByTagName("Category").item(0).getTextContent());
 //                       System.out.println("Distance  " + xElm.getElementsByTagName("Distance").item(0).getTextContent());

                    }

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class parseDescription implements Serializable {

    String fromDate;
    String toDate;
    String Distance;
    public parseDescription() {
    }
    public parseDescription(String Description){

    }
}