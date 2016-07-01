package scapecraft.compat.forgeessentials;

import com.forgeessentials.api.APIRegistry;
import com.forgeessentials.api.UserIdent;
import com.forgeessentials.api.remote.*;
import com.google.gson.JsonElement;
import net.minecraft.util.Tuple;
import net.minecraftforge.permission.PermissionLevel;
import scapecraft.util.Stat;
import scapecraft.util.Stats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by mraof on 2016 April 08 at 4:07 PM.
 */
@FERemoteHandler(id = "query_scskills")
public class SkillHandler extends GenericRemoteHandler<JsonElement>
{
    public final static String PERM = PERM_REMOTE + ".scapecraft.skill";
    public SkillHandler()
    {
        super(PERM, JsonElement.class);
        APIRegistry.perms.registerPermission(PERM, PermissionLevel.TRUE, "Allows seeing skills remotely");
        APIRegistry.perms.registerPermission(PERM + ".all", PermissionLevel.OP, "Allows seeing all skills remotely");
    }

    @Override
    protected RemoteResponse<?> handleData(RemoteSession session, RemoteRequest request)
    {
        HashMap<UUID, HashMap<Stat, Stats>> statMap;
        UUID playerUUID = session.getUserIdent().getUuid();
        if(APIRegistry.perms.checkUserPermission(session.getUserIdent(), PERM + ".all"))
        {
            statMap = new HashMap<UUID, HashMap<Stat, Stats>>(Stats.serverStats);
        }
        else
        {
            statMap = new HashMap<UUID, HashMap<Stat, Stats>>();
            statMap.put(playerUUID, Stats.serverStats.get(playerUUID));
        }
        ArrayList<Tuple> statList = new ArrayList<Tuple>();
        if(statMap.containsKey(playerUUID))
        {
            statList.add(new Tuple(session.getUserIdent().getUsernameOrUuid(), statMap.remove(playerUUID)));
        }

        for(Map.Entry<UUID, HashMap<Stat, Stats>> entry : statMap.entrySet())
        {
            statList.add(new Tuple(UserIdent.get(entry.getKey()).getUsernameOrUuid(), entry.getValue()));
        }

        return new RemoteResponse<ArrayList>(request, statList);
    }
}
