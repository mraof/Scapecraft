package scapecraft.client;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.MinecraftForgeClient;

import scapecraft.CommonProxy;
import scapecraft.client.gui.GuiHealth;
import scapecraft.client.model.ModelAGS;
import scapecraft.client.model.ModelAbbyDemon;
import scapecraft.client.model.ModelAhrim;
import scapecraft.client.model.ModelAkrisae;
import scapecraft.client.model.ModelAkrisaeMace;
import scapecraft.client.model.ModelBGS;
import scapecraft.client.model.ModelBalfrugKreeyath;
import scapecraft.client.model.ModelBandosArmor;
import scapecraft.client.model.ModelBlackDemon;
import scapecraft.client.model.ModelCaveCrawler;
import scapecraft.client.model.ModelChaoticLongsword;
import scapecraft.client.model.ModelChaoticMaul;
import scapecraft.client.model.ModelDBA;
import scapecraft.client.model.ModelDD;
import scapecraft.client.model.ModelDarkBow;
import scapecraft.client.model.ModelDharok;
import scapecraft.client.model.ModelDharokAxe;
import scapecraft.client.model.ModelDragonHelm;
import scapecraft.client.model.ModelDrylong;
import scapecraft.client.model.ModelDrymace;
import scapecraft.client.model.ModelDryrapier;
import scapecraft.client.model.ModelDwarf;
import scapecraft.client.model.ModelFireGiant;
import scapecraft.client.model.ModelGeneralGraardor;
import scapecraft.client.model.ModelGhost;
import scapecraft.client.model.ModelGoblin;
import scapecraft.client.model.ModelGreenDragon;
import scapecraft.client.model.ModelGuthan;
import scapecraft.client.model.ModelGuthanSpear;
import scapecraft.client.model.ModelHalberd;
import scapecraft.client.model.ModelHellhound;
import scapecraft.client.model.ModelHillGiant;
import scapecraft.client.model.ModelIceGiant;
import scapecraft.client.model.ModelKK;
import scapecraft.client.model.ModelKKspawn;
import scapecraft.client.model.ModelKQ;
import scapecraft.client.model.ModelKQ2;
import scapecraft.client.model.ModelKaril;
import scapecraft.client.model.ModelKarilBow;
import scapecraft.client.model.ModelKreearra;
import scapecraft.client.model.ModelKrilTsutsaroth;
import scapecraft.client.model.ModelLavaBlock;
import scapecraft.client.model.ModelLesserDemon;
import scapecraft.client.model.ModelLesserDemon2;
import scapecraft.client.model.ModelLootChest;
import scapecraft.client.model.ModelMossGiant;
import scapecraft.client.model.ModelNeitiznotHelm;
import scapecraft.client.model.ModelPitchFork;
import scapecraft.client.model.ModelRapier;
import scapecraft.client.model.ModelRat;
import scapecraft.client.model.ModelSGS;
import scapecraft.client.model.ModelSaraSword;
import scapecraft.client.model.ModelScorpion;
import scapecraft.client.model.ModelSergeantGrimSpike;
import scapecraft.client.model.ModelSergeantSteelWill;
import scapecraft.client.model.ModelSergeantStrongStack;
import scapecraft.client.model.ModelTD;
import scapecraft.client.model.ModelTorag;
import scapecraft.client.model.ModelToragHammer;
import scapecraft.client.model.ModelTstanonKarlak;
import scapecraft.client.model.ModelVerac;
import scapecraft.client.model.ModelVeracFlail;
import scapecraft.client.model.ModelWarhammer;
import scapecraft.client.model.ModelWhip;
import scapecraft.client.model.ModelZGS;
import scapecraft.client.model.ModelZaklnGritch;
import scapecraft.client.model.ModelZilyana;
import scapecraft.client.model.Modeld2h;
import scapecraft.client.renderer.entity.RenderBipedScapecraft;
import scapecraft.client.renderer.entity.RenderEntityScapecraft;
import scapecraft.client.renderer.entity.RenderGenericBiped;
import scapecraft.client.renderer.entity.RenderShapeshifter;
import scapecraft.client.renderer.item.RenderItemSpawnEgg;
import scapecraft.client.renderer.item.RenderItemWeapon;
import scapecraft.client.renderer.tileentity.RenderFire;
import scapecraft.client.renderer.tileentity.RenderStall;
import scapecraft.command.WeaponModelCommand;
import scapecraft.entity.EntityAbbyDemon;
import scapecraft.entity.EntityAhrim;
import scapecraft.entity.EntityAkrisae;
import scapecraft.entity.EntityBalfrugKreeyath;
import scapecraft.entity.EntityBandit;
import scapecraft.entity.EntityBarbarian;
import scapecraft.entity.EntityBlackDemon;
import scapecraft.entity.EntityBlackDragon;
import scapecraft.entity.EntityBlackGuard;
import scapecraft.entity.EntityBlackGuard2;
import scapecraft.entity.EntityBlackKnight;
import scapecraft.entity.EntityBot;
import scapecraft.entity.EntityBot2;
import scapecraft.entity.EntityBot3;
import scapecraft.entity.EntityCaveCrawler;
import scapecraft.entity.EntityCook;
import scapecraft.entity.EntityDarkwizard;
import scapecraft.entity.EntityDharok;
import scapecraft.entity.EntityDoctor;
import scapecraft.entity.EntityDwarf;
import scapecraft.entity.EntityEliteBlackKnight;
import scapecraft.entity.EntityFarmer;
import scapecraft.entity.EntityFireGiant;
import scapecraft.entity.EntityFremGuard;
import scapecraft.entity.EntityGeneralGraardor;
import scapecraft.entity.EntityGenericBiped;
import scapecraft.entity.EntityGhost;
import scapecraft.entity.EntityGoblin;
import scapecraft.entity.EntityGreenDragon;
import scapecraft.entity.EntityGuard;
import scapecraft.entity.EntityGuthan;
import scapecraft.entity.EntityHellhound;
import scapecraft.entity.EntityHeroKnight;
import scapecraft.entity.EntityHighMage;
import scapecraft.entity.EntityHillGiant;
import scapecraft.entity.EntityIceGiant;
import scapecraft.entity.EntityIronDragon;
import scapecraft.entity.EntityKK;
import scapecraft.entity.EntityKKspawn;
import scapecraft.entity.EntityKQ;
import scapecraft.entity.EntityKQ2;
import scapecraft.entity.EntityKaril;
import scapecraft.entity.EntityKing;
import scapecraft.entity.EntityKingsGuard;
import scapecraft.entity.EntityKos1;
import scapecraft.entity.EntityKos2;
import scapecraft.entity.EntityKos3;
import scapecraft.entity.EntityKos4;
import scapecraft.entity.EntityKreearra;
import scapecraft.entity.EntityKrilTsutsaroth;
import scapecraft.entity.EntityLavaBlock;
import scapecraft.entity.EntityLesserDemon;
import scapecraft.entity.EntityLesserDemon2;
import scapecraft.entity.EntityLootChest;
import scapecraft.entity.EntityMan;
import scapecraft.entity.EntityMorgan;
import scapecraft.entity.EntityMossGiant;
import scapecraft.entity.EntityMugger;
import scapecraft.entity.EntityRat;
import scapecraft.entity.EntityRatSmall;
import scapecraft.entity.EntityScorpion;
import scapecraft.entity.EntitySergeantGrimspike;
import scapecraft.entity.EntitySergeantSteelwill;
import scapecraft.entity.EntitySergeantStrongstack;
import scapecraft.entity.EntityShapeshifter;
import scapecraft.entity.EntityShopKeeper;
import scapecraft.entity.EntityTD;
import scapecraft.entity.EntityTheif;
import scapecraft.entity.EntityTorag;
import scapecraft.entity.EntityTstanonKarlak;
import scapecraft.entity.EntityVampire;
import scapecraft.entity.EntityVarze;
import scapecraft.entity.EntityVerac;
import scapecraft.entity.EntityWhiteKnight;
import scapecraft.entity.EntityWizard;
import scapecraft.entity.EntityZaklnGritch;
import scapecraft.entity.EntityZilyana;
import scapecraft.item.ItemArmorScapecraft;
import scapecraft.item.ScapecraftItems;
import scapecraft.tileentity.TileEntityFire;
import scapecraft.tileentity.TileEntityStall;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
	public static final ModelBandosArmor bandosChest = new ModelBandosArmor(1.0f);
	public static final ModelBandosArmor bandosLegs = new ModelBandosArmor(0.5f);

	public static GuiHealth guiHealth = new GuiHealth();


	public void registerRenderers()
	{
		ClientCommandHandler.instance.registerCommand(new WeaponModelCommand());
		//Add server to server list
		try
		{
			String address = "";
			if(!address.isEmpty())
			{
				NBTTagCompound tagCompound = CompressedStreamTools.read(new File(Minecraft.getMinecraft().mcDataDir, "servers.dat"));
				NBTTagList servers = tagCompound.getTagList("servers", 10);
				boolean hasServer = false;
				for(int i = 0; i < servers.tagCount(); i++)
				{
					if(servers.getCompoundTagAt(i).getString("ip").equals(address))//TODO move to config
					{
						hasServer = true;
						break;
					}
				}

				if(!hasServer)
				{
					NBTTagCompound scServer = new NBTTagCompound();
					scServer.setString("name", "Scapecraft");
					scServer.setString("ip", address);
					scServer.setBoolean("acceptTextures", true);
					servers.appendTag(scServer);
					tagCompound.setTag("servers", servers);
					CompressedStreamTools.safeWrite(tagCompound, new File(Minecraft.getMinecraft().mcDataDir, "servers.dat"));
				}
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		RenderingRegistry.registerEntityRenderingHandler(EntityBandit.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/bandit.png")).setScale(1.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBarbarian.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/barbarian.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlackGuard.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/blackboss.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlackGuard2.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/blackboss.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlackKnight.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/Theif.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityBot.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/bot.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityBot2.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/bot2.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityBot3.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/bot.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityCook.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/cook.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityDarkwizard.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/darkwizard.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityDoctor.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/doctor.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityEliteBlackKnight.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/Theif.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityFarmer.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/farmer.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityFremGuard.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/fremguard.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityGuard.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/guard.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityHeroKnight.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/whiteknight.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityHighMage.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/highmage.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityKing.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/king.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityKingsGuard.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/kingguard.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityKos1.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/Kos.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityKos2.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/Kos.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityKos3.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/Kos.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityKos4.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/Kos2.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityMan.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/man.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityMorgan.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/morgan.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityMugger.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/mugger.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityShopKeeper.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/shopkeeper.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityTheif.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/Theif.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityVampire.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/vampire.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityVarze.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/varze.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityWhiteKnight.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/whiteknight.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityWizard.class, new RenderBipedScapecraft(new ResourceLocation("scapecraft", "textures/entity/wizard.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityAbbyDemon.class, new RenderEntityScapecraft(new ModelAbbyDemon(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/abbydemon.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityAhrim.class, new RenderEntityScapecraft(new ModelAhrim(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/Ahrim.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityAkrisae.class, new RenderEntityScapecraft(new ModelAkrisae(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/Akrisae.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlackDemon.class, new RenderEntityScapecraft(new ModelBlackDemon(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/BlackDemon.png")).setScale(2.1F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlackDragon.class, new RenderEntityScapecraft(new ModelGreenDragon(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/BlackDragon.png")).setScale(2.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityCaveCrawler.class, new RenderEntityScapecraft(new ModelCaveCrawler(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/CaveCrawler.png")).setScale(1.4F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDharok.class, new RenderEntityScapecraft(new ModelDharok(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/Dharok.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityDwarf.class, new RenderEntityScapecraft(new ModelDwarf(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/dwarf.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityFireGiant.class, new RenderEntityScapecraft(new ModelFireGiant(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/FireGiant.png")).setScale(1.4F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGeneralGraardor.class, new RenderEntityScapecraft(new ModelGeneralGraardor(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/GeneralGraardor.png")).setScale(2.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGhost.class, new RenderEntityScapecraft(new ModelGhost(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/GhostF.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityGoblin.class, new RenderEntityScapecraft(new ModelGoblin(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/goblin.png")).setScale(0.7F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGreenDragon.class, new RenderEntityScapecraft(new ModelGreenDragon(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/GreenDragon.png")).setScale(2.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGuthan.class, new RenderEntityScapecraft(new ModelGuthan(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/Guthan.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityHellhound.class, new RenderEntityScapecraft(new ModelHellhound(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/HellHound.png")).setScale(1.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityHillGiant.class, new RenderEntityScapecraft(new ModelHillGiant(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/HillGiant.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityIceGiant.class, new RenderEntityScapecraft(new ModelIceGiant(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/IceGiant.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityIronDragon.class, new RenderEntityScapecraft(new ModelGreenDragon(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/IronDragon.png")).setScale(2.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityKK.class, new RenderEntityScapecraft(new ModelKK(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/KK.png")).setScale(3.5F).setOffset(0F, .7F, 0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityKKspawn.class, new RenderEntityScapecraft(new ModelKKspawn(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/KKspawn.png")).setOffset(0F, .7F, 0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityKQ.class, new RenderEntityScapecraft(new ModelKQ(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/KQ.png")).setScale(3.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityKQ2.class, new RenderEntityScapecraft(new ModelKQ2(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/KQ2.png")).setScale(0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityKaril.class, new RenderEntityScapecraft(new ModelKaril(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/Karil.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityLavaBlock.class, new RenderEntityScapecraft(new ModelLavaBlock(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/LavaBlock.png")).setScale(.2F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLesserDemon.class, new RenderEntityScapecraft(new ModelLesserDemon(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/LesserDemon.png")).setScale(1.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLesserDemon2.class, new RenderEntityScapecraft(new ModelLesserDemon2(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/LesserDemon2.png")).setScale(1.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLootChest.class, new RenderEntityScapecraft(new ModelLootChest(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/Chest.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityMossGiant.class, new RenderEntityScapecraft(new ModelMossGiant(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/MossGiant.png")).setScale(1.4F));
		RenderingRegistry.registerEntityRenderingHandler(EntityRat.class, new RenderEntityScapecraft(new ModelRat(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/rat.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityRatSmall.class, new RenderEntityScapecraft(new ModelRat(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/rat.png")).setScale(0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityScorpion.class, new RenderEntityScapecraft(new ModelScorpion(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/Scorpion.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntitySergeantGrimspike.class, new RenderEntityScapecraft(new ModelSergeantGrimSpike(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/SergeantGrimspike.png")).setScale(0.8F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySergeantSteelwill.class, new RenderEntityScapecraft(new ModelSergeantSteelWill(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/SergeantSteelwill.png")).setScale(0.8F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySergeantStrongstack.class, new RenderEntityScapecraft(new ModelSergeantStrongStack(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/SergeantStrongstack.png")).setScale(0.8F));
		RenderingRegistry.registerEntityRenderingHandler(EntityTD.class, new RenderEntityScapecraft(new ModelTD(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/TD.png")).setScale(2.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityTorag.class, new RenderEntityScapecraft(new ModelTorag(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/ToragWHammers.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityVerac.class, new RenderEntityScapecraft(new ModelVerac(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/Verac.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityZilyana.class, new RenderEntityScapecraft(new ModelZilyana(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/Zilyana.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityZaklnGritch.class, new RenderEntityScapecraft(new ModelZaklnGritch(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/ZaklnGritch.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityTstanonKarlak.class, new RenderEntityScapecraft(new ModelTstanonKarlak(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/TstanonKarlak.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityKrilTsutsaroth.class, new RenderEntityScapecraft(new ModelKrilTsutsaroth(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/KrilTsutsaroth.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityBalfrugKreeyath.class, new RenderEntityScapecraft(new ModelBalfrugKreeyath(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/BalfrugKreeyath.png"))); 
		RenderingRegistry.registerEntityRenderingHandler(EntityKreearra.class, new RenderEntityScapecraft(new ModelKreearra(), 0.5F, new ResourceLocation("scapecraft", "textures/entity/Kreearra.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityShapeshifter.class, new RenderShapeshifter()); 
		RenderingRegistry.registerEntityRenderingHandler(EntityGenericBiped.class, new RenderGenericBiped()); 

		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.scapecraftSpawnEgg, new RenderItemSpawnEgg());
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.bronzeHammer, new RenderItemWeapon(new ModelWarhammer(), Resources.TEXTURE_BronzeHammer, 0.85F, 230F).setOffset(-0.15F, 1.1F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.ironHammer, new RenderItemWeapon(new ModelWarhammer(), Resources.TEXTURE_SteelHammer, 0.85F, 230F).setOffset(-0.15F, 1.1F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.mithHammer, new RenderItemWeapon(new ModelWarhammer(), Resources.TEXTURE_MithHammer, 0.85F, 230F).setOffset(-0.15F, 1.1F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.addyHammer, new RenderItemWeapon(new ModelWarhammer(), Resources.TEXTURE_AddyHammer, 0.85F, 230F).setOffset(-0.15F, 1.1F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.runeHammer, new RenderItemWeapon(new ModelWarhammer(), Resources.TEXTURE_RuneHammer, 0.85F, 230F).setOffset(-0.15F, 1.1F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.AGS, new RenderItemWeapon(new ModelAGS(), Resources.TEXTURE_AGS, 0.55F, 220F).setOffset(0.9F, 0.5F, -0.1F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.BGS, new RenderItemWeapon(new ModelBGS(), Resources.TEXTURE_BGS, 0.55F, 220F).setOffset(0.9F, 0.5F, -0.1F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.SGS, new RenderItemWeapon(new ModelSGS(), Resources.TEXTURE_SGS, 0.55F, 220F).setOffset(0.9F, 0.5F, -0.1F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.ZGS, new RenderItemWeapon(new ModelZGS(), Resources.TEXTURE_ZGS, 0.55F, 220F).setOffset(0.9F, 0.5F, -0.1F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.DBA, new RenderItemWeapon(new ModelDBA(), Resources.TEXTURE_DBA, 1.05F, 220F).setOffset(0F, 0F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.DD, new RenderItemWeapon(new ModelDD(), Resources.TEXTURE_DD, 1F, 220F).setOffset(0F, 0F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.DDS, new RenderItemWeapon(new ModelDD(), Resources.TEXTURE_DDS, 1F, 220F).setOffset(0F, 0F, 0F));
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
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.pitchFork, new RenderItemWeapon(new ModelPitchFork(), Resources.TEXTURE_PITCHFORK, 1F, 220F).setOffset(0F, 0F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.blackHalberd, new RenderItemWeapon(new ModelHalberd(), Resources.TEXTURE_BLACKHALBERD, 1F, 220F).setOffset(0F, 0F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.dryRapier, new RenderItemWeapon(new ModelDryrapier(), Resources.TEXTURE_DRYRAPIER, 1F, 220F).setOffset(0F, 0F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.dryMace, new RenderItemWeapon(new ModelDrymace(), Resources.TEXTURE_DRYMACE, 1F, 220F).setOffset(0F, 0F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.dryLong, new RenderItemWeapon(new ModelDrylong(), Resources.TEXTURE_DRYLONG, 1F, 220F).setOffset(1F, 0.3F, 0F).setRotation(150F, 90F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.dragon2hSword, new RenderItemWeapon(new Modeld2h(), Resources.TEXTURE_D2H, 0.5F, 220F).setOffset(1.3F, 0.9F, -0.1F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.darkBow, new RenderItemWeapon(new ModelDarkBow(), Resources.TEXTURE_DARKBOW, 1F, 0F).setOffset(0F, 0.5F, 0F).setRotation(0F, 270F, 0F));
		MinecraftForgeClient.registerItemRenderer(ScapecraftItems.karilBow, new RenderItemWeapon(new ModelKarilBow(), Resources.TEXTURE_KARIL, 1F, 180F).setOffset(0.1F, 0.3F, 1F));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStall.class, new RenderStall());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFire.class, new RenderFire());

		setArmorModel(ScapecraftItems.dragonFullHelm, new ModelDragonHelm(), "scapecraft:textures/armor/DragonHelm.png");
		setArmorModel(ScapecraftItems.neitiznotHelmet, new ModelNeitiznotHelm(), "scapecraft:textures/armor/NeitiznotHelm.png");
	}

	public static void setArmorModel(Item armor, ModelBiped model, String textureName)
	{
		((ItemArmorScapecraft) armor).armorModel = model;
		((ItemArmorScapecraft) armor).textureName = textureName;
	}
}
