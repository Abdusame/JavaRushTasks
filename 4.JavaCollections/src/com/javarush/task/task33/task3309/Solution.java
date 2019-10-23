package com.javarush.task.task33.task3309;

import org.w3c.dom.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.ArrayDeque;
import java.util.Queue;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, ParserConfigurationException, TransformerException {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        marshaller.marshal(obj, doc);

        Node root = doc.getDocumentElement();
        if(root.hasChildNodes()) {
            Queue<NodeList> queue = new ArrayDeque<>();
            queue.offer(root.getChildNodes());
            while (!queue.isEmpty()) {
                NodeList list = queue.poll();
                for (int i = 0; i<list.getLength(); i++){
                    Node node = list.item(i);
                    if(node.hasChildNodes()){
                        queue.offer(node.getChildNodes());
                    }

                    if(Node.TEXT_NODE == node.getNodeType()){
                        String text = node.getTextContent();
                        if(text.contains("<") || text.contains(">") || text.contains("&")
                                || text.contains("\'") || text.contains("\"")){
                            Node parent = node.getParentNode();
                            parent.appendChild(doc.createCDATASection(node.getTextContent()));
                            parent.removeChild(node);
                        }

                    }
                }
            }

        }

        doc.normalize();

        NodeList list = doc.getElementsByTagName(tagName);
        for(int i = 0; i<list.getLength(); i++) {
            Node node = list.item(i);
            if (node.getNodeName().equals(tagName)) {
                node.getParentNode().insertBefore(doc.createComment(comment), node);
            }
        }
        doc.normalize();

        //Output the document
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "no");

        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(doc), new StreamResult(writer));

        return writer.toString();
    }

    public static void main(String[] args) throws TransformerException, JAXBException, ParserConfigurationException {
        System.out.println(toXmlWithComment(new First(), "second", "it's a comment"));
    }
}
