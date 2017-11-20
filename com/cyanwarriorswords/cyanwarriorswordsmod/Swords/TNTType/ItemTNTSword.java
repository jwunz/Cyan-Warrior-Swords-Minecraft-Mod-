package com.cyanwarriorswords.cyanwarriorswordsmod.Swords.TNTType;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSword;

public class ItemTNTSword extends ItemSword {

	public ItemTNTSword(int par1, ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		this.setMaxDamage(1000);
		this.setMaxStackSize(1);
		// TODO Auto-generated constructor stub
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{  
	        this.itemIcon = ir.registerIcon("CyanWarriorSwords:TNTSword");
	}
}
