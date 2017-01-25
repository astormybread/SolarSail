public  abstract class CelestialBody{
    private static String name;
     private static double mass;    //mass
    private double x;       // position on the x-axis
    private double y;       // position on the y-axis
    private double[] v = new double[2];
    // v[0];      // x-component of velocity
    // v[1];      // y-component of velocity
    private double ax = 0;  // x-component of acceleration
    private double ay = 0;  // y-component of acceleration

//////////////////CONSTRUCTORS//////////////////////



    public CelestialBody(String newValue)
    {
        name = newValue;
    }

    void setm(double newValue)
    {
        mass = newValue;
    }

    void setx(double newValue)
    {
        x = newValue;
    }

    void sety(double newValue)
    {
        y = newValue;
    }

    void setvx(double newValue)
    {
        v[0] = newValue;
    }

    void setvy(double newValue)
    {
        v[1] = newValue;
    }

    void setax(double newValue)
    {
        ax = newValue;
    }

    void setay(double newValue)
    {
        ay = newValue;
    }

//////////////////////////////////////////////////

///////////////ACCESSORS/////////////////////////


    double m()
    {
      return mass ;
    }

    double x()
    {
     return  x ;
    }

    double y()
    {
     return  y ;
    }

    double vx()
    {
      return v[0] ;
    }

    double vy()
    {
      return v[1] ;
    }

    double ax()
    {
     return  ax;
    }

    double ay()
    {
      return ay ;
    }

/////////////////////////////////////////

}

