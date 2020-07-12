import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String filename;
        float lat1, lon1;
        System.out.print("Enter the filename: ");
        filename = sc.next();
        List<Centres> CCentres = Load(filename);
        System.out.println("Displaying all the community centres: ");
        for (Centres c: CCentres)
        {
            System.out.println(c);
        }
        System.out.print("Enter latitude of your address: ");
        lat1 = sc.nextFloat();
        System.out.print("Enter longitude of your address: ");
        lon1 = sc.nextFloat();
        Distance nearest = new Distance(lat1, lon1, CCentres);
        List<Centres> nearCentres = nearest.near(CCentres);
        System.out.println("Community Centres that are 5km or less to your location are: ");
        for (Centres i: nearCentres)
        {
            i.toString2();
        }

    }
    private static List<Centres> Load(String filename)
    {
        String line = "";
        List<Centres> CCentres = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename)))
        {
            while ((line = br.readLine())!=null)
            {
                String[] data = line.split(",");
                if (!line.startsWith("F"))
                {
                    Centres centre = createCentre(data);
                    CCentres.add(centre);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return CCentres;
    }
    private static Centres createCentre(String[] data)
    {
        int FID = Integer.parseInt(data[0]);
        String address = data[1];
        String name = data[2];
        float X = Float.parseFloat(data[3]);
        float Y = Float.parseFloat(data[4]);

        return new Centres(FID, address, name, X, Y);
    }
}
