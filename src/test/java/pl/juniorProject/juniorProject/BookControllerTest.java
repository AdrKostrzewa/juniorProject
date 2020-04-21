package pl.juniorProject.juniorProject;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.juniorProject.juniorProject.converter.BookConverter;
import pl.juniorProject.juniorProject.dto.BookResponseDTO;
import pl.juniorProject.juniorProject.model.Book;

import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    @Mock
    private BookConverter bookConverter;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void getAllBooksSuccess() throws Exception {
    when(bookService.findAll()).thenReturn(prepareMockData());
    when(bookConverter.convertToBookDTO(prepareMockData())).thenReturn(bookResponseDTOS());
    mockMvc.perform(get("/books"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json(JUnitHelper.convertObjectToJson(prepareMockData())));
    }

    @Test
    public void findBookByIdSuccess() throws Exception {
        Long id = 1L;
        when(bookService.findById(id)).thenReturn(java.util.Optional.ofNullable(prepareMockData().get(0)));
        when(bookConverter.convertToBookDTO(prepareMockData().get(0))).thenReturn(bookResponseDTOS().get(0));
        mockMvc.perform(get("/books/{id}", id))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json(JUnitHelper.convertObjectToJson(bookResponseDTOS().get(0))));
    }

    private List<BookResponseDTO> bookResponseDTOS(){
        return List.of(BookResponseDTO.builder().title("title1").isbn("isbn1").description("description1").id(1L).build(),
                BookResponseDTO.builder().title("title2").isbn("isbn2").description("description2").id(2L).build(),
                BookResponseDTO.builder().title("title3").isbn("isbn3").description("description3").id(3L).build());
    }

    private List<Book> prepareMockData(){
        return List.of(Book.builder().title("title1").isbn("isbn1").description("description1").id(1L).build(),
                Book.builder().title("title2").isbn("isbn2").description("description2").id(2L).build(),
                Book.builder().title("title3").isbn("isbn3").description("description3").id(3L).build());
    }


}