public class CrappyString
{
	// Le tableau de char
	private char[] chars;
	// La taille courante
	private int size = 0;

	public CrappyString(char[] chars)
	{
		int taille = chars.length - 1;
		this.chars = new char[taille + 1];
		int i = 0;
		for (; i <= taille; i++ )
		{
			this.chars[i] = chars[i];
		}
		this.size = taille;
	}

	// Pour faciliter les tests
	public CrappyString(String chars)
	{
		if (chars == null)
		{
			chars = "";
		}
		int taille = chars.length() - 1;
		this.chars = new char[taille + 1];
		int i = 0;
		for (; i <= taille; i++ )
		{
			this.chars[i] = chars.charAt(i);
		}
		this.size = taille;
	}

	public CrappyString concat(CrappyString chaine)
	{
		char[] resultat = new char[chaine.size() + this.size()];
		int i = 0, j = 0;
		for (; i < this.size; i++ )
		{
			resultat[i] = this.chars[i];
		}
		for (; j < chaine.size(); j++ )
		{
			resultat[j + i + 1] = chaine.charAt(j);
		}
		return new CrappyString(resultat);
	}

	public boolean startsWith(CrappyString c)
	{
		for (int i = 0; i < c.size(); i++ )
		{
			if (this.chars[i] != c.charAt(i))
				return false;
		}
		return true;
	}

	public boolean endsWith(CrappyString c)
	{
		if (c.size() > this.size)
			return false;
		for (int i = 0; i <= c.size(); i++ )
		{
			if (this.chars[this.size - i] != c.charAt(c.size() - i))
				return false;
		}
		return true;
	}

	public CrappyString subChaine(int index, int length)
	{
		int taille = length;
		char[] resultat = new char[taille];
		for (int i = 0; i < taille; i++ )
		{
			resultat[i] = this.chars[index + i];
		}
		return new CrappyString(resultat);
	}

	public boolean contains(CrappyString c)
	{
		for (int i = 0; i < (this.size() - c.size()); i++ )
		{
			boolean identique = true;
			for (int j = 0; j < c.size(); j++ )
			{
				if (this.chars[i + j] != c.charAt(j))
				{
					identique = false;
					break;
				}
			}
			if (identique)
				return true;
		}
		return false;
	}

	@Override
	public String toString()
	{
		return new String(this.chars);
	}

	public int size()
	{
		return this.size;
	}

	public char charAt(int i)
	{
		if (i > (this.size - 1))
			return 0;
		return this.chars[i];
	}
	/**/
}
