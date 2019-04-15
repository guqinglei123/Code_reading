"""
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
"""
from AriaPy import *
from ArNetworkingPy import *
import sys

# This example demonstrates how to use ArNetworking in Python. 

# Global library initialization, just like the C++ API:
Aria_init()

# Create a robot object:
robot = ArRobot()

# make a gyro 
gyro = ArAnalogGyro(robot)

#sonar, must be added to the robot
sonarDev = ArSonarDevice()
#add the sonar to the robot
robot.addRangeDevice(sonarDev)

# make the core server object:
server = ArServerBase()

# Create a "simple connector" object and connect to either the simulator
# or the robot. Unlike the C++ API which takes int and char* pointers, 
# the Python constructor just takes argv as a list.
print "Connecting..."

con = ArSimpleConnector(sys.argv)
if (not con.connectRobot(robot)):
    print "Could not connect to robot, exiting"
    Aria_exit(1)


# Open the server on port 7272:
if (not server.open(7272)):
    print "Could not open server, exiting"
    Aria_exit(1)

# Create various services and attach them to the core server
serverInfoRobot = ArServerInfoRobot(server, robot)
serverInfoSensor = ArServerInfoSensor(server, robot)
drawings = ArServerInfoDrawings(server)
drawings.addRobotsRangeDevices(robot)

# ways of moving the robot
modeStop = ArServerModeStop(server, robot)
modeRatioDrive = ArServerModeRatioDrive(server, robot)
modeWander = ArServerModeWander(server, robot)
modeStop.addAsDefaultMode()
modeStop.activate()

# set up the simple commands ("custom commands" in MobileEyes)
commands = ArServerHandlerCommands(server)
# add the simple commands for the microcontroller
uCCommands = ArServerSimpleComUC(commands, robot)
# add the simple commands for logging
loggingCommands = ArServerSimpleComMovementLogging(commands, robot)
# add the simple commands for the gyro
gyroCommands = ArServerSimpleComGyro(commands, robot, gyro)
# Add the simple command for logging the robot config and orig robot config
configCommands = ArServerSimpleComLogRobotConfig(commands, robot)



    
# Run the robot and server threads in the background:
print "Running..."
robot.runAsync(1)

server.runAsync()

robot.enableMotors()

robot.waitForRunExit()

Aria_exit(0)
