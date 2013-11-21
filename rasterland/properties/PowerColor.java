package powell.rasterland.properties;

public enum PowerColor
{
	WHITE(0), RED(1), ORANGE(2), YELLOW(3), GREEN(4), BLUE(5), PURPLE(6);

	private int value;
	
	private PowerColor(int c)
	{
		value = c;
	}
	
	@Override public String toString() 
	{
		//only capitalize the first letter
		String s = super.toString();
		return s.substring(0, 1) + s.substring(1).toLowerCase();
	}
	
	public int getInt()
	{
		return value;
	}
}