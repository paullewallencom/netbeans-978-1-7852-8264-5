/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidsalter.masteringnb.ch9.wsdl;

import com.davidsalter.helloservice.HelloResponse;
import javax.jws.WebService;
import javax.xml.ws.BindingType;

/**
 *
 * @author david
 */
@WebService(serviceName = "helloService", portName = "helloPort", endpointInterface = "com.davidsalter.helloservice.HelloPortType", targetNamespace = "http://www.davidsalter.com/HelloService/", wsdlLocation = "WEB-INF/wsdl/SampleWebServiceFromWSDL/WebService.wsdl")
@BindingType(value = "http://java.sun.com/xml/ns/jaxws/2003/05/soap/bindings/HTTP/")
public class SampleWebServiceFromWSDL {

    public com.davidsalter.helloservice.HelloResponse greetings(com.davidsalter.helloservice.HelloRequest helloInputPart) {
        HelloResponse response = new HelloResponse();
        response.setGreeting("Hi!!");
        return response;
    }
}
