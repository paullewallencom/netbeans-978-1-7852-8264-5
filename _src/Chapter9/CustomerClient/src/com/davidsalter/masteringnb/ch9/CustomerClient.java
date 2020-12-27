/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidsalter.masteringnb.ch9;

/**
 *
 * @author david
 */
public class CustomerClient {

    public static void main(String[] args) {
        System.out.println(hello("David"));
    }

    private static String hello(java.lang.String name) {
        com.davidsalter.masteringnb.ch9.soapclient.SampleStatelessWebService_Service service = new com.davidsalter.masteringnb.ch9.soapclient.SampleStatelessWebService_Service();
        com.davidsalter.masteringnb.ch9.soapclient.SampleStatelessWebService port = service.getSampleStatelessWebServicePort();
        return port.hello(name);
    }
}
