# 3060U_Back

### Prerequisites
- Java 8 or higher 
- Corresponding JavaFX version

### How to run on Windows cmd
Go into the src directory then enter the following:
```bash
> javac --module-path %PATH_TO_FX% --add-modules javafx.controls main.java
> java --module-path %PATH_TO_FX% --add-modules javafx.controls main.java
```
Note that %PATH_TO_FX% is an environment variable that points to the lib directory in your JavaFX SDK. For example mine is:
```
"C:\Program Files\Java\javafx-sdk-14\lib"
```
If you don't want to create an environment variable you can replace it with your directory that takes you to lib instead.
