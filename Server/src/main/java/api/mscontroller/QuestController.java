package api.mscontroller;

import api.model.Quest;
import api.msservices.interfaces.IQuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quest")
public class QuestController {
    @Autowired
    private IQuestService questService;

    @GetMapping(value = "/{questName}")
    public ResponseEntity<Quest> getQuestByName(@PathVariable("questName") String questName) {
        Quest quest = questService.getByName(questName);
        if (quest == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(quest, HttpStatus.OK);
    }

    @GetMapping(value = "/new")
    public ResponseEntity<Quest> getNewQuest() {
        Quest quest = questService.getRandomQuest();
        if (quest == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(quest, HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Quest>> getAllQuests() {
        List<Quest> quests = questService.getAllQuests();
        if (quests == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(quests, HttpStatus.OK);
    }
}
