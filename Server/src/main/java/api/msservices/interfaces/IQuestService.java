package api.msservices.interfaces;

import api.model.Quest;

import java.util.List;

public interface IQuestService {
    Quest getByName(String name);
    Quest getRandomQuest();
    List<Quest> getAllQuests();
}
