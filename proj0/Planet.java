public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    
    public Planet(double xP, double yP, double xV, 
                    double yV, double m, String img) {

        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double xxDistance = this.xxPos - p.xxPos;
        double yyDistance = this.yyPos - p.yyPos; 
        double rrDistance = (xxDistance * xxDistance) + (yyDistance * yyDistance);
        
        return Math.sqrt(rrDistance);
    }

    public double calcForceExertedBy(Planet p) {
        double distance = calcDistance(p);
        double G_Constant = 6.67e-11;
        double forceExerted = (G_Constant * this.mass * p.mass)/(distance*distance);

        return forceExerted;
    }

    public double calcForceExertedByX(Planet p) {
        double forceExerted = calcForceExertedBy(p);
        double distanceBetweenPlanets = p.xxPos - this.xxPos;
        double forceExertedX = (forceExerted * distanceBetweenPlanets)/calcDistance(p);

        return forceExertedX; 
    } 

    public double calcForceExertedByY(Planet p) {
        double forceExerted = calcForceExertedBy(p);
        double distanceBetweenPlanets = p.yyPos - this.yyPos;
        double forceExertedY = (forceExerted * distanceBetweenPlanets)/calcDistance(p);

        return forceExertedY; 
    }

    public double calcNetForceExertedByX(Planet[] multiplePlanets) {
        double multipleNetForcesExertedByX = 0;

        for(Planet p : multiplePlanets) {
            if(p.equals(this)) {
                continue;
            }

            multipleNetForcesExertedByX += calcForceExertedByX(p);   
        }

        return multipleNetForcesExertedByX;
    }

    public double calcNetForceExertedByY(Planet[] multiplePlanets) {
        double multipleNetForcesExertedByY = 0;

        for(Planet p : multiplePlanets) {
            if(p.equals(this)) {
                continue;
            }

            multipleNetForcesExertedByY += calcForceExertedByY(p);   
        }

        return multipleNetForcesExertedByY;
    }

    public void update(double time, double xForce, double yForce) {
        double accelerationX = xForce/this.mass;
        double accelerationY = yForce/this.mass;
        
        this.xxVel = this.xxVel + time * accelerationX;
        this.yyVel = this.yyVel + time * accelerationY;
        
        this.xxPos = this.xxPos + time * this.xxVel;
        this.yyPos = this.yyPos + time * this.yyVel;

    }

    public void draw() {
        String planetImage = "images/"  + imgFileName;
        StdDraw.picture(this.xxPos, this.yyPos, planetImage);
    
    }

}