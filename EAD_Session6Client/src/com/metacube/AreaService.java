/**
 * AreaService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.metacube;

public interface AreaService extends javax.xml.rpc.Service {
    public java.lang.String getAreaAddress();

    public com.metacube.Area getArea() throws javax.xml.rpc.ServiceException;

    public com.metacube.Area getArea(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
