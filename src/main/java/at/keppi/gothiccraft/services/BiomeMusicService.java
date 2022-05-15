package at.keppi.gothiccraft.services;

import at.keppi.gothiccraft.registry.SoundRegistry;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BiomeMusicService {

    private final static Map<String, RegistryObject[]> BIOME_MUSIC_MAP = new HashMap<>() {{
        put("badlands", new RegistryObject[]{SoundRegistry.MUSIC_XARDAS, SoundRegistry.MUSIC_ORCCAMP});
        put("badlands_plateau", new RegistryObject[]{SoundRegistry.MUSIC_XARDAS, SoundRegistry.MUSIC_ORCCAMP});
        put("bamboo_jungle", new RegistryObject[]{SoundRegistry.MUSIC_MONASTERY});
        put("bamboo_jungle_hills", new RegistryObject[]{SoundRegistry.MUSIC_MONASTERY});
        put("basalt_deltas", new RegistryObject[]{SoundRegistry.MUSIC_CAVE});
        put("beach", new RegistryObject[]{SoundRegistry.MUSIC_VISTAPOINT, SoundRegistry.MUSIC_VISTAPOINT});
        put("birch_forest", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANTA_WOODS});
        put("birch_forest_hills", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANTA_WOODS});
        put("cold_ocean", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANA});
        put("crimson_forest", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANTA_WOODS});
        put("dark_forest", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANTA_WOODS});
        put("dark_forest_hills", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANTA_WOODS});
        put("deep_cold_ocean", new RegistryObject[]{SoundRegistry.MUSIC_NORDMAR_CAVE});
        put("deep_frozen_ocean", new RegistryObject[]{SoundRegistry.MUSIC_NORDMAR_CAVE});
        put("deep_lukewarm_ocean", new RegistryObject[]{SoundRegistry.MUSIC_NORDMAR_CAVE});
        put("deep_ocean", new RegistryObject[]{SoundRegistry.MUSIC_NORDMAR_CAVE});
        put("deep_warm_ocean", new RegistryObject[]{SoundRegistry.MUSIC_NORDMAR_CAVE});
        put("desert", new RegistryObject[]{SoundRegistry.MUSIC_VARANT});
        put("desert_hills", new RegistryObject[]{SoundRegistry.MUSIC_VARANT});
        put("desert_lakes", new RegistryObject[]{SoundRegistry.MUSIC_VARANT});
        put("dripstone_caves", new RegistryObject[]{SoundRegistry.MUSIC_CAVE, SoundRegistry.MUSIC_ORCCAMP});
        put("end_barrens", new RegistryObject[]{SoundRegistry.MUSIC_BOSS_FIGHT});
        put("end_highlands", new RegistryObject[]{SoundRegistry.MUSIC_BOSS_FIGHT});
        put("end_midlands", new RegistryObject[]{SoundRegistry.MUSIC_BOSS_FIGHT});
        put("eroded_badlands", new RegistryObject[]{SoundRegistry.MUSIC_XARDAS, SoundRegistry.MUSIC_ORCCAMP});
        put("flower_forest", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANTA_WOODS});
        put("forest", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANTA_WOODS});
        put("frozen_ocean", new RegistryObject[]{SoundRegistry.MUSIC_NORDMAR});
        put("frozen_peaks", new RegistryObject[]{SoundRegistry.MUSIC_NORDMAR});
        put("frozen_river", new RegistryObject[]{SoundRegistry.MUSIC_NORDMAR});
        put("giant_spruce_taiga", new RegistryObject[]{SoundRegistry.MUSIC_EXPLORE, SoundRegistry.MUSIC_SAD});
        put("giant_spruce_taiga_hills", new RegistryObject[]{SoundRegistry.MUSIC_EXPLORE, SoundRegistry.MUSIC_SAD});
        put("giant_tree_taiga", new RegistryObject[]{SoundRegistry.MUSIC_EXPLORE, SoundRegistry.MUSIC_SAD});
        put("giant_tree_taiga_hills", new RegistryObject[]{SoundRegistry.MUSIC_EXPLORE, SoundRegistry.MUSIC_SAD});
        put("gravelly_mountains", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANA});
        put("grove", new RegistryObject[]{SoundRegistry.MUSIC_NORDMAR});
        put("ice_spikes", new RegistryObject[]{SoundRegistry.MUSIC_NORDMAR_CAVE});
        put("jagged_peaks", new RegistryObject[]{SoundRegistry.MUSIC_NORDMAR});
        put("jungle", new RegistryObject[]{SoundRegistry.MUSIC_MONASTERY});
        put("jungle_edge", new RegistryObject[]{SoundRegistry.MUSIC_MONASTERY});
        put("jungle_hills", new RegistryObject[]{SoundRegistry.MUSIC_MONASTERY});
        put("lukewarm_ocean", new RegistryObject[]{SoundRegistry.MUSIC_NORDMAR_CAVE});
        put("lush_caves", new RegistryObject[]{SoundRegistry.MUSIC_CAVE});
        put("meadow", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANA});
        put("modified_badlands_plateau", new RegistryObject[]{SoundRegistry.MUSIC_XARDAS, SoundRegistry.MUSIC_ORCCAMP});
        put("modified_gravelly_mountains", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANA});
        put("modified_jungle", new RegistryObject[]{SoundRegistry.MUSIC_MONASTERY});
        put("modified_jungle_edge", new RegistryObject[]{SoundRegistry.MUSIC_MONASTERY});
        put("modified_wooded_badlands_plateau", new RegistryObject[]{SoundRegistry.MUSIC_XARDAS, SoundRegistry.MUSIC_ORCCAMP});
        put("mountain_edge", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANA});
        put("mountains", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANA});
        put("mushroom_field_shore", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANA});
        put("mushroom_fields", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANA});
        put("nether_wastes", new RegistryObject[]{SoundRegistry.MUSIC_XARDAS});
        put("ocean", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANA});
        put("old_growth_birch_forest", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANTA_WOODS});
        put("old_growth_pine_taiga", new RegistryObject[]{SoundRegistry.MUSIC_EXPLORE, SoundRegistry.MUSIC_SAD});
        put("old_growth_spruce_taiga", new RegistryObject[]{SoundRegistry.MUSIC_EXPLORE, SoundRegistry.MUSIC_SAD});
        put("plains", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANA});
        put("river", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANA});
        put("savanna", new RegistryObject[]{SoundRegistry.MUSIC_VARANT});
        put("savanna_plateau", new RegistryObject[]{SoundRegistry.MUSIC_VARANT});
        put("shattered_savanna", new RegistryObject[]{SoundRegistry.MUSIC_VARANT});
        put("shattered_savanna_plateau", new RegistryObject[]{SoundRegistry.MUSIC_VARANT});
        put("small_end_islands", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANA});
        put("snowy_beach", new RegistryObject[]{SoundRegistry.MUSIC_NORDMAR});
        put("snowy_mountains", new RegistryObject[]{SoundRegistry.MUSIC_NORDMAR});
        put("snowy_plains", new RegistryObject[]{SoundRegistry.MUSIC_NORDMAR});
        put("snowy_slopes", new RegistryObject[]{SoundRegistry.MUSIC_NORDMAR});
        put("snowy_taiga", new RegistryObject[]{SoundRegistry.MUSIC_NORDMAR});
        put("snowy_taiga_hills", new RegistryObject[]{SoundRegistry.MUSIC_NORDMAR});
        put("snowy_taiga_mountains", new RegistryObject[]{SoundRegistry.MUSIC_NORDMAR});
        put("snowy_tundra", new RegistryObject[]{SoundRegistry.MUSIC_NORDMAR});
        put("soul_sand_valley", new RegistryObject[]{SoundRegistry.MUSIC_NORDMAR});
        put("sparse_jungle", new RegistryObject[]{SoundRegistry.MUSIC_MONASTERY});
        put("stone_shore", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANA});
        put("stony_peaks", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANA});
        put("stony_shore", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANA});
        put("sunflower_plains", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANA});
        put("swamp", new RegistryObject[]{SoundRegistry.MUSIC_SAD});
        put("swamp_hills", new RegistryObject[]{SoundRegistry.MUSIC_SAD});
        put("taiga", new RegistryObject[]{SoundRegistry.MUSIC_EXPLORE, SoundRegistry.MUSIC_SAD});
        put("taiga_hills", new RegistryObject[]{SoundRegistry.MUSIC_EXPLORE, SoundRegistry.MUSIC_SAD});
        put("taiga_mountains", new RegistryObject[]{SoundRegistry.MUSIC_EXPLORE, SoundRegistry.MUSIC_SAD});
        put("tall_birch_forest", new RegistryObject[]{SoundRegistry.MUSIC_EXPLORE, SoundRegistry.MUSIC_SAD});
        put("tall_birch_hills", new RegistryObject[]{SoundRegistry.MUSIC_EXPLORE, SoundRegistry.MUSIC_SAD});
        put("the_end", new RegistryObject[]{SoundRegistry.MUSIC_BOSS_FIGHT});
        put("the_void", new RegistryObject[]{SoundRegistry.MUSIC_ORCCAMP});
        put("warm_ocean", new RegistryObject[]{SoundRegistry.MUSIC_NORDMAR_CAVE});
        put("warped_forest", new RegistryObject[]{SoundRegistry.MUSIC_ARENA_FIGHT});
        put("windswept_forest", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANTA_WOODS});
        put("windswept_gravelly_hills", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANA});
        put("windswept_hills", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANA});
        put("windswept_savanna", new RegistryObject[]{SoundRegistry.MUSIC_VARANT});
        put("wooded_badlands", new RegistryObject[]{SoundRegistry.MUSIC_XARDAS, SoundRegistry.MUSIC_ORCCAMP});
        put("wooded_badlands_plateau", new RegistryObject[]{SoundRegistry.MUSIC_XARDAS, SoundRegistry.MUSIC_ORCCAMP});
        put("wooded_hills", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANTA_WOODS});
        put("wooded_mountains", new RegistryObject[]{SoundRegistry.MUSIC_MYRTANTA_WOODS});
    }};

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
            potentialNewBiome = new BiomeCounter(biomeName, 0);
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

    public void playBiomeMusic(Biome biome, Player player) {
        try {
            RegistryObject[] soundTracks = BiomeMusicService.BIOME_MUSIC_MAP.get(biome.getRegistryName().getPath());
            int randomIndex = new Random().nextInt(soundTracks.length);

            System.out.println("Play Music for: " + biome.getRegistryName());
            System.out.println("Track: " + soundTracks[randomIndex]);

            SoundService.play(soundTracks[randomIndex], player);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private class BiomeCounter {

        public String name;
        public int count;

        public BiomeCounter(String biome) {
            this.name = biome;
            this.count = 0;
        }

        public BiomeCounter(String biome, int count) {
            this.name = biome;
            this.count = count;
        }
    }
}
