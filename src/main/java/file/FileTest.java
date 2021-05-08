package file;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fullteaching.backend.comment.Comment;
import com.fullteaching.backend.file.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class FileTest {
	File arquivo;
	File arquivo2;
	File arquivo3;
	File arquivo4;
	
	@BeforeEach
	public void inicializa() {
		arquivo = new File(1, "Arquivo PDF");
		arquivo2 = new File(0, "Arquivo web-link", "link");
		arquivo3 = new File(2, "Video", "link", 5);
		arquivo4 = new File();
	}
	
	@Test
	public void testEquals() {
		assertFalse(arquivo.equals(null));
		assertTrue(arquivo.equals(arquivo));
		
		Comment comentario = new Comment();
		assertFalse(arquivo.equals(comentario));
		
		assertTrue(arquivo.equals(arquivo2));
	}
	
	@Test
	public void assertionComHamcrestMatcher() {
		assertThat(arquivo.getId(), notNullValue());
		assertThat(arquivo.getType(), equalTo(1));
		assertThat(arquivo.getName(), containsString("Arquivo PDF"));
		assertThat(arquivo.getNameIdent(), notNullValue());
		assertThat(arquivo2.getLink(), containsString("link"));
		assertThat(arquivo3.getIndexOrder(), equalTo(5));
		assertThat(arquivo, instanceOf(File.class));
	}
	
	@Test
	public void testSetters() {
		arquivo.setId(500);
		assertEquals(arquivo.getId(), 500);
		
		arquivo3.setIndexOrder(7);
		assertEquals(arquivo3.getIndexOrder(), 7);
		
		arquivo.setName("Outro arquivo PDF");
		assertEquals(arquivo.getName(), "Outro arquivo PDF");
		
		arquivo.setNameIdent("Outro NameIdent");
		assertEquals(arquivo.getNameIdent(), "Outro NameIdent");
		
		arquivo2.setLink("Outro link");
		assertEquals(arquivo2.getLink(), "Outro link");
		
		arquivo.setType(2);
		assertEquals(arquivo.getType(), 2);
		
	}
}
