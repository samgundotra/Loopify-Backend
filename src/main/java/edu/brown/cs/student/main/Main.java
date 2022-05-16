package edu.brown.cs.student.main;

import edu.brown.cs.student.main.backendHandlers.*;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import spark.Spark;

import java.io.IOException;

/**
 * The Main class of our project. This is where execution begins.
 */

public final class Main {

  private static final int DEFAULT_PORT = 4567;

  /**
   * The initial method called when execution begins.
   *
   * @param args An array of command line arguments
   */
  public static void main(String[] args) {
    new Main(args).run();
  }

  private String[] args;

  private Main(String[] args) {
    this.args = args;
  }

  private void run() {

//    OptionParser parser = new OptionParser();
//    parser.accepts("gui");
//    parser.accepts("port").withRequiredArg().ofType(Integer.class).defaultsTo(DEFAULT_PORT);
//
//    OptionSet options = parser.parse(args);
//
//    if (options.has("gui")) {
//      runSparkServer((int) options.valueOf("port"));
//    }
    runSparkServer(getHerokuAssignedPort());

//    Repl myRepl = new Repl();
//    try {
//      myRepl.setUpRepl();
//    } catch (IOException e) {
//      e.printStackTrace();
//    }

  }

  /**
   * This method runs the spark server to listen for requests to the endpoints specified.
   *
   * @param port to run server on
   */
  private void runSparkServer(int port) {
    Spark.port(port);
    Spark.externalStaticFileLocation("src/main/resources/static");

    Spark.options("/*", (request, response) -> {
      String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
      if (accessControlRequestHeaders != null) {
        response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
      }

      String accessControlRequestMethod = request.headers("Access-Control-Request-Method");

      if (accessControlRequestMethod != null) {
        response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
      }

      return "OK";
    });

    Spark.before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

    // Put Routes Here
    Spark.post("/getRoute", new GetRouteHandler());
    Spark.init();
  }

  static int getHerokuAssignedPort() {
    ProcessBuilder processBuilder = new ProcessBuilder();
    if (processBuilder.environment().get("PORT") != null) {
      return Integer.parseInt(processBuilder.environment().get("PORT"));
    }
    return DEFAULT_PORT;
  }
}
