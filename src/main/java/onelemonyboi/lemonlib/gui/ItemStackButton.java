package onelemonyboi.lemonlib.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.client.gui.widget.ExtendedButton;

public class ItemStackButton extends ExtendedButton {
    public Item item;
    public int xPos;
    public int yPos;

    public ItemStackButton(int xPos, int yPos, int width, int height, Component displayString, OnPress handler) {
        super(xPos, yPos, width, height, displayString, handler);
        this.item = Items.AIR;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public ItemStackButton(int xPos, int yPos, int width, int height, Component displayString, OnPress handler, Item item) {
        super(xPos, yPos, width, height, displayString, handler);
        this.item = item;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public ItemStackButton(int xPos, int yPos, int width, int height, Component displayString, OnPress handler, Item item, CreateNarration narration) {
        super(xPos, yPos, width, height, displayString, handler);
        this.item = item;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    @Override
    public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.renderWidget(guiGraphics, mouseX, mouseY, partialTick);
        guiGraphics.renderItem(new ItemStack(item), xPos, yPos);
    }
}
