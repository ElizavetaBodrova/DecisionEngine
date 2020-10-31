package com.services;

import com.XMLDocument.DeXMLDocument;
import org.springframework.stereotype.Service;

import javax.xml.bind.*;
import javax.xml.transform.dom.DOMResult;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

@Service
public class XMLDocumentParser {

    public DeXMLDocument parseToObject(InputStream xmlReport) throws JAXBException {
        JAXBContext context  = JAXBContext.newInstance("com/XMLDocument");

        Unmarshaller unmarshaller = context.createUnmarshaller();

        JAXBElement<?> element = (JAXBElement<?>) unmarshaller.unmarshal(xmlReport);

        return (DeXMLDocument) element.getValue();
    }

    public String parseToXML(DeXMLDocument deXMLDocument) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance("com/XMLDocument");

        Marshaller marshaller = context.createMarshaller();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        DOMResult domResult = new DOMResult();
        marshaller.marshal(deXMLDocument, domResult);
        return os.toString();
        
    }

}
