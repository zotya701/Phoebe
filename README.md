# phoebeProto

Szoftverlabor 4 Proto

A forrásfájlok kódolása Cp1250, másnéven Windows-1250.

Könyvtár hierarchia futtatás előtt:
│   01_compile.cmd
│   02_copy_files.cmd
│   03_run.cmd
│   ALL.cmd
│   create_jar.cmd
│   MANIFEST.MF
│   README.md
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
		
Fordítás és futtatás egyszerűen:
	Sorban futtatjuk az alábbi fájlokat a gyökérkönyvtárból:
		01_compile.cmd
		02_copy_files.cmd
		03_run.cmd
		
	vagy:
		ALL.cmd
		03_run.cmd
	vagy:
		ALL.cmd
		Phoebe.jar
	vagy:
		01_compile.cmd
		02_copy_files.cmd
		create_jar.cmd
		Phoebe.jar
	
Parancssorból:
	A gyökér könyvtárban shift+jobb klikk, Open command window here, majd futtatjuk az alábbi parancsokat:
		
		Fordítás:		if not exist bin mkdir bin
						javac -d bin src/controller/*.java src/model/*.java src/view/*.java
		
		Futtatás:		if not exist "bin\maps" mkdir "bin\maps"
						xcopy "maps\*.*" "bin\maps" /y
						xcopy "resources\*.png" "bin\" /y
						cd bin
						java model.GameManager
		
Könyvtár hierarchia futtatás után:
│   01_compile.cmd
│   02_copy_files.cmd
│   03_run.cmd
│   ALL.cmd
│   create_jar.cmd
│   MANIFEST.MF
│   Phoebe.jar
│   README.md
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