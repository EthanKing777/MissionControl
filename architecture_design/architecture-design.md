# ENGR 301: Architectural Design and Proof-of-Concept

## Proof-of-Concept

<!--The aim of an architectural proof-of-concept (spike or walking skeleton) is to demonstrate the technical feasibility of your chosen architecture, to mitigate technical and project risks, and to plan and validate your technical and team processes (e.g., build systems, story breakdown, Kanban boards, acceptance testing, deployment).

A walking skeleton is an initial technical attempt that will form the architectural foundation of your product. Since a walking skeleton is expected to be carried into your product, it must be completed to the quality standards expected for your final product. A walking skeleton should demonstrate all the technologies your program will rely on "end-to-end" &mdash; from the user interface down to the hardware.

In the context of ENGR 301, a walking skeleton does not need to deliver any business value to your project: the aim is technical validation and risk mitigation.


## Document

The aim of the architectural design document is to describe the architecture and high-level design of the system your group is to build, to identify any critical technical issues with your design, and to explain how you have addressed the highest rated technical and architectural risks. The architecture document should also demonstrate your understanding of architectural techniques and architectural quality, using tools and associated notations as necessary to communicate the architecture precisely, unambiguously and clearly in a written technical document.

Page specifications below are *limits not targets* and refer to the pages in the PDF generated from the markdown. Because the size of your document is necessarily limited, you should ensure that you focus your efforts on those architectural concerns that are most important to completing a successful system: if sections are at their page limit, indicate how many items would be expected in a complete specification.

The ENGR 301 project architecture design document should be based on the standard ISO/IEC/IEEE 42010:2011(E) _Systems and software engineering &mdash; Architecture description_, plus appropriate sections from ISO/IEC/IEEE 29148:2018(E) _Systems and software engineering &mdash; Life cycle processes &mdash; Requirements engineering_; ISO/IEC/IEEE 15289:2017 _Systems and software engineering &mdash; Content of life-cycle information items (documentation)_; ISO/IEC/IEEE 15288:2015 _Systems and software engineering &mdash; System life-cycle processes_; ISO/IEC/IEEE 12207:2017 _Systems and software engineering &mdash; Software life cycle processes_ and ISO 25010 SQuaRE; with notations from ISO/ISE 19501 (UML). In particular, Annex F of ISO/IEC/IEEE 15288 and Annex F of ISO/IEC/IEEE 12207. These standards are available through the Victoria University Library subscription to the [IEEE Xplore Digital Library](https://ieeexplore.ieee.org/) (e.g., by visiting IEEE Xplore from a computer connected to the University network).

The document should contain the sections listed below, and conform to the formatting rules listed at the end of this brief.

All team members are expected to contribute equally to the document and list their contributions in the last section of the document (please make sure that your continued contribution to this document can be traced in GitLab). You should work on your document in your team's GitLab repository in a directory called "M2_Architecture". If more than one team member has contributed to a particular commit, all those team member IDs should be included in the first line of the git commit message. ``git blame``, ``git diff``, file histories, etc. will be tools used to assess individual contributions, so everyone is encouraged to contribute individually (your contribution should be made to many sections of the document, rather than focusing on just a single section), commit early and commit often.

---
--> 

# ENGR 301 Project *Mission Control Software* Architectural Design and Proof-of-Concept

**Authors:** Alex Jackson, Chris Burt, Ethan King, Henry Pettit, Nirari Awas, Ruvindu Wijeratne, Thomas Rainford

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

<!-- One paragraph describing the scope of the system. -->

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

### 1.3 Changes to requirements

If the requirement have changed significantly since the requirements document, outline the changes here. Changes must be justified and supported by evidences, i.e., they must be substantiated. (max one page, only if required)

## 2. References


*  “Keeping New Zealand  skies safe and secure  ,” CAA and Avsec. [Online]. Available: https://www.aviation.govt.nz/. [Accessed: 10-May-2020].

*  "ISO/IEC/IEEE 42010:2011(E) (Revision of ISO/IEC 42010:2007 and IEEE Std 1471-2000)", Ieeexplore-ieee-org.helicon.vuw.ac.nz, 2011. [Online]. Available: https://ieeexplore-ieee-org.helicon.vuw.ac.nz/stamp/stamp.jsp?tp=&arnumber=6129467. [Accessed: 15- Jun- 2020].

*  P. Kruchten, "Architectural Blueprints—The “4+1” View Model of Software Architecture", Cs.ubc.ca, 1995. [Online]. Available: https://www.cs.ubc.ca/~gregor/teaching/papers/4+1view-architecture.pdf. [Accessed: 18- Jun- 2020].

## 3. Architecture

<!--Describe your system's architecture according to ISO/IEC/IEEE 42010:2011(E), ISO/IEC/IEEE 12207, ISO/IEC/IEEE 15289 and ISO/IEC/IEEE 15288.

Note in particular the note to clause 5 of 42010:

_"The verb include when used in Clause 5 indicates that either the information is present in the architecture description or reference to that information is provided therein."_

This means that you should refer to information (e.g. risks, requirements, models) in this or other documents rather than repeat information. -->

### 3.1 Stakeholders

| Name | Position | Project Role | Contact Information |
|:----:|:--------:|:------------:|:-------------------:|
|Andre Geldenhuis|Research Software Engineer|Client|andre.geldenhuis@vuw.ac.nz|
|Aaron Chen|Course Coordinator|Administration|aaron.chen@ecs.vuw.ac.nz|
|Craig Anslow|Course Lecturer|Administration|craig.anslow@ecs.vuw.ac.nz|
|Chansocheat Chheang|Tutor|Senior Manager|chansocheatchheang@gmail.com|
|Christopher Burt|Student|Developer|cvburt08@gmail.com|
|Ethan King|Student|Developer|ethank.842@gmail.com|
|Alexander Jackson|Student|Developer|wellyboyjacko@gmail.com|
|Thomas Rainford|Student|Developer|thomas@rainfords.net|
|Henry Pettit|Student|Developer|henry.g.c.pettit@outlook.com|
|Nirari Awas|Student|Developer|awasnira@ecs.vuw.ac.nz|
|Ruvindu|Student|Developer|ruvindu.w@gmail.com|
|Roger Cliffe|Support Staff|Health & Safety|ecs-safety@ecs.vuw.ac.nz|
|Stuart Marshall|Head of School|Health & Safety Reports|stuart.marshall@vuw.ac.nz|
|Software Technicians|Support Staff|Resources/ Configuration Changes Support|jobs@ecs.vuw.ac.nz|
|Software Technicians|Support Staff|Problems/ Bugs Support|bugs@ecs.vuw.ac.nz|
|Electronics Technicians|Support Staff|Electronic Components Support|electronics@ecs.vuw.ac.nz|

### 3.2 Architectural Viewpoints

<!-- Identify the architectural viewpoints you will use to present your system's architecture. Write one sentence to outline each viewpoint. Show which viewpoint frames which architectural concern.
--> 

**Logical:** Is used to break down the system into key concepts and explaining the functionality of the system as a whole and of each key concept to end-users. 

**Development:** Describes the architecture of the software development cycle and addresses concerns of how software is being managed. 

**Process:** Describes dynamic and non-functional system requirments and explain how these concepts from the logical viewpoint fit within the project as a whole. 
             Examples of dymanic and non-functional requirments are: performance, the integrtors between parts of the system.
             
**Physical:** Describes how our Mission Control software is going to be mapped and interact with the hardware components from different teams and discussing scalability, performance, reliability, etc of the system.

**Senarios:** Describes interaction between users, processes, users and the system, software and hardware etc and compiled into use cases. This allows us to carry out a qualitative review of our architectures. 
 
## 4. Architectural Views

<!--(5 sub-sections of 2 pages each sub-section, per 42010, 5.5, 5.6, with reference to Annex F of both 12207 and 15288) 

Describe your system's architecture in a series of architectural views, each view corresponding to one viewpoint.

You should include views from the following viewpoints (from Kruchten's 4+1 model):

 * Logical
 * Development
 * Process
 * Physical 
 * Scenarios - present scenarios illustrating how two of your most important use cases are supported by your architecture

As appropriate you should include the following viewpoints:

 * Circuit Architecture
 * Hardware Architecture

Each architectural view should include at least one architectural model. If architectural models are shared across views, refer back to the first occurrence of that model in your document, rather than including a separate section for the architectural models.
--> 
### 4.1 Logical
The logical view presents the communicational and functional responsibilities of the system. In this case, CRC cards along with connections between them show the logical view of our system. An advantage of using CRC cards is because considering the early stages of research we are in, these boxes are subject to change. 
However, when these classes are implemented the CRC cards can be converted into class diagrams that will show specifics about fields and methods. This diagram does not constrain the architecture to a particular medium which leaves it open to scalability. 

![Imgur](https://i.imgur.com/ckNukat.png)

figure x

The frontend is where all the graphical elements will be displayed to the mission control team. This includes textual and graphical elements being updated in real time based on variables changing within the rocket.
Simulations within Monte Carlo will also be presented here as static graphs after requesting and processing time.

The backend contains the deployment software of the localhost that the frontend will operate on. The backend holds all the information needed and communicates with the necessary
APIs from external sources. It also makes comparisons and conclusions based on the data such as upwind trajectory and landing zone information that can be passed on to other people. 

### 4.2 Development
The Development view presents the responsibilities surrounding the development cycle and it’s management, including module/ functional programming, ensuring that the 
design of the application and it’s tests are consistent, performance is as expected and maintained and that all developers and testers are using GIT, branching, issue
tracking appropriately to better improve the development of the application. This view is concerned with it the Developers, testers and possible the ECS software 
technicians and effects all software areas of the project. 

There are many risks associated with the development viewpoint that we hope to combat via good development practices, such as too much or too little details in 
planning, developers not being committed or lazy. The development practices we are implementing are but are not limited to a clear modularization of
the application, Good GIT practices such as creating and tracking epics, milestones, issues, and each being tracked and distributed among the developers.

**modularization of the Application:**

Breaking the application down in to modules allows different developers to work on different parts of application independently of other “sub-teams” as 
well as reducing the amount of dependency they have to one another, so modules should be fairly easy to add, update, remove as necessarily without majorly 
effecting other parts of the mission control application.  

![Example of modularization diagram](https://gitlab.ecs.vuw.ac.nz/course-work/engr300/2020/group11/group-11/-/blob/master/Images/Example_of_modulariazrion_diagram.png)

figure x Example of modularization of different aspects of the application
    
**Good Git practices:**

Good Git practices include but are not limited to:
    
*  Branching 
   
*   Boards
   
*   Epics, Milestones, Issues
    

Branching allows developers to create/update/remove modules and ensure their safety by storing them, not just locally but also independently of the master branch.  
Allowing developers to push safety what they have done, without effecting the master, keeping code that has not been fully integrated/ buggy code out of the way of 
others. Branching allows us to review new modules/ changed modules before it is placed in the master and we can either reject the merge request or approve it if there 
are no issues. 

The use of Epics, Milestones and Issues allows us to modularization of the application into manageable tasks, that can be completed, tracked, and maintained easily. 
This also helps with a consistent development styles, Consistent development style, Layered Style of development and planning sprints. 
    
**Consistent development style:**

Allows all developers to have a clear understanding of the system fits together and is going to integrate with the avionics and simulation  teams. This is 
achieved by the modularization the application, so components and processes are grouped in a meaningful, clear, and useful way. This also allows different 
teams on the team to quickly support on an issue if needed. Interactions between the different modules will all follow the same idea. During the planning of 
creating/updating/ removing modules, key things to discuss and think about are: What does this module add overall, what existing modules does this need to 
interact with, will it affect any other modules (existing or planned) etc. 
    
**Layered Style of development:**
Using a layered style for development allows us to break down different aspects of the application in to “layers”. This allows us to practise the idea 
that every layer has a responsibility and everything in that layer can depend on everything else in there, therefore as a whole reducing dependency.     
    
![Example of layered style of development](https://gitlab.ecs.vuw.ac.nz/course-work/engr300/2020/group11/group-11/-/blob/master/Images/Layered_style_of_development_diagram.png)

figure x Example of a layered style of development (Work in Progress) 
    
**Agile and Scrum:**

Allows us to manage the team in a more effective way, allowing us to break bigger parts of the application down into more manageable chucks, monitor and keep 
up to date with what other members of the team are working on and give support if needed, regular stand-ups and retrospectives allows all members of the team be 
caught up to date and allows members to take responsibility for the issues that have been assigned to them.  During our sprint planning sessions, a scrum leader is 
chosen, issues are created/ moved from backlog and assigned to team members  that’s are needed for the current milestone’s goal.
### 4.3 Process
...

### 4.4 Physical 
...

### 4.5 Scenarios
**Use Case 1:** Mary is currently at the launch site of her amateur rocket. Before she launches her rocket she wants to check where her rocket will potentially land. Mary can go to the 'landing site' tab in the software, and see a spread of potential landing spots based on local parameters. 

|User|System|
|----|------|
|Mary wants to see potential landing <br> sites|The system will display a 'landing site' tab, which Mary will <br>click to see the flight parameters window|
|Mary enters the parameters of the flight|The system will take the parameters of the flight such as the launch rod angle <br> and will calculate a spread of landing sites based off <br> the local weather, and will display the spread to the window|

**Use Case 2:** David wants to make sure that his amateur rocket is safe to launch before doing so. David can use the go / no go feature of the software to give clearance for the launch, before launching.

|User|System|
|----|------|
|David has set up the launch and is ready <br> to launch|The system will display a 'launch' tab, which David will <br>click to prepare for launch|
|David will be prompted to enter the parameters <br> of the flight|The system will take the parameters of the flight such as the launch rod angle <br> and will calculate a spread of landing sites based off the local weather.<br> If the landing site is safe for launch the system will respond with 'go'|
|David will then know it is safe to launch the rocket| |

**Use Case 3:** Mark is just about to launch his amateur rocket and wants to be able to track its flight. Mark can use the software to connect to his rocket via LoRa to track its flight path.

|User|System|
|----|------|
|Mark sets up his amateur rocket for launch <br> and wants to connect his rocket to the system|The system will have a 'connect rocket' button which Mark will click to connect<br> the rocket|
|Mark goes through the rocket connection instructions|The system will attempt to connect to Marks rocket, and<br> will indicate to him when it has done so|
|Mark will then click the 'launch' button| The system will go through the go / no go safety check and will indicate mark<br> when to launch|
|Mark will are the parachute and ejection charges<br> and will launch|The system will communicate with the rocket via LoRa to gather information<br> of the flight and display a flight path|  

**Use Case 4:** Emily has launched her amateur rocket and it seems to be flying well until suddenly the rocket turns horizontal and is flying uncontrollably. Emily would like to abort the flight so she can retrieve her rocket safely.

|User|System|
|----|-----|
|Emily's amateur rocket has started flying sideways|The system will be displaying an 'abort' button|
|Emily clicks the 'abort' button|The system will communicate to the rocket to cut the thruster and deploy the <br> parachute imidiately|
|Emily will collect the rocket from where it softly lands| |

**Use Case 5:** Amanda wants to check the current weather and the forecast at her launch site. So she goes the weather tab of the mission control software to see the weather information on her launch site.

|User|System|
|----|------|
|Amanda wants to check the weather data of her launch <br> site|The system will display a 'weather' tab, which Amanda will click|
|Amanda will enter the location of her launch site|The system will display information about the current weather status, as well as show <br> a forecast for the weather status of her launch site|

## 5. Development Schedule

_For each subsection, make clear what (if anything) has changed from the requirements document._ If unchanged, these sections should be copied over from the requirements document, not simply cross-referenced.

Schedules must be justified and supported by evidences; they must be either direct client requirements or direct consequences of client requirements. If the requirements document did not contain justifications or supporting evidences, then both must be provided here.

### 5.1 Schedule


1. prototype(s).
1. first deployment to the client.
1. further improvements required or specified by the client.


Identify dates for key project deliverables: 

**Minimum Viable Product** <br />
The minimum viable product which is specified in part 1.3.2 will completed by 25 September 2020

**Further Releases** <br />
The final product will be completed by  6 November 2020


### 5.2 Budget and Procurement

#### 5.2.1 Budget

At this stage, we do not require a budgetary allocation as we do not have any forecasted expenses. The mission control system will rely on equipment and tools belonging to
the Avionics team and the Simulation team, and we currently do not plan on purchasing any resources or tools. 

If the need arises in the future, we intend on requesting an allocation from the customer in the form of a formal request. 


(1 page). 

#### 5.2.2 Procurement

<!-- Present a table of goods or services that will be required to deliver project goals and specify how they are to be procured (e.g. from the School or from an external organisation). These may be software applications, libraries, training or other infrastructure, including open source software. Justify and substantiate procurement with reference to fulfilment of project goals, one paragraph per item.
(1 page). -->

| Component | Purchasing team | Cost | Procurer |
| ------ | ------ | ------ | ------ |
| LORA module | Avinonics | $20 - $40 (TBC) | External Vendor |

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


## 6. Appendices

### 6.1 Assumptions and dependencies 

  Our hardware will use a LoRa radio transceiver and a teensy microcontroller along with a signal receiver dongle
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


| Team Memeber | Contribution |
| ------ | ------ |
| Alex Jackson  | 6.1, 4.1 |
| Chris Burt  |  5.1,4.5 | 
| Ethan King | 5.3, 5.4, 4.2 |
| Henry Pettit | cell | 
| Nirari Awas |1.1, 1.0 |
| Ruvindu Wijeratne | 5.2, Table of Content | 
| Thomas Rainford | 1.0, 1.1, 1.2 |


<!--## Formatting Rules 

 * Write your document using [Markdown](https://gitlab.ecs.vuw.ac.nz/help/user/markdown#gitlab-flavored-markdown-gfm) in your team's GitLab repository.
 * Major sections should be separated by a horizontal rule.


## Assessment 

This document will be weighted at 20% on the architectural proof-of-concept(s), and 80% on the architecture design.

The proof-of-concept will be assessed for coverage (does it demonstrate all the technologies needed to build your project?) and quality (with an emphasis on simplicity, modularity, and modifiability).

The document will be assessed by considering both presentation and content. Group and individual group members will be assessed by identical criteria, the group mark for the finished PDF and the individual mark on the contributions visible through `git blame`, `git diff`, file histories, etc. 

The presentation will be based on how easy it is to read, correct spelling, grammar, punctuation, clear diagrams, and so on.

The content will be assessed according to its clarity, consistency, relevance, critical engagement and a demonstrated understanding of the material in the course. We look for evidence these traits are represented and assess the level of performance against these traits. Inspection of the GitLab Group is the essential form of assessing this document. While being comprehensive and easy to understand, this document must be reasonably concise too. You will be affected negatively by writing a report with too many pages (far more than what has been suggested for each section above).

---
--> 
