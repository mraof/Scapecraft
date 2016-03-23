package scapecraft.entity;

import net.minecraft.entity.Entity;

import java.util.ArrayList;

public interface MobSpawner
{
	void onSpawnedDeath(Entity entity);

	ArrayList<Drop> getDrops(EntityScapecraft entityScapecraft);

	int[] getMoneyDrops(EntityScapecraft entityScapecraft);
}
