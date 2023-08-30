package at.keppi.gothiccraft.ticker;

import at.keppi.gothiccraft.GothicCraft;
import at.keppi.gothiccraft.services.BiomeMusicService;
import at.keppi.gothiccraft.services.MusicEventService;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Comparator;
import java.util.List;

/***
 * Listenes on Player ticks and manages the in-game music based on different events.
 * Events can be anything like biome/location change, enemy encounter.
 */
@Mod.EventBusSubscriber(modid = GothicCraft.ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class MusicTicker {

    private final static int TICK_THRESHOLD = 50;

    private static int tickCounter = 0;

    private final static List<MusicEventService> musicEventServices = List.of(
            BiomeMusicService.getInstance()
    );

    @SubscribeEvent
    public static void playerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            tickCounter++;

            if (tickCounter >= TICK_THRESHOLD) {
                tickCounter = 0;
                musicEventServices.stream()
                        .sorted(Comparator.comparingInt(MusicEventService::getPriority))
                        .forEach(musicEventService -> musicEventService.handleTick(event));
            }
        }
    }
}
