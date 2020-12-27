/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidsalter.masteringnb.soap;

import com.davidsalter.masteringnb.ejb.WelcomeSessionBean;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author david
 */
@WebService(serviceName = "SampleWebServiceFromEJB")
public class SampleWebServiceFromEJB {
    @EJB
    private WelcomeSessionBean ejbRef;

    @WebMethod(operationName = "sayHello")
    public String sayHello(@WebParam(name = "name") String name) {
        return ejbRef.sayHello(name);
    }
}
