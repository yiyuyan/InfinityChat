package cn.ksmcbrigade.ic.mixin;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.FriendlyByteBuf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Mixin(value = FriendlyByteBuf.class)
public abstract class PacketFix {
    @Shadow public abstract int readerIndex();

    @Shadow public abstract String toString(int p_130454_, int p_130455_, Charset p_130456_);

    @Shadow public abstract int readVarInt();

    @Shadow public abstract ByteBuf readerIndex(int p_130343_);

    @Inject(method = "readUtf(I)Ljava/lang/String;",at = @At(value = "HEAD"),cancellable = true)
    public void read(int p_130137_, CallbackInfoReturnable<String> cir){
        int i = readVarInt();
        if(!(i<0)){
            String s = this.toString(this.readerIndex(), i, StandardCharsets.UTF_8);
            this.readerIndex(this.readerIndex() + i);
            cir.setReturnValue(s);
            cir.cancel();
        }
    }
}
