package pl.juniorProject.juniorProject.image.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.juniorProject.juniorProject.dto.ImageResponse;
import pl.juniorProject.juniorProject.model.Image;

import java.util.List;

@Mapper
public interface ImageMapper {

    ImageMapper INSTANCE = Mappers.getMapper(ImageMapper.class);

    ImageResponse toImageResponse(Image car);

    List<ImageResponse> toImageResponse(List<Image> car);
}