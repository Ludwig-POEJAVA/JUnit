import org.junit.Test;

import junit.framework.TestCase;

public class TestChaineStagiaire extends TestCase
{
	@Test
	public void testInit()
	{
		CrappyString c;
		String s = null;
		c = new CrappyString(s);
		assertEquals(c.toString(), "");
	}

	@Test
	public void testConcat()
	{
		CrappyString o1;
		CrappyString o2;
		String str1;
		String str2;
		CrappyString res;

		str1 = "ABC";
		str2 = "123";

		o1 = new CrappyString(str1);
		o2 = new CrappyString(str2);

		res = o1.concat(o2);
		assertEquals(res.toString(), "ABC123");
		res = o1.concat(o1);
		assertEquals(res.toString(), "ABCABC");
		res = o2.concat(o2);
		assertEquals(res.toString(), "123123");
		o2 = null;
		res = o1.concat(o2);
		assertEquals(res.toString(), "ABC");

		str1 = null;
		str2 = null;

		o1 = new CrappyString(str1);
		o2 = new CrappyString(str2);
		res = o1.concat(o2);
		assertEquals(res.toString(), "");
	}

	@Test
	public void testSize()
	{
		CrappyString obj;
		String str;
		int objSize;
		char[] chars;

		//constructor 1

		//	test : une moyenne chaine -> size()
		str = "Ť̛̀h̸̛͜͡ï̢͠ş̛͘͜͜͜ ̶͏í́̕͡͝͠ș͘͠ ̸͝ẃ͜h̴̕͞ã̶̕ț̸̀͝ ̧̨̀͢҉ç̴̨͠ø̛̀͝m̛̛͏̧̕b̨̡î̡̛̕͜͡ñ̛͞ę̷̛͞ř̷͜ ͏̛å҉͟b̵̡͜ű͏̡̛ś̴̕ȩ̈̕͢ ̨̧́͞ļ́͢͡͏͢ō҉͘͢ṑ͞k̸̨̛͢ș̷͘͟͠͡ ͠҉̨̛͜ĺ̴҉̧̀ı̷̡͢͜͠k̸͞ê̶̷̷̵!̵Ä̴̷̙̟̫̰͉͚̬̻͚͕̮̜̗̳̗̪̳̪͍ͬ͛̐ͤ͢͞͡Bͫͪͮ͊̓̍ͤͧͥͩͫ̔̌̔̅̊͗҉̛̖̟̦̫̟̺̣͉͓̕͞ͅU̶̘̫̳̙̠̽ͤ̔̆ͥ̍̚̕͡͠͡S̊̍͑͊ͯͣͧͯ̉̐͏̸̞̗̭̯̼̟̤̘̠̟̦͙͙́͢͞Ḛ̴̢̦̟̥̖̋ͫͨ̇̀ͭͧ͋̽ͯ͒̉̾ͮͯ̍̚̚?̸̸͉͚͎̬̞͕̼͔̜͚̥̓̇̏̀̋̏͗̈́̀̓̐̾̀̚͘͠";
		obj = new CrappyString(str);
		objSize = obj.size();
		assertEquals(objSize, 327);//je triche

		//	test : une moyenne chaine -> size()
		str = "12345678901234567890";
		obj = new CrappyString(str);
		objSize = obj.size();
		assertEquals(objSize, 20);

		//	test : une chaine vide -> size()
		str = "";
		obj = new CrappyString(str);
		objSize = obj.size();
		assertEquals(objSize, 0);

		//	test : un caractère échapé -> size()
		str = "\\";
		obj = new CrappyString(str);
		objSize = obj.size();
		assertEquals(objSize, 1);

		//constructor 2

		//	test : une petite chaine -> size()
		chars = new char[] {48, 49, 50, 51 };
		obj = new CrappyString(chars);
		objSize = obj.size();
		assertEquals(objSize, 4);

		//	test : une chaine monocaractere -> size()
		chars = new char[] {0 };
		obj = new CrappyString(chars);
		objSize = obj.size();
		assertEquals(objSize, 1);

		//	test : une chaine vide -> size()
		chars = new char[] {};
		obj = new CrappyString(chars);
		objSize = obj.size();
		assertEquals(objSize, 0);
	}

	@Test
	public void testCharAt()
	{

		CrappyString obj;
		String str;
		char objCharAt;
		char[] chars;

		//constructor 1

		//	test : une caractère au pif -> charAt()
		str = "1234567890*234567890x";
		obj = new CrappyString(str);
		objCharAt = obj.charAt(0);
		assertEquals(objCharAt, '1');
		objCharAt = obj.charAt(20);
		assertEquals(objCharAt, objCharAt, 'x');

		//	test :le caractère vide en position 0-> charAt()
		str = "";
		obj = new CrappyString(str);
		objCharAt = obj.charAt(0);
		assertEquals(objCharAt, 0);

		//	test : une caractère échappé en bonne position -> charAt()
		str = "\\";
		obj = new CrappyString(str);
		objCharAt = obj.charAt(0);
		assertEquals(objCharAt, '\\');

		//constructor 2

		//	test : tous les caractères d'une petite chaine -> charAt()
		chars = new char[] {48, 49, 50, 51 };
		obj = new CrappyString(chars);
		objCharAt = obj.charAt(0);
		assertEquals(objCharAt, 48);
		objCharAt = obj.charAt(1);
		assertEquals(objCharAt, 49);
		objCharAt = obj.charAt(2);
		assertEquals(objCharAt, 50);
		objCharAt = obj.charAt(3);
		assertEquals(objCharAt, 51);
		objCharAt = obj.charAt(4);
		assertEquals(objCharAt, 0);

		//	test : le premier caractère , le caractère en pos -1 -> charAt()
		chars = new char[] {65 };
		obj = new CrappyString(chars);
		objCharAt = obj.charAt(1);
		assertEquals(objCharAt, 0);
		objCharAt = obj.charAt(0);
		assertEquals(objCharAt, 'A');

		//	test : le premier caractère , le caractère en pos -1 -> charAt()
		chars = new char[] {};
		obj = new CrappyString(chars);
		objCharAt = obj.charAt(80);
		assertEquals(objCharAt, 0);
		objCharAt = obj.charAt( -1);
		assertEquals(objCharAt, 0);

	}

	@Test
	public void testStartsWith()
	{
		String str1;
		String str2;
		CrappyString o1;
		CrappyString o2;
		boolean b;

		str1 = "babar le roi des éléphants";
		o1 = new CrappyString(str1);
		str2 = "babar le";
		o2 = new CrappyString(str2);
		b = o1.startsWith(o2);
		assertEquals(b, true);

		str2 = "babar la";
		o2 = new CrappyString(str2);
		b = o1.startsWith(o2);
		assertEquals(b, false);

		str2 = str1;
		o2 = new CrappyString(str2);
		b = o1.startsWith(o2);
		assertEquals(b, true);

		str2 += 1;
		o2 = new CrappyString(str2);
		b = o1.startsWith(o2);
		assertEquals(b, false);

		o2 = null;
		b = o1.startsWith(o2);
		assertEquals(b, false);

		str2 = null;
		o2 = new CrappyString(str2);
		b = o1.startsWith(o2);
		assertEquals(b, true);
	}

	@Test
	public void testEndsWith()
	{

		String str1;
		String str2;
		CrappyString o1;
		CrappyString o2;
		boolean b;

		str1 = "babar le roi des éléphants";
		o1 = new CrappyString(str1);
		str2 = "i des éléphants";
		o2 = new CrappyString(str2);
		b = o1.endsWith(o2);
		assertEquals(b, true);

		str2 = "i des éléphant";
		o2 = new CrappyString(str2);
		b = o1.endsWith(o2);
		assertEquals(b, false);

		str2 = "o des éléphants";
		o2 = new CrappyString(str2);
		b = o1.endsWith(o2);
		assertEquals(b, false);

		str2 = str1;
		o2 = new CrappyString(str2);
		b = o1.endsWith(o2);
		assertEquals(b, true);

		str2 = "" + 1 + str2;
		o2 = new CrappyString(str2);
		b = o1.endsWith(o2);
		assertEquals(b, false);

		o2 = null;
		b = o1.endsWith(o2);
		assertEquals(b, false);

		str2 = null;
		o2 = new CrappyString(str2);
		b = o1.endsWith(o2);
		assertEquals(b, true);

	}

	@Test
	public void testContains()
	{

		String str1;
		String str2;
		CrappyString o1;
		CrappyString o2;
		boolean b;

		str1 = "babar le roi des éléphants";
		o1 = new CrappyString(str1);
		str2 = "babar le";
		o2 = new CrappyString(str2);
		b = o1.contains(o2);
		assertEquals(b, true);

		str1 = "babar le roi des éléphants";
		o1 = new CrappyString(str1);
		str2 = str1;
		o2 = new CrappyString(str2);
		b = o1.contains(o2);
		assertEquals(b, true);

		//espace insecable au milieu
		str1 = "babar le roi des éléphants";
		o1 = new CrappyString(str1);
		str2 = "babar le roi des éléphants";
		o2 = new CrappyString(str2);
		b = o1.contains(o2);
		assertEquals(b, false);

		str1 = "babar le roi des éléphants";
		o1 = new CrappyString(str1);
		str2 = "babar le roi des éléphants de la jungle";
		o2 = new CrappyString(str2);
		b = o1.contains(o2);
		assertEquals(b, false);

		str1 = "babar le roi des éléphants";
		o1 = new CrappyString(str1);
		str2 = null;
		o2 = new CrappyString(str2);
		b = o1.contains(o2);
		assertEquals(b, true);

		str1 = null;
		o1 = new CrappyString(str1);
		str2 = null;
		o2 = new CrappyString(str2);
		b = o1.contains(o2);
		assertEquals(b, true);

		str1 = null;
		o1 = new CrappyString(str1);
		str2 = "babar le roi des éléphants";
		o2 = new CrappyString(str2);
		b = o1.contains(o2);
		assertEquals(b, false);

		o1 = new CrappyString(str1);
		o2 = null;
		b = o1.contains(o2);
		assertEquals(b, false);
	}

	@Test
	public void testSubchaine()
	{
		String str;
		char[] chars;
		CrappyString obj;
		CrappyString sub;
		int index;
		int length;

		//ChaineDeCaractereStagiaire subChaine(int index, int length)

		str = "La boite à Lambertz";
		obj = new CrappyString(str);

		index = 0;
		length = 3;
		sub = obj.subChaine(index, length);
		assertEquals(sub.toString(), "La ");

		index = 11;
		length = 8;
		sub = obj.subChaine(index, length);
		assertEquals(sub.toString(), "Lambertz");

		index = -5;
		length = 8;
		sub = obj.subChaine(index, length);
		assertEquals(sub.toString(), Character.toString((char) 0));
		assertEquals(sub.toString(), "");

		str = "0123456789ABCDEF";
		obj = new CrappyString(str);
		index = 10;
		length = 900000;
		sub = obj.subChaine(index, length);
		assertEquals(sub.toString(), "ABCDEF");

		index = 10;
		length = 20;
		sub = obj.subChaine(index, length);
		assertEquals(sub.toString(), "ABCDEF");

		index = 10;
		length = -20;
		sub = obj.subChaine(index, length);
		assertEquals(sub.toString(), "");
	}

	@Test
	public void testEquals()
	{

		String str1;
		String str2;
		CrappyString o1;
		CrappyString o2;
		Object ob;
		boolean b;

		str1 = "babar le roi des éléphants";
		o1 = new CrappyString(str1);
		str2 = "babar le";
		o2 = new CrappyString(str2);
		b = o1.equals(o2);
		assertEquals(b, false);

		str1 = "babar le roi des éléphants";
		o1 = new CrappyString(str1);
		str2 = str1;
		o2 = new CrappyString(str2);
		b = o1.equals(o2);
		assertEquals(b, true);

		//espace insecable au milieu
		str1 = "babar le roi des éléphants";
		o1 = new CrappyString(str1);
		str2 = "babar le roi des éléphants";
		o2 = new CrappyString(str2);
		b = o1.equals(o2);
		assertEquals(b, false);

		str1 = "babar le roi des éléphants";
		o1 = new CrappyString(str1);
		str2 = "babar le roi des éléphants de la jungle";
		o2 = new CrappyString(str2);
		b = o1.equals(o2);
		assertEquals(b, false);

		str1 = "babar le roi des éléphants";
		o1 = new CrappyString(str1);
		str2 = null;
		o2 = new CrappyString(str2);
		b = o1.equals(o2);
		assertEquals(b, false);

		str1 = null;
		o1 = new CrappyString(str1);
		str2 = null;
		o2 = new CrappyString(str2);
		b = o1.equals(o2);
		assertEquals(b, true);

		str1 = null;
		o1 = new CrappyString(str1);
		str2 = "babar le roi des éléphants";
		o2 = new CrappyString(str2);
		b = o1.equals(o2);
		assertEquals(b, false);

		str1 = "babar le roi des éléphants";
		o1 = new CrappyString(str1);
		o2 = null;
		b = o1.equals(o2);
		assertEquals(b, false);

		str1 = "babar le roi des éléphants";
		o1 = new CrappyString(str1);
		ob = new Object();
		b = o1.equals(ob);
		assertEquals(b, false);

	}/**/
}
