package scapecraft.item;

import net.minecraft.item.Item;

public enum ScapecraftArmorMaterial
{
	SANTA(50000, new int[]{3, 1, 1, 1}, 10),
	PHAT(500000, new int[]{3, 1, 1, 1}, 10),
	WPHAT(500000, new int[]{3, 1, 1, 1}, 10),
	YPHAT(500000, new int[]{3, 1, 1, 1}, 10),
	GPHAT(500000, new int[]{3, 1, 1, 1}, 10),
	RPHAT(500000, new int[]{3, 1, 1, 1}, 10),
	PPHAT(500000, new int[]{3, 1, 1, 1}, 10),
	STONE(50000000, new int[]{1, 3, 2, 1}, 50),
	WHITE(240, new int[]{3, 5, 3, 2}, 10, 10, 12D),
	AHRIM(10000, new int[]{3, 5, 3, 2}, 30, 70, 30D),
	AKRISAE(10000, new int[]{3, 5, 3, 2}, 30, 70, 30D),
	BANDOS(10000, new int[]{3, 5, 3, 2}, 10, 65, 20D),
	BLACK(300, new int[]{3, 5, 3, 2}, 10, 20, 16D),
	BLACKD(100, new int[]{3, 5, 3, 2}, 20, 25, 14D),
	BLACKG(5000, new int[]{3, 5, 3, 2}, 30, 15, 16D),
	CDRAGON(90, new int[]{3, 5, 3, 2}, 10, 10, 24D),
	DHAROK(10000, new int[]{3, 5, 3, 2}, 30, 70, 30D),
	DRAGON(5000, new int[]{3, 5, 3, 2}, 30, 60, 30D),
	NEIT(8000, new int[]{3, 5, 3, 2}, 30, 50, 40D),
	DRAGONL(50000, new int[]{3, 5, 3, 2}, 50, 60, 38D),
	GRANITE(1500, new int[]{3, 5, 3, 2}, 20, 55, 25D),
	GREEND(60, new int[]{3, 5, 3, 2}, 10, 40, 8D),
	GUTHAN(10000, new int[]{3, 5, 3, 2}, 30, 70, 30D),
	KARIL(10000, new int[]{3, 5, 3, 2}, 30, 70, 30D),
	BRONZE(160, new int[]{3, 5, 3, 2}, 10, 0, 6D),
	MITH(380, new int[]{3, 5, 3, 2}, 10, 30, 20D),
	ADDY(600, new int[]{3, 5, 3, 2}, 10, 40, 24D),
	RUNE(1000, new int[]{3, 5, 3, 2}, 10, 50, 30D),
	RUNEG(330, new int[]{3, 5, 3, 2}, 30, 50, 16D),
	TORAG(20000, new int[]{3, 5, 3, 2}, 30, 70, 30D),
	VERAC(10000, new int[]{3, 5, 3, 2}, 30, 70, 30D);

	private static final int[] maxDamageArray = new int[] {11, 16, 15, 13};
	private int maxDamageFactor;
	private int[] damageReductionAmountArray;
	private int enchantability;
	private int minLevel;
	private double healthBoost;

	public Item customCraftingMaterial = null;

	ScapecraftArmorMaterial(int maxDamageFactor, int[] damageReductionAmountArray, int enchantability)
	{
		this.maxDamageFactor = maxDamageFactor;
		this.damageReductionAmountArray = damageReductionAmountArray;
		this.enchantability = enchantability;
		this.minLevel = 0;
		this.healthBoost = 0D;
	}

	ScapecraftArmorMaterial(int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, int minLevel)
	{
		this.maxDamageFactor = maxDamageFactor;
		this.damageReductionAmountArray = damageReductionAmountArray;
		this.enchantability = enchantability;
		this.minLevel = minLevel;
		this.healthBoost = 0D;
	}

	ScapecraftArmorMaterial(int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, int minLevel, double healthBoost)
	{
		this.maxDamageFactor = maxDamageFactor;
		this.damageReductionAmountArray = damageReductionAmountArray;
		this.enchantability = enchantability;
		this.minLevel = minLevel;
		this.healthBoost = healthBoost;
	}

	/**
	 * Returns the durability for a armor slot of for this type.
	 */
	public int getDurability(int par1)
	{
		return maxDamageArray[par1] * this.maxDamageFactor;
	}

	/**
	 * Return the damage reduction (each 1 point is a half a shield on gui) of the piece index passed (0 = helmet, 1
	 * = plate, 2 = legs and 3 = boots)
	 */
	public int getDamageReductionAmount(int par1)
	{
		return this.damageReductionAmountArray[par1];
	}

	/**
	 * Return the enchantability factor of the material.
	 */
	public int getEnchantability()
	{
		return this.enchantability;
	}

	/**
	 * Return minimum combat level required to wear armor of this material
	 */
	public int getMinLevel()
	{
		return this.minLevel;
	}

	/**
	 * Return max health when full equipped with this armor
	 */
	public double getHealthBoost()
	{
		return this.healthBoost;
	}
}
