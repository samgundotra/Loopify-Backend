package edu.brown.cs.student.main.RouteFinder;

import edu.brown.cs.student.main.routefindermaps.Node;
import edu.brown.cs.student.main.routefindermaps.NodeGrid;
import edu.brown.cs.student.main.routefindermaps.RouteFinder;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Testing the route finder class.
 */
public class RouteFinderTest {
    /**
     * Tests that a route can be found for a route of distance 1 mile.
     */
    @Test
    public void routeTest1mile() {
        RouteFinder routeFinder = new RouteFinder(41.82690997456079, -71.40016570863611, 1);
        List<Node> route = routeFinder.findRoute();
        Assert.assertEquals(4, route.size());
    }

    /**
     * Tests that a route can be found for a route of distance 5 miles.
     */
    @Test
    public void routeTest5mile() {
        RouteFinder routeFinder = new RouteFinder(41.82690997456079, -71.40016570863611, 5);
        routeFinder.findRoute();
        Assert.assertTrue(4.5 < routeFinder.getPathDistance() && routeFinder.getPathDistance() < 5.5);
    }

    /**
     * Tests that a route can be found for a route of distance 20 miles.
     */
    @Test
    public void routeTest20mile(){
        RouteFinder routeFinder = new RouteFinder(41.82690997456079, -71.40016570863611, 22);
        routeFinder.findRoute();
        Assert.assertTrue(20 < routeFinder.getPathDistance() && routeFinder.getPathDistance() < 24);
    }

    /**
     * Tests that multiple different 1 mile routes can be generated
     */
    @Test
    public void multiple1mileRoutes() {
        RouteFinder routeFinder = new RouteFinder(41.82690997456079, -71.40016570863611, 1);
        List<Node> route1 = routeFinder.findRoute();
        double dist1 = routeFinder.getPathDistance();
        List<Node> route2 = routeFinder.findRoute();
        double dist2 = routeFinder.getPathDistance();
        List<Node> route3 = routeFinder.findRoute();
        double dist3 = routeFinder.getPathDistance();
        List<Node> route4 = routeFinder.findRoute();
        double dist4 = routeFinder.getPathDistance();
        List<Node> route5 = routeFinder.findRoute();
        double dist5 = routeFinder.getPathDistance();
        Assert.assertTrue(dist1 < dist2);
        Assert.assertTrue(dist2 < dist3);
        Assert.assertTrue(dist3 < dist4);
        Assert.assertTrue(dist4 < dist5);
    }

    /**
     * Tests that multiple different 5 mile routes can be generated
     */
    @Test
    public void multiple5mileRoutes() {
        RouteFinder routeFinder = new RouteFinder(41.82690997456079, -71.40016570863611, 5);
        List<Node> route1 = routeFinder.findRoute();
        double dist1 = routeFinder.getPathDistance();
        List<Node> route2 = routeFinder.findRoute();
        double dist2 = routeFinder.getPathDistance();
        List<Node> route3 = routeFinder.findRoute();
        double dist3 = routeFinder.getPathDistance();
        List<Node> route4 = routeFinder.findRoute();
        double dist4 = routeFinder.getPathDistance();
        List<Node> route5 = routeFinder.findRoute();
        double dist5 = routeFinder.getPathDistance();
        Assert.assertTrue(dist1 < dist2);
        Assert.assertTrue(dist2 < dist3);
        Assert.assertTrue(dist3 < dist4);
        Assert.assertTrue(dist4 < dist5);
    }

    /**
     * Tests that multiple different 10 mile routes can be generated
     */
    @Test
    public void multiple10mileRoutes() {
        RouteFinder routeFinder = new RouteFinder(41.82690997456079, -71.40016570863611, 10);
        List<Node> route1 = routeFinder.findRoute();
        double dist1 = routeFinder.getPathDistance();
        List<Node> route2 = routeFinder.findRoute();
        double dist2 = routeFinder.getPathDistance();
        List<Node> route3 = routeFinder.findRoute();
        double dist3 = routeFinder.getPathDistance();
        List<Node> route4 = routeFinder.findRoute();
        double dist4 = routeFinder.getPathDistance();
        List<Node> route5 = routeFinder.findRoute();
        double dist5 = routeFinder.getPathDistance();
        Assert.assertTrue(dist1 < dist2);
        Assert.assertTrue(dist2 < dist3);
        Assert.assertTrue(dist3 < dist4);
        Assert.assertTrue(dist4 < dist5);
    }
}
