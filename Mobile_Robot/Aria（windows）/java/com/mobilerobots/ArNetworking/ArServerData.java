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
public class ArServerData {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  /* for internal use by swig only */
  public ArServerData(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  /* for internal use by swig only */
  public static long getCPtr(ArServerData obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ArNetworkingJavaJNI.delete_ArServerData(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public ArServerData(String name, String description, long command, ArFunctor_ServerData functor, String argumentDescription, String returnDescription, String commandGroup, String dataFlags, SWIGTYPE_p_ArRetFunctor1T_long_unsigned_int_t getFrequencyFunctor, SWIGTYPE_p_ArFunctor2T_long_unsigned_int_t requestChangedFunctor, SWIGTYPE_p_ArRetFunctor2T_bool_ArServerClient_p_ArNetPacket_p_t requestOnceFunctor) {
    this(ArNetworkingJavaJNI.new_ArServerData__SWIG_0(name, description, command, ArFunctor_ServerData.getCPtr(functor), functor, argumentDescription, returnDescription, commandGroup, dataFlags, SWIGTYPE_p_ArRetFunctor1T_long_unsigned_int_t.getCPtr(getFrequencyFunctor), SWIGTYPE_p_ArFunctor2T_long_unsigned_int_t.getCPtr(requestChangedFunctor), SWIGTYPE_p_ArRetFunctor2T_bool_ArServerClient_p_ArNetPacket_p_t.getCPtr(requestOnceFunctor)), true);
  }

  public ArServerData(String name, String description, long command, ArFunctor_ServerData functor, String argumentDescription, String returnDescription, String commandGroup, String dataFlags, SWIGTYPE_p_ArRetFunctor1T_long_unsigned_int_t getFrequencyFunctor, SWIGTYPE_p_ArFunctor2T_long_unsigned_int_t requestChangedFunctor) {
    this(ArNetworkingJavaJNI.new_ArServerData__SWIG_1(name, description, command, ArFunctor_ServerData.getCPtr(functor), functor, argumentDescription, returnDescription, commandGroup, dataFlags, SWIGTYPE_p_ArRetFunctor1T_long_unsigned_int_t.getCPtr(getFrequencyFunctor), SWIGTYPE_p_ArFunctor2T_long_unsigned_int_t.getCPtr(requestChangedFunctor)), true);
  }

  public ArServerData(String name, String description, long command, ArFunctor_ServerData functor, String argumentDescription, String returnDescription, String commandGroup, String dataFlags, SWIGTYPE_p_ArRetFunctor1T_long_unsigned_int_t getFrequencyFunctor) {
    this(ArNetworkingJavaJNI.new_ArServerData__SWIG_2(name, description, command, ArFunctor_ServerData.getCPtr(functor), functor, argumentDescription, returnDescription, commandGroup, dataFlags, SWIGTYPE_p_ArRetFunctor1T_long_unsigned_int_t.getCPtr(getFrequencyFunctor)), true);
  }

  public ArServerData(String name, String description, long command, ArFunctor_ServerData functor, String argumentDescription, String returnDescription, String commandGroup, String dataFlags) {
    this(ArNetworkingJavaJNI.new_ArServerData__SWIG_3(name, description, command, ArFunctor_ServerData.getCPtr(functor), functor, argumentDescription, returnDescription, commandGroup, dataFlags), true);
  }

  public ArServerData(String name, String description, long command, ArFunctor_ServerData functor, String argumentDescription, String returnDescription, String commandGroup) {
    this(ArNetworkingJavaJNI.new_ArServerData__SWIG_4(name, description, command, ArFunctor_ServerData.getCPtr(functor), functor, argumentDescription, returnDescription, commandGroup), true);
  }

  public ArServerData(String name, String description, long command, ArFunctor_ServerData functor, String argumentDescription, String returnDescription) {
    this(ArNetworkingJavaJNI.new_ArServerData__SWIG_5(name, description, command, ArFunctor_ServerData.getCPtr(functor), functor, argumentDescription, returnDescription), true);
  }

  public String getName() {
    return ArNetworkingJavaJNI.ArServerData_getName(swigCPtr, this);
  }

  public String getDescription() {
    return ArNetworkingJavaJNI.ArServerData_getDescription(swigCPtr, this);
  }

  public long getCommand() {
    return ArNetworkingJavaJNI.ArServerData_getCommand(swigCPtr, this);
  }

  public ArFunctor_ServerData getFunctor() {
    long cPtr = ArNetworkingJavaJNI.ArServerData_getFunctor(swigCPtr, this);
    return (cPtr == 0) ? null : new ArFunctor_ServerData(cPtr, false);
  }

  public String getArgumentDescription() {
    return ArNetworkingJavaJNI.ArServerData_getArgumentDescription(swigCPtr, this);
  }

  public String getReturnDescription() {
    return ArNetworkingJavaJNI.ArServerData_getReturnDescription(swigCPtr, this);
  }

  public String getCommandGroup() {
    return ArNetworkingJavaJNI.ArServerData_getCommandGroup(swigCPtr, this);
  }

  public SWIGTYPE_p_ArRetFunctor2T_bool_ArServerClient_p_ArNetPacket_p_t getRequestOnceFunctor() {
    long cPtr = ArNetworkingJavaJNI.ArServerData_getRequestOnceFunctor(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_ArRetFunctor2T_bool_ArServerClient_p_ArNetPacket_p_t(cPtr, false);
  }

  public boolean hasDataFlag(String dataFlag) {
    return ArNetworkingJavaJNI.ArServerData_hasDataFlag(swigCPtr, this, dataFlag);
  }

  public boolean addDataFlags(String dataFlags) {
    return ArNetworkingJavaJNI.ArServerData_addDataFlags(swigCPtr, this, dataFlags);
  }

  public boolean remDataFlag(String dataFlag) {
    return ArNetworkingJavaJNI.ArServerData_remDataFlag(swigCPtr, this, dataFlag);
  }

  public boolean isSlowPacket() {
    return ArNetworkingJavaJNI.ArServerData_isSlowPacket(swigCPtr, this);
  }

  public boolean isIdlePacket() {
    return ArNetworkingJavaJNI.ArServerData_isIdlePacket(swigCPtr, this);
  }

  public String getDataFlagsString() {
    return ArNetworkingJavaJNI.ArServerData_getDataFlagsString(swigCPtr, this);
  }

  public void callRequestChangedFunctor() {
    ArNetworkingJavaJNI.ArServerData_callRequestChangedFunctor(swigCPtr, this);
  }

}
