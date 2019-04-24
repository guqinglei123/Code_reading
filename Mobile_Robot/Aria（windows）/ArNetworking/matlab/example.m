% Adept MobileRobots Robotics Interface for Applications (ARIA)
% Copyright (C) 2004-2005 ActivMedia Robotics LLC
% Copyright (C) 2006-2010 MobileRobots Inc.
% Copyright (C) 2011-2014 Adept Technology
% 
%      This program is free software; you can redistribute it and/or modify
%      it under the terms of the GNU General Public License as published by
%      the Free Software Foundation; either version 2 of the License, or
%      (at your option) any later version.
% 
%      This program is distributed in the hope that it will be useful,
%      but WITHOUT ANY WARRANTY; without even the implied warranty of
%      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
%      GNU General Public License for more details.
% 
%      You should have received a copy of the GNU General Public License
%      along with this program; if not, write to the Free Software
%      Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
% 
% If you wish to redistribute ARIA under different terms, contact 
% Adept MobileRobots for information about a commercial version of ARIA at 
% robots@mobilerobots.com or 
% Adept MobileRobots, 10 Columbia Drive, Amherst, NH 03031; +1-603-881-7960

function example
     cleanupobj = onCleanup(@cleanup)
     arnetc_init
     
     c = arnetc_connect('localhost');
     if c == 0
         return
     end
     arnetc_request(c, 'gotoGoal', 'Hallway 2')
 
     ru = arnetc_new_robot_update_handler(c);
     while (true)
       m = arnetc_robot_update_get_mode(ru);
       disp(['Mode: ' m])
       s = arnetc_robot_update_get_status(ru);
       disp(['Status: ' s])
       v = arnetc_robot_update_get_vels(ru);
       disp(['Vel: ' num2str(v)])
       p = arnetc_robot_update_get_pose(ru);
       disp(['Pos: ' num2str(p)])
       %arnetc_request(c, 'LogActions')
       pause(0.5)
     end

 
     function cleanup
       disp('Example exited, cleaning up')
       arnetc_delete_robot_update_handler(ru)
       arnetc_disconnect(c)
       arnetc_shutdown
     end

end

