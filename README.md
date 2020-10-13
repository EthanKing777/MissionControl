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

- *src*
  - *main*
    - *java* - This folder contains all the Java code that the application runs (excluding test cases). All files in this directory are *\*.java* files.
    - *resources* - This folder contains all non-Java resources required by the software package.

  - *test*
    - *java* - This folder contains all the test cases for the code located in the *src/main/java* directory. Files in this folder must have the suffix *Test*.
    - *resources* - This folder contains all the non-Java resources that are required by the tests.