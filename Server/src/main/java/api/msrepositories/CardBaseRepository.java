package api.msrepositories;

import api.model.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface CardBaseRepository<T extends Card> extends CrudRepository<T, Long> {
    Card findByName(String cardName);
}
