package onelemonyboi.lemonlib.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraftforge.client.gui.widget.ExtendedButton;

public class InvisibleButton extends ExtendedButton {
    public int xPos;
    public int yPos;

    public InvisibleButton(int xPos, int yPos, int width, int height, Component displayString, OnPress handler) {
        super(xPos, yPos, width, height, displayString, handler);
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public InvisibleButton(int xPos, int yPos, int width, int height, Component displayString, OnPress handler, CreateNarration narration) {
        super(xPos, yPos, width, height, displayString, handler);
        this.xPos = xPos;
        this.yPos = yPos;
    }

    @Override
    public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {

    }
}
