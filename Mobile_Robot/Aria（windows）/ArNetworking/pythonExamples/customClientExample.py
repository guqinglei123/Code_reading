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

def testCB(packet):
  print "client: received reply packet with command %d\n" % (packet.getCommand())

Aria_init()

client = ArClientBase()

startTime = ArTime()
startTime.setToNow()
if not client.blockingConnect("localhost", 7273):
  print "Could not connect to server at localhost port 7273, exiting"
  Aria_exit(1);
print "client: Took %ld msec to connect\n" % (startTime.mSecSince())

client.runAsync()

client.lock()

print "Client detected the following data requests on the server:"
client.logDataList()

print "Adding callback for data requests \"test\", \"test2\", \"test3\"..."
client.addHandler("test", testCB)
client.addHandler("test2", testCB)
client.addHandler("test3", testCB)


print "Requesting \"test\" once..."
client.requestOnce("test")

print "Requesting \"test2\" every 100ms..."
client.request("test2", 100)

print "Requesting \"test3\" to be sent at server's discrecion..."
client.request("test3", -1)
client.unlock()

print "Waiting 2 sec..."
ArUtil_sleep(2000)

print "Changing request frequency of \"test2\" to 300ms..."
client.lock()
client.request("test2", 300)
client.unlock()

print "Watiing 2 sec..."
ArUtil_sleep(1000)

print "Stopping request for \"test2\"..."
client.lock()
client.requestStop("test2")
client.unlock()

print "Waiting 2 sec..."
ArUtil_sleep(2000)

print "Disconnecting and exiting."
client.lock()
client.disconnect()
client.unlock()
ArUtil_sleep(50)

