package at.keppi.gothiccraft.event_handlers;

import at.keppi.gothiccraft.GothicCraft;
import at.keppi.gothiccraft.lists.SoundList;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;

@Mod.EventBusSubscriber(modid = GothicCraft.ID, bus = Bus.FORGE, value = Dist.CLIENT)
public class SoundEventHandler {

    @SubscribeEvent
    public static void onWakeup(PlayerWakeUpEvent event) {
        // TODO verify if this a 'LocalPLayer' instance (otherwise you would not hear it)
        Player player = (Player) event.getPlayer();
        player.playSound(SoundList.DEATH_SOUND.get(), 1F, 1F);
    }
}
