package com.cyanwarriorswords.cyanwarriorswordsmod.Swords.TNTType;

import net.minecraft.entity.effect.EntityLightningBolt;import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ItemCannonSword extends ItemSword{
	
	private static int tntloopcount = 10;

	public ItemCannonSword(int par1, ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		// TODO Auto-generated constructor stub
		this.setMaxDamage(1000);
		this.setMaxStackSize(1);
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entity){
		entity.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
		float var4 = 1.0F;
		int i = (int)(entity.prevPosX + (entity.posX - entity.prevPosX) * (double)var4);
		int j = (int)(entity.prevPosY + (entity.posY - entity.prevPosY) * (double)var4 + 1.62D - (double)entity.yOffset);
		int k = (int)(entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)var4);
		//world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k+2));
		for(int t = 0; t<tntloopcount;t++)
		{
			world.spawnEntityInWorld(new EntityTNTPrimed(world, i, j, k, entity));

		}
		return itemstack;
		}
}
