/*
Adept MobileRobots Robotics Interface for Applications (ARIA)
Copyright (C) 2004-2005 ActivMedia Robotics LLC
Copyright (C) 2006-2010 MobileRobots Inc.
Copyright (C) 2011-2014 Adept Technology

     This program is free software; you can redistribute it and/or modify
     it under the terms of the GNU General Public License as published by
     the Free Software Foundation; either version 2 of the License, or
     (at your option) any later version.

     This program is distributed in the hope that it will be useful,
     but WITHOUT ANY WARRANTY; without even the implied warranty of
     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
     GNU General Public License for more details.

     You should have received a copy of the GNU General Public License
     along with this program; if not, write to the Free Software
     Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

If you wish to redistribute ARIA under different terms, contact 
Adept MobileRobots for information about a commercial version of ARIA at 
robots@mobilerobots.com or 
Adept MobileRobots, 10 Columbia Drive, Amherst, NH 03031; +1-603-881-7960
*/
/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.40
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.mobilerobots.ArNetworking;
import com.mobilerobots.Aria.*;
public class ArServerSimpleOpener {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  /* for internal use by swig only */
  public ArServerSimpleOpener(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  /* for internal use by swig only */
  public static long getCPtr(ArServerSimpleOpener obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ArNetworkingJavaJNI.delete_ArServerSimpleOpener(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public ArServerSimpleOpener(ArArgumentParser parser, String prefix, boolean addAriaCallbacks) {
    this(ArNetworkingJavaJNI.new_ArServerSimpleOpener__SWIG_0(ArArgumentParser.getCPtr(parser), parser, prefix, addAriaCallbacks), true);
  }

  public ArServerSimpleOpener(ArArgumentParser parser, String prefix) {
    this(ArNetworkingJavaJNI.new_ArServerSimpleOpener__SWIG_1(ArArgumentParser.getCPtr(parser), parser, prefix), true);
  }

  public ArServerSimpleOpener(ArArgumentParser parser) {
    this(ArNetworkingJavaJNI.new_ArServerSimpleOpener__SWIG_2(ArArgumentParser.getCPtr(parser), parser), true);
  }

  public boolean open(ArServerBase server, String baseDirectory, int secondsToTryFor) {
    return ArNetworkingJavaJNI.ArServerSimpleOpener_open__SWIG_0(swigCPtr, this, ArServerBase.getCPtr(server), server, baseDirectory, secondsToTryFor);
  }

  public boolean open(ArServerBase server, String baseDirectory) {
    return ArNetworkingJavaJNI.ArServerSimpleOpener_open__SWIG_1(swigCPtr, this, ArServerBase.getCPtr(server), server, baseDirectory);
  }

  public boolean open(ArServerBase server) {
    return ArNetworkingJavaJNI.ArServerSimpleOpener_open__SWIG_2(swigCPtr, this, ArServerBase.getCPtr(server), server);
  }

  public boolean parseArgs() {
    return ArNetworkingJavaJNI.ArServerSimpleOpener_parseArgs__SWIG_0(swigCPtr, this);
  }

  public boolean parseArgs(ArArgumentParser parser) {
    return ArNetworkingJavaJNI.ArServerSimpleOpener_parseArgs__SWIG_1(swigCPtr, this, ArArgumentParser.getCPtr(parser), parser);
  }

  public void logOptions() {
    ArNetworkingJavaJNI.ArServerSimpleOpener_logOptions(swigCPtr, this);
  }

  public boolean checkAndLog() {
    return ArNetworkingJavaJNI.ArServerSimpleOpener_checkAndLog(swigCPtr, this);
  }

  public boolean wasUserFileBad() {
    return ArNetworkingJavaJNI.ArServerSimpleOpener_wasUserFileBad(swigCPtr, this);
  }

  public boolean didOpenFail() {
    return ArNetworkingJavaJNI.ArServerSimpleOpener_didOpenFail(swigCPtr, this);
  }

  public int getPort() {
    return ArNetworkingJavaJNI.ArServerSimpleOpener_getPort(swigCPtr, this);
  }

  public void setDefaultPort(int port) {
    ArNetworkingJavaJNI.ArServerSimpleOpener_setDefaultPort(swigCPtr, this, port);
  }

  public boolean parseFile(String fileName) {
    return ArNetworkingJavaJNI.ArServerSimpleOpener_parseFile(swigCPtr, this, fileName);
  }

  public void setServerTcpOnly(boolean serverTcpOnly) {
    ArNetworkingJavaJNI.ArServerSimpleOpener_setServerTcpOnly(swigCPtr, this, serverTcpOnly);
  }

  public String getServerKey() {
    return ArNetworkingJavaJNI.ArServerSimpleOpener_getServerKey(swigCPtr, this);
  }

}
