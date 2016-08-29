public class Cannonballs
{
	public static void main(String[] args)
	{
		int baseSize;
		int height;
		int cannonballs = Integer.parseInt(args[0]);
		baseSize = minBase(cannonballs);
		height = levelsNeeded(cannonballs, baseSize);
		System.out.println("Base: "+baseSize);
		System.out.println("Height: "+height);
	}

	public static int levelsize(int level)
	{
		return level*level;
	}

	public static int pilesize(int level)
	{
		return levelsize(level)+pilesize(level-1);
	}

	public static int minBase(int balls)
	{
		int levels = 0;
		while(balls > 0)
		{
			levels++;
			balls = balls - levelsize(levels);
		}
		return levels;
	}

	public static int levelsNeeded(int balls, int base)
	{
		int levelsUsed = 0;
		while(balls > 0)
		{
			balls = balls - levelsize(base);
			levelsUsed++;
			base--;
		}
		return levelsUsed;
	}
}