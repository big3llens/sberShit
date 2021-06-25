package sberApi.parsers;

/**
 * Created by orlovsauser on 27.05.2021.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class XmlParser {
    final static String fileName = "1s.xml";
    static Short i = 0;

    public static XmlItem startProgram (String contactNumber) {
        
        try {
            XMLStreamReader xmlr = XMLInputFactory.newInstance().createXMLStreamReader(fileName, new FileInputStream(fileName));
            XmlItem item = new XmlItem();
            while (xmlr.hasNext()) {
                xmlr.next();
                if (xmlr.isStartElement()) {
                    if (xmlr.getLocalName().equalsIgnoreCase("Value")) {
                        //System.out.println(xmlr.getLocalName());
                        xmlr.next();
                        ++i;

                        if (xmlr.hasText()) {

                            // Заполняем поля класса!
                            switch (i) {
                                case 1:
                                    item.setNomerStroki(xmlr.getText());
                                    break;
                                case 2:
                                    item.setNomerDogovora(xmlr.getText());
                                    break;
                                case 3:
                                    item.setDataDogovora(xmlr.getText().substring(0, 10));
                                    break;
                                case 4:
                                    item.setDeponiruemaiaSumma(xmlr.getText());
                                    break;
                                case 5:
                                    item.setNaimenovanieGK(xmlr.getText());
                                    break;
                                case 6:
                                    item.setNomerUchastka(xmlr.getText());
                                    break;
                                case 7:
                                    item.setUslovnyNomerObiekta(xmlr.getText());
                                    break;
                                case 8:
//                                    item.setDolshik(new java.lang.String(xmlr.getText().getBytes()));
                                    item.setDolshik(xmlr.getText());
                                    break;
                                case 9:
                                    item.setTipDocumenta(xmlr.getText());
                                    break;
                                case 10:
                                    item.setSeriyaDoc(xmlr.getText().replace(" ", ""));
                                    break;
                                case 11:
                                    item.setNomerDoc(xmlr.getText());
                                    break;
                                case 12:
                                    item.setDataVidachiDoc(xmlr.getText().substring(0, 10));
                                    break;
                                case 13:
                                    item.setKemVidanDoc(xmlr.getText());
                                    break;
                                case 14:
                                    item.setAdresRegistracii(xmlr.getText());
                                    break;
                                case 15:
                                    item.setAdresProgivatia(xmlr.getText());
                                    break;
                                case 16:
                                    item.setTelefon(xmlr.getText());
                                    break;
                                case 17:
                                    item.setElektrPochta(xmlr.getText());
                                    break;
                            }
                            //System.out.println("   " + xmlr.getText());
                        }
                    }
                }else if (xmlr.isEndElement()) {
                    if (xmlr.getLocalName().equalsIgnoreCase("row")){

                        //Мы прочитали все поля записи!
                        i = 0;
                        //System.out.println("/" + xmlr.getLocalName());

                        // Выводим на экран содержимое полей класса
//                        System.out.println(item.toString());

                        if (item.getNomerDogovora().equals(contactNumber)){
                            return item;
                        }
                    }
                }
            }
        } catch (XMLStreamException ex) {
            ex.printStackTrace();
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
