package cn.ksmcbrigade.ic.mixin;

import io.netty.buffer.*;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.game.ServerboundChatPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.nio.charset.StandardCharsets;

@Mixin(LocalPlayer.class)
public class PacketMixin {

    @Shadow @Final public ClientPacketListener connection;

    @Inject(method = "chat",at = @At(value = "HEAD"), cancellable = true)
    public void init(String p_133830_, CallbackInfo ci){
        if(p_133830_.length()>256){
            ServerboundChatPacket packet = new ServerboundChatPacket("");
            ((PacketAccessor)packet).set(p_133830_);
            this.connection.send(packet);
            ci.cancel();
        }
    }
}
