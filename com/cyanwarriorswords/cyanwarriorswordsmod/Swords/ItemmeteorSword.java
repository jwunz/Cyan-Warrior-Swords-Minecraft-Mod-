package com.cyanwarriorswords.cyanwarriorswordsmod.Swords;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemmeteorSword extends ItemSword{

	public ItemmeteorSword(int par1, ToolMaterial par2EnumToolMaterial) {
		super(par2EnumToolMaterial);
		this.setMaxDamage(1500);
		this.setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{  
	        this.itemIcon = ir.registerIcon("CyanWarriorSwords:MeteorSword");
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
    return 150000;
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

if (!world.isRemote)
{
Vec3 look = entity.getLookVec();
EntityLargeFireball fireball2 = new EntityLargeFireball(world, entity, 1, 1, 1);
fireball2.setPosition(entity.posX + look.xCoord * 5, entity.posY + look.yCoord * 5, entity.posZ + look.zCoord * 5);
fireball2.accelerationX = look.xCoord * 0.5;
fireball2.accelerationY = look.yCoord * 0.5;
fireball2.accelerationZ = look.zCoord * 0.5;
world.spawnEntityInWorld(fireball2);
}


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
        if (world.isAirBlock(x+1, y+1, z-1))
        {
            world.setBlock(x+1, y+1, z-1, Blocks.fire);
        }
        if (world.isAirBlock(x-3, y+1, z-1))
        {
            world.setBlock(x-3, y+1, z-1, Blocks.fire);
        }
        if (world.isAirBlock(x-1, y+1, z+1))
        {
            world.setBlock(x-1, y+1, z+1, Blocks.fire);
        }
        if (world.isAirBlock(x-1, y+1, z-3))
        {
            world.setBlock(x-1, y+1, z-3, Blocks.fire);
        }
    }  
    }

world.spawnParticle("flame", (double)i+2, (double)j, (double)k, 1.0D, 0.0D, 0.0D);
world.spawnParticle("flame", (double)i-2, (double)j, (double)k, -1.0D, 0.0D, 0.0D);
world.spawnParticle("flame", (double)i, (double)j, (double)k+2, 0.0D, 0.0D, 1.0D);
world.spawnParticle("flame", (double)i, (double)j, (double)k-2, 0.0D, 0.0D, -1.0D);
entity.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 6000, 0));



itemstack.damageItem(5, entity);

/*
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
*/

return itemstack;
}
public void onCreated(ItemStack itemstack, World world, EntityPlayer entity){
float var4 = 1.0F;
int i = (int)(entity.prevPosX + (entity.posX - entity.prevPosX) * (double)var4);
int j = (int)(entity.prevPosY + (entity.posY - entity.prevPosY) * (double)var4 + 1.62D - (double)entity.yOffset);
int k = (int)(entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)var4);

world.playSoundEffect((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, "fire.ignite", 1.0F, 1.0F);
itemstack.addEnchantment(Enchantment.fireAspect, 10);
world.createExplosion((Entity)null, i, j+10, k, 1, true);
}
public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
{
    return true;
}
public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
{
         par2EntityLivingBase.setFire(10);
         par1ItemStack.damageItem(1, par3EntityLivingBase);
         return true;
}
public class EnchantmentFireAspect extends Enchantment
{
    protected EnchantmentFireAspect(int par1, int par2)
    {
        super(par1, par2, EnumEnchantmentType.weapon);
        this.setName("fire");
    }

    /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    public int getMinEnchantability(int par1)
    {
        return 10 + 20 * (par1 - 1);
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
public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return true;
    }

}
