package com.cyanwarriorswords.cyanwarriorswordsmod.Swords;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;



public class ItemiceSword extends ItemSword{

	public ItemiceSword(int par1, ToolMaterial par2EnumToolMaterial) {
		super(par2EnumToolMaterial);
		this.setMaxDamage(1500);
		this.setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{  
	        this.itemIcon = ir.registerIcon("CyanWarriorSwords:IceSword");
	}
	        
	public boolean isFull3D()
    {
        return true;
    }
public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.block;
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

MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, entity, true);

if (movingobjectposition == null)
{
    return itemstack;
}
else
{
    if (movingobjectposition.typeOfHit == MovingObjectPosition
            .MovingObjectType.BLOCK)
    {
        int x = movingobjectposition.blockX;
        int y = movingobjectposition.blockY;
        int z = movingobjectposition.blockZ;

        if (!world.canMineBlock(entity, x, y, z))
        {
            return itemstack;
        }

        if (!entity.canPlayerEdit(x, y, z, movingobjectposition.sideHit, itemstack))
        {
            return itemstack;
        }

        if (world.isAirBlock(x+1, y+2, z-1))
        {
            world.setBlock(x+1, y+2, z-1, Blocks.ice);
        }
        if (world.isAirBlock(x-3, y+2, z-1))
        {
           world.setBlock(x-3, y+2, z-1, Blocks.ice); 
        }
        if (world.isAirBlock(x-1, y+2, z+1))
        {
            world.setBlock(x-1, y+2, z+1, Blocks.ice);
        }
        if (world.isAirBlock(x-1, y+2, z-3))
        {
            world.setBlock(x-1, y+2, z-3, Blocks.ice);
        }
        if (world.isAirBlock(x+1, y+1, z-1))
        {
            world.setBlock(x+1, y+1, z-1, Blocks.ice);
        }
        if (world.isAirBlock(x-3, y+1, z-1))
        {
            world.setBlock(x-3, y+1, z-1, Blocks.ice);
        }
        if (world.isAirBlock(x-1, y+1, z+1))
        {
            world.setBlock(x-1, y+1, z+1, Blocks.ice);
        }
        if (world.isAirBlock(x-1, y+1, z-3))
        {
            world.setBlock(x-1, y+1, z-3, Blocks.ice);
        }
        if (world.isAirBlock(x-1, y+1, z-1))
        {
        	world.setBlock(x-1, y+1, z-1, Blocks.snow);
        }
        if (world.isAirBlock(x-1, y+2, z-1))
        {
            world.setBlock(x-1, y+2, z-1, Blocks.snow);
        }
        if (world.isAirBlock(x-1, y+3, z-1))
        {
        	world.setBlock(x-1, y+3, z-1, Blocks.pumpkin);
        }
    }    
    }

itemstack.damageItem(20, entity);

return itemstack;
}
/*
public void onUpdate(ItemStack par1ItemStack, World par2World, EntityPlayer par3Entity, int par4, boolean par5) {
	
	int i = MathHelper.floor_double(par3Entity.posX);
    int j = MathHelper.floor_double(par3Entity.posZ);
	
	for (i = 0; i < 4; ++i)
    {
        j = MathHelper.floor_double(par3Entity.posX + (double)((float)(i % 2 * 2 - 1) * 0.25F));
        int k = MathHelper.floor_double(par3Entity.posY);
        int l = MathHelper.floor_double(par3Entity.posZ + (double)((float)(i / 2 % 2 * 2 - 1) * 0.25F));

        if (par3Entity.worldObj.getBlockId(j, k, l) == 0 && par3Entity.worldObj.getBiomeGenForCoords(j, l).getFloatTemperature() < 0.8F && Block.snow.canPlaceBlockAt(par3Entity.worldObj, j, k, l))
        {
        	par3Entity.worldObj.setBlock(j, k, l, Block.snow.blockID);
        }
    }
}
*/

public void onCreated(ItemStack itemstack, World world, EntityPlayer entity){
float var4 = 1.0F;
int i = (int)(entity.prevPosX + (entity.posX - entity.prevPosX) * (double)var4);
int j = (int)(entity.prevPosY + (entity.posY - entity.prevPosY) * (double)var4 + 1.62D - (double)entity.yOffset);
int k = (int)(entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)var4);
}
public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
{
	
	par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1200, 4));
	if (par2EntityLivingBase.isPotionActive(Potion.moveSlowdown))
    {
		par2EntityLivingBase.isEntityInsideOpaqueBlock();
		par2EntityLivingBase.attackTime = 1200;
		par2EntityLivingBase.hurtTime = 1200;
		par2EntityLivingBase.isInsideOfMaterial(Material.web);
		ForgeHooks.onLivingSetAttackTarget(par2EntityLivingBase, null);
		
    }
	
	par1ItemStack.damageItem(1, par3EntityLivingBase);
    return true;
}

public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
{
    return true;
}
public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return true;
    }
}
