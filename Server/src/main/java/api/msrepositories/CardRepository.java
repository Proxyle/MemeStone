package api.msrepositories;

import api.model.Card;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface CardRepository extends CardBaseRepository<Card> {
}
