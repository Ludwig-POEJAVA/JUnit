public class ChaineDeCaractere
{

	// Le tableau de char
	private char[] chars;
	// La taille courante
	private int size = 0;

	public ChaineDeCaractere(char[] chars)
	{
		this.chars = new char[chars.length];
		for (int i = 0; i < chars.length; i++ )
		{
			this.chars[i] = chars[i];
		}
		this.size = chars.length;
	}

	// Pour faciliter les tests
	public ChaineDeCaractere(String chars)
	{
		if (chars == null)
		{
			this.chars = new char[0];
			this.size = 0;
		}
		else
		{
			this.chars = new char[chars.length()];
			for (int i = 0; i < chars.length(); i++ )
			{
				this.chars[i] = chars.charAt(i);
			}
			this.size = chars.length();
		}
	}

	public ChaineDeCaractere concat(ChaineDeCaractere chaine)
	{
		if (chaine == null)
			return this;
		char[] resultat = new char[chaine.size() + this.size()];
		int i = 0, j = 0;
		for (; i < this.size; i++ )
		{
			resultat[i] = this.chars[i];
		}
		for (; j < chaine.size(); j++ )
		{
			resultat[i + j] = chaine.charAt(j);
		}
		return new ChaineDeCaractere(resultat);
	}

	public boolean startsWith(ChaineDeCaractere c)
	{
		if (c == null)
			return false;
		if (c.size() > this.size)
			return false;
		for (int i = 0; i < c.size(); i++ )
		{
			if (this.chars[i] != c.charAt(i))
				return false;
		}
		return true;
	}

	public boolean endsWith(ChaineDeCaractere c)
	{
		if (c == null)
			return false;
		if (c.size() > this.size)
			return false;
		for (int i = 1; i <= c.size(); i++ )
		{
			if (this.chars[this.size - i] != c.charAt(c.size() - i))
				return false;
		}
		return true;
	}

	public ChaineDeCaractere subChaine(int index, int length)
	{
		if ((length < 0) || (index < 0) || (index > (this.size - 1)))
			return new ChaineDeCaractere(new char[0]);
		int taille = length;
		if ((index + length) > this.size())
		{
			taille = this.size() - index;
		}
		char[] resultat = new char[taille];
		for (int i = 0; i < taille; i++ )
		{
			resultat[i] = this.chars[index + i];
		}
		return new ChaineDeCaractere(resultat);
	}

	public boolean contains(ChaineDeCaractere c)
	{
		if (c == null)
			return false;
		if (c.size() > this.size)
			return false;
		for (int i = 0; i <= (this.size() - c.size()); i++ )
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
	public boolean equals(Object o)
	{
		if (o == null)
			return false;
		if ( !(o instanceof ChaineDeCaractere))
			return false;
		ChaineDeCaractere c = (ChaineDeCaractere) o;
		if (c.size() != this.size)
			return false;
		for (int i = 0; i < this.chars.length; i++ )
		{
			if (this.chars[i] != c.charAt(i))
				return false;
		}
		return true;
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
		if (i < 0)
			return 0;
		if (i > (this.size - 1))
			return 0;
		return this.chars[i];
	}

}
