package io.bluebeaker.saveindicator.mixin;

import org.lwjgl.opengl.Display;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.bluebeaker.saveindicator.Texts;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mixin(MinecraftServer.class)
@SideOnly(Side.CLIENT)
public abstract class MixinMinecraftServer {
    String baseTitle="";
    @Inject(at=@At("HEAD"),method = "saveAllWorlds(Z)V",remap = false)
    public void onSavingStart(CallbackInfo ci){
        baseTitle=Display.getTitle();
        Display.setTitle(baseTitle + Texts.Saving.getUnformattedText());
    }
    @Inject(at=@At("RETURN"),method = "saveAllWorlds(Z)V",remap = false)
    public void onSavingEnd(CallbackInfo ci){
        Display.setTitle(baseTitle);
    }
}
