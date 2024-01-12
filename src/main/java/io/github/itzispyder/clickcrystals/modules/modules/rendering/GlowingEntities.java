package io.github.itzispyder.clickcrystals.modules.modules.rendering;

import io.github.itzispyder.clickcrystals.modules.Categories;
import io.github.itzispyder.clickcrystals.modules.Module;
import io.github.itzispyder.clickcrystals.modules.ModuleSetting;
import io.github.itzispyder.clickcrystals.modules.settings.SettingSection;

public class GlowingEntities extends Module {

    private final SettingSection scGeneral = getGeneralSection();
    public final ModuleSetting<Double> light_level = scGeneral.add(createDoubleSetting()
            .name("entity-light-level")
            .description("Entity light level.")
            .def(15.0)
            .max(15.0)
            .min(0.0)
            .build()
    );

    public GlowingEntities() {
        super("glowing-entities", Categories.RENDER, "Having trouble seeing entities in the dark?");
    }

    @Override
    protected void onEnable() {

    }

    @Override
    protected void onDisable() {

    }
}
