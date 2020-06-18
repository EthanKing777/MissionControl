# ENGR 301 Project *Mission Control Software* Project Proposal and Requirements Document
#### Author list: Alex Jackson, Chris Burt, Ethan King, Henry Pettit, Nirari Awas, Ruvindu Wijeratne, Thomas Rainford

#Table of Contents:

1.  Introduction    
    * 1.1 Purpose 
    * 1.2 Scope
    * 1.3 Product Overview
        * 1.3.1 Product Perspective 
        * 1.3.2 Product Function 
        * 1.3.3 User Characteristics 
        * 1.3.4 Limitation 
2. References 
3. Specific Requirements
    * 3.1 External Interfaces 
    * 3.2 Functions 
    * 3.3 Usability Requirements 
    * 3.4 Performance Requirments 
    * 3.5 Logical Database Requirments
    * 3.6 Design Constraints
    * 3.7 Non-functional System Attributes
    * 3.8 Physical and Environmental Requirements
    * 3.9 Supporting Information
4. Verification
5. Development Schedule
    * 5.1 Schedule
    * 5.2 Budget
    * 5.3 Risks
    * 5.4 Health and Safety
        * 5.4.1 Safety Plan
6. Appendices
    * 6.1 Assumptions and Dependencies
    * 6.2 Acronyms and Abbreviations
7. Contributions
    


## 1. Introduction

Amateur rockets are flown regularly worldwide. These rockets are typically flown with off the shelf rocket motors with widely available propellant reloads. These rockets often exceed the speed of sound, altitudes above 30 km are not unheard of. These rockets are almost never controlled, they are stable due to passive aerodynamic features. 

While passively stable rockets are reasonably simple and reliable if well designed, they are susceptible to a variety of disturbances, particularly early in flight. Unexpected winds can cause the rocket to weathercock; flexibility in the launch tower/rail can cause railwhip, imparting a random launch angle to the rocket; the thrust from the rocket motor is also never perfectly symmetrical.

This project is a continuation of a project from 2018. This year the project is broken into hardware and software components. The project will be all opensource/openhardware and as such will need to use opensource tools to make it accessible to the community E.g Kicad instead of Altium for PCB designs. The hardware component is to design an avionics board that can provide telemetry from the rocket, log data from sensors and control the rocket by gimballing a motor. The software components are to design a mission control that runs on a laptop at the launch site as well as some software to statistically predict the rockets flight and software to help design the control parameters for the avionics.

### Client

Andre Geldenhuis is a rocket enthusiast who has experience building and launching rockets, and is a member of the New Zealand Rocketry Association.
Contact: Andre.Geldenhuis@vuw.ac.nz

### 1.1 Purpose

The purpose of the mission control software is to enusre conditions for launch are safe, and display data from a rocket in flight.

### 1.2 Scope

**Mission control software that will:**

* Be able to run on a laptop in a field.
* Send a message to the rocket when launch is imminent.
* Display data from the rocket including:
    - Current software state.
    - Current location.
    - Current altitude.
* Provide go/no go functionality which includes:
    - Collecting current local weather conditions.
    - Altering launch rod angle.
* Integrate with the simulation team to:
    - Provide weather information.
    - Determine an upwind trajectory to minimise landing distance from launch site.

### 1.3 Product overview 

In order to create a Mission Control software capable of safely executing a successful launch of the model rocket, the Mission Control system will need to rely on information provided by the Avionics Engineering teams and the Simulation teams. The Mission Control system should also possess the capability to transmit data required by other teams as the need occurs.  

### 1.3.1 Product Perspective

In order to create a Mission Control software capable of safely executing a successful launch of the model rocket, the Mission Control system will need to rely on information provided by the Avionics Engineering teams and the Simulation teams. The Mission Control system should also possess the capability to transmit data required by other teams as the need occurs.  

The architecture of the various interfaces is still a work in progress, but conceptually, it would facilitate a mode of data transmission that is easy to execute and compatible across all platforms of the avionics teams and the simulation teams. For example; we have explored the idea of using a radio modulation scheme such as <a href="https://www.semtech.com/products/wireless-rf/lora-transceivers" target="_top">LoRA</a> to retrieve and store sensor data emmitted by the rocket. In this scenario, the communication interface should be capable of requesting the avionics system for the sensor data, and should also be capable of transmitting the extracted information back to the avionics system or simulation system if there is a need to do so.

Memory contstraints have not yet been specified for this system, but we will focus on minimizing or avoiding exhaustive processes where possible, to conform with the primary and secondary memory characteristics of our system. 

The operational constraints as well as the Site adaptation requirements are still under discussion. These requirements will be updated as development progresses.

#### 1.3.2 Product functions

The minimum viable product of the mission control software is characterised as:

 - Being able to run on a laptop at the rocket launch site.
 - Being able to communicate with the rocket hardware.
 - Displaying relevant data (software state, location of the rocket, altitude of the rocket).
 - Integrating with the monte-carlo rocket simulation and using weather reports to determine probable landing location. If the predicted location is not within the defined bounds then the mission control software should signal that the launch should be aborted.
 - Being able to communicate with the rocket to let it know a launch is imminent, allowing the avionics to arm the parachute ejection charges.

 The functionality of the mission control software will be extended by:

- Suggesting the ideal launch rod angle to ensure the rocket stays within the defined bounds.
- Using current wind reports and the monte-carlo simulation to determine the optimal upwind trajectory that the rocket should follow to minimise the distance of the landing location from the launch site.

#### 1.3.3 User characteristics   

The client has specified that they would like the mission control software to be open source. This means that the mission control software will be available to the entire amateur rocket community. A consequence of this is that there are no strict limitations on the education level, disabilities, and experience of the end user. However, given the context of a mission control software designed to be used in conjunction with an amateur rocket, it can be reasonably assumed that the end user:

 - Has an understanding of how to integrate the mission control software with the rocket hardware.
 - Has the technical expertise to operate a laptop that has the mission control software installed.
 - Is able to understand the readings and suggestions from the software.
 - Is able to utilise readings and suggestions from the software to influence launch factors.

#### 1.3.4 Limitations

Limitations on the product are : <br />
  * The system won't be able to operate in extreme weather beacasue the electronics could be damaged in the wet with both the rocket and the laptop that the mission conrol software is operating on (assuming that both of these aren't water resistant). Overhanging cloud could affect comunication with the rockets GPS. Casuing errors, which may lead to losing the rockets where abouts or directing the rocket onto a bad flight path.

  * When the rocket is flying, the mission control software is communicating the rocket via radio comunications. These radio communications are limited to rignal range and sttrength, which can be affected by step hills in the nearby area. Which could cause errors in path updates and adjustments.
  
  * There is a limit with data being sent to the rocket and receive being receive. Radio waves can only travel a such a speed that there will be a slight delay of on the data being sent to the rocket as well as data being sent back from the rockets. Also depending on the hardware operating the mission control software there could be slight delays in processing information that has come from the rocket, which also applies for the data being processed on the rocket itself.  
  
  * The communications of the rocket will be limited to the hardware used by the avionics team.

## 2. References

*  “Keeping New Zealand  skies safe and secure  ,” CAA and Avsec. [Online]. Available: https://www.aviation.govt.nz/. [Accessed: 10-May-2020].

*  "ISO/IEC/IEEE 42010:2011(E) (Revision of ISO/IEC 42010:2007 and IEEE Std 1471-2000)", Ieeexplore-ieee-org.helicon.vuw.ac.nz, 2011. [Online]. Available: https://ieeexplore-ieee-org.helicon.vuw.ac.nz/stamp/stamp.jsp?tp=&arnumber=6129467. [Accessed: 15- Jun- 2020].

*  P. Kruchten, "Architectural Blueprints—The “4+1” View Model of Software Architecture", Cs.ubc.ca, 1995. [Online]. Available: https://www.cs.ubc.ca/~gregor/teaching/papers/4+1view-architecture.pdf. [Accessed: 18- Jun- 2020].

## 3. Specific requirements  

<!-- 20 pages outlining the requirements of the system. You should apportion these pages across the following subsections to focus on the most important parts of your product. -->

This section will be completed at a later time.

### 3.1 External interfaces  
**Radio Antenna**  <br />
The radio antenna will be used to do minimal communication to the rocket for locating and small amounts of debugging. The antenna will act to provide the communication to and from the rocket on a continuous basis. This will transmit the GPS information from the rocket as well as data on the rocket’s performance for later evaluation. Performance data will include the gimbal states, inertial measurements, servos power inputs and coordinates from GPS.  
**SD Card**  <br />
The SD card will act as a Blackbox to the rocket to store the data collected over the flight for later diagnosis. The data will be either stored in a CVS or text file. This data will include the inertial measurement unit output, GPS and gimbal position at the end of every control loop. The write rate of this SD will need to be fast enough to keep up with the data flow from each control loop and not impact the speed of the microcontroller.   
**Inertial Measurement Unit**  <br />
The Inertial Measurement Unit (IMU) will measure the change in both linear and rotation acceleration of the rocket. The output from this will be stored on the SD card. This data will be used for controlling the gimbal position.   
**Gimbal**  <br />
The gimbal is used for inflight adjustments to correct the rockets course up. The gimbal acts to adjust the motors nozzle direction which in turn changes the relative thrust of the rockets to correct its direction up. The servos will act to move the gimbals position by adjusting the pit and yaw. The adjustments needed are computed in the processor onboard from the flight data.  
**Servos**  <br />
The servos will receive the computational instructions from the onboard processor to alter the rockets course by adjusting the gimbals position. There will be two servos for adjustments, one yaw and other for pit. The data given to the servos will specify the amount of degrees to rotate the gimbal by. The end position of the gimbal is output back.  

### 3.2 Functions  
**Stakeholder requirements** 

	Avionics package shall fit entirely into a 29mm airframe rocket vehicle.  
	Avionics package will interface with the gimbal.  
	Avionics package will guide the rockets course.  
	Avionics package blueprints and information will be published to the clients GitHub as open source.  
	The avionics package logical database will be human readable in the form of a text file.  
  
**Use Case**  <br />
The purpose of the avionics package is the guide the rocket. For it to be able to do this it needs in be installed, configured, calibrated and then launched. After the flight the clients will also want to look over the flight data to diagnose what happened. So gives 5 main uses: installation, configuration, calibration, launch, and diagnosis.  
**Installation**  <br />
For the rocket, the avionics package must be easy to install for ease of use. So will need the package to be spatially efficient as well as simply made as to make it even easier to use.  
**Configuration**  <br />
The rocket should be easy  to configure for both the hardware and software. This part should only need like 10 minutes to have it fully ready.   
**Calibration**  <br />
Before launch, all final changes will be made so the rocket is fully prepared for take-off. This will mean all final checks on parts like the SD card working to collect data and such. Will also have tests of the gimbal moving right and if the data is being correctly used. Will also be when all sensors are adjusted if needed too.  
**Launch**  <br />
Once launch begins the rocket will be fully under its own control so all systems will be operations to give it a successful flight. once at maximum height the rocket will switch to a safety state to allow it to safely go back to earth.   
**Diagnosis**  <br />
After flight, the rockets data will be collected to look over for what happened in the flight. This will be all used to help future flight for the rocket.  
  
  
### 3.3 Usability Requirements  
In this project the rocket’s software will need to be able to keep up with what the rocket can do mainly. This will mean the efficiency of the software has to be enough to keep up with the control loops and not have any losses in recording data. The software will also have to be reasonably accurate  to correctly control the rocket during its flight up too. So for the project it will mean we need to be able to quickly read all the incoming data from the external interfaces onboard and received data too over the radio. This will then have to process efficiently to be output to the rocket controls as well as to the SD card and radio back to ground. On the ground the software will need to be able to be constantly updated at the speed the rocket sends off the data.   

### 3.4 Performance requirements  
**In this section I am quite unsure of what numbers we should use so just using theirs** 
  
During the rockets flight the rocket will be traveling at quite a high speed so the avionics package will need to be able to keep up with it. This will mean that the system will have to do a control loop every time the rocket travels a metre. This will allow enough time for the adjustments to be made to allow for a smoother flight. If this was slower the system will be working with too old of information and not be able to correctly correct continuously. Next the radio will need a range of 80m without line of sight to allow for easy collection. As 80m will likely be as far as the rocket will travel horizontally from launch pad. The GPS then from the rocket will need to be accurate to within 10m to allow use to even find the rocket after it lands.  
The rocket will allow have to be made durable enough to survive the flight and landing or else it will ruin the cost efficiency of the rocket. The components will need to be able to withstand acceleration of 200 metres per second per second. All components within must be able stay in positions within too as to not damage it. As we want this to be able to withstand 10 flights at least.  
  
### 3.5 Logical database requirements  
**Microcontroller Driver**  <br />
This will handle general initialization and is responsible for communicating to every component. Also, for storing the flight data to the SD card.  
Inertial Measurement Unit Driver  
This reads from the Inertial Measurement Unit. This allows the microcontroller to access the data about the accelerometer, gyro, and magnetometer.   
**GPS Driver**  <br />
This connects to the GPS module. Will feed the GPS data to the microcontroller. Is vital for finding rocket after landing.  
**Sd Card Driver**  <br />
Will log the flight data from the rocket during flight. This will store everything from time to position to position of gimbal. Will used to later diagnose what happened during flight.  
**Radio Driver**  <br />
The radio is used to communicate to the ground control team. This is mainly used to send the location of the rocket for easy collection. This is also used to send commands over to the rocket (such as a kill command).  

### 3.6 Design constraints  
**Radio antenna and GPS system unit**  <br />
The radio must comply with all New Zealand regulation relating to radio communication. This means there are frequencies we are not able to use. Also due to other interference we will be quite limited on what frequencies we can use or else it could become illegal and corrupted. Also for the GPS it will need to use the legally allowed frequencies.  
**Open Source**  <br />
As the client specified all the final product must be open source. After project is finished all code must be released.  
**Physically constraints**  
Again, the rocket must comply with New Zealand aviation laws:  
-	Rocket cannot have more than 125g of propellant.  
-	Rocket cannot produce more than 320 newton second of impulse.  
-	Rocket must use slow burning propellant.  
-	The rocket needs to be made from light weight materials such as plastic and wood.  
-	Rocket cannot have any part of body fashioned from metal.  
-	Rocket cannot exceed a weight of 1.5kg.  
-	The rocket must not use a aerial firework as an ingredient to create its own jet.  

### 3.7 Nonfunctional system attributes

**Open source**
As the program is made to become an open source avionics package at end of the project. This means all the things used to make the system will need to be also open source so any rocket enthusiast can pick up the package and use it. This will include all coding software and hardware used.

**Reliable (fault tolerance)**
The rocket will need to be made with the idea that not everything will work perfectly on the day of flight. So, the system will be made with a capacity to handle any errors. This will be in all parts of the system from communication to use of gimbal.

**Cost effective**
These systems are made for enthusiast and not NASA, so the package will be made with cost as an obstacle. So, we need to make it so it will work with cheaper options and not cost thousands to dollars to use.

**Ease of deployment**
As this is meant to be used by other people not involved with the development, we need to make it all easy to setup. We want it to be a simple pick up and put in sort of system so others can use it easily.

**Safety**
We are working with a powerful rocket so safety will be a big aspect of the production. We want the rocket to be able to go safely and if something goes wrong for the rocket to not injure someone or be destroyed. So measures will have to put in place along with the error tolerances to ensure it is safe to use.

**High performance**
As the rocket will be very fast the package must be able to keep up with the rocket. So, the software must be made to keep up with the rocket as well as the gimbal and such being able to react fast enough to the changes in the rocket. This will also have to be balanced with safe and readable coding. 

**Coding standards**
This package is not made to be only used by the teams developing them so the system will need to make as such that other people will be able to understand the coding. To help this we will use the general coding standards, so the styles are all similar and readable to other people.

**Cross platform use**
The whole system will have to be written in a few languages no matter how it is done as open rocket is in java and the LORA is done in C. So, the whole thing must be written in such a way that any platform can interact with it without fault. This will also be extended to the device with is run on too as mac, windows and Linux can have issues running the same thing. This will need to be addressed especially if we are using low level languages like C.

**Testing**
The package  must be able to fully testable without flight. This will mean simulations or grounded flight. As it such a dangerous system we need to be able to safely to do all the testing without risking safety. We will use such things as unit tests for the software but will likely need more advanced methods for whole systems.

**Integration with other parts**
As this will be open to anyone to use, we must consider that not everyone will use the same parts for the rocket so we must be able to take this into account somehow.

**Efficient coding**
The code must be made with speed in mind in order to keep up with the rocket. This will mean a large constraints loops and expensive operations.

**Scalable to different sized rockets**
We want this to be able to be used by another rocket and not just the one we are making for. So, we need to have this able to scale up to larger rockets.

**Communication integrity**
The communication between the rocket and ground is important so it also important that the correct message is send and received. For this we will need to implement redundancy and check to ensure we are getting the right messages.

**Reporting**
The avionics package must be able must be able to report what is always happening  for later analysis. This is also for the mission control so that we can see no errors are occurring too.

### 3.8 Physical and Environmental Requirements 

**The following criteria regarding rockets build:**
-	Weight: 60g excluding the C-motor; 79g including C-motor and framework around.
-	Dimensions: the height of MVP 1 is of a broad cone shape with radius= 9cm, height= 9cm.
-	Inside the cone, there is a holder with encapsulates the C-motor and is like that of a cylinder with radius= 0.1cm and height= 7cm.
-	Volume: MVP stage 1 includes only the rockets first stage which has a approximate volume of 763.41cm^3.

**Physical components:**
-	C-motor: low powered rocket motor capable of 14.1 newtons of thrust.
-	Teensy 3.2: microcontroller on board the rocket. Used to control the Gimbal.
-	MPU 9520 IMU: located within the rocket, connected to the Teensy.
-	RFM96W Radio: located on the base station for receiving any information sent from rocket.
-	Teensy 3.6: microcontroller used at the base station.
-	A2200A GPS: located on the Teensy 3.6.

The avionics package is required to collect data from the flight which includes all gimbal data and location data. This will be sent over a wireless channel to the ground team for research and recovery purposes. 

The rocket is required to be able to be flown in all conditions listed under 9.4.11 of the IEEE standards [insert reference stuff]. As well as complying with the CAA weather regulations (specifically subpart D of CAA part 101 rules)[insert reference stuff]. Regulations state:
-	A rocket shall not operate within 4km of an aerodrome boundary.
-	A rocket shall not be flown if cloud coverage is extensive, as well as if visibility is below 8km.

The rockets control system must be able to correct rocket in winds up to 30km/h. As up to this speed the flight will continue as planned.

The residents in the local area require that the rocket will not pose a threat to them. So, avionics package must be reliable and safe to use in the local areas.

The rocket must be open source so any rocket lovers can use and edit this to their liking.

The engineering department of Victoria requires that we follow all the guidelines set out by them.

The local council requires that the rocket can operate without violating any of the laws or regulations for the area. Also, that no damage happens too.

The Civil Aviation Authority requires us to follow all their regulation relating to rockets. These are all set out by CAA regulations part 101 [insert reference] 

For operation, the launch shall not happen in winds exceeding 30km/h. The rocket shall not be flown at night. The rocket shall not be launched if cloud coverage is greater than 50%.

### 3.9 Supporting information

With the project being made open source it will mean the project can be forever be updated with new methods and techniques. This will allow for a great longevity of the project and be far more useful to people in the rocket community to use. 
We want this to be able to be open to anyone to use and for them to be able to understand what is happening in the avionics system.
see 9.5.19. 

## 4. Verification

<!-- 3 pages outlining how you will verify that the product meets the most important specific requirements. The format of this section should parallel section 3 of your document (see 9.5.18). Wherever possible (especially systemic requirements) you should indicate testable acceptance criteria. -->

This section will be completed at a later time.

## 5. Development schedule.

### 5.1 Schedule

Identify dates for key project deliverables: 

**Minimum Viable Product** <br />
The minimum viable product which is specified in part 1.3.2 will completed by 25 September 2020

**Further Releases** <br />
The final product will be completed by  6 November 2020


### 5.2 Budget

At this stage, we do not require a budgetary allocation as we do not have any forecasted expenses. The mission control system will rely on equipment and tools belonging to
the Avionics team and the Simulation team, and we currently do not plan on purchasing any resources or tools. 

If the need arises in the future, we intend on requesting an allocation from the customer in the form of a formal request. 

### 5.3 Risks 

Identify the ten most important project risks to achieving project goals: their type, likelihood, impact, and mitigation strategies (3 pages).

If the project will involve any work outside the ECS laboratories, i.e. off-campus activities, these should be included in the following section.

| Risk | Risk Type | Likelihood | Impact | Mitigation Strategies |
| ------ | ------ | ------ | ------ | ------ |
| COVID 19 | Health and Safety | 2 | 5 | All team members will follow government and univeristy advice/requirements. Working from home and personal devices where possible. If use of shared devices/resources are needed then team members must ensure that correct levels of PPE and personal hygine and followed|
| Rocket entering restricted airspace  | legal, Health and Safety | 1 | 5 | The launch site will be carefully chosen by the client. The Client will be able to use the mission control software to gather information about wind speed/direction, possible landing zone, recommendations to launch parameters and other information that will impact the clients choice of launch location. |   
| Weather Conditions moving the rocket out of the predicted landed zone  | Environmental | 5  | 5 | The mission control software will be able to pull weather data in advance of the lanuch. If any of the weather paramenters are outside of the recommended ranges provided by the CAA regulations 101 launch will be aborted.|   
| Occupational Over Use  | Health and Safety | 3 | 3 | Team members must take breaks to avoid any computer use related health issues. e.g. Eye strain, repetitive strain injury etc|   
| Engine ignites prematurely | Health and Safety | 2 | 4 | During stoarge and transport, the engine will be kept separate from heat/electrical sources. The mission Control safety lock will be only disabled only when the go singal has been given. |   
| Fire caused by rocket launch/landing | Health and Safety | 2 | 5 | The launch chosen in advance will be an open field. The local fire risk will be checked before hand, and if the level for the chosen area is HIGH or above the launch will be canceled or moved to another area with a lower fire danger level. |   



### 5.4 Health and Safety

<!-- Document here project requirements for Health and Safety.   All teams must state in this section: -->

All team members must take regular breaks to reduce the risks of Occupational Over Use, e.g. eye strain, repetitive strain injuries etc. Strict Cable management will be practiced at all work sites. Ensuring electronics are connected to mains or surge protected extenders, cables are run and routed out of the way of high foot traffic areas and ensuring that all Emergency exit are clear at all times.
Range and reliability testing on the LO-RA modules may be required, as such this will be undertaken at Victoria Univeristy Kelburn campus and around the Wellington CBD. If use of these test sites are required then all team members will follow health and safety, radio protcols and traffic laws etc from the govering body for said areas.  
As we are creating mission control software, the need to gather user feedback and test usability may be required. If so all test users will give their consent for their use and comments on the software to be observed and recorded in a testing log. To ensure that user testing meets the Ethical Approval of the univeristy, ECS department and to ensure the privacy of the test users, a redacted verison of the results will be inclued in the project documents only if needed. 

**Discussions/briefing with Roger Cliffe (Victoria Univeristy of Wellington Safety Officer):**

Date: 8 May 2020 - Briefing on the Health and Safety Act 2015
This was a mandatory lecture were the Health and Safety Act of 2015 and what it imolementations are for us.Safety Plans and Risk management strategies were also discused, e.g. a Risk Matrix.

#### 5.4.1 Safety Plans

**Launch Site Safety:** 

As required by the CAA NZ Regulations Part 101.155 the rocket launch will not take place within 4 km of an aerodrome
unless the following is met:
*  The Rocket does not fly above 400 feet AGL.
*  At uncontrolled aerodromes, operates with agreement from the aerodrome operator.
*  At controlled aerodromes, operates with authorisation from ATC.
*  Is not operated on or over any active aircraft movement areas.
*  Is not operated on or over any active runway strip areas.

The rocket launch will not take place between 4 and 8 km of an aerodrome if the rocket will fly above 400 feet AGL.
This is to ensure the safety of the rocket operators, personnel at the aerodromes and members of the general public 
traveling to/ from the aerodrome and in the surrounding areas. 

As required by the CAA NZ Regulations 101.157 and 101.159 the launch will not take place if any of the following 
are true: 
*  It is night-time
*  There are clouds or obscuring phenomena of more than four-eights coverage.
*  The horizontal visibility is less than 8 km.
*  The rocket will operate in a cloud.
*  Heavy precipitation
*  High wind speeds (Upper wind speed limit TBC after further discussions with Avionics teams and client). 

The Launch will be supervised by Andre Geldenhuis. As Andre is an experienced model rocketeer, he will be responsible
for launching the rocket, disarming the charges/ ignition switches if the launch is aborted/ the need arises. As the 
Rocket motor is classified as a Class 1 dangerous good under the Land Transport rule: Dangerous Goods 2005, 
transportation of the motors to and from the launch site will be under taken by Andre as he is experienced in safe 
methods of carrying out this procedure. 

Once a launch site has been identified and chosen, per CAA regulations part 101.161. the following information 
will be submitted to the NZ NOTAM office at least 24 hours before launch: 
1. Their name, address, and telephone number or, where there are multiple participants at a single event, the name, 
address, and telephone number of the person whose duties include coordination of the launch data estimates 
required by paragraphs (2), (3), and (4) of this rule and co-ordinating the launch event.]
2. The estimated number of rockets to be operated.
3. The estimated size and the estimated weight of each rocket.
4. The estimated highest altitude or flight level to which each rocket will be operated.
5. The location of the operation. 
6. The date, time, and duration of the operation. 
7. Any other relevant information requested by the person to whom notification is given.

Prior to launch the launch site will be checked for any hazards and mitigation strategies will put in place that 
follow the NZ Rocketry Association Safety code (exact mitigations to be confirmed once launch site is confirmed). 
A countdown will be used in order to notify all participants and people in the launch area that the launch is 
imminent. This countdown can be halted at the request of anyone in the launch area. If the motor fails to ignite 
or misfires, safety interlocks will be re-engaged, and Andre will disarm the rocket after waiting 90 secs before 
approaching the rocket. Andre will determine when the all clear is given. 

The Rocket trajectory will be calculated to be as vertical as possible to reduce the change of the rocket traveling 
too far from the launch site/ entering airspace where the risks are greater.

All participants at the launch site must wear the necessary PPE.

**Software Development Safety:**

All team members must take regular breaks to reduce the risks of Occupational Overuse, e.g. eye strain, repetitive 
strain injuries etc. Strict Cable management will be practiced at all work sites. Ensuring electronics are connected 
to mains or surge protected extenders, cables are run and routed out of the way of high foot traffic areas and
ensuring that all Emergency exit are clear at all times.

Range and reliability testing on the LO-RA modules may be required, as such this will be undertaken at Victoria 
University Kelburn campus and around the Wellington CBD. If use of these test sites is required then all team 
members will follow health and safety, radio protocols and traffic laws etc from the governing body for said areas.  

**COVID 19 related Safety:**

All team members will follow government and university advice/requirements. Working from home and personal devices 
where possible. If use of shared devices/resources are needed then team members must ensure that correct levels of 
PPE and personal hygiene are followed.

**As our project is purely software, we have only added the launch site safety plan as a precaution in cause we need to be present at the launch.**

<!-- _If the project is purely software and requires no contact risks involving physical harm, then state "Project requirements do not involve risk of death, serious harm, harm or injury." in this section._ -->


## 6. Appendices
### 6.1 Assumptions and dependencies 

One page on assumptions and dependencies (9.5.7).

*  Our hardware will use a LoRa radio transceiver and a teensy microcontroller along with a signal receiver dongle
*  The launch will follow guidelines of the CAA pertaining to launch conditions
*  The success of mission control will depend on correct and accurate simulations of launches based on various conditions
*  Our software will depend on the correct units being transmitted via the avionics hardware. Therefore the hardware and software need to assume the same units of data
*  The computers used will have adequate power prior to the launch

### 6.2 Acronyms and abbreviations

CAA (Civil Aviation Authority): Responsible for the rues that govern managing the risks arounds aviation systems

NOTAM (Notice to Airmen): Notice issued by Airways NZ to alert aircraft of an event within the airspace

AGL: Above Ground Level

ATC: Air Traffic Control

## 7. Contributions

A one page statement of contributions, including a list of each member of the group and what they contributed to this document.

| Team Memeber | Contribution |
| ------ | ------ |
| Alex Jackson  | 6.1 |
| Chris Burt  | 1.3.4, 5.1 | 
| Ethan King | Table of Content, 5.3, 5.4, 5.4.1 |
| Henry Pettit | 3 | 
| Nirari Awas | 1.3.2, 1.3.3 |
| Ruvindu Wijeratne | 1.3.1, 5.2 | 
| Thomas Rainford | 1.0, 1.1, 1.2 |




<!-- ## Formatting Rules 

 * Write your document using [Markdown](https://gitlab.ecs.vuw.ac.nz/help/user/markdown#gitlab-flavored-markdown-gfm) and ensure you commit your work to your team's GitLab repository.
 * Major sections should be separated by a horizontal rule.


## Assessment  

The goal of a requirements document is the problem you are attempting to solve:  not a first attempt at a solution to that problem. The most important factor in the assessmernt of the document is how will it meet that goal. The document will be assessed for both presentation and content. 

The presentation will be based on how easy it is to read, correct spelling, grammar, punctuation, clear diagrams, and so on.

The content will be assessed according to its clarity, consistency, relevance, critical engagement and a demonstrated understanding of the material in the course. We look for evidence these traits are represented and assess the level of performance against these traits. While being comprehensive and easy to understand, this document must be reasonably concise too. You will be affected negatively by writing a report with too many pages (far more than what has been suggested for each section above).

We aim to evaluate ENGR301 documents and projects as if they were real projects rather than academic exercises &mdash; especially as they are real projects with real clients. The best way to get a good mark in a document is to do the right thing for your project, your client, and your team. We encourage you to raise questions with your tutor or course staff, as soon as possible, so you can incorporate their feedback into your work. -->

---
