package session;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fullteaching.backend.comment.Comment;
import com.fullteaching.backend.course.Course;
import com.fullteaching.backend.session.Session;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import java.util.List;

public class SessionTest {
	Session sessao;
	Session sessao2;
	Session sessao3; //Sessão Vazia
	Course curso;
	
	@BeforeEach
	public void inicializa() {
		curso = mock(Course.class);
		
		sessao = new Session("Titulo", "Descrição", 101010);
		sessao2 = new Session("Titulo", "Descrição", 101010, curso);
		sessao3 = new Session();

	}
	
	@Test
	public void testEquals() {
		assertFalse(sessao.equals(null));
		assertTrue(sessao.equals(sessao));
		assertFalse(sessao.equals(curso));
		assertTrue(sessao.equals(sessao2));
	}
	
	@Test
	public void assertionComHamcrestMatcher() {
		assertThat(sessao.getId(), notNullValue());
		assertThat(sessao.getTitle(), containsString("Titulo"));
		assertThat(sessao.getDate(), equalTo(101010L));
		assertThat(sessao.getDescription(), containsString("Descrição"));
		assertThat(sessao, instanceOf(Session.class));
	}
	
	@Test
	public void testSetters() {
		sessao.setId(500);
		assertEquals(sessao.getId(), 500);
		
		sessao.setTitle("Outro titulo");
		assertEquals(sessao.getTitle(), "Outro titulo");
		
		sessao.setDescription("Outra descrição");
		assertEquals(sessao.getDescription(), "Outra descrição");
		
		sessao.setDate(050505);
		assertEquals(sessao.getDate(), 050505);
		
		sessao2.setCourse(curso);
		assertEquals(sessao2.getCourse(), curso);
	}
}
