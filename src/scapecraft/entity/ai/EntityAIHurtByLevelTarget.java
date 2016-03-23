package scapecraft.entity.ai;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import scapecraft.entity.EntityScapecraft;
import scapecraft.util.Stats;

import java.util.Comparator;
import java.util.List;

/**
 * Created by mraof on 2016 January 04.
 * Based on level of enemy, call for help or flee
 */
public class EntityAIHurtByLevelTarget extends EntityAITarget
{
    private static final Comparator heroSorter = new Comparator()
    {
        @Override
        public int compare(Object o1, Object o2)
        {
            return (((EntityScapecraft)o1).isHero() ? -1 : 0 ) + (((EntityScapecraft)o2).isHero() ? 1 : 0 );
        }
    };
    int lastRevengeTime = 0;
    public int bravery = 5;
    Class<? extends EntityScapecraft>[] allies;
    private final IEntitySelector allySelector = new IEntitySelector() {

        @Override
        public boolean isEntityApplicable(Entity p_82704_1_)
        {
            for(Class ally : EntityAIHurtByLevelTarget.this.allies)
            {
                if(p_82704_1_.getClass().isAssignableFrom(ally))
                {
                    return true;
                }
            }
            return false;
        }
    };

    public EntityAIHurtByLevelTarget(EntityScapecraft entity, Class<? extends EntityScapecraft>... allies)
    {
        super(entity, false);
        this.allies = allies;
    }

    @Override
    public boolean shouldExecute()
    {
        return (this.taskOwner.getRevengeTimer() != this.lastRevengeTime) &&
                this.isSuitableTarget(this.taskOwner.getAITarget(), false);
    }

    @Override
    public void startExecuting()
    {
        EntityLivingBase target = this.taskOwner.getAITarget();
        int ownerLevel = ((EntityScapecraft)this.taskOwner).getLevel();
        int targetLevel = 0;
        this.lastRevengeTime = this.taskOwner.getRevengeTimer();
        if(target instanceof EntityScapecraft)
        {
            targetLevel = ((EntityScapecraft) target).getLevel();
        }
        else if(target instanceof EntityPlayer)
        {
            targetLevel = Stats.getCombatLevel((EntityPlayer) target);
        }
        int levelDifference = targetLevel - ownerLevel;
        int allyNum = 0;
        List list = null;
        if(this.allies.length > 0)
        {
            if (levelDifference > bravery)
            {
                double distance = this.getTargetDistance();
                list = this.taskOwner.worldObj.selectEntitiesWithinAABB(EntityScapecraft.class, AxisAlignedBB.getBoundingBox(this.taskOwner.posX, this.taskOwner.posY, this.taskOwner.posZ, this.taskOwner.posX + 1.0D, this.taskOwner.posY + 1.0D, this.taskOwner.posZ + 1.0D).expand(distance, 10.0D, distance), allySelector);
                //noinspection unchecked
                list.sort(heroSorter);
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
        Vec3 vec3 = null;
        if(levelDifference > bravery)
        {
            vec3 = RandomPositionGenerator.findRandomTargetBlockAwayFrom(this.taskOwner, (int) Math.sqrt(levelDifference) + 3, 4, target.getLookVec());
        }
        if(vec3 == null || this.taskOwner.getNavigator().tryMoveToXYZ(vec3.xCoord, vec3.yCoord, vec3.zCoord, 1 + Math.sqrt(levelDifference) / 10f))
        {
            this.taskOwner.setAttackTarget(target);
            for (int i = 0; i < allyNum; i++)
            {
                EntityScapecraft entity = ((EntityScapecraft) list.get(i));
                if (this.taskOwner != entity && entity.getAttackTarget() == null && !entity.isOnSameTeam(this.taskOwner.getAITarget()))
                {
                    entity.setAttackTarget(target);
                }
            }
            super.startExecuting();
        }
    }
}
