package com.cyanwarriorswords.cyanwarriorswordsmod.Swords.CyanType;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemcyanSword extends ItemSword{

	public ItemcyanSword(int par1, Item.ToolMaterial par2EnumToolMaterial)
	{
		    super(par2EnumToolMaterial);
		    this.setMaxDamage(4000);
		    this.setMaxStackSize(1);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{  
	        this.itemIcon = ir.registerIcon("CyanWarriorSwords:CyanSword");
	}
	public boolean isFull3D()
	{
	        return true;
	}
	public int getItemEnchantability()
	{
	    return 20;
	}
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
	    return 100000;
	}
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	{
	    return 1.5F;
	}
	public int getDamageVsEntity(Entity par1Entity)
	{
	    return 6;
	}
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entity){
		entity.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
		float var4 = 1.0F;
	int i = (int)(entity.prevPosX + (entity.posX - entity.prevPosX) * (double)var4);
	int j = (int)(entity.prevPosY + (entity.posY - entity.prevPosY) * (double)var4 + 1.62D - (double)entity.yOffset);
	int k = (int)(entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)var4);
	return itemstack;
	}
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
	    return true;
	}
	public void onCreated(ItemStack itemstack, World world, EntityPlayer entity){
	float var4 = 1.0F;
	int i = (int)(entity.prevPosX + (entity.posX - entity.prevPosX) * (double)var4);
	int j = (int)(entity.prevPosY + (entity.posY - entity.prevPosY) * (double)var4 + 1.62D - (double)entity.yOffset);
	int k = (int)(entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)var4);
	}
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
	{
	    return true;
	}
}
