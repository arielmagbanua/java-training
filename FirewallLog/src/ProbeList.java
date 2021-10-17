import java.util.ArrayList;

public class ProbeList {
    // To store current number of probe
    int actualSize;
    // To store probe class objects
    Probe []probeArray;

    // Parameterized constructor
    ProbeList(int maxSize)
    {
        // Creates the array with parameter size
        probeArray = new Probe[maxSize];
        // Initially current size is 0
        actualSize = 0;
    }

    // Method to return maximum size
    int getMaxSize()
    {
        return probeArray.length;
    }

    // Method to return current size
    int getActualSize()
    {
        return actualSize;
    }

    // Method to insert a probe
    int insertProbe(Probe probe)
    {
        // Checks if actual size is less than the maximum size then returns -1
        if(actualSize == probeArray.length)
            return -1;

            // Otherwise assigns the parameter Probe class object
            // at actualSize index position
            // Increase the actualSize by one
        else
            probeArray[actualSize++] = probe;

        // Returns the actual size
        return actualSize;
    }

    // Method to counter and return number of parameter IP available in the probe array
    int countProbe(String ip)
    {
        // To store number of IP
        int counter = 0;
        // Loops till number of probes
        for(int c = 0; c < actualSize; c++)
            // Checks if current probe original IP is equals to parameter destIP
            if(probeArray[c].getOriginIP().equalsIgnoreCase(ip))
                // Increase the counter by one
                counter++;
        // Returns the counter
        return counter;
    }

    // Method to counter and return number of parameter destPort available
    // in the probe array
    int countProbe(int destPort)
    {
        // To store number of destination port
        int counter = 0;
        // Loops till number of probes
        for(int c = 0; c < actualSize; c++)
            // Checks if current probe destination port is equals to parameter destPort
            if(probeArray[c].getDestPort() == destPort)
                // Increase the counter by one
                counter++;
        // Returns the counter
        return counter;
    }

    ArrayList<String> getProbes(int destPort)
    {
        // Array list to store the original IP of those probes that is equals to destPort
        ArrayList<String> probes = new ArrayList<String>();
        // Loops till number of probes
        for(int c = 0; c < actualSize; c++)
            // Checks if current probe destination port is equals to parameter destPort
            if(probeArray[c].getDestPort() == destPort)
                // Adds the original IP of current probe
                probes.add(probeArray[c].getOriginIP());
        // Returns the counter
        // Returns the array list
        return probes;
    }

    ArrayList<Probe> getProbes(String ip)
    {
        // Array list to store the original IP of those probes that is equals to destPort
        ArrayList<Probe> probes = new ArrayList<Probe>();
        // Loops till number of probes
        for(int c = 0; c < actualSize; c++)
            // Checks if current probe original IP is equals to parameter destIP
            if(probeArray[c].getOriginIP().equalsIgnoreCase(ip))
                // Adds the probe object at c index position
                probes.add(probeArray[c]);
        // Returns the counter
        // Returns the array list
        return probes;
    }
}
