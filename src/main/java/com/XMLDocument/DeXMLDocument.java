package com.XMLDocument;//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.10.25 at 07:13:35 PM MSK 
//


import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "applicationId",
    "person",
    "control",
    "output"
})
@XmlRootElement(name = "com.XMLDocument.DeXMLDocument")
public class DeXMLDocument {

    @XmlElement(name = "ApplicationId", required = true)
    protected String applicationId;
    @XmlElement(name = "Person", required = true)
    protected Person person;
    @XmlElement(name = "Control", required = true)
    protected Control control;
    @XmlElement(name = "Output", required = true)
    protected Output output;


    public String getApplicationId() {
        return applicationId;
    }


    public void setApplicationId(String value) {
        this.applicationId = value;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person value) {
        this.person = value;
    }


    public Control getControl() {
        return control;
    }

    public void setControl(Control value) {
        this.control = value;
    }

    public Output getOutput() {
        return output;
    }

    public void setOutput(Output value) {
        this.output = value;
    }




}