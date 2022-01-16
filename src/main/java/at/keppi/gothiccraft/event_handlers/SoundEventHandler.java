package at.keppi.gothiccraft.event_handlers;

import at.keppi.gothiccraft.GothicCraft;
import at.keppi.gothiccraft.lists.SoundRegistry;
import at.keppi.gothiccraft.services.SoundService;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;

@Mod.EventBusSubscriber(modid = GothicCraft.ID, bus = Bus.FORGE, value = Dist.CLIENT)
public class SoundEventHandler {

    @SubscribeEvent
    public static void onWakeup(PlayerWakeUpEvent event) {
        Player player = event.getPlayer();
        player.playSound(SoundRegistry.PLAYER_YAWN.get(), 1F, 1F);
    }

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof Player player) {
            SoundService.play(SoundRegistry.PLAYER_DEATH, player);
        }
    }
}
