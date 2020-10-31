package com.XMLDocument;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "approvedLimit"
})
public class Output {

    @XmlElement(name = "ApprovedLimit", required = true)
    protected BigDecimal approvedLimit;

    public BigDecimal getApprovedLimit() {
        return approvedLimit;
    }

    public void setApprovedLimit(BigDecimal value) {
        this.approvedLimit = value;
    }

}
