package api.mscontroller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@RestController
@RequestMapping(value="/{playerId}/collection")
public class CollectionController {
    @RequestMapping(method= RequestMethod.GET)
    public String getCollection(@PathVariable String playerId) {
        throw new NotImplementedException();
    }
}
