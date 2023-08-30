package at.keppi.gothiccraft.ticker;

import at.keppi.gothiccraft.GothicCraft;
import at.keppi.gothiccraft.services.BiomeMusicService;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/***
 * Listenes on Player ticks and manages the in-game music based on different events.
 * Events can be anything like biome/location change, enemy encounter.
 */
@Mod.EventBusSubscriber(modid = GothicCraft.ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class MusicTicker {

    private final static int THROTTLE_FACTOR = 50;
    private static int throttleCounter = 0;

    @SubscribeEvent
    public static void playerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            throttleCounter++;

            if (throttleCounter % THROTTLE_FACTOR == 0) {
                handleBiomeMusicTick(event);
                throttleCounter = 0;
            }
        }
    }

    public static void handleBiomeMusicTick(TickEvent.PlayerTickEvent event) {
        Biome biome = getCurrentPlayerBiome(event);
        BiomeMusicService service = BiomeMusicService.getInstance();

        if (service.hasBiomeChanged(biome)) {
            service.playBiomeMusic(biome, event.player);
        }
    }

    private static Biome getCurrentPlayerBiome(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        Vec3 playerPosition = player.position();
        return player.level.getBiome(new BlockPos(playerPosition));
    }
}
