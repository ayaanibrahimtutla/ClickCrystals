package io.github.itzispyder.clickcrystals;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.itzispyder.clickcrystals.client.system.ClickCrystalsSystem;
import io.github.itzispyder.clickcrystals.client.system.Version;
import net.minecraft.client.MinecraftClient;

public interface Global {

    MinecraftClient mc = MinecraftClient.getInstance();
    ClickCrystalsSystem system = ClickCrystalsSystem.getInstance();
    Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();


    Version version = Version.ofString("1.2.0");
    String prefix = "[ClickCrystals] ";
    String starter = "§7[§bClick§3Crystals§7] §r";
    String modId = "clickcrystals";

}
