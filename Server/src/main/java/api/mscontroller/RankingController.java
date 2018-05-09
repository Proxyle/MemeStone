package api.mscontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@RestController
@RequestMapping(value="/ranking")
public class RankingController {
    @RequestMapping(method= RequestMethod.GET)
    public String getAll() {
        throw new NotImplementedException();
    }
}
