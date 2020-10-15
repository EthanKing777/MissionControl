# ENGR301/302 Handover Documentation

**Project: Mission Control**
<br>
**Client: Andre Geldenhuis**
<br>
**Date: 16th Oct 2020** 
<br>
**Team: Group 11**
<br>

## Table of Contents

1.  Project Overview     
    * 1.1 Project Objectives
    * 1.2 Service Description
        * 1.2.1 Original Service Scope 
        * 1.2.2 Delivered Service Scope 
        * 1.2.3 Limitations
        * 1.2.4 Future Work
        * 1.2.5 Bugs
2. User Manual
    * 2.1 code Source
    * 2.2 Software Prerequisite
    * 2.3 Supported Operating Systems
    * 2.4 Desktop Environment Setup 
    * 2.5 IDE Usage
    * 2.6 Maven Commands 
    * 2.7 Application usage
        * 2.7.1 Application start
        * 2.7.2 Displaying Weather Information
        * 2.7.3 Displaying Simulation Data
        * 2.7.4 Receiving Flight Data
        * 2.7.5 Using the create/edit simulation tab
    * 2.8 Editing Application
        * 2.8.1 Editing/ Adding/ Removing Scenes
        * 2.8.2 Editing Graphs/ Displayed Data
3. Testing Documentation
4. Technical Manual

## 1. Project Overview 

The initial brief of the mission control software was to develop software capable of displaying information from the 
Avionics package, from the monte carlo simulation package and also implementing a go/no-go feature for parameter 
checking and arming the rocket. This was expanded upon to include weather information fetch, display and checking. 
Over the course of the project, a mission control software package was designed and developed that was capable of 
fetching and displaying the relevant weather information to determine if a lunch should proceed, allowing a user 
to input and edit simulation parameters, display relevant simulation data/ models, display New Zealand flight zones 
and displaying information received from the Avionics package. 

### 1.1 Project Objectives
- Runnable off a laptop
- Display Rocket Data
  - Current Rocket State
  - Current Location 
  - Current Altitude
- Go/ No-Go Function
- Integration with monte carlo simulation package
- Fetch and display local weather
- Determine Possible Landing sites
- Suggest possible launch angle (Suggestion)

### 1.2 Service Description

#### 1.2.1 Original Service Scope 

#### 1.2.2 Delivered Service Scope
 ##### Configurations Tab
 Configurations Tab allows the user to alter some settings of the Mission Control software. Here the user can set their flight launch date, launch time and launch location in latitude and longitude so that user can:
 1. See the weather conditions of the launch site at the launch time
 2. See the launch area on a satellite image 

 The Configurations Tab also allows the user to toggle the option to enforce a simulation before launch as a safety feature. Should the user toggle this option on they won't be able to arm and launch their rocket before they have run a simulation on the launch parameters.
 
 Finally, in this tab, the user can toggle an automatic switch to the Flight Tab upon launch. When this is toggled on, the program wil be forced to switch to the Flight Tab when the rocket is launch removing the hassle of the user having to manually switch.

 ##### Flight Tab
 The Flight Tab allows the user to track the rockets flight in realativley real time. The data displayed is ...

 ##### Create / Edit Simulation Tab
 The user can go to this tab when they want to create a new flight simulation or edit the current flight simulation. The tab has two tables, a Weather Data table and a Rocket properties table. To which the user can enter details into. For the Rocket Information table, the user can enter the properties of their rocket either manually or they can load in a file with a .csv extension, which will take a simulation file and load the rocket properties from that file into the table. Once the user is happy with the values they can click the "Save all properties as a CSV" which will generate a csv file that can be used with a specific simulation application that extends open rocket.

 ##### Simulation Tab
This tab displays a summary of a simulation data that can be provided to the program via a CSV file. The CSV file will need to follow a specific format for it to be compatible with the mission control software. This format is:

Time (s),Altitude (m),Vertical velocity (m/s),Vertical acceleration (m/s≤),Total velocity (m/s),Total acceleration (m/s≤),Position East of launch (m),Position North of launch (m),Lateral distance (m),Lateral direction (∞),Lateral velocity (m/s),Lateral acceleration (m/s≤),Latitude (∞),Longitude (∞),Gravitational acceleration (m/s≤),Angle of attack (∞),Roll rate (∞/s),Pitch rate (∞/s),Yaw rate (∞/s),Mass (g),Propellant mass (g),Longitudinal moment of inertia (kg∑m≤),Rotational moment of inertia (kg∑m≤),CP location (cm),CG location (cm),Stability margin calibers (?),Mach number (?),Reynolds number (?),Thrust (N),Drag force (N),Drag coefficient (?),Axial drag coefficient (?),Friction drag coefficient (?),Pressure drag coefficient (?),Base drag coefficient (?),Normal force coefficient (?),Pitch moment coefficient (?),Yaw moment coefficient (?),Side force coefficient (?),Roll moment coefficient (?),Roll forcing coefficient (?),Roll damping coefficient (?),Pitch damping coefficient (?),Reference length (cm),Reference area (cm≤),Vertical orientation (zenith) (∞),Lateral orientation (azimuth) (∞),Wind velocity (m/s),Air temperature (∞C),Air pressure (mbar),Speed of sound (m/s),Simulation time step (s),Computation time (s) 

Once this file is provided, the tab will display a graph for the rocket arc (path) of the simulated flight, a graph for the rocket's velocity throughout the simulated flight and the rocket's acceleration throughout the simulated flight. The tab will also display and satellite image of the launch site with possible landing sites (based on simulations with a standard deviation applied to variables) plotted on the image.

 ##### Weather Information Tab / Screen
 The Weather information Tab/Screen can be used to see the local weather conditions of the provided launch site and launch time. The tab will show the user the current wind direction, the wind direction for the 24 hours, the wind speed for the next 24 hours, the cloud coverage and the wind speed at different altitudes. This screen will be brought up automatically in a separate window when the user enters the flight time, location and date into the configuration tab. It is worth noting that the weather API that is used for this screen is only updated every hour, meaning the data is only accurate to the hour.
 
 ##### Airspace NZ Tab
 If the user is unsure of flight restrictions in the area they wish to launch, they can use this page to get an **idea*** of what air restrictions are in place around them. The page displays a map highlighting restricted airspace in New Zealand and has a whole bunch of other information about New Zealand's restricted Air Spaces.

 ***Note** that the Airspace page is specific to New Zealand airspace and the rules that are displayed on this page are specific to drone flying. While this will give the user an idea of amateur rocket flying in their area, it should not be used as the only check for their flight complying wth New Zeland law. For accurate information of flying rocket in New Zealand, the user should go to https://www.aviation.govt.nz/. For accurate information in other countries, the user should read the Laws and Regulations of that country.
 
 ##### Rocket Status
 The status of the rocket is displayed on each tab of the application so the user at all times can see what state the rocket is currently in (for safety reasons). The rocket that the application was built around could be in 4 different states. These are disabled, armed, unarmed launched. The application can be extended however to allowing for different rocket states.
 
#### 1.2.3 Limitations

#### 1.2.4 Future Work

#### 1.2.5 Known Bugs
- Weather data tab opens in a new window after launch information set via configuration tab. 
- URL encoding bug causes negative Longitude values in the GEOjson array to be encoded as 0.
- Airspace Map does not render on Linux(KDE).

## 2. User Manual 
### 2.1 code Source
LINK TO HANDOVER REPO

### 2.2 Software Prerequisite
To run and modify the software package:
- Java 14+ (JDK)
- Apache Maven
- Scene Builder (optional, for editing of *.fxml files)

### 2.3 Supported Operating Systems
The software was developed for three primary platforms. In theory, any system capable of running Java 14 should be able to run this software, however, there are no guarantees that it will run as intended.
- Windows 10
- Linux (KDE)
- macOS

### 2.4 Desktop Environment Setup 
It is recommended that an IDE is installed for development, future work and bug fixes. The software was developed in a
range of IDEs and operating system environments. Initial contributors used IntellJ IDEA or Eclipse as IDEs, and used Windows,
Linux and MacOS as operating systems. The executable JAR file provided in the handover repository can be executed via
command line/ termnFurtureinal via [INSERT COMMANDS HERE]. Or via an IDE's run function. We used JavaFX as our graphical library,
as such Scene Builder can be used to edit or preview Scenes without running the code/ editing in an IDE. 

### 2.5 IDE Usage
You can either clone the raw code files via git, download and import the files, or import the project from
the executable JAR file into your IDE of choice. 

### 2.6 Maven Commands 
Note: Maven commands are not needed when importing/ running the project from the JAR, or when cloning/ running from the 
remote repository(as the package has already been deployed here).

1) ```mvn validate``` - checks if all th  information needed for the build is available
2) ```mvn compile``` - compiles the code
3) ```mvn test``` - runs the unit tests (Optional)
4) ```mvn package``` - packages the compiled coding into an executable package (JAR)
5) ```mvn install``` - installs the package to the local repository
6) ```mvn delopy``` - deploys the package to the remote repository

### 2.7 Application usage
#### 2.7.1 Application start
1) Run Application - the application will build and execute, displaying the configuration tab. This Tab 
allows the user to enter information about the rocket, the launch, and application settings.
2) Enter perferences/ information into Config Tab.

#### 2.7.2 Displaying Weather Information
1) Enter launch information into the config tab and save.
2) Weather Tab will open in a new window, rather than the initial weather tab (Known Bug).
3) click display Weather Information button.

#### 2.7.3 Displaying Simulation Data
1) Navigate to the simulation tab.
2) Click population Graph, select the Simulation data CSV.

Note: All simulation data, milestones, graphs are saved to the output directory for later reference.

#### 2.7.4 Receiving Flight Data
1) flight data in recieved i as a csv file and then dislayed on flight tab

#### 2.7.5 Using the create/edit simulation tab

### 2.8 Editing Application
#### 2.8.1 Editing/ Adding/ Removing Scenes
Editing what is displayed by the application can be achieved by editing the FXML files either in: 
- Scene Builder - stand alone (https://www.oracle.com/java/technologies/javase/javafxscenebuilder-info.html)
- Scene Builder - IDE integrated/plugin
- editing the raw FXML files via an IDE

#### 2.8.2 Editing Graphs/ Displayed Data
Editing the displayed graphs/elements graphically, logically or behaviourally can be achieved by editing the controllers
for each of the FXML tabs. The location of these controllers are below: 
- src/main/java/org/group11/controller

## 3. Testing Documentation

## 4. Technical Manual




