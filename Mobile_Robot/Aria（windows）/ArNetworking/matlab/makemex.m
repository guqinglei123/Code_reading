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

funcs = { 
    'arnetc_init',
    'arnetc_shutdown',
    'arnetc_connect',
    'arnetc_disconnect',
    'arnetc_new_robot_update_handler',
    'arnetc_delete_robot_update_handler',
    'arnetc_robot_update_get_pose',
    'arnetc_robot_update_get_vels',
    'arnetc_robot_update_get_mode',
    'arnetc_robot_update_get_status',
    'arnetc_request'
}

% Unload old mex functions etc.  Note, if you add a new mex function above that
% does not match these patterns, add it to this list or a pattern that
% matches it.
clear arnetc_*

 
% Set filenames and options depending on current platform
def = '';
switch computer
    case 'PCWIN'
		ariainstdir = 'C:/Program Files/MobileRobots/Aria'
        arialink = '-L../../lib -lAriaVC10 -lArNetworkingVC10'
        def = '-DWIN32 -win32'
        ariadll = '../../bin/AriaVC10.dll'
        arnetdll = '../../bin/ArNetworkingVC10.dll'
        username = getenv('USERNAME')
        hostname = getenv('COMPUTERNAME')
		disp 'You are on Windows 32 bit. Will attempt to use AriaVC10.dll and ArNetworkingVC10.dll, built in Release configuration for win32 platform with Visual C++ 2010.';
    case 'PCWIN64'
		ariainstdir = 'C:/Program Files/MobileRobots/Aria'
        def = '-DWIN32'
        arialink = '-L../../lib64 -lAriaVC10 -lArNetworkingVC10'
        ariadll = '../../bin64/AriaVC10.dll'
        arnetdll = '../../bin64/ArNetworkingVC10.dll'
        username = getenv('USERNAME')
        hostname = getenv('COMPUTERNAME')
		disp 'You are on Windows 64 bit. Will attempt to use AriaVC10.dll and ArNetworkingVC10.dll from ../../bin64, built in Release configuration for x64 platform with Visual C++ 2010.';
    case 'GLNX86'
		ariainstdir = '/usr/local/Aria'
        arialink = '-L../../lib -lAria -lArNetworking'
        ariadll = '../../lib/libAria.so'
        arnetdll = '../../lib/libArNetworking.so'
        username = getenv('USER')
        hostname = getenv('HOSTNAME')
		disp 'You are on Linux 32 bit. Will attempt to use libAria.so and libariac.so.';
    case 'GLNXA64'
		ariainstdir = '/usr/local/Aria'
        arialink = '-L../../lib -lAria -lArNetworking'
        ariadll = '../../lib/libAria.so'
        arnetdll = '../../lib/libArNetworking.so'
        username = getenv('USER')
        hostname = getenv('HOSTNAME')
        disp 'You are on Linux 64 bit. Will attempt to use libAria.so and libariac.so.';
	case 'MACI64'
	    disp 'Sorry, not set up for Mac yet. You will need to get ARIA and ArNetworking built on Mac, then edit makemex.m to set the appropriate mex compilation flags under the MACI64 computer type case instead of displaying this message..';
        return
    otherwise
        disp 'error, unrecognized system type. (what kind of computer and OS are you on?)';
        computer
		return
end

% Put a copy of the ARIA runtime library into the current directory
disp 'Copying ARIA and ArNetworking DLLs into current directory so Matlab can easily find it...';
eval(['copyfile ' ariadll ' .'])
eval(['copyfile ' arnetdll ' .'])

% Compile all the mex functions listed above:
disp 'Compiling mex functions...'
for i = 1:length(funcs);
  disp(funcs{i});
  cmd = sprintf('mex -g %s -DMATLAB -I../include -I../../include %s %s.cpp', def, arialink, funcs{i});
  eval(cmd);
end;

disp 'Writing build info to file buildinfo.txt'
fp = fopen('buildinfo.txt', 'w');
fprintf(fp, 'ArNetworking Matlab Interface built %s by %s@%s\nMatlab %s %s\nUsed ARIA DLL %s and ArNetworking DLL %S with link flags  %s\n', date, username, hostname, version, computer, ariadll, arnetdll, arialink);
fclose(fp);

disp 'done'

clear ariadll ariainstdir arialink arnetdll cmd def funcs i;

