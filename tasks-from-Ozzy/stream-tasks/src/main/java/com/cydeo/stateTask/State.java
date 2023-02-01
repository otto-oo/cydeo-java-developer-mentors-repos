package com.cydeo.stateTask;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Data
@RequiredArgsConstructor
public class State {

    private List<String> cities = new ArrayList<>();


    public void addCity(String city) {
        cities.add(city);
    }

    public List<String> getCities() {
        return cities;
    }
}

class StateData {

    public static List<State> getAllStates() {
        State alabama = new State();
        alabama.addCity("Montgomery");
        alabama.addCity("Birmingham");


        State alaska = new State();
        alaska.addCity("Juneau");
        alaska.addCity("Anchorage");

        State california = new State();
        california.addCity("Sacramento");
        california.addCity("Los Angeles");

        State kansas = new State();
        kansas.addCity("Topeka");
        kansas.addCity("Wichita");

        return Arrays.asList(
                alabama, alaska, california, kansas
        );
    }
}

class StateTest{
    public static void main(String[] args) {
        StateData.getAllStates()
                .stream().map(State::getCities)
                .flatMap(Collection::stream)
                .forEach(System.out::println);
    }
}
