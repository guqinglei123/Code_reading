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

public class ArASyncTask extends ArThread {
  /* (begin code from javabody_derived typemap) */

  private long swigCPtr;

  /* for internal use by swig only */
  public ArASyncTask(long cPtr, boolean cMemoryOwn) {
    super(AriaJavaJNI.SWIGArASyncTaskUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  /* for internal use by swig only */
  public static long getCPtr(ArASyncTask obj) {
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
        AriaJavaJNI.delete_ArASyncTask(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public SWIGTYPE_p_void runThread(SWIGTYPE_p_void arg) {
    long cPtr = AriaJavaJNI.ArASyncTask_runThread(swigCPtr, this, SWIGTYPE_p_void.getCPtr(arg));
    return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
  }

  public void run() {
    AriaJavaJNI.ArASyncTask_run(swigCPtr, this);
  }

  public void runAsync() {
    AriaJavaJNI.ArASyncTask_runAsync(swigCPtr, this);
  }

  public void stopRunning() {
    AriaJavaJNI.ArASyncTask_stopRunning(swigCPtr, this);
  }

  public int create(boolean joinable, boolean lowerPriority) {
    return AriaJavaJNI.ArASyncTask_create__SWIG_0(swigCPtr, this, joinable, lowerPriority);
  }

  public int create(boolean joinable) {
    return AriaJavaJNI.ArASyncTask_create__SWIG_1(swigCPtr, this, joinable);
  }

  public int create() {
    return AriaJavaJNI.ArASyncTask_create__SWIG_2(swigCPtr, this);
  }

  public SWIGTYPE_p_void runInThisThread(SWIGTYPE_p_void arg) {
    long cPtr = AriaJavaJNI.ArASyncTask_runInThisThread__SWIG_0(swigCPtr, this, SWIGTYPE_p_void.getCPtr(arg));
    return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
  }

  public SWIGTYPE_p_void runInThisThread() {
    long cPtr = AriaJavaJNI.ArASyncTask_runInThisThread__SWIG_1(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
  }

  public String getThreadActivity() {
    return AriaJavaJNI.ArASyncTask_getThreadActivity(swigCPtr, this);
  }

}
