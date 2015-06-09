package com.cyanwarriorswords.cyanwarriorswordsmod.Swords.ThunderType;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemthunderZeusSword extends ItemSword{

	public ItemthunderZeusSword(int par1, ToolMaterial par2EnumToolMaterial) {
		super(par2EnumToolMaterial);
		this.setMaxDamage(2000);
		this.setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{  
	        this.itemIcon = ir.registerIcon("CyanWarriorSwords:ThunderZeusSword");
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
    return 6;
}
public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entity){
	entity.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
float var4 = 1.0F;
int i = (int)(entity.prevPosX + (entity.posX - entity.prevPosX) * (double)var4);
int j = (int)(entity.prevPosY + (entity.posY - entity.prevPosY) * (double)var4 + 1.62D - (double)entity.yOffset);
int k = (int)(entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)var4);

entity.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
float closest = Float.MAX_VALUE;
Entity thisOne=null;
for (int i1 = 0; i1 < world.loadedEntityList.size(); i1++)
{
if (((Entity)world.loadedEntityList.get(i1)).getDistanceToEntity(entity)<closest)
{
if (world.loadedEntityList.get(i1) instanceof EntityLiving) //if it is a mob...
{
closest = ((Entity)world.loadedEntityList.get(i1)).getDistanceToEntity(entity);
thisOne = ((Entity)world.loadedEntityList.get(i1));
}
}
}
if (thisOne!=null)
{
/*
entity.addVelocity(thisOne.posX - entity.posX, thisOne.posY - entity.posY, thisOne.posZ - entity.posZ);
*/
entity.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1200, 5));

if(thisOne.posX < entity.posX){
if((thisOne.posX - entity.posX <= 8)){

if((thisOne.posZ < entity.posZ) && (thisOne.posX - entity.posX <= 8)){
	world.spawnEntityInWorld(new EntityLightningBolt(world, thisOne.posX, thisOne.posY, thisOne.posZ));
	}
if((thisOne.posZ > entity.posZ) && (entity.posZ - thisOne.posZ >= -8)){
	world.spawnEntityInWorld(new EntityLightningBolt(world, thisOne.posX, thisOne.posY, thisOne.posZ));
	}

}
}
if(thisOne.posX > entity.posX){
if((entity.posX - thisOne.posX >= -8)){

if((thisOne.posZ < entity.posZ) && (thisOne.posX - entity.posX <= 8)){
	world.spawnEntityInWorld(new EntityLightningBolt(world, thisOne.posX, thisOne.posY, thisOne.posZ));
}
if((thisOne.posZ > entity.posZ) && (entity.posZ - thisOne.posZ >= -8)){
	world.spawnEntityInWorld(new EntityLightningBolt(world, thisOne.posX, thisOne.posY, thisOne.posZ));
}

}
}

/*
if(thisOne.posY - entity.posY <= 4){
par2World.spawnParticle("explode", (double)entity.posX, (double)entity.posY, (double)entity.posZ, thisOne.posX - entity.posX, thisOne.posY - entity.posY, thisOne.posZ - entity.posZ);
thisOne.addVelocity(0, thisOne.posY - entity.posY -4, 0);
}
*/
}

entity.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 60, 0));

world.spawnEntityInWorld(new EntityLightningBolt(world, i+1, j, k-1));
world.spawnEntityInWorld(new EntityLightningBolt(world, i-3, j, k-1));
world.spawnEntityInWorld(new EntityLightningBolt(world, i-1, j, k+1));
world.spawnEntityInWorld(new EntityLightningBolt(world, i-1, j, k-3));
entity.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1200, 5));

if (!world.isRemote)
{
Vec3 look = entity.getLookVec();
EntityLightningBolt fireball2 = new EntityLightningBolt(world, i+1, j, k+1);
fireball2.setPosition(entity.posX + look.xCoord * 5, entity.posY + look.yCoord * 5, entity.posZ + look.zCoord * 5);
fireball2.motionX = look.xCoord * 0.5;
fireball2.motionY = look.yCoord * 0.5;
fireball2.motionZ = look.zCoord * 0.5;
world.spawnEntityInWorld(fireball2);
}

itemstack.damageItem(50, entity);
return itemstack;
}
public ItemStack onItemUse(ItemStack itemstack, World world, EntityPlayer entity){
float var4 = 1.0F;
int i = (int)(entity.prevPosX + (entity.posX - entity.prevPosX) * (double)var4);
int j = (int)(entity.prevPosY + (entity.posY - entity.prevPosY) * (double)var4 + 1.62D - (double)entity.yOffset);
int k = (int)(entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)var4);
world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k+2));
return itemstack;
}
public void onCreated(ItemStack itemstack, World world, EntityPlayer entity){
float var4 = 1.0F;
int i = (int)(entity.prevPosX + (entity.posX - entity.prevPosX) * (double)var4);
int j = (int)(entity.prevPosY + (entity.posY - entity.prevPosY) * (double)var4 + 1.62D - (double)entity.yOffset);
int k = (int)(entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)var4);

world.playSoundEffect((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, "ambient.weather.thunder", 1.0F, 1.0F);
}
public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
{
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
