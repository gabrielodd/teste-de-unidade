package comment;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fullteaching.backend.comment.Comment;
import com.fullteaching.backend.user.User;

class CommentTest {
	User usuario;
	
	Comment comentario;
	Comment comentario2;
	Comment comentario3;
	List<Comment> comentarios;
	
	@BeforeEach
	void inicializa() {
		this.usuario = mock(User.class);
		
		this.comentario =  new Comment();
		this.comentario2 =  new Comment("Mensagem 1", 101010, usuario);
		this.comentario3 =  new Comment("Mensagem 2", 050505, usuario, comentario2);
	}
	
	@Test
	public void assertionComHamcrestMatcher() {
		assertThat(comentario2.getId(), notNullValue());
		assertThat(comentario2.getDate(), equalTo(101010L));
		assertThat(comentario2.getMessage(), containsString("Mensagem 1"));
		assertThat(comentario3.getCommentParent(), equalTo(comentario2));
		assertThat(comentario3.getReplies(), notNullValue());
		assertThat(comentario, instanceOf(Comment.class));
	}
	
	@Test
	public void testSetters() {
		comentario2.setId(500);
		assertEquals(comentario2.getId(), 500);
		
		comentario2.setMessage("Outra mensagem");
		assertEquals(comentario2.getMessage(), "Outra mensagem");
		
		comentario2.setDate(020202);
		assertEquals(comentario2.getDate(), 020202);

		User usuario2 = mock(User.class);
		comentario2.setUser(usuario2);
		assertEquals(comentario2.getUser(), usuario2);
		
		comentario3.setCommentParent(comentario);
		assertEquals(comentario3.getCommentParent(), comentario);
		
		comentario3.setReplies(comentarios);
		assertEquals(comentario3.getReplies(), comentarios);
	}
	
	@Test
	void testToString() {		
		String toString = "Comment[message: \"null\", author: \"\", parent: \"null\", #replies: 0date: \"0\"]";
		String toString2 = "Comment[message: \"Mensagem 1\", author: \"null\", parent: \"null\", #replies: 0date: \"101010\"]";
		String toString3 = "Comment[message: \"Mensagem 2\", author: \"null\", parent: \"Mensagem 1\", #replies: 0date: \"20805\"]";

		assertEquals(this.comentario.toString(), toString);
		assertEquals(this.comentario2.toString(), toString2);
		assertEquals(this.comentario3.toString(), toString3);
	}
	
}