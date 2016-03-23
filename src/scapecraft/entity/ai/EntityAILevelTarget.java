package scapecraft.entity.ai;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import scapecraft.entity.EntityScapecraft;
import scapecraft.util.Stats;

import java.util.Collections;
import java.util.List;

/**
 * Created by mraof on 2016 March 02.
 */
public class EntityAILevelTarget extends EntityAITarget
{
    private final EntityAINearestAttackableTarget.Sorter sorter;
    private final IEntitySelector targetEntitySelector;
    private EntityLivingBase targetEntity;
    private Class<?extends EntityScapecraft>[] allies;

    public EntityAILevelTarget(final EntityScapecraft entityScapecraft, boolean p_i1665_4_, boolean p_i1665_5_, Class<? extends EntityScapecraft>... allies)
    {
        super(entityScapecraft, p_i1665_4_, p_i1665_5_);
        this.sorter = new EntityAINearestAttackableTarget.Sorter(entityScapecraft);
        this.setMutexBits(1);
        this.targetEntitySelector = new IEntitySelector()
        {
            @Override
            public boolean isEntityApplicable(Entity p_82704_1_)
            {
                return entityScapecraft.isEntityApplicable(p_82704_1_) && EntityAILevelTarget.this.isSuitableTarget((EntityLivingBase) p_82704_1_, false);
            }
        };
        this.allies = allies;
    }

    @Override
    public boolean shouldExecute()
    {
        double distance = this.getTargetDistance();
        List list = this.taskOwner.worldObj.selectEntitiesWithinAABB(EntityLivingBase.class, this.taskOwner.boundingBox.expand(distance, 4, distance), this.targetEntitySelector);
        Collections.sort(list, sorter);
        if(list.isEmpty())
        {
            return false;
        }
        else
        {
            this.targetEntity = (EntityLivingBase) list.get(0);
            return true;
        }
    }

    @Override
    public void startExecuting()
    {
        int levelDifference = 0;
        int ownerLevel = ((EntityScapecraft) this.taskOwner).getLevel();
        if(this.targetEntity instanceof EntityScapecraft)
        {
            levelDifference = ((EntityScapecraft) this.targetEntity).getLevel() - ownerLevel;
        }
        else if(this.targetEntity instanceof EntityPlayer)
        {
            levelDifference = Stats.getCombatLevel((EntityPlayer) targetEntity) - ownerLevel;
        }

        int bravery = 5;
        if(this.allies.length > 0)
        {
            if (levelDifference > bravery)
            {
                int allyNum;
                double distance = this.getTargetDistance();
                List list = this.taskOwner.worldObj.getEntitiesWithinAABB(EntityScapecraft.class, AxisAlignedBB.getBoundingBox(this.taskOwner.posX, this.taskOwner.posY, this.taskOwner.posZ, this.taskOwner.posX + 1.0D, this.taskOwner.posY + 1.0D, this.taskOwner.posZ + 1.0D).expand(distance, 10.0D, distance));
                for(allyNum = 0; allyNum < list.size() && levelDifference > bravery; allyNum++)
                {
                    EntityScapecraft entity = ((EntityScapecraft) list.get(allyNum));
                    if (this.taskOwner != entity && entity.getAttackTarget() == null && !entity.isOnSameTeam(this.taskOwner.getAITarget()))
                    {
                        levelDifference -= 1 + ((entity.getLevel() > ownerLevel) ? (entity.getLevel() - ownerLevel) : 0);
                    }
                }
            }
        }

        if(levelDifference > bravery)
        {
            Vec3 vec3 = RandomPositionGenerator.findRandomTargetBlockAwayFrom(this.taskOwner, (int) Math.sqrt(levelDifference) + 3, 4, this.targetEntity.getLookVec());
            if(vec3 != null)
            {
                this.taskOwner.getNavigator().tryMoveToXYZ(vec3.xCoord, vec3.yCoord, vec3.zCoord, 1 + Math.sqrt(levelDifference) / 10f);
            }
        }
        else
        {
            this.taskOwner.setAttackTarget(this.targetEntity);
        }
    }

    @Override
    public boolean continueExecuting()
    {
        return super.continueExecuting() || !this.taskOwner.getNavigator().noPath();
    }
}
