# 3060U Project Phase 6
Shawn Yama, Liangyu Zhao, Moiz Abdul

## Prerequisites
- Java 11
- JavaFX 11
- Linux Terminal

## How to run
Stay in the root directory and enter the following to run the weekly bash script:
```bash
./weekly.sh
```

Make sure you have an environment variable called ```$PATH_TO_FX``` that points to your JavaFX lib folder.
```bash
export PATH_TO_FX=path/to/javafx-sdk-11/lib
```

## Printout Location
The ```items.txt``` and ```userAccounts.txt``` will always start off as the versions within the ```initial``` folder. Every change that is done to these files can be viewed within ```week > day#``` (# meaning whatever day number you want to examine). You will also find the three input, output and transaction streams as well as the merged transactions file here. The text files in the root folder can be ignored, the newest versions of them must be copied there in order for the backend to easily access them.
