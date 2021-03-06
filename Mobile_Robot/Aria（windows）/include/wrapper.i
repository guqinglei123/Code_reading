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

        /* SWIG 1.3 Wrapper Interface Definition for Aria */

#ifdef SWIGPYTHON
/*#warning Defining ARIA wrapper interface for Python*/

/* We need the module declared as "AriaPy" here so that other modules
   (like ArNetworking or ARNL) that use this wrapper will know what
   the resulting Python module and wrapper library are called. 
*/
%module(directors="1", docstring="Python wrapper library for Aria") AriaPy

#else
# ifdef SWIGJAVA
/*# warning Defining ARIA wrapper interface for Java*/

%module(directors="1", docstring="Java wrapper library for Aria") AriaJava

# else
# warning Defining ARIA wrapper interface for something other that Java or Python. This might be an error.

%module(directors="1", docstring="Wrapper library for Aria") Aria

# endif
#endif

#ifdef SWIGIMPORTED
#warning Imported ARIA wrapper
#endif

%feature("autodoc", "1");



%{
#include "Aria.h"
#include "ArGPSConnector.h"
#include "ArSystemStatus.h"
#include "ArMD5Calculator.h"
/*#include "SwigTestClass.h"*/
#include "wrapper_ExtraClasses.h"
#include "wrapper_Functors.h"

#include <cstddef>
%}

/* Filter out warnings about setting const char* members in these classes--
 they are all static so the warning about leaking memory doesn't really apply.  */
%warnfilter(451) ArUtil;
%warnfilter(451) ArCameraCommands;
%warnfilter(451) ArMapInfoInterface;
%warnfilter(451) ArMapInterface;




/* Enable director classes (subclasses) for ArAction.
   Other classes in Aria that can be subclasses, but very rarely are,
   include ArResolver, ArBasePacket, ArDeviceConnection, ArRangeDevice,
   ArActionGroup, ArMode; maybe others.  
   In Java it needs to be enabled for various ArFunctor subclasses too, 
   see later.
   You could add %feature("director") directives for those classes
   and regenerate the wrapper libraries if you want to use them.
   (They are omitted since making a class a director adds lots
   of code to the wrapper library.)
   ArASyncTask is also often subclassed, but threading in Python is
   kind of hard to get working right, at least as of Python 2.3, 
   especially going through Swig to do it, so providing ArASyncTask is 
   postponed.
*/
%feature("director") ArAction;

/* Supply an alternate setRobot() to avoid infinite recursion
   between the Python/Java subclass and Swig's director method.
*/
%extend ArAction {
  void setActionRobot(ArRobot* robot)
  {
    self->ArAction::setRobot(robot);
  }
}


/* ArMap needs directors, and to be explicitly not abstract, for constructors to be made correctly */

#ifdef SWIGJAVA
%feature("director") ArMap;
#endif

%feature("notabstract") ArMap;
%feature("notabstract") ArMapInfo;



/** Functors: **/

%{
#include "wrapper_Functors.h"
%}


/* In python, use typemaps to convert function objects to ArFunctor subclasses */

#ifdef SWIGPYTHON

%typemap(in) ArFunctor* {
  $1 = new ArPyFunctor($input); /* XXX Memory leak. How to free? */
}

%typecheck(SWIG_TYPECHECK_POINTER) ArFunctor* {
  $1 = PyCallable_Check($input);
}


%typemap(in) ArRetFunctor<bool>* {
  $1 = new ArPyRetFunctor_Bool($input); /* XXX Memory leak. How to free it? */
}


%typecheck(SWIG_TYPECHECK_POINTER) ArRetFunctor<bool>* {
  $1 = PyCallable_Check($input);
}

#endif /* ifdef SWIGPYTHON  */




/* In Java, enable directors so you can subclass ArFunctors. */

#ifdef SWIGJAVA


%feature("director") ArFunctor;
%feature("director") ArRetFunctor<bool>;
%feature("director") ArRetFunctor;
%feature("director") ArRetFunctor1;
%feature("director") ArFunctor1<ArRobotPacket*>;
%feature("director") ArRetFunctor1<bool, ArRobotPacket*>;

#endif




/* Rename or ignore things that can cause problems for SWIG: */

%rename (removePendingItemsWithType) ArSoundsQueue::removePendingItems(const %char*, ItemType);
%rename (removePendingItemsByPriority) ArSoundsQueue::removePendingItems(int);
%rename (removePendingItemsByPriorityWithType) ArSoundsQueue::removePendingItems(int, ItemType);
%rename (removePendingItemsByType) ArSoundsQueue::removePendingItems(ItemType);
%rename (nextItemByType) ArSoundsQueue::nextItem(ItemType);
%rename (nextItemByPriority) ArSoundsQueue::nextItem(int);
%rename (nextItemByTypeAndPriority) ArSoundsQueue::nextItem(ItemType, int);
%ignore ArActionTriangleDriveTo::getData;
%rename (addPreMapChangedCBPos) ArMapInterface::addPreMapChangedCB(ArFunctor*, ArListPos::Pos);
%rename (addPreMapChangedCBPos) ArMap::addPreMapChangedCB(ArFunctor*, ArListPos::Pos);
%rename (addMapChangedCBPos) ArMapInterface::addMapChangedCB(ArFunctor*, ArListPos::Pos);
%rename (addMapChangedCBPos) ArMap::addMapChangedCB(ArFunctor*, ArListPos::Pos);

/* arconfig cannot target pointers in the wrapped languages: */
%ignore ArConfigArg::ArConfigArg(const char*, int*, const char*, int, int);
%ignore ArConfigArg::ArConfigArg(const char*, short*, const char*, int, int);
%ignore ArConfigArg::ArConfigArg(const char*, unsigned short*, const char*, int, int);
%ignore ArConfigArg::ArConfigArg(const char*, unsigned char*, const char*, int, int);
%ignore ArConfigArg::ArConfigArg(const char*, double*, const char*, double, double);
%ignore ArConfigArg::ArConfigArg(const char*, bool*, const char*);
 

/* Rename reserved words in Python: */
#ifdef SWIGPYTHON
%rename(NoLog) ArLog::None;
%rename(printQueue) ArRingQueue::print;
%rename(printPoint) Ar3DPoint::print;
#endif

/* In Java and Python, you can easily concatenate strings and primitive types, 
   so we can just refer to logPlain() as log(), and ignore the varargs log(). */
%ignore ArLog::log;
%rename (log) ArLog::logPlain;

/* Rename names of some built in methods in java.lang.Object */
#ifdef SWIGJAVA
%rename(waitFor) ArCondition::wait;
%rename(cloneMap) ArMapInterface::clone; 
#endif

/* cant wrap operators (should provide replacement methods though, TODO) */
%ignore operator=;
%ignore operator==;
%ignore operator<;
%ignore operator>;
%ignore operator();
%ignore operator+;
%ignore operator-;
%ignore operator*;
%ignore operator!=;
%ignore operator+=;
%ignore operator-=;

/* Typemaps to make ARIA classes more accessible and work better in various
 * target languages:
 */

%include "typemaps.i"

%apply int *OUTPUT {int *x, int *y, int *z};
%apply double *OUTPUT {double *x, double *y, double *th};
%apply double *OUTPUT {double *x, double *y, double *z};


/* In python, use a standard list of strings for argc and argv: */

#ifdef SWIGPYTHON

// TODO: ArArgumentParser can modify the argv list, these changes
// need to be reflected in the Python or Java list after the C++ function
// returns (if possible). Not sure how to do that yet.

%typemap(in) (int *argc, char **argv) {
    # (begin %typemap(in) for (int *argc, char **argv)
    int i;
    if (!PyList_Check($input)) {
        PyErr_SetString(PyExc_ValueError, "Expecting a list");
        return NULL;
    }
    int tmpArgc = PyList_Size($input);
    tmpArgc = PyList_Size($input);
    $2 = (char **) malloc((tmpArgc+1)*sizeof(char *));
    for (i = 0; i < tmpArgc; i++) {
        PyObject *s = PyList_GetItem($input,i);
        if (!PyString_Check(s)) {
            free($2);
            PyErr_SetString(PyExc_ValueError, "Arguments must be strings");
            return NULL;
        }
        $2[i] = PyString_AsString(s);
    }
    $2[i] = 0;
    /* Allocate a new int to hold the size, since some classes retain the pointer
       and try to use it after this wrapped function returns.
       Note this is not deallocated, in general classes using this typemap are
       defacto singletons that live for the life of the program, so it's not a problem,
       but if this typemap ever gets used for other kinds of classes is may come up. */
    int *newArgc = (int*) malloc(sizeof(int));
    *newArgc = tmpArgc;
    $1 = newArgc;
    # (end %typemap(in) for (int *argc, char **argv)
}

%typecheck(SWIG_TYPECHECK_POINTER) (int *argc, char **argv) {
  $1 = PyList_Check($input);
}

#endif /*SIWGPYTHON*/



/* Modify Java wrapper to make it easier to access functions with pointer and
   array arguments:

*/

#ifdef SWIGJAVA


/* Use a String[] for argc and argv (e.g. the argv[] parameter in main())   */

%typemap(in) (int *argc, char **argv) (jint size){
  /* (begin %typemap(in) for (int *argc, char **argv) */
  size = jenv->GetArrayLength((jarray)$input);
  int tmpArgc = size;
  int i;
  $2 = (char**)malloc( (size+1) * sizeof(char*) );
  for(i = 0; i < size; i++) {
    jstring js = (jstring) jenv->GetObjectArrayElement((jobjectArray)$input, i);
    const char *cs = jenv->GetStringUTFChars(js, 0);
    $2[i] = (char*)malloc(strlen(cs)+1 * sizeof(const char));
    strcpy($2[i], cs);
    jenv->ReleaseStringUTFChars(js, cs);
    jenv->DeleteLocalRef(js);
  }
  $2[i] = 0;
  int *newArgc = (int*) malloc(sizeof(int));
  *newArgc = tmpArgc;
  $1 = newArgc;
  /* (end %typemap(in) for (int *argc, char **argv) */
}


/* XXX TODO? or will the jni and jtype typemaps below deal with it? :
%typecheck(java,SWIG_TYPECHECK_POINTER) (int *, char **) {
  // TODO 
}
*/


%typemap(jni) (int *argc, char **argv) "jobjectArray"
%typemap(jtype) (int *argc, char **argv) "java.lang.String[]"
%typemap(jstype) (int *argc, char **argv) "java.lang.String[]"
%typemap(javain) (int *argc, char **argv) "$javainput"
%typemap(javaout) (int *argc, char **argv) { return $jnicall; }


/* In Java, we alsoneed to override how SWIG defines some methods in the wrappers,
 * to be public not protected (the defaut javabody typemap is defined in 
 * java.swg) so that other packages such as ArNetworking and ARNL can access them: 
 */
%typemap(javabody) SWIGTYPE %{
  /* (begin code from javabody typemap) */

  private long swigCPtr;
  protected boolean swigCMemOwn;

  /* for internal use by swig only */
  public $javaclassname(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  /* for internal use by swig only */
  public static long getCPtr($javaclassname obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  /* (end code from javabody typemap) */
%}

%typemap(javabody_derived) SWIGTYPE %{
  /* (begin code from javabody_derived typemap) */

  private long swigCPtr;

  /* for internal use by swig only */
  public $javaclassname(long cPtr, boolean cMemoryOwn) {
    super($imclassname.SWIG$javaclassnameUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  /* for internal use by swig only */
  public static long getCPtr($javaclassname obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  /* (end code from javabody_derived typemap) */
%}


%typemap(javabody) SWIGTYPE *, SWIGTYPE &, SWIGTYPE [], SWIGTYPE (CLASS::*) %{
  /* (begin code from javabody typemap for pointers, references, and arrays) */

  private long swigCPtr;

  /* for internal use by swig only */
  public $javaclassname(long cPtr, boolean bFutureUse) {
    swigCPtr = cPtr;
  }

  protected $javaclassname() {
    swigCPtr = 0;
  }

  /* for internal use by swig only */
  public static long getCPtr($javaclassname obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  /* (end code from javabody typemap for pointers, references, and arrays) */
%}



#endif /* SWIGJAVA */



#ifndef SWIGPYTHON
/* These are special additional structs used by methods added to
 * ArJoyHandler via %extend below */
%{
struct ArJoyVec3f { double x, y, z; };
struct ArJoyVec3i { int x, y, z; };
%}
#endif


/* Give names to some standard library container template types. 
 * In Java, you must use the special template instance names defined
 * here to subclass from, e.g. "class MyPacketHandler extends ArRetFunctor1_Bool_ArRobotPacketP" 
 */


%include "std_vector.i"
%template(ArPoseWithTimeVector) std::vector<ArPoseWithTime>;
%template(ArSensorReadingVector) std::vector<ArSensorReading>;
%template(DoubleVector) std::vector<double>;

#include <list>
/*#ifndef SWIGJAVA*/ /* doesn't have std_list.i */
#ifdef SWIGJAVA
%include "wrapper_std_list_java.i"
#else
%include "std_list.i"
#endif

%template(ArMapObjectPtrList) std::list<ArMapObject*>;
%template(ArFunctorPtrList) std::list<ArFunctor*>;
%template(ArPoseList) std::list<ArPose>;
%template(ArPosePtrList) std::list<ArPose*>;
%template(ArPoseWithTimeList) std::list<ArPoseWithTime>;
%template(ArPoseWithTimePtrList) std::list<ArPoseWithTime*>;
%template(ArRangeDevicePtrList) std::list<ArRangeDevice*>;
%template(ArArgumentBuilderPtrList) std::list<ArArgumentBuilder*>;
%template(ArLineSegmentList) std::list<ArLineSegment>;
%template(ArLineSegmentPtrList) std::list<ArLineSegment*>;
/*#endif*/

#ifndef SWIGJAVA /* doesn't have set */
%include "std_set.i"
%template(IntSet) std::set<int>;
#endif

%include "std_map.i"
%template(IntArPoseMap) std::map<int, ArPose>;


%include "std_string.i"

    /* Bring in header files with classes to wrap. */

/* note dont include ArVersalogicIO.h or ArRobotTypes.h */

/* Base classes first. */
%include "ariaTypedefs.h"
%include "ariaUtil.h"
%include "md5.h"
%include "ArBasePacket.h"
%include "ArPTZ.h"
%include "ArRangeDevice.h"
%include "ArRangeDeviceThreaded.h"
%include "ArLaser.h"
%include "ArResolver.h"
%include "ArThread.h"
%include "ArFunctor.h"

/* Give names to some instantiations of ArFunctor template classes (for use as
 * .h files that use these instantiations are loaded). */
%template(ArRetFunctor_VoidP) ArRetFunctor<void*>;
%template(ArRetFunctor_Bool) ArRetFunctor<bool>;
%template(ArFunctor1_CString) ArFunctor1<const char*>;
%template(ArFunctor1_Int) ArFunctor1<int>;
%template(ArFunctor1_ArRobotPacketP) ArFunctor1<ArRobotPacket*>;
%template(ArRetFunctor_Int) ArRetFunctor<int>;
%template(ArRetFunctor_Double) ArRetFunctor<double>;
%template(ArRetFunctor_UnsignedInt) ArRetFunctor<unsigned int>;
%template(ArRetFunctor1_Double_ArPoseWithTime) ArRetFunctor1<double, ArPoseWithTime>;
%template(ArRetFunctor1_Bool_ArRobotPacketP) ArRetFunctor1<bool, ArRobotPacket*>;
%template(ArRetFunctor1_Bool_ArgumentBuilder) ArRetFunctor1<bool, ArArgumentBuilder>;
%template(ArRetFunctor1_Bool_ArgumentBuilderP) ArRetFunctor1<bool, ArArgumentBuilder*>;
%template(ArRetFunctor1_VoidP_VoidP) ArRetFunctor1<void*, void*>;

%include "ArACTS.h"
%include "ArAMPTU.h"
%include "ArASyncTask.h"
%include "ArAction.h"
%include "ArActionAvoidFront.h"
%include "ArActionAvoidSide.h"
%include "ArActionBumpers.h"
%include "ArActionColorFollow.h"
%include "ArActionConstantVelocity.h"
%include "ArActionDeceleratingLimiter.h"
%include "ArActionDesired.h"
%include "ArActionDriveDistance.h"
%include "ArActionGoto.h"
%include "ArActionGotoStraight.h"
%include "ArActionGroup.h"
%include "ArActionGroups.h"
%include "ArActionIRs.h"
%include "ArActionInput.h"
%include "ArActionJoydrive.h"
%include "ArActionKeydrive.h"
%include "ArActionLimiterBackwards.h"
%include "ArActionLimiterForwards.h"
%include "ArActionLimiterTableSensor.h"
%include "ArActionMovementParameters.h"
%include "ArActionRatioInput.h"
%include "ArActionRobotJoydrive.h"
%include "ArActionStallRecover.h"
%include "ArActionStop.h"
%include "ArActionTriangleDriveTo.h"
%include "ArActionTurn.h"
%include "ArAnalogGyro.h"
%include "ArArg.h"
%include "ArArgumentBuilder.h"
%include "ArArgumentParser.h"
%include "ArBumpers.h"
%include "ArCameraCollection.h"
%include "ArCameraCommands.h"
%include "ArCommands.h"
%include "ArCondition.h"
%include "ArConfig.h"
%include "ArConfigArg.h"
%include "ArConfigGroup.h"
%include "ArDataLogger.h"
%include "ArDPPTU.h"
%include "ArDeviceConnection.h"
%include "ArDrawingData.h"
%include "ArFileParser.h"
%include "ArForbiddenRangeDevice.h"
%include "ArFunctor.h"
%include "ArFunctorASyncTask.h"
%include "ArGPS.h"
%include "ArGPSConnector.h"
%include "ArGPSCoords.h"
%include "ArGripper.h"
%include "ArIRs.h"
%include "ArInterpolation.h"
%include "ArIrrfDevice.h"
%include "ArJoyHandler.h"
%include "ArKeyHandler.h"
%include "ArLaserConnector.h"
%include "ArLaserFilter.h"
%include "ArLaserLogger.h"
%include "ArLaserReflectorDevice.h"
%include "ArLineFinder.h"
%include "ArLog.h"
%include "ArLogFileConnection.h"
%include "ArMD5Calculator.h"
%include "ArMapInterface.h"
%include "ArMap.h"
%include "ArMapComponents.h"
%include "ArMapObject.h"
%include "ArMapUtils.h"
%include "ArMode.h"
%include "ArModes.h"
%include "ArModule.h"
%include "ArModuleLoader.h"
%include "ArMutex.h"
%include "ArNMEAParser.h"
%include "ArNetServer.h"
%include "ArNovatelGPS.h"
%include "ArP2Arm.h"
%include "ArPriorityResolver.h"
%include "ArRangeBuffer.h"
%include "ArRatioInputJoydrive.h"
%include "ArRatioInputKeydrive.h"
%include "ArRatioInputRobotJoydrive.h"
%include "ArRecurrentTask.h"
%include "ArRingQueue.h"
%include "ArRobot.h"
%include "ArRobotConfig.h"
%include "ArRobotConfigPacketReader.h"
%include "ArRobotConnector.h"
%include "ArRobotJoyHandler.h"
%include "ArRobotPacket.h"
%include "ArRobotPacketReceiver.h"
%include "ArRobotPacketSender.h"
%include "ArRobotParams.h"
%include "ArRVisionPTZ.h"
%include "ArSensorReading.h"
%include "ArSerialConnection.h"
%include "ArSignalHandler.h"
%include "ArSimpleConnector.h"
%include "ArSimulatedLaser.h"
%include "ArSocket.h"
%include "ArSonarAutoDisabler.h"
%include "ArSonarDevice.h"
%include "ArSonyPTZ.h"
%include "ArSoundPlayer.h"
%include "ArSoundsQueue.h"
%include "ArSpeech.h"
%include "ArStringInfoGroup.h"
%include "ArSyncLoop.h"
%include "ArSyncTask.h"
%include "ArSystemStatus.h"
%include "ArTCM2.h"
%include "ArTCMCompassDirect.h"
%include "ArTCMCompassRobot.h"
%include "ArTaskState.h"
%include "ArTcpConnection.h"
%include "ArTransform.h"
%include "ArTrimbleGPS.h"
%include "ArUrg.h"
%include "ArVCC4.h"
#if !defined(SWIGWIN) && !defined(WIN32)
%include "ArVersalogicIO.h"
%include "ArMTXIO.h"
#endif
%include "ariaInternal.h"

%include "wrapper_Functors.h"
%include "wrapper_ExtraClasses.h"




/* Extensions to make ARIA classes more convenient in various target languages: */

/* Extension to print an ArPose nicely in Python: */
#ifdef SWIGPYTHON
%extend ArPose {
   char* __str__() {
      static char tmp[256];
      snprintf(tmp, 256, "(X:%.4f, Y:%.4f, T:%.4f)", self->getX(), self->getY(), self->getTh());
      return &tmp[0];
   }
}
#endif

/* Extension that allows you to access pose components as member attributes
   rather than using accessor methods.  We do this by providing "dummy" member
   variables, then overloading Swigs internal accessors:
 */
#ifdef SWIGPYTHON
%extend ArPose {
  double x, y, th;
}
%{
  const double ArPose_x_get(ArPose* p) {
    return (const double) p->getX();
  }
  void ArPose_x_set(ArPose* p, double x) {
    p->setX(x);
  }
  const double ArPose_y_get(ArPose* p) {
    return (const double) p->getY();
  }
  void ArPose_y_set(ArPose* p, double y) {
    p->setY(y);
  }
  const double ArPose_th_get(ArPose* p) {
    return (const double) p->getTh();
  }
  void ArPose_th_set(ArPose* p, double th) {
    p->setTh(th);
  }
%}
#endif


%extend ArSocket {
  std::string read(size_t len, unsigned int msWait) {
    char *buf = (char*)malloc(len);
    int n = self->read(buf, len, msWait);
    if(n <= 0) {
      free(buf);
      return "";
    }
    std::string s(buf, n);
    free(buf);
    return s;
  }

  bool write(std::string s) { 
    return self->write( (void*)(s.c_str()), (size_t)(s.length())); 
  } 
}


/* Extend the ArJoyHandler class to return structs with vector values, which is
 * easier to use than return via pointer arguments. */
#ifndef SWIGPYTHON // In Python the original functions return a nicer python tuple

struct ArJoyVec3f { double x, y, z; };
struct ArJoyVec3i { int x, y, z; };

%extend ArJoyHandler {
  /** @copydoc getDoubles(double *x, double *y, double *z)
     @added 2.7.3
  */
  ArJoyVec3f getDoubles() {
    ArJoyVec3f r;
    self->getDoubles(&r.x, &r.y, &r.z);
    return r;
  }
  /** @copydoc getAdjusted(int *x, int *y, int *z)
     @added 2.7.3
  */
  ArJoyVec3i getAdjusted() {
    ArJoyVec3i r;
    self->getAdjusted(&r.x, &r.y, &r.z);
    return r;
  }
  /** @copydoc getUnfiltered(int *x, int *y, int *z)
     @added 2.7.3
  */
  ArJoyVec3i getUnfiltered() {
    ArJoyVec3i r;
    self->getUnfiltered(&r.x, &r.y, &r.z);
    return r;
  }
  /** @copydoc getSpeeds(int *x, int *y, int *z)
     @added 2.7.3
  */
  ArJoyVec3i getSpeeds() {
    ArJoyVec3i r;
    self->getSpeeds(&r.x, &r.y, &r.z);
    return r;
  }
}

#endif

/* TODO:
    * Make ArConfig and ArConfigSection have dictionary access operators in Python
*/




/* TODO: typemap to check if a pointer returned by a method is NULL, and
   throw an exception. (Many methods in ARIA return NULL if an object
   is not found.)  Maybe only do this for Java since Python has the "None"
   object value?  (Also falso boolean returns for status?)
*/

