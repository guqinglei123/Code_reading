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
public class ArClientArg {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  /* for internal use by swig only */
  public ArClientArg(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  /* for internal use by swig only */
  public static long getCPtr(ArClientArg obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ArNetworkingJavaJNI.delete_ArClientArg(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public ArClientArg(boolean isDisplayHintParsed, ArPriority.Priority lastPriority, int version, boolean isSingleParam) {
    this(ArNetworkingJavaJNI.new_ArClientArg__SWIG_0(isDisplayHintParsed, lastPriority.swigValue(), version, isSingleParam), true);
  }

  public ArClientArg(boolean isDisplayHintParsed, ArPriority.Priority lastPriority, int version) {
    this(ArNetworkingJavaJNI.new_ArClientArg__SWIG_1(isDisplayHintParsed, lastPriority.swigValue(), version), true);
  }

  public ArClientArg(boolean isDisplayHintParsed, ArPriority.Priority lastPriority) {
    this(ArNetworkingJavaJNI.new_ArClientArg__SWIG_2(isDisplayHintParsed, lastPriority.swigValue()), true);
  }

  public ArClientArg(boolean isDisplayHintParsed) {
    this(ArNetworkingJavaJNI.new_ArClientArg__SWIG_3(isDisplayHintParsed), true);
  }

  public ArClientArg() {
    this(ArNetworkingJavaJNI.new_ArClientArg__SWIG_4(), true);
  }

  public static boolean isSendableParamType(ArConfigArg arg, boolean isIncludeSeparator) {
    return ArNetworkingJavaJNI.ArClientArg_isSendableParamType__SWIG_0(ArConfigArg.getCPtr(arg), arg, isIncludeSeparator);
  }

  public static boolean isSendableParamType(ArConfigArg arg) {
    return ArNetworkingJavaJNI.ArClientArg_isSendableParamType__SWIG_1(ArConfigArg.getCPtr(arg), arg);
  }

  public boolean createArg(ArNetPacket packet, ArConfigArg argOut, SWIGTYPE_p_std__string parentPathNameOut) {
    return ArNetworkingJavaJNI.ArClientArg_createArg__SWIG_0(swigCPtr, this, ArNetPacket.getCPtr(packet), packet, ArConfigArg.getCPtr(argOut), argOut, SWIGTYPE_p_std__string.getCPtr(parentPathNameOut));
  }

  public boolean createArg(ArNetPacket packet, ArConfigArg argOut) {
    return ArNetworkingJavaJNI.ArClientArg_createArg__SWIG_1(swigCPtr, this, ArNetPacket.getCPtr(packet), packet, ArConfigArg.getCPtr(argOut), argOut);
  }

  public boolean createPacket(ArConfigArg arg, ArNetPacket packet, String parentPathName) {
    return ArNetworkingJavaJNI.ArClientArg_createPacket__SWIG_0(swigCPtr, this, ArConfigArg.getCPtr(arg), arg, ArNetPacket.getCPtr(packet), packet, parentPathName);
  }

  public boolean createPacket(ArConfigArg arg, ArNetPacket packet) {
    return ArNetworkingJavaJNI.ArClientArg_createPacket__SWIG_1(swigCPtr, this, ArConfigArg.getCPtr(arg), arg, ArNetPacket.getCPtr(packet), packet);
  }

  public boolean bufToArgValue(ArNetPacket packet, ArConfigArg arg) {
    return ArNetworkingJavaJNI.ArClientArg_bufToArgValue(swigCPtr, this, ArNetPacket.getCPtr(packet), packet, ArConfigArg.getCPtr(arg), arg);
  }

  public boolean argValueToBuf(ArConfigArg arg, ArNetPacket packet) {
    return ArNetworkingJavaJNI.ArClientArg_argValueToBuf(swigCPtr, this, ArConfigArg.getCPtr(arg), arg, ArNetPacket.getCPtr(packet), packet);
  }

  public boolean argTextToBuf(ArConfigArg arg, ArNetPacket packet) {
    return ArNetworkingJavaJNI.ArClientArg_argTextToBuf(swigCPtr, this, ArConfigArg.getCPtr(arg), arg, ArNetPacket.getCPtr(packet), packet);
  }

  public boolean addArgTextToPacket(ArConfigArg arg, ArNetPacket packet) {
    return ArNetworkingJavaJNI.ArClientArg_addArgTextToPacket(swigCPtr, this, ArConfigArg.getCPtr(arg), arg, ArNetPacket.getCPtr(packet), packet);
  }

  public boolean addAncestorListToPacket(SWIGTYPE_p_std__listT_ArConfigArg_p_t ancestorList, ArNetPacket packet) {
    return ArNetworkingJavaJNI.ArClientArg_addAncestorListToPacket(swigCPtr, this, SWIGTYPE_p_std__listT_ArConfigArg_p_t.getCPtr(ancestorList), ArNetPacket.getCPtr(packet), packet);
  }

  public boolean addListBeginToPacket(ArConfigArg parentArg, ArNetPacket packet) {
    return ArNetworkingJavaJNI.ArClientArg_addListBeginToPacket(swigCPtr, this, ArConfigArg.getCPtr(parentArg), parentArg, ArNetPacket.getCPtr(packet), packet);
  }

  public boolean addListEndToPacket(ArConfigArg parentArg, ArNetPacket packet) {
    return ArNetworkingJavaJNI.ArClientArg_addListEndToPacket(swigCPtr, this, ArConfigArg.getCPtr(parentArg), parentArg, ArNetPacket.getCPtr(packet), packet);
  }

}
