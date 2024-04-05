package cn.ksmcbrigade.ic.mixin;

import net.minecraft.network.protocol.game.ServerboundChatPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ServerboundChatPacket.class)
public interface PacketAccessor {
    @Accessor("message")
    @Mutable
    void set(String message);
}
