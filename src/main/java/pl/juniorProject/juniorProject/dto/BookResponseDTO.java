package pl.juniorProject.juniorProject.dto;


import io.swagger.annotations.Info;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookResponseDTO {
    private Long id;
    private String title;
    private String isbn;
    private String description;


}
