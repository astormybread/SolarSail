
public class SolarSail{
  public static void main(String arg[]){


///////////////////////////Constants/////////////////////////////////////////
   
  final double c = 3E8; // speed of light in meters/second
  final double stefanboltz = 5.6703E-8; // in Watts/(m^2*K^4)
  final double g = 6.67E-11; // Gravitational Constant in (N*m^2)/(Kg^2)
  final double AU = 149597871E3; // length of one astronomical Unit in m
   
   
   
////////////////////////////////////////////////////////////////////////////////
//                          CELESTIAL BODIES                                  //     
////////////////////////////////////////////////////////////////////////////////

/** 
 THIS MODEL uses ephemeris data FOR YEAR 2020 OF FEBRUARY 1st 05:27 and the data
 is derivedfrom Ephemeris calculations by Alcyon Ephemeris 4.3 software (+ve
 x-axis goes from vernal equinox earth to Sun and y-axis is 90 degrees following 
 right handwhile the mass data is taken from NASA website.
**/



///////////////////////////Sun Data//////////////////////////////////////////

   double  msun = 1.98855E30; // mass of the Sun in kg
   double rsun = 695800000.; // Radius of the sun in meters
   double tsun = 5778.; // Surface Temperature in Kelvins of the Sun
   double xsun = 0.0; // X-cooridinate of the Sun
   double ysun = 0.0; // Y-coordinate of the sun


////////////////////////Mercury Data//////////////////////////////////////////

    double mmercury = 3.3010E23; // mass of Mercury in kg
    double xmercury = 0.3287109E3*AU; // INITIAL distance on x-axis from the sun in m
    double ymercury = 0.0830574E3*AU; // INITIAL distance on y-axis from the sun in m
    double vxmercury = -21.46433E3; // INITIAL  velocity on x-axis relative to the sun in m/s
    double vymercury = 49.33479E3; // INITIAL velocity on y-axis relative to the sun in m/s

////////////////////////Venus Data//////////////////////////////////////////

    double mvenus = 4.8673E24; // mass of Mercury in kg
    double xvenus = 0.4175777E3*AU; // INITIAL distance on x-axis from the sun in m
    double yvenus = 0.5890271E3*AU; // INITIAL distance on y-axis from the sun in m
    double vxvenus = -28.69043E3; // INITIAL  velocity on x-axis relative to the sun in m/s
    double vyvenus = 20.08491E3; // INITIAL velocity on y-axis relative to the sun in m/s
    

////////////////////////Earth Data////////////////////////////////////////////   
   
    double mearth = 5.9722E24; //mass of the Earth in kg
    double xearth = -0.6595378E3*AU; // INITIAL distance on x-axis from the sun in m
    double yearth = 0.7319421E3*AU; // INITIAL distance on y-axis from the sun in m
    double vxearth = -22.60193E3; // INITIAL  velocity on x-axis relative to the sun in m/s
    double vyearth = -20.07241E3; // INITIAL velocity on y-axis relative to the sun in m/s
    

////////////////////////MOON?- SOON //////////////////////////////////////////


////////////////////////Mars Data/////////////////////////////////////////////   
   
    double mmars = 6.4169E23; //mass ofMars in kg
    double xmars = -1.0072218E3*AU; // INITIAL distance on x-axis from the sun in m
    double ymars = -1.1814551E3*AU; // INITIAL distance on y-axis from the sun in m
    double vxmars = 19.34207E3; // INITIAL  velocity on x-axis relative to the sun in m/s
    double vymars = -13.63487E3; // INITIAL velocity on y-axis relative to the sun in m/s

////////////////////////1 Ceres Data/////////////////////////////////////////////   
   
    double mceres = 9.47E20; //mass of 1-Ceres in kg
    double xceres = 1.3031563E3*AU; // INITIAL distance on x-axis from the sun in m
    double yceres = -2.26069823E3*AU; // INITIAL distance on y-axis from the sun in m
    double vxceres = 15.16524E3; // INITIAL  velocity on x-axis relative to the sun in m/s
    double vyceres = 5.35596E3; // INITIAL velocity on y-axis relative to the sun in m/s
   
////////////////////////2 Pallas Data/////////////////////////////////////////////   
   
    double mpallas = 2.11E20; //mass of 2-Pallas in kg (data from google)
    double xpallas = -0.3388292E3*AU; // INITIAL distance on x-axis from the sun in m
    double ypallas = -2.5888546E3*AU; // INITIAL distance on y-axis from the sun in m
    double vxpallas = 14.75699E3; // INITIAL  velocity on x-axis relative to the sun in m/s
    double vypallas = -3.13607E3; // INITIAL velocity on y-axis relative to the sun in m/s

////////////////////////3 Juno Data/////////////////////////////////////////////   
   
    double mjuno = 2.67E19; //mass of 3-Juno in kg (data from google)
    double xjuno = -2.9174132E3*AU; // INITIAL distance on x-axis from the sun in m
    double yjuno = -0.1571614E3*AU; // INITIAL distance on y-axis from the sun in m
    double vxjuno = -2.93902E3; // INITIAL  velocity on x-axis relative to the sun in m/s
    double vyjuno = -13.07529E3; // INITIAL velocity on y-axis relative to the sun in m/s
               
////////////////////////Jupiter Data/////////////////////////////////////////   
   
    double mjupiter = 1.8981E27; //mass of Jupiter in kg
    double xjupiter = 0.7841558E3*AU; // INITIAL distance on x-axis from the sun in m
    double yjupiter = -5.1568154E3*AU; // INITIAL distance on y-axis from the sun in m
    double vxjupiter = 12.76972E3; // INITIAL  velocity on x-axis relative to the sun in m/s
    double vyjupiter = 2.58312E3; // INITIAL velocity on y-axis relative to the sun in m/s
    
////////////////////////Saturn Data/////////////////////////////////////////   
   
    double msaturn = 5.6832E26; //mass of Saturn in kg
    double xsaturn = 3.9946564E3*AU; // INITIAL distance on x-axis from the sun in m
    double ysaturn = -9.2013962E3*AU; // INITIAL distance on y-axis from the sun in m
    double vxsaturn = 8.33991E3; // INITIAL  velocity on x-axis relative to the sun in m/s
    double vysaturn = 3.81962E3; // INITIAL velocity on y-axis relative to the sun in m/s
    
////////////////////////Uranus Data/////////////////////////////////////////   
   
    double muranus = 8.6810E25; //mass of Uranus in kg
    double xuranus = 16.0971228E3*AU; // INITIAL distance on x-axis from the sun in m
    double yuranus = 11.5532974E3*AU; // INITIAL distance on y-axis from the sun in m
    double vxuranus = -4.00721E3; // INITIAL  velocity on x-axis relative to the sun in m/s
    double vyuranus = 5.21728E3; // INITIAL velocity on y-axis relative to the sun in m/s

////////////////////////Neptune Data/////////////////////////////////////////   
   
    double mneptune = 1.0241E26; //mass of Neptune in kg
    double xneptune = 29.2936390E3*AU; // INITIAL distance on x-axis from the sun in m
    double yneptune = -6.1266735E3*AU; // INITIAL distance on y-axis from the sun in m
    double vxneptune = 1.08974E3; // INITIAL  velocity on x-axis relative to the sun in m/s
    double vyneptune = 5.35655E3; // INITIAL velocity on y-axis relative to the sun in m/s

////////////////////////Pluto Data/////////////////////////////////////////   
   
    double mpluto = 1.3090E22; //mass of Pluto in kg
    double xpluto = 13.2237527E3*AU; // INITIAL distance on x-axis from the sun in m
    double ypluto = -31.2887513E3*AU; // INITIAL distance on y-axis from the sun in m
    double vxpluto = 5.15046E3; // INITIAL  velocity on x-axis relative to the sun in m/s
    double vypluto = 0.96292E3; // INITIAL velocity on y-axis relative to the sun in m/s



/////////////////////////////////////////////////////////////////////////////                                
///////////////////////    Solar Sail Parameters    /////////////////////////
/////////////////////////////////////////////////////////////////////////////



    double epsilon = 0.9; // Reflectivity of the Sun as a percentage turned into decimal (where 1 would be 100% reflection, 0.5 would be 50%, etc.)
    double msail = 1; // mass of the solar sail in Kg
    // double absorption = (1. - epsilon); // the absorption rate of the incident light - Probably not important
    // double reflection = (1. + epsilon); // the reflection rate of the incident light - Probably not important
    double area = 1000000; // Is the total surface area of the sail in m^2
    double angleearth = Math.atan(yearth/xearth); // Angle from x-axis to earth
    double heightsail = 9000E3; // height in m from sirface of Earth when program begins
    double xsail = xearth + Math.cos(angleearth)*heightsail; // INITIAL distance on x-axis from the sun in m starts in opposition
    double ysail = yearth + Math.sin(angleearth)*heightsail; // INITIAL distance on y-axis from the sun in m starts in opposition
    double vescape = Math.sqrt(2.*g*mearth/heightsail); // escape velocity at height "heightsail"
    double vxsail = vxearth + vescape*Math.cos(angleearth); // INITIAL  velocity on x-axis relative to the sun in m/s including escape velocity relative to earth
    double vysail = vyearth + vescape*Math.sin(angleearth); // INITIAL velocity on y-axis relative to the sun in m/s including escape velocity relative to earth
    
  
   
  }
}