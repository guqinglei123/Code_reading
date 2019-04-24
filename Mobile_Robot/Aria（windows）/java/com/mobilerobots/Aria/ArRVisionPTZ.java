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

public class ArRVisionPTZ extends ArPTZ {
  /* (begin code from javabody_derived typemap) */

  private long swigCPtr;

  /* for internal use by swig only */
  public ArRVisionPTZ(long cPtr, boolean cMemoryOwn) {
    super(AriaJavaJNI.SWIGArRVisionPTZUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  /* for internal use by swig only */
  public static long getCPtr(ArRVisionPTZ obj) {
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
        AriaJavaJNI.delete_ArRVisionPTZ(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public ArRVisionPTZ(ArRobot robot) {
    this(AriaJavaJNI.new_ArRVisionPTZ(ArRobot.getCPtr(robot), robot), true);
  }

  public boolean init() {
    return AriaJavaJNI.ArRVisionPTZ_init(swigCPtr, this);
  }

  public String getTypeName() {
    return AriaJavaJNI.ArRVisionPTZ_getTypeName(swigCPtr, this);
  }

  public void setPort(String port) {
    AriaJavaJNI.ArRVisionPTZ_setPort(swigCPtr, this, port);
  }

  public boolean canZoom() {
    return AriaJavaJNI.ArRVisionPTZ_canZoom(swigCPtr, this);
  }

  public boolean zoom(int zoomValue) {
    return AriaJavaJNI.ArRVisionPTZ_zoom(swigCPtr, this, zoomValue);
  }

  public boolean zoomRel(int zoomValue) {
    return AriaJavaJNI.ArRVisionPTZ_zoomRel(swigCPtr, this, zoomValue);
  }

  public int getZoom() {
    return AriaJavaJNI.ArRVisionPTZ_getZoom(swigCPtr, this);
  }

  public boolean canGetRealPanTilt() {
    return AriaJavaJNI.ArRVisionPTZ_canGetRealPanTilt(swigCPtr, this);
  }

  public boolean canGetRealZoom() {
    return AriaJavaJNI.ArRVisionPTZ_canGetRealZoom(swigCPtr, this);
  }

  public boolean canGetFOV() {
    return AriaJavaJNI.ArRVisionPTZ_canGetFOV(swigCPtr, this);
  }

  public double getFOVAtMaxZoom() {
    return AriaJavaJNI.ArRVisionPTZ_getFOVAtMaxZoom(swigCPtr, this);
  }

  public double getFOVAtMinZoom() {
    return AriaJavaJNI.ArRVisionPTZ_getFOVAtMinZoom(swigCPtr, this);
  }

  public ArBasePacket readPacket() {
    long cPtr = AriaJavaJNI.ArRVisionPTZ_readPacket(swigCPtr, this);
    return (cPtr == 0) ? null : new ArBasePacket(cPtr, false);
  }

  public final static int MAX_PAN = AriaJavaJNI.ArRVisionPTZ_MAX_PAN_get();
  public final static int MIN_PAN = AriaJavaJNI.ArRVisionPTZ_MIN_PAN_get();
  public final static int MIN_TILT = AriaJavaJNI.ArRVisionPTZ_MIN_TILT_get();
  public final static int MAX_TILT = AriaJavaJNI.ArRVisionPTZ_MAX_TILT_get();
  public final static int MIN_ZOOM = AriaJavaJNI.ArRVisionPTZ_MIN_ZOOM_get();
  public final static int MAX_ZOOM = AriaJavaJNI.ArRVisionPTZ_MAX_ZOOM_get();
  public final static int TILT_OFFSET_IN_DEGREES = AriaJavaJNI.ArRVisionPTZ_TILT_OFFSET_IN_DEGREES_get();
  public final static int PAN_OFFSET_IN_DEGREES = AriaJavaJNI.ArRVisionPTZ_PAN_OFFSET_IN_DEGREES_get();

}
