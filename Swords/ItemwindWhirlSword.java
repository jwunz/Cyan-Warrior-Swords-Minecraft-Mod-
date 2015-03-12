package com.cyanwarriorswords.cyanwarriorswordsmod.Swords;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemwindWhirlSword extends ItemSword{

	public ItemwindWhirlSword(int par1, ToolMaterial par2EnumToolMaterial) {
		super(par2EnumToolMaterial);
		this.setMaxDamage(3000);
		this.setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{  
	        this.itemIcon = ir.registerIcon("CyanWarriorSwords:WindWhirlSword");
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
public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
{
    return 1.5F;
}
public int getDamageVsEntity(Entity par1Entity)
{
    return 6;
}
public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
{
    return true;
}

public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer){
	
{
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
	par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1200, 4));
	par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.jump.id, 1200, 4));
	
	par2World.spawnParticle("explode", (double)par3EntityPlayer.posX +1, (double)par3EntityPlayer.posY, (double)par3EntityPlayer.posZ, 0, 0.5, 0);
	par2World.spawnParticle("explode", (double)par3EntityPlayer.posX -1, (double)par3EntityPlayer.posY, (double)par3EntityPlayer.posZ, 0, 0.5, 0);
	par2World.spawnParticle("explode", (double)par3EntityPlayer.posX, (double)par3EntityPlayer.posY +1, (double)par3EntityPlayer.posZ, 0, 0.5, 0);
	par2World.spawnParticle("explode", (double)par3EntityPlayer.posX, (double)par3EntityPlayer.posY -1, (double)par3EntityPlayer.posZ, 0, 0.5, 0);

if(thisOne.posX < par3EntityPlayer.posX){
if((thisOne.posX - par3EntityPlayer.posX <= 4)){
	par2World.spawnParticle("explode", (double)par3EntityPlayer.posX, (double)par3EntityPlayer.posY, (double)par3EntityPlayer.posZ, thisOne.posX - par3EntityPlayer.posX, thisOne.posY - par3EntityPlayer.posY, thisOne.posZ - par3EntityPlayer.posZ);

	if((thisOne.posZ < par3EntityPlayer.posZ) && (thisOne.posX - par3EntityPlayer.posX <= 4)){
		thisOne.addVelocity(thisOne.posX - par3EntityPlayer.posX -4, 0, thisOne.posZ - par3EntityPlayer.posZ -4);
		}
	if((thisOne.posZ > par3EntityPlayer.posZ) && (par3EntityPlayer.posZ - thisOne.posZ >= -4)){
		thisOne.addVelocity(thisOne.posX - par3EntityPlayer.posX -4, 0, par3EntityPlayer.posX - thisOne.posX +4);
		}

}
}
if(thisOne.posX > par3EntityPlayer.posX){
if((par3EntityPlayer.posX - thisOne.posX >= -4)){
	par2World.spawnParticle("explode", (double)par3EntityPlayer.posX, (double)par3EntityPlayer.posY, (double)par3EntityPlayer.posZ, thisOne.posX - par3EntityPlayer.posX, thisOne.posY - par3EntityPlayer.posY, thisOne.posZ - par3EntityPlayer.posZ);

if((thisOne.posZ < par3EntityPlayer.posZ) && (thisOne.posX - par3EntityPlayer.posX <= 4)){
	thisOne.addVelocity(par3EntityPlayer.posX - thisOne.posX +4, 0, thisOne.posZ - par3EntityPlayer.posZ -4);
	}
if((thisOne.posZ > par3EntityPlayer.posZ) && (par3EntityPlayer.posZ - thisOne.posZ >= -4)){
	thisOne.addVelocity(par3EntityPlayer.posX - thisOne.posX +4, 0, par3EntityPlayer.posX - thisOne.posX +4);
	}

}
}

/*
if(thisOne.posY - par3EntityPlayer.posY <= 4){
	par2World.spawnParticle("explode", (double)par3EntityPlayer.posX, (double)par3EntityPlayer.posY, (double)par3EntityPlayer.posZ, thisOne.posX - par3EntityPlayer.posX, thisOne.posY - par3EntityPlayer.posY, thisOne.posZ - par3EntityPlayer.posZ);
thisOne.addVelocity(0, thisOne.posY - par3EntityPlayer.posY -4, 0);
}
*/
}

/*
{
float closest = Float.MAX_VALUE;
Entity thisOne=null;
for (int i = 0; i < par2World.loadedEntityList.size(); i++)
{
if (((Entity)par2World.loadedEntityList.get(i)).getDistanceToEntity(par3EntityPlayer)<closest)
{
if (par2World.loadedEntityList.get(i) instanceof EntityMob) //if it is a mob...
{
closest = ((Entity)par2World.loadedEntityList.get(i)).getDistanceToEntity(par3EntityPlayer);
thisOne = ((Entity)par2World.loadedEntityList.get(i));
}
}
}
if (thisOne!=null)
{
par2World.addWeatherEffect(new EntityLightningBolt(par2World,thisOne.posX,thisOne.posY, thisOne.posZ));
}
*/
par1ItemStack.damageItem(1, par3EntityPlayer);

return par1ItemStack;
}
}


public void onUsingItemTick(ItemStack stack, EntityPlayer player, int count, World par2World, float par4)
{
	
}

public void onCreated(ItemStack itemstack, World world, EntityPlayer entity){
float var4 = 1.0F;
int i = (int)(entity.prevPosX + (entity.posX - entity.prevPosX) * (double)var4);
int j = (int)(entity.prevPosY + (entity.posY - entity.prevPosY) * (double)var4 + 1.62D - (double)entity.yOffset);
int k = (int)(entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)var4);
itemstack.addEnchantment(Enchantment.knockback, 10);
}
public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
{
	float var4 = 1.0F;
	int i = (int)(par2EntityLivingBase.prevPosX + (par2EntityLivingBase.posX - par2EntityLivingBase.prevPosX) * (double)var4);
	int j = (int)(par2EntityLivingBase.prevPosY + (par2EntityLivingBase.posY - par2EntityLivingBase.prevPosY) * (double)var4 + 1.62D - (double)par2EntityLivingBase.yOffset);
	int k = (int)(par2EntityLivingBase.prevPosZ + (par2EntityLivingBase.posZ - par2EntityLivingBase.prevPosZ) * (double)var4);
	par1ItemStack.damageItem(1, par3EntityLivingBase);
	par2EntityLivingBase.addVelocity(((double)(-MathHelper.sin(par3EntityLivingBase.rotationYaw * (float)Math.PI / 180.0F) * (float)j * 0.5F))/8F, 0.1D, ((double)(MathHelper.cos(par3EntityLivingBase.rotationYaw * (float)Math.PI / 180.0F) * (float)j * 0.5F))/8F);
    return true;
}
public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return true;
    }	
	public class EnchantmentKnockback extends Enchantment
{
    protected EnchantmentKnockback(int par1, int par2)
    {
        super(par1, par2, EnumEnchantmentType.weapon);
        this.setName("knockback");
    }

    /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    public int getMinEnchantability(int par1)
    {
        return 5 + 20 * (par1 - 1);
    }

    /**
     * Returns the maximum value of enchantability nedded on the enchantment level passed.
     */
    public int getMaxEnchantability(int par1)
    {
        return super.getMinEnchantability(par1) + 50;
    }

    /**
     * Returns the maximum level that the enchantment can have.
     */
    public int getMaxLevel()
    {
        return 10;
    }
}
public double getMovementFactor()
    {
  return 4.0;
    }

}
