package com.cyanwarriorswords.cyanwarriorswordsmod.Items;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityBlaze;

public class EntityFrostBall extends EntityThrowable
{
	public double accelerationX;
	public double accelerationY;
	public double accelerationZ;

	public EntityFrostBall(World par1World)
    {
        super(par1World);
    }

    public EntityFrostBall(World par1World, EntityLiving par2EntityLiving)
    {
        super(par1World, par2EntityLiving);
    }

    public EntityFrostBall(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

    
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
        if (par1MovingObjectPosition.entityHit != null)
        {
            byte b0 = 3;

            if (par1MovingObjectPosition.entityHit instanceof EntityBlaze)
            {
                b0 = 5;
            }

            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), b0);
        }

        for (int i = 0; i < 8; ++i)
        {
            this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
}
