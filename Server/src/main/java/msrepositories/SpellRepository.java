package msrepositories;

import model.Spell;

import javax.transaction.Transactional;

@Transactional
public interface SpellRepository extends CardBaseRepository<Spell> {
}
