UnB-DALi
=======
Given that the usual activities of our group is heavily dependant on Model Transformations, be it from UML or any other model description language, it has become of extreme need the existence of a library to reduce the overhead of developing tools that relies on such operations.

This project is thus an attempt to provide the infrastructure and functionality needed by our future projects on performing model transformation routines. In software engineering terms, this kind of project is often called a Library, since its target is not the end-user, but the developer himself. Hence, the name: *UnB Dependability Analysis Library* (*UnB-DALi*, for short).

How to Contribute 1 - Coding, Building and Distributing
=======
For building and dependency management we use Gradle (https://gradle.org/), which merges the better worlds from `ant` and `maven`, on a simple functional, typed, scripting language based on Groovy. 

So, to starters, it is recommended the installation of gradle on both the machine and eclipse (or IntelliJ), although the machine one is not necessary since the project already comes with a command line tool `gradlew` (or `gradlew.bat`, for windows users) that carries all the gradle engine and its functionality.

**To import** the project for development under Eclipse, here are some basic steps:
  1. Clone the project;
  2. Run `./gradlew eclipse clean build` from the command line (always on the project folder). This is necessary since the `.classpath` and `.project` files are *NOT* on version control;
  3. Open the eclipse and install the gradle plugin (http://marketplace.eclipse.org/content/gradle-integration-eclipse-44);
  4. Import the project to workspace using the `Gradle Project` option and then: `browse to the folder -> click the Build Model button -> Finish!`
  
**To build** the project, open the command line tool, head to the project folder and type:
```
  ./gradlew clean build
```

**To distribute** the library, we need to put together all the dependencies on a single .jar. To do that, simply type from the command line:
```
  ./gradlew clean fatJar
```
where the .jar will be put under `/build/libs/`. With the "fatJar" in hands, one can import it to the tool he/she is developing, and be able to consume our APIs. In future versions we plan to put it under maven management so people can import it more easily, through dependency management software (such as maven, ivy, and of course, gradle).

How to Contribute 2 - Version Control
=======
We have adopted the Git Flow versioning pattern (https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow/), which is basically a branch naming standardization. This makes for a nice versioning tree and is a *must* when development happens with different versions and contributors at the same time. 

We then recommend the use of Source Tree (https://www.sourcetreeapp.com/) as a versioning management tool. Its interface is quite straight forward and has a great conflict management. After you clone the project using the Source Tree, please **make sure to click on the top rigth-corner button Git Flow** and then **ok**, which will set your project to use the versioning convention we have adopted here.

And **be aware**, commits to `master` should **only** be done when a **STABLE** version of the project is reached. 

Basic Organization
=======

  - `src/main/java`: holds the project modules and APIs;
  - `src/main/resources`: holds the usual resources one would use at runtime; it can be a uml *metamodel*, or project configuration flags, or anything else (it will grow with time);
  - `src/test/java`: here should be put classes to test the APIs created at `src/main/java` (also, Gradle already looks at this folder for unit tests with JUnit);
  - `src/test/resources`: resources that the tests need to be able to run the tests.

Obs: note that `src/test/` files will **NOT** be added to the final .jar.

Integration With UML Tools
============================

UnB-DALi has been extended to provide support to multiple UML modelling tools like MagicDraw, Papyrus, Modelio, etc. UML diagrams as XMI files are transformed into Discrete-Time Markov Chains (DTMCs) in PRISM language via the UnB-Dependability Analysis Library (UnB-DALi). Check the XMItoPRISM project <a href="https://github.com/lesunb/XMIToPRISM">here</a> via UnB-DALi.

The project's goal is to extract the information of an UML diagram, in the form of an XMI file, and use it as input to UnB-DALi, that conducts the graph transformation of an UML diagram to a DTMC in the language of the PRISM model checker tool. Tests were performed to the following UML tools: Argouml, Magic Draw, Astah, BOUML, Modelio and Papyrus.

This is it for now.
--
Dependability@cic.
