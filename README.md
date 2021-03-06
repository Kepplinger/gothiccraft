# Gothic Craft
Built with Minecraft Forge:
https://files.minecraftforge.net/net/minecraftforge/forge/

### Install mod
1. Run `gradlew build` from project root
2. Find the newly built JAR file inside `build/libs`
3. Place this jar file into the `mods` folder inside your Forge enabled Minecraft installation

### Test your mod locally

1. Generating IDE Launch/Run Configurations:
 - For IntelliJ, run the `genIntellijRuns` gradle task (`gradlew genIntellijRuns`)
 - For Eclipse, run the `genEclipseRuns` gradle task (`gradlew genEclipseRuns`)
 - For VSCode, run the `genVSCodeRuns` gradle task (`gradlew genVSCodeRuns`)

2. This will generate the Launch Configurations and download any required assets for the game to run. After this has finished, refresh your project.<br />
   
3. Run `gradlew runClient`.  This will launch Minecraft from the <runDir> location along with your mod’s code in any source sets specified within your run configurations. The default MDK includes the main source set, so any code written within src/main/java will be applied.

If you encounter any errors, please read the docs and try to solve them: https://mcforge.readthedocs.io/en/1.18.x/gettingstarted/

### Useful Links

Forge Docs: https://mcforge.readthedocs.io/en/1.18.x/ <br />
Gothic 3 PAK extractor: http://www.bendlins.de/nico/gothic3/ <br />
sounds.json entires: https://minecraft.fandom.com/wiki/Sounds.json#Sound_events
