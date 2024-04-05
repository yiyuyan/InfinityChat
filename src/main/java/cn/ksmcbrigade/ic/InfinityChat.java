package cn.ksmcbrigade.ic;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod("icc")
public class InfinityChat {

    public InfinityChat() {
        MinecraftForge.EVENT_BUS.register(this);

    }
}
