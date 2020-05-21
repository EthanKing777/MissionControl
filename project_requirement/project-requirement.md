# ENGR 301: Project Requirements Document

The aim of this document is to specify the requirements of the system your group is to build. The focus of a requirements document is the problem you are attempting to solve:  not a first attempt at a solution to that problem. This document should communicate clearly to the supervisor, client and course coordinator what the system you build is going to do, and what constraints it must meet while doing so.

The document should also demonstrate your understanding of the main analysis principles and quality guidelines, and applicable standards, using tools and notations as necessary to communicate the requirements precisely, unambiguously and clearly in a written technical document. Page specifications below are *limits not targets* and refer to the pages in the PDF generated from the markdown. Because the size of your document is necessarily limited, you should ensure that you focus your efforts on those requirements that are most important to completing a successful system: if sections are at their page limit, indicate how many items would be expected in a complete specification. 

The ENGR 301 project proposal and requirements document should be based on the standard ISO/IEC/IEEE 29148:2011(E), primarily sections 8.4 and 9.5, plus section 9.4 for projects involving hardware and ISO 25010 SQuaRE for systemic requirements. While excerpts from the standard have been quoted within the template, to understand what is required it will be necessary to read earlier sections of the standards themselves. A supplementary treatment of requirements gathering in engineering projects may be found in [Requirements in Engineering Projects](https://victoria.rl.talis.com/items/F166DA94-DAD8-FBDB-0785-7A63C9BA3603.html?referrer=%2Flists%2F5886F297-2506-1F17-45D9-7F04CEE284EE.html%23item-F166DA94-DAD8-FBDB-0785-7A63C9BA3603) (Talis). The requirements document should contain the sections listed below, and conform to the formatting rules listed at the end of this brief. 

All team members are expected to contribute equally to the document and list their contributions in section 6 of the document. You should work on your document in your team's GitLab repository. While collective contributions are expected to be the exception rather than the rule, if more than one team member has contributed to a particular commit then all those team member IDs should be included in the first line of the git commit message. `git blame`, `git diff`, file histories, etc. will be tools used to assess individual contributions, so everyone is encouraged to contribute individually, commit early and commit often. Any team wishing to separate individually contributed sections into a single file before collation into the single proposal document for submission is welcome to do so.

---

<div style="page-break-after: always;"></div>

# ENGR 301 Project *NN* Project Proposal and Requirements Document
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

One page on the limitations on the product (9.5.6)
The system can't operate in too extreme weather (high wind or rain) due to the impractical launch of the rocket and electronics could get damaged.
The communications of the rocket will be limited to the hardware used by the avionics team.

## 2. References

References to other documents or standards. Follow the IEEE Citation  Reference scheme, available from the IEEE website (please use the search box). (1 page, longer if required)
OpenRocket?

## 3. Specific requirements  

20 pages outlining the requirements of the system. You should apportion these pages across the following subsections to focus on the most important parts of your product.

### 3.1 External interfaces

See 9.5.10. for most systems this will be around one page. 

### 3.2 Functions

This is typically the longest subsection in the document. List up to fifty use cases (in order of priority for development), and for at least top ten focal use cases, write a short goal statement and use case body (up to seven pages).  Identify the use cases that comprise a minimum viable product.

### 3.3 Usability Requirements

See 9.5.12. for most systems this will be around one page.

> **9.5.12 Usability requirements**<br>
> Define usability (quality in use) requirements. Usability requirements and objectives for the software system include measurable effectiveness, efficiency, and satisfaction criteria in specific contexts of use.

### 3.4 Performance requirements

See 9.5.13. for most systems this will be around one page. Hardware projects also see section 9.4.6.

> **9.5.13 Performance requirements** <br>
> Specify both the static and the dynamic numerical requirements placed on the software or on human interaction with the software as a whole. 
> 
> Static numerical requirements may include the following:
> 
> a) The number of terminals to be supported;  
> b) The number of simultaneous users to be supported;  
> c) Amount and type of information to be handled.
> 
> Static numerical requirements are sometimes identified under a separate section entitled Capacity.
> 
> Dynamic numerical requirements may include, for example, the numbers of transactions and tasks and the amount of data to be processed within certain time periods for both normal and peak workload conditions. The performance requirements should be stated in measurable terms.
> 
>  For example, "_95 % of the transactions shall be processed in less than 1 second._" rather than, "An operator shall not have to wait for the transaction to complete."
> 
> NOTE Numerical limits applied to one specific function are normally specified as part of the processing subparagraph description of that function.


### 3.5 Logical database requirements

See 9.5.14. for most systems, a focus on d) and e) is appropriate, such as an object-oriented domain analysis. You should provide an overview domain model (e.g.  a UML class diagram of approximately ten classes) and write a brief description of the responsibilities of each class in the model (3 pages).

You should use right tools, preferabley PlantUML, to draw your URL diagrams which can be easily embedded into a Mardown file (PlantUML is also supported by GitLab and Foswiki).

### 3.6 Design constraints

see 9.5.15 and 9.5.16. for most systems, this will be around one page.

> 9.5.15 Design constraints<br>
> Specify constraints on the system design imposed by external standards, regulatory requirements, or project limitations.
> 
> 9.5.16 Standards compliance<br>
> Specify the requirements derived from existing standards or regulations, including:
> 
> a) Report format;<br>
> b) Data naming;<br>
> c) Accounting procedures;<br>
> d) Audit tracing.
> 
> For example, this could specify the requirement for software to trace processing activity. Such traces are needed for some applications to meet minimum regulatory or financial standards. An audit trace requirement may, for example, state that all changes to a payroll database shall be recorded in a trace file with before and after values.

### 3.7 Nonfunctional system attributes

Present the systemic (aka nonfunctional) requirements of the product (see ISO/IEC 25010).
List up to twenty systemic requirements / attributes.
Write a short natural language description of the top nonfunctional requirements (approx. five pages).


### 3.8 Physical and Environmental Requirements 

For systems with hardware components, identify the physical characteristics of that hardware (9.4.10) and environment conditions in which it must operate (9.4.11).  Depending on the project, this section may be from one page up to 5 pages.

### 3.9 Supporting information

see 9.5.19. 

## 4. Verification

3 pages outlining how you will verify that the product meets the most important specific requirements. The format of this section should parallel section 3 of your document (see 9.5.18). Wherever possible (especially systemic requirements) you should indicate testable acceptance criteria.

## 5. Development schedule.

### 5.1 Schedule

Identify dates for key project deliverables: 

1. architectural prototype
1. minimum viable product
1. further releases

(1 page).

### 5.2 Budget

Present a budget for the project (table), and justify each budget item (one paragraph per item, one page overall). 

### 5.3 Risks 

Identify the ten most important project risks to achieving project goals: their type, likelihood, impact, and mitigation strategies (3 pages).

If the project will involve any work outside the ECS laboratories, i.e. off-campus activities, these should be included in the following section.

| Risk | Risk Type | Likelihood | Impact | Mitigation Strategies |
| ------ | ------ | ------ | ------ | ------ |
| COVID 19 | Health and Safety | 2 | 5 | All team members will follow government and univeristy advice/requirments. Working from home and personal devices where possible. If use of shared devices/ resources are needed then team members must ensure that correct levels of PPE and personal hygine and followed|
| Rocket entering restricted airspace  | legal, Health and Saefty | 1 | 5 | The launch site will be carefully chosen by the client. The Client will be able to use the mission control software to gather information about wind speed/ direction, possible landing zone, recommendations to launch parameters and other information that will impact the clients choice of launch location. |   
| Weather Conditions moving the rocket out of the predicted landed zone  | Enviromental | 5  | 5 | The mission control software will be able to pull weather data in advance of the lanuch. If any of the weather paramenters are outside of the recommended ranges provided by the CAA regulations 101 launch will be aborted.|   
| Occupational Over Use  | Health and Safety | 3 | 3 | Team members must take breaks to avoid any computer use related health issues. e.g. Eye strain, repetitive strain injury etc|   
| Engine ignites prematurely | Health and Safety | 2 | 4 | During stoarge and transport, the engine will be kept separte from heat/ electrical sources. The mission Control safety lock will be only disabled only when the go singal has been given. |   
| Fire casued by rocket launch/landing | Health and Safety | 2 | 5 | The launch chosen in advance will be an open field. The local fire risk will be checked before hand, and if the level for the chosen area is HIGH or above the launch will be canceled or moved to another area with a lower fire danger leve. |   



### 5.4 Health and Safety

Document here project requirements for Health and Safety. All teams must state in this section:

All team members must take regular breaks to reduce the risks of Occupational Over Use, e.g. eye strain, repetitive strain injuries etc. Strict Cable management will be practiced at all work sites. Ensuring electronics are connected to mains or surge protected extenders, cables are run and routed out of the way of high foot traffic areas and ensuring that all Emergency exit are clear at all times.
Range and reliability testing on the LO-RA modules may be required, as such this will be undertaken at Victoria Univeristy Kelburn campus and around the Wellington CBD. If use of these test sites are required then all team members will follow health and safety, radio protcols and traffic laws etc from the govering body for said areas.  
As we are creating mission control software, the need to gather user feedback and test usability may be required. If so all test users will give their consent for their use and comments on the software to be observed and recorded in a testing log. To ensure that user testing meets the Ethical Approval of the univeristy, ECS department and to ensure the privacy of the test users, a redacted verison of the results will be inclued in the project documents only if needed. 

Discussions/briefing with Roger Cliffe (Victoria Univeristy of Wellington Safety Officer):

Date: 8 May 2020 - Briefing on the Health and Safety Act 2015
This was a mandatory lecture were the Health and Safety Act of 2015 and what it imolementations are for us.Safety Plans and Risk management strategies were also discused, e.g. a Risk Matrix.

#### 5.4.1 Safety Plans

Safety Plans may be required for some projects, depending on project requirements. Safety Plan templates are available on the course Health & Safety page. Two questions all teams must answer are:

**Do project requirements involve anything that can cause serious harm or death?**  
Examples: building/modifying devices using voltages > 60 V, chemicals, large moving machinery, flying devices, bodies of water.

If so, you will have to write a separate Safety Plan as part of project requirements, and the Safety Plan must be referenced in this section. For health and safety risks involving serious harm or death, you must first contact the School Safety Officer and Course Coordinator first to discuss the Safety Plan and project requirements.

**Do project requirements involve anything that can cause harm or injury?**  
Examples: building/modifying things with voltages <= 60V, small moving machinery, wearable devices.

If so, you will have to write a separate Safety Plan as part of project requirements, and the Safety Plan must be referenced in this section. For health and safety risks involving harm or injury, you should write a draft of the Safety Plan before contacting the School Safety Officer and Course Coordinator to discuss the Safety Plan and project requirements.

If a safety plan is required, list in this section the date the School Safety officer accepted your Health and Safety plan (if accepted by submission date).

_If the project is purely software and requires no contact risks involving physical harm, then state "Project requirements do not involve risk of death, serious harm, harm or injury." in this section._


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

## 7. Contributions

A one page statement of contributions, including a list of each member of the group and what they contributed to this document.

| Team Memeber | Contribution |
| ------ | ------ |
| Alex Jackson  | 6.1 |
| Chris Burt  | cell | 
| Ethan King | Table of Content, 5.3, 5.4  |
| Henry Pettit | cell | 
| Nirari Awas | 1.3.2, 1.3.3 |
| Ruvindu Wijeratne | cell | 
| Thomas Rainford | 1.0, 1.1, 1.2 |




## Formatting Rules 

 * Write your document using [Markdown](https://gitlab.ecs.vuw.ac.nz/help/user/markdown#gitlab-flavored-markdown-gfm) and ensure you commit your work to your team's GitLab repository.
 * Major sections should be separated by a horizontal rule.


## Assessment  

The goal of a requirements document is the problem you are attempting to solve:  not a first attempt at a solution to that problem. The most important factor in the assessmernt of the document is how will it meet that goal. The document will be assessed for both presentation and content. 

The presentation will be based on how easy it is to read, correct spelling, grammar, punctuation, clear diagrams, and so on.

The content will be assessed according to its clarity, consistency, relevance, critical engagement and a demonstrated understanding of the material in the course. We look for evidence these traits are represented and assess the level of performance against these traits. While being comprehensive and easy to understand, this document must be reasonably concise too. You will be affected negatively by writing a report with too many pages (far more than what has been suggested for each section above).

We aim to evaluate ENGR301 documents and projects as if they were real projects rather than academic exercises &mdash; especially as they are real projects with real clients. The best way to get a good mark in a document is to do the right thing for your project, your client, and your team. We encourage you to raise questions with your tutor or course staff, as soon as possible, so you can incorporate their feedback into your work.

---
