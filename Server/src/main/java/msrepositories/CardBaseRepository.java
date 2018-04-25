package msrepositories;

import model.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface CardBaseRepository<T extends Card> extends CrudRepository<T, Long> {
    T findByName(String cardName);
}
