package com.cyanwarriorswords.cyanwarriorswordsmod.Swords;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemenderFireSword extends ItemSword{

	public ItemenderFireSword(int par1, ToolMaterial par2EnumToolMaterial) {
		super(par2EnumToolMaterial);
		this.setMaxDamage(1500);
		this.setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{  
	        this.itemIcon = ir.registerIcon("CyanWarriorSwords:EnderFireSword");
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
    return 6;
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

world.spawnEntityInWorld(var8);

entity.fallDistance = 0.0F;
}



itemstack.damageItem(35, entity);

return itemstack;
}
public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
{
	par2EntityLivingBase.setFire(10);
	par1ItemStack.damageItem(1, par3EntityLivingBase);
    return true;
}
public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
{
    return true;
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
}
