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
#include <cstdint>

void mexFunction(int nlhs, mxArray *plhs[], int nrhs, const mxArray *prhs[])
{
   if(nrhs != 1)
       mexErrMsgIdAndTxt( "arnetc:arnetc_connect:minrhs", "Incorrect number of input arguments. Must provide connection handle returned by arnetc_connect.");
   uint64_t *p = (uint64_t*)mxGetData(prhs[0]);
   uint64_t i = *p;
   mexPrintf("disconnecting %ld...\n", i);
   ArClientBase *client = (ArClientBase*) i;
   if(client == 0)
       mexErrMsgIdAndTxt("arnetc:arnetc_disconnect", "NULL connection handle.");
   mexPrintf("arnetc_disconnect: Disconnecting from server and destroying client connection...\n");
   client->disconnect();
   client->stopRunning();
   delete client;

}
	