package entry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fullteaching.backend.comment.Comment;
import com.fullteaching.backend.entry.Entry;
import com.fullteaching.backend.user.User;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import java.util.List;

public class EntryTest {
	Entry entrada;
	Entry entrada2;
	User usuario;
	List<Comment> comentarios;
	
	@BeforeEach
	public void inicializa() {
		usuario = mock(User.class);
		entrada = new Entry("Titulo", 101010, usuario);
		entrada2 = new Entry();
	}
	
	@Test
	public void assertionComHamcrestMatcher() {
		assertThat(entrada.getId(), notNullValue());
		assertThat(entrada.getTitle(), containsString("Titulo"));
		assertThat(entrada.getUser(), instanceOf(User.class));
		assertThat(entrada.getDate(), equalTo(101010L));
		assertThat(entrada.getComments(), notNullValue());
		assertThat(entrada, instanceOf(Entry.class));
	}
	
	@Test
	public void testSetters() {
		entrada.setId(500);
		assertEquals(entrada.getId(), 500);
		
		entrada.setTitle("Outro titulo");
		assertEquals(entrada.getTitle(), "Outro titulo");
		
		entrada.setDate(050505);
		assertEquals(entrada.getDate(), 050505);
		
		User usuario2 = mock(User.class);
		entrada.setUser(usuario2);
		assertEquals(entrada.getUser(), usuario2);
		
		entrada.setComments(comentarios);
	}
}
