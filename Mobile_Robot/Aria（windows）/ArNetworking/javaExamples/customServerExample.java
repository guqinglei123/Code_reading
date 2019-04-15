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

class RequestCallback extends ArFunctor_ServerData
{
  public void invoke(ArServerClient client, ArNetPacket packet)
  {
    ArNetPacket sending = new ArNetPacket();
    System.out.println("customServerExample: RequestCallback: responding to a request packet with ID " + packet.getCommand());
    client.sendPacketTcp(sending); // just send back an empty packet.
  }
}

public class customServerExample {


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


  public static void main(String[] argv)
  {
    Aria.init();
    ArServerBase server = new ArServerBase();
    ArNetPacket packet = new ArNetPacket(); // empty packet to test broadcasting

    RequestCallback testCB = new RequestCallback();

    server.addData("test", "some wierd test", testCB, "none", "none");
    server.addData("test2", "another wierd test", testCB, "none", "none");
    server.addData("test3", "yet another wierd test", testCB, "none", "none");
    if (!server.open(7273))
    {
      System.err.println("customServerExample: Could not open server port 7273");
      System.exit(1);
    }
    server.runAsync();
    System.out.println("customServerExample: ready for customClientExamples to connect on port 7273; will broadcast \"test3\" packet every 4 seconds as well.");
    while (server.getRunningWithLock())
    {
      ArUtil.sleep(4000);
      server.broadcastPacketTcp(packet, "test3");
    }
    Aria.shutdown();
  }
}

