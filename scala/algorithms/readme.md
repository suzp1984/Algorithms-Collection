* How to run the sample

    ```sbt run```
    
* deploy the sample as App

    ```sbt package```
    
    then check the output in `target/scala-2.12/` direcotry.
    run the jar from scala:
    
    `scala target/scala-2.12/algorithms_2.12-0.1.jar`
    
    deploy the fat jar with all dependencies:
    
    `sbt assembly`

    Run the fat jar:
    
    `java -jar target/scala-2.12/algorithms-assembly-0.1.jar`

