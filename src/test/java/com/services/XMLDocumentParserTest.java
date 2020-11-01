package com.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import ru.neoflex.xmodel.de.DeXMLDocument;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.*;
import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {XMLDocumentParser.class},
        initializers = ConfigFileApplicationContextInitializer.class)
public class XMLDocumentParserTest {
    @Autowired
    private XMLDocumentParser xmlDocumentParser;

    @Test
    public void parseToObject() throws JAXBException {
        String document = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<ns2:DeXMLDocument xmlns:ns2=\"http://neoflex.ru/xModel/DE\">\n" +
                "  <ApplicationId>\"1\"</ApplicationId>\n" +
                "  <Person>\n" +
                "    <LastName>str1234</LastName>\n" +
                "    <FirstName>str1234</FirstName>\n" +
                "    <Patronymic>str1234</Patronymic>\n" +
                "    <BirthDate>2012-12-13</BirthDate>\n" +
                "    <Gender>1</Gender>\n" +
                "    <Income>300000</Income>\n" +
                "  </Person>\n" +
                "  <Control>\n" +
                "    <ErrorCode></ErrorCode>\n" +
                "    <ErrorMsg></ErrorMsg>\n" +
                "  </Control>\n" +
                "  <Output>\n" +
                "    <ApprovedLimit></ApprovedLimit>\n" +
                "  </Output>\n" +
                "</ns2:DeXMLDocument>";
        DeXMLDocument deXMLDocument = xmlDocumentParser.parseToObject(new ByteArrayInputStream(document.getBytes()));

    }

    @Test
    public void parseToXML() throws DatatypeConfigurationException, IOException, JAXBException {
        DeXMLDocument deXMLDocument = new DeXMLDocument();
        deXMLDocument.setApplicationId("1");
        DeXMLDocument.Person person = new DeXMLDocument.Person();
        person.setFirstName("firstname");
        person.setGender(1);
        person.setIncome(BigDecimal.valueOf(300000));
        XMLGregorianCalendar xmlGregorianCalendar =
                DatatypeFactory.newInstance().newXMLGregorianCalendar("2000-10-10");
        person.setBirthDate(xmlGregorianCalendar);
        deXMLDocument.setPerson(person);
        DeXMLDocument.Output output = new DeXMLDocument.Output();
        output.setApprovedLimit(BigDecimal.valueOf(0));
        deXMLDocument.setOutput(output);
        File file = File.createTempFile("xmlfile", ".xml");
        file.deleteOnExit();
        String xml = xmlDocumentParser.parseToXML(deXMLDocument);
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(xml.getBytes());
        }

    }

    @Test
    public void initialize() {
        Assert.assertNotNull(xmlDocumentParser);
    }
}