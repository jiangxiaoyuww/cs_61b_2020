import java.lang.*;
public class Body {
    final static double G = 6.67e-11;
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Body(double xP, double yP, double xV,
                double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b) {
        this(b.xxPos, b.yyPos, b.xxVel, b.yyVel,
                b.mass, b.imgFileName);
    }


    public double calcDistance(Body b){
        return Math.sqrt(Math.pow(this.xxPos - b.xxPos, 2) + Math.pow(this.yyPos - b.yyPos, 2));
    }

    public double calcForceExertedBy(Body b){
        double dis = Math.pow(this.calcDistance(b), 2);
        return Body.G * this.mass * b.mass / dis;
    }

    public double calcForceExertedByX(Body b){
        double force = this.calcForceExertedBy(b);
        double dis = this.calcDistance(b);
        return force * (b.xxPos - this.xxPos) / dis;
    }

    public double calcForceExertedByY(Body b){
        double force = this.calcForceExertedBy(b);
        double dis = this.calcDistance(b);
        return force * (b.yyPos - this.yyPos) / dis;
    }

    public double calcNetForceExertedByX(Body[] bodies){
        double xforce = 0;
        for (Body i: bodies) {
            if (!(this.equals(i))) {
                xforce += this.calcForceExertedByX(i);
            }
        }
        return xforce;
    }


    public double calcNetForceExertedByY(Body[] bodies){
        double yforce = 0;
        for (Body i: bodies) {
            if (!(this.equals(i))) {
                yforce += this.calcForceExertedByY(i);
            }
        }
        return yforce;
    }


    public void update(double dt, double fX, double fY){
        double ax = fX / this.mass;
        double ay = fY / this.mass;
        this.xxVel += ax * dt;
        this.yyVel += ay * dt;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}
