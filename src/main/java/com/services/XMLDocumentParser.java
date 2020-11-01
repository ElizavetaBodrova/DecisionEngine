package com.services;


import org.springframework.stereotype.Service;
import ru.neoflex.xmodel.de.DeXMLDocument;

import javax.xml.bind.*;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

@Service
public class XMLDocumentParser {

    public DeXMLDocument parseToObject(InputStream xmlReport) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance("ru.neoflex.xmodel.de");

        Unmarshaller unmarshaller = context.createUnmarshaller();

        return (DeXMLDocument) unmarshaller.unmarshal(xmlReport);
    }

    public String parseToXML(DeXMLDocument deXMLDocument) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance("ru.neoflex.xmodel.de");

        Marshaller marshaller = context.createMarshaller();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        marshaller.marshal(deXMLDocument, new StreamResult(os));
        return os.toString();

    }

}
