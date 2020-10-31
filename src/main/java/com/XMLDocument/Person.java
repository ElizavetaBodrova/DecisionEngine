package com.XMLDocument;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "lastName",
        "firstName",
        "patronymic",
        "birthDate",
        "gender",
        "income"
})
public class Person {

    @XmlElement(name = "LastName", required = true)
    protected String lastName;
    @XmlElement(name = "FirstName", required = true)
    protected String firstName;
    @XmlElement(name = "Patronymic", required = true)
    protected String patronymic;
    @XmlElement(name = "BirthDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar birthDate;
    @XmlElement(name = "Gender", required = true)
    protected int gender;
    @XmlElement(name = "Income", required = true)
    protected BigDecimal income;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String value) {
        this.lastName = value;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String value) {
        this.firstName = value;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String value) {
        this.patronymic = value;
    }

    public XMLGregorianCalendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(XMLGregorianCalendar value) {
        this.birthDate = value;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int value) {
        this.gender = value;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal value) {
        this.income = value;
    }

}
