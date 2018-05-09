package api.mscontroller;

import api.model.Quest;
import api.msservices.IQuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
