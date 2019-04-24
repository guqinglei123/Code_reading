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

package com.mobilerobots.Aria;

public class ArActionDesiredChannel {
  /* (begin code from javabody typemap) */

  private long swigCPtr;
  protected boolean swigCMemOwn;

  /* for internal use by swig only */
  public ArActionDesiredChannel(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  /* for internal use by swig only */
  public static long getCPtr(ArActionDesiredChannel obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  /* (end code from javabody typemap) */

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        AriaJavaJNI.delete_ArActionDesiredChannel(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public static double getNO_STRENGTH() {
    return AriaJavaJNI.ArActionDesiredChannel_NO_STRENGTH_get();
  }

  public static double getMIN_STRENGTH() {
    return AriaJavaJNI.ArActionDesiredChannel_MIN_STRENGTH_get();
  }

  public static double getMAX_STRENGTH() {
    return AriaJavaJNI.ArActionDesiredChannel_MAX_STRENGTH_get();
  }

  public ArActionDesiredChannel() {
    this(AriaJavaJNI.new_ArActionDesiredChannel(), true);
  }

  public void setOverrideDoesLessThan(boolean overrideDoesLessThan) {
    AriaJavaJNI.ArActionDesiredChannel_setOverrideDoesLessThan(swigCPtr, this, overrideDoesLessThan);
  }

  public void setDesired(double desired, double desiredStrength, boolean allowOverride) {
    AriaJavaJNI.ArActionDesiredChannel_setDesired__SWIG_0(swigCPtr, this, desired, desiredStrength, allowOverride);
  }

  public void setDesired(double desired, double desiredStrength) {
    AriaJavaJNI.ArActionDesiredChannel_setDesired__SWIG_1(swigCPtr, this, desired, desiredStrength);
  }

  public double getDesired() {
    return AriaJavaJNI.ArActionDesiredChannel_getDesired(swigCPtr, this);
  }

  public double getStrength() {
    return AriaJavaJNI.ArActionDesiredChannel_getStrength(swigCPtr, this);
  }

  public double getAllowOverride() {
    return AriaJavaJNI.ArActionDesiredChannel_getAllowOverride(swigCPtr, this);
  }

  public void reset() {
    AriaJavaJNI.ArActionDesiredChannel_reset(swigCPtr, this);
  }

  public void merge(ArActionDesiredChannel desiredChannel) {
    AriaJavaJNI.ArActionDesiredChannel_merge(swigCPtr, this, ArActionDesiredChannel.getCPtr(desiredChannel), desiredChannel);
  }

  public void startAverage() {
    AriaJavaJNI.ArActionDesiredChannel_startAverage(swigCPtr, this);
  }

  public void addAverage(ArActionDesiredChannel desiredChannel) {
    AriaJavaJNI.ArActionDesiredChannel_addAverage(swigCPtr, this, ArActionDesiredChannel.getCPtr(desiredChannel), desiredChannel);
  }

  public void endAverage() {
    AriaJavaJNI.ArActionDesiredChannel_endAverage(swigCPtr, this);
  }

  public void checkLowerBound(String actionName, String typeName, int lowerBound) {
    AriaJavaJNI.ArActionDesiredChannel_checkLowerBound(swigCPtr, this, actionName, typeName, lowerBound);
  }

  public void checkUpperBound(String actionName, String typeName, int upperBound) {
    AriaJavaJNI.ArActionDesiredChannel_checkUpperBound(swigCPtr, this, actionName, typeName, upperBound);
  }

}
