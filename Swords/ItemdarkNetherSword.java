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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemdarkNetherSword extends ItemSword{

	public ItemdarkNetherSword(int par1, ToolMaterial par2EnumToolMaterial) {
		super(par2EnumToolMaterial);
		this.setMaxDamage(1500);
		this.setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{  
	        this.itemIcon = ir.registerIcon("CyanWarriorSwords:DarkNetherSword");
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
	entity.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
float var4 = 1.0F;
int i = (int)(entity.prevPosX + (entity.posX - entity.prevPosX) * (double)var4);
int j = (int)(entity.prevPosY + (entity.posY - entity.prevPosY) * (double)var4 + 1.62D - (double)entity.yOffset);
int k = (int)(entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double)var4);
entity.addPotionEffect(new PotionEffect(Potion.blindness.id, 20, 1));

itemstack.damageItem(1, entity);

if (!world.isRemote)
{
Vec3 look = entity.getLookVec();
EntityWitherSkull fireball2 = new EntityWitherSkull(world, entity, 0, 3, 0);
fireball2.setPosition(entity.posX + look.xCoord, entity.posY + look.yCoord, entity.posZ + look.zCoord);
fireball2.accelerationX = look.xCoord;
fireball2.accelerationY = look.yCoord;
fireball2.accelerationZ = look.zCoord;
world.playSoundEffect((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, "mob.wither.idle", 1.0F, 1.0F);
world.spawnEntityInWorld(fireball2);
}

return itemstack;
}
public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
{
         par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.wither.id, 1200, 4));
		 par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.blindness.id, 2000, 4));
         par1ItemStack.damageItem(1, par3EntityLivingBase);
         return true;
}
public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
{
    return true;
}
}
