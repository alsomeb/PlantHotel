import alternateVersionSwing.GreenestHotelApp;
import frontend.AlexPlantHotelApp;

public class Main {
    public static void main(String[] args) {
        // OOP för att komma ut ur en statisk kontext, behöver ej namnge objektet pga kommer ej ref den igen!
        new AlexPlantHotelApp();

        //new GreenestHotelApp(); //<-- Denna gjorde jag för skojs skull (Allt ligger i "alternateVersionSwing"), för att prova frontenden i SWING, STRUNTA i denna, mest för det fanns tid.
    }
}