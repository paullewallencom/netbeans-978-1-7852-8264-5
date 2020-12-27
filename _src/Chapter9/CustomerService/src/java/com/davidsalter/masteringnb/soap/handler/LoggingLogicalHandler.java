/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidsalter.masteringnb.soap.handler;

import javax.xml.ws.LogicalMessage;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author david
 */
public class LoggingLogicalHandler implements LogicalHandler<LogicalMessageContext> {
    
    public boolean handleMessage(LogicalMessageContext messageContext) {
        LogicalMessage msg = messageContext.getMessage();
        return true;
    }
    
    public boolean handleFault(LogicalMessageContext messageContext) {
        return true;
    }
    
    public void close(MessageContext context) {
    }
    
}
