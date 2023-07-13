package io.github.itzispyder.clickcrystals.gui.elements.cc;

import io.github.itzispyder.clickcrystals.gui.GuiElement;
import io.github.itzispyder.clickcrystals.gui.GuiTextures;
import io.github.itzispyder.clickcrystals.gui.screens.ModuleSettingsScreen;
import io.github.itzispyder.clickcrystals.modules.Module;
import io.github.itzispyder.clickcrystals.util.DrawableUtils;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import static io.github.itzispyder.clickcrystals.ClickCrystals.mc;

public class ModuleElement extends GuiElement {

    private final Module module;

    public ModuleElement(Module module, int x, int y, int width) {
        super(x, y, width, width / 4);
        this.module = module;
    }

    @Override
    public void onRender(DrawContext context, int mouseX, int mouseY) {
        Identifier texture = GuiTextures.MODULE_EMPTY;

        if (module != null) {
            if (module.isEnabled()) {
                texture = GuiTextures.MODULE_ON;
            }
            else {
                texture = GuiTextures.MODULE_OFF;
            }
        }

        context.drawTexture(texture, x, y, 0, 0, width, height, width, height);

        if (module != null) {
            DrawableUtils.drawText(context, module.getNameLimited(), x + 7, y + (int)(height * 0.33), 0.5F, true);
        }
    }

    @Override
    public void onClick(double mouseX, double mouseY, int button) {
        mc.player.playSound(SoundEvents.BLOCK_WOODEN_DOOR_OPEN, SoundCategory.MASTER, 0.8F, 2);

        if (button == 0) {
            module.setEnabled(!module.isEnabled(), false);
        }
        else if (button == 1) {
            mc.currentScreen.close();
            mc.setScreenAndRender(new ModuleSettingsScreen(module));
        }
    }

    public Module getModule() {
        return module;
    }
}
