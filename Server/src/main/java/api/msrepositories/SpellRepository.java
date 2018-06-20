package api.msrepositories;

import api.model.Spell;

import javax.transaction.Transactional;

@Transactional
public interface SpellRepository extends CardBaseRepository<Spell> {
}
