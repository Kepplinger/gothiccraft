package at.keppi.gothiccraft.services;

import at.keppi.gothiccraft.utils.SimpleCounter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.Random;

public class BiomeMusicService implements MusicEventService {

    private static BiomeMusicService instance;

    private String activeBiomeName;
    private SimpleCounter potentialNewBiomeCounter;

    private BiomeMusicService() {
    }

    public static BiomeMusicService getInstance() {
        if (instance == null) {
            instance = new BiomeMusicService();
        }

        return instance;
    }

    public int getPriority() {
        return 100;
    }

    public boolean handleTick(TickEvent.PlayerTickEvent event) {
        Biome biome = getCurrentPlayerBiome(event);

        if (hasBiomeChanged(biome)) {
            return playBiomeMusic(biome, event.player);
        } else {
            return false;
        }
    }

    private Biome getCurrentPlayerBiome(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        Vec3 playerPosition = player.position();
        return player.level.getBiome(new BlockPos(playerPosition));
    }

    public boolean hasBiomeChanged(Biome biome) {
        try {
            String biomeName = biome.getRegistryName().getPath();

            if (activeBiomeName == null) {
                activeBiomeName = biomeName;
                System.out.println("First sound for " + biomeName);

                return true;
            } else if (isNewBiome(biomeName)) {
                return isNewBiomeOverThreshold(biomeName);
            } else {
                potentialNewBiomeCounter = null;
                System.out.println("Reset " + biomeName);

                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isNewBiome(String biomeName) {
        return !biomeName.equals(activeBiomeName);
    }

    private boolean isNewBiomeOverThreshold(String biomeName) {
        if (potentialNewBiomeCounter == null || !biomeName.equals(potentialNewBiomeCounter.name)) {
            potentialNewBiomeCounter = new SimpleCounter(biomeName);
            System.out.println("Potential new biome " + biomeName);
        } else {
            if (potentialNewBiomeCounter.isLimitReached()) {
                System.out.println("Yeah new biome " + biomeName);
                activeBiomeName = potentialNewBiomeCounter.name;
                potentialNewBiomeCounter = null;
                return true;
            } else {
                System.out.println("Count for " + biomeName);
                potentialNewBiomeCounter.count();
            }
        }

        return false;
    }

    private boolean playBiomeMusic(Biome biome, Player player) {
        try {
            RegistryObject biomeMusic = getRandomBiomeMusic(biome, player);
            System.out.println("Play Music for: " + biome.getRegistryName());
            System.out.println("Track: " + biomeMusic);

            return MusicService.playMusic(biomeMusic);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    private RegistryObject getRandomBiomeMusic(Biome biome, Player player) {
        RegistryObject[] soundTracks = BiomeMusicFacade.getBiomeMusic(biome, player.level);
        int randomIndex = new Random().nextInt(soundTracks.length);
        return soundTracks[randomIndex];
    }
}
