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

public class simple {

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

  /* Main program: */
  public static void main(String argv[]) {
    System.out.println("Starting Java ArNetworking Test");

    /* Global Aria class inititalizaton */
    Aria.init(Aria.SigHandleMethod.SIGHANDLE_THREAD, true);

    /* Robot and device objects */
    ArRobot robot = new ArRobot("robot1", true, true, true);
    ArSonarDevice sonar = new ArSonarDevice();
    robot.addRangeDevice(sonar);

    /* Make connector and parse arguments from argv */
    ArSimpleConnector conn = new ArSimpleConnector(argv);
    if(!Aria.parseArgs())
    {
      Aria.logOptions();
      Aria.shutdown();
      System.exit(1); 
    }

    /* Connect to the robot */
    System.out.println("Connecting to robot...");
    if (!conn.connectRobot(robot))
    {
      System.err.println("Could not connect to robot, exiting.\n");
      System.exit(1);
    }

    /* Open the sever */
    ArServerBase server = new ArServerBase();
    if(!server.open(7272))
    {
      System.err.println("Could not open server on port 7272, exiting.");
      System.exit(1);
    }
    System.out.println("Opened server on port 7272.");

    /* Informational services: */
    ArServerInfoRobot servInfoRobot = new ArServerInfoRobot(server, robot);
    ArServerInfoSensor servInfoSensor = new ArServerInfoSensor(server, robot);
    ArServerInfoDrawings servInfoDraw = new ArServerInfoDrawings(server);
    servInfoDraw.addRobotsRangeDevices(robot);

    /* Control mode services: */
    ArServerModeStop servModeStop = new ArServerModeStop(server, robot);
    ArServerModeRatioDrive servModeDrive = new ArServerModeRatioDrive(server, robot);
    ArServerModeWander servModeWander = new ArServerModeWander(server, robot);
    servModeStop.addAsDefaultMode();
    servModeStop.activate();

    /* Simple text command  service ("custom commands" in MobileEyes): */
    ArServerHandlerCommands commands = new ArServerHandlerCommands(server);
    
    // Relay microcontroller commands directly:
    ArServerSimpleComUC cmdUC = new ArServerSimpleComUC(commands, robot);

    // Log information:
    ArServerSimpleComMovementLogging cmdLog = new ArServerSimpleComMovementLogging(commands, robot);
    ArServerSimpleComLogRobotConfig cmdConfigLog = new ArServerSimpleComLogRobotConfig(commands, robot);


    /* Run robot and server threads in the backrgound: */
    System.out.println("Running...");
    robot.enableMotors();
    robot.runAsync(true);
    server.runAsync();
    robot.waitForRunExit();
  }
}
