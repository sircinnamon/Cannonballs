public class TriCannonballs
{
	public static void main(String[] args)
	{
		int baseSize;
		int height;
		long cannonballs = Long.parseLong(args[0]);
		baseSize = minBase(cannonballs);
		height = levelsNeeded(cannonballs, baseSize);
		System.out.println("Base: "+baseSize + " ("+levelsize(baseSize)+")");
		System.out.println("Height: "+height);
	}

	public static long levelsize(int level)
	{
		long answer = 0;
		if(level == 1){return 1;}
		while(level > 0)
		{
			answer = answer + level;
			level--;
		}
		return answer;
		//return level+levelsize(level-1);
	}

	public static long levelsize(int level, long prev, boolean asc)
	{
		if(asc){return level + prev;}
		else{return prev-(level+1);}
	}

	public static long pilesize(int level)
	{
		return levelsize(level)+pilesize(level-1);
	}

	public static int minBase(long balls)
	{
		int levels = 0;
		long lvl = 0;
		while(balls > 0)
		{
			levels++;
			lvl = levelsize(levels,lvl,true);
			balls = balls - lvl;
			//System.out.println(lvl);
		}
		//System.out.println("base found");
		return levels;
	}

	public static int levelsNeeded(long balls, int base)
	{
		int levelsUsed = 0;
		long lvl = levelsize(base+1);
		while(balls > 0)
		{
			lvl = levelsize(base,lvl,false);
			balls = balls - lvl;
			//System.out.println(balls);
			levelsUsed++;
			base--;
		}
		//System.out.println("height found");
		return levelsUsed;
	}
}