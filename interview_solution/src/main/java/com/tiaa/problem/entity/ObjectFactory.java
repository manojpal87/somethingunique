//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.08.05 at 04:29:03 PM IST 
//


package com.tiaa.problem.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tiaa.problem.entity package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Cmfoodchain_QNAME = new QName("", "cmfoodchain");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tiaa.problem.entity
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CmfoodchainType }
     * 
     */
    public CmfoodchainType createCmfoodchainType() {
        return new CmfoodchainType();
    }

    /**
     * Create an instance of {@link OrderdetailType }
     * 
     */
    public OrderdetailType createOrderdetailType() {
        return new OrderdetailType();
    }

    /**
     * Create an instance of {@link BranchType }
     * 
     */
    public BranchType createBranchType() {
        return new BranchType();
    }

    /**
     * Create an instance of {@link OrdersType }
     * 
     */
    public OrdersType createOrdersType() {
        return new OrdersType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CmfoodchainType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "cmfoodchain")
    public JAXBElement<CmfoodchainType> createCmfoodchain(CmfoodchainType value) {
        return new JAXBElement<CmfoodchainType>(_Cmfoodchain_QNAME, CmfoodchainType.class, null, value);
    }

}
