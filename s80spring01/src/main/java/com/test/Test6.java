package com.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test6 {
    public static void main(String[] args) throws DocumentException, IOException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("C:\\Users\\Mr胡\\Desktop\\a.xml"));

       Element element = (Element) document.selectSingleNode("books/book[@id='4']");
        if(element==null){
            System.out.println("找不到");
            return ;
        }

      element.getParent().remove(element);

        XMLWriter xmlWriter = new XMLWriter(new FileWriter("C:\\Users\\Mr胡\\Desktop\\a.xml"), OutputFormat.createPrettyPrint());
        xmlWriter.write(document);
        xmlWriter.close();





    }
}
