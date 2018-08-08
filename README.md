## Welcome!

This GitHub repository contains the source code that is used to build 
training code for Don Bosco Tech course CSEE331 "Robotics Engineering". 
It is based on the FTC Software Development Kit (SDK), available at the
[FTC SDK repository](https://github.com/ftctechnh/ftc_app/releases).
        
Open it in Android Studio. That's how it was developed.

### Get This Project
To get our code, download or clone from 
[our repository](https://github.com/jrasor/csee331).

If you are new to the FIRST Tech Challenge software and control system, 
look at the [FTC SDK Wiki](https://github.com/ftctechnh/ftc_app/wiki).
Check back there from time to time, as it contains the most current
information about the FIRST Tech Challenge software and control system.
### About This Project
The CSEE331 course is designed to bring high school students to the
skill level needed to enter FTC competition as rookie participants. 
#### The Robot
They begin by running a simple robot called a "Trainerbot". Then they disassemble
its major subsystems and put it back together again. Then they disassemble
the whole thing down to nuts and screws, and assemble it, all the while 
writing documentation on how to do that.

The robot has 3 main subsystems:
1. The electronics pan, containing the battery and control modules.
2. The drive train. Yes, the electonics pan hangs under the drive train.
3. The actuator and sensor suite. Actuators and sensors are mounted atop the
transverse members of the drive train, and can easily be moved around on
them.

All these subsystems are modular. A team can swap them in and out in their
pit, making multiple configurations possible. For example, they can bring 
a number of drive trains to a Meet and choose one to fit their Allies' 
strengths. They can bring a spare electronics pan and swap it in in less than
a minute. The possibilities for actuator and sensor suites are virtually
endless.
#### Another Robot
Another training robot is supported by this project, the "Lookeebot". It
is a drive train and a camera, nothing else. It's a testing platform for
robot vision. It just runs around with the camera and looks at stuff.
#### The Software
The software is this project. It is built up from sample opmodes taken from
the FtcRobotController samples that come with the SDK, and also with this
project. It is _not_ particularly well suited to this type of modular robot.
For starters, this software is not very modular.
* Some opmode classes contain methods and properties that should be members
 of a robot class. There is some duplication of code among them.
* Some of the robot class members are at different levels of complexity,
and the complex ones are only partially built on the simpler ones.

What are the students supposed to do with it, then?
1. First, run it on a Trainerbot and score with it at an early season Meet.
2. Then remedy its deficiencies with well chosen classes that use abstraction,
inheritance, overloading, etc. This means learning object-oriented programming
in a fun and competitive setting.
3. They should be able to write new classes and use them on new hardware 
modules swapped in for service in late-season Meets.

Students of this course are then well-qualified to contribute to an intermediate
or advanced FTC Team.
