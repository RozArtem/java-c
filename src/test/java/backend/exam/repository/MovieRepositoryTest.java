package backend.exam.repository;

import backend.exam.org.domain.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(statements = "delete from movie" , executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void testMovie() {

        Movie c = new Movie();
        c = movieRepository.save(c);
        assertNotNull(c.getId());
        assertTrue(movieRepository.findById(c.getId()).isPresent());
    }
}