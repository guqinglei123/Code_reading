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


/* This example shows how to receive updates from an ArNetworking server (e.g.
 * arnlServer) providing robot data (position estimate, velocity), server mode string and
 * status string.
 */

import com.mobilerobots.Aria.*;
import com.mobilerobots.ArNetworking.*;


public class clientRobotUpdateHandlerExample {


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

    if (!client.blockingConnect("localhost", 7272)) // change hostname or ip address here to connect to a remote host
    {
      System.err.println("Error: Could not connect to server on localhost, exiting.");
      System.exit(1);
    }    

    
    client.runAsync();
    
    ArClientHandlerRobotUpdate updates =  new ArClientHandlerRobotUpdate(client);
    updates.requestUpdates();

    // Example server request:
    // client.requestOnce("wander");

    while(client.isConnected())
    {
      updates.lock();
      System.out.println(
        "Mode: " + updates.getMode() + " " +
        "Status: " + updates.getStatus() + " " +
        "Pos: ("+
        updates.getX()+", "+
        updates.getY()+", "+
        updates.getTh()+")"
      );
      updates.unlock();
      ArUtil.sleep(2000);
    }

    Aria.shutdown();
  }
}
