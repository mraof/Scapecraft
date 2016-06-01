package scapecraft.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.MathHelper;
import scapecraft.entity.EntityScapecraft;

/**
 * Created by mraof on 2016 March 24 at 11:17 PM.
 */
public class EntityAIAttackWithDistance extends EntityAIBase
{
    private EntityScapecraft attacker;
    private PathEntity entityPathEntity;
    private int retargetTime;
    private int attackTick;
    int failedPathFindingPenalty;
    private double x;
    private double y;
    private double z;
    private double speed;
    private final double distance;

    public EntityAIAttackWithDistance(EntityScapecraft attacker, double speed, double distance)
    {
        this.attacker = attacker;
        this.speed = speed;
        this.distance = distance;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    @Override
    public boolean shouldExecute()
    {
        EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();

        if (entitylivingbase == null)
        {
            return false;
        }
        else if (!entitylivingbase.isEntityAlive())
        {
            return false;
        }
        else
        {
            if (-- this.retargetTime <= 0)
            {
                this.entityPathEntity = this.attacker.getNavigator().getPathToEntityLiving(entitylivingbase);
                this.retargetTime = 4 + this.attacker.getRNG().nextInt(7);
                return this.entityPathEntity != null;
            }
            else
            {
                return true;
            }
        }
    }

    @Override
    public boolean continueExecuting()
    {
        EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
        return (entitylivingbase != null) && (entitylivingbase.isEntityAlive() && (this.attacker.isWithinHomeDistance(MathHelper.floor_double(entitylivingbase.posX), MathHelper.floor_double(entitylivingbase.posY), MathHelper.floor_double(entitylivingbase.posZ))));
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    @Override
    public void startExecuting()
    {
        this.attacker.getNavigator().setPath(this.entityPathEntity, this.speed);
        this.retargetTime = 0;
    }

    @Override
    public void resetTask()
    {
        this.attacker.getNavigator().clearPathEntity();
    }

    @Override
    public void updateTask()
    {
        EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
        this.attacker.getLookHelper().setLookPositionWithEntity(entitylivingbase, 30.0F, 30.0F);
        double posY;
        if ((entitylivingbase.boundingBox.minY > attacker.boundingBox.minY) && ((entitylivingbase.boundingBox.minY - this.attacker.height) < this.attacker.boundingBox.minY))
        {
            posY = (entitylivingbase.boundingBox.minY > this.attacker.boundingBox.maxY) ? (entitylivingbase.boundingBox.minY - this.attacker.height) : this.attacker.boundingBox.minY;
        }
        else if (entitylivingbase.boundingBox.minY > this.attacker.boundingBox.maxY)
        {
            posY = (entitylivingbase.boundingBox.minY - this.attacker.height);
        }
        else
        {
            posY = entitylivingbase.boundingBox.minY;
        }
        double d0 = this.attacker.getDistanceSq(entitylivingbase.posX, posY, entitylivingbase.posZ);
        double d1 = (attacker.width / 2 + distance + entitylivingbase.width / 2);
        d1 *= d1;
        --this.retargetTime;

        if (this.retargetTime <= 0 && (this.x == 0.0D && this.y == 0.0D && this.z == 0.0D || entitylivingbase.getDistanceSq(this.x, this.y, this.z) >= 1.0D || this.attacker.getRNG().nextFloat() < 0.05F))
        {
            this.x = entitylivingbase.posX;
            this.y = entitylivingbase.boundingBox.minY;
            this.z = entitylivingbase.posZ;
            this.retargetTime = failedPathFindingPenalty + 4 + this.attacker.getRNG().nextInt(7);

            if (this.attacker.getNavigator().getPath() != null)
            {
                PathPoint finalPathPoint = this.attacker.getNavigator().getPath().getFinalPathPoint();
                if (finalPathPoint != null && entitylivingbase.getDistanceSq(finalPathPoint.xCoord, finalPathPoint.yCoord, finalPathPoint.zCoord) < 1)
                {
                    failedPathFindingPenalty = 0;
                }
                else
                {
                    failedPathFindingPenalty += 10;
                }
            }
            else
            {
                failedPathFindingPenalty += 10;
            }

            if (d0 > 1024.0D)
            {
                this.retargetTime += 10;
            }
            else if (d0 > 256.0D)
            {
                this.retargetTime += 5;
            }

            if (!this.attacker.getNavigator().tryMoveToEntityLiving(entitylivingbase, this.speed))
            {
                this.retargetTime += 15;
            }
        }

        this.attackTick = Math.max(this.attackTick - 1, 0);

        if (d0 <= d1 && this.attackTick <= 20)
        {
            this.attackTick = 20;

            if (this.attacker.getHeldItem() != null)
            {
                this.attacker.swingItem();
            }

            this.attacker.attackEntityAsMob(entitylivingbase);
        }
    }
}
