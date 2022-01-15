package at.keppi.gothiccraft;

import at.keppi.gothiccraft.event_handlers.SoundEventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(GothicCraft.ID)
public class GothicCraft {

    public static final String ID = "gothiccraft";
    private static final Logger LOGGER = LogManager.getLogger();

    public GothicCraft() {
        final IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        modBus.addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("Gothic Craft: Hello World");
    }
}
