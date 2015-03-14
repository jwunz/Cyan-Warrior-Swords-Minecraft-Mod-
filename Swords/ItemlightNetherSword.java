package com.cyanwarriorswords.cyanwarriorswordsmod.Swords;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemlightNetherSword extends ItemSword{

	public ItemlightNetherSword(int par1, ToolMaterial par2EnumToolMaterial) {
		super(par2EnumToolMaterial);
		this.setMaxDamage(1500);
		this.setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{  
	        this.itemIcon = ir.registerIcon("CyanWarriorSwords:LightNetherSword");
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
	entity.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
float var4 = 1.0F;
int i = (int)(entity.prevPosX + (entity.posX - entity.prevPosX) * (double)var4);
int j = (int)(entity.prevPosY + (entity.posY - entity.prevPosY) * (double)var4 + 1.62D - (double)entity.yOffset);
int k = (int)(entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)var4);

entity.getBrightness(4);
itemstack.damageItem(5, entity);

world.spawnParticle("fireworksSpark", (double)i+2, (double)j, (double)k,  0, 10, 0);
world.spawnParticle("fireworksSpark", (double)i-2, (double)j, (double)k,  0, 10, 0);
world.spawnParticle("fireworksSpark", (double)i, (double)j, (double)k+2,  0, 10, 0);
world.spawnParticle("fireworksSpark", (double)i, (double)j, (double)k-2,  0, 10, 0);

entity.addPotionEffect(new PotionEffect(Potion.regeneration.id, 20, 0));
entity.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 600, 4));
if (entity.isPotionActive(Potion.wither)){
	entity.removePotionEffect(Potion.wither.id);
}
if (entity.isPotionActive(Potion.blindness)){
	entity.removePotionEffect(Potion.blindness.id);
}
/*
entity.getActivePotionEffect(new PotionHealthBoost (21, false, 16284963));


/*
if (!world.isRemote)
{
Vec3 look = entity.getLookVec();
EntityArrow fireball2 = new EntityArrow(world, 1, 1, 1);
fireball2.setLocationAndAngles();
fireball2.setPosition(i + look.xCoord * 5, j + look.yCoord * 5, k + look.zCoord * 5);
/*
fireball2.motionX = look.xCoord * 0.5;
fireball2.motionY = look.yCoord * 0.5;
fireball2.motionZ = look.zCoord * 0.5;
fireball2.addVelocity((-(MathHelper.sin(entity.rotationYaw / 180.0F * (float)Math.PI) * 0.16F))*25, 0.0D, ((MathHelper.cos(entity.rotationYaw / 180.0F * (float)Math.PI) * 0.16F))*25);
world.spawnEntityInWorld(fireball2);
*/

return itemstack;
}
public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
{
	if (par2EntityLivingBase.isPotionActive(Potion.invisibility)){
		par2EntityLivingBase.removePotionEffect(Potion.invisibility.id);
	}     
	par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.weakness.id, 1200, 4));
		 par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.blindness.id, 2000, 4));
		 par1ItemStack.damageItem(1, par3EntityLivingBase);
         return true;
}
public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
{
    return true;
}

}
