# phoebeProto

Szoftverlabor 4 Proto

A forrásfájlok kódolása Cp1250, másnéven Windows-1250.

Könyvtár hierarchia futtatás előtt:
│   compile.cmd
│   MANIFEST.MF
│   README.md
│   run.cmd
│
├───maps
│       goo.map
│       goo.robots
│       small.map
│       small.robots
│
├───resources
│       cleaner.png
│       robot.png
│
└───src
    ├───controller
    │       CleanerFactory.java
    │       Controller.java
    │       GooFactory.java
    │       NormalFieldFactory.java
    │       OilFactory.java
    │       RobotFactory.java
    │
    ├───model
    │       Cleaner.java
    │       Edge.java
    │       Field.java
    │       GameManager.java
    │       Goo.java
    │       Jumping.java
    │       Landable.java
    │       Map.java
    │       Node.java
    │       NormalField.java
    │       Oil.java
    │       OutsideField.java
    │       Printable.java
    │       Robot.java
    │       RobotState.java
    │       Trap.java
    │
    └───view
            CleanerView.java
            ControlPanel.java
            Drawable.java
            GamePanel.java
            GooView.java
            NormalFieldView.java
            OilView.java
            RobotView.java
            View.java
		
Fordítás és futtatás:
	Sorban futtatjuk az alábbi fájlokat a gyökérkönyvtárból:
		compile.cmd
		run.cmd
		
	vagy:
		compile.cmd
		Phoebe.jar


Könyvtár hierarchia futtatás után:
│   compile.cmd
│   MANIFEST.MF
│   Phoebe.jar
│   README.md
│   run.cmd
│
├───bin
│   │   cleaner.png
│   │   robot.png
│   │
│   ├───controller
│   │       CleanerFactory.class
│   │       Controller.class
│   │       GooFactory.class
│   │       NormalFieldFactory.class
│   │       OilFactory.class
│   │       RobotFactory.class
│   │
│   ├───maps
│   │       goo.map
│   │       goo.robots
│   │       small.map
│   │       small.robots
│   │
│   ├───model
│   │       Cleaner.class
│   │       Edge.class
│   │       Field.class
│   │       GameManager.class
│   │       Goo.class
│   │       Jumping.class
│   │       Landable.class
│   │       Map.class
│   │       Node.class
│   │       NormalField.class
│   │       Oil.class
│   │       OutsideField.class
│   │       Printable.class
│   │       Robot.class
│   │       RobotState.class
│   │       Trap.class
│   │
│   └───view
│           CleanerView.class
│           ControlPanel$1.class
│           ControlPanel$2.class
│           ControlPanel$3.class
│           ControlPanel$4.class
│           ControlPanel$5.class
│           ControlPanel$6.class
│           ControlPanel$7.class
│           ControlPanel.class
│           Drawable.class
│           GamePanel.class
│           GooView.class
│           NormalFieldView.class
│           OilView.class
│           RobotView.class
│           View$1.class
│           View$2.class
│           View$3.class
│           View$4.class
│           View.class
│
├───maps
│       goo.map
│       goo.robots
│       small.map
│       small.robots
│
├───resources
│       cleaner.png
│       robot.png
│
└───src
    ├───controller
    │       CleanerFactory.java
    │       Controller.java
    │       GooFactory.java
    │       NormalFieldFactory.java
    │       OilFactory.java
    │       RobotFactory.java
    │
    ├───model
    │       Cleaner.java
    │       Edge.java
    │       Field.java
    │       GameManager.java
    │       Goo.java
    │       Jumping.java
    │       Landable.java
    │       Map.java
    │       Node.java
    │       NormalField.java
    │       Oil.java
    │       OutsideField.java
    │       Printable.java
    │       Robot.java
    │       RobotState.java
    │       Trap.java
    │
    └───view
            CleanerView.java
            ControlPanel.java
            Drawable.java
            GamePanel.java
            GooView.java
            NormalFieldView.java
            OilView.java
            RobotView.java
            View.java