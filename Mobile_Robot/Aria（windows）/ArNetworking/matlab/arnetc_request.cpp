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
    if(nrhs < 2)
       mexErrMsgIdAndTxt( "arnetc:arnetc_request:minrhs", "Incorrect number of input arguments. Must provide connection handle returned by arnetc_connect, request name, followed by 0 or more optional arguments.");
   uint64_t *p = (uint64_t*)mxGetData(prhs[0]);
   uint64_t i = *p;
   ArClientBase *client = (ArClientBase*) i;
   if(client == 0)
   {
       mexErrMsgIdAndTxt("arnetc:arnetc_request", "Error: NULL connection handle.");
       return;
   }
   
    // todo check data type of this argument
  
   if(mxGetClassID(prhs[1]) != mxCHAR_CLASS)
   {
       mexErrMsgIdAndTxt("arnetc:arnetc_request:", "Error: second argument must be a string containing request name.");
       return;
   }
   char reqname[128];
   mxGetString(prhs[1], reqname, 128);
   
   if(!client->dataExists(reqname))
   {
       mexErrMsgIdAndTxt("arnetc:arnetc_request", "Server does not have request \"%s\". Not sending.", reqname);
       return;
   }

    if(nrhs == 2) // no arguments
    {
        client->requestOnce(reqname);
        return;
    }
    
    ArNetPacket pkt;
    char buf[256];
    double d;
    for(int i = 2; i < nrhs; ++i)
    {
        switch(mxGetClassID(prhs[i]))
        {
            case mxSINGLE_CLASS:
            case mxDOUBLE_CLASS:
                // Warning, floating point value is truncated to integer
                d = mxGetScalar(prhs[i]);
                mexPrintf("arnetc_request: warning: truncating floating point argument #%d (%g) to integer (%d).\n", i, d, (ArTypes::Byte4) d);
                pkt.byte4ToBuf( (ArTypes::Byte4) d );
                break;
            case mxINT8_CLASS:
                //mexPrintf("arnetc_request: Adding 8-bit argument #%d as byte.\n", i);
                pkt.byteToBuf( (ArTypes::Byte)mxGetScalar(prhs[i]) );
                break;
            case mxINT16_CLASS:
                //mexPrintf("arnetc_request: Adding 16-bit argument #%d as byte2.\n", i);
                pkt.byteToBuf( (ArTypes::Byte2)mxGetScalar(prhs[i]) );
                break;
            case mxINT32_CLASS:
                //mexPrintf("arnetc_request: Adding 32-bit argument #%d as byte4.\n", i);
                pkt.byteToBuf( (ArTypes::Byte4) mxGetScalar(prhs[i]) );
                break;
            case mxUINT8_CLASS:
               // mexPrintf("arnetc_request: Adding 8-bit unsigned argument #%d as unsigned byte.\n", i);
                pkt.uByteToBuf( (ArTypes::UByte)mxGetScalar(prhs[i]) );
                break;
            case mxUINT16_CLASS:
                //mexPrintf("arnetc_request: Adding 16-bit unsigned argument #%d as unsigned byte2.\n", i);
                pkt.uByteToBuf( (ArTypes::UByte2) mxGetScalar(prhs[i]) );
                break;
            case mxUINT32_CLASS:
               // mexPrintf("arnetc_request: Adding 32-bit unsigned argument #%d as unsigned byte4.\n", i);
                pkt.uByteToBuf( (ArTypes::UByte4) mxGetScalar(prhs[i]) );
                break;
            case mxCHAR_CLASS:
                mxGetString(prhs[i], buf, 256);
                //mexPrintf("arnetc_request: Adding string argument #%d to request %s as %s...\n",i, reqname, buf);
                pkt.strToBuf(buf);
                break;
            case mxCELL_CLASS:
                mexPrintf("cell class\n");
                // TODO iterate over array and pack each item.
                break;
            default:
                mexErrMsgIdAndTxt("arnetc:arnetc_request", "Error: not able to pack argument %d of type %s into ArNetPacket.", i, mxGetClassName(prhs[i]));
        }

    }    
    mexPrintf("arnetc_request: sending %s request...\n", reqname);
    client->requestOnce(reqname, &pkt);
}
	
