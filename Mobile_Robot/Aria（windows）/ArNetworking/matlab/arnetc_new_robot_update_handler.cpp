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


/* MEX function for Matlab */

#include "mex.h"
#include "ArClientBase.h"
#include "ArClientHandlerRobotUpdate.h"
#include <cstdint>

void mexFunction(int nlhs, mxArray *plhs[], int nrhs, const mxArray *prhs[])
{   
   if(nrhs != 1 || nrhs != 2)
       mexErrMsgIdAndTxt( "arnetc:arnetc_robot_update_handler:minrhs", "Incorrect number of input arguments. Must provide connection handle returned by arnetc_connect, and optional request frequency");
   if(nlhs != 1)
       mexErrMsgIdAndTxt( "arnetc:arnetc_connect:minlhs", "Must assign result to an output variable.");
   
   uint64_t *p = (uint64_t*)mxGetData(prhs[0]);
   ArClientBase *client = (ArClientBase*) *p;

   double freq = 100;
   if(nrhs == 2)
     freq = mxGetScalar(prhs[0]);
   
   mexPrintf("arnetc_robot_update_handler: Requesting robot status, mode and data updates (%dms rate)...", freq);
   ArClientHandlerRobotUpdate *updateHandler = new ArClientHandlerRobotUpdate(client);
   updateHandler->requestUpdates((int)freq);
   
   plhs[0] = mxCreateNumericMatrix(1, 1, mxUINT64_CLASS, mxREAL);
   uint64_t* r = (uint64_t*)mxGetData(plhs[0]);
   *r = (uint64_t)updateHandler;
}
	
