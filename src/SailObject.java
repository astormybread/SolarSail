public class SailObject extends CelestialBody{
    
   //This is a solar model of a celestial body with temperature and radius added
    
    private double epsilon = 0.9; // Reflectivity of the Sun as a percentage turned into decimal (where 1 would be 100% reflection, 0.5 would be 50%, etc.)
    private double area = 1000000; // Is the total surface area of the sail in m^2
    private double[] inclination = new double[imax]; // the inclination between the normal of the sail's area and the unit vector pointing at the sun
    private double fixInclination = 0.0174532925; // the amount by which the sail can adjust its sail every day, set to 1 degree by default
    
    /**
     * @param epsilon reflectivity contant of the sun (where for example,  1 would be 100% reflection and 0.5 would be 50% reflection)
     * @param area the total surface area of the sail in m^2
     * @param inclination inclination of the sail's surface's normal with respect to a unit vector pointing towards the Sun in rads
     **/
   
   
    public SailObject(String newValue, int i){
      super(newValue,i);
    }
    //////////////////////setters////////////////


    
     void setreflectivity(double newValue)
    {
        epsilon = newValue;
    }
    
    void setarea(double newValue)
    {
        area = newValue;
    }
    
    void setinclination(double newValue,int i)
    {
        inclination[i] = newValue;
    }
    
    void setfixInclination(double newValue){
        
        fixInclination = newValue;
        
    }
    ///////getters//////////////////////////
    
    double epsilon()
    {
      return epsilon ;
    }
    
    double area()
    {
     return  area ;
    }
    
    double inclination(int i)
    {
        return inclination[i];
    }
    
    double fixInclination(){
        
        return fixInclination;
    }
    
}