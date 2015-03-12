package com.cyanwarriorswords.cyanwarriorswordsmod.Swords;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemtrienderSword extends ItemSword{

	public ItemtrienderSword(int par1, ToolMaterial par2EnumToolMaterial) {
		super(par2EnumToolMaterial);
		this.setMaxDamage(3000);
		this.setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{  
	        this.itemIcon = ir.registerIcon("CyanWarriorSwords:TriEnderSword");
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

if (!world.isRemote)
{
Vec3 look = entity.getLookVec();
EntityEnderPearl var8 = new EntityEnderPearl(world, entity);
entity.setPosition(entity.posX + look.xCoord * 5, entity.posY + look.yCoord * 5, entity.posZ + look.zCoord * 5);

        if (world.isAirBlock(i+1, j+1, k-1))
        {
            world.setBlock(i+1, j+1, k-1, Blocks.fire);
        }
        if (world.isAirBlock(i-3, j+1, k-1))
        {
            world.setBlock(i-3, j+1, k-1, Blocks.fire);
        }
        if (world.isAirBlock(i-1, j+1, k+1))
        {
            world.setBlock(i-1, j+1, k+1, Blocks.fire);
        }
        if (world.isAirBlock(i-1, j+1, k-3))
        {
            world.setBlock(i-1, j+1, k-3, Blocks.fire);
        }

world.spawnParticle("flame", (double)i+2, (double)j, (double)k, 1.0D, 0.0D, 0.0D);
world.spawnParticle("flame", (double)i-2, (double)j, (double)k, -1.0D, 0.0D, 0.0D);
world.spawnParticle("flame", (double)i, (double)j, (double)k+2, 0.0D, 0.0D, 1.0D);
world.spawnParticle("flame", (double)i, (double)j, (double)k-2, 0.0D, 0.0D, -1.0D);
entity.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 6000, 0));

entity.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1200, 5));

entity.addPotionEffect(new PotionEffect(Potion.jump.id, 1200, 4));

world.spawnEntityInWorld(var8);

world.spawnEntityInWorld(new EntityLightningBolt(world, i+1, j, k-1));
world.spawnEntityInWorld(new EntityLightningBolt(world, i-3, j, k-1));
world.spawnEntityInWorld(new EntityLightningBolt(world, i-1, j, k+1));
world.spawnEntityInWorld(new EntityLightningBolt(world, i-1, j, k-3));

entity.fallDistance = 0.0F;
}

entity.addPotionEffect(new PotionEffect(Potion.regeneration.id, 40, 3));

itemstack.damageItem(50, entity);

return itemstack;
}
public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
{
	par2EntityLivingBase.setFire(10);
	float var4 = 1.0F;
	int i = (int)(par2EntityLivingBase.prevPosX + (par2EntityLivingBase.posX - par2EntityLivingBase.prevPosX) * (double)var4);
	int j = (int)(par2EntityLivingBase.prevPosY + (par2EntityLivingBase.posY - par2EntityLivingBase.prevPosY) * (double)var4 + 1.62D - (double)par2EntityLivingBase.yOffset);
	int k = (int)(par2EntityLivingBase.prevPosZ + (par2EntityLivingBase.posZ - par2EntityLivingBase.prevPosZ) * (double)var4);
	par2EntityLivingBase.addVelocity(((double)(-MathHelper.sin(par3EntityLivingBase.rotationYaw * (float)Math.PI / 180.0F) * (float)j * 0.5F))/8F, 0.1D, ((double)(MathHelper.cos(par3EntityLivingBase.rotationYaw * (float)Math.PI / 180.0F) * (float)j * 0.5F))/8F);
	par1ItemStack.damageItem(1, par3EntityLivingBase);
    return true;
}
public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
{
    return true;
}

}
