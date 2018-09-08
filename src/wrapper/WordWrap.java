package wrapper;

public class WordWrap
{
    public String wrap(String string, int i)
    {
	// - Quito los espacios antes y despues
	// - Quito los espacios multiples
	string = string.trim().replaceAll(" +", " ");

	// Caso 1: la palabra entra
	if (string.length() <= i)
	{
	    return string;
	}

	// Caso 2: palabras multiples
	// Parandome en i, encuentro un caracter
	if (string.charAt(i) != ' ')
	{
	    // Busco el ultimo espacio dentro de mi substring
	    int pos = string.substring(0, i).lastIndexOf(" ");
	    
	    // Si no era una palabra larga (pos != -1), devuelvo hasta ese espacio
	    if (pos != -1)
	    {
		return string.substring(0, pos) + "\n" + wrap(string.substring(pos), i);
	    }
	}

	// Caso 3: 
	// - La palabra es muy larga y hay que cortarla
	// - O devuelvo hasta antes de un espacio
	return string.substring(0, i) + "\n" + wrap(string.substring(i), i);
    }
}
