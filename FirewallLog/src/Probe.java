class Probe
{
    // Instance variables to store probe information
    private int destPort;
    private String originIP;
    private int originPort;
    private String probeTime;

    // Parameterized constructor
    public Probe(int desport, String ip, int oriport, String time)
    {
        destPort = desport;
        originIP = ip;
        originPort = oriport;
        probeTime = time;
    }

    // Getter methods
    public int getDestPort()
    {
        return destPort;
    }

    public String getOriginIP()
    {
        return originIP;
    }

    public int getOriginPort()
    {
        return originPort;
    }

    public String getProbeTime()
    {
        return probeTime;
    }

    // Overrides method to return probe information
    public String toString()
    {
        return "\n IP " + originIP + " sent a packet from port " + originPort +
                " to port " + destPort;
    }
}
