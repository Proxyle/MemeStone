package api.msrepositories;

import api.model.Quest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestRepository extends CrudRepository<Quest, Long> {
    Quest findByName(String name);
}
