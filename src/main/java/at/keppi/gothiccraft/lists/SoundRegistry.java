package at.keppi.gothiccraft.lists;

import at.keppi.gothiccraft.GothicCraft;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundRegistry {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(
            ForgeRegistries.SOUND_EVENTS, GothicCraft.ID
    );

    public static final RegistryObject<SoundEvent> PLAYER_DEATH = registerSound("player.death");
    public static final RegistryObject<SoundEvent> PLAYER_YAWN = registerSound("player.yawn");

    private static RegistryObject<SoundEvent> registerSound(String name) {
        return SOUNDS.register(name, () -> new SoundEvent(new ResourceLocation(GothicCraft.ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }
}
