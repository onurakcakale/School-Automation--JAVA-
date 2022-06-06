package OkulOtomasyon;

public class Private_degisken 
{
    private int x;
    private int y;

    Private_degisken(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    int getX() 
    {
        return x;
    }

    int getY() 
    {
        return y;
    }

    double distanceFromZero() 
    {
        return distanceFromPoint(new Private_degisken(0, 0));
    }

    double distanceFromPoint(Private_degisken point) 
    {
        int distX = point.getX()-this.x;
        int distY = point.getY()-this.y;

        return (double) Math.sqrt(Math.pow(distX, 2)+Math.pow(distY, 2));
    }

    public static void main(String[] args) 
    {

    }
}