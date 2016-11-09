package scapecraft.entity;

import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import scapecraft.entity.ai.EntityAIHurtByLevelTarget;
import scapecraft.entity.ai.EntityAILevelTarget;

/**
 * Created by mraof on 2016 March 27 at 8:38 PM.
 */
public class EntityRockCrab extends EntityScapecraft
{
    public EntityRockCrab(World world)
    {
        super(world);
        this.setSize(0.6f, 1);

        //noinspection unchecked
        this.targetTasks.addTask(1, new EntityAIHurtByLevelTarget(this, EntityRockCrab.class));
        //noinspection unchecked
        this.targetTasks.addTask(2, new EntityAILevelTarget(this, true, false));
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.1D, false));
        this.tasks.addTask(5, new EntityAIWander(this, 1D));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
    }

    }
