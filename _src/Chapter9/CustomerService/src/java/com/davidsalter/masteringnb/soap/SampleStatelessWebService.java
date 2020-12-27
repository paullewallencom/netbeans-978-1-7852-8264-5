/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidsalter.masteringnb.soap;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.jws.HandlerChain;

/**
 *
 * @author david
 */
@WebService(serviceName = "SampleStatelessWebService")
@Stateless()
@HandlerChain(file = "SampleStatelessWebService_handler.xml")
public class SampleStatelessWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "goodbye")
    public String goodbye(@WebParam(name = "name") final String name) throws UnsupportedOperationException {
        //TODO write your implementation code here:
        return null;
    }
}
