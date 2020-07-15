import java.util.ArrayList;
import java.util.List;

public class Distance {
    private float lat1;
    private float lon1;
    private List<Centres> cCentres;

    //overloaded constructor to set values
    public Distance(float lat1, float lon1, List<Centres> cCentres)
    {
        this.lat1 = lat1;
        this.lon1 = lon1;
        this.cCentres = cCentres;

    }

    //create a list for the nearest community centres
    public List<Centres> near(List<Centres> cCentres)
    {
        List<Centres> closest = new ArrayList<Centres>();
        for(Centres i: cCentres)
        {
            //latitude and longitude for each centre
            float lat2 = i.getY();
            float lon2 = i.getX();
            //distance
            double dist = calcDist(lat2, lon2, cCentres);
            if(dist<=5)
            {
                Centres near = new Centres(i.getFID(), i.getAddress(), i.getname(), i.getX(), i.getY(), dist);
                closest.add(near);
            }
        }
        return closest;
    }

    //calculate distances
    public double calcDist(float lat2, float lon2, List<Centres> cCentres)
    {
        double theta = lon1 - lon2;
        double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;     //km
        return (dist);
    }

}
