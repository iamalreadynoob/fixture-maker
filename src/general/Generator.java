package general;

import maker.FixMake;
import maker.GroupMake;
import maker.KnockMake;
import maker.PlayoffMake;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Generator
{
    ArrayList<String> result;
    ArrayList<ArrayList<String>> groups;

    public Generator()
    {
        result = new ArrayList<>();
    }

    public void fixture(@NotNull Pool pool, boolean isTwice)
    {
        switch (pool.getType())
        {
            case CLASSIC: result = new FixMake(pool.getTeamIDs(), isTwice).getFixture(); break;
            case KNOCK_OUT: result = new KnockMake(pool.getTeamIDs() ,isTwice).getKnocked(); break;
            case PLAYOFF: result = new PlayoffMake(pool.getTeamIDs(), isTwice).getMatches(); break;
        }
    }

    public void grouper(@NotNull Pool pool, int amountGroup)
    {
        if (pool.getType() == RunType.GROUP) groups = new GroupMake(pool.getTeamIDs(), amountGroup).getGroups();
    }

    public ArrayList<String> getResult() {return result;}
    public ArrayList<ArrayList<String>> getGroups() {return groups;}
}
