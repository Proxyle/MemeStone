package api.msservices;

import api.model.Quest;

public interface IQuestService {
    Quest getByName(String name);
}
