package api.msservices.implementation;

import api.model.Quest;
import api.msrepositories.QuestRepository;
import api.msservices.IQuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestService implements IQuestService {
    @Autowired
    public QuestRepository questRepository;

    @Override
    public Quest getByName(String name) {
        Quest quest;
        try {
            quest = questRepository.findByName(name);
        } catch (Exception e) {
            return null;
        }
        return quest;
    }
}
