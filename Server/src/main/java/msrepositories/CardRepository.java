package msrepositories;

import model.Card;

import javax.transaction.Transactional;

@Transactional
public interface CardRepository extends CardBaseRepository<Card> {
}
