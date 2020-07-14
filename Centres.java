//contains all the fields/attributes of the community centres that are listed in the file
public class Centres
{
    private int FID;
    private String address;
    private String name;
    private float X;
    private float Y;
    private double dist;        //distance between user-entered lat/long and community centres

    //overloaded constructor
    public Centres(int FID, String address, String name, float X, float Y)
    {
        this.FID = FID;
        this.address = address;
        this.name = name;
        this.X = X;
        this.Y = Y;
    }
    //used when distance is calculated
    public Centres(int FID, String address, String name, float X, float Y, double dist)
    {
        this.FID = FID;
        this.address = address;
        this.name = name;
        this.X = X;
        this.Y = Y;
        this.dist = dist;
    }
    //get methods
    public int getFID()
    {
        return FID;
    }
    public String getAddress()
    {
        return address;
    }
    public String getname()
    {
        return name;
    }
    public float getX()
    {
        return X;
    }
    public float getY()
    {
        return Y;
    }
    public double getDist()
    {
        return dist;
    }

    //set methods
    public void setFID(int FID)
    {
        this.FID = FID;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public void setname(String name)
    {
        this.name = name;
    }
    public void setX(float X)
    {
        this.X = X;
    }
    public void setY(float Y)
    {
        this.Y = Y;
    }
    public void setDist(int dis)
    {
        this.dist = dis;
    }

    //override toString
    public String toString()
    {
        return "FID: " + FID + ", Address: " + address + ", Name: " + name + ", X: " + X + ", Y: " + Y;
    }
    //to print out distances
    public void toString2()
    {
        System.out.println("FID: " + FID + ", Address: " + address + ", Name: " + name + ", X: " + X + ", Y: " + Y + ", Distance (in km): " + dist);
    }

}
