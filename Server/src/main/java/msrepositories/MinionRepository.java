package msrepositories;

import model.Minion;

import javax.transaction.Transactional;

@Transactional
public interface MinionRepository extends CardBaseRepository<Minion> {
}
