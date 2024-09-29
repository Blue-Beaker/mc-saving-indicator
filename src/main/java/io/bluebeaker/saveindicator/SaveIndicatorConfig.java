package io.bluebeaker.saveindicator;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.Config.Type;

@Config(modid = SaveIndicator.MODID,type = Type.INSTANCE,category = "general")
public class SaveIndicatorConfig {
    @Comment("Example")
    @LangKey("config.saveindicator.example.name")
    public static boolean example = true;
}