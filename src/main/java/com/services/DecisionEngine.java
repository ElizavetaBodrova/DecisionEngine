package com.services;

import com.XMLDocument.Control;
import com.XMLDocument.DeXMLDocument;
import com.XMLDocument.Output;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

@Service
public class DecisionEngine {


    private final XMLDocumentParser xmlDocumentParser;
    private final BigDecimal borderAge= BigDecimal.valueOf(60);
    private final BigDecimal borderAfter= BigDecimal.valueOf(40);
    private final BigDecimal limitBefore= BigDecimal.valueOf(18);

    @Autowired
    public DecisionEngine(XMLDocumentParser xmlDocumentParser) {
        this.xmlDocumentParser = xmlDocumentParser;
    }

    public String addControlAndOutput(String document) throws JAXBException {

        DeXMLDocument deXMLDocument = xmlDocumentParser.parseToObject(new ByteArrayInputStream(document.getBytes()));
        LocalDate birthDate=LocalDate.of(deXMLDocument.getPerson().getBirthDate().getYear(),deXMLDocument.getPerson().getBirthDate().getMonth(),deXMLDocument.getPerson().getBirthDate().getDay());
        int age= Period.between(LocalDate.now(),birthDate).getYears();

        BigDecimal income=deXMLDocument.getPerson().getIncome();
        Output output=new Output();
        addControl(deXMLDocument);
        if(borderAge.compareTo(new BigDecimal(age))>-1){//for granny

            if(income.compareTo(borderAfter)>-1){
                output.setApprovedLimit(income.divide(new BigDecimal(2)));
            }
            else{
                output.setApprovedLimit(new BigDecimal(0));
            }
        }
        else{
            if(income.compareTo(limitBefore)>-1){
                output.setApprovedLimit(income);
            }
            else{
                output.setApprovedLimit(limitBefore);
            }

        }
        deXMLDocument.setOutput(output);

        return xmlDocumentParser.parseToXML(deXMLDocument);
    }

    private void addControl(DeXMLDocument deXMLDocument){
       Control control=new Control();
       if(deXMLDocument.getPerson().getBirthDate()==null){
           control.setErrorCode("101");
           control.setErrorMsg("Null Exception(BirthDay)");
       }
       else if(deXMLDocument.getPerson().getIncome()==null){
           control.setErrorCode("101");
           control.setErrorMsg("Null Exception(Income)");
       }
       else{
           control.setErrorCode("1");
           control.setErrorMsg("");

       }
        deXMLDocument.setControl(control);
    }
}
