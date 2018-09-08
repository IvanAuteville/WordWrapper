package wrapper;

import org.junit.Assert;
import org.junit.Test;

public class WordWrapTest
{

    @Test
    public void notNull()
    {
	Assert.assertNotNull(new WordWrap());
    }

    @Test
    public void casoSimple()
    {
	WordWrap w = new WordWrap();
	Assert.assertEquals("", w.wrap("", 1));
	Assert.assertEquals("palabra", w.wrap("palabra", 7));
    }

    @Test
    public void casoSupera()
    {
	WordWrap w = new WordWrap();
	Assert.assertEquals("aa", w.wrap("aa       ", 10));
	Assert.assertEquals("palabro\nta", w.wrap("palabrota", 7));
    }

    @Test
    public void casoMultiple()
    {
	WordWrap w = new WordWrap();
	Assert.assertEquals("casa\ncasa", w.wrap("casa casa", 4));
	Assert.assertEquals("casa\ncaso\nna", w.wrap("casa casona", 4));
	Assert.assertEquals("casa\ncasa", w.wrap("casa           casa", 5));
    }

    @Test
    public void casoCompleto()
    {
	WordWrap w = new WordWrap();
	Assert.assertEquals("BATTLEFIELD™ V LLEGA\nEL 20 DE NOVIEMBRE DE\n2018 PARA XBOX ONE,\nPLAYSTATION®4 Y PC", w
		.wrap("BATTLEFIELD™ V            LLEGA EL 20 DE NOVIEMBRE       DE 2018 PARA XBOX ONE, PLAYSTATION®4 Y PC",
			21));
    }
}