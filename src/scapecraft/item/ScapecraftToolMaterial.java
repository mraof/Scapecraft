package scapecraft.item;

import net.minecraft.item.Item;

public enum ScapecraftToolMaterial
{

	BRONZE(1, 500, 5.5F, 2.0F, 10),
	MITH(2, 1400, 6.5F, 3.0F, 10, 30),
	ADDY(2, 1700, 7.5F, 4.0F, 10, 40),
	RUNE(3, 2000, 10.5F, 5.0F, 10, 50),
	DRAGONG(3, 500, 100.0F, 8.0F, 30, 70),
	KORASIS(3, 100, 5.0F, 9.0F, 10, 15),
	DRAGON(3, 2500, 15.0F, 6.0F, 30, 60),
	DRAGONC(3, 250, 15.0F, 8.0F, 30),	 
	BLACK(2, 1000, 6.0F, 2.0F, 15, 20),
	BLACKH(2, 1500, 6.0F, 3.0F, 15, 20),
	AGS(3, 30000, 15.0F, 17.0F, 30, 75),
	BGS(3, 30000, 15.0F, 15.0F, 30, 75),
	SGS(3, 30000, 15.0F, 15.0F, 30, 75),
	ZGS(3, 30000, 15.0F, 15.0F, 30, 75),
	SS(3, 30000, 15.0F, 11.0F, 30, 70),
	CHICKEN(3, 15000000, 15.0F, -4.0F, 100),
	KERIS(3, 15000000, 15.0F, 7.0F, 40, 15),
	STAKE(3, 150, 15.0F, 1.0F, 40),
	PITCHFORK(1, 5000, 3.0F, 1.0F, 100),
	CHAOTIC(3, 30000, 15.0F, 15.0F, 30, 80),
	DRAGOND(3, 2500, 15.0F, 4.0F, 30, 60),
	DRAGONDS(3, 2500, 15.0F, 4.0F, 30, 60),
	DRAGONB(3, 2500, 15.0F, 9.0F, 30, 60),
	DRAGONS(3, 2500, 15.0F, 8.0F, 30, 60),
	WHIP(3, 30000, 15.0F, 10.0F, 30, 70),
	FREM(3, 1000, 15.0F, 8.0F, 5, 25),
	FREMF(3, 30000, 15.0F, 13.0F, 5, 25),
	VESTA(3, 100, 15.0F, 13.0F, 1),
	AGILITY(3, 500, 15.0F, 5.0F, 10),
	DRYGORE(3, 30000, 15.0F, 13.0F, 15, 90),
	IRON(2, 700, 5.5F, 2.0F, 10, 10),
	TORAG(3, 10000, 15.0F, 12.0F, 8, 70),
	VERAC(3, 10000, 15.0F, 8.0F, 8, 70),
	GUTHAN(3, 10000, 15.0F, 9.0F, 8, 70),
	DHAROK(3, 10000, 15.0F, 10.0F, 8, 70),
	AHRIM(3, 10000, 15.0F, 9.0F, 8, 70),
	AKRISAE(3, 10000, 15.0F, 10.0F, 8, 70);
	private int harvestLevel;
	private int maxUses;
	private float efficiencyOnProperMaterial;
	private float damageVsEntity;
	private int enchantability;
	private int minLevel;

	public Item customCraftingMaterial = null;

	ScapecraftToolMaterial(int harvestLevel, int maxUses, float effieciencyOnProperMaterial, float damageVsEntity, int enchantability)
	{
		this.harvestLevel = harvestLevel;
		this.maxUses = maxUses;
		this.efficiencyOnProperMaterial = effieciencyOnProperMaterial;
		this.damageVsEntity = damageVsEntity;
		this.enchantability = enchantability;
		this.minLevel = 0;
	}

	ScapecraftToolMaterial(int harvestLevel, int maxUses, float effieciencyOnProperMaterial, float damageVsEntity, int enchantability, int minLevel)
	{
		this.harvestLevel = harvestLevel;
		this.maxUses = maxUses;
		this.efficiencyOnProperMaterial = effieciencyOnProperMaterial;
		this.damageVsEntity = damageVsEntity;
		this.enchantability = enchantability;
		this.minLevel = minLevel;
	}

	public int getMaxUses()
	{
		return this.maxUses;
	}

	public float getEfficiencyOnProperMaterial()
	{
		return this.efficiencyOnProperMaterial;
	}

	public float getDamageVsEntity()
	{
		return this.damageVsEntity;
	}

	public int getHarvestLevel()
	{
		return this.harvestLevel;
	}

	public int getEnchantability()
	{
		return this.enchantability;
	}

	public int getMinLevel()
	{
		return minLevel;
	}

	public Item getBaseItemForRepair()
	{
		return customCraftingMaterial;
	}
}
