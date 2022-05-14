package at.keppi.gothiccraft.registry;

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

    public static final RegistryObject<SoundEvent> PLAYER_YAWN = registerSound("player.yawn");
    public static final RegistryObject<SoundEvent> MUSIC_ARENA_FIGHT = registerSound("music.arena-fight");
    public static final RegistryObject<SoundEvent> MUSIC_BOSS_FIGHT = registerSound("music.bossfight");
    public static final RegistryObject<SoundEvent> MUSIC_CAVE = registerSound("music.cave");
    public static final RegistryObject<SoundEvent> MUSIC_EXPLORE = registerSound("music.explore");
    public static final RegistryObject<SoundEvent> MUSIC_MONASTERY = registerSound("music.monastery");
    public static final RegistryObject<SoundEvent> MUSIC_MYRTANA = registerSound("music.myrtana");
    public static final RegistryObject<SoundEvent> MUSIC_MYRTANTA_WOODS = registerSound("music.myrtana-woods");
    public static final RegistryObject<SoundEvent> MUSIC_NORDMAR = registerSound("music.nordmar");
    public static final RegistryObject<SoundEvent> MUSIC_NORDMAR_CAVE = registerSound("music.nordmar-cave");
    public static final RegistryObject<SoundEvent> MUSIC_ORCCAMP = registerSound("music.orccamp");
    public static final RegistryObject<SoundEvent> MUSIC_VARANT = registerSound("music.varant");
    public static final RegistryObject<SoundEvent> MUSIC_SAD = registerSound("music.sad");
    public static final RegistryObject<SoundEvent> MUSIC_VISTAPOINT = registerSound("music.vistapoint");
    public static final RegistryObject<SoundEvent> MUSIC_XARDAS = registerSound("music.xardas");

    public static RegistryObject<SoundEvent> registerSound(String name) {
        return SOUNDS.register(name, () -> new SoundEvent(new ResourceLocation(GothicCraft.ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }
}
