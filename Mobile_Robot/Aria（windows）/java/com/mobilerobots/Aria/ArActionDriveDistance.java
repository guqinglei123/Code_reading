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

public class ArActionDriveDistance extends ArAction {
  /* (begin code from javabody_derived typemap) */

  private long swigCPtr;

  /* for internal use by swig only */
  public ArActionDriveDistance(long cPtr, boolean cMemoryOwn) {
    super(AriaJavaJNI.SWIGArActionDriveDistanceUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  /* for internal use by swig only */
  public static long getCPtr(ArActionDriveDistance obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  /* (end code from javabody_derived typemap) */

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        AriaJavaJNI.delete_ArActionDriveDistance(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public ArActionDriveDistance(String name, double speed, double deceleration) {
    this(AriaJavaJNI.new_ArActionDriveDistance__SWIG_0(name, speed, deceleration), true);
  }

  public ArActionDriveDistance(String name, double speed) {
    this(AriaJavaJNI.new_ArActionDriveDistance__SWIG_1(name, speed), true);
  }

  public ArActionDriveDistance(String name) {
    this(AriaJavaJNI.new_ArActionDriveDistance__SWIG_2(name), true);
  }

  public ArActionDriveDistance() {
    this(AriaJavaJNI.new_ArActionDriveDistance__SWIG_3(), true);
  }

  public boolean haveAchievedDistance() {
    return AriaJavaJNI.ArActionDriveDistance_haveAchievedDistance(swigCPtr, this);
  }

  public void cancelDistance() {
    AriaJavaJNI.ArActionDriveDistance_cancelDistance(swigCPtr, this);
  }

  public void setDistance(double distance, boolean useEncoders) {
    AriaJavaJNI.ArActionDriveDistance_setDistance__SWIG_0(swigCPtr, this, distance, useEncoders);
  }

  public void setDistance(double distance) {
    AriaJavaJNI.ArActionDriveDistance_setDistance__SWIG_1(swigCPtr, this, distance);
  }

  public boolean usingEncoders() {
    return AriaJavaJNI.ArActionDriveDistance_usingEncoders(swigCPtr, this);
  }

  public void setSpeed(double speed) {
    AriaJavaJNI.ArActionDriveDistance_setSpeed__SWIG_0(swigCPtr, this, speed);
  }

  public void setSpeed() {
    AriaJavaJNI.ArActionDriveDistance_setSpeed__SWIG_1(swigCPtr, this);
  }

  public double getSpeed() {
    return AriaJavaJNI.ArActionDriveDistance_getSpeed(swigCPtr, this);
  }

  public void setDeceleration(double deceleration) {
    AriaJavaJNI.ArActionDriveDistance_setDeceleration__SWIG_0(swigCPtr, this, deceleration);
  }

  public void setDeceleration() {
    AriaJavaJNI.ArActionDriveDistance_setDeceleration__SWIG_1(swigCPtr, this);
  }

  public double getDeceleration() {
    return AriaJavaJNI.ArActionDriveDistance_getDeceleration(swigCPtr, this);
  }

  public void setPrinting(boolean printing) {
    AriaJavaJNI.ArActionDriveDistance_setPrinting(swigCPtr, this, printing);
  }

  public ArActionDesired fire(ArActionDesired currentDesired) {
    long cPtr = AriaJavaJNI.ArActionDriveDistance_fire(swigCPtr, this, ArActionDesired.getCPtr(currentDesired), currentDesired);
    return (cPtr == 0) ? null : new ArActionDesired(cPtr, false);
  }

  public ArActionDesired getDesired() {
    long cPtr = AriaJavaJNI.ArActionDriveDistance_getDesired(swigCPtr, this);
    return (cPtr == 0) ? null : new ArActionDesired(cPtr, false);
  }

}
