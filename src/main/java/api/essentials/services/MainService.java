package api.essentials.services;

import api.essentials.interfaces.IMainService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("MainServiceCloud")
public class MainService implements IMainService {

    @Override
    public String mainOperation() {
        return "Execute main operation";
    }
}
