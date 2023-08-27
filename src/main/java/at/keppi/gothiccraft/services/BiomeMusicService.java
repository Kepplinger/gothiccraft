package at.keppi.gothiccraft.services;

import at.keppi.gothiccraft.registry.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BiomeMusicService {

    private static BiomeMusicService instance;

    private String activeBiomeName;
    private BiomeCounter potentialNewBiome;

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
                potentialNewBiome = null;
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
        if (potentialNewBiome == null || !biomeName.equals(potentialNewBiome.name)) {
            potentialNewBiome = new BiomeCounter(biomeName);
            System.out.println("Potential new biome " + biomeName);

        } else {
            if (potentialNewBiome.count <= 6) {
                System.out.println("Count for " + biomeName);
                potentialNewBiome.count++;
            } else {
                System.out.println("Yeah new biome " + biomeName);
                activeBiomeName = potentialNewBiome.name;
                potentialNewBiome = null;

                return true;
            }
        }

        return false;
    }

    public boolean playBiomeMusic(Biome biome, Player player) {
        try {
            RegistryObject[] soundTracks = BiomeMusicFacade.get(biome.getRegistryName().getPath(), player.level);
            int randomIndex = new Random().nextInt(soundTracks.length);

            RegistryObject biomeMusic = soundTracks[randomIndex];
            System.out.println("Play Music for: " + biome.getRegistryName());
            System.out.println("Track: " + biomeMusic);

            return MusicService.play(biomeMusic);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    private class BiomeCounter {

        public String name;
        public int count;

        public BiomeCounter(String biome) {
            this(biome, 0);
        }

        public BiomeCounter(String biome, int count) {
            this.name = biome;
            this.count = count;
        }
    }
}
