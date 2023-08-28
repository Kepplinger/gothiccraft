package at.keppi.gothiccraft.services;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.RegistryObject;

import java.util.Random;

public class BiomeMusicService {

    private static BiomeMusicService instance;

    private String activeBiomeName;
    private BiomeCounter potentialNewBiomeCounter;

    private BiomeMusicService() {
    }

    public static BiomeMusicService getInstance() {
        if (instance == null) {
            instance = new BiomeMusicService();
        }

        return instance;
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
            potentialNewBiomeCounter = new BiomeCounter(biomeName);
            System.out.println("Potential new biome " + biomeName);

        } else {
            if (!potentialNewBiomeCounter.finished()) {
                System.out.println("Count for " + biomeName);
                potentialNewBiomeCounter.count();
            } else {
                System.out.println("Yeah new biome " + biomeName);
                activeBiomeName = potentialNewBiomeCounter.name;
                potentialNewBiomeCounter = null;
                return true;
            }
        }

        return false;
    }

    public boolean playBiomeMusic(Biome biome, Player player) {
        try {
            RegistryObject[] soundTracks = BiomeMusicFacade.getBiomeMusic(biome, player.level);
            int randomIndex = new Random().nextInt(soundTracks.length);

            RegistryObject biomeMusic = soundTracks[randomIndex];
            System.out.println("Play Music for: " + biome.getRegistryName());
            System.out.println("Track: " + biomeMusic);

            return MusicService.playMusic(biomeMusic);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    private class BiomeCounter {
        public static final int DEFAULT_LIMIT = 6;

        public String name;
        private int count = 0;
        private int limit;

        public BiomeCounter(String biome) {
            this(biome, DEFAULT_LIMIT);
        }

        public BiomeCounter(String biome, int limit) {
            this.name = biome;
            this.limit = limit;
        }

        public int count() {
            this.count++;
            return this.count;
        }

        public boolean finished() {
            return this.count >= this.limit;
        }
    }
}
