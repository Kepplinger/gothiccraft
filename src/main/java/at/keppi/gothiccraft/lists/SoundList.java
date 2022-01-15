package at.keppi.gothiccraft.lists;

import at.keppi.gothiccraft.GothicCraft;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundList {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(
            ForgeRegistries.SOUND_EVENTS, GothicCraft.ID
    );

    public static final RegistryObject<SoundEvent> DEATH_SOUND = SOUNDS.register(
            "player.death", () -> new SoundEvent(new ResourceLocation(GothicCraft.ID, "player.death"))
    );
}
