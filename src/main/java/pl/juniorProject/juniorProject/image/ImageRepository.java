package pl.juniorProject.juniorProject.image;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;

@Repository
@Data
public interface ImageRepository extends JpaRepository <Image, Long>
{



}
