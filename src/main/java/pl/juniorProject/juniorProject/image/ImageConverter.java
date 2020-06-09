package pl.juniorProject.juniorProject.image;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.juniorProject.juniorProject.dto.ImageResponseDTO;

import java.awt.*;

@Component
@RequiredArgsConstructor
public class ImageConverter {
    private final ModelMapper modelMapper;

    @Autowired
    public ImageConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ImageResponseDTO convertToImageDTO (Image image){
        return modelMapper.map(image, ImageResponseDTO.class);
    }


}
