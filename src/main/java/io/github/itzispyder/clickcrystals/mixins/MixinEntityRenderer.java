package io.github.itzispyder.clickcrystals.mixins;

import io.github.itzispyder.clickcrystals.modules.Module;
import io.github.itzispyder.clickcrystals.modules.modules.rendering.GlowingEntities;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityRenderer.class)
public abstract class MixinEntityRenderer {

    @Inject(method = "getBlockLight", at = @At("RETURN"), cancellable = true)
    public <T extends Entity> void getLight(T entity, BlockPos pos, CallbackInfoReturnable<Integer> cir) {
        GlowingEntities glowingEntities = Module.get(GlowingEntities.class);

        if (glowingEntities.isEnabled()) {
            double light = glowingEntities.lightLevel.getVal();
            cir.setReturnValue((int) light);
        }
    }
}
