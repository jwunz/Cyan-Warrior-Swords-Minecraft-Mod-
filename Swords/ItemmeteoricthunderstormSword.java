package com.cyanwarriorswords.cyanwarriorswordsmod.Swords;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemmeteoricthunderstormSword extends ItemSword{

	public ItemmeteoricthunderstormSword(int par1, ToolMaterial par2EnumToolMaterial) {
		super(par2EnumToolMaterial);
		this.setMaxDamage(3000);
		this.setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{  
	        this.itemIcon = ir.registerIcon("CyanWarriorSwords:MeteoricThunderStormSword");
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
    return 250000;
}
public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
{
    return 1.5F;
}
public int getDamageVsEntity(Entity par1Entity)
{
    return 9;
}
public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
{
    return true;
}
public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entity){
float var4 = 1.0F;
int i = (int)(entity.prevPosX + (entity.posX - entity.prevPosX) * (double)var4);
int j = (int)(entity.prevPosY + (entity.posY - entity.prevPosY) * (double)var4 + 1.62D - (double)entity.yOffset);
int k = (int)(entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)var4);

entity.addPotionEffect(new PotionEffect(Potion.regeneration.id, 80, 3));

entity.fallDistance = 0.0F;
entity.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1200, 4));
entity.addPotionEffect(new PotionEffect(Potion.jump.id, 1200, 4));
entity.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 6000, 0));

world.spawnParticle("flame", (double)i+2, (double)j, (double)k, 1.0D, 0.0D, 0.0D);
world.spawnParticle("flame", (double)i-2, (double)j, (double)k, -1.0D, 0.0D, 0.0D);
world.spawnParticle("flame", (double)i, (double)j, (double)k+2, 0.0D, 0.0D, 1.0D);
world.spawnParticle("flame", (double)i, (double)j, (double)k-2, 0.0D, 0.0D, -1.0D);

entity.addVelocity(((double)(-MathHelper.sin(entity.rotationYaw * (float)Math.PI / 180.0F) * (float)j * 0.5F))/8F, 0.1D, ((double)(MathHelper.cos(entity.rotationYaw * (float)Math.PI / 180.0F) * (float)j * 0.5F))/8F);

world.spawnParticle("flame", (double)i-2, (double)j, (double)k, -1.0D, 0.0D, 0.0D);
world.spawnParticle("flame", (double)i-2, (double)j, (double)k, -1.0D, 1.0D, 0.0D);
world.spawnParticle("flame", (double)i-2, (double)j, (double)k, -1.0D, 2.0D, 0.0D);

entity.addPotionEffect(new PotionEffect(Potion.regeneration.id, 80, 3));

EntitySmallFireball fireball = new EntitySmallFireball(world, entity, 0, 0, 0);
fireball.setLocationAndAngles(entity.posX, entity.posY + entity.getEyeHeight(), entity.posZ, entity.rotationYaw, entity.rotationPitch);
fireball.posX -= (MathHelper.cos(fireball.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
fireball.posY -= 0.10000000149011612D;
fireball.posZ -= (MathHelper.sin(fireball.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
fireball.setPosition(fireball.posX, fireball.posY, fireball.posZ);
fireball.yOffset = 0.0F;
float var3 = 0.4F;
fireball.motionX = (-MathHelper.sin(fireball.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(fireball.rotationPitch / 180.0F * (float)Math.PI) * var3);
fireball.motionZ = (MathHelper.cos(fireball.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(fireball.rotationPitch / 180.0F * (float)Math.PI) * var3);
fireball.motionY = (-MathHelper.sin((fireball.rotationPitch) / 180.0F * (float)Math.PI) * var3);
fireball.posY = entity.posY + (entity.height / 2.0) + 0.5D;
world.spawnEntityInWorld(fireball);
world.spawnEntityInWorld(fireball);
world.spawnEntityInWorld(fireball);
world.spawnEntityInWorld(fireball);
world.spawnEntityInWorld(fireball);

entity.addPotionEffect(new PotionEffect(Potion.regeneration.id, 80, 3));

world.spawnParticle("flame", (double)i-2, (double)j, (double)k, -1.0D, 0.0D, 0.0D);
world.spawnParticle("flame", (double)i-2, (double)j, (double)k, -1.0D, 1.0D, 0.0D);
world.spawnParticle("flame", (double)i-2, (double)j, (double)k, -1.0D, 2.0D, 0.0D);

world.spawnEntityInWorld(new EntityLightningBolt(world, i+1, j, k-1));
world.spawnEntityInWorld(new EntityLightningBolt(world, i-3, j, k-1));

entity.addPotionEffect(new PotionEffect(Potion.regeneration.id, 80, 3));

entity.fallDistance = 0.0F;

EntityLargeFireball fireball2 = new EntityLargeFireball(world, entity, 0, 0, 0);
fireball2.setLocationAndAngles(entity.posX, entity.posY + entity.getEyeHeight(), entity.posZ, entity.rotationYaw, entity.rotationPitch);
fireball2.posX -= (MathHelper.cos(fireball2.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
fireball2.posY -= 0.10000000149011612D;
fireball2.posZ -= (MathHelper.sin(fireball2.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
fireball2.setPosition(fireball2.posX, fireball2.posY, fireball2.posZ);
fireball2.yOffset = 0.0F;
fireball2.motionX = (-MathHelper.sin(fireball2.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(fireball2.rotationPitch / 180.0F * (float)Math.PI) * var3);
fireball2.motionZ = (MathHelper.cos(fireball2.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(fireball2.rotationPitch / 180.0F * (float)Math.PI) * var3);
fireball2.motionY = (-MathHelper.sin((fireball2.rotationPitch) / 180.0F * (float)Math.PI) * var3);
fireball2.posY = entity.posY + (entity.height / 2.0) + 0.5D;
world.spawnEntityInWorld(fireball2);
world.spawnEntityInWorld(fireball2);
world.spawnEntityInWorld(fireball2);
world.spawnEntityInWorld(fireball2);
world.spawnEntityInWorld(fireball2);

entity.addPotionEffect(new PotionEffect(Potion.regeneration.id, 80, 3));

world.spawnParticle("flame", (double)i-2, (double)j, (double)k, -1.0D, 0.0D, 0.0D);
world.spawnParticle("flame", (double)i-2, (double)j, (double)k, -1.0D, 1.0D, 0.0D);
world.spawnParticle("flame", (double)i-2, (double)j, (double)k, -1.0D, 2.0D, 0.0D);

world.spawnEntityInWorld(new EntityLightningBolt(world, i+1, j, k-1));
world.spawnEntityInWorld(new EntityLightningBolt(world, i-3, j, k-1));
world.spawnEntityInWorld(new EntityLightningBolt(world, i+1, j, k-1));
world.spawnEntityInWorld(new EntityLightningBolt(world, i-3, j, k-1));

entity.addPotionEffect(new PotionEffect(Potion.regeneration.id, 80, 3));

entity.addPotionEffect(new PotionEffect(Potion.regeneration.id, 120, 3));

entity.fallDistance = 0.0F;

entity.addPotionEffect(new PotionEffect(Potion.regeneration.id, 80, 3));

itemstack.damageItem(75, entity);
return itemstack;
}
public void onCreated(ItemStack itemstack, World world, EntityPlayer entity){
float var4 = 1.0F;
int i = (int)(entity.prevPosX + (entity.posX - entity.prevPosX) * (double)var4);
int j = (int)(entity.prevPosY + (entity.posY - entity.prevPosY) * (double)var4 + 1.62D - (double)entity.yOffset);
int k = (int)(entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)var4);
world.playSoundEffect((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, "fire.ignite", 1.0F, 1.0F);
world.createExplosion((Entity)null, i, j+10, k, 1, true);
world.spawnEntityInWorld(new EntityLightningBolt(world, i, j+5, k));
}
public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return true;
    }	
public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
{
	float var4 = 1.0F;
	int i = (int)(par2EntityLivingBase.prevPosX + (par2EntityLivingBase.posX - par2EntityLivingBase.prevPosX) * (double)var4);
	int j = (int)(par2EntityLivingBase.prevPosY + (par2EntityLivingBase.posY - par2EntityLivingBase.prevPosY) * (double)var4 + 1.62D - (double)par2EntityLivingBase.yOffset);
	int k = (int)(par2EntityLivingBase.prevPosZ + (par2EntityLivingBase.posZ - par2EntityLivingBase.prevPosZ) * (double)var4);
	par1ItemStack.damageItem(1, par3EntityLivingBase);
	par2EntityLivingBase.addVelocity(((double)(-MathHelper.sin(par3EntityLivingBase.rotationYaw * (float)Math.PI / 180.0F) * (float)j * 0.5F))/8F, 0.1D, ((double)(MathHelper.cos(par3EntityLivingBase.rotationYaw * (float)Math.PI / 180.0F) * (float)j * 0.5F))/8F);
	par2EntityLivingBase.setFire(10);
    return true;
}
public double getMovementFactor()
    {
  return 4.0;
    }

}
