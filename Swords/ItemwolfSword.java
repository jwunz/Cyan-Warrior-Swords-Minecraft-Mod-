package com.cyanwarriorswords.cyanwarriorswordsmod.Swords;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemwolfSword extends ItemSword{
	
	public ItemwolfSword(int par1, ToolMaterial par2EnumToolMaterial) {
		super(par2EnumToolMaterial);
		this.setMaxDamage(2000);
		this.setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{  
	        this.itemIcon = ir.registerIcon("CyanWarriorSwords:WolfSword");
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
        Material material = par2Block.blockMaterial;
        return material != Material.plants && material != Material.vine && material != Material.coral && material != Material.leaves && material != Material.pumpkin ? 1.0F : 1.5F;
    }
}
*/
public float getDamageVsEntity(Entity par1Entity)
{
    return 7.0F;
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

float var4 = 1.0F;
int a = (int)(par3EntityPlayer.prevPosX + (par3EntityPlayer.posX - par3EntityPlayer.prevPosX) * (double)var4);
int b = (int)(par3EntityPlayer.prevPosY + (par3EntityPlayer.posY - par3EntityPlayer.prevPosY) * (double)var4 + 1.62D - (double)par3EntityPlayer.yOffset);
int c = (int)(par3EntityPlayer.prevPosZ + (par3EntityPlayer.posZ - par3EntityPlayer.prevPosZ) * (double)var4);

if (thisOne!=null)
{

	if (!par2World.isRemote)
	{
	Vec3 look = par3EntityPlayer.getLookVec();
	EntityWolf fireball2 = new EntityWolf(par2World);
	fireball2.setPosition(a, b, c);
	fireball2.motionX = look.xCoord * 0.15;
	fireball2.motionY = look.yCoord * 0.15;
	fireball2.motionZ = look.zCoord * 0.15;
	par2World.spawnEntityInWorld(fireball2);
	fireball2.setTamed(true);
	fireball2.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 200, 2));
	fireball2.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 200, 2));
	fireball2.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 200, 2));
	
	}


	par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 900, 3));

	par1ItemStack.damageItem(50, par3EntityPlayer);
}
}
par1ItemStack.damageItem(15, par3EntityPlayer);

return par1ItemStack;
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

world.playSoundEffect((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, "wolf.howl1", 1.0F, 1.0F);

}
public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
{
	par1ItemStack.damageItem(1, par3EntityLivingBase);
	if (par2EntityLivingBase.isSwingInProgress) {
		par2EntityLivingBase.mountEntity(par3EntityLivingBase);
	}
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