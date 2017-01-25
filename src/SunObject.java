public  class SunObject extends CelestialBody{
    
   //This is a solar model of a celestial body with temperature and radius added
    
    
    private double solarradius;
    private double temperature;
    
     void setr(double newValue)
    {
        solarradius = newValue;
    }
    
    void sett(double newValue)
    {
        temperature = newValue;
    }
    
    
    
    double temperature()
    {
      return temperature ;
    }
    
    double solarradius()
    {
     return  solarradius ;
    }
    
}