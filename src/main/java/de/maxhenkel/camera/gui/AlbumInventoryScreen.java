package de.maxhenkel.camera.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import de.maxhenkel.camera.Main;
import de.maxhenkel.corelib.inventory.ScreenBase;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class AlbumInventoryScreen extends ScreenBase<AlbumInventoryContainer> {

    public static final ResourceLocation DEFAULT_IMAGE = new ResourceLocation(Main.MODID, "textures/gui/album.png");

    private Inventory playerInventory;

    public AlbumInventoryScreen(AlbumInventoryContainer albumInventory, Inventory playerInventory, Component name) {
        super(DEFAULT_IMAGE, albumInventory, playerInventory, name);

        this.playerInventory = playerInventory;
        imageWidth = 176;
        imageHeight = 222;
    }

    @Override
    protected void renderLabels(PoseStack matrixStack, int x, int y) {
        super.renderLabels(matrixStack, x, y);
        font.draw(matrixStack, getTitle().getVisualOrderText(), 8F, 6F, FONT_COLOR);
        font.draw(matrixStack, playerInventory.getDisplayName().getVisualOrderText(), 8F, (float) (imageHeight - 96 + 2), FONT_COLOR);
    }

}