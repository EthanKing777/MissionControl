
## Document

The aim of the architectural design document is to describe the architecture and high-level design of the system your group is to build, to identify any critical technical issues with your design, and to explain how you have addressed the highest rated technical and architectural risks. The architecture document should also demonstrate your understanding of architectural techniques and architectural quality, using tools and associated notations as necessary to communicate the architecture precisely, unambiguously and clearly in a written technical document.

Page specifications below are *limits not targets* and refer to the pages in the PDF generated from the markdown. Because the size of your document is necessarily limited, you should ensure that you focus your efforts on those architectural concerns that are most important to completing a successful system: if sections are at their page limit, indicate how many items would be expected in a complete specification.

This project architecture design document should be based on the standard ISO/IEC/IEEE 42010:2011(E) _Systems and software engineering &mdash; Architecture description_, plus appropriate sections from ISO/IEC/IEEE 29148:2018(E) _Systems and software engineering &mdash; Life cycle processes &mdash; Requirements engineering_; ISO/IEC/IEEE 15289:2017 _Systems and software engineering &mdash; Content of life-cycle information items (documentation)_; ISO/IEC/IEEE 15288:2015 _Systems and software engineering &mdash; System life-cycle processes_; ISO/IEC/IEEE 12207:2017 _Systems and software engineering &mdash; Software life cycle processes_ and ISO 25010 SQuaRE; with notations from ISO/ISE 19501 (UML). In particular, Annex F of ISO/IEC/IEEE 15288 and Annex F of ISO/IEC/IEEE 12207. 

The document should contain the sections listed below, and conform to the formatting rules listed at the end of this brief.

All team members are expected to contribute equally to the document and list their contributions in the last section of the document (please make sure that your continued contribution to this document can be traced in GitLab). You should work on your document in your team's GitLab repository in a directory called "M2_Architecture". If more than one team member has contributed to a particular commit, all those team member IDs should be included in the first line of the git commit message. ``git blame``, ``git diff``, file histories, etc. will be tools used to assess individual contributions, so everyone is encouraged to contribute individually (your contribution should be made to many sections of the document, rather than focusing on just a single section), commit early and commit often.

---
--> 

# *Mission Control Software* Architectural Design and Proof-of-Concept

## 1. Introduction

Amateur rockets are flown regularly worldwide. These rockets are typically flown with off the shelf rocket motors with widely available propellant reloads. These rockets often exceed the speed of sound, altitudes above 30 km are not unheard of. These rockets are almost never controlled, they are stable due to passive aerodynamic features. 

While passively stable rockets are reasonably simple and reliable if well designed, they are susceptible to a variety of disturbances, particularly early in flight. Unexpected winds can cause the rocket to weathercock; flexibility in the launch tower/rail can cause railwhip, imparting a random launch angle to the rocket; the thrust from the rocket motor is also never perfectly symmetrical.

This project is a continuation of a project from 2018. This year the project is broken into hardware and software components. The project will be all opensource/openhardware and as such will need to use opensource tools to make it accessible to the community E.g Kicad instead of Altium for PCB designs. The hardware component is to design an avionics board that can provide telemetry from the rocket, log data from sensors and control the rocket by gimballing a motor. The software components are to design a mission control that runs on a laptop at the launch site as well as some software to statistically predict the rockets flight and software to help design the control parameters for the avionics.


### Client

Andre Geldenhuis is a rocket enthusiast who has experience building and launching rockets, and is a member of the New Zealand Rocketry Association.


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

Clients Requirments from the mission control software: 
*  Must be able to able to display weather information, rocket's current state and the results of simulations in a graphical user interface. 
*  That  the software is structured into modules. 
*  The Mission control software must be able to transmit a go/no-go signal to the rocket for launch. 

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

Figure 1

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

figure 2 Example of modularization of different aspects of the application
    
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

figure 3 Example of a layered style of development (Work in Progress) 
    
**Agile and Scrum:**

Allows us to manage the team in a more effective way, allowing us to break bigger parts of the application down into more manageable chucks, monitor and keep 
up to date with what other members of the team are working on and give support if needed, regular stand-ups and retrospectives allows all members of the team be 
caught up to date and allows members to take responsibility for the issues that have been assigned to them.  During our sprint planning sessions, a scrum leader is 
chosen, issues are created/ moved from backlog and assigned to team members  that’s are needed for the current milestone’s goal.
### 4.3 Process

The process architecture can be viewed as mutiple levels of abstraction, were each level describes a different concern. At the highest level the process architecture demonstrates the independently executing networks of processes distributed accross a range of hardware resources connected via a LAN or a WAN.

A process is a group of tasks that form an executable program. Processes represent a section of the process architecture which can be controlled. These processes can be replicated for improved load processing and availibility. This is particularly usefull for implementing a system which requires concurrency and parallelism.

The diagram used to demonstrate the process view for this system will use a UML activity diagram. This diagram shows the process of which the software will follow.

![UML Activity diagram](architecture_design/state-diagram.PNG)

*Figure 4: UML Activity diagram for misson control system*

Issues:

* Asynchronicity: This is the ability to periodically make a request to the weather API and render the data, while continuing the process. API calls take time so for the system to be able to continue to run threw the process, the call must be made asynchronusly. Then the rendering of the data must be done asychronously for other processes of the system to continue to operate.

* Request failure: This issue refers to the data flow through the backend of the system. One function of the backend is to request weather data from an external API. It is possible that this request could fail either at the systems end or the external API's end. It is unlikely that the external API would fail as it is well known and trusted, however, it is entirely possible to fail at the systems end. The failure could originate from a poor or no internet connection, or it could originate from a bad request which would be the cause of incorrect input from the user.  

* Wireless communication: This issue refers to the communication between the mission control system and the rocket which must be achieved wirelessly.  There are some obvious concerns with wireless communication such as unreliability and range. The mission control system must recieve data from the rocket through a wireless connection and display it to the user. It is critical the location of the rocket is broadcast and recieved in the event the rocket does not follow the intended path.

### 4.4 Physical 

The physical view provides an overview of how the software maps to the hardware of the system. The mission control package will pull weather data from an API to determine
whether it is safe to launch under the current weather conditions. This weather data will be shared with the simulation package in order to determine the landing area and
the direction of the rocket. The mission control software will parse this simulation data to determine if the simulated results match the expected results. 

The mission control package will communicate with the avionics package to obtain flight data of the rocket. This data will be used to map the flight path of the rocket, which 
in turn will be used for post-flight analysis. 

If it is deemed unsafe to launch the rocket, the control software will communicate to the avionics package so a kill-switch signal could be transmitted to the rocket.

At this stage, there is only one use case for downlink transmission. This is to address the concern of reliability. Ideally, the mission control package will possess the ability to transmit a kill-switch signal
directly to the base station, eliminating the need to go through the avionics package in the event of a transmission failure between the two packages. 


### 4.5 Scenarios
**Use Case 1:** Mary is currently at the launch site of her amateur rocket. Before she launches her rocket she wants to check where her rocket will potentially land. Mary can go to the 'Simulation' tab in the software, and see a spread of potential landing spots based on local parameters. 

|User|System|
|----|------|
|Mary wants to see potential landing <br> sites|The system will display a 'Create simulation' tab, which Mary will <br>click to see the flight parameters/ rocket info window|
|Mary enters the parameters of the flight|The system will take the parameters of the flight such as the launch rod angle <br> and will calculate a spread of landing sites based off <br> the local weather, and will display the spread in the 'simulations' tab|

**Use Case 2:** David wants to make sure that his amateur rocket is safe to launch before doing so. David can use the go / no go feature of the software to give clearance for the launch, before launching.

|User|System|
|----|------|
|David has set up the launch and is ready <br> to launch|The system will display a 'pre-launch' tab, which David will <br>click to prepare for launch|
|David will be prompted to enter the parameters <br> of the flight|The system will take the parameters of the flight such as the launch rod angle <br> and will calculate a spread of landing sites based off the local weather.<br> If the landing site is safe for launch the system will respond with 'go'|
|David will then know it is safe to launch the rocket| |

**Use Case 3:** Mark is just about to launch his amateur rocket and wants to be able to track its flight. Mark can use the software to see the flight path of the rocket using the 'Create Simulation' tab.

|User|System|
|----|------|
|Mark sets up his amateur rocket for launch <br>  and want to see the potential flight path of the roket|The system will have a 'Create Simulation' tab which Mark will click on to <br> calcualte the rockets flight path|
|Mark goes through the 'Create Simulation' tabs inputs <br> and enters the flights parameters | The system will calculate potential flight path and willdisplay the<br> flight path to the 'Simulation' tab|

**Use Case 4:** Emily has launched her amateur rocket and it seems to be flying well until suddenly the rocket turns horizontal and is flying uncontrollably. Emily would like to abort the flight so she can retrieve her rocket safely.

|User|System|
|----|-----|
|Emily's amateur rocket has started flying sideways|The system will be displaying an 'abort' button in the flight tab|
|Emily clicks the 'abort' button|The system will communicate to the rocket to cut the thruster and deploy the <br> parachute imidiately|
|Emily will collect the rocket from where it lands| |

**Use Case 5:** Amanda wants to check the current weather and the forecast at her launch site. So she goes the 'weather' tab of the mission control software to see the weather information on her launch site.

|User|System|
|----|------|
|Amanda wants to check the weather data of her launch <br> site|The system will display a 'weather' tab, which Amanda will click|
|Amanda will enter the location of her launch site|The system will display information about the current weather status, as well as show <br> a forecast for the weather status of her launch site|

## 5. Development Schedule

_For each subsection, make clear what (if anything) has changed from the requirements document._ If unchanged, these sections should be copied over from the requirements document, not simply cross-referenced.

Schedules must be justified and supported by evidences; they must be either direct client requirements or direct consequences of client requirements. If the requirements document did not contain justifications or supporting evidences, then both must be provided here.

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
