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

def requestCallback(client, packet):
  replyPacket = ArNetPacket()
  replyPacket.strToBuf("Reply");
  print "requestCallback received a packet with command #%d. Sending a reply...\n" % (packet.getCommand())
  client.sendPacketTcp(replyPacket)

Aria_init()
server = ArServerBase()
packet = ArNetPacket()

server.addData("test", "some wierd test", requestCallback, "none", "none")
server.addData("test2", "another wierd test", requestCallback, "none", "none")
server.addData("test3", "yet another wierd test", requestCallback, "none", "none")
if not server.open(7273):
  print "Error: Could not open server port 7273"
  Aria_exit(1)
print "Opened server on port 7273. Connect with customClientExample."
server.runAsync()
while (server.getRunningWithLock()):
  ArUtil_sleep(1000)
  server.broadcastPacketTcp(packet, "test3")
Aria_exit(0)

