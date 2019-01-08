package pl.bykowski.rectangleapp;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RectangleRepo extends CrudRepository<Rectangle, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM RECTANGLE rect WHERE (2*rect.height + 2*rect.width) >= :size")
    List<Rectangle> getBigRectangles(@Param("size") int size);

    @Query(nativeQuery = true, value = "SELECT * FROM RECTANGLE rect WHERE (2*rect.height + 2*rect.width) < :size")
    List<Rectangle> getSmallRectangles(@Param("size") int size);

}
