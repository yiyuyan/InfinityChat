package cn.ksmcbrigade.ic.mixin;

import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.ChatScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChatScreen.class)
public abstract class ChatMixin {

    @Shadow protected EditBox input;

    @Inject(method = "init",at = @At(value = "TAIL"))
    public void init(CallbackInfo ci){
        this.input.setMaxLength(Integer.MAX_VALUE);
    }
}
