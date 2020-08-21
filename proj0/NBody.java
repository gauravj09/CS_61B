public class NBody {
    public static double readRadius(String filePath) {
        In inputFile = new In(filePath);
        inputFile.readInt();

        double radius = inputFile.readDouble(); 

        return radius;
    }

    public static Planet[] readPlanets(String filePath) {
        In inputFile = new In(filePath);
        Planet[] planets = new Planet[5];

        inputFile.readInt();
        inputFile.readDouble();
        
        int index = 0;

        while(index < 5) {

            double xxPositionString = inputFile.readDouble();
            double yyPositionString = inputFile.readDouble();
            double xxVelocityString = inputFile.readDouble();
            double yyVelocityString = inputFile.readDouble();
            double mass = inputFile.readDouble();
            String image = inputFile.readString();
            planets[index] = new Planet(xxPositionString, yyPositionString, 
                                    xxVelocityString, yyVelocityString, 
                                    mass, image);

            index++;
        }

        return planets;
    }
}