package pl.juniorProject.juniorProject.image;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.juniorProject.juniorProject.model.Image;

import java.awt.*;

@Repository
public interface ImageRepository extends JpaRepository <Image, Long>
{



}
