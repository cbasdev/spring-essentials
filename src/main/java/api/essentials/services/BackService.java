package api.essentials.services;

import api.essentials.interfaces.IMainService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("BackServiceCloud")
public class BackService implements IMainService {

    @Override
    public String mainOperation() {
        return "Execute back operation";
    }
}
