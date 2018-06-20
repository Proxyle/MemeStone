package api.msservices;

import api.model.Quest;
import api.msrepositories.QuestRepository;
import api.msservices.interfaces.IQuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    @Override
    public Quest getRandomQuest() {
        List<Quest> quests = new ArrayList<>();
        try {
            questRepository.findAll().forEach(q -> quests.add(q));
        } catch (Exception e) {
            return null;
        }
        Random random = new Random();
        int randomNumber = random.nextInt(quests.size());
        return quests.get(randomNumber);
    }

    @Override
    public List<Quest> getAllQuests() {
        List<Quest> quests = new ArrayList<>();
        try {
            questRepository.findAll().forEach(q -> quests.add(q));
        } catch (Exception e) {
            return null;
        }
        return quests;
    }
}
