package com.cyanwarriorswords.cyanwarriorswordsmod.Swords.TNTType;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ItemTNTSword extends ItemSword {

	public ItemTNTSword(int par1, ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		this.setMaxDamage(1000);
		this.setMaxStackSize(1);
		// TODO Auto-generated constructor stub
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{  
	        this.itemIcon = ir.registerIcon("CyanWarriorSwords:TNTSword");
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entity){
		entity.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
		float var4 = 1.0F;
		int i = (int)(entity.prevPosX + (entity.posX - entity.prevPosX) * (double)var4);
		int j = (int)(entity.prevPosY + (entity.posY - entity.prevPosY) * (double)var4 + 1.62D - (double)entity.yOffset);
		int k = (int)(entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)var4);
		//world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k+2));
		world.spawnEntityInWorld(new EntityTNTPrimed(world, i, j, k, entity));
		return itemstack;
		}
}
