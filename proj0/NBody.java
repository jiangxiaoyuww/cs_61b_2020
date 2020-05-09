public class NBody{

    public static double readRadius(String filename) {
        In in = new In(filename);
        int n = in.readInt();
        double radius = in.readDouble();
        return radius;
    }


    public static Body[] readBodies(String filename) {
        In in = new In(filename);
        int n = in.readInt();
        double radius = in.readDouble();
        Body[] bodies = new Body[n];
        for (int i = 0; i < n; i++){
            bodies[i] = new Body(in.readDouble(), in.readDouble(),
                    in.readDouble(), in.readDouble(),
                    in.readDouble(), in.readString());
        }
        return bodies;
    }


    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        double time = 0;
        Body[] bodies = readBodies(filename);
        int n = bodies.length;
        while (time <= T) {
            double[] xForces = new double[n];
            double[] yForces = new double[n];
            for (int i = 0; i < bodies.length; i++) {
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
            }
            for (int i = 0; i < bodies.length; i++) {
                bodies[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.enableDoubleBuffering();
            StdDraw.setScale(-radius, radius);
            StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg", 2*radius, 2*radius);
            for (int i = 0; i < bodies.length; i ++){
                bodies[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }

        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                    bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
        }

    }
}