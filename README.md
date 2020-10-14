# Technical requirements

Although we aimed to make our project compatible with a wide variety of systems, there are still technical requirements to be able to run the software. Outlined below are some of the technical requirements for running this software package.


## Software prerequisites

To run and modify the software package:

- Java 14+ (JDK)
- Apache Maven
- Scene Builder (*optional*, for editing of *.fxml files)

## Operating systems

The software was developed for three primary platforms. In theory, any system capable of running Java 14 should be able to run this software, however, there are no guarantees that it will run as intended.

- Windows 10
- Linux (KDE)
- macOS

<br>


# Modifying the software

## Assumptions

To run and modify this software, it is assumed that you have an understanding of the Java programming language, and are familiar with object-oriented programming concepts.

## Project structure

This project follows the standard Maven project structure. Each folder is described below:

| **Directory**        | **File types** |**Description**|
|----------------------|----------------|---------------|
| *src/main/java*      |    \*.java     |This folder contains all the Java code that the application runs (excluding test cases).|
| *src/main/resources* | Non-Java files |This folder contains all non-Java resources required by the software package.|
| *src/test/java*      |    \*.java     |This folder contains all the test cases for the code located in the *src/main/java* directory. Files in this folder must have the suffix *Test*.|
| *src/test/resources* | Non-Java files |This folder contains all non-Java resources required by the test.|


## UI

UI components in this library are part of the JavaFX library. The entire UI was created using an external tool called Scene Builder, which is a drag-and-drop UI builder for JavaFX. Scene Builder generates XML files (with a custom *\*.fxml* extension), which can then be loaded by the JavaFX library.

> *Note: all generated \*.fxml files are located under the src/main/resources directory.*

<br />

### Modifying the UI with Scene Builder

Each *\*.fxml* file corresponds to a single tab in the application:
- prelaunchscreen.fxml - The pre-launch tab
- config.fxml - The configuration tab
- FlightTab.fxml - The flight tab
- simulation.fxml - The create/edit simulation tab
- SimulationTab.fxml - The simulation tab
- WeatherTab.fxml - The weather information tab
- AirspaceMapTab.fxml - The Airspace NZ tab

<br />

To modify one of the tabs above:

1. Open Scene Builder
2. Click open project, and open the respective *\*.fxml* file you would like to edit.
3. Make any desired modifications to the UI using Scene Builder
4. Click save, located under the *File* menu in the top-left (File > Save)

<br />

### Modifying the UI behaviour

Although the UI is designed with Scene Builder, the functionality for the UI still needs to be programmed with Java. JavaFX uses a pattern known as model-view-presenter (MVP), where each *\*.fxml* file is associated with a Java class referred to as a controller. Controllers are responsible for handling user interaction. In this software package, each tab is associated with a separate controller, located under the *src/main/java* directory.

|       FXML file      |           Controller file           |
|----------------------|-------------------------------------|
| prelaunchscreen.fxml | PreLaunchScreenController.java      |
| config.fxml          | configController.java               |
| FlightTab.fxml       | FlightTabController.java            |
| simulation.fxml      | CreateEditSimulationController.java |
| SimulationTab.fxml   | SimulationTabController.java        |
| WeatherTab.fxml      | WeatherTabController.java           |
| AirspaceMapTab.fxml  | AirspaceController.java             |