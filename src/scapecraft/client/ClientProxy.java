package scapecraft.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GLContext;
import scapecraft.CommonProxy;
import scapecraft.client.gui.GuiHealth;
import scapecraft.client.model.*;
import scapecraft.client.model.armor.ModelDragonHelm;
import scapecraft.client.model.armor.ModelFullHelm;
import scapecraft.client.model.armor.ModelPlateskirt;
import scapecraft.client.renderer.entity.*;
import scapecraft.client.renderer.tileentity.RenderFire;
import scapecraft.client.renderer.tileentity.RenderPortal;
import scapecraft.client.renderer.tileentity.RenderStall;
import scapecraft.client.settings.ScapecraftKeyHandler;
import scapecraft.command.FileGuiCommand;
import scapecraft.entity.*;
import scapecraft.item.ItemArmorScapecraft;
import scapecraft.item.ScapecraftItems;
import scapecraft.tileentity.TileEntityFire;
import scapecraft.tileentity.TileEntityScapecraftPortal;
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
		System.out.println(dynamicResourcePack.getResourceDomains());
	}

	@Override
	public void registerPreInit()
	{
		RenderFactoryBiped standardBipedFactory = new RenderFactoryBiped();
		RenderingRegistry.registerEntityRenderingHandler(EntityBandit.class, new RenderFactoryBiped().setScale(1.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBarbarian.class, standardBipedFactory);
		RenderingRegistry.registerEntityRenderingHandler(EntityBlackGuard.class, standardBipedFactory);
		RenderingRegistry.registerEntityRenderingHandler(EntityBlackKnight.class, standardBipedFactory);
		RenderingRegistry.registerEntityRenderingHandler(EntityCook.class, standardBipedFactory);
		RenderingRegistry.registerEntityRenderingHandler(EntityDarkwizard.class, standardBipedFactory);
		RenderingRegistry.registerEntityRenderingHandler(EntityDoctor.class, standardBipedFactory);
		RenderingRegistry.registerEntityRenderingHandler(EntityEliteBlackKnight.class, standardBipedFactory);
		RenderingRegistry.registerEntityRenderingHandler(EntityFarmer.class, standardBipedFactory);
		RenderingRegistry.registerEntityRenderingHandler(EntityFremGuard.class, standardBipedFactory);
		RenderingRegistry.registerEntityRenderingHandler(EntityGuard.class, standardBipedFactory);
		RenderingRegistry.registerEntityRenderingHandler(EntityHeroKnight.class, standardBipedFactory);
		RenderingRegistry.registerEntityRenderingHandler(EntityHighMage.class, standardBipedFactory);
		RenderingRegistry.registerEntityRenderingHandler(EntityKing.class, standardBipedFactory);
		RenderingRegistry.registerEntityRenderingHandler(EntityKingsGuard.class, standardBipedFactory);
		RenderingRegistry.registerEntityRenderingHandler(EntityKos1.class, standardBipedFactory);
		RenderingRegistry.registerEntityRenderingHandler(EntityKos2.class, standardBipedFactory);
		RenderingRegistry.registerEntityRenderingHandler(EntityKos3.class, standardBipedFactory);
		RenderingRegistry.registerEntityRenderingHandler(EntityKos4.class, standardBipedFactory);
		RenderingRegistry.registerEntityRenderingHandler(EntityMan.class, standardBipedFactory);
		RenderingRegistry.registerEntityRenderingHandler(EntityMorgan.class, standardBipedFactory);
		RenderingRegistry.registerEntityRenderingHandler(EntityMugger.class, standardBipedFactory);
		RenderingRegistry.registerEntityRenderingHandler(EntityShopKeeper.class, standardBipedFactory);
		RenderingRegistry.registerEntityRenderingHandler(EntityThief.class, standardBipedFactory);
		RenderingRegistry.registerEntityRenderingHandler(EntityVampire.class, standardBipedFactory);
		RenderingRegistry.registerEntityRenderingHandler(EntityVarze.class, standardBipedFactory);
		RenderingRegistry.registerEntityRenderingHandler(EntityWhiteKnight.class, standardBipedFactory);
		RenderingRegistry.registerEntityRenderingHandler(EntityWizard.class, standardBipedFactory);
		RenderingRegistry.registerEntityRenderingHandler(EntityAbbyDemon.class, new RenderFactoryScapecraft(new ModelAbbyDemon()));
		RenderingRegistry.registerEntityRenderingHandler(EntityAhrim.class, new RenderFactoryScapecraft(new ModelAhrim()));
		RenderingRegistry.registerEntityRenderingHandler(EntityAkrisae.class, new RenderFactoryScapecraft(new ModelAkrisae()));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlackDemon.class, new RenderFactoryScapecraft(new ModelBlackDemon()).setScale(2.1F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlackDragon.class, new RenderFactoryScapecraft(new ModelGreenDragon()).setScale(2.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityCaveCrawler.class, new RenderFactoryScapecraft(new ModelCaveCrawler()).setScale(1.4F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDharok.class, new RenderFactoryScapecraft(new ModelDharok()));
		RenderingRegistry.registerEntityRenderingHandler(EntityDwarf.class, new RenderFactoryScapecraft(new ModelDwarf()));
		RenderingRegistry.registerEntityRenderingHandler(EntityFireGiant.class, new RenderFactoryScapecraft(new ModelFireGiant()).setScale(1.4F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGeneralGraardor.class, new RenderFactoryScapecraft(new ModelGeneralGraardor()).setScale(2.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGiantSpider.class, new RenderFactoryScapecraft(new ModelSpider()).setShadowSize(1F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGhost.class, new RenderFactoryScapecraft(new ModelGhost()));
		RenderingRegistry.registerEntityRenderingHandler(EntityGoblin.class, new RenderFactoryScapecraft(new ModelGoblin()).setScale(0.7F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGreenDragon.class, new RenderFactoryScapecraft(new ModelGreenDragon()).setScale(2.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGuthan.class, new RenderFactoryScapecraft(new ModelGuthan()));
		RenderingRegistry.registerEntityRenderingHandler(EntityHellhound.class, new RenderFactoryScapecraft(new ModelHellhound()).setScale(1.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityHillGiant.class, new RenderFactoryScapecraft(new ModelHillGiant()));
		RenderingRegistry.registerEntityRenderingHandler(EntityIceGiant.class, new RenderFactoryScapecraft(new ModelIceGiant()));
		RenderingRegistry.registerEntityRenderingHandler(EntityIronDragon.class, new RenderFactoryScapecraft(new ModelGreenDragon()).setScale(2.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityKK.class, new RenderFactoryScapecraft(new ModelKK()).setScale(3.5F).setOffset(0F, .7F, 0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityKKspawn.class, new RenderFactoryScapecraft(new ModelKKspawn()).setOffset(0F, .7F, 0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityKQ.class, new RenderFactoryScapecraft(new ModelKQ()).setScale(3.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityKQ2.class, new RenderFactoryScapecraft(new ModelKQ2()).setScale(0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityKaril.class, new RenderFactoryScapecraft(new ModelKaril()));
		RenderingRegistry.registerEntityRenderingHandler(EntityLavaBlock.class, new RenderFactoryScapecraft(new ModelLavaBlock()).setScale(.2F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLesserDemonUgly.class, new RenderFactoryScapecraft(new ModelLesserDemonUgly()).setScale(1.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLesserDemon.class, new RenderFactoryScapecraft(new ModelLesserDemon2()).setScale(1.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMossGiant.class, new RenderFactoryScapecraft(new ModelMossGiant()).setScale(1.4F));
		RenderingRegistry.registerEntityRenderingHandler(EntityRat.class, new RenderFactoryScapecraft(new ModelRat()));
		RenderingRegistry.registerEntityRenderingHandler(EntityRatSmall.class, new RenderFactoryScapecraft(new ModelRat()).setScale(0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityScorpion.class, new RenderFactoryScapecraft(new ModelScorpion()));
		RenderingRegistry.registerEntityRenderingHandler(EntitySergeantGrimspike.class, new RenderFactoryScapecraft(new ModelSergeantGrimSpike()).setScale(0.8F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySergeantSteelwill.class, new RenderFactoryScapecraft(new ModelSergeantSteelWill()).setScale(0.8F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySergeantStrongstack.class, new RenderFactoryScapecraft(new ModelSergeantStrongStack()).setScale(0.8F));
		RenderingRegistry.registerEntityRenderingHandler(EntityTormentedDemon.class, new RenderFactoryScapecraft(new ModelTD()).setScale(2.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityTorag.class, new RenderFactoryScapecraft(new ModelTorag()));
		RenderingRegistry.registerEntityRenderingHandler(EntityVerac.class, new RenderFactoryScapecraft(new ModelVerac()));
		RenderingRegistry.registerEntityRenderingHandler(EntityZilyana.class, new RenderFactoryScapecraft(new ModelZilyana()));
		RenderingRegistry.registerEntityRenderingHandler(EntityZaklnGritch.class, new RenderFactoryScapecraft(new ModelZaklnGritch()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTstanonKarlak.class, new RenderFactoryScapecraft(new ModelTstanonKarlak()));
		RenderingRegistry.registerEntityRenderingHandler(EntityKrilTsutsaroth.class, new RenderFactoryScapecraft(new ModelKrilTsutsaroth()));
		RenderingRegistry.registerEntityRenderingHandler(EntityBalfrugKreeyath.class, new RenderFactoryScapecraft(new ModelBalfrugKreeyath()));
		RenderingRegistry.registerEntityRenderingHandler(EntityKreearra.class, new RenderFactoryScapecraft(new ModelKreearra()));
		RenderingRegistry.registerEntityRenderingHandler(EntityShapeshifter.class, new IRenderFactory<EntityShapeshifter>() {
			@Override
			public Render<? super EntityShapeshifter> createRenderFor(RenderManager renderManager) {
				return new RenderShapeshifter(renderManager);
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityGenericBiped.class, new IRenderFactory<EntityGenericBiped>() {
			@Override
			public Render<? super EntityGenericBiped> createRenderFor(RenderManager manager) {
				return new RenderGenericBiped(manager);
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityKey.class, new IRenderFactory<EntityKey>() {
			@Override
			public Render<? super EntityKey> createRenderFor(RenderManager manager) {
				return new RenderKey(manager);
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityDrop.class, new IRenderFactory<EntityDrop>() {
			@Override
			public Render<? super EntityDrop> createRenderFor(RenderManager manager) {
				return new RenderEntityDrop(manager);
			}
		});
	}

	@Override
	public void registerRenderers()
	{
		ClientCommandHandler.instance.registerCommand(new FileGuiCommand());
		MinecraftForge.EVENT_BUS.register(new ScapecraftKeyHandler());


/*		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.scapecraftSpawnEgg, new RenderItemSpawnEgg());
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.equipmentSets.get("bronzeHammer"), new RenderItemObj("Warhammer", "BronzeWarhammer"));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.equipmentSets.get("ironHammer"), new RenderItemObj("Warhammer", "IronWarhammer"));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.equipmentSets.get("steelHammer"), new RenderItemObj("Warhammer", "SteelWarhammer"));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.equipmentSets.get("whiteHammer"), new RenderItemObj("Warhammer", "WhiteWarhammer"));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.equipmentSets.get("blackHammer"), new RenderItemObj("Warhammer", "BlackWarhammer"));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.equipmentSets.get("mithrilHammer"), new RenderItemObj("Warhammer", "MithrilWarhammer"));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.equipmentSets.get("adamantHammer"), new RenderItemObj("Warhammer", "AdamantWarhammer"));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.equipmentSets.get("runeHammer"), new RenderItemObj("Warhammer", "RuneWarhammer"));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.equipmentSets.get("dragonHammer"), new RenderItemObj("Warhammer", "DragonWarhammer"));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.equipmentSets.get("dragonDagger"), new RenderItemWeapon(new ModelDD(), Resources.TEXTURE_DD, 1F, 220F).setOffset(0F, 0F, 0F));*/
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
/*		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.pitchFork, new RenderItemWeapon(new ModelPitchFork(), Resources.TEXTURE_PITCHFORK, 1F, 220F).setOffset(0F, 0F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.dryRapier, new RenderItemWeapon(new ModelDryrapier(), Resources.TEXTURE_DRYRAPIER, 1F, 220F).setOffset(0F, 0F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.dryMace, new RenderItemWeapon(new ModelDrymace(), Resources.TEXTURE_DRYMACE, 1F, 220F).setOffset(0F, 0F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.dryLong, new RenderItemWeapon(new ModelDrylong(), Resources.TEXTURE_DRYLONG, 0.3F, 220F).setOffset(2F, 1F, 0F).setRotation(150F, 90F, 0F));*/

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStall.class, new RenderStall());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFire.class, new RenderFire());
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
		Class<? extends EntityScapecraft> entityClass = (Class<? extends EntityScapecraft>) ScapecraftEntities.entityNames.get(name.toLowerCase());
		if(tag.hasKey("model"))
		{
			IRenderFactory<EntityScapecraft> renderFactory = null;
			RenderManager manager = Minecraft.getMinecraft().getRenderManager();
			String modelName = tag.getString("model");
			if ("Biped".equals(modelName))
			{
				renderFactory = new RenderFactoryBiped();
			}
			else
			{
				try
				{
					renderFactory = new RenderFactoryScapecraft((ModelBase) Class.forName("scapecraft.client.model.Model" + modelName).newInstance());
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			if(renderFactory != null)
			{
				RenderingRegistry.registerEntityRenderingHandler(entityClass, renderFactory);
				manager.entityRenderMap.put(entityClass, renderFactory.createRenderFor(manager));
			}
		}

		ScapecraftEntities.addTextures(name);
		//RenderingRegistry.registerEntityRenderingHandler(entityClass, render);
	}
}