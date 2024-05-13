# IoTBay Release 1
### 41025 Introduction To Software Development

## Table of contents:(#41025-introduction-to-software-development)
  - [Introduction:](#introduction)
  - [Software Requirements](#software-requirements)
  - [Deployment Instructions](#deployment-instructions)

## Introduction:
This repository contains release one for our groups submission of the IotBay website for Assignment 2 of 41025 Introduction To Software Development.


## Software Requirements
- [JDK 1.8](https://www.oracle.com/au/java/technologies/javase/javase8-archive-downloads.html) 
- [Apache Maven 3.9.6](https://maven.apache.org/download.cgi)
- [MySQL 8.0.37](https://dev.mysql.com/downloads/windows/installer/8.0.html)
- [DBeaver](https://dbeaver.io/download/) (Or equivelent)
- [Visual Studio Code](https://code.visualstudio.com/)
- [Extention pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
- [Maven for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-maven)

## Deployment Instructions
- Clone the repository or download the ZIP from GitHub and extract it.
- Setup your MySQL admin credentials.
- Open DBeaver and create a new MySQL connection.
  - The projects default DB name is `IOTBAY`
  - The projects default DB Username is `root`
  - The projects default DB Password is `password`
  - Either set your DBeaver connection up with the above credentials, or enter your own credentials in the DB.java file located in `java/uts/isd/model/dao`

- Click on the insert SQL button in DBeaver's toolbar. Now copy, paste and run *each statement **separately*** in the script editor.

- Open a terminal in VSCode (Ctrl + Shift + P - then type create new terminal)
- For the first time, run `mvn package`
- Then run `mvn jetty:run`
- To open the website, enter `localhost:8080` into your browser.