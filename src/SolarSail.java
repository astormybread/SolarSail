
public class SolarSail{

///////////////////////////Constants/////////////////////////////////////////

  final static  double c = 3E8; // speed of light in meters/second
  final static double stefanboltz = 5.6703E-8; // in Watts/(m^2*K^4)
  final static double g = 6.67E-11; // Gravitational Constant in (N*m^2)/(Kg^2)
  final static double AU = 149597871; // length of one astronomical Unit in km
  final static int dt = 86400; // one day in seconds
  final static int imax = (int)(40*365.25); // number of years you want the simulation to run



  public static void main(String arg[]){




////////////////////////////////////////////////////////////////////////////////
//                          CELESTIAL BODIES                                  //
////////////////////////////////////////////////////////////////////////////////

/**
 THIS MODEL uses ephemeris data FOR YEAR 2020 OF FEBRUARY 1st 05:27 and the data
 is derivedfrom Ephemeris calculations by Alcyon Ephemeris 4.3 software (+ve
 x-axis goes from vernal equinox earth to Sun and y-axis is 90 degrees following
 right handwhile the mass data is taken from NASA website.
**/




    SunObject sun = new SunObject("sun", imax);
    CelestialBody mercury = new CelestialBody("mercury", imax);
    CelestialBody venus = new CelestialBody("venus", imax);
    CelestialBody earth = new CelestialBody("earth", imax);
    CelestialBody mars = new CelestialBody("mars", imax);
    CelestialBody ceres = new CelestialBody("ceres", imax);
    CelestialBody pallas = new CelestialBody("pallas", imax);
    CelestialBody juno = new CelestialBody("juno", imax);
    CelestialBody jupiter = new CelestialBody("jupiter", imax);
    CelestialBody saturn = new CelestialBody("saturn", imax);
    CelestialBody uranus = new CelestialBo,0dy("uranus", imax);
    CelestialBody neptune = new CelestialBody("neptune", imax);
    CelestialBody pluto = new CelestialBody("pluto", imax);
    SailObject sail = new SailObject("sail", imax);

 CelestialBody[]  celestialbodyarray = {sun,mercury,venus,earth,mars,ceres,pallas,juno,jupiter,saturn,uranus,neptune,pluto}; //This is simply an array that contains all the above objects in it
 // note the array does not contain the CelestialBody SailObject subclass because its effects on other bodies will be negligeable and so we will save ourselves many needless calculations
 
 
///////////////////////////Sun Data//////////////////////////////////////////

    sun.setm(1.98855E30); // mass of the Sun in kg
    sun.setr(695800000.); // Radius of the sun in meters
    sun.sett(5778.); // Surface Temperature in Kelvins of the Sun
    sun.setx(0.0,0); // X-cooridinate of the Sun
    sun.sety(0.0,0); // Y-coordinate of the sun
////////////////////////Mercury Data//////////////////////////////////////////

    mercury.setm(3.3010E23); // mass of Mercury in kg
    mercury.setx(0.3287109E3*AU,0); // INITIAL distance on x-axis from the sun in m
    mercury.sety(0.0830574E3*AU,0); // INITIAL distance on y-axis from the sun in m
    mercury.setvx(-21.46433E3,0); // INITIAL  velocity on x-axis relative to the sun in m/s
    mercury.setvy(49.33479E3,0); // INITIAL velocity on y-axis relative to the sun in m/s
    mercury.setr(2439.7E3);    // Mean radius in meters

////////////////////////Venus Data//////////////////////////////////////////

    venus.setm(4.8673E24); // mass of Mercury in kg
    venus.setx(0.4175777E3*AU,0); // INITIAL distance on x-axis from the sun in m
    venus.sety(0.5890271E3*AU,0); // INITIAL distance on y-axis from the sun in m
    venus.setvx(-28.69043E3,0); // INITIAL  velocity on x-axis relative to the sun in m/s
    venus.setvy(20.08491E3,0); // INITIAL velocity on y-axis relative to the sun in m/s
    venus.setr(6051.8E3);    // Mean radius in meters

////////////////////////Earth Data////////////////////////////////////////////

    earth.setm(5.9722E24); //mass of the Earth in kg
    earth.setx(-0.6595378E3*AU,0); // INITIAL distance on x-axis from the sun in m
    earth.sety(0.7319421E3*AU,0); // INITIAL distance on y-axis from the sun in m
    earth.setvx(-22.60193E3,0); // INITIAL  velocity on x-axis relative to the sun in m/s
    earth.setvy(-20.07241E3,0); // INITIAL velocity on y-axis relative to the sun in m/s
    earth.setr(6371E3);    // Mean radius in meters

////////////////////////MOON?- COMING SOON  //////////////////////////////////////////


////////////////////////Mars Data/////////////////////////////////////////////

    mars.setm(6.4169E23); //mass ofMars in kg
    mars.setx(-1.0072218E3*AU,0); // INITIAL distance on x-axis from the sun in m
    mars.sety(-1.1814551E3*AU,0); // INITIAL distance on y-axis from the sun in m
    mars.setvx(19.34207E3,0); // INITIAL  velocity on x-axis relative to the sun in m/s
    mars.setvy(-13.63487E3,0); // INITIAL velocity on y-axis relative to the sun in m/s
    mars.setr(3389.5E3);    // Mean radius in meters
    
////////////////////////1 Ceres Data/////////////////////////////////////////////

    ceres.setm(9.47E20); //mass of 1-Ceres in kg
    ceres.setx(1.3031563E3*AU,0); // INITIAL distance on x-axis from the sun in m
    ceres.sety(-2.26069823E3*AU,0); // INITIAL distance on y-axis from the sun in m
    ceres.setvx(15.16524E3,0); // INITIAL  velocity on x-axis relative to the sun in m/s
    ceres.setvy(5.35596E3,0); // INITIAL velocity on y-axis relative to the sun in m/s
    ceres.setr(476.2E3);    // Mean radius in meters
////////////////////////2 Pallas Data/////////////////////////////////////////////

    pallas.setm(2.11E20); //mass of 2-Pallas in kg (data from google)
    pallas.setx(-0.3388292E3*AU,0); // INITIAL distance on x-axis from the sun in m
    pallas.sety(-2.5888546E3*AU,0); // INITIAL distance on y-axis from the sun in m
    pallas.setvx(14.75699E3,0); // INITIAL  velocity on x-axis relative to the sun in m/s
    pallas.setvy(-3.13607E3,0); // INITIAL velocity on y-axis relative to the sun in m/s
    pallas.setr(272E3);    // Mean radius in meters
////////////////////////3 Juno Data/////////////////////////////////////////////

    juno.setm(2.67E19); //mass of 3-Juno in kg (data from google)
    juno.setx(-2.9174132E3*AU,0); // INITIAL distance on x-axis from the sun in m
    juno.sety(-0.1571614E3*AU,0); // INITIAL distance on y-axis from the sun in m
    juno.setvx(-2.93902E3,0); // INITIAL  velocity on x-axis relative to the sun in m/s
    juno.setvy(-13.07529E3,0); // INITIAL velocity on y-axis relative to the sun in m/s
    juno.setr(116.5E3);    // Mean radius in meters
////////////////////////Jupiter Data/////////////////////////////////////////

    jupiter.setm(1.8981E27); //mass of Jupiter in kg
    jupiter.setx(0.7841558E3*AU,0); // INITIAL distance on x-axis from the sun in m
    jupiter.sety(-5.1568154E3*AU,0); // INITIAL distance on y-axis from the sun in m
    jupiter.setvx(12.76972E3,0); // INITIAL  velocity on x-axis relative to the sun in m/s
    jupiter.setvy(2.58312E3,0); // INITIAL velocity on y-axis relative to the sun in m/s
    jupiter.setr(69911E3);    // Mean radius in meters
////////////////////////Saturn Data/////////////////////////////////////////

    saturn.setm(5.6832E26); //mass of Saturn in kg
    saturn.setx(3.9946564E3*AU,0); // INITIAL distance on x-axis from the sun in m
    saturn.sety(-9.2013962E3*AU,0); // INITIAL distance on y-axis from the sun in m
    saturn.setvx(8.33991E3,0); // INITIAL  velocity on x-axis relative to the sun in m/s
    saturn.setvy(3.81962E3,0); // INITIAL velocity on y-axis relative to the sun in m/s
    saturn.setr(58232E3);    // Mean radius in meters

////////////////////////Uranus Data/////////////////////////////////////////

    uranus.setm(8.6810E25); //mass of Uranus in kg
    uranus.setx(16.0971228E3*AU,0); // INITIAL distance on x-axis from the sun in m
    uranus.sety(11.5532974E3*AU,0); // INITIAL distance on y-axis from the sun in m
    uranus.setvx(-4.00721E3,0); // INITIAL  velocity on x-axis relative to the sun in m/s
    uranus.setvy(5.21728E3,0); // INITIAL velocity on y-axis relative to the sun in m/s
    uranus.setr(25362E3);    // Mean radius in meters

////////////////////////Neptune Data/////////////////////////////////////////

    neptune.setm(1.0241E26); //mass of Neptune in kg
    neptune.setx(29.2936390E3*AU,0); // INITIAL distance on x-axis from the sun in m
    neptune.sety(-6.1266735E3*AU,0); // INITIAL distance on y-axis from the sun in m
    neptune.setvx(1.08974E3,0); // INITIAL  velocity on x-axis relative to the sun in m/s
    neptune.setvy(5.35655E3,0); // INITIAL velocity on y-axis relative to the sun in m/s
    neptune.setr(24622E3);    // Mean radius in meters
////////////////////////Pluto Data/////////////////////////////////////////

    pluto.setm(1.3090E22); //mass of Pluto in kg
    pluto.setx(13.2237527E3*AU,0); // INITIAL distance on x-axis from the sun in m
    pluto.sety(-31.2887513E3*AU,0); // INITIAL distance on y-axis from the sun in m
    pluto.setvx(5.15046E3,0); // INITIAL  velocity on x-axis relative to the sun in m/s
    pluto.setvy(0.96292E3,0); // INITIAL velocity on y-axis relative to the sun in m/s
    pluto.setr(1151E3);    // Mean radius in meters


/////////////////////////////////////////////////////////////////////////////
///////////////////////    Solar Sail Parameters    /////////////////////////
/////////////////////////////////////////////////////////////////////////////



    sail.setreflectivity(0.9); // Reflectivity of the Sun as a percentage turned into decimal (where 1 would be 100% reflection, 0.5 would be 50%, etc.)
    // double absorption = (1. - epsilon); // the absorption rate of the incident light - Probably not important
    // double reflection = (1. + epsilon); // the reflection rate of the incident light - Probably not important
    sail.setm(1); // mass of the solar sail in Kg
    sail.setarea(1000000); // Is the total surface area of the sail in m^2
    double angleearth = angle(earth,sun,0); // Angle from x-axis to earth
    double heightsail = 9000E3; // height in m from surface of Earth when program begins
    double vescape = Math.sqrt(2.*g*earth.m()/heightsail); // escape velocity at height "heightsail"
    sail.setx(earth.x(0) + Math.cos(angleearth)*heightsail,0); // INITIAL distance on x-axis from the sun in m starts in opposition
    sail.sety(earth.y(0) + Math.sin(angleearth)*heightsail,0); // INITIAL distance on y-axis from the sun in m starts in opposition
    sail.setvx(earth.vx(0) + vescape*Math.cos(angleearth),0) ; // INITIAL  velocity on x-axis relative to the sun in m/s including escape velocity relative to earth
    sail.setvy(earth.vy(0) + vescape*Math.sin(angleearth),0) ; // INITIAL velocity on y-axis relative to the sun in m/s including escape velocity relative to earth
    sail.setinclination(angle(sail,sun,0),0); // sets the inclination of the sail relative to the unit vector pointing at the sun
    double radiationpressureconstant = sail.area*stefanboltz*Math.pow(sun.temperature(),4)*Math.pow(sun.solarradius(),2)/c; // constant that will remain the same at every iteration of radiation pressure equation




//////////////////////////TESTTING///////////////////

    long startTime = System.currentTimeMillis();

    for(int interval = 1 ; interval < imax ; interval++){
        
        for(int body ; body <= celestialbodyarray.length ; body++)
            {
                updateAll(body,celestialbodyarray,dt,interval); // update every body
            }
            //Given the difficulty of adjusting sails, Every day the sail can adjust its inclination by up to one degree 
            if(sail.inclination - angle(sail,sun) < sail.fixInclination()){
                sail.inclination += Math.max(sail.fixInclination(),Math.abs(sail.inclination - angle(sail,sun)));
            }
            else if(sail.inclination - angle(sail,sun) > sail.fixInclination()){
                sail.inclination -= Math.max(sail.fixInclination(),Math.abs(sail.inclination - angle(sail,sun)));
            }
            updateAll(sail,sun,celestialbodyarray,dt,interval); // update the Solar Sail at the end
        
        long finishTime = System.currentTimeMillis();
        System.out.println("By day: " + interval + "\nthis much time has passed: "+(finishTime-startTime)+ " ms\n\n");
        
    }

  }
  
  
//////////////////////////////////////////////////////////////////////////////////////////////////////
//////////                         RELATIVE POSITION METHODS                                //////////
//////////////////////////////////////////////////////////////////////////////////////////////////////


  public static  double distancex(CelestialBody object1 , CelestialBody object2,int i){

     double distancex = object2.x(i)-object1.x(i); // horizontal distance FROM object 1 to object 2
      return distancex;

  }

  public static double distancey(CelestialBody object1 , CelestialBody object2,int i){

      double distancey = object2.y(i)-object1.y(i); // vertical distance FROM object 1 to object 2
      return distancey;

  }

  public static double distance(CelestialBody object1 , CelestialBody object2,int i){

    double distance =  Math.hypot(distancex(object1 ,object2,i),distancey(object1 ,object2,i)); // total distance FROM object 1 to object 2
      return distance;

  }
  
  public static double xside(CelestialBody object1 , CelestialBody object2,int i){
      
      double xside = distancex(object1,object2,i)/Math.abs(distancex(object1,object2,i)) // gives us +ve 1 or -ve 1 and dictates whether object 2 is on the right or on the left of object1
      return xside;
      
  }
  
   public static double yside(CelestialBody object1 , CelestialBody object2,int i){
      
      double yside = distancey(object1,object2,i)/Math.abs(distancey(object1,object2,i)) // gives us +ve 1 or -ve 1 and dictates whether object 2 is above or under object1
      return yside;
      
  }

  public static double angle(CelestialBody object1 , CelestialBody object2,int i){

    double angle = Math.abs(Math.atan(distancey(object1 ,object2,i)/distancex(object1 ,object2,i))); // angle between object 1 and object 2
      return angle;

  }

//////////////////////////////////////////////////////////////////////////////////////////////////////////
///////                             GRAVITY METHODS                                                ///////
//////////////////////////////////////////////////////////////////////////////////////////////////////////


  public static double gravitypull (CelestialBody object1 , CelestialBody object2,int i){

      double gravitationalforce; // gravitational pull between objects

      gravitationalforce = g*object1.m()*object2.m()/Math.pow(distance(object1,object2,i),2); // calculates the force of gravity acting between two objects

	return gravitationalforce;
  }
  
  public static double gravitypullx (CelestialBody object1 , CelestialBody object2,int i){

      double gravitationalforcex; // x-component of gravitational pull on object 1

      gravitationalforcex = gravitypull(object1,object2,i)*Math.cos(angle(object1,object2,i))*xside(object1,object2,i); // calculates the x-component of the force of gravity acting between two objects

    return gravitationalforcex;

  }

  public static double gravitypully (CelestialBody object1 , CelestialBody object2,int i){

      double gravitationalforcey; // y-component of gravitational pull on object 1

      gravitationalforcey = gravitypull(object1,object2,i)*Math.sin(angle(object1,object2,i))*yside(object1,object2,i); // calculates the y-component of the  force of gravity acting between two objects

      return gravitationalforcey;

  }
  
  public static double sumgravitypullx (CelestialBody object1 ,CelestialBody[] objects,int j){
      
      // return the sum of gravitaional x-pull from all objects from the array on object1
      // makes sure it doesn't calculate gravity on itself (that would be infinity!)
      
      double sumgravitypullx = 0;
      
      for (int i = 0; i < objects.length ; i++ ){
          if(object1 != objects[i]){
            sumgravitypullx += gravitypullx(object1,objects[i],j);
          }
      }
      return sumgravitypullx;
  }
  
   public static double sumgravitypully (CelestialBody object1 ,CelestialBody[] objects,int j){
      
      // return the sum of gravitaional y-pull from all objects from the array on object1
      // makes sure it doesn't calculate gravity on itself (that would be infinity!)
      
      double sumgravitypully = 0;
      
      for (int i = 0; i < objects.length ; i++ ){
          if(object1 != objects[i]){
            sumgravitypully += gravitypully(object1,objects[i],j);
          }
      }
      return sumgravitypully;
  }
  
//////////////////////////////////////////////////////////////////////////////////////////////////////////
///////                        RADIATION PRESSURE METHODS                                          ///////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  public static double ForceOnSailx(SailObject sail, SunObject sun,int i){
      
      //Area*SolarConstant/Speed of Light * [(1-reflectivity)s_hat + (1+reflectivity)n_hat] where Area*solarConstant/(distance^2*c) is radiationpressureconstant
      
      double forcex = radiationpressureconstant/Math.pow(distance(sail,sun,i),2)*((1-sail.epsilon())*Math.cos(angle(sail,sun,i))*xside(sun,sail,i) + (1+sail.epsilon())*Math.cos(angle(sail,sun,i)+sail.inclination(i))*xside(sun,sail,i);
      return forcex;
  }
  
  
  public static double ForceOnSaily(SailObject sail, SunObject sun,int i){
      
      //Area*SolarConstant/Speed of Light * [(1-reflectivity)s_hat + (1+reflectivity)n_hat] where Area*solarConstant/(distance^2*c) is radiationpressureconstant
      
      double forcey = radiationpressureconstant/Math.pow(distance(sail,sun,i),2)*((1-sail.epsilon())*Math.sin(angle(sail,sun,i))*yside(sun,sail,i) + (1+sail.epsilon())*Math.sin(angle(sail,sun,i)+sail.inclination(i))*yside(sun,sail,i);
      return forcey;
  }
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////                          Position Update Methods                                        /////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public  static  void  setAccelerationX(SailObject sail, SunObject sun,  CelestialBody[] objectarray,int i){
        //calculates acceleration on solar sail where gravity and radiation pressure are the forces. a=F/m
        sail.setax((sumgravitypullx(sail,objectarray,i) + ForceOnSailx(sail,sun,i))/sail.m(),i);
    }

    public  static  void setAccelerationY(SailObject sail, SunObject sun, CelestialBody[] objectarray,int i){
        //calculates acceleration on solar sail where gravity and radiation pressure are the forces. a=F/m
        sail.setay((sumgravitypully(sail,objectarray,i) + ForceOnSaily(sail,sun, i)/sail.m(),i);
    }


    public  static  void  setAccelerationX(CelestialBody object, CelestialBody[] objectarray,int i){
        //calculates acceleration on objects where gravity is only force. a=F/m
        object.setax(sumgravitypullx(object,objectarray,i)/object.m(),i);
    }

    public  static  void setAccelerationY(CelestialBody object, CelestialBody[] objectarray,int i){
        //calculates acceleration on objects where gravity is only force. a=F/m
        object.setay(sumgravitypully(object,objectarray,i)/object.m(),i);
    }
    
    public static void setVelocityX(CelestialBody object, int dt,int i){
        // Velocity at each increment will be updated using Verlet numerical method for velocity where Vn2 = Vn1 +1/2(An2+An1)*dt 
        //where A is acceleration and V is velocity and n2 is current increment and n1 is last increment
        
        object.setvx(object.vx(i-1)+0.5*dt*(object.ax(i)+object.ax(i-1)),i);
        
    }
  
        public static void setVelocityY(CelestialBody object, int dt,int i){
        // Velocity at each increment will be updated using Verlet numerical method for velocity where Vn2 = Vn1 +1/2(An2+An1)*dt 
        //where A is acceleration and V is velocity and n2 is current increment and n1 is last increment
        
        object.setvy(object.vy(i-1)+0.5*dt*(object.ay(i)+object.ay(i-1)),i);
        
    }
    
    public static void setPositionX(CelestialBody object, int dt, int i){
        // Verlet method for updating position is Xn2 = Xn1 + Vn1*dt + (1/2)*An1*(dt)^2
        // where A is acceleration, v is velocity and X is position and n2 is curent increment while n1 is last increment
        
        object.setx(object.x(i-1)+object.vx(i-1)*dt + 0.5*object.ax(i-1)*(dt*dt),i);
        
    }
        public static void setPositionY(CelestialBody object, int dt, int i){
        // Verlet method for updating position is Yn2 = Yn1 + Vn1*dt + (1/2)*An1*(dt)^2
        // where A is acceleration, v is velocity and Y is position and n2 is curent increment while n1 is last increment
        
        object.sety(object.y(i-1)+object.vy(i-1)*dt + 0.5*object.ay(i-1)*(dt*dt),i);
        
    }
  
  
     public static void updateAll(CelestialBody object, CelestialBody[] objectarray, int dt, int i){
         
         // simply updates all acceleration,velocity and position components at current increment
         setAccelerationX(object,i);
         setAccelerationY(object,i);
         setVelocityX(object,dt,i);
         setVelocityY(object,dt,i);
         setPositionX(object,dt,i);
         setPositionY(object,dt,i);
         
     }
  
     public static void updateAll(SailObject sail,SunObject sun, CelestialBody[] objectarray, int dt, int i){
         
         // simply updates all acceleration,velocity and position components at current increment
         // specifically for the solar sail
         setAccelerationX(sail,sun,objectarray,i);
         setAccelerationY(sail,sun,objectarray,i);
         setVelocityX(sail,dt,i);
         setVelocityY(sail,dt,i);
         setPositionX(sail,dt,i);
         setPositionY(sail,dt,i);
         
     }
  
}