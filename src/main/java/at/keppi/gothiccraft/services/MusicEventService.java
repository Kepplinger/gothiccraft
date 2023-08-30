package at.keppi.gothiccraft.services;

import net.minecraftforge.event.TickEvent;

public interface MusicEventService {
    int getPriority();
    boolean handleTick(TickEvent.PlayerTickEvent event);
}
