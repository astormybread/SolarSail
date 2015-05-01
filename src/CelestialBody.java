public class CelestialBody{
    String name;
    double mass;    //mass
    double x;       // position on the x-axis
    double y;       // position on the y-axis
    double vx;      // x-component of velocity
    double vy;      // y-component of velocity
    double ax = 0;  // x-component of acceleration
    double ay = 0;  // y-component of acceleration
    
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
        vx = newValue;
    }
    
    void setvy(double newValue)
    {
        vy = newValue;
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
      return vx ;
    }
    
    double vy()
    {
      return vy ;
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