package com.magistuarmory.client.renderer.entity.layer;

import com.magistuarmory.KnightlyArmory;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class SunblockLayer<T extends LivingEntity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
    private static final ResourceLocation SUNBLOCK_ARMOR = new ResourceLocation(KnightlyArmory.ID, "textures/entity/sunblock_glow.png");

    public SunblockLayer(IEntityRenderer<T, M> entityRendererIn)
    {
        super(entityRendererIn);
    }

    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch)
    {
        float f = 1.0f;
        EntityModel<T> entitymodel = this.getParentModel();
        entitymodel.prepareMobModel(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
        this.getParentModel().copyPropertiesTo(entitymodel);
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.energySwirl(this.getTexture(), this.getThickness(f), f * 0.01F));
        entitymodel.setupAnim(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        entitymodel.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1F, 1F, 0.1F, 1.0F);

    }

    protected float getThickness(float p_225634_1_)
    {
        return p_225634_1_ * 0.02F;
    }

    protected @NotNull ResourceLocation getTexture()
    {
        return SUNBLOCK_ARMOR;
    }
}
