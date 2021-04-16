package state;

public class Main {
    public static void main(String[] args) {
        ComputerState computerState = new ComputerState();
        MappedState state1 = new MappedState();
        // X is undefined, so it cannot be a substate or superstate of any other state
        state1.put("x", new RangeValueSet(true, 0,0));

        MappedState state2 = new MappedState(state1);
        state2.put("x", new RangeValueSet(false, 0, 4));
        state2.put("y", new RangeValueSet(false, Integer.MIN_VALUE, 20));

        MappedState state3 = new MappedState(state2);
        state3.put("z", new RangeValueSet(false, 1,1));

        MappedState state4 = new MappedState(state3);
        state4.put("x", new RangeValueSet(false, 0, 1));
        state4.put("y", new RangeValueSet(false, 0, 20));

        System.out.println("Is State 4 a substate of state 3? - " + state4.subStateOf(state3));
        System.out.println("Is State 3 a substate of state 2? - " + state3.subStateOf(state2));
        System.out.println("Is State 2 a substate of state 1? - " + state2.subStateOf(state1));
        System.out.println("Is State 4 a substate of state 2? - " + state4.subStateOf(state2));
        System.out.println("Is State 1 a substate of state 4? - " + state1.subStateOf(state4));
        System.out.println("Is State 2 a substate of state 4? - " + state2.subStateOf(state4));

        computerState.addSnapshot(state1);
        computerState.addSnapshot(state2);
        computerState.addSnapshot(state3);
        computerState.addSnapshot(state4);

    }
}
