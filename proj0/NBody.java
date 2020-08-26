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

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] totalPlanets = readPlanets(filename);
        
        //first draw the background 
        String imageToDraw = "images/starfield.jpg";
        StdDraw.setScale(-radius, radius);
        StdDraw.picture(T, dt, imageToDraw);
        StdDraw.picture(0, 0, imageToDraw);

        //draw the planets
        for(Planet p : totalPlanets) {
            p.draw();
        }


    } 
}