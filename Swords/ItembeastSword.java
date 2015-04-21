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

public class ItembeastSword extends ItemSword{
	
	public ItembeastSword(int par1, ToolMaterial par2EnumToolMaterial) {
		super(par2EnumToolMaterial);
		this.setMaxDamage(2000);
		this.setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{  
	        this.itemIcon = ir.registerIcon("CyanWarriorSwords:BeastSword");
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
        return material != Material.plants && material != Material.vine && material != Material.coral && material != Material.leaves && material != Material.ice ? 1.0F : 1.5F;
    }
}
*/
public float getDamageVsEntity(Entity par1Entity)
{
    return 7.0F;
}
public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entity){
	{
	entity.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));

     float var4 = 1.0F;
     int i = (int)(entity.prevPosX + (entity.posX - entity.prevPosX) * var4);
     int j = (int)(entity.prevPosY + (entity.posY - entity.prevPosY) * var4 + 1.62D - entity.yOffset);
     int k = (int)(entity.prevPosZ + (entity.posZ - entity.prevPosZ) * var4);
     if (!world.isRemote)
     {
       Vec3 look = entity.getLookVec();
       EntityWolf fireball2 = new EntityWolf(world);
       fireball2.setPosition(entity.posX + look.xCoord * 5.0D, entity.posY + look.yCoord * 5.0D, entity.posZ + look.zCoord * 5.0D);
       fireball2.motionX = (look.xCoord * 0.15D);
       fireball2.motionY = (look.yCoord * 0.15D);
       fireball2.motionZ = (look.zCoord * 0.15D);
       world.spawnEntityInWorld(fireball2);
       fireball2.setTamed(true);
       fireball2.setAttackTarget((EntityLivingBase)null);
       fireball2.setHealth(20.0F);
       fireball2.func_152115_b(entity.getUniqueID().toString());
       
     }
    entity.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 300, 1));
  
    itemstack.damageItem(50, entity);
    return itemstack;
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