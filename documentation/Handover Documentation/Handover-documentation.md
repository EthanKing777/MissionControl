# ENGR301/302 Handover Documentation

**Project: Mission Control**
<br>
**Client: Andre Geldenhuis**
<br>
**Date: ** 
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
        * 1.2.4 Furture Work
        * 1.2.5 Bugs
2. User Manual
3. Testing Documentation
4. Technical Manual

## Project Overview 

The initial brief of the mission control software was to develop software capable of displaying information from the Avionics package, from the monte carlo simulation package and also implementing a go/no-go feature for parameter checking and arming the rocket. This was expanded upon to include weather information fetch, display and checking. 

Over the course of the project, a mission control software package was designed and developed that was capable of fetching and displaying the relevant weather information to determine if a lunch should proceed, allowing a user to input and edit simulation parameters, display relevent simulation data/ models, display New Zealand flight zones and displaying information recieved from the Avionics package. 

## User Manual 

### Software Prerequisite
To run and modify the software package:
- Java 14+ (JDK)
- Apache Maven
- Scene Builder (optional, for editing of *.fxml files)

### Supported Operating Systems
The software was developed for three primary platforms. In theory, any system capable of running Java 14 should be able to run this software, however, there are no guarantees that it will run as intended.
- Windows 10
- Linux (KDE)
- macOS

### Desktop Environment Setup 
It is recommended that an IDE is installed for development, future work and bug fixes. The software was developed in a
range of IDEs and operating system environments. Initial contributors used IntellJ IDEA or Eclipse as IDEs, and used Windows,
Linux and MacOS as operating systems. The executable JAR file provided in the handover repository can be executed via
command line/ termninal via [INSERT COMMANDS HERE]. Or via an IDE's run function. We used JavaFX as our graphical library,
as such Scene Builder can be used to edit or preview Scenes without running the code/ editing in an IDE. 

### IDE Usage
You can either clone the raw code files via git, download and import the files, or import the project from
the executable JAR file into your IDE of choice. 

### code Source
LINK TO HANDOVER REPO

### Maven Commands 
Note: Maven commands are un-needed when importing/ running the project from the JAR, or when cloning/ running from the 
remote repository(as the package has already been deployed here).

1) ```mvn validate``` - checks if all th  information needed for the build is available
2) ```mvn compile``` - compiles the code
3) ```mvn test``` - runs the unit tests (Optional)
4) ```mvn package``` - packages the compiled coding into an executable package (JAR)
5) ```mvn install``` - installs the package to the local repository
6) ```mvn delopy``` - deploys the package to the remote repository

### Application usage
#### Application start
1) Run Application - the application will build and execute, displaying the configuration tab. This Tab 
allows the user to enter information about the rocket, the launch, and application settings.
2) Enter perferences/ information into Config Tab 

#### Displaying Weather Information
1) Enter launch information into the config tab and save
2) Weather Tab will open in a new window, rather than the initial weather tab (Known Bug)
3) click display Weather Information button

#### Displaying Simulation Data
1) Navigate to the simulation tab
2) Click population Graph, select the Simulation data CSV

note: All simulation data, milestones, graphs are saved to the output directory for later reference.

#### Receiving Flight Data

#### Using the create/edit simulation tab

## Testing Documentation

## Technical Manual




