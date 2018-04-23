package mscontroller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@RestController
@RequestMapping(value="/{userId}/collection")
public class CollectionController {
    @RequestMapping(method= RequestMethod.GET)
    public String getCollection(@PathVariable String userId) {
        throw new NotImplementedException();
    }
}
