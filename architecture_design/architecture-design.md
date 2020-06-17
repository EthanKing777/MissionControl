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

One paragraph describing the scope of the system.

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

“Keeping New Zealand  skies safe and secure  ,” CAA and Avsec. [Online]. Available: https://www.aviation.govt.nz/. [Accessed: 10-May-2020].

## 3. Architecture

Describe your system's architecture according to ISO/IEC/IEEE 42010:2011(E), ISO/IEC/IEEE 12207, ISO/IEC/IEEE 15289 and ISO/IEC/IEEE 15288.

Note in particular the note to clause 5 of 42010:

_"The verb include when used in Clause 5 indicates that either the information is present in the architecture description or reference to that information is provided therein."_

This means that you should refer to information (e.g. risks, requirements, models) in this or other documents rather than repeat information.

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
(1 page, 42010 5.4) 

<!-- Identify the architectural viewpoints you will use to present your system's architecture. Write one sentence to outline each viewpoint. Show which viewpoint frames which architectural concern.
--> 

**Logical:** Is used to break down the system into key concepts and explaining the functionality of the system as a whole and of each key concept to end-users. 

**Development:** Describes the architecture of the software development cycle and addresses concerns of how software is being managed. 

**Process:** Describes dynamic and non-functional system requirments and explain how these concepts from the logical viewpoint fit within the project as a whole. 
             Examples of dymanic and non-functional requirments are: performance, the integrtors between parts of the system.
             
**Physical:** Describes how our Mission Control software is going to be mapped and interact with the hardware components from different teams and discussing scalability, performance, reliability, etc of the system.

**Senarios:** Describes interaction between users, processes, users and the system, software and hardware etc and compiled into use cases. This allows us to carry out a qualitative review of our architectures. 
 
### 4. Architectural Views

(5 sub-sections of 2 pages each sub-section, per 42010, 5.5, 5.6, with reference to Annex F of both 12207 and 15288) 

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

### 4.1 Logical
...

### 4.2 Development
...

### 4.3 Process

The process architecture can be viewed as mutiple levels of abstraction, were each level describes a different concern. At the highest level the process architecture demonstrates the independently executing networks of processes distributed accross a range of hardware resources connected via a LAN or a WAN.

A process is a group of tasks that form an executable program. Processes represent a section of the process architecture which can be controlled. These processes can be replicated for improved load processing and availibility. This is particularly usefull for implementing a system which requires concurrency and parallelism.

The diagram used to demonstrate the process view for this project will use a UML activity diagram. This diagram shows the process which the software will follow.

![UML Activity diagram](architecture_design/state-diagram.PNG)

*Figure x: UML Activity diagram for misson control system*

### 4.4 Physical 
...

### 4.5 Scenarios
...

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
| LORA module | Avinonics | $20 - $40 | External Vendor |

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

Document here project requirements for Health and Safety. All teams must state in this section:

All team members must take regular breaks to reduce the risks of Occupational Over Use, e.g. eye strain, repetitive strain injuries etc. Strict Cable management will be practiced at all work sites. Ensuring electronics are connected to mains or surge protected extenders, cables are run and routed out of the way of high foot traffic areas and ensuring that all Emergency exit are clear at all times.
Range and reliability testing on the LO-RA modules may be required, as such this will be undertaken at Victoria Univeristy Kelburn campus and around the Wellington CBD. If use of these test sites are required then all team members will follow health and safety, radio protcols and traffic laws etc from the govering body for said areas.  
As we are creating mission control software, the need to gather user feedback and test usability may be required. If so all test users will give their consent for their use and comments on the software to be observed and recorded in a testing log. To ensure that user testing meets the Ethical Approval of the univeristy, ECS department and to ensure the privacy of the test users, a redacted verison of the results will be inclued in the project documents only if needed. 

Discussions/briefing with Roger Cliffe (Victoria Univeristy of Wellington Safety Officer):

Date: 8 May 2020 - Briefing on the Health and Safety Act 2015
This was a mandatory lecture were the Health and Safety Act of 2015 and what it imolementations are for us.Safety Plans and Risk management strategies were also discused, e.g. a Risk Matrix.

#### 5.4.1 Safety Plans

Safety Plans may be required for some projects, depending on project requirements.


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


## 7. Contributions


| Team Memeber | Contribution |
| ------ | ------ |
| Alex Jackson  | 6.1 |
| Chris Burt  |  5.1 | 
| Ethan King | 5.3, 5.4  |
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
