package mscontroller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@RestController
@RequestMapping(value="/cards")
public class CardController {
    @RequestMapping(method= RequestMethod.GET)
    public String getAllCards(){
        throw new NotImplementedException();
    }

    @RequestMapping(method= RequestMethod.GET, value="/{cardId}")
    public String getCardById(@PathVariable String cardId){
        throw new NotImplementedException();
    }

    @RequestMapping(method= RequestMethod.GET, value="/{cardName}")
    public String getCardByName(@PathVariable String cardName){
        throw new NotImplementedException();
    }
}
