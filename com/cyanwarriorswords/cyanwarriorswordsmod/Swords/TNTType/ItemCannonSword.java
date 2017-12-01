package com.cyanwarriorswords.cyanwarriorswordsmod.Swords.TNTType;

import com.sun.javafx.geom.Vec3d;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.effect.EntityLightningBolt;import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemCannonSword extends ItemSword{
	
	private static int tntloopcount = 10;

	public ItemCannonSword(int par1, ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		// TODO Auto-generated constructor stub
		this.setMaxDamage(1000);
		this.setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{  
	        this.itemIcon = ir.registerIcon("CyanWarriorSwords:CannonSword");
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entity){
		entity.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
		float var4 = 1.0F;
		int x = (int)(entity.prevPosX + (entity.posX - entity.prevPosX) * (double)var4);
		int y = (int)(entity.prevPosY + (entity.posY - entity.prevPosY) * (double)var4 + 1.62D - (double)entity.yOffset);
		int z = (int)(entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)var4);
		
//		int var24;
//		if(entity.rotationYaw <0)
//		{
//			var24 = (int)Math.floor((double)((entity.rotationYaw + 360.0F) * 4.0F / 360.0F) + 0.5D)+2;
//		}
//		else{
//			var24 = (int)Math.floor((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D)+2;
//		}
//		EnumFacing facing = EnumFacing.values()[var24];
//		if(entity.rotationPitch < -45.0f){
//			facing = EnumFacing.UP;
//		}
//		else if(entity.rotationPitch > 45.0f){
//			facing = EnumFacing.DOWN;
//		}
//		
//		System.out.println(facing.toString());
//		switch (facing) {
//			case WEST:
//				for(int t = 0; t<tntloopcount;t++)
//				{
//					world.spawnEntityInWorld(new EntityTNTPrimed(world, x, y, z-4, entity));
//				}
//				break;
//			case EAST:
//				for(int t = 0; t<tntloopcount;t++)
//				{
//					world.spawnEntityInWorld(new EntityTNTPrimed(world, x-4, y, z, entity));
//				}
//				break;
//			case NORTH:
//				for(int t = 0; t<tntloopcount;t++)
//				{
//					world.spawnEntityInWorld(new EntityTNTPrimed(world, x, y, z+4, entity));
//				}
//				break;
//			case SOUTH:
//				for(int t = 0; t<tntloopcount;t++)
//				{
//					world.spawnEntityInWorld(new EntityTNTPrimed(world, x+4, y, z, entity));
//				}
//				break;
//			case UP:
//				for(int t = 0; t<tntloopcount;t++)
//				{
//					world.spawnEntityInWorld(new EntityTNTPrimed(world, x, y+4, z, entity));
//				}
//				break;
//			case DOWN:
//				for(int t = 0; t<tntloopcount;t++)
//				{
//					world.spawnEntityInWorld(new EntityTNTPrimed(world, x, y, z, entity));
//				}
//				break;
		for(int t = 0; t<tntloopcount;t++)
		{
			world.spawnEntityInWorld(new EntityTNTPrimed(world, x, y, z, entity));
		}
		//}
		return itemstack;
		}
}
