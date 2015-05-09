package scapecraft.item;

import net.minecraft.init.Items;
import net.minecraft.item.Item;

public enum ScapecraftBowMaterial
{
	KARIL(10000, -0.5F, 1, 8F, ScapecraftItems.boltRack),
	OAK(384, 0.6F, 1),
	WILLOW(384, 1.2F, 1),
	MAPLE(384, 1.8F, 1),
	YEW(384, 2.4F, 1),
	MAGIC(384, 3F, 1),
	CRYSTAL(4000, 3.6F, 1, 20F, null),
	DARK(10000, 4.2F, 1);

	int maxUses;
	float damage;
	int enchantability;
	float speed = 20F; //Ticks for bow to be fully pulled back
	Item ammo = Items.arrow; 

	ScapecraftBowMaterial(int maxUses, float damage, int enchantability)
	{
		this.maxUses = maxUses;
		this.damage = damage;
		this.enchantability = enchantability;
	}

	ScapecraftBowMaterial(int maxUses, float damage, int enchantability, float speed)
	{
		this.maxUses = maxUses;
		this.damage = damage;
		this.enchantability = enchantability;
		this.speed = speed;
	}

	ScapecraftBowMaterial(int maxUses, float damage, int enchantability, float speed, Item ammo)
	{
		this.maxUses = maxUses;
		this.damage = damage;
		this.enchantability = enchantability;
		this.speed = speed;
		this.ammo = ammo;
	}

	public int getMaxUses()
	{
		return maxUses;
	}

	public float getDamage()
	{
		return damage;
	}

	public int getEnchantability()
	{
		return enchantability;
	}

	public Item getAmmo()
	{
		return ammo;
	}

	public float getSpeed()
	{
		return speed;
	}
}
