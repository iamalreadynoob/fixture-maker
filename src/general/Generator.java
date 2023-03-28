package general;

import maker.FixMake;
import maker.KnockMake;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Generator
{
    ArrayList<String> result;

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
        }
    }

    public ArrayList<String> getResult() {return result;}
}
