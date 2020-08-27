import java.sql.Time;

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
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);

        double time = 0;

        while(time < T) {
            double[] xForces = new double[totalPlanets.length];
            double[] yForces = new double[totalPlanets.length];
            
            for (int i = 0; i < totalPlanets.length; i++) {
                xForces[i] = totalPlanets[i].calcNetForceExertedByX(totalPlanets);
                yForces[i] = totalPlanets[i].calcNetForceExertedByY(totalPlanets);
            }

            for (int i = 0; i < totalPlanets.length; i++) {
                totalPlanets[i].update(time, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, imageToDraw);

            for(Planet p : totalPlanets) {
                p.draw();
            }
            
            StdDraw.show(); 
            StdDraw.pause(10);

            time += dt;
        }

        StdOut.printf("%d\n", totalPlanets.length);
        StdOut.printf("%.2e\n", radius);

        for (int i = 0; i < totalPlanets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            totalPlanets[i].xxPos, totalPlanets[i].yyPos, totalPlanets[i].xxVel,
            totalPlanets[i].yyVel, totalPlanets[i].mass, totalPlanets[i].imgFileName);   
        }
    } 
}