package scapecraft.entity;

import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import io.netty.buffer.ByteBuf;
import net.minecraft.command.IEntitySelector;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import scapecraft.economy.EconomyHandler;
import scapecraft.item.ItemWeapon;
import scapecraft.item.QualityItem;
import scapecraft.tileentity.TileEntityScapecraftMobSpawner;
import scapecraft.util.Stat;
import scapecraft.util.Stats;

import java.util.*;
import java.util.Map.Entry;

public abstract class EntityScapecraft extends EntityCreature implements XpDropper, IEntitySelector, IMob, IEntityAdditionalSpawnData
{
	protected HashMap<EntityPlayer, Float> attackers = new HashMap<EntityPlayer, Float>();
	protected HashMap<EntityPlayer, HashMap<Stat, Float>> statDamage = new HashMap<EntityPlayer, HashMap<Stat, Float>>();
	public Set<Class<? extends EntityLivingBase>> targetClasses = new HashSet<Class<? extends EntityLivingBase>>();
	public boolean passive = true;
	public MobSpawner mobSpawner = null;
	public boolean fromSpawner = false;
	public int mobSpawnerX;
	public int mobSpawnerY;
	public int mobSpawnerZ;
	protected int textureNum;
	protected boolean hero = false;

	public int level = 5;
	protected float defense = 0;
	public float healthBase = ScapecraftEntities.defaultStats[0];
	public float healthGrowth = ScapecraftEntities.defaultStats[1];
	public float attackBase = ScapecraftEntities.defaultStats[2];
	public float attackGrowth = ScapecraftEntities.defaultStats[3];
	public float defenseBase = ScapecraftEntities.defaultStats[4];
	public float defenseGrowth = ScapecraftEntities.defaultStats[5];
	public float xpBase = ScapecraftEntities.defaultStats[6];
	public float xpGrowth = ScapecraftEntities.defaultStats[7];
	public int minLevel = 1;
	public int maxLevel = 1;
	private ResourceLocation texture = new ResourceLocation("scapecraft", "missingTexture");
	protected float scale = 1;
	private float baseWidth = 0;
	private float baseHeight = 0;
	protected String heroPrefix = "Hero";

	public EntityScapecraft(World world)
	{
		super(world);
		this.addArmor();
		float[] stats = ScapecraftEntities.getMobStats(this.getClass());
		healthBase = stats[0];
		healthGrowth = stats[1];
		attackBase = stats[2];
		attackGrowth = stats[3];
		defenseBase = stats[4];
		defenseGrowth = stats[5];
		xpBase = stats[6];
		xpGrowth = stats[7];
		minLevel = ScapecraftEntities.getMobLevels(this.getClass())[0];
		maxLevel = ScapecraftEntities.getMobLevels(this.getClass())[1];
		this.setLevel(minLevel + rand.nextInt(maxLevel - minLevel + 1));
		this.setHealth(this.getMaxHealth());
		this.setTexture(-1);
	}

	public void setTexture(int textureNum)
	{
		if(ScapecraftEntities.hasTextures(this.getClass()))
		{
			Random textRand = new Random(this.getEntityId());
			if (textureNum < 0)
			{
				textureNum = textRand.nextInt(ScapecraftEntities.getTextureCount(this.getClass()));
			}
			this.texture = ScapecraftEntities.getTexture(this.getClass(), textureNum);
		}
		this.textureNum = textureNum;
	}
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.27D);
	}

	@Override
	public void giveXp()
	{
		int[] moneyDrops = this.mobSpawner == null ? ScapecraftEntities.getMoneyDrops(this.getClass()) : this.mobSpawner.getMoneyDrops(this);
		double money = moneyDrops != null && moneyDrops.length > 0 && rand.nextInt(10) == 0 ? moneyDrops[rand.nextInt(moneyDrops.length)] : 0;
		float damageTaken = 0;
		for(Float damage : attackers.values())
		{
			damageTaken += damage;
		}

		for(Entry<EntityPlayer, Float> entry : attackers.entrySet())
		{
			if(entry.getKey() != null)
			{
				for(Entry<Stat, Float> statDamageEntry : statDamage.get(entry.getKey()).entrySet())
				{
					Stats.addCombatXp(entry.getKey(), statDamageEntry.getKey(), (int) (statDamageEntry.getValue() / damageTaken * this.getXpValue())); //TODO split Xp between stats
				}
				if(money > 0)
				{
					EconomyHandler.deposit(entry.getKey().getUniqueID(), entry.getValue() / damageTaken * money);
				}
			}
		}
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		if(fromSpawner && mobSpawner == null)
		{
			TileEntity te;
			if ((((te = this.worldObj.getTileEntity(mobSpawnerX, mobSpawnerY, mobSpawnerZ))) instanceof TileEntityScapecraftMobSpawner))
			{
				((TileEntityScapecraftMobSpawner) te).addSpawned(this);
				if(((TileEntityScapecraftMobSpawner) te).maxSpawn <= ((TileEntityScapecraftMobSpawner) te).spawnedIds.size())
				{
					this.setDead();
				}
			}
		}
	}

	@Override
	protected void dropFewItems(boolean recentlyHit, int looting)
	{
		HashMap<EntityPlayer, Float> realAttackers = new HashMap<EntityPlayer, Float>(attackers);
		realAttackers.remove(null);
		ArrayList<Drop> drops = this.mobSpawner == null ? ScapecraftEntities.getDrops(this.getClass()) : this.mobSpawner.getDrops(this);
		if(!drops.isEmpty() && recentlyHit && !realAttackers.isEmpty())
		{
			int tries = 1 + rand.nextInt(realAttackers.size()) + (hero ? 1 : 0);
			for(int i = 0; i < tries; i++)
			{
				for (Drop drop : drops)
				{
					if(drop.chance > 0)
					{
						if (rand.nextInt(drop.chance) == 0)
						{
							ItemStack stack = drop.stack.copy();
							if (stack.getItem() instanceof QualityItem)
							{
								if (!stack.hasTagCompound())
								{
									stack.setTagCompound(new NBTTagCompound());
								}
								stack.getTagCompound().setString("source", "Dropped by " + this.getCommandSenderName());
								stack.getTagCompound().setInteger("level", this.getLevel());
							}
							entityDropItem(stack, 1);
						}
					}
				}
			}

			if(!capturedDrops.isEmpty())
			{
				if(!realAttackers.isEmpty())
				{
					float totalDamage = 0;
					for (float damage : realAttackers.values())
					{
						totalDamage += damage;
					}
					HashMap<EntityPlayer, EntityDrop> entityDropHashMap = new HashMap<EntityPlayer, EntityDrop>();
					while (!capturedDrops.isEmpty())
					{
						float offset = rand.nextFloat() * totalDamage;
						//System.out.println(capturedDrops.get(0) + " " + realAttackers + " " + entityDropHashMap);
						Iterator<Entry<EntityPlayer, Float>> it = realAttackers.entrySet().iterator();
						while (it.hasNext())
						{
							Entry<EntityPlayer, Float> entry = it.next();
							offset -= entry.getValue();
							if (offset <= 0 || !it.hasNext())
							{
								EntityDrop entityDrop = entityDropHashMap.containsKey(entry.getKey()) ? entityDropHashMap.get(entry.getKey()) : new EntityDrop(this.worldObj);
								entityDrop.addItem(capturedDrops.remove(0));
								entityDrop.owner = entry.getKey().getCommandSenderName();
								entityDropHashMap.put(entry.getKey(), entityDrop);
								break;
							}
						}
					}
					for (EntityDrop entityDrop : entityDropHashMap.values())
					{
						entityDrop.setPosition(this.posX, this.posY, this.posZ);
						this.worldObj.spawnEntityInWorld(entityDrop);
					}
					//System.out.println(entityDropHashMap);
				}
			}
		}
	}

	@Override
	protected void attackEntity(Entity entity, float f)
	{
		if (this.attackTime <= 0 && f < 2.0F && entity.boundingBox.maxY > this.boundingBox.minY && entity.boundingBox.minY < this.boundingBox.maxY)
		{
			this.attackTime = 20;
			this.attackEntityAsMob(entity);
		}
	}

	public float getAttackStrength(Entity entity)
	{
		//float damage = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
		float damage = attackBase + attackGrowth * level;

		if (entity instanceof EntityLivingBase)
		{
			damage += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase) entity);
		}

		return damage;
	}

	@Override
	public boolean attackEntityAsMob(Entity entity)
	{
		if(entity.attackEntityFrom(DamageSource.causeMobDamage(this), getAttackStrength(entity)))
		{
			if(entity instanceof EntityLivingBase)
			{
				int knockback = EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase) entity);
				if(knockback > 0)
				{
					entity.addVelocity((double)(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * (float)knockback* 0.5F), 0.1D, (double)(MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * (float)knockback* 0.5F));
					this.motionX *= 0.6D;
					this.motionZ *= 0.6D;
				}

				EnchantmentHelper.func_151384_a((EntityLivingBase) entity, this);
			}

			int fire = EnchantmentHelper.getFireAspectModifier(this) * 4;
			if(fire > 0)
			{
				entity.setFire(fire);
			}

			EnchantmentHelper.func_151385_b(this, entity);

			return true;
		}
		return false;
	}

	@Override
	protected void damageEntity(DamageSource source, float damage)
	{
		float oldHealth = this.getHealth();
		super.damageEntity(source, damage);
		if(this.getHealth() < oldHealth && !this.worldObj.isRemote)
		{
			EntityPlayer attacker = null;
			if(source.getEntity() instanceof EntityLivingBase)
			{
				if(source.getEntity() instanceof EntityPlayer && !((EntityPlayer) source.getEntity()).capabilities.isCreativeMode)
				{
					attacker = (EntityPlayer) source.getEntity();
				}
				if(attackers.get(attacker) == null)
				{
					attackers.put(attacker, oldHealth - this.getHealth());
				}
				else
				{
					attackers.put(attacker, attackers.get(attacker) + oldHealth - this.getHealth());
				}
				if(attacker != null)
				{
					HashMap<Stat, Float> damageMap = statDamage.containsKey(attacker) ? statDamage.get(attacker) : new HashMap<Stat, Float>();
					Stat stat = "arrow".equals(source.getDamageType()) ? Stat.RANGED : Stat.ATTACK;
					damageMap.put(stat, (damageMap.containsKey(stat) ? damageMap.get(stat) : 0) + oldHealth - this.getHealth());
					statDamage.put(attacker, damageMap);
				}
			}
		}
	}

	@Override
	public float applyArmorCalculations(DamageSource source, float damage)
	{
		if(!source.isUnblockable())
		{
			damage = (getDefense() > 0) ? ((getDefense() > (damage + 1)) ? (damage / getDefense()) : (damage - getDefense())) : damage;
		}
		return damage;
	}

	@Override
	public boolean isEntityApplicable(Entity entity)
	{
		return entity instanceof EntityPlayer && !passive || targetClasses.contains(entity.getClass());
	}

	@Override
	protected Entity findPlayerToAttack()
	{
		if(passive)
		{
			return null;
		}
		else
		{
			EntityPlayer player = null;
			double leastDistance = -1;
			double maxDistance = 16;
			for(int i = 0; i < this.worldObj.playerEntities.size(); i++)
			{
				EntityPlayer possiblePlayer = (EntityPlayer) this.worldObj.playerEntities.get(i);
				if(!possiblePlayer.capabilities.disableDamage && possiblePlayer.isEntityAlive())
				{
					double distance = possiblePlayer.getDistanceSq(this.posX, this.posY, this.posZ);
					if(distance <= maxDistance && (player == null || distance < leastDistance))
					{
						int playerLevel = Stats.getCombatLevel(possiblePlayer);
						double chance = maxDistance;
						if(possiblePlayer.isSneaking())
						{
							chance *= 0.8;
						}

						if(possiblePlayer.isInvisible())
						{
							float visibility = possiblePlayer.getArmorVisibility();
							if(visibility < 0.1F)
							{
								visibility = 0.1F;
							}

							chance *= visibility;
						}
						if((player == null || distance < chance * chance) && (this.level == 0 || this.level - playerLevel - this.level < 10))
						{
							player = possiblePlayer;
							leastDistance = distance;
						}
					}
				}
			}
			return player != null && this.canEntityBeSeen(player) ? player : null;
		}
	}

	/*
	 * Object instead of Class to avoid warnings because java is weird
	 */
	@SuppressWarnings("unchecked")
	public void addTargets(Object... entityClasses)
	{
		for(Object entityClass : entityClasses)
		{
			if(entityClass.equals(EntityPlayer.class))
			{
				passive = false;
			}
			else if(EntityLivingBase.class.isAssignableFrom((Class<?>) entityClass))
			{
				targetClasses.add((Class<? extends EntityLivingBase>) entityClass);
			}
		}
	}

	public void onSpawnerSpawn(ArrayList<String> args)
	{
		int index;
		if(maxLevel == 1)
		{
			maxLevel = 0;
		}
		for(int i = 1; i < args.size(); i++)
		{
			String arg = args.get(i);
			String value = "";
			index = args.get(i).indexOf('=');
			if(index != -1)
			{
				arg = args.get(i).substring(0, index);
				value = args.get(i).substring(index + 1);
			}
			parseSpawnArgument(arg, value);
		}

		if(this.hero)
		{
			this.setCustomNameTag(heroPrefix() + " " + this.getCommandSenderName());
		}
		if(maxLevel == 0)
		{
			maxLevel = minLevel;
			EntityPlayer player = worldObj.getClosestVulnerablePlayerToEntity(this, 80);
			if(player != null)
			{
				maxLevel = Stats.getCombatLevel(player);
			}
		}
		if(maxLevel < minLevel)
		{
			maxLevel = minLevel;
		}
		this.setLevel(minLevel + rand.nextInt(maxLevel - minLevel + 1));
		this.setHealth(this.getMaxHealth());
	}

	public void parseSpawnArgument(String arg, String value)
	{
		try
		{
			if ("level".equalsIgnoreCase(arg) && !hero)
			{
				try
				{
					if (value.contains("-"))
					{
						String[] levelRange = value.split("-");
						minLevel = Integer.parseInt(levelRange[0]);
						maxLevel = Integer.parseInt(levelRange[1]);
					}
					else
					{
						minLevel = maxLevel = Integer.parseInt(value);
					}
				}
				catch (NumberFormatException e)
				{
					minLevel = maxLevel = 0;
					System.out.println("Invalid value for level");
				}
			}
			else if ("passive".equalsIgnoreCase(arg))
			{
				this.passive = Boolean.valueOf(value);
			}
			else if ("healthBase".equalsIgnoreCase(arg))
			{
				this.healthBase = Float.parseFloat(value);
			}
			else if ("healthGrowth".equalsIgnoreCase(arg))
			{
				this.healthGrowth = Float.parseFloat(value);
			}
			else if ("attackBase".equalsIgnoreCase(arg))
			{
				this.attackBase = Float.parseFloat(value);
			}
			else if ("attackGrowth".equalsIgnoreCase(arg))
			{
				this.attackGrowth = Float.parseFloat(value);
			}
			else if ("defenseBase".equalsIgnoreCase(arg))
			{
				this.defenseBase = Float.parseFloat(value);
			}
			else if ("defenseGrowth".equalsIgnoreCase(arg))
			{
				this.defenseGrowth = Float.parseFloat(value);
			}
			else if ("xpBase".equalsIgnoreCase(arg))
			{
				this.xpBase = Float.parseFloat(value);
			}
			else if ("xpGrowth".equalsIgnoreCase(arg))
			{
				this.xpGrowth = Float.parseFloat(value);
			}
			else if ("nohero".equalsIgnoreCase(arg))
			{
				this.setHero(false);
			}
			else if ("name".equalsIgnoreCase(arg))
			{
				this.setCustomNameTag(value);
			}
			else if ("heroPrefix".equalsIgnoreCase(arg))
			{
				heroPrefix = value;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void setLevel(int level)
	{
		this.level = level;
		if (hero)
		{
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(healthBase + healthGrowth * level * 2);
			this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(attackBase + attackGrowth * level * 1.2);
			this.defense = this.defenseBase + this.defenseGrowth * level * 1.5f;
		}
		else
		{
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(healthBase + healthGrowth * level);
			this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(attackBase + attackGrowth * level);
			this.defense = this.defenseBase + this.defenseGrowth * level;
		}
	}

	public int getLevel()
	{
		return level;
	}

	public void addArmor()
	{
	}

	@Override
	public void addRandomArmor()
	{
		this.addArmor();
		for(int i = 0; i < equipmentDropChances.length; i++)
		{
			equipmentDropChances[i] = 0F;
		}
	}

	@Override
	public void setEquipmentDropChance(int slot, float chance)
	{
		equipmentDropChances[slot] = 0F;
	}

	@Override
	protected void dropEquipment(boolean b, int i)
	{
	}

	@Override
	public void setDead()
	{
		super.setDead();
		if(this.getHealth() <= 0)
		{
			if (mobSpawner != null && !worldObj.isRemote)
			{
				mobSpawner.onSpawnedDeath(this);
			}

			if (!worldObj.isRemote)
			{
				this.giveXp();
			}
		}
	}

	public int getXpValue() //getXpValue
	{
		return (int) (xpBase + (Math.pow(1.05, level) - 1 + level * 0.5) * xpGrowth);
	}
	@Override
	public int getExperiencePoints(EntityPlayer player)
	{
		return (int) Math.sqrt(this.getXpValue()) + 5;
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound tagCompound)
	{
		super.writeEntityToNBT(tagCompound);
		tagCompound.setInteger("level", level);
		if(fromSpawner)
		{
			tagCompound.setBoolean("fromSpawner", true);
			tagCompound.setInteger("spawnerX", mobSpawnerX);
			tagCompound.setInteger("spawnerY", mobSpawnerY);
			tagCompound.setInteger("spawnerZ", mobSpawnerZ);
		}
		tagCompound.setFloat("healthBase", healthBase);
		tagCompound.setFloat("healthGrowth", healthGrowth);
		tagCompound.setFloat("attackBase", attackBase);
		tagCompound.setFloat("attackGrowth", attackGrowth);
		tagCompound.setFloat("defenseBase", defenseBase);
		tagCompound.setFloat("defenseGrowth", defenseGrowth);
		tagCompound.setFloat("xpBase", xpBase);
		tagCompound.setFloat("xpGrowth", xpGrowth);
		tagCompound.setBoolean("hero", hero);
		tagCompound.setInteger("texture", textureNum);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound tagCompound)
	{
		super.readEntityFromNBT(tagCompound);
		level = tagCompound.getInteger("level");
		if(level < 1)
		{
			level = 1;
		}
		setLevel(level);
		if(tagCompound.getBoolean("fromSpawner"))
		{
			fromSpawner = true;
			this.mobSpawnerX = tagCompound.getInteger("spawnerX");
			this.mobSpawnerY = tagCompound.getInteger("spawnerY");
			this.mobSpawnerZ = tagCompound.getInteger("spawnerZ");
		}
		this.healthBase = tagCompound.getFloat("healthBase");
		this.healthGrowth = tagCompound.getFloat("healthGrowth");
		this.attackBase = tagCompound.getFloat("attackBase");
		this.attackGrowth = tagCompound.getFloat("attackGrowth");
		this.defenseBase = tagCompound.getFloat("defenseBase");
		this.defenseGrowth = tagCompound.getFloat("defenseGrowth");
		this.xpBase = tagCompound.getFloat("xpBase");
		this.xpGrowth = tagCompound.getFloat("xpGrowth");
		this.setHero(tagCompound.getBoolean("hero"));
		setTexture(tagCompound.getInteger("texture"));
	}

	@Override
	public void setWorld(World worldIn)
	{
		super.setWorld(worldIn);
		if(fromSpawner && worldObj != null && worldObj.getTileEntity(mobSpawnerX, mobSpawnerY, mobSpawnerZ) instanceof MobSpawner)
		{
			mobSpawner = (MobSpawner) worldObj.getTileEntity(mobSpawnerX, mobSpawnerY, mobSpawnerZ);
		}
	}

	@Override
	public final int getTotalArmorValue()
	{
		return 0;
	}

	public float getDefense()
	{
		return defense;
	}

	//Defense reduces knockback
	@Override
	public void knockBack(Entity attacker, float damage, double distanceX, double distanceZ)
	{
		if (this.rand.nextDouble() >= this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).getAttributeValue())
		{
			this.isAirBorne = true;
			float distance = MathHelper.sqrt_double(distanceX * distanceX + distanceZ * distanceZ);
			float power = 0.3F;
			if(getDefense() * 2f > damage)
			{
				power *= damage / getDefense() / 2f;
			}
			if(attacker instanceof EntityLivingBase)
			{
				EntityLivingBase entityLivingBase = (EntityLivingBase) attacker;
				if(entityLivingBase.getHeldItem() != null && entityLivingBase.getHeldItem().getItem() instanceof ItemWeapon)
				{
					power *= ((ItemWeapon) entityLivingBase.getHeldItem().getItem()).getAttackTime();
				}
			}
			this.motionX /= 2.0D;
			this.motionY /= 2.0D;
			this.motionZ /= 2.0D;
			this.motionX -= distanceX / (double)distance * (double)power;
			this.motionY += (double)power;
			this.motionZ -= distanceZ / (double)distance * (double)power;

			if (this.motionY > 0.4)
			{
				this.motionY = 0.4;
			}
		}
	}

	public ResourceLocation getTexture()
	{
		return texture;
	}

	@Override
	public boolean getAlwaysRenderNameTag()
	{
		return true;
	}

	@Override
	public void writeSpawnData(ByteBuf buf)
	{
		buf.writeInt(this.level);
		buf.writeInt(this.textureNum);
		buf.writeFloat(scale);
	}

	@Override
	public void readSpawnData(ByteBuf buf)
	{
		this.setLevel(buf.readInt());
		this.setTexture(buf.readInt());
		this.setScale(buf.readFloat());
	}

	public String heroPrefix()
	{
		return heroPrefix;
	}

	public void setHero(boolean hero)
	{
		if(hero != this.hero)
		{
			this.hero = hero;
			if(hero)
			{
				setScale(scale * 1.5f);
			}
			else
			{
				setScale(scale / 1.5f);
			}
		}
	}

	public boolean isHero()
	{
		return hero;
	}

	public void setScale(float scale)
	{
		this.scale = scale;
		if (this.baseWidth == 0)
		{
			this.baseWidth = this.width;
			this.baseHeight = this.height;
		}
		this.setSize(baseWidth * scale, baseHeight * scale);
	}

	public float getScale()
	{
		return scale;
	}

	public HashMap<EntityPlayer, Float> getRealAttackers()
	{
		HashMap<EntityPlayer, Float> realAttackers = new HashMap<EntityPlayer, Float>(attackers);
		realAttackers.remove(null);
		return realAttackers;
	}
}
