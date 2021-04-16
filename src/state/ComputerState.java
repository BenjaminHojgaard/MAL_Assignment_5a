package state;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ComputerState {
    Map<UUID, State> states = new HashMap<>();


    void addSnapshot(State state){
        states.put(UUID.randomUUID(), state);
    }

    Map<UUID, State> getStates() {
        return states;
    }

}
