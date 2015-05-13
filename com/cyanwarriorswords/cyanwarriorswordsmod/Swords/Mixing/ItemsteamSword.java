package com.cyanwarriorswords.cyanwarriorswordsmod.Swords.Mixing;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemsteamSword extends ItemSword{

	public ItemsteamSword(int par1, ToolMaterial par2EnumToolMaterial) {
		super(par2EnumToolMaterial);
		this.setMaxDamage(2000);
		this.setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{  
	        this.itemIcon = ir.registerIcon("CyanWarriorSwords:SteamSword");
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
    return 200000;
}
/*
public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
{
    if (par2Block.blockID == Block.web.blockID)
    {
        return 15.0F;
    }
    else
    {
        Material material = par2Block.getMaterial();
        return material != Material.plants && material != Material.vine && material != Material.coral && material != Material.leaves && material != Material.sponge ? 1.0F : 1.5F;
    }
}
*/
public float getDamageVsEntity(Entity par1Entity)
{
    return 7.0F;
}
public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer){
	
{
	par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
float closest = Float.MAX_VALUE;
Entity thisOne=null;
for (int i = 0; i < par2World.loadedEntityList.size(); i++)
{
if (((Entity)par2World.loadedEntityList.get(i)).getDistanceToEntity(par3EntityPlayer)<closest)
{
if (par2World.loadedEntityList.get(i) instanceof EntityLiving) //if it is a mob...
{
closest = ((Entity)par2World.loadedEntityList.get(i)).getDistanceToEntity(par3EntityPlayer);
thisOne = ((Entity)par2World.loadedEntityList.get(i));
}
}
}
if (thisOne!=null)
{
	/*
	par3EntityPlayer.addVelocity(thisOne.posX - par3EntityPlayer.posX, thisOne.posY - par3EntityPlayer.posY, thisOne.posZ - par3EntityPlayer.posZ);
	*/
	
	par2World.spawnParticle("explode", (double)par3EntityPlayer.posX +1, (double)par3EntityPlayer.posY, (double)par3EntityPlayer.posZ, 0, 0.5, 0);
	par2World.spawnParticle("explode", (double)par3EntityPlayer.posX -1, (double)par3EntityPlayer.posY, (double)par3EntityPlayer.posZ, 0, 0.5, 0);
	par2World.spawnParticle("explode", (double)par3EntityPlayer.posX, (double)par3EntityPlayer.posY +1, (double)par3EntityPlayer.posZ, 0, 0.5, 0);
	par2World.spawnParticle("explode", (double)par3EntityPlayer.posX, (double)par3EntityPlayer.posY -1, (double)par3EntityPlayer.posZ, 0, 0.5, 0);

if(thisOne.posX < par3EntityPlayer.posX){
if((thisOne.posX - par3EntityPlayer.posX <= 4)){
	par2World.spawnParticle("explode", (double)thisOne.posX, (double)thisOne.posY, (double)thisOne.posZ, 0, 1, 0);

	if((thisOne.posZ < par3EntityPlayer.posZ) && (thisOne.posX - par3EntityPlayer.posX <= 4) && (thisOne.posY - par3EntityPlayer.posY <= 3)){
		thisOne.addVelocity(0, 1, 0);
		thisOne.fallDistance = 0.0F;
		}
	if((thisOne.posZ > par3EntityPlayer.posZ) && (par3EntityPlayer.posZ - thisOne.posZ >= -4) && (thisOne.posY - par3EntityPlayer.posY <= 3)){
		thisOne.addVelocity(0, 1, 0);
		thisOne.fallDistance = 0.0F;
		}

}
}
if(thisOne.posX > par3EntityPlayer.posX){
if((par3EntityPlayer.posX - thisOne.posX >= -4)){
	par2World.spawnParticle("explode", (double)thisOne.posX, (double)thisOne.posY, (double)thisOne.posZ, 0, 1, 0);

if((thisOne.posZ < par3EntityPlayer.posZ) && (thisOne.posX - par3EntityPlayer.posX <= 4) && (thisOne.posY - par3EntityPlayer.posY <= 3)){
	thisOne.addVelocity(0, 1, 0);
	thisOne.fallDistance = 0.0F;
	}
if((thisOne.posZ > par3EntityPlayer.posZ) && (par3EntityPlayer.posZ - thisOne.posZ >= -4) && (thisOne.posY - par3EntityPlayer.posY <= 3)){
	thisOne.addVelocity(0, 1, 0);
	thisOne.fallDistance = 0.0F;
	}
}
}
}
par1ItemStack.damageItem(3, par3EntityPlayer);

return par1ItemStack;
}
}
public ItemStack onItemUse(ItemStack itemstack, World world, EntityPlayer entity){
float var4 = 1.0F;
int i = (int)(entity.prevPosX + (entity.posX - entity.prevPosX) * (double)var4);
int j = (int)(entity.prevPosY + (entity.posY - entity.prevPosY) * (double)var4 + 1.62D - (double)entity.yOffset);
int k = (int)(entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)var4);
return itemstack;
}
public void onCreated(ItemStack itemstack, World world, EntityPlayer entity){
float var4 = 1.0F;
int i = (int)(entity.prevPosX + (entity.posX - entity.prevPosX) * (double)var4);
int j = (int)(entity.prevPosY + (entity.posY - entity.prevPosY) * (double)var4 + 1.62D - (double)entity.yOffset);
int k = (int)(entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)var4);

}
public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
{
	par2EntityLivingBase.setFire(5);
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