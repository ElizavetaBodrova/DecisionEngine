package com.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.services.DecisionEngine;

import javax.xml.bind.JAXBException;

@Controller
public class controller {

    private DecisionEngine decisionEngine;

    @Autowired
    public controller(DecisionEngine decisionEngine){
        this.decisionEngine =decisionEngine;
    }

    @RequestMapping(value="/", method = RequestMethod.POST,
                    consumes = "text/xml")
    public @ResponseBody String calcAvailableLimit(@RequestBody String xmlDocument) throws JAXBException {
        String resultDocument= decisionEngine.addControlAndOutput(xmlDocument);
        return resultDocument;
    }




}
