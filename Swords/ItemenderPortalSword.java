package com.cyanwarriorswords.cyanwarriorswordsmod.Swords;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;

public class ItemenderPortalSword extends ItemSword{

	public ItemenderPortalSword(int par1, ToolMaterial par2EnumToolMaterial) {
		super(par2EnumToolMaterial);
		this.setMaxDamage(1500);
		this.setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{  
	        this.itemIcon = ir.registerIcon("CyanWarriorSwords:EnderPortalSword");
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
    return 5;
}
public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entity){
float var4 = 1.0F;
int i = (int)(entity.prevPosX + (entity.posX - entity.prevPosX) * (double)var4);
int j = (int)(entity.prevPosY + (entity.posY - entity.prevPosY) * (double)var4 + 1.62D - (double)entity.yOffset);
int k = (int)(entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)var4);

MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, entity, false);

if (movingobjectposition != null && movingobjectposition.typeOfHit == MovingObjectPosition
.MovingObjectType.BLOCK)
{
    int e = world.getBlockMetadata(movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ);

    /*
    if (e == Blocks.end_portal_frame.registerBlocks();)
    {
        return itemstack;
    }
    */
}

if (!world.isRemote)
{
    ChunkPosition chunkposition = world.findClosestStructure("Stronghold", (int)entity.posX, (int)entity.posY, (int)entity.posZ);

    if (chunkposition != null)
    {
        EntityEnderEye entityendereye = new EntityEnderEye(world, entity.posX, entity.posY + 1.62D - (double)entity.yOffset, entity.posZ);
        entityendereye.moveTowards((double)chunkposition.chunkPosX, chunkposition.chunkPosY, (double)chunkposition.chunkPosZ);
        world.spawnEntityInWorld(entityendereye);
        world.playSoundAtEntity(entity, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        world.playAuxSFXAtEntity((EntityPlayer)null, 1002, (int)entity.posX, (int)entity.posY, (int)entity.posZ, 0);
    }
}

itemstack.damageItem(25, entity);

return itemstack;
}

public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
{
	/*
	Random rnd;
	double d0 = par3EntityLivingBase.posX + (Math.rand.nextDouble() - 0.5D) * 64.0D;
    double d1 = par3EntityLivingBase.posY + (double)(par3EntityLivingBase.rand.nextInt(64) - 32);
    double d2 = par3EntityLivingBase.posZ + (par3EntityLivingBase.rand.nextDouble() - 0.5D) * 64.0D;
	*/
	
	par2EntityLivingBase.setPositionAndRotation(par3EntityLivingBase.posX + 5, par3EntityLivingBase.posY + 5, par3EntityLivingBase.posZ + 5, 90, 45);
	par1ItemStack.damageItem(1, par3EntityLivingBase);
    return true;
}

public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
{
    return true;
}

}
