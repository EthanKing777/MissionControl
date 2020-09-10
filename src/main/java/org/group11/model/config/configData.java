package org.group11.model.config;

public class configData {

    private Double LAT = 0.0;
    private Double LOG = 0.0;
    private final Boolean autoSwitch;
    private final Boolean runSim;


    public configData(Double lat, Double log, Boolean autoSwitch, Boolean runSim) {
        this.LAT = lat;
        this.LOG = log;
        this.autoSwitch = autoSwitch;
        this.runSim = runSim;
    }

    public Double getLAT() {
        return LAT;
    }

    public Double getLOG() {
        return LOG;
    }

}
