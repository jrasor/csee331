## Welcome!

This GitHub repository contains the source code that is used to build 
training code for Don Bosco Tech course CSEE331 "Robotics Engineering". 
It is based on the FTC Software Development Kit (SDK), available at the
[FTC SDK repository](https://github.com/ftctechnh/ftc_app/releases).
        
Open it in Android Studio. That's how it was developed.

### Get This Project
To get our code, download or clone from 
[our repository](https://github.com/jrasor/csee331).

If you are new to the FIRST Tech Challenge software and control system, 
look at the [FTC SDK Wiki](https://github.com/ftctechnh/ftc_app/wiki).
Check back there from time to time, as it contains the most current
information about the FIRST Tech Challenge software and control system.
### About This Project
The CSEE331 course is designed to bring high school students to the
skill level needed to enter FTC competition as rookie participants. 
#### The Robot
They begin by running a simple robot called a "Trainerbot". Then they disassemble
its major subsystems and put it back together again. Then they disassemble
the whole thing down to nuts and screws, and assemble it, all the while 
writing documentation on how to do that.

The robot has 3 main subsystems:
1. The electronics pan, containing the battery and control modules.
2. The drive train. Yes, the electonics pan hangs under the drive train.
3. The actuator and sensor suite. Actuators and sensors are mounted atop the
transverse members of the drive train, and can easily be moved around on
them.

All these subsystems are modular. A team can swap them in and out in their
pit, making multiple configurations possible. For example, they can bring 
a number of drive trains to a Meet and choose one to fit their Allies' 
strengths. They can bring a spare electronics pan and swap it in in less than
a minute. The possibilities for actuator and sensor suites are virtually
endless.
#### Another Robot
Another training robot is supported by this project, the "Lookeebot". It
is a drive train and a controller phone, nothing else. It's a testing 
platform for robot vision. It just runs around with the phone's camera and 
looks at stuff.
#### The Software
The software is this project. It is built up from sample opmodes taken from
the FtcRobotController samples that come with the SDK, and also with this
project. It is _not_ particularly well suited to this type of modular robot.
For starters, this software is not very modular.
* Some opmode classes contain methods and properties that should be members
 of a robot class. There is some duplication of code among them.
* Some of the robot class members are at different levels of complexity,
and the complex ones are only partially built on the simpler ones.

What are the students supposed to do with it, then?
1. First, run it on a Trainerbot and score with it at an early season Meet.
2. Then remedy its deficiencies with well chosen classes that use abstraction,
inheritance, overloading, etc. This means learning object-oriented programming
in a fun and competitive setting.
3. They should be able to write new classes and use them on new hardware 
modules swapped in for service in late-season Meets.

Students of this course are then well-qualified to contribute to an intermediate
or advanced FTC Team.

## Bonjour!

Ce référentiel GitHub contient le code source utilisé pour construire le code de formation du cours CSEE331 "Ingénierie robotique" de Don Bosco Tech. Il est basé sur le kit de développement logiciel FTC (SDK), disponible dans le [référentiel FTC SDK](https://github.com/ftctechnh/ftc_app/releases).

Ouvrez-le dans Android Studio. C'est comme ça que ça a été développé.

### Obtenir Ce Projet

Pour obtenir notre code, téléchargez ou clonez à partir de notre [référentiel](https://github.com/jrasor/csee331).

Si vous débutez avec le logiciel et le système de contrôle FIRST Tech Challenge, [consultez le Wiki FTC SDK](https://github.com/ftctechnh/ftc_app/wiki). Consultez de temps en temps car il contient les informations les plus récentes sur le logiciel et le système de contrôle FIRST Tech Challenge.

### A propos de ce projet

Le cours CSEE331 est conçu pour amener les élèves du secondaire au niveau de compétence nécessaire pour participer au concours FTC en tant que participants débutants.

### Robot

Ils commencent par exécuter un simple robot appelé "Trainerbot". Ensuite, ils désassemblent ses principaux sous-systèmes et le remettent en place. Ensuite, ils démontent le tout en vissant des écrous et des vis et l’assemblent tout en écrivant de la documentation sur la façon de le faire.

Le robot comporte 3 sous-systèmes principaux:

1. Le plateau électronique, contenant la batterie et les modules de contrôle.
2. Le train roulant. Oui, la casserole électronique se bloque sous la transmission.
3. La suite actionneur et capteur. Les actionneurs et les capteurs sont montés au sommet des membres transversaux de la transmission et peuvent facilement être déplacés.

Tous ces sous-systèmes sont modulaires. Une équipe peut les échanger dans et dans leur puits, rendant possibles de multiples configurations. Par exemple, ils peuvent amener un certain nombre de trains d'entraînement à une réunion et en choisir un qui correspond aux forces de leurs alliés. Ils peuvent apporter un pan électronique de rechange et l’échanger en moins d’une minute. Les possibilités pour les suites d'actionneurs et de capteurs sont pratiquement illimitées.

### Un autre robot

Un autre robot d'entraînement est soutenu par ce projet, le "Lookeebot". C'est un groupe motopropulseur et un téléphone de contrôle, rien d'autre. C'est une plateforme de test pour la vision robotique. Il tourne simplement avec la caméra du téléphone et regarde des choses.

### Les logiciels

Le logiciel est ce projet. Il est construit à partir d’exemples d’opmodes extraits des exemples FtcRobotController fournis avec le SDK, ainsi que de ce projet. Il n'est pas particulièrement bien adapté à ce type de robot modulaire. Pour commencer, ce logiciel n'est pas très modulaire.

* Certaines classes opmode contiennent des méthodes et des propriétés qui devraient être membres d'une classe robot. Il y a une duplication de code parmi eux.
* Certains membres de la classe robot sont à différents niveaux de complexité et les plus complexes ne sont que partiellement construits sur les plus simples.

Qu'est-ce que les étudiants sont supposés en faire, alors?

1. Tout d'abord, lancez-le sur un Trainerbot et marquez-le lors d'une rencontre en début de saison.
2. Ensuite, remédiez à ses lacunes avec des classes bien choisies utilisant l'abstraction, l'héritage, la surcharge, etc. Cela signifie apprendre la programmation orientée objet dans un cadre amusant et compétitif.
3. Ils devraient être en mesure d'écrire de nouvelles classes et de les utiliser sur de nouveaux modules matériels mis en service pour les réunions de fin de saison.

Les étudiants de ce cours sont alors bien qualifiés pour contribuer à une équipe FTC intermédiaire ou avancée.

## Herzlich willkommen!

Dieses GitHub-Repository enthält den Quellcode, der zum Erstellen des Trainingscodes für den Don Bosco Tech-Kurs CSEE331 "Robotics Engineering" verwendet wird. Es basiert auf dem FTC Software Development Kit (SDK), das im [FTC SDK-Repository verfügbar ist](https://github.com/ftctechnh/ftc_app/releases).

Öffnen Sie es in Android Studio. So wurde es entwickelt.

### Holen Sie sich dieses Projekt

Um unseren Code zu erhalten, können Sie ihn aus [unserem Repository](https://github.com/ftctechnh/ftc_app/wiki)herunterladen oder klonen.

Wenn Sie das FIRST Tech Challenge-Software- und Steuerungssystem noch nicht kennen, schauen Sie im [FTC SDK-Wiki nach](https://github.com/ftctechnh/ftc_app/wiki). Schauen Sie sich von Zeit zu Zeit dort vorbei, da es die aktuellsten Informationen über die FIRST Tech Challenge-Software und das Steuerungssystem enthält.

### Über dieses Projekt

Der CSEE331-Kurs soll Highschool-Studenten auf das Niveau bringen, das sie für den FTC-Wettbewerb als Anfänger benötigen.

### Der Roboter

Sie starten mit einem einfachen Roboter namens "Trainerbot". Dann zerlegen sie die wichtigsten Subsysteme und bauen sie wieder zusammen. Dann zerlegen sie das Ganze bis auf Schrauben und Muttern, bauen es zusammen und schreiben dabei Dokumentationen, wie das geht.

Der Roboter hat 3 Hauptsubsysteme:

1. Die Elektronikwanne mit Batterie und Steuermodulen.
2. Der Antriebszug. Ja, die Elektronikpfanne hängt unter dem Antriebsstrang.
3. Das Stellglied und die Sensorik. Aktuatoren und Sensoren sind auf den Querträgern des Antriebsstrangs montiert und können auf diesen leicht verschoben werden.

Alle diese Subsysteme sind modular aufgebaut. Ein Team kann sie in ihrer Box ein- und auswechseln, wodurch mehrere Konfigurationen möglich werden. Zum Beispiel können sie eine Reihe von Antriebssträngen zu einem Meet bringen und einen auswählen, der den Stärken ihrer Allies entspricht. Sie können eine Ersatz-Elektronikpfanne mitbringen und diese in weniger als einer Minute eintauschen. Die Möglichkeiten für Aktor- und Sensor-Suiten sind nahezu unbegrenzt.

### Ein anderer Roboter

Ein weiterer Trainingsroboter wird von diesem Projekt unterstützt, der "Lookeebot". Es ist ein Antriebsstrang und ein Controller-Telefon, sonst nichts. Es ist eine Testplattform für Robotervision. Es läuft einfach mit der Kamera des Telefons herum und schaut sich Dinge an.

### Die Software

Die Software ist dieses Projekt. Es wird aus Beispielmodi aufgebaut, die den im SDK enthaltenen FtcRobotController-Beispielen sowie diesem Projekt entnommen wurden. Es ist für diesen Typ eines modularen Roboters nicht besonders gut geeignet. Für den Anfang ist diese Software nicht sehr modular.

*Einige Opmode-Klassen enthalten Methoden und Eigenschaften, die Mitglieder einer Roboterklasse sein sollten. Es gibt einige doppelte Codes unter ihnen.
*Einige Mitglieder der Roboterklasse haben unterschiedliche Komplexitätsgrade und die Komplexen sind nur teilweise auf den einfacheren aufgebaut.

Was sollen die Schüler dann damit machen?

1. Führen Sie es zuerst auf einem Trainerbot aus und punkten Sie damit bei einem frühen Saisonmeeting.
2. Beheben Sie anschließend die Mängel mit gut ausgewählten Klassen, die Abstraktion, Vererbung, Überladung usw. verwenden. Dies bedeutet, objektorientiertes Lernen in einer unterhaltsamen und wettbewerbsfähigen Umgebung zu erlernen.
3. Sie sollten in der Lage sein, neue Klassen zu schreiben und sie für neue Hardwaremodule zu verwenden, die in den späten Saison-Meets ausgetauscht werden.

Die Studierenden dieses Kurses sind dann gut qualifiziert, um zu einem fortgeschrittenen oder fortgeschrittenen FTC-Team beizutragen.


