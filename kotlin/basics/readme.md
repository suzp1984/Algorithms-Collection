* How to run the sample

    ```./gradlew run```
    
* deploy the sample as App

    ```./gradlew build```
    
    then check the output in `build` direcotry.
    run the fat jar directly:
    
    `java -jar build/libs/algorithm-fat-1.0-SNAPSHOT.jar`
    
    Or run the jar without kotlin runtime in this way:
    
    `kotlin -classpath build/libs/algorithm-1.0-SNAPSHOT.jar HelloKt`
    