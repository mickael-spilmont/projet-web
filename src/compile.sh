#!/bin/bash

# Java Servlet
javac -d ../WEB-INF/classes/ Accueil.java
javac -d ../WEB-INF/classes/ Connexion.java
javac -d ../WEB-INF/classes/ Deconnexion.java
javac -d ../WEB-INF/classes/ MesLivres.java
javac -d ../WEB-INF/classes/ AjouterLivre.java

# Java Base
javac -d ../WEB-INF/classes/ Base.java

# Java Beans
javac -d ../WEB-INF/classes/ Utilisateur.java
javac -d ../WEB-INF/classes/ Exemplaire.java
javac -d ../WEB-INF/classes/ Livre.java

cd ../WEB-INF/classes/ && ~/Code/Prog\ Web/tomcat8/bin/shutdown.sh &&
  ~/Code/Prog\ Web/tomcat8/bin/startup.sh
