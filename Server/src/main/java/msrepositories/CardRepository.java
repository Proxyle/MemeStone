package msrepositories;

import model.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CardRepository extends CrudRepository<Card, Long> {
    @Query("SELECT c FROM Card c WHERE LOWER(c.name) = LOWER(:cardName)")
    Card findByName(@Param("cardName") String cardName);
}
