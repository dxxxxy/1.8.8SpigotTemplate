# 1.8.8SpigotTemplate
A ready to use template for developing spigot plugins on `1.8.8/1.8.9` with `shade` plugin integrated including the latest version of PaperMC's `server.jar`. Tested flawlessly on `IntelliJ IDEA Ultimate 2022.2.1`.

![](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![](https://img.shields.io/badge/1.8.8/1.8.9-53AC56?style=for-the-badge&logo=Minetest&logoColor=white)

## Setup
1. Clone this repository.
2. Open the project and let maven configure it.
> *Check out [#build](#build), [#run](#run) and [#debug](#debug) for more information.*

## Build
1. Run the `package` task in Maven: `Lifecycle > package`
> Output .jar will be located in `server/plugins/`

## Run
> The `server.jar` is `paper 1.8.8 build 445`. You can see a list of builds [here](https://api.papermc.io/v2/projects/paper/versions/1.8.8/builds/). It probably won't be updated for a long time as the last build was in December 2021.
1. Open a terminal and cd into the server folder.
2. Run the following command which contains some good performance improving arguments.
```shell
# Make sure you're using cmd instead of ps as default terminal.
java -Xms4G -Xmx4G -XX:+UseG1GC -XX:+ParallelRefProcEnabled -XX:MaxGCPauseMillis=200 -XX:+UnlockExperimentalVMOptions -XX:+DisableExplicitGC -XX:+AlwaysPreTouch -XX:G1NewSizePercent=30 -XX:G1MaxNewSizePercent=40 -XX:G1HeapRegionSize=8M -XX:G1ReservePercent=20 -XX:G1HeapWastePercent=5 -XX:G1MixedGCCountTarget=4 -XX:InitiatingHeapOccupancyPercent=15 -XX:G1MixedGCLiveThresholdPercent=90 -XX:G1RSetUpdatingPauseTimePercent=5 -XX:SurvivorRatio=32 -XX:+PerfDisableSharedMem -XX:MaxTenuringThreshold=1 -Dusing.aikars.flags=https://mcflags.emc.gs -Daikars.new.flags=true -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -jar server.jar nogui
```

## Debug
> Once you've run your server, you can use `HotSwap` instead of using `/reload` if it crashes your load events.
1. Create a new run configuration using the `Remote JVM Configuration` type.
2. Make sure the cmdline arguments match the ones you used to run the server.