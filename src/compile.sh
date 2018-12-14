#!/bin/bash

javac -d ../WEB-INF/classes/ Accueil.java
javac -d ../WEB-INF/classes/ Connexion.java

cd ../WEB-INF/classes/ && ~/Code/Prog\ Web/tomcat8/bin/shutdown.sh &&
  ~/Code/Prog\ Web/tomcat8/bin/startup.sh
