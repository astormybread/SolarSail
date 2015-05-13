
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

//String[] celestialbodynames = {"sun","mercury","venus","earth","mars","ceres","pallas","juno","jupiter","saturn","uranus","neptune","pluto"};


    CelestialBody sun = new CelestialBody("sun");
    CelestialBody mercury = new CelestialBody("mercury");
    CelestialBody venus = new CelestialBody("venus");
    CelestialBody earth = new CelestialBody("earth");
    CelestialBody mars = new CelestialBody("mars");
    CelestialBody ceres = new CelestialBody("ceres");
    CelestialBody pallas = new CelestialBody("pallas");
    CelestialBody juno = new CelestialBody("juno");
    CelestialBody jupiter = new CelestialBody("jupiter");
    CelestialBody saturn = new CelestialBody("saturn");
    CelestialBody uranus = new CelestialBody("uranus");
    CelestialBody neptune = new CelestialBody("neptune");
    CelestialBody pluto = new CelestialBody("pluto");


///////////////////////////Sun Data//////////////////////////////////////////

    sun.setm(1.98855E30); // mass of the Sun in kg
   double sunr = 695800000.; // Radius of the sun in meters
   double sunt = 5778.; // Surface Temperature in Kelvins of the Sun
    sun.setx(0.0); // X-cooridinate of the Sun
    sun.sety(0.0); // Y-coordinate of the sun
////////////////////////Mercury Data//////////////////////////////////////////

    mercury.setm(3.3010E23); // mass of Mercury in kg
    mercury.setx(0.3287109E3*AU); // INITIAL distance on x-axis from the sun in m
    mercury.sety(0.0830574E3*AU); // INITIAL distance on y-axis from the sun in m
     mercury.setvx(-21.46433E3); // INITIAL  velocity on x-axis relative to the sun in m/s
     mercury.setvy(49.33479E3); // INITIAL velocity on y-axis relative to the sun in m/s

////////////////////////Venus Data//////////////////////////////////////////

    venus.setm(4.8673E24); // mass of Mercury in kg
    venus.setx(0.4175777E3*AU); // INITIAL distance on x-axis from the sun in m
    venus.sety(0.5890271E3*AU); // INITIAL distance on y-axis from the sun in m
     venus.setvx(-28.69043E3); // INITIAL  velocity on x-axis relative to the sun in m/s
     venus.setvy(20.08491E3); // INITIAL velocity on y-axis relative to the sun in m/s


////////////////////////Earth Data////////////////////////////////////////////

    earth.setm(5.9722E24); //mass of the Earth in kg
    earth.setx(-0.6595378E3*AU); // INITIAL distance on x-axis from the sun in m
    earth.sety(0.7319421E3*AU); // INITIAL distance on y-axis from the sun in m
     earth.setvx(-22.60193E3); // INITIAL  velocity on x-axis relative to the sun in m/s
     earth.setvy(-20.07241E3); // INITIAL velocity on y-axis relative to the sun in m/s


////////////////////////MOON?- SOON //////////////////////////////////////////


////////////////////////Mars Data/////////////////////////////////////////////

    mars.setm(6.4169E23); //mass ofMars in kg
    mars.setx(-1.0072218E3*AU); // INITIAL distance on x-axis from the sun in m
    mars.sety(-1.1814551E3*AU); // INITIAL distance on y-axis from the sun in m
     mars.setvx(19.34207E3); // INITIAL  velocity on x-axis relative to the sun in m/s
     mars.setvy(-13.63487E3); // INITIAL velocity on y-axis relative to the sun in m/s

////////////////////////1 Ceres Data/////////////////////////////////////////////

    ceres.setm(9.47E20); //mass of 1-Ceres in kg
    ceres.setx(1.3031563E3*AU); // INITIAL distance on x-axis from the sun in m
    ceres.sety(-2.26069823E3*AU); // INITIAL distance on y-axis from the sun in m
     ceres.setvx(15.16524E3); // INITIAL  velocity on x-axis relative to the sun in m/s
     ceres.setvy(5.35596E3); // INITIAL velocity on y-axis relative to the sun in m/s

////////////////////////2 Pallas Data/////////////////////////////////////////////

    pallas.setm(2.11E20); //mass of 2-Pallas in kg (data from google)
    pallas.setx(-0.3388292E3*AU); // INITIAL distance on x-axis from the sun in m
    pallas.sety(-2.5888546E3*AU); // INITIAL distance on y-axis from the sun in m
     pallas.setvx(14.75699E3); // INITIAL  velocity on x-axis relative to the sun in m/s
     pallas.setvy(-3.13607E3); // INITIAL velocity on y-axis relative to the sun in m/s

////////////////////////3 Juno Data/////////////////////////////////////////////

    juno.setm(2.67E19); //mass of 3-Juno in kg (data from google)
    juno.setx(-2.9174132E3*AU); // INITIAL distance on x-axis from the sun in m
    juno.sety(-0.1571614E3*AU); // INITIAL distance on y-axis from the sun in m
     juno.setvx(-2.93902E3); // INITIAL  velocity on x-axis relative to the sun in m/s
     juno.setvy(-13.07529E3); // INITIAL velocity on y-axis relative to the sun in m/s

////////////////////////Jupiter Data/////////////////////////////////////////

    jupiter.setm(1.8981E27); //mass of Jupiter in kg
    jupiter.setx(0.7841558E3*AU); // INITIAL distance on x-axis from the sun in m
    jupiter.sety(-5.1568154E3*AU); // INITIAL distance on y-axis from the sun in m
     jupiter.setvx(12.76972E3); // INITIAL  velocity on x-axis relative to the sun in m/s
     jupiter.setvy(2.58312E3); // INITIAL velocity on y-axis relative to the sun in m/s

////////////////////////Saturn Data/////////////////////////////////////////

    saturn.setm(5.6832E26); //mass of Saturn in kg
    saturn.setx(3.9946564E3*AU); // INITIAL distance on x-axis from the sun in m
    saturn.sety(-9.2013962E3*AU); // INITIAL distance on y-axis from the sun in m
     saturn.setvx(8.33991E3); // INITIAL  velocity on x-axis relative to the sun in m/s
     saturn.setvy(3.81962E3); // INITIAL velocity on y-axis relative to the sun in m/s

////////////////////////Uranus Data/////////////////////////////////////////

    uranus.setm(8.6810E25); //mass of Uranus in kg
    uranus.setx(16.0971228E3*AU); // INITIAL distance on x-axis from the sun in m
    uranus.sety(11.5532974E3*AU); // INITIAL distance on y-axis from the sun in m
     uranus.setvx(-4.00721E3); // INITIAL  velocity on x-axis relative to the sun in m/s
     uranus.setvy(5.21728E3); // INITIAL velocity on y-axis relative to the sun in m/s

////////////////////////Neptune Data/////////////////////////////////////////

     neptune.setm(1.0241E26); //mass of Neptune in kg
     neptune.setx(29.2936390E3*AU); // INITIAL distance on x-axis from the sun in m
     neptune.sety(-6.1266735E3*AU); // INITIAL distance on y-axis from the sun in m
     neptune.setvx(1.08974E3); // INITIAL  velocity on x-axis relative to the sun in m/s
     neptune.setvy(5.35655E3); // INITIAL velocity on y-axis relative to the sun in m/s

////////////////////////Pluto Data/////////////////////////////////////////

     pluto.setm(1.3090E22); //mass of Pluto in kg
     pluto.setx(13.2237527E3*AU); // INITIAL distance on x-axis from the sun in m
     pluto.sety(-31.2887513E3*AU); // INITIAL distance on y-axis from the sun in m
     pluto.setvx(5.15046E3); // INITIAL  velocity on x-axis relative to the sun in m/s
     pluto.setvy(0.96292E3); // INITIAL velocity on y-axis relative to the sun in m/s



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