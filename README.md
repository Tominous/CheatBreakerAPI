# CheatBreaker API #
<p>This is the primary repository for my version of the CheatBreaker API. This API is not a supported
software by their development team (CheatBreaker); please do not bug them to fix any issues for you. You are free to submit
issues via the Issue tracker on GitHub, we will aim to fix or add any issues you come across.</p>

<p>Bungee support and PluginMessagingChannels support has been added.</p>
<p>Tested Versions:
   BUNGEE: 1.7 - LATEST
   PluginMessagingChannels: 1.7 - LATEST
   Packets (ProtocolLib): 1.8 (kinda broken)
   </p>

### Using CheatBreaker ###
![alt text](https://i.imgur.com/4ZvX0qi.png)

### Without CheatBreaker ###
![alt text](https://i.imgur.com/wXiMegs.png)

## Installation Instructions ##

To use this library, first add CheatBreakerAPI.jar to your Java build path. Then, add CheatBreakerAPI
as a dependency or soft dependency to your plugin.yml file like any other plugin:

````yml
depend: [CheatBreakerAPI]
````

#### Maven repository
````xml 
<dependency>
   <groupId>gg.kitpvp</groupId>
   <artifactId>cheatbreaker</artifactId>
   <version>LATEST</version>
</dependency>
````
       
#### Gradle repository
Coming soon...

#### JAR Files
1. Download the [latest version](https://github.com/MannyFlapjack/CheatBreakerAPI/releases).
2. Add the JAR to your project.
 For Eclipse users, see [here](http://stackoverflow.com/questions/11033603/how-to-create-a-jar-with-external-libraries-included-in-eclipse).
 For IntelliJ users, see [here](http://stackoverflow.com/questions/1051640/correct-way-to-add-external-jars-lib-jar-to-an-intellij-idea-project).

## Usage
Here is some example usage, the following code will tell you if a player is using CheatBreaker or not.

````java
CheatBreakerAPI.getInstance().onCheatBreaker(player); //Returns true or false
````

This is my first public github project so cut me some slack
