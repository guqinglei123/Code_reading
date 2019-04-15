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

import com.mobilerobots.Aria.*;
import com.mobilerobots.ArNetworking.*;

class ResponseCallback extends ArFunctor_NetPacket
{
  public void invoke(ArNetPacket packet)
  {
    System.out.println("customClientExample: ResponseCallback: Got a packet from the server with type " + packet.getCommand());
  }
}

public class customClientExample {


  /* This loads all the ArNetworking classes (they will be in the global
   * namespace) when this class is loaded: */
  static {
    try {
        System.loadLibrary("AriaJava");
        System.loadLibrary("ArNetworkingJava");
    } catch (UnsatisfiedLinkError e) {
      System.err.println("Native code libraries (AriaJava and ArNetworkingJava .so or .DLL) failed to load. See the chapter on Dynamic Linking Problems in the SWIG Java documentation for help.\n" + e);
      System.exit(1);
    }
  }

  public static void main(String argv[])
  {
    Aria.init();

    ArClientBase client = new ArClientBase();
    ResponseCallback testCB = new ResponseCallback();

    ArTime startTime = new ArTime();
    startTime.setToNow();
    System.out.println("customClientExample: trying to connect to a server running on the local host at port 7273...");
    if (!client.blockingConnect("localhost", 7273))
    {
      System.err.println("Error: Could not connect to server on localhost:7273, exiting.");
      System.exit(1);
    }    

    System.out.println("customClientExample: Connected after " + startTime.mSecSince() + " msec.");
    
    client.runAsync();
    
    System.out.println("\ncustomClientExample: Adding data handler callbacks...");
    client.addHandler("test", testCB);
    client.addHandler("test2", testCB);
    client.addHandler("test3", testCB);
    client.logDataList();
    
    System.out.println("\ncustomClientExample: Requesting \"test\" once...");
    client.requestOnce("test");

    System.out.println("\ncustomClientExample: Requesting \"test2\" with a frequency of 10ms...");
    client.request("test2", 100);

    System.out.println("\ncustomClientExample: Requesting \"test3\" with a frequency of -1 (updates may happen at any time the server sends them) and waiting 5 sec...");
    client.request("test3", -1);
    ArUtil.sleep(5000);

    System.out.println("\ncustomClientExample: Changing request frequency of \"test2\" to 300ms and waiting 5 sec");
    client.request("test2", 300);
    ArUtil.sleep(5000);

    System.out.println("\ncustomClientExample: Cancelling \"test2\" request.");
    client.requestStop("test2");
    
    System.out.println("\ncustomClientExample: waiting 10 seconds, then disconnecting...");
    ArUtil.sleep(10000);
    client.disconnect();
    ArUtil.sleep(50);
  }
}
