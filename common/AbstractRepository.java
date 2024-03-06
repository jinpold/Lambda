package common;

import enums.Messenger;

import java.io.IOException;
import java.util.Map;

public abstract class AbstractRepository {

    public abstract Map<String, ?> save (Map<String, ?> paraMap) throws IOException;

    public abstract Map<String, ?> saveMelon (Map<String, ?> paraMap) throws IOException;


}
