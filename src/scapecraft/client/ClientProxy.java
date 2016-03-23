package scapecraft.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.MinecraftForgeClient;
import org.lwjgl.opengl.GLContext;
import scapecraft.CommonProxy;
import scapecraft.client.gui.GuiHealth;
import scapecraft.client.model.*;
import scapecraft.client.model.armor.ModelDragonHelm;
import scapecraft.client.model.armor.ModelFullHelm;
import scapecraft.client.model.armor.ModelPlateskirt;
import scapecraft.client.model.weapon.*;
import scapecraft.client.renderer.entity.*;
import scapecraft.client.renderer.item.RenderItemObj;
import scapecraft.client.renderer.item.RenderItemSpawnEgg;
import scapecraft.client.renderer.item.RenderItemWeapon;
import scapecraft.client.renderer.tileentity.RenderAnvil;
import scapecraft.client.renderer.tileentity.RenderFire;
import scapecraft.client.renderer.tileentity.RenderPortal;
import scapecraft.client.renderer.tileentity.RenderStall;
import scapecraft.client.settings.ScapecraftKeyHandler;
import scapecraft.command.FileGuiCommand;
import scapecraft.command.WeaponModelCommand;
import scapecraft.entity.*;
import scapecraft.item.ItemArmorScapecraft;
import scapecraft.item.ScapecraftItems;
import scapecraft.tileentity.TileEntityFire;
import scapecraft.tileentity.TileEntityScapecraftPortal;
import scapecraft.tileentity.TileEntitySmithingAnvil;
import scapecraft.tileentity.TileEntityStall;

import java.io.File;
import java.util.HashSet;
import java.util.List;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
	private HashSet<String> pendingRefresh = new HashSet<String>();

	public static GuiHealth guiHealth = new GuiHealth();

	public DynamicResourcePack dynamicResourcePack = new DynamicResourcePack();

	@Override
	public void setCacheDir(File cacheDir)
	{
		super.setCacheDir(cacheDir);
		dynamicResourcePack.setCacheDir(cacheDir);
	}

	@Override
	public void registerRenderers()
	{
		ClientCommandHandler.instance.registerCommand(new WeaponModelCommand());
		ClientCommandHandler.instance.registerCommand(new FileGuiCommand());
		FMLCommonHandler.instance().bus().register(new ScapecraftKeyHandler());

		RenderBipedScapecraft standardBiped = new RenderBipedScapecraft();
		RenderingRegistry.registerEntityRenderingHandler(EntityBandit.class, new RenderBipedScapecraft().setScale(1.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBarbarian.class, standardBiped);
		RenderingRegistry.registerEntityRenderingHandler(EntityBlackGuard.class, standardBiped);
		RenderingRegistry.registerEntityRenderingHandler(EntityBlackKnight.class, standardBiped);
		RenderingRegistry.registerEntityRenderingHandler(EntityCook.class, standardBiped);
		RenderingRegistry.registerEntityRenderingHandler(EntityDarkwizard.class, standardBiped);
		RenderingRegistry.registerEntityRenderingHandler(EntityDoctor.class, standardBiped);
		RenderingRegistry.registerEntityRenderingHandler(EntityEliteBlackKnight.class, standardBiped);
		RenderingRegistry.registerEntityRenderingHandler(EntityFarmer.class, standardBiped);
		RenderingRegistry.registerEntityRenderingHandler(EntityFremGuard.class, standardBiped);
		RenderingRegistry.registerEntityRenderingHandler(EntityGuard.class, standardBiped);
		RenderingRegistry.registerEntityRenderingHandler(EntityHeroKnight.class, standardBiped);
		RenderingRegistry.registerEntityRenderingHandler(EntityHighMage.class, standardBiped);
		RenderingRegistry.registerEntityRenderingHandler(EntityKing.class, standardBiped);
		RenderingRegistry.registerEntityRenderingHandler(EntityKingsGuard.class, standardBiped);
		RenderingRegistry.registerEntityRenderingHandler(EntityKos1.class, standardBiped);
		RenderingRegistry.registerEntityRenderingHandler(EntityKos2.class, standardBiped);
		RenderingRegistry.registerEntityRenderingHandler(EntityKos3.class, standardBiped);
		RenderingRegistry.registerEntityRenderingHandler(EntityKos4.class, standardBiped);
		RenderingRegistry.registerEntityRenderingHandler(EntityMan.class, standardBiped);
		RenderingRegistry.registerEntityRenderingHandler(EntityMorgan.class, standardBiped);
		RenderingRegistry.registerEntityRenderingHandler(EntityMugger.class, standardBiped);
		RenderingRegistry.registerEntityRenderingHandler(EntityShopKeeper.class, standardBiped);
		RenderingRegistry.registerEntityRenderingHandler(EntityThief.class, standardBiped);
		RenderingRegistry.registerEntityRenderingHandler(EntityVampire.class, standardBiped);
		RenderingRegistry.registerEntityRenderingHandler(EntityVarze.class, standardBiped);
		RenderingRegistry.registerEntityRenderingHandler(EntityWhiteKnight.class, standardBiped);
		RenderingRegistry.registerEntityRenderingHandler(EntityWizard.class, standardBiped);
		RenderingRegistry.registerEntityRenderingHandler(EntityAbbyDemon.class, new RenderEntityScapecraft(new ModelAbbyDemon(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityAhrim.class, new RenderEntityScapecraft(new ModelAhrim(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityAkrisae.class, new RenderEntityScapecraft(new ModelAkrisae(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlackDemon.class, new RenderEntityScapecraft(new ModelBlackDemon(), 0.5F).setScale(2.1F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlackDragon.class, new RenderEntityScapecraft(new ModelGreenDragon(), 0.5F).setScale(2.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityCaveCrawler.class, new RenderEntityScapecraft(new ModelCaveCrawler(), 0.5F).setScale(1.4F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDharok.class, new RenderEntityScapecraft(new ModelDharok(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDwarf.class, new RenderEntityScapecraft(new ModelDwarf(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityFireGiant.class, new RenderEntityScapecraft(new ModelFireGiant(), 0.5F).setScale(1.4F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGeneralGraardor.class, new RenderEntityScapecraft(new ModelGeneralGraardor(), 0.5F).setScale(2.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGiantSpider.class, new RenderEntityScapecraft(new ModelSpider(), 1F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGhost.class, new RenderEntityScapecraft(new ModelGhost(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGoblin.class, new RenderEntityScapecraft(new ModelGoblin(), 0.5F).setScale(0.7F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGreenDragon.class, new RenderEntityScapecraft(new ModelGreenDragon(), 0.5F).setScale(2.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGuthan.class, new RenderEntityScapecraft(new ModelGuthan(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityHellhound.class, new RenderEntityScapecraft(new ModelHellhound(), 0.5F).setScale(1.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityHillGiant.class, new RenderEntityScapecraft(new ModelHillGiant(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityIceGiant.class, new RenderEntityScapecraft(new ModelIceGiant(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityIronDragon.class, new RenderEntityScapecraft(new ModelGreenDragon(), 0.5F).setScale(2.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityKK.class, new RenderEntityScapecraft(new ModelKK(), 0.5F).setScale(3.5F).setOffset(0F, .7F, 0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityKKspawn.class, new RenderEntityScapecraft(new ModelKKspawn(), 0.5F).setOffset(0F, .7F, 0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityKQ.class, new RenderEntityScapecraft(new ModelKQ(), 0.5F).setScale(3.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityKQ2.class, new RenderEntityScapecraft(new ModelKQ2(), 0.5F).setScale(0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityKaril.class, new RenderEntityScapecraft(new ModelKaril(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLavaBlock.class, new RenderEntityScapecraft(new ModelLavaBlock(), 0.5F).setScale(.2F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLesserDemonUgly.class, new RenderEntityScapecraft(new ModelLesserDemonUgly(), 0.5F).setScale(1.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLesserDemon.class, new RenderEntityScapecraft(new ModelLesserDemon2(), 0.5F).setScale(1.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLootChest.class, new RenderEntityScapecraft(new ModelLootChest(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMossGiant.class, new RenderEntityScapecraft(new ModelMossGiant(), 0.5F).setScale(1.4F));
		RenderingRegistry.registerEntityRenderingHandler(EntityRat.class, new RenderEntityScapecraft(new ModelRat(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityRatSmall.class, new RenderEntityScapecraft(new ModelRat(), 0.5F).setScale(0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityScorpion.class, new RenderEntityScapecraft(new ModelScorpion(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySergeantGrimspike.class, new RenderEntityScapecraft(new ModelSergeantGrimSpike(), 0.5F).setScale(0.8F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySergeantSteelwill.class, new RenderEntityScapecraft(new ModelSergeantSteelWill(), 0.5F).setScale(0.8F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySergeantStrongstack.class, new RenderEntityScapecraft(new ModelSergeantStrongStack(), 0.5F).setScale(0.8F));
		RenderingRegistry.registerEntityRenderingHandler(EntityTormentedDemon.class, new RenderEntityScapecraft(new ModelTD(), 0.5F).setScale(2.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityTorag.class, new RenderEntityScapecraft(new ModelTorag(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityVerac.class, new RenderEntityScapecraft(new ModelVerac(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityZilyana.class, new RenderEntityScapecraft(new ModelZilyana(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityZaklnGritch.class, new RenderEntityScapecraft(new ModelZaklnGritch(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityTstanonKarlak.class, new RenderEntityScapecraft(new ModelTstanonKarlak(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityKrilTsutsaroth.class, new RenderEntityScapecraft(new ModelKrilTsutsaroth(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBalfrugKreeyath.class, new RenderEntityScapecraft(new ModelBalfrugKreeyath(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityKreearra.class, new RenderEntityScapecraft(new ModelKreearra(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlueDragon.class, new RenderEntityScapecraft(new ModelBlueDragon(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityShapeshifter.class, new RenderShapeshifter());
		RenderingRegistry.registerEntityRenderingHandler(EntityGenericBiped.class, new RenderGenericBiped());
		RenderingRegistry.registerEntityRenderingHandler(EntityKey.class, new RenderKey());
		RenderingRegistry.registerEntityRenderingHandler(EntityDrop.class, new RenderEntityDrop());

		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.scapecraftSpawnEgg, new RenderItemSpawnEgg());
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.equipmentSets.get("bronzeHammer"), new RenderItemObj("Warhammer", "BronzeWarhammer"));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.equipmentSets.get("ironHammer"), new RenderItemObj("Warhammer", "IronWarhammer"));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.equipmentSets.get("steelHammer"), new RenderItemObj("Warhammer", "SteelWarhammer"));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.equipmentSets.get("whiteHammer"), new RenderItemObj("Warhammer", "WhiteWarhammer"));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.equipmentSets.get("blackHammer"), new RenderItemObj("Warhammer", "BlackWarhammer"));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.equipmentSets.get("mithrilHammer"), new RenderItemObj("Warhammer", "MithrilWarhammer"));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.equipmentSets.get("adamantHammer"), new RenderItemObj("Warhammer", "AdamantWarhammer"));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.equipmentSets.get("runeHammer"), new RenderItemObj("Warhammer", "RuneWarhammer"));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.equipmentSets.get("dragonHammer"), new RenderItemObj("Warhammer", "DragonWarhammer"));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.equipmentSets.get("dragonDagger"), new RenderItemWeapon(new ModelDD(), Resources.TEXTURE_DD, 1F, 220F).setOffset(0F, 0F, 0F));
		/*MinecraftForgeClient.registerItemRenderer(ScapecraftItems.ags, new RenderItemObj("ArmadylGodsword", "ArmadylGodsword"));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.bgs, new RenderItemWeapon(new ModelBGS(), Resources.TEXTURE_BGS, 0.55F, 220F).setOffset(0.9F, 0.5F, -0.1F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.sgs, new RenderItemWeapon(new ModelSGS(), Resources.TEXTURE_SGS, 0.55F, 220F).setOffset(0.9F, 0.5F, -0.1F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.zgs, new RenderItemWeapon(new ModelZGS(), Resources.TEXTURE_ZGS, 0.55F, 220F).setOffset(0.9F, 0.5F, -0.1F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.dragonBattleAxe, new RenderItemWeapon(new ModelDBA(), Resources.TEXTURE_DBA, 1.05F, 220F).setOffset(0F, 0F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.dds, new RenderItemWeapon(new ModelDD(), Resources.TEXTURE_DDS, 1F, 220F).setOffset(0F, 0F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.chaoticRapier, new RenderItemWeapon(new ModelRapier(), Resources.TEXTURE_RAPIER, 0.15F, 220F).setOffset(0F, 0F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.chaoticMaul, new RenderItemWeapon(new ModelChaoticMaul(), Resources.TEXTURE_CMAUL, 0.4F, 220F).setOffset(1.5F, 0.4F, -0.1F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.chaoticLongsword, new RenderItemWeapon(new ModelChaoticLongsword(), Resources.TEXTURE_CHAOTICLONGSWORD, 1F, 220F).setOffset(0.87F, 0.08F, -0.05F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.whip, new RenderItemWeapon(new ModelWhip(), Resources.TEXTURE_Whip, 1.15F, 220F).setOffset(0.5F, 0.3F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.saraSword, new RenderItemWeapon(new ModelSaraSword(), Resources.TEXTURE_SS, 1.1F, 220F).setOffset(0F, 0F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.toragHammer, new RenderItemWeapon(new ModelToragHammer(), Resources.TEXTURE_TORAG, 0.7F, 220F).setOffset(0.4F, 0.9F, 0.1F).setRotation(0F, 90F, 220F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.veracFlail, new RenderItemWeapon(new ModelVeracFlail(), Resources.TEXTURE_VERAC, 1.1F, 220F).setOffset(0F, 0F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.guthanSpear, new RenderItemWeapon(new ModelGuthanSpear(), Resources.TEXTURE_GUTHAN, 1.5F).setOffset(0F, 0F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.dharokAxe, new RenderItemWeapon(new ModelDharokAxe(), Resources.TEXTURE_DHAROK, 1.1F, 220F).setOffset(0F, 0F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.akrisaeMace, new RenderItemWeapon(new ModelAkrisaeMace(), Resources.TEXTURE_AKRISAE, 1.3F, 220F).setOffset(0F, 0F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.blackHalberd, new RenderItemWeapon(new ModelHalberd(), Resources.TEXTURE_BLACKHALBERD, 1F, 220F).setOffset(0F, 0F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.dragon2hSword, new RenderItemWeapon(new Modeld2h(), Resources.TEXTURE_D2H, 0.5F, 220F).setOffset(1.3F, 0.9F, -0.1F));*/
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.pitchFork, new RenderItemWeapon(new ModelPitchFork(), Resources.TEXTURE_PITCHFORK, 1F, 220F).setOffset(0F, 0F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.dryRapier, new RenderItemWeapon(new ModelDryrapier(), Resources.TEXTURE_DRYRAPIER, 1F, 220F).setOffset(0F, 0F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.dryMace, new RenderItemWeapon(new ModelDrymace(), Resources.TEXTURE_DRYMACE, 1F, 220F).setOffset(0F, 0F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.dryLong, new RenderItemWeapon(new ModelDrylong(), Resources.TEXTURE_DRYLONG, 0.3F, 220F).setOffset(2F, 1F, 0F).setRotation(150F, 90F, 0F));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStall.class, new RenderStall());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFire.class, new RenderFire());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySmithingAnvil.class, new RenderAnvil());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityScapecraftPortal.class, new RenderPortal());

		setArmorModel(ScapecraftItems.equipmentSets.get("bronzeFullHelm"), new ModelFullHelm(), "scapecraft:textures/armor/bronzeFullHelm.png");
		setArmorModel(ScapecraftItems.equipmentSets.get("ironFullHelm"), new ModelFullHelm(), "scapecraft:textures/armor/ironFullHelm.png");
		setArmorModel(ScapecraftItems.equipmentSets.get("steelFullHelm"), new ModelFullHelm(), "scapecraft:textures/armor/steelFullHelm.png");
		setArmorModel(ScapecraftItems.equipmentSets.get("whiteFullHelm"), new ModelFullHelm(), "scapecraft:textures/armor/whiteFullHelm.png");
		setArmorModel(ScapecraftItems.equipmentSets.get("blackFullHelm"), new ModelFullHelm(), "scapecraft:textures/armor/blackFullHelm.png");
		setArmorModel(ScapecraftItems.equipmentSets.get("mithrilFullHelm"), new ModelFullHelm(), "scapecraft:textures/armor/mithrilFullHelm.png");
		setArmorModel(ScapecraftItems.equipmentSets.get("adamantFullHelm"), new ModelFullHelm(), "scapecraft:textures/armor/adamantFullHelm.png");
		setArmorModel(ScapecraftItems.equipmentSets.get("runeFullHelm"), new ModelFullHelm(), "scapecraft:textures/armor/runeFullHelm.png");
		setArmorModel(ScapecraftItems.equipmentSets.get("dragonFullHelm"), new ModelDragonHelm(), "scapecraft:textures/armor/dragonFullHelm.png");

		setArmorModel(ScapecraftItems.equipmentSets.get("bronzePlateskirt"), new ModelPlateskirt(), "scapecraft:textures/armor/bronzePlateskirt.png");
		setArmorModel(ScapecraftItems.equipmentSets.get("ironPlateskirt"), new ModelPlateskirt(), "scapecraft:textures/armor/ironPlateskirt.png");
		setArmorModel(ScapecraftItems.equipmentSets.get("steelPlateskirt"), new ModelPlateskirt(), "scapecraft:textures/armor/steelPlateskirt.png");
		setArmorModel(ScapecraftItems.equipmentSets.get("whitePlateskirt"), new ModelPlateskirt(), "scapecraft:textures/armor/whitePlateskirt.png");
		setArmorModel(ScapecraftItems.equipmentSets.get("blackPlateskirt"), new ModelPlateskirt(), "scapecraft:textures/armor/blackPlateskirt.png");
		setArmorModel(ScapecraftItems.equipmentSets.get("mithrilPlateskirt"), new ModelPlateskirt(), "scapecraft:textures/armor/mithrilPlateskirt.png");
		setArmorModel(ScapecraftItems.equipmentSets.get("adamantPlateskirt"), new ModelPlateskirt(), "scapecraft:textures/armor/adamantPlateskirt.png");
		setArmorModel(ScapecraftItems.equipmentSets.get("runePlateskirt"), new ModelPlateskirt(), "scapecraft:textures/armor/runePlateskirt.png");
		setArmorModel(ScapecraftItems.equipmentSets.get("dragonPlateskirt"), new ModelPlateskirt(), "scapecraft:textures/armor/dragonPlateskirt.png");
		setArmorModel(ScapecraftItems.equipmentSets.get("dragonCPlateskirt"), new ModelPlateskirt(), "scapecraft:textures/armor/dragonCPlateskirt.png");
		//setArmorModel(ScapecraftItems.neitiznotHelmet, new ModelNeitiznotHelm(), "scapecraft:textures/armor/NeitiznotHelm.png");

		for(String name : ScapecraftEntities.entities)
		{
			ScapecraftEntities.addTextures(name);
		}

		try
		{
			//noinspection unchecked
			((List)ReflectionHelper.findField(Minecraft.class, "defaultResourcePacks", "field_110449_ao", "ap").get(Minecraft.getMinecraft())).add(dynamicResourcePack);
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
	}

	public static void setArmorModel(Item armor, ModelBiped model, String textureName)
	{
		((ItemArmorScapecraft) armor).armorModel = model;
		((ItemArmorScapecraft) armor).textureName = textureName;
	}

	@Override
	public void saveCache()
	{
		super.saveCache();
		try
		{
			GLContext.getCapabilities();
			Minecraft.getMinecraft().refreshResources();
			for (String name : this.pendingRefresh)
			{
				ScapecraftEntities.addTextures(name);
			}
		}
		catch (RuntimeException e)
		{
			System.out.println(e.toString());
		}
	}

	@Override
	public void cacheResource(ResourceLocation location, byte[] data, long cacheId)
	{
		super.cacheResource(location, data, cacheId);
		if("scapecraft".equals(location.getResourceDomain()) && location.getResourcePath().startsWith("assets/textures/entity/"))
		{
			String name = location.getResourcePath().substring("assets/textures/entity/".length());
			int index = name.indexOf("/");
			if(index != -1)
			{
				name = name.substring(0, index);
			}
			if(ScapecraftEntities.entities.contains(name))
			{
				this.pendingRefresh.add(name);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void registerMobRenderer(NBTTagCompound tag)
	{
		String name = tag.getString("name");
		Class<? extends Entity> entityClass = ScapecraftEntities.entityNames.get(name.toLowerCase());
		if(tag.hasKey("model"))
		{
			Render render = null;
			String modelName = tag.getString("model");
			if ("Biped".equals(modelName))
			{
				render = new RenderBipedScapecraft();
			}
			else
			{
				try
				{
					render = new RenderEntityScapecraft((ModelBase) Class.forName("scapecraft.client.model.Model" + modelName).newInstance(), 0.5f);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			RenderManager.instance.entityRenderMap.put(entityClass, render);
			assert render != null;
			render.setRenderManager(RenderManager.instance);
		}

		ScapecraftEntities.addTextures(name);
		//RenderingRegistry.registerEntityRenderingHandler(entityClass, render);
	}
}