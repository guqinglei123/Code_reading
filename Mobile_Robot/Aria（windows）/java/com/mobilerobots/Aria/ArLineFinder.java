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

public class ArLineFinder {
  /* (begin code from javabody typemap) */

  private long swigCPtr;
  protected boolean swigCMemOwn;

  /* for internal use by swig only */
  public ArLineFinder(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  /* for internal use by swig only */
  public static long getCPtr(ArLineFinder obj) {
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
        AriaJavaJNI.delete_ArLineFinder(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public ArLineFinder(ArRangeDevice dev) {
    this(AriaJavaJNI.new_ArLineFinder(ArRangeDevice.getCPtr(dev), dev), true);
  }

  public SWIGTYPE_p_std__setT_ArLineFinderSegment_p_t getLinesAsSet() {
    return new SWIGTYPE_p_std__setT_ArLineFinderSegment_p_t(AriaJavaJNI.ArLineFinder_getLinesAsSet(swigCPtr, this), true);
  }

  public SWIGTYPE_p_std__setT_ArPose_t getNonLinePointsAsSet() {
    return new SWIGTYPE_p_std__setT_ArPose_t(AriaJavaJNI.ArLineFinder_getNonLinePointsAsSet(swigCPtr, this), true);
  }

  public ArPose getLinesTakenPose() {
    return new ArPose(AriaJavaJNI.ArLineFinder_getLinesTakenPose(swigCPtr, this), true);
  }

  public void saveLast() {
    AriaJavaJNI.ArLineFinder_saveLast(swigCPtr, this);
  }

  public void getLinesAndSaveThem() {
    AriaJavaJNI.ArLineFinder_getLinesAndSaveThem(swigCPtr, this);
  }

  public void setVerbose(boolean verbose) {
    AriaJavaJNI.ArLineFinder_setVerbose(swigCPtr, this, verbose);
  }

  public boolean getVerbose() {
    return AriaJavaJNI.ArLineFinder_getVerbose(swigCPtr, this);
  }

  public void setLineCreationParams(int minLineLen, int minLinePoints) {
    AriaJavaJNI.ArLineFinder_setLineCreationParams__SWIG_0(swigCPtr, this, minLineLen, minLinePoints);
  }

  public void setLineCreationParams(int minLineLen) {
    AriaJavaJNI.ArLineFinder_setLineCreationParams__SWIG_1(swigCPtr, this, minLineLen);
  }

  public void setLineCreationParams() {
    AriaJavaJNI.ArLineFinder_setLineCreationParams__SWIG_2(swigCPtr, this);
  }

  public void setLineCombiningParams(int angleTol, int linesCloseEnough) {
    AriaJavaJNI.ArLineFinder_setLineCombiningParams__SWIG_0(swigCPtr, this, angleTol, linesCloseEnough);
  }

  public void setLineCombiningParams(int angleTol) {
    AriaJavaJNI.ArLineFinder_setLineCombiningParams__SWIG_1(swigCPtr, this, angleTol);
  }

  public void setLineCombiningParams() {
    AriaJavaJNI.ArLineFinder_setLineCombiningParams__SWIG_2(swigCPtr, this);
  }

  public void setLineFilteringParams(int minPointsInLine, int minLineLength) {
    AriaJavaJNI.ArLineFinder_setLineFilteringParams__SWIG_0(swigCPtr, this, minPointsInLine, minLineLength);
  }

  public void setLineFilteringParams(int minPointsInLine) {
    AriaJavaJNI.ArLineFinder_setLineFilteringParams__SWIG_1(swigCPtr, this, minPointsInLine);
  }

  public void setLineFilteringParams() {
    AriaJavaJNI.ArLineFinder_setLineFilteringParams__SWIG_2(swigCPtr, this);
  }

  public void setLineValidParams(int maxDistFromLine, int maxAveDistFromLine) {
    AriaJavaJNI.ArLineFinder_setLineValidParams__SWIG_0(swigCPtr, this, maxDistFromLine, maxAveDistFromLine);
  }

  public void setLineValidParams(int maxDistFromLine) {
    AriaJavaJNI.ArLineFinder_setLineValidParams__SWIG_1(swigCPtr, this, maxDistFromLine);
  }

  public void setLineValidParams() {
    AriaJavaJNI.ArLineFinder_setLineValidParams__SWIG_2(swigCPtr, this);
  }

  public void setMaxDistBetweenPoints(int maxDistBetweenPoints) {
    AriaJavaJNI.ArLineFinder_setMaxDistBetweenPoints__SWIG_0(swigCPtr, this, maxDistBetweenPoints);
  }

  public void setMaxDistBetweenPoints() {
    AriaJavaJNI.ArLineFinder_setMaxDistBetweenPoints__SWIG_1(swigCPtr, this);
  }

  public void addToConfig(ArConfig config, String section) {
    AriaJavaJNI.ArLineFinder_addToConfig(swigCPtr, this, ArConfig.getCPtr(config), config, section);
  }

}
