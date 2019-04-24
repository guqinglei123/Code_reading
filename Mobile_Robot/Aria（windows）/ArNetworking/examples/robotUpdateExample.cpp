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
/* This is the ArNetworking example client. 
 * It connects to an ArNetworking server, and provides continuous 
 * information about the robot state (position, speed, server mode, etc.),
 * and, if the server supports the commands, lets you drive the robot with
 * the keyboard.  
 *
 * To see the example client in action, first run a server on the robot's 
 * onboard computer, for example, serverDemo, testServer, guiServer (from ARNL),
 * or ARAM. Make sure the robot computer is on a network, and run this
 * clientDemo with the hostname of the robot computer as an argument:
 *
 *    ./clientDemo -host myrobot
 *
 */

#include "Aria.h"
#include "ArNetworking.h"
#include "ArClientHandlerRobotUpdate.h"




int main(int argc, char **argv)
{
  Aria::init();
  ArClientBase client;
  ArArgumentParser parser(&argc, argv);

  /* This will be used to connect our client to the server. 
   * It will get the hostname from the -host command line argument: */
  ArClientSimpleConnector clientConnector(&parser);

  parser.loadDefaultArguments();

  /* Check for -host, -help, ARIA arguments, and unhandled arguments: */
  if (!Aria::parseArgs() || !parser.checkHelpAndWarnUnparsed())
  {
    Aria::logOptions();
    Aria::exit(0);
  }

  
  /* Connect our client object to the remote server: */
  if (!clientConnector.connectClient(&client))
  {
    if (client.wasRejected())
      printf("Server '%s' rejected connection, exiting\n", client.getHost());
    else
      printf("Could not connect to server '%s', exiting\n", client.getHost());
    Aria::exit(1);
  } 

  printf("Connected to server.\n");

  client.setRobotName(client.getHost()); // include server name in log messages

  client.runAsync();

 
  ArClientHandlerRobotUpdate updates(&client);
  updates.requestUpdates();

  while (client.getRunningWithLock())
  {
    updates.lock();
    printf("Mode:%s  Status:%s  Pos:%.0f,%.0f,%.0f  Vel:%.0f,%.0f,%.0f  Bat:%.1f  \r",
		updates.getMode(),
		updates.getStatus(),
		updates.getX(), updates.getY(), updates.getTh(),
		updates.getVel(), updates.getLatVel(), updates.getRotVel(),
		updates.getVoltage()
	);
	updates.unlock();
    ArUtil::sleep(1000);
  }

  /* The client stopped running, due to disconnection from the server, general
   * Aria shutdown, or some other reason. */
  client.disconnect();
  Aria::exit(0);
  return 0;
}
