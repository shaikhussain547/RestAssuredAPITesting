package DeserializeConcept;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {

    public int year;
    public double price;

    @JsonProperty("CPU model")
    public String cpuModel;

    @JsonProperty("Hard disk size")
    public String hardDiskSize;

}
